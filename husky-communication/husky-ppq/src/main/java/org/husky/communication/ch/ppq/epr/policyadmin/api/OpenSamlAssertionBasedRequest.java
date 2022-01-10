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
package org.husky.communication.ch.ppq.epr.policyadmin.api;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.opensaml.core.xml.XMLObject;

/**
* <!-- @formatter:off -->
* <div class="en">Extending interface to integrate AssertionBasedRequest interface to opensaml implementation.</div>
* <div class="de">Erweiterndes Interface um das AssertionBasedRequest Interface in OpenSAML Implementation zu integrieren.</div>
* <div class="fr"></div>
* <div class="it"></div>
* <!-- @formatter:on -->
*/
public interface OpenSamlAssertionBasedRequest extends AssertionBasedRequest, XMLObject {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the assertion</div>
	 * <div class="de">Methode um die Assertion zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertion
	 * <div class="en">the assertion to be set.</div>
	 * <div class="de">die Assertion die gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setAssertion(AssertionType aAssertion);
	// There are no special methods defined, but this intermediate interface has
	// to be declared for opensaml reasons
}
