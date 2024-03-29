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
package org.projecthusky.communication.ch.ppq.impl.serialization;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.projecthusky.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.projecthusky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.hl7v3.InstanceIdentifier;
import org.projecthusky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

class PrivacyPolicyQuerySerializerImplTest extends InitializerTestHelper {

	private Logger logger = LoggerFactory.getLogger(PrivacyPolicyQuerySerializerImplTest.class);

	private String testConsent;
	private String testDestination;
	private InstanceIdentifier testInstanceIdentifier;
	private String testInstanceIdentifierExt;
	private String testInstanceIdentifierRoot;
	private PrivacyPolicyQuerySerializerImpl testSerializer;
	private PrivacyPolicyQuery testXmlObject;

	@BeforeEach
	public void setUp() throws Exception {
		testSerializer = new PrivacyPolicyQuerySerializerImpl();
		testConsent = "My New Consent";
		testDestination = "https://my.destination.org/path";

		testInstanceIdentifierRoot = "2.16.756.5.30.1.127.3.10.3";
		testInstanceIdentifierExt = "761337610455909127";

		testInstanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		testInstanceIdentifier.setRoot(testInstanceIdentifierRoot);
		testInstanceIdentifier.setExtension(testInstanceIdentifierExt);

		testXmlObject = new PrivacyPolicyQueryBuilderImpl().consent(testConsent)
				.destination(testDestination).instanceIdentifier(testInstanceIdentifier).create();
	}

	@Test
	void testSerializeToXml_InputNull() throws SerializeException {
		assertThrows(SerializeException.class, () -> testSerializer.toXmlElement(null));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.PrivacyPolicyQuerySerializerImpl#toXmlByteArray(org.projecthusky.xua.ch.ppq.PrivacyPolicyQuery)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlByteArray() throws SerializeException {
		final byte[] xmlArray = testSerializer.toXmlByteArray(testXmlObject);
		assertNotNull(xmlArray);
		final byte[] startPart = new byte["<?xml version=".length()];
		System.arraycopy(xmlArray, 0, startPart, 0, "<?xml version=".length());
		assertArrayEquals("<?xml version=".getBytes(), startPart);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.PrivacyPolicyQuerySerializerImpl#toXmlElement(org.projecthusky.xua.ch.ppq.PrivacyPolicyQuery)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlElement() throws SerializeException {
		final Element xmlElement = testSerializer.toXmlElement(testXmlObject);
		assertNotNull(xmlElement);
		assertTrue(xmlElement.hasAttribute("Consent"));
		assertEquals(testConsent, xmlElement.getAttributeNode("Consent").getValue());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.PrivacyPolicyQuerySerializerImpl#toXmlString(org.projecthusky.xua.ch.ppq.PrivacyPolicyQuery)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		logger.debug(xmlString);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
		assertTrue(xmlString.endsWith(">"));
		assertTrue(xmlString.contains("urn:e-health-suisse:2015:epr-spid"));
	}

}
