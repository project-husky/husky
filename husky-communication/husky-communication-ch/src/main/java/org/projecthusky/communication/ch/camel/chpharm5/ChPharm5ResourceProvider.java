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
package org.projecthusky.communication.ch.camel.chpharm5;

import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.model.valueset.BundleTypeEnum;
import ca.uhn.fhir.rest.annotation.IncludeParam;
import ca.uhn.fhir.rest.annotation.Operation;
import ca.uhn.fhir.rest.annotation.OperationParam;
import ca.uhn.fhir.rest.annotation.Sort;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.*;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5ResourceProvider;
import org.projecthusky.communication.ch.camel.chpharm5.requests.ChPharm5FindMedicationCardSearchParameters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Resource provider for CH:PHARM-5 based on IPF's {@link Pharm5ResourceProvider} extended to include the
 * <i>FindMedicationCard</i> operation.
 */
public class ChPharm5ResourceProvider extends Pharm5ResourceProvider {

    // The method is not idempotent, but we need it to support GET requests
    @Operation(name = "$find-medication-card", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findMedicationCard(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_LANGUAGE) TokenOrListParam language,
            @OperationParam(name = ChPharm5FindMedicationCardSearchParameters.INCLUDE_NON_ACTIVE_PARAM_NAME) TokenParam includeNonActive,
            @OperationParam(name = ChPharm5FindMedicationCardSearchParameters.PAPER_FORMAT_PARAM_NAME) TokenParam paperFormat,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        final var searchParameters = ChPharm5FindMedicationCardSearchParameters.chPharm5Builder()
                .status(status)
                .period(period)
                .format(format)
                .patientIdentifier(patient)
                .language(language)
                .includeNonActive(includeNonActive)
                .paperFormat(paperFormat)
                .sortSpec(sortSpec)
                .includeSpec(includeSpec)
                .fhirContext(getFhirContext())
                .build();

        // Run down the route
        return requestBundleProvider(null, searchParameters, ResourceType.DocumentReference.name(),
                httpServletRequest, httpServletResponse, requestDetails);
    }

}
