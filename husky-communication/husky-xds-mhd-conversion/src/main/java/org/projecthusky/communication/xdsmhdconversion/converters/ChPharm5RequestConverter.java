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
package org.projecthusky.communication.xdsmhdconversion.converters;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.TokenOrListParam;
import ca.uhn.fhir.rest.param.TokenParam;
import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5SearchParameters;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.common.utils.time.DateTimes;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.*;
import org.projecthusky.communication.ch.camel.chpharm5.ChPharm5Operations;
import org.projecthusky.communication.ch.camel.chpharm5.requests.ChPharm5FindMedicationCardSearchParameters;
import org.projecthusky.communication.xdsmhdconversion.model.XdsTimeRange;
import org.projecthusky.communication.xdsmhdconversion.utils.FindQueryUtils;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Converter of {@link Pharm5SearchParameters} to {@link ChPharmacyDocumentsQuery}.
 *
 * @author Quentin Ligier
 * @author Oliver Egger
 * @author Daniel Vazquez Rivera
 * @see <a href="https://github.com/i4mi/MobileAccessGateway/blob/1f99e596e80cc03a81cf08634be3b996b7d918f2/src/main/java/ch/bfh/ti/i4mi/mag/mhd/pharm5/Pharm5RequestConverter.java">Pharm5RequestConverter</a>
 **/
public class ChPharm5RequestConverter {
    /**
     * Converts a PHARM-5 parameters object to a {@link ChPharmacyDocumentsQuery}.
     *
     * NOTE: CH EPR FHIR specifies that MHD transactions must use the EPR-SPID as patient.identifier, while for the XDS
     * transactions, the XAD-PID must be used. This converter does not perform any check on the patient.identifier
     * system and will be set as-is, any further checks and transformations should be done by the caller as
     * post-converter-processing.
     * <p>
     * NOTE: identifier param is ignored
     * </p>
     *
     * @param searchParameters The PHARM-5 search parameters.
     * @return The <i>equivalent</i> {@link ChPharmacyDocumentsQuery}.
     */
    public static ChPharmacyDocumentsQuery toChPharmacyDocumentsQuery(final Pharm5SearchParameters searchParameters) throws InvalidRequestException {
        Objects.requireNonNull(searchParameters);
        if (searchParameters instanceof ChPharm5FindMedicationCardSearchParameters findCardParams)
            return toChPharmacyDocumentsQuery(findCardParams);
        final var operation = Objects.requireNonNull(searchParameters.getOperation());
        return switch(operation) {
            case FIND_MEDICATION_TREATMENT_PLANS -> convertStableQuery(new ChFindMedicationTreatmentPlansQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
            case FIND_PRESCRIPTIONS -> convertStableQuery(new ChFindPrescriptionsQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
            case FIND_DISPENSES -> convertStableQuery(new ChFindDispensesQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
            case FIND_PRESCRIPTIONS_FOR_VALIDATION -> convertStableQuery(new ChFindPrescriptionsForValidationQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
            case FIND_PRESCRIPTIONS_FOR_DISPENSE -> convertStableQuery(new ChFindPrescriptionsForDispenseQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
            case FIND_MEDICATION_ADMINISTRATIONS -> convertStableQuery(new ChFindMedicationAdministrationsQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
            case FIND_MEDICATION_LIST -> convertMedicationListQuery(new ChFindMedicationListQuery(), searchParameters, ChPharm5Operations.fromPharm5Operation(operation));
        };
    }

    /**
     * Converts a {@link ChPharm5FindMedicationCardSearchParameters} parameters object to a {@link ChPharmacyDocumentsQuery}.
     *
     * NOTE: CH EPR FHIR specifies that MHD transactions must use the EPR-SPID as patient.identifier, while for the XDS
     * transactions, the XAD-PID must be used. This converter does not perform any check on the patient.identifier
     * system and will be set as-is, any further checks and transformations should be done by the caller as
     * post-converter-processing.
     * <p>
     * NOTE: identifier param is ignored
     * </p>
     *
     * @param searchParameters The PHARM-5 search parameters.
     * @return The <i>equivalent</i> {@link ChPharmacyDocumentsQuery}.
     */
    public static ChPharmacyDocumentsQuery toChPharmacyDocumentsQuery(final ChPharm5FindMedicationCardSearchParameters searchParameters) throws InvalidRequestException {
        Objects.requireNonNull(searchParameters);
        final var query = new ChFindMedicationCardQuery();

        fillCommonChPharmacyDocumentsQueryInfo(query, searchParameters, searchParameters.getChPharm5Operation());

        // Query param: period.
        parsePeriodParam(searchParameters.getPeriod(), query.getServiceStart(), query.getServiceEnd());

        if (searchParameters.getLanguage() != null)
            query.setLanguageCode(
                    searchParameters.getLanguage().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(searchParameters.getFhirContext()))
                            .collect(Collectors.joining(","))
            );

        if (searchParameters.getIncludeNonActive() != null) {
            query.setIncludeNonActive("true".equals(searchParameters.getIncludeNonActive().getValueAsQueryToken(searchParameters.getFhirContext())));
        }

        query.setPaperFormat(parsePaperFormat(searchParameters.getPaperFormat(), searchParameters.getFhirContext()));

        return query;
    }

    /**
     * Fills the criteria that is common to all PHARM queries.
     * @param query        The {@link ChPharmacyDocumentsQuery} to be filled.
     * @param searchParams The original search parameters.
     * @param operation    The PHARM-5 operation.
     */
    protected static void fillCommonChPharmacyDocumentsQueryInfo(final ChPharmacyDocumentsQuery query,
                                                                 final Pharm5SearchParameters searchParams,
                                                                 final ChPharm5Operations operation) {
        //COMMON PARAMS:
        // type is set by constructor, not need to be set here
        // home community id is not specified by pharm-5

        // Query param: patient(.identifier)
        ensureNotNull(searchParams.getPatientIdentifier(), "patient.identifier", operation);
        final var receivedIdentifiable = new Identifiable(searchParams.getPatientIdentifier().getValue(),
                new AssigningAuthority(Oids.normalize(searchParams.getPatientIdentifier().getSystem())));
        query.setPatientId(receivedIdentifiable);

        parseStatusParam(searchParams.getStatus(), query, operation);

        query.setFormatCodes(new ArrayList<>());
        FindQueryUtils.parseCodeList(searchParams.getFormat(), query.getFormatCodes(), "format");
    }

    /**
     * Fills the criteria that are specific to the stable documents query operations (e.g. FindTreatmentPlans).
     *
     * @param query        The {@link ChPharmacyDocumentsQuery} to be filled.
     * @param searchParams The original search parameters.
     * @param operation    The PHARM-5 operation.
     */
    protected static ChPharmacyDocumentsQuery convertStableQuery(final ChPharmacyStableDocumentsQuery query,
                                                                 final Pharm5SearchParameters searchParams,
                                                                 final ChPharm5Operations operation
                                                                 ) {
        fillCommonChPharmacyDocumentsQueryInfo(query, searchParams, operation);

        //STABLE PARAMS:
        // Query param: date

        final XdsTimeRange creationXdsTimeRange = FindQueryUtils.toXdsTimeRange(searchParams.getDate());
        if (creationXdsTimeRange.getLower() != null) {
            query.getCreationTime().setFrom(DateTimes.toHl7Dtm(creationXdsTimeRange.getLower(), ZoneId.systemDefault()));
        }
        if (creationXdsTimeRange.getUpper() != null) {
            query.getCreationTime().setTo(DateTimes.toHl7Dtm(creationXdsTimeRange.getUpper(), ZoneId.systemDefault()));
        }
        // Query param: period.
        parsePeriodParam(searchParams.getPeriod(), query.getServiceStartTime(), query.getServiceStopTime());

        //TODO identifiers (uuids and uniqueids)
        //if (searchParams.getIdentifier() != null)

        // Query param: setting
        query.setPracticeSettingCodes(new ArrayList<>());
        FindQueryUtils.parseCodeList(searchParams.getSetting(), query.getPracticeSettingCodes(), "setting");

        // Query param: facility
        query.setHealthcareFacilityTypeCodes(new ArrayList<>());
        FindQueryUtils.parseCodeList(searchParams.getFacility(),
                query.getHealthcareFacilityTypeCodes(),
                "facility"
        );

        // Query param: event
        final List<Code> eventCodes = new ArrayList<>(0);
        FindQueryUtils.parseCodeList(searchParams.getEvent(), eventCodes, "event");
        if (!eventCodes.isEmpty()) query.setEventCodes(new ArrayList<>(eventCodes));

        // Query param: security-label
        final List<Code> confidentialityCodes = new ArrayList<>(0);
        FindQueryUtils.parseCodeList(searchParams.getSecurityLabel(), confidentialityCodes, "security-label");
        if (!confidentialityCodes.isEmpty()) query.setConfidentialityCodes(new ArrayList<>(confidentialityCodes));

        // Query params: author.given and author.family
        query.setAuthorPersons(new ArrayList<>());
        FindQueryUtils.parseAuthor(searchParams.getAuthorGivenName(), query.getAuthorPersons());
        FindQueryUtils.parseAuthor(searchParams.getAuthorFamilyName(), query.getAuthorPersons());

        return query;
    }

    /**
     * Fills the criteria that are specific to the FindMedicationList operation.
     *
     * @param query        The {@link ChPharmacyDocumentsQuery} to be filled.
     * @param searchParams The original search parameters.
     * @param operation    The PHARM-5 operation.
     */
    protected static ChPharmacyDocumentsQuery convertMedicationListQuery(final ChFindMedicationListQuery query,
                                                                         final Pharm5SearchParameters searchParams,
                                                                         final ChPharm5Operations operation) {
        fillCommonChPharmacyDocumentsQueryInfo(query, searchParams, operation);

        // Query param: period.
        parsePeriodParam(searchParams.getPeriod(), query.getServiceStart(), query.getServiceEnd());

        return query;
    }

    /**
     * Parses a period param and fills the passed service start and service end criteria.
     * @param param        The date range param to be parsed as criteria.
     * @param serviceStart The service start criterium to be filled from the parsed param.
     * @param serviceEnd   The service end criterium to be filled from the parsed param.
     */
    protected static void parsePeriodParam(final @Nullable DateRangeParam param,
                                           final TimeRange serviceStart,
                                           final TimeRange serviceEnd) {
        final XdsTimeRange serviceTimeRange = FindQueryUtils.toXdsTimeRange(param);
        if (serviceTimeRange.getLower() != null) {
            serviceStart.setFrom(DateTimes.toHl7Dtm(serviceTimeRange.getLower(), ZoneId.systemDefault()));
        }
        if (serviceTimeRange.getUpper() != null) {
            serviceEnd.setTo(DateTimes.toHl7Dtm(serviceTimeRange.getUpper(), ZoneId.systemDefault()));
        }
    }

    /**
     * Enforces non-null validation on a parameter.
     * @param parameter     The parameter to be checked.
     * @param parameterName The name fo the parameter being checked.
     * @param operation     The current operation, e.g. {@code $find-treatment-plans}.
     */
    protected static void ensureNotNull(final @Nullable Object parameter,
                                        final String parameterName,
                                        final ChPharm5Operations operation) {
        if (parameter == null) {
            throw FindQueryUtils.invalidRequestException(
                    OperationOutcome.IssueType.REQUIRED,
                    "In PHARM-5 %s operation, the parameter '%s' shall be set",
                    operation.getOperation(),
                    parameterName
            );
        }
    }

    /**
     * Parses the query parameter 'status' as a set of {@link AvailabilityStatus} and adds it to the corresponding field
     * of the CH Pharmacy documents query. It is required and limited to 'current' and 'superseded' values.
     *
     * @param statusTokens The FHIR search parameters 'status'.
     * @param query        The ch pharmacy documents query to fill.
     * @param operation    The CH:PHARM-5 operation.
     */
    protected static void parseStatusParam(final @Nullable TokenOrListParam statusTokens,
                                           final ChPharmacyDocumentsQuery query,
                                           final ChPharm5Operations operation
                                           ) {
        Objects.requireNonNull(query);

        ensureNotNull(statusTokens, "status", operation);

        query.setStatus(new ArrayList<>(1));
        FindQueryUtils.parseStatusParam(statusTokens, query.getStatus());
    }

    /**
     * Parses the paper format returning the resulting {@link Code} translation.
     * @param param       The paper format as received in the CH:PHARM-5 query.
     * @param fhirContext The FHIR context.
     * @return The parsed paper format code.
     */
    protected static @Nullable Code parsePaperFormat(final @Nullable TokenParam param, final FhirContext fhirContext) {
        if (param == null) return null;
        return new Code(param.getValue(), null, param.getSystem());
    }
}
