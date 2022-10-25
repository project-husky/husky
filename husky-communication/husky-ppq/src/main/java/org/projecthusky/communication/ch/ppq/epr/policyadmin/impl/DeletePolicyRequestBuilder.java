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
package org.projecthusky.communication.ch.ppq.epr.policyadmin.impl;

import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.DeletePolicyRequest;
import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.OpenSamlDeletePolicyRequest;
import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.PolicyAdministrationConstants;
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
		return buildObject(PolicyAdministrationConstants.DEFAULT_NS_URI, DeletePolicyRequest.DEFAULT_ELEMENT_LOCAL_NAME,
				PolicyAdministrationConstants.DEFAULT_PREFIX);
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
