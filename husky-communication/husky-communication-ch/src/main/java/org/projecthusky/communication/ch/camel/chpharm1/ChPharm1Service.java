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
package org.projecthusky.communication.ch.camel.chpharm1;

import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryResponse;
import org.openehealth.ipf.platform.camel.ihe.xds.XdsAdhocQueryService;

/**
 * Service implementation for the CH:PHARM-1 transaction (Query Pharmacy Documents).
 * <p>
 * This implementation delegates to a Camel consumer by creating an exchange.
 *
 * @author Quentin Ligier
 **/
public class ChPharm1Service extends XdsAdhocQueryService implements ChPharm1PortType {

    public ChPharm1Service() {
        super(null);
    }

    @Override
    public AdhocQueryResponse communityPharmacyManagerQueryPharmacyDocuments(final AdhocQueryRequest body) {
        return this.processRequest(body);
    }
}
