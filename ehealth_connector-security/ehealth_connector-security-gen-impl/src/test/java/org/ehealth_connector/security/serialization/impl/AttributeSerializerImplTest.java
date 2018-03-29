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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.impl.AttributeBuilderImpl;
import org.ehealth_connector.security.utilities.impl.AbstractTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AttributeSerializerImplTest extends AbstractTestHelper {

	private AttributeSerializerImpl testSerializer;

	private Attribute testXmlObject;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		testSerializer = new AttributeSerializerImpl();

		testXmlObject = new AttributeBuilderImpl().name(testAttributeName).value(testAttributeValue).create();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.AttributeSerializerImpl#toXmlElement(org.ehealth_connector.security.saml2.Attribute)}.
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
	 * {@link org.ehealth_connector.security.serialization.impl.AttributeSerializerImpl#toXmlString(org.ehealth_connector.security.saml2.Attribute)}.
	 * 
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.AttributeSerializerImpl#toXmlByteArray(org.ehealth_connector.security.saml2.Attribute)}.
	 * 
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlByteArray() throws SerializeException {
		final byte[] xmlArray = testSerializer.toXmlByteArray(testXmlObject);
		assertNotNull(xmlArray);
	}

}
