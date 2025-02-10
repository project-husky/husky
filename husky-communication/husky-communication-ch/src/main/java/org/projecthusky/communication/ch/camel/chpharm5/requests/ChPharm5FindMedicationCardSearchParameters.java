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
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.param.*;
import lombok.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5Operations;
import org.projecthusky.communication.ch.camel.chpharm5.ChPharm5Operations;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5SearchParameters;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Search parameters for the $find-medication-card operation of CH:PHARM-5.
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter @Setter
public class ChPharm5FindMedicationCardSearchParameters extends Pharm5SearchParameters {
    public static final String INCLUDE_NON_ACTIVE_PARAM_NAME = "includenonactive";
    public static final String PAPER_FORMAT_PARAM_NAME = "paperformat";

    private @Nullable TokenOrListParam language;
    private @Nullable TokenParam includeNonActive;
    private @Nullable TokenParam paperFormat;

    @Builder(builderMethodName = "chPharm5Builder")
    public ChPharm5FindMedicationCardSearchParameters(TokenParam patientIdentifier,
                                                      DateRangeParam date,
                                                      StringParam authorFamilyName,
                                                      StringParam authorGivenName,
                                                      TokenParam identifier,
                                                      TokenOrListParam status,
                                                      TokenOrListParam setting,
                                                      DateRangeParam period,
                                                      TokenOrListParam facility,
                                                      TokenOrListParam event,
                                                      TokenOrListParam securityLabel,
                                                      TokenOrListParam format,
                                                      TokenOrListParam language,
                                                      TokenParam includeNonActive,
                                                      TokenParam paperFormat,
                                                      SortSpec sortSpec,
                                                      Set<Include> includeSpec,
                                                      FhirContext fhirContext) {
        super(patientIdentifier, date, authorFamilyName, authorGivenName, identifier, status, setting, period, facility, event, securityLabel, format, null, sortSpec, includeSpec, fhirContext);
        this.language = language;
        this.includeNonActive = includeNonActive;
        this.paperFormat = paperFormat;
    }

    /**
     * Since the overridden method signature returns the {@link Pharm5Operations} enum, which does not include the
     * find medication card operation (because it is a Swiss extension), we are forced to use a different method to
     * get the actual operation.
     *
     * @return The operation.
     */
    @Override @Deprecated
    public Pharm5Operations getOperation() {
        throw new UnsupportedOperationException("ChPharm5SearchParameters#getOperation is not supported, use getChPharm5Operation instead.");
    }

    public ChPharm5Operations getChPharm5Operation() {
        return ChPharm5Operations.FIND_MEDICATION_CARD;
    }

    @Override
    public Parameters toParameters() {
        final var params = super.toParameters();
        if (language != null) {
            params.addParameter(
                    DocumentReference.SP_LANGUAGE,
                    new StringType(
                            language.getValuesAsQueryTokens().stream()
                                    .map(tokenParam -> tokenParam.getValueAsQueryToken(getFhirContext()))
                                    .collect(Collectors.joining(","))
                    )
            );
        }
        if (includeNonActive != null) {
            params.addParameter(INCLUDE_NON_ACTIVE_PARAM_NAME, new BooleanType(includeNonActive.getValueAsQueryToken(getFhirContext())));
        }
        if (paperFormat != null) {
            params.addParameter(PAPER_FORMAT_PARAM_NAME, new StringType(paperFormat.getValueAsQueryToken(getFhirContext())));
        }
        return params;
    }
}
