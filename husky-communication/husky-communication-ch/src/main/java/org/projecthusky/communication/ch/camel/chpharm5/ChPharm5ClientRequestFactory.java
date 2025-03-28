/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.camel.chpharm5;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.IClientExecutable;
import ca.uhn.fhir.rest.gclient.IOperationUntypedWithInput;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Parameters;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5SearchParameters;
import org.projecthusky.communication.ch.camel.chpharm5.requests.ChPharm5FindMedicationCardSearchParameters;
import org.openehealth.ipf.commons.ihe.fhir.ClientRequestFactory;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Request factory for CH:PHARM-5 requests.
 *
 * @author Christian Ohr
 * @author Quentin Ligier
 * @author Oliver Egger
 * @author Daniel Vazquez Rivera
 * @see <a href="https://github.com/i4mi/MobileAccessGateway/blob/d73ab958ee4e59dc96560e16eeeb93a42869b802/src/main/java/ch/bfh/ti/i4mi/mag/mhd/pharm5/Pharm5ClientRequestFactory.java">
 * Pharm5ClientRequestFactory in MobileAccessGateway</a>
 **/
public class ChPharm5ClientRequestFactory implements ClientRequestFactory<IOperationUntypedWithInput<Bundle>> {

    /**
     * Returns a FHIR request using a FHIR client and a sequence of input data.
     *
     * @param client        FHIR client
     * @param requestData   main request data, either {@link Parameters} or {@link ChPharm5FindMedicationCardSearchParameters}. If {@link
     *                      Parameters}, it shall contain the operation name if the user data (use {@link
     *                      Base#setUserData(String, Object)}).
     * @param parametersMap parameter map
     * @return FHIR request executable.
     */
    @Override
    public IClientExecutable<IOperationUntypedWithInput<Bundle>, ?> getClientExecutable(final IGenericClient client,
                                                                                        final Object requestData,
                                                                                        final Map<String, Object> parametersMap) {
        Objects.requireNonNull(client, "client shall not be null in ChPharm5ClientRequestFactory");
        Objects.requireNonNull(requestData, "requestData shall not be null in ChPharm5ClientRequestFactory");
        Objects.requireNonNull(parametersMap, "parametersMap shall not be null in ChPharm5ClientRequestFactory");

        final Parameters parameters;
        final String operation;

        if (requestData instanceof final Parameters p2) {
            parameters = p2;
            operation = Optional.ofNullable(p2.getUserString("operation"))
                    .orElseThrow(() -> new IllegalArgumentException("The Parameters 'requestData' doesn't contain the operation name"));
        } else if (requestData instanceof final ChPharm5FindMedicationCardSearchParameters searchParameters) {
            parameters = searchParameters.toParameters();
            operation = searchParameters.getChPharm5Operation().getOperation();
        } else if (requestData instanceof Pharm5SearchParameters searchParameters) {
            parameters = searchParameters.toParameters();
            operation = searchParameters.getOperation().getOperation();
        } else {
            throw new IllegalArgumentException(String.format("The argument 'requestData' is not supported (expected " +
                    "Parameters or Pharm5SearchParameters, got '%s')", requestData.getClass().getName()));
        }

        return this.getClientExecutable(client, parameters, operation);
    }

    IOperationUntypedWithInput<Bundle> getClientExecutable(final IGenericClient client,
                                                           final Parameters parameters,
                                                           final String operation) {
        return client.operation()
                .onType(DocumentReference.class)
                .named(operation)
                .withParameters(parameters)
                .returnResourceType(Bundle.class)
                .useHttpGet();
    }
}
