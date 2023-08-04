/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.ch.camel.chpharm5.requests;

import ca.uhn.fhir.rest.param.*;
import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.jetbrains.annotations.Contract;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.projecthusky.communication.ch.camel.chpharm1.requests.ChQueryRegistry;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.*;
import org.projecthusky.communication.ch.camel.chpharm5.ChPharm5Operations;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter of {@link ChPharm5SearchParameters} (CH:PHARM-5) to {@link ChQueryRegistry} (CH:PHARM-1).
 *
 * @author Quentin Ligier
 * @author Oliver Egger
 **/
public class ChPharm5RequestConverter {

    /**
     * Validates a PHARM-5 request, throwing an {@link UnprocessableEntityException} on validation failure
     */
    public ChQueryRegistry requestConverter(final ChPharm5SearchParameters searchParameters) {
        ensureNotNull(searchParameters.getPatientIdentifier(), "patient.identifier", searchParameters.getOperation());
        ensureNotNull(searchParameters.getPatientIdentifier().getValue(), "patient.identifier[value]",
                      searchParameters.getOperation());
        ensureNotNull(searchParameters.getPatientIdentifier().getSystem(), "patient.identifier[system]",
                      searchParameters.getOperation());

        ensureNotNull(searchParameters.getStatus(), "status", searchParameters.getOperation());

        searchParameters.getStatus().getValuesAsQueryTokens().stream()
                .filter(t -> !"current".equals(t.getValue()) && !"superseded".equals(t.getValue()))
                .findAny()
                .ifPresent(t -> {
                    throw invalidRequestException(
                            OperationOutcome.IssueType.CODEINVALID,
                            "In CH:PHARM-5 %s operation, the 'status' value '%s' is invalid ('current' or " +
                                    "'superseded' expected)",
                            searchParameters.getOperation().getOperation(),
                            t.getValue()
                    );
                });

        final var searchRegistry = new ChQueryRegistry();
        searchRegistry.setReturnType(QueryReturnType.LEAF_CLASS);

        final ChPharmacyDocumentsQuery query = switch (searchParameters.getOperation()) {
            case FIND_DISPENSES -> new ChFindDispensesQuery();
            case FIND_PRESCRIPTIONS -> new ChFindPrescriptionsQuery();
            case FIND_MEDICATION_ADMINISTRATIONS -> new ChFindMedicationAdministrationsQuery();
            case FIND_MEDICATION_TREATMENT_PLANS -> new ChFindMedicationTreatmentPlansQuery();
            case FIND_PRESCRIPTIONS_FOR_DISPENSE -> new ChFindPrescriptionsForDispenseQuery();
            case FIND_PRESCRIPTIONS_FOR_VALIDATION -> new ChFindPrescriptionsForValidationQuery();
            case FIND_MEDICATION_CARD -> new ChFindMedicationCardQuery();
            case FIND_MEDICATION_LIST -> new ChFindMedicationListQuery();
        };

        // homeCommunityId: not present in MHD

        // patientId
        query.setPatientId(new Identifiable(
                searchParameters.getPatientIdentifier().getValueNotNull(),
                new AssigningAuthority(searchParameters.getPatientIdentifier().getSystem())
        ));

        // status
        if (searchParameters.getStatus() != null) {
            query.setStatus(new ArrayList<>(searchParameters.getStatus().size()));
            for (final TokenParam token : searchParameters.getStatus().getValuesAsQueryTokens()) {
                query.getStatus().add(switch (token.getValue()) {
                    case "current" -> AvailabilityStatus.APPROVED;
                    case "superseded" -> AvailabilityStatus.DEPRECATED;
                    default -> throw new IllegalStateException(String.format("Unsupported status '%s'",
                                                               token.getValue()));
                });
            }
        }

        // metadataLevel: we don't set it

        // formatCodes
        if (searchParameters.getFormat() != null) {
            query.setFormatCodes(this.convertTokensToCode(searchParameters.getFormat()));
        }

        // extraParameters: nothing to add

        if (query instanceof final ChPharmacyStableDocumentsQuery stableQuery) {
            // creationTime
            if (searchParameters.getCreation() != null) {
                this.convertDateRangeAndSetTimeRange(searchParameters.getCreation(), stableQuery.getCreationTime());
            }

            // serviceStartTime TODO: how to map?

            // serviceStopTime TODO: how to map?

            // uuids TODO: how to map?

            // uniqueIds TODO: how to map?

            // practiceSettingCodes
            if (searchParameters.getSetting() != null) {
                stableQuery.setPracticeSettingCodes(this.convertTokensToCode(searchParameters.getSetting()));
            }

            // healthcareFacilityTypeCodes
            if (searchParameters.getFacility() != null) {
                stableQuery.setHealthcareFacilityTypeCodes(this.convertTokensToCode(searchParameters.getFacility()));
            }

            // eventCodes
            if (searchParameters.getEvent() != null) {
                stableQuery.setEventCodes(this.convertTokensToCode(searchParameters.getEvent()));
            }

            // confidentialityCodes
            if (searchParameters.getSecurityLabel() != null) {
                stableQuery.setConfidentialityCodes(this.convertTokensToCode(searchParameters.getSecurityLabel()));
            }

            // authorPersons
            if (searchParameters.getAuthorFamilyName() != null) {
                if (stableQuery.getAuthorPersons() == null) {
                    stableQuery.setAuthorPersons(new ArrayList<>(1));
                }
                stableQuery.getAuthorPersons().add(searchParameters.getAuthorFamilyName().getValueNotNull());
            }
            if (searchParameters.getAuthorGivenName() != null) {
                if (stableQuery.getAuthorPersons() == null) {
                    stableQuery.setAuthorPersons(new ArrayList<>(1));
                }
                stableQuery.getAuthorPersons().add(searchParameters.getAuthorGivenName().getValueNotNull());
            }

        } else if (query instanceof final ChFindMedicationCardQuery pmlcQuery && searchParameters.getLanguage() != null) {
            pmlcQuery.setLanguageCode(searchParameters.getLanguage().getValueNotNull());
        }

        return searchRegistry;
    }

    @Contract("null,_,_->fail")
    void ensureNotNull(final @Nullable Object parameter,
                       final String parameterName,
                       final ChPharm5Operations operation) {
        if (parameter == null) {
            throw invalidRequestException(
                    OperationOutcome.IssueType.REQUIRED,
                    "In CH:PHARM-5 %s operation, the parameter '%s' shall be set",
                    operation.getOperation(),
                    parameterName
            );
        }
    }

    InvalidRequestException invalidRequestException(final OperationOutcome.IssueType type,
                                                    final String message,
                                                    final Object... args) {
        final var msg = String.format(message, args);
        final var operationOutcome = new OperationOutcome();
        operationOutcome.addIssue()
                .setSeverity(OperationOutcome.IssueSeverity.ERROR)
                .setCode(type)
                .setDiagnostics(msg);

        final var exception = new InvalidRequestException(msg);
        exception.setOperationOutcome(operationOutcome);
        return exception;
    }

    void convertDateRangeAndSetTimeRange(final DateRangeParam source,
                                         final TimeRange destination) {
        final DateParam lowerBound = source.getLowerBound();
        final DateParam upperBound = source.getUpperBound();
        if (lowerBound != null) {
            if (lowerBound.getPrefix() != ParamPrefixEnum.GREATERTHAN_OR_EQUALS) {
                throw new IllegalArgumentException("The date lower bound shall have prefix 'ge'");
            }
            destination.setFrom(lowerBound.getValueAsString());
        }
        if (upperBound != null) {
            if (upperBound.getPrefix() != ParamPrefixEnum.GREATERTHAN_OR_EQUALS) {
                throw new IllegalArgumentException("The date upper bound shall have prefix 'lt'");
            }
            destination.setTo(upperBound.getValueAsString());
        }
    }

    List<Code> convertTokensToCode(final TokenOrListParam tokens) {
        final var codes = new ArrayList<Code>(tokens.size());
        for (final TokenParam token : tokens.getValuesAsQueryTokens()) {
            codes.add(this.convertTokenToCode(token));
        }
        return codes;
    }

    Code convertTokenToCode(final TokenParam token) {
        return new Code(
                token.getValueNotNull(),
                null,
                token.getSystem()
        );
    }
}
