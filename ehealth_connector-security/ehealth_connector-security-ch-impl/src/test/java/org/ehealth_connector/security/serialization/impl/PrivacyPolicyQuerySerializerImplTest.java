/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.serialization.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.hl7v3.InstanceIdentifier;
import org.ehealth_connector.security.hl7v3.impl.InstanceIdentifierBuilder;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class PrivacyPolicyQuerySerializerImplTest extends InitializerTestHelper {

	private Logger logger = LoggerFactory.getLogger(PrivacyPolicyQuerySerializerImplTest.class);

	private PrivacyPolicyQuerySerializerImpl testSerializer;
	private PrivacyPolicyQuery testXmlObject;
	private String testConsent;
	private String testDestination;
	private String testInstanceIdentifierRoot;
	private String testInstanceIdentifierExt;
	private InstanceIdentifier testInstanceIdentifier;

	@Before
	public void setUp() throws Exception {
		testSerializer = new PrivacyPolicyQuerySerializerImpl();
		testConsent = "My New Consent";
		testDestination = "https://my.destination.org/path";

		testInstanceIdentifierRoot = "2.16.756.5.30.1.127.3.10.3";
		testInstanceIdentifierExt = "761337610455909127";

		testInstanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		testInstanceIdentifier.setRoot(testInstanceIdentifierRoot);
		testInstanceIdentifier.setExtension(testInstanceIdentifierExt);

		testXmlObject = new PrivacyPolicyQueryBuilderImpl().consent(testConsent).destination(testDestination)
				.instanceIdentifier(testInstanceIdentifier).create();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.PrivacyPolicyQuerySerializerImpl#toXmlElement(org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery)}.
	 * 
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlElement() throws SerializeException {
		final Element xmlElement = testSerializer.toXmlElement(testXmlObject);
		assertNotNull(xmlElement);
		assertTrue(xmlElement.hasAttribute("Consent"));
		assertEquals(testConsent, xmlElement.getAttributeNode("Consent").getValue());
	}

	@Test(expected = SerializeException.class)
	public void testSerializeToXml_InputNull() throws SerializeException {
		testSerializer.toXmlElement(null);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.PrivacyPolicyQuerySerializerImpl#toXmlString(org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery)}.
	 * 
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		logger.debug(xmlString);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
		assertTrue(xmlString.endsWith(">"));
		assertTrue(xmlString.contains("urn:e-health-suisse:2015:epr-spid"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.PrivacyPolicyQuerySerializerImpl#toXmlByteArray(org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery)}.
	 * 
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlByteArray() throws SerializeException {
		final byte[] xmlArray = testSerializer.toXmlByteArray(testXmlObject);
		assertNotNull(xmlArray);
		final byte[] startPart = new byte["<?xml version=".length()];
		System.arraycopy(xmlArray, 0, startPart, 0, "<?xml version=".length());
		assertArrayEquals("<?xml version=".getBytes(), startPart);
	}

}
