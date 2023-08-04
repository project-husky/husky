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

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.api.SortOrderEnum;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.param.*;
import ca.uhn.fhir.util.UrlUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.openehealth.ipf.commons.ihe.fhir.FhirSearchAndSortParameters;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5ResourceProvider;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5SearchParameters;
import org.projecthusky.communication.ch.camel.chpharm5.ChPharm5Operations;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * A specialized {@link SearchParameter} for CH:PHARM-5 search requests.
 *
 * @author Quentin Ligier
 **/
@Getter
@Setter
@ToString
public class ChPharm5SearchParameters extends FhirSearchAndSortParameters<DocumentReference> {

    protected TokenParam patientIdentifier;
    protected @Nullable DateRangeParam creation;
    protected @Nullable StringParam authorFamilyName;
    protected @Nullable StringParam authorGivenName;
    protected @Nullable TokenParam identifier;
    protected @Nullable TokenOrListParam status;
    protected @Nullable TokenOrListParam setting;
    protected @Nullable DateRangeParam period;
    protected @Nullable TokenOrListParam facility;
    protected @Nullable TokenOrListParam event;
    protected @Nullable TokenOrListParam securityLabel;
    protected @Nullable TokenOrListParam format;
    protected @Nullable TokenParam language;
    protected ChPharm5Operations operation;

    protected @Nullable SortSpec sortSpec;
    protected @Nullable Set<Include> includeSpec;

    protected FhirContext fhirContext;

    ChPharm5SearchParameters(final TokenParam patientIdentifier,
                             final @Nullable DateRangeParam creation,
                             final @Nullable StringParam authorFamilyName,
                             final @Nullable StringParam authorGivenName,
                             final @Nullable TokenParam identifier,
                             final @Nullable TokenOrListParam status,
                             final @Nullable TokenOrListParam setting,
                             final @Nullable DateRangeParam period,
                             final @Nullable TokenOrListParam facility,
                             final @Nullable TokenOrListParam event,
                             final @Nullable TokenOrListParam securityLabel,
                             final @Nullable TokenOrListParam format,
                             final @Nullable TokenParam language,
                             final ChPharm5Operations operation,
                             final @Nullable SortSpec sortSpec,
                             final @Nullable Set<Include> includeSpec,
                             final FhirContext fhirContext) {
        this.patientIdentifier = Objects.requireNonNull(patientIdentifier);
        this.creation = creation;
        this.authorFamilyName = authorFamilyName;
        this.authorGivenName = authorGivenName;
        this.identifier = identifier;
        this.status = status;
        this.setting = setting;
        this.period = period;
        this.facility = facility;
        this.event = event;
        this.securityLabel = securityLabel;
        this.format = format;
        this.language = language;
        this.operation = Objects.requireNonNull(operation);
        this.sortSpec = sortSpec;
        this.includeSpec = includeSpec;
        this.fhirContext = Objects.requireNonNull(fhirContext);
    }

    public static ChPharm5SearchParametersBuilder builder() {
        return new ChPharm5SearchParametersBuilder();
    }

    @Override
    public List<TokenParam> getPatientIdParam() {
        return List.of(this.patientIdentifier);
    }

    public ChPharm5SearchParameters setAuthor(final @Nullable ReferenceAndListParam author) {
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
        if (this.getCreation() != null) {
            this.getCreation().getValuesAsQueryTokens().forEach(dateParam -> parameters.addParameter(DocumentReference.SP_DATE,
                                                                                                     new StringType(
                                                                                                         dateParam.getValueAsQueryToken(
                                                                                                                 fhirContext))));
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
            this.getPeriod().getValuesAsQueryTokens().forEach(dateParam -> parameters.addParameter(DocumentReference.SP_PERIOD,
                                                                                                   new StringType(
                                                                                                           dateParam.getValueAsQueryToken(
                                                                                                                   fhirContext))));
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
        if (this.getLanguage() != null) {
            parameters.addParameter(DocumentReference.SP_LANGUAGE,
                                    new StringType(this.getLanguage().getValueNotNull()));
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
        if (!documentReference.hasAuthor()) {
            return "";
        }
        var author = documentReference.getAuthorFirstRep();
        if (author.getResource() instanceof final PractitionerRole practitionerRole) {
            if (!practitionerRole.hasPractitioner()) {
                return "";
            }
            author = practitionerRole.getPractitioner();
        }
        if (author.getResource() == null) {
            return "";
        }
        if (author.getResource() instanceof final Practitioner practitioner) {
            if (!practitioner.hasName()) {
                return "";
            }
            final var name = practitioner.getNameFirstRep();
            return name.getFamilyElement().getValueNotNull() + name.getGivenAsSingleString();
        }
        return "";
    }));


    public static class ChPharm5SearchParametersBuilder {
        private TokenParam patientIdentifier;
        private @Nullable DateRangeParam creation;
        private @Nullable StringParam authorFamilyName;
        private @Nullable StringParam authorGivenName;
        private @Nullable TokenParam identifier;
        private @Nullable TokenOrListParam status;
        private @Nullable TokenOrListParam setting;
        private @Nullable DateRangeParam period;
        private @Nullable TokenOrListParam facility;
        private @Nullable TokenOrListParam event;
        private @Nullable TokenOrListParam securityLabel;
        private @Nullable TokenOrListParam format;
        private @Nullable TokenParam language;
        private ChPharm5Operations operation;
        private @Nullable SortSpec sortSpec;
        private @Nullable Set<Include> includeSpec;
        private FhirContext fhirContext;

        ChPharm5SearchParametersBuilder() {
        }

        public ChPharm5SearchParametersBuilder patientIdentifier(final TokenParam patientIdentifier) {
            this.patientIdentifier = patientIdentifier;
            return this;
        }

        public ChPharm5SearchParametersBuilder creation(final @Nullable DateRangeParam creation) {
            this.creation = creation;
            return this;
        }

        public ChPharm5SearchParametersBuilder authorFamilyName(final @Nullable StringParam authorFamilyName) {
            this.authorFamilyName = authorFamilyName;
            return this;
        }

        public ChPharm5SearchParametersBuilder authorGivenName(final @Nullable StringParam authorGivenName) {
            this.authorGivenName = authorGivenName;
            return this;
        }

        public ChPharm5SearchParametersBuilder identifier(final @Nullable TokenParam identifier) {
            this.identifier = identifier;
            return this;
        }

        public ChPharm5SearchParametersBuilder status(final @Nullable TokenOrListParam status) {
            this.status = status;
            return this;
        }

        public ChPharm5SearchParametersBuilder setting(final @Nullable TokenOrListParam setting) {
            this.setting = setting;
            return this;
        }

        public ChPharm5SearchParametersBuilder period(final @Nullable DateRangeParam period) {
            this.period = period;
            return this;
        }

        public ChPharm5SearchParametersBuilder facility(final @Nullable TokenOrListParam facility) {
            this.facility = facility;
            return this;
        }

        public ChPharm5SearchParametersBuilder event(final @Nullable TokenOrListParam event) {
            this.event = event;
            return this;
        }

        public ChPharm5SearchParametersBuilder securityLabel(final @Nullable TokenOrListParam securityLabel) {
            this.securityLabel = securityLabel;
            return this;
        }

        public ChPharm5SearchParametersBuilder format(final @Nullable TokenOrListParam format) {
            this.format = format;
            return this;
        }

        public ChPharm5SearchParametersBuilder language(final @Nullable TokenParam language) {
            this.language = language;
            return this;
        }

        public ChPharm5SearchParametersBuilder operation(final ChPharm5Operations operation) {
            this.operation = operation;
            return this;
        }

        public ChPharm5SearchParametersBuilder sortSpec(final @Nullable SortSpec sortSpec) {
            this.sortSpec = sortSpec;
            return this;
        }

        public ChPharm5SearchParametersBuilder includeSpec(final @Nullable Set<Include> includeSpec) {
            this.includeSpec = includeSpec;
            return this;
        }

        public ChPharm5SearchParametersBuilder fhirContext(final FhirContext fhirContext) {
            this.fhirContext = fhirContext;
            return this;
        }

        public ChPharm5SearchParameters build() {
            return new ChPharm5SearchParameters(this.patientIdentifier,
                                                this.creation,
                                                this.authorFamilyName,
                                                this.authorGivenName,
                                                this.identifier,
                                                this.status,
                                                this.setting,
                                                this.period,
                                                this.facility,
                                                this.event,
                                                this.securityLabel,
                                                this.format,
                                                this.language,
                                                this.operation,
                                                this.sortSpec,
                                                this.includeSpec,
                                                this.fhirContext);
        }


        @Override
        public String toString() {
            return "ChPharm5SearchParametersBuilder{" +
                    "patientIdentifier=" + patientIdentifier +
                    ", creation=" + creation +
                    ", authorFamilyName=" + authorFamilyName +
                    ", authorGivenName=" + authorGivenName +
                    ", identifier=" + identifier +
                    ", status=" + status +
                    ", setting=" + setting +
                    ", period=" + period +
                    ", facility=" + facility +
                    ", event=" + event +
                    ", securityLabel=" + securityLabel +
                    ", format=" + format +
                    ", language=" + language +
                    ", operation=" + operation +
                    ", sortSpec=" + sortSpec +
                    ", includeSpec=" + includeSpec +
                    ", fhirContext=" + fhirContext +
                    '}';
        }
    }
}
