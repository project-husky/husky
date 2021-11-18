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
