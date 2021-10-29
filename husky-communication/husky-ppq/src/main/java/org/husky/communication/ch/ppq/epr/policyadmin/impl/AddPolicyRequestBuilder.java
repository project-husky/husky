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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import org.husky.communication.ch.ppq.epr.policyadmin.api.AddPolicyRequest;
import org.husky.communication.ch.ppq.epr.policyadmin.api.BasePolicyAdministration;
import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlAddPolicyRequest;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlAddPolicyRequest.</div>
 * <div class="de">Builder Klasse für OpenSamlAddPolicyRequest.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AddPolicyRequestBuilder extends AbstractXMLObjectBuilder<OpenSamlAddPolicyRequest> {

	private AssertionType assertion;

	public AddPolicyRequestBuilder assertion(AssertionType aAssertion) {
		assertion = aAssertion;
		return this;
	}

	public OpenSamlAddPolicyRequest buildObject() {
		return buildObject(BasePolicyAdministration.DEFAULT_NS_URI, AddPolicyRequest.DEFAULT_ELEMENT_LOCAL_NAME,
				BasePolicyAdministration.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlAddPolicyRequest buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		final OpenSamlAddPolicyRequest abr = new AddPolicyRequestImpl(namespaceURI, localName,
				namespacePrefix);
		if (assertion != null) {
			abr.setAssertion(assertion);
		}
		return abr;
	}
}
