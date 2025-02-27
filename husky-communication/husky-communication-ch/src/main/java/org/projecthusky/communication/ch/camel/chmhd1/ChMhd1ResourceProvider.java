package org.projecthusky.communication.ch.camel.chmhd1;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.ResourceParam;
import ca.uhn.fhir.rest.annotation.Update;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.IdType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A resource provider for the <a href="https://fhir.ch/ig/ch-epr-fhir/ch-mhd-1.html">CH:MHD-1</a> transaction.
 */
public class ChMhd1ResourceProvider extends AbstractPlainProvider {
    @Update
    public MethodOutcome updateDocumentMetadata(@IdParam IdType theId,
                                                @ResourceParam DocumentReference documentReference,
                                                RequestDetails requestDetails,
                                                HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse) {
        final var params = ChMhd1Parameters.builder()
            .fhirContext(getFhirContext())
            .id(theId)
            .build();
        return requestAction(documentReference, params, httpServletRequest, httpServletResponse, requestDetails);
    }
}
