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
package org.ehealth_connector.security.serialization.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.utilities.impl.AbstractTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

public class AuthnRequestSerializerImplTest extends AbstractTestHelper {

	private AuthnRequestSerializerImpl testSerializer;

	private AuthnRequest testXmlObject;

	@Override
	@Before
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
	 * {@link org.ehealth_connector.security.utilities.impl.SerializerDeserializerImpl#serializeToXml(org.opensaml.xml.XMLObject)}.
	 *
	 * @throws SerializeException
	 */
	@Test(expected = SerializeException.class)
	public void testSerializeToXml_InputNull() throws SerializeException {
		testSerializer.toXmlElement(null);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl#toXmlByteArray(org.ehealth_connector.security.authentication.AuthnRequest)}.
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
	 * {@link org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl#toXmlElement(org.ehealth_connector.security.authentication.AuthnRequest)}.
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
	 * {@link org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl#toXmlString(org.ehealth_connector.security.authentication.AuthnRequest)}.
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
