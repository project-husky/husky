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
package org.husky.communication.ch.camel.chpharm1;

import org.apache.camel.Processor;
import org.husky.communication.ch.camel.chpharm1.requests.ChPharm1RequestValidator;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLAdhocQueryRequest30;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLQueryResponse30;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.validate.responses.QueryResponseValidator;

import static org.openehealth.ipf.commons.ihe.xds.CMPD.Interactions.PHARM_1;
import static org.openehealth.ipf.platform.camel.core.adapter.ValidatorAdapter.validationEnabled;

/**
 * Validating processors for ebXML 3.0-based CH:PHARM-1 transaction.
 *
 * @author Dmytro Rud
 * @author Quentin Ligier
 **/
public class ChPharm1Validators {

    private static final Processor CHPHARM_1_REQUEST_VALIDATOR = exchange -> {
        if (! validationEnabled(exchange)) {
            return;
        }
        var message =
                new EbXMLAdhocQueryRequest30(exchange.getIn().getBody(AdhocQueryRequest.class));
        new ChPharm1RequestValidator().validate(message, PHARM_1); // TODO: CHPHARM-1
    };

    private static final Processor CHPHARM_1_RESPONSE_VALIDATOR = exchange -> {
        if (! validationEnabled(exchange)) {
            return;
        }
        var message =
                new EbXMLQueryResponse30(exchange.getIn().getBody(AdhocQueryResponse.class));
        new QueryResponseValidator().validate(message, PHARM_1);
    };

    /**
     * Returns a validating processor for CH:PHARM-1 request messages.
     */
    public static Processor chpharm1RequestValidator() {
        return CHPHARM_1_REQUEST_VALIDATOR;
    }

    /**
     * Returns a validating processor for CH:PHARM-1 response messages.
     */
    public static Processor chpharm1ResponseValidator() {
        return CHPHARM_1_RESPONSE_VALIDATOR;
    }
}
