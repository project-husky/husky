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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlUpdatePolicyRequest;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

class UpdatePolicyRequestUnmarshallerTest extends InitializerTestHelper {

	private Element testXmlElement;

	@BeforeEach
	public void setUp() throws Exception {
		testXmlElement = loadXmlDokument("/ch-ppq/update_policy_request.xml");
	}

	@Test
	void test() throws UnmarshallingException, MarshallingException {
		final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport
				.getUnmarshallerFactory();
		final Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(testXmlElement);
		final XMLObject xmlObject = unmarshaller.unmarshall(testXmlElement);
		assertNotNull(xmlObject);
		assertTrue(xmlObject instanceof OpenSamlUpdatePolicyRequest);
	}

}
