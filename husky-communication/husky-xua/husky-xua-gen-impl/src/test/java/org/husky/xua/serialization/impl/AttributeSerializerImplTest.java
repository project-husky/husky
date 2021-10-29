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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.impl.AttributeBuilderImpl;
import org.husky.xua.serialization.impl.AttributeSerializerImpl;
import org.husky.xua.utilities.impl.AbstractTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AttributeSerializerImplTest extends AbstractTestHelper {

	private AttributeSerializerImpl testSerializer;

	private AttributeType testXmlObject;

	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
		testSerializer = new AttributeSerializerImpl();

		testXmlObject = new AttributeBuilderImpl().name(testAttributeName).value(testAttributeValue)
				.create();
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.serialization.impl.AttributeSerializerImpl#toXmlByteArray(org.husky.xua.saml2.Attribute)}.
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
	 * {@link org.husky.xua.serialization.impl.AttributeSerializerImpl#toXmlElement(org.husky.xua.saml2.Attribute)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlElement() throws SerializeException {
		final Element xmlElement = testSerializer.toXmlElement(testXmlObject);
		assertNotNull(xmlElement);
		assertTrue(xmlElement.hasAttribute("Name"));
		assertEquals(testAttributeName, xmlElement.getAttributeNode("Name").getValue());
		final Node firstChild = xmlElement.getFirstChild();
		assertNotNull(firstChild);
		assertEquals(testAttributeValue, firstChild.getTextContent());

	}

	/**
	 * Test method for
	 * {@link org.husky.xua.serialization.impl.AttributeSerializerImpl#toXmlString(org.husky.xua.saml2.Attribute)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
	}

}
