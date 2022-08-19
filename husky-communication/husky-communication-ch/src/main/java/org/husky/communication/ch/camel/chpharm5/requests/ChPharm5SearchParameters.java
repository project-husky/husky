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
package org.husky.communication.ch.camel.chpharm5.requests;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.api.SortOrderEnum;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.param.*;
import ca.uhn.fhir.util.UrlUtil;
import lombok.*;
import org.hl7.fhir.r4.model.*;
import org.husky.communication.ch.camel.chpharm5.ChPharm5Operations;
import org.openehealth.ipf.commons.ihe.fhir.FhirSearchAndSortParameters;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5ResourceProvider;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5SearchParameters;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
@ToString
public abstract class ChPharm5SearchParameters extends FhirSearchAndSortParameters<DocumentReference> {

    @Getter @Setter private TokenParam patientIdentifier;
    @Getter @Setter private DateRangeParam date;
    @Getter @Setter private StringParam authorFamilyName;
    @Getter @Setter private StringParam authorGivenName;
    @Getter @Setter private TokenParam identifier;
    @Getter @Setter private TokenOrListParam status;
    @Getter @Setter private TokenOrListParam setting;
    @Getter @Setter private DateRangeParam period;
    @Getter @Setter private TokenOrListParam facility;
    @Getter @Setter private TokenOrListParam event;
    @Getter @Setter private TokenOrListParam securityLabel;
    @Getter @Setter private TokenOrListParam format;
    @Getter @Setter private ChPharm5Operations operation;

    @Getter @Setter private SortSpec sortSpec;
    @Getter @Setter private Set<Include> includeSpec;

    @Getter private FhirContext fhirContext;


    @Override
    public List<TokenParam> getPatientIdParam() {
        return (patientIdentifier != null) ? List.of(patientIdentifier) : Collections.emptyList();
    }

    public ChPharm5SearchParameters setAuthor(final ReferenceAndListParam author) {
        if (author != null) {
            author.getValuesAsQueryTokens().forEach(param -> {
                var ref = param.getValuesAsQueryTokens().get(0);
                var authorChain = ref.getChain();
                if (Practitioner.SP_FAMILY.equals(authorChain)) {
                    setAuthorFamilyName(ref.toStringParam(getFhirContext()));
                } else if (Practitioner.SP_GIVEN.equals(authorChain)) {
                    setAuthorGivenName(ref.toStringParam(getFhirContext()));
                }
            });
        }
        return this;
    }

    @Override
    public Optional<Comparator<DocumentReference>> comparatorFor(final String paramName) {
        if (DocumentReference.SP_DATE.equals(paramName)) {
            return Optional.of(CP_DATE);
        } else if (DocumentReference.SP_AUTHOR.equals(paramName)) {
            return Optional.of(CP_AUTHOR);
        }
        return Optional.empty();
    }

    public String getQueryString(FhirContext context) {
        return this.patientIdentifier.getValueAsQueryToken(context);
    }


    /**
     * Maps the {@link Pharm5SearchParameters} to an equivalent {@link Parameters}, for the given FHIR context.
     */
    public Parameters toParameters() {
        final var parameters = new Parameters();

        if (this.getPatientIdentifier() != null) {
            parameters.addParameter(Pharm5ResourceProvider.SP_PATIENT_IDENTIFIER,
                    new StringType(this.getPatientIdentifier().getValueAsQueryToken(fhirContext)));
        }
        if (this.getDate() != null) {
            this.getDate().getValuesAsQueryTokens().forEach(dateParam -> parameters.addParameter(DocumentReference.SP_DATE, new StringType(dateParam.getValueAsQueryToken(fhirContext))));
        }
        if (this.getAuthorFamilyName() != null) {
            parameters.addParameter(Pharm5ResourceProvider.SP_AUTHOR_FAMILY,
                    new StringType(this.getAuthorFamilyName().getValueAsQueryToken(fhirContext)));
        }
        if (this.getAuthorGivenName() != null) {
            parameters.addParameter(Pharm5ResourceProvider.SP_AUTHOR_GIVEN,
                    new StringType(this.getAuthorGivenName().getValueAsQueryToken(fhirContext)));
        }
        if (this.getIdentifier() != null) {
            parameters.addParameter(DocumentReference.SP_IDENTIFIER,
                    new StringType(this.getIdentifier().getValueAsQueryToken(fhirContext)));
        }
        if (this.getStatus() != null) {
            parameters.addParameter(DocumentReference.SP_STATUS, new StringType(
                    this.getStatus().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(fhirContext))
                            .collect(Collectors.joining(","))
            ));
        }
        if (this.getSetting() != null) {
            parameters.addParameter(DocumentReference.SP_SETTING, new StringType(
                    this.getSetting().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(fhirContext))
                            .collect(Collectors.joining(","))
            ));
        }
        if (this.getPeriod() != null) {
            this.getPeriod().getValuesAsQueryTokens().forEach(dateParam -> parameters.addParameter(DocumentReference.SP_PERIOD, new StringType(dateParam.getValueAsQueryToken(fhirContext))));
        }
        if (this.getFacility() != null) {
            parameters.addParameter(DocumentReference.SP_FACILITY, new StringType(
                    this.getFacility().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(fhirContext))
                            .collect(Collectors.joining(","))
            ));
        }
        if (this.getEvent() != null) {
            parameters.addParameter(DocumentReference.SP_EVENT, new StringType(
                    this.getEvent().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(fhirContext))
                            .collect(Collectors.joining(","))
            ));
        }
        if (this.getSecurityLabel() != null) {
            parameters.addParameter(DocumentReference.SP_SECURITY_LABEL, new StringType(
                    this.getSecurityLabel().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(fhirContext))
                            .collect(Collectors.joining(","))
            ));
        }
        if (this.getFormat() != null) {
            parameters.addParameter(DocumentReference.SP_FORMAT, new StringType(
                    this.getFormat().getValuesAsQueryTokens().stream()
                            .map(tokenParam -> tokenParam.getValueAsQueryToken(fhirContext))
                            .collect(Collectors.joining(","))
            ));
        }

        if (this.getSortSpec() != null) {
            SortSpec sort = this.getSortSpec();
            boolean first = true;
            final var b = new StringBuilder();
            while (sort != null) {
                if (!first) {
                    b.append(',');
                }
                if (sort.getOrder() == SortOrderEnum.DESC) {
                    b.append('-');
                }
                b.append(sort.getParamName());
                sort = sort.getChain();
                first = false;
            }
            parameters.addParameter(ca.uhn.fhir.rest.api.Constants.PARAM_SORT, new StringType(b.toString()));
        }
        if (this.getIncludeSpec() != null) {
            for (final Include nextInclude : this.getIncludeSpec()) {
                final var b = new StringBuilder();
                b.append(UrlUtil.escapeUrlParam(nextInclude.getParamType()));
                b.append(':');
                b.append(UrlUtil.escapeUrlParam(nextInclude.getParamName()));
                if (isNotBlank(nextInclude.getParamTargetType())) {
                    b.append(':');
                    b.append(nextInclude.getParamTargetType());
                }

                final var paramName = (nextInclude.isRecurse())
                        ? ca.uhn.fhir.rest.api.Constants.PARAM_INCLUDE_ITERATE
                        : ca.uhn.fhir.rest.api.Constants.PARAM_INCLUDE;
                parameters.addParameter(paramName, new StringType(b.toString()));
            }
        }

        return parameters;
    }

    private static final Comparator<DocumentReference> CP_DATE = nullsLast(comparing(DocumentReference::getDate));

    private static final Comparator<DocumentReference> CP_AUTHOR = nullsLast(comparing(documentReference -> {
        if (!documentReference.hasAuthor()) return null;
        var author = documentReference.getAuthorFirstRep();
        if (author.getResource() instanceof PractitionerRole) {
            var practitionerRole = (PractitionerRole) author.getResource();
            if (!practitionerRole.hasPractitioner()) return null;
            author = practitionerRole.getPractitioner();
        }
        if (author.getResource() == null) return null;
        if (author.getResource() instanceof Practitioner) {
            var practitioner = (Practitioner) author.getResource();
            if (!practitioner.hasName()) return null;
            var name = practitioner.getNameFirstRep();
            return name.getFamilyElement().getValueNotNull() + name.getGivenAsSingleString();
        }
        return null;
    }));
}
