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
package org.husky.communication.ch.camel.chpharm5;

import ca.uhn.fhir.rest.annotation.Operation;
import ca.uhn.fhir.rest.annotation.OperationParam;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.TokenOrListParam;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DocumentReference;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;
import org.openehealth.ipf.commons.ihe.fhir.iti67.Iti67SearchParameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ca.uhn.fhir.rest.annotation.OperationParam.MAX_UNLIMITED;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public class ChPharm5ResourceProvider extends AbstractPlainProvider {

    @Operation(name = "$find-dispenses", type = DocumentReference.class, idempotent = true)
    public Bundle findDispenses(
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = MAX_UNLIMITED) TokenOrListParam status,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        /*var relatedTokenParam = new TokenOrListParam();
        if (related != null) {
            related.getValuesAsQueryTokens().stream()
                .map(referenceParam -> referenceParam.toTokenParam(getFhirContext()))
                .forEach(relatedTokenParam::addOr);
        }*/

        final Iti67SearchParameters searchParameters = Iti67SearchParameters.builder()
                .status(status)
                .fhirContext(getFhirContext())
                .build();

        return requestResource(null, searchParameters, Bundle.class, httpServletRequest, httpServletResponse,
                requestDetails);
    }
}
