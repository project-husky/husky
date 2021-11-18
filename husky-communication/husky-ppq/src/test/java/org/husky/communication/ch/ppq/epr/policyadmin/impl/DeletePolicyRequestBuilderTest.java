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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlDeletePolicyRequest;
import org.husky.communication.ch.ppq.epr.policyadmin.impl.DeletePolicyRequestBuilder;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.w3c.dom.Element;

public class DeletePolicyRequestBuilderTest extends InitializerTestHelper {

	private AssertionType testAssertion;

	@BeforeEach
	public void setUp() throws Exception {
		final Element testAssertionXmlElement = loadXmlDokument(
				"/ch-ppq/delete_policy_request_assertion_only.xml");
		final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport
				.getUnmarshallerFactory();
		final Unmarshaller unmarshaller = unmarshallerFactory
				.getUnmarshaller(testAssertionXmlElement);
		final org.opensaml.saml.saml2.core.Assertion innerAssertion = (org.opensaml.saml.saml2.core.Assertion) unmarshaller
				.unmarshall(testAssertionXmlElement);
		testAssertion = new AssertionBuilderImpl().create(innerAssertion);
	}

	@Test
	public void testAssertion() {
		final OpenSamlDeletePolicyRequest ref = new DeletePolicyRequestBuilder()
				.assertion(testAssertion).buildObject();
		assertNotNull(ref);
		assertEquals(testAssertion, ref.getAssertion());
	}

}
