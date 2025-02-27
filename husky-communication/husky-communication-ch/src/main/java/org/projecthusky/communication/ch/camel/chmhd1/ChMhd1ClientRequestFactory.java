package org.projecthusky.communication.ch.camel.chmhd1;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.IUpdateExecutable;
import org.hl7.fhir.r4.model.DocumentReference;
import org.openehealth.ipf.commons.ihe.fhir.ClientRequestFactory;

import java.util.Map;
import java.util.Objects;

import static org.openehealth.ipf.commons.ihe.fhir.Constants.FHIR_REQUEST_PARAMETERS;

/**
 * A client request factory for the <a href="https://fhir.ch/ig/ch-epr-fhir/ch-mhd-1.html">CH:MHD-1</a> transaction.
 */
public class ChMhd1ClientRequestFactory implements ClientRequestFactory<IUpdateExecutable> {
    @Override
    public IUpdateExecutable getClientExecutable(IGenericClient client, Object requestData, Map parameters) {
        Objects.requireNonNull(client);
        Objects.requireNonNull(requestData);
        Objects.requireNonNull(parameters);

        if (requestData instanceof DocumentReference docRef) {

            if (parameters.containsKey(FHIR_REQUEST_PARAMETERS)) {
                if (parameters.get(FHIR_REQUEST_PARAMETERS) instanceof ChMhd1Parameters chMhd1Parameters) {
                    return client.update().resource(docRef).withId(chMhd1Parameters.getId());
                } else throw new IllegalArgumentException(FHIR_REQUEST_PARAMETERS + " parameter is required and should contain a ChMhd1Parameters instance.");
            } else throw new IllegalArgumentException(FHIR_REQUEST_PARAMETERS + " parameter is required and should contain a ChMhd1Parameters instance.");
        } else throw new IllegalArgumentException(String.format("Unsupported request data type " + requestData.getClass()));
    }
}
