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

import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

public class XUserAssertionRequestSerializerImplTest {

	private XUserAssertionRequestSerializerImpl testSerializer;
	private XUserAssertionRequest testXmlObject;
	private String testContext;
	private String testDialect;

	@Before
	public void setUp() throws Exception {
		testSerializer = new XUserAssertionRequestSerializerImpl();

		testDialect = "http://bag.admin.ch/epr/2017/annex/5/addendum/2";
		testContext = "This is my Context";

		testXmlObject = new XUserAssertionRequestBuilderImpl()//
				.context(testContext)//
				.dialect(testDialect)//
				.create();
	}

	@Test(expected = SerializeException.class)
	public void testSerializeToXml_InputNull() throws SerializeException {
		testSerializer.toXmlElement(null);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.XUserAssertionRequestSerializerImpl#toXmlByteArray(org.ehealth_connector.security.communication.xua.XUserAssertionRequest)}.
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

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.XUserAssertionRequestSerializerImpl#toXmlElement(org.ehealth_connector.security.communication.xua.XUserAssertionRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlElement() throws SerializeException {
		final Element xmlElement = testSerializer.toXmlElement(testXmlObject);
		assertNotNull(xmlElement);
		assertTrue(xmlElement.hasAttribute("Context"));
		assertEquals(testContext, xmlElement.getAttributeNode("Context").getValue());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.impl.XUserAssertionRequestSerializerImpl#toXmlString(org.ehealth_connector.security.communication.xua.XUserAssertionRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	public void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		System.out.println(xmlString);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
		assertTrue(xmlString.endsWith(">"));
	}

}
