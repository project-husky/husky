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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.communication.ch.ppq.epr.policyadmin.api.UpdatePolicyRequest;
import org.ehealth_connector.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.ehealth_connector.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.Before;
import org.junit.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.w3c.dom.Element;

public class UpdatePolicyRequestImplTest extends InitializerTestHelper {

	private AssertionType testAssertion;

	@Before
	public void setUp() throws Exception {
		final Element testAssertionXmlElement = loadXmlDokument(
				"/ch-ppq/update_policy_request_assertion_only.xml");
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
		final UpdatePolicyRequest ref = new UpdatePolicyRequestBuilder().assertion(testAssertion)
				.buildObject();
		assertNotNull(ref);
		assertEquals(testAssertion, ref.getAssertion());
	}

}
