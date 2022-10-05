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
package org.projecthusky.xua.serialization.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.utilities.impl.AbstractTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class AuthnRequestSerializerImplTest extends AbstractTestHelper {

	private AuthnRequestSerializerImpl testSerializer;

	private AuthnRequest testXmlObject;

	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
		testSerializer = new AuthnRequestSerializerImpl();

		testXmlObject = new AuthnRequestBuilderImpl()//
				.id(testId)//
				.issueInstant(testIssueInstant)//
				.destination(testDestination)//
				.assertionConsumerServiceUrl(testAssertionConsumerServiceURL)//
				.providerName(testProviderName)//
				.protocolBinding(testProtocolBinding)//
				.issuer(testIssuer)//
				.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate)//
				.nameIdPolicyFormat(testNameIdPolicyFormat)//
				.create();

	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.utilities.impl.SerializerDeserializerImpl#serializeToXml(org.opensaml.xml.XMLObject)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testSerializeToXml_InputNull() throws SerializeException {
		assertThrows(SerializeException.class, () -> testSerializer.toXmlElement(null));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.AuthnRequestSerializerImpl#toXmlByteArray(org.projecthusky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlByteArray() throws SerializeException {
		final byte[] xmlArray = testSerializer.toXmlByteArray(testXmlObject);
		assertNotNull(xmlArray);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.AuthnRequestSerializerImpl#toXmlElement(org.projecthusky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlElement() throws SerializeException {

		final Element xmlElement = testSerializer.toXmlElement(testXmlObject);
		assertNotNull(xmlElement);
		assertTrue(xmlElement.hasAttribute("ID"));
		assertEquals(testId, xmlElement.getAttributeNode("ID").getValue());
		assertTrue(xmlElement.hasAttribute("AssertionConsumerServiceURL"));
		assertEquals(testAssertionConsumerServiceURL,
				xmlElement.getAttributeNode("AssertionConsumerServiceURL").getValue());
		assertTrue(xmlElement.hasAttribute("ProviderName"));
		assertEquals(testProviderName, xmlElement.getAttributeNode("ProviderName").getValue());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.AuthnRequestSerializerImpl#toXmlString(org.projecthusky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		System.out.println(xmlString);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
	}

}
