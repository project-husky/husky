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

import org.apache.camel.CamelContext;
import org.husky.communication.ch.camel.MHD;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirComponent;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpointConfiguration;

/**
 * The Camel component for the CH:PHARM-5 transaction.
 *
 * @author Quentin Ligier
 **/
public class ChPharm5Component extends FhirComponent<FhirQueryAuditDataset> {

    public ChPharm5Component() {
        super(MHD.QueryDocumentReferenceInteractions.CHPHARM_5);
    }

    public ChPharm5Component(final CamelContext context) {
        super(context, MHD.QueryDocumentReferenceInteractions.CHPHARM_5);
    }

    @Override
    protected ChPharm5Endpoint doCreateEndpoint(final String uri,
                                                final FhirEndpointConfiguration<FhirQueryAuditDataset> config) {
        return new ChPharm5Endpoint(uri, this, config);
    }
}
