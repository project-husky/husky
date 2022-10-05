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

import org.apache.camel.Endpoint;
import org.openehealth.ipf.commons.ihe.ws.JaxWsClientFactory;
import org.openehealth.ipf.commons.ihe.ws.WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsQueryAuditDataset;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryResponse;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsProducer;
import org.openehealth.ipf.platform.camel.ihe.ws.SimpleWsProducer;
import org.openehealth.ipf.platform.camel.ihe.xds.XdsComponent;
import org.openehealth.ipf.platform.camel.ihe.xds.XdsEndpoint;

import java.util.Map;

import static org.projecthusky.communication.ch.camel.ChCmpd.Interactions.CHPHARM_1;

/**
 * The Camel component for the CH:PHARM-1 transaction.
 *
 * @author Quentin Ligier
 */
public class ChPharm1Component extends XdsComponent<XdsQueryAuditDataset>  {

    public ChPharm1Component() {
        super(CHPHARM_1);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) {
        return new XdsEndpoint<>(uri, remaining, this, parameters, ChPharm1Service.class) {
            @Override
            public AbstractWsProducer<XdsQueryAuditDataset, WsTransactionConfiguration<XdsQueryAuditDataset>, ?, ?> getProducer(
                    final AbstractWsEndpoint<XdsQueryAuditDataset, WsTransactionConfiguration<XdsQueryAuditDataset>> endpoint,
                    final JaxWsClientFactory<XdsQueryAuditDataset> clientFactory
            ) {
                return new SimpleWsProducer<>(endpoint, clientFactory, AdhocQueryRequest.class, AdhocQueryResponse.class);
            }
        };
    }
}
