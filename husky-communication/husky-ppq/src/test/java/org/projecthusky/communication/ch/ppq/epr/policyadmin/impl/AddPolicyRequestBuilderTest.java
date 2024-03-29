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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.OpenSamlAddPolicyRequest;
import org.projecthusky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.projecthusky.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.w3c.dom.Element;

class AddPolicyRequestBuilderTest extends InitializerTestHelper {

	private AssertionType testAssertion;

	@BeforeEach
	public void setUp() throws Exception {
		final Element testAssertionXmlElement = loadXmlDokument(
				"/ch-ppq/add_policy_request_assertion_only.xml");
		final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport
				.getUnmarshallerFactory();
		final Unmarshaller unmarshaller = unmarshallerFactory
				.getUnmarshaller(testAssertionXmlElement);
		final org.opensaml.saml.saml2.core.Assertion innerAssertion = (org.opensaml.saml.saml2.core.Assertion) unmarshaller
				.unmarshall(testAssertionXmlElement);
		testAssertion = new AssertionBuilderImpl().create(innerAssertion);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.ch.epr.policyadmin.impl.AddPolicyRequestBuilder#assertion(org.projecthusky.xua.saml2.Assertion)}.
	 */
	@Test
	void testAssertion() {
		final OpenSamlAddPolicyRequest ref = new AddPolicyRequestBuilder().assertion(testAssertion)
				.buildObject();
		assertNotNull(ref);
		assertEquals(testAssertion, ref.getAssertion());
	}

}
