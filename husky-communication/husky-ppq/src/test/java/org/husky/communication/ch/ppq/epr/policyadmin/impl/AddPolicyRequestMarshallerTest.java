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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlAddPolicyRequest;
import org.husky.communication.ch.ppq.epr.policyadmin.impl.AddPolicyRequestBuilder;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.w3c.dom.Element;

public class AddPolicyRequestMarshallerTest extends InitializerTestHelper {

	private OpenSamlAddPolicyRequest testAddPolicyRequest;

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

		final AssertionType assertion = new AssertionBuilderImpl().create(innerAssertion);
		testAddPolicyRequest = new AddPolicyRequestBuilder().assertion(assertion).buildObject();

	}

	@Test
	public void testMarshall() throws MarshallingException {
		final MarshallerFactory marshallerFactory = XMLObjectProviderRegistrySupport
				.getMarshallerFactory();
		final Marshaller marshaller = marshallerFactory.getMarshaller(testAddPolicyRequest);

		final Element serialized = marshaller.marshall(testAddPolicyRequest);
		assertNotNull(serialized);
	}

}
