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

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DocumentReference;
import org.openehealth.ipf.commons.ihe.fhir.QueryClientRequestFactory;

/**
 * Request factory for CH:PHARM-5 requests.
 *
 * @author Quentin Ligier
 **/
public class ChPharm5ClientRequestFactory extends QueryClientRequestFactory<Bundle> {

    public ChPharm5ClientRequestFactory() {
        super(DocumentReference.class, Bundle.class);
    }
}
