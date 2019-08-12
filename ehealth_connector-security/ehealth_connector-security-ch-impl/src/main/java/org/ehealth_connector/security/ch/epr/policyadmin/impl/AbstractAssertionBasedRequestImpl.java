/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.security.ch.epr.policyadmin.impl;

import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlAssertionBasedRequest;
import org.ehealth_connector.security.saml2.Assertion;
import org.opensaml.core.xml.AbstractXMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract Class implelementing the common methods for AssertionBasedRequests.</div>
 * <div class="de">Abstrakte Klasse welche die gemeinsamen methoden für AssertionBasedRequests implementiert</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractAssertionBasedRequestImpl extends AbstractXMLObject
		implements OpenSamlAssertionBasedRequest {

	private Assertion assertion;

	protected AbstractAssertionBasedRequestImpl(String namespaceURI, String elementLocalName,
			String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.ch.epr.policyadmin.AssertionBasedRequest#getAssertion()
	 */
	@Override
	public Assertion getAssertion() {
		return assertion;
	}

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
	@Override
	public void setAssertion(Assertion aAssertion) {
		assertion = aAssertion;
	}

}
