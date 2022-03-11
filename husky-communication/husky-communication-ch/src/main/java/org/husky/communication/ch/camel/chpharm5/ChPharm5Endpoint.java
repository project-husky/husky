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

import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpoint;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpointConfiguration;

/**
 * FHIR endpoint for CH:PHARM-5.
 *
 * @author Quentin Ligier
 **/
public class ChPharm5Endpoint extends FhirEndpoint<FhirQueryAuditDataset, ChPharm5Component> {

    public ChPharm5Endpoint(final String uri,
                            final ChPharm5Component fhirComponent,
                            final FhirEndpointConfiguration<FhirQueryAuditDataset> config) {
        super(uri, fhirComponent, config);
    }

    @Override
    protected String createEndpointUri() {
        return "cmpd-chpharm-5:" + "not-implemented yet";
    }
}
