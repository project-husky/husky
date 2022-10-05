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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.impl.AttributeBuilderImpl;
import org.projecthusky.xua.utilities.impl.AbstractTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

class AttributeSerializerImplTest extends AbstractTestHelper {

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
	 * {@link org.projecthusky.xua.serialization.impl.AttributeSerializerImpl#toXmlByteArray(org.projecthusky.xua.saml2.Attribute)}.
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
	 * {@link org.projecthusky.xua.serialization.impl.AttributeSerializerImpl#toXmlElement(org.projecthusky.xua.saml2.Attribute)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlElement() throws SerializeException {
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
	 * {@link org.projecthusky.xua.serialization.impl.AttributeSerializerImpl#toXmlString(org.projecthusky.xua.saml2.Attribute)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
	}

}
