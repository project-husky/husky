package org.projecthusky.communication.ch.camel.chmhd1;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.param.TokenParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r4.model.IdType;
import org.openehealth.ipf.commons.ihe.fhir.FhirSearchParameters;

import java.util.List;
import java.util.Set;

/**
 * Encapsulation of the query parameters for the
 * <a href="https://fhir.ch/ig/ch-epr-fhir/ch-mhd-1.html">CH:MHD-1</a> transaction.
 */
@Builder
@AllArgsConstructor
public class ChMhd1Parameters implements FhirSearchParameters {
    @Getter @Setter
    private IdType id;
    @Getter
    private final FhirContext fhirContext;

    @Override
    public Set<Include> getIncludeSpec() {
        return Set.of();
    }

    @Override
    public List<TokenParam> getPatientIdParam() {
        return List.of();
    }
}
