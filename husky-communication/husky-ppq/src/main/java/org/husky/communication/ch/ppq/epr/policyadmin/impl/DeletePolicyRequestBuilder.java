/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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

import org.husky.communication.ch.ppq.epr.policyadmin.api.BasePolicyAdministration;
import org.husky.communication.ch.ppq.epr.policyadmin.api.DeletePolicyRequest;
import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlDeletePolicyRequest;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
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

	private AssertionType assertion;

	public DeletePolicyRequestBuilder assertion(AssertionType aAssertion) {
		assertion = aAssertion;
		return this;
	}

	public OpenSamlDeletePolicyRequest buildObject() {
		return buildObject(BasePolicyAdministration.DEFAULT_NS_URI, DeletePolicyRequest.DEFAULT_ELEMENT_LOCAL_NAME,
				BasePolicyAdministration.DEFAULT_PREFIX);
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
