/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlUpdatePolicyRequest;
import org.ehealth_connector.security.ch.epr.policyadmin.UpdatePolicyRequest;
import org.ehealth_connector.security.saml2.Assertion;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlUpdatePolicyRequest.</div>
 * <div class="de">Builder Klasse für OpenSamlUpdatePolicyRequest.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class UpdatePolicyRequestBuilder extends AbstractXMLObjectBuilder<OpenSamlUpdatePolicyRequest> {

	private Assertion assertion;

	public UpdatePolicyRequestBuilder assertion(Assertion aAssertion) {
		assertion = aAssertion;
		return this;
	}

	public OpenSamlUpdatePolicyRequest buildObject() {
		return buildObject(UpdatePolicyRequest.DEFAULT_NS_URI, UpdatePolicyRequest.DEFAULT_ELEMENT_LOCAL_NAME,
				UpdatePolicyRequest.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlUpdatePolicyRequest buildObject(String namespaceURI, String localName, String namespacePrefix) {
		final OpenSamlUpdatePolicyRequest abr = new UpdatePolicyRequestImpl(namespaceURI, localName, namespacePrefix);
		if (assertion != null) {
			abr.setAssertion(assertion);
		}
		return abr;
	}
}
