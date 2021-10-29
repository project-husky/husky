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
package org.husky.xua.serialization.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.serialization.impl.AuthnRequestSerializerImpl;
import org.husky.xua.utilities.impl.AbstractTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

public class AuthnRequestSerializerImplTest extends AbstractTestHelper {

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
	 * {@link org.husky.xua.utilities.impl.SerializerDeserializerImpl#serializeToXml(org.opensaml.xml.XMLObject)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testSerializeToXml_InputNull() throws SerializeException {
		assertThrows(SerializeException.class, () -> testSerializer.toXmlElement(null));
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.serialization.impl.AuthnRequestSerializerImpl#toXmlByteArray(org.husky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlByteArray() throws SerializeException {
		final byte[] xmlArray = testSerializer.toXmlByteArray(testXmlObject);
		assertNotNull(xmlArray);
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.serialization.impl.AuthnRequestSerializerImpl#toXmlElement(org.husky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlElement() throws SerializeException {

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
	 * {@link org.husky.xua.serialization.impl.AuthnRequestSerializerImpl#toXmlString(org.husky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		System.out.println(xmlString);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
	}

}
