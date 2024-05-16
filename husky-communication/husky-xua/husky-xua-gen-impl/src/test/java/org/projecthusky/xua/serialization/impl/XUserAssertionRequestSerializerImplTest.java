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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.projecthusky.xua.communication.xua.XUserAssertionRequest;
import org.projecthusky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.projecthusky.xua.exceptions.SerializeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.w3c.dom.Element;

class XUserAssertionRequestSerializerImplTest {

	private String testContext;
	private String testDialect;
	private XUserAssertionRequestSerializerImpl testSerializer;
	private XUserAssertionRequest testXmlObject;

	@BeforeEach
	public void setUp() throws Exception {
		testSerializer = new XUserAssertionRequestSerializerImpl();

		testDialect = "http://www.bag.admin.ch/epr/2017/annex/5/amendment/2";
		testContext = "This is my Context";
		
		InitializationService.initialize();

		testXmlObject = new XUserAssertionRequestBuilderImpl()//
				.context(testContext)//
				.dialect(testDialect)//
				.create();
	}

	@Test
	void testSerializeToXml_InputNull() throws SerializeException {
		assertThrows(SerializeException.class, () -> testSerializer.toXmlElement(null));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.XUserAssertionRequestSerializerImpl#toXmlByteArray(org.projecthusky.xua.communication.xua.XUserAssertionRequest)}.
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
	 * {@link org.projecthusky.xua.serialization.impl.XUserAssertionRequestSerializerImpl#toXmlElement(org.projecthusky.xua.communication.xua.XUserAssertionRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlElement() throws SerializeException {
		final Element xmlElement = testSerializer.toXmlElement(testXmlObject);
		assertNotNull(xmlElement);
		assertTrue(xmlElement.hasAttribute("Context"));
		assertEquals(testContext, xmlElement.getAttributeNode("Context").getValue());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.serialization.impl.XUserAssertionRequestSerializerImpl#toXmlString(org.projecthusky.xua.communication.xua.XUserAssertionRequest)}.
	 *
	 * @throws SerializeException
	 */
	@Test
	void testToXmlString() throws SerializeException {
		final String xmlString = testSerializer.toXmlString(testXmlObject);
		System.out.println(xmlString);
		assertNotNull(xmlString);
		assertTrue(xmlString.startsWith("<?xml version="));
		assertTrue(xmlString.endsWith(">"));
	}

}
