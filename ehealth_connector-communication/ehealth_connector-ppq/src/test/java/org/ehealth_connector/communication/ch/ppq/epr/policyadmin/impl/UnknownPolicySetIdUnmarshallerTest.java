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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.ehealth_connector.communication.ch.ppq.epr.policyadmin.api.OpenSamlUnknownPolicySetId;
import org.ehealth_connector.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

public class UnknownPolicySetIdUnmarshallerTest extends InitializerTestHelper {

	private Element testXmlElement;

	@BeforeEach
	public void setUp() throws Exception {
		testXmlElement = loadXmlDokument("/ch-ppq/unknown_policy_set_id.xml");
	}

	@Test
	public void test() throws UnmarshallingException, MarshallingException {
		final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport
				.getUnmarshallerFactory();
		final Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(testXmlElement);

		final XMLObject xmlObject = unmarshaller.unmarshall(testXmlElement);
		assertNotNull(xmlObject);
		assertTrue(xmlObject instanceof OpenSamlUnknownPolicySetId);
	}

}
