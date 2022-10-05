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
package org.projecthusky.communication.ch.ppq.epr.policyadmin.api;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the AssertionBasedRequestBuilder Interface</div>
 * <div class="de">Beschreibung der Methoden des AssertionBasedRequestBuilder Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AssertionBasedRequestBuilder {

	AssertionBasedRequestBuilder assertion(AssertionType aAssertion);

}
