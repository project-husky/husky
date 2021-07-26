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
package org.ehealth_connector.communication.ch.ppq.epr.policyadmin.impl;

import org.ehealth_connector.communication.ch.ppq.epr.policyadmin.api.DeletePolicyRequest;
import org.ehealth_connector.communication.ch.ppq.epr.policyadmin.api.OpenSamlDeletePolicyRequest;
import org.ehealth_connector.security.saml2.Assertion;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlDeletePolicyRequest.</div>
 * <div class="de">Builder Klasse für OpenSamlDeletePolicyRequest.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class DeletePolicyRequestBuilder
		extends AbstractXMLObjectBuilder<OpenSamlDeletePolicyRequest> {

	private Assertion assertion;

	public DeletePolicyRequestBuilder assertion(Assertion aAssertion) {
		assertion = aAssertion;
		return this;
	}

	public OpenSamlDeletePolicyRequest buildObject() {
		return buildObject(DeletePolicyRequest.DEFAULT_NS_URI,
				DeletePolicyRequest.DEFAULT_ELEMENT_LOCAL_NAME, DeletePolicyRequest.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlDeletePolicyRequest buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		final OpenSamlDeletePolicyRequest abr = new DeletePolicyRequestImpl(namespaceURI, localName,
				namespacePrefix);
		if (assertion != null) {
			abr.setAssertion(assertion);
		}
		return abr;
	}
}
