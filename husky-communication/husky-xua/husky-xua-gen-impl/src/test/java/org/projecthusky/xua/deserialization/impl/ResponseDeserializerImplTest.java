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
package org.projecthusky.xua.deserialization.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.saml2.Response;
import org.projecthusky.xua.utilities.impl.AbstractTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class ResponseDeserializerImplTest extends AbstractTestHelper {

	private ResponseDeserializerImpl testDeserializer;
	private byte[] testXmlByteArray;
	private Element testXmlElement;
	private String testXmlString;

	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
		testDeserializer = new ResponseDeserializerImpl();
		testXmlByteArray = Files
				.readAllBytes(Paths.get(getClass().getResource("/saml2/Response.xml").toURI()));
		testXmlString = new String(testXmlByteArray);
		testXmlElement = new OpenSaml2DeserializerImpl<Response>()
				.deserializeFromByteArrayToXmlElement(testXmlString.getBytes());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.deserialization.impl.ResponseDeserializerImpl#fromXmlByteArray(byte[])}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlByteArray() throws DeserializeException {
		final Response ref = testDeserializer.fromXmlByteArray(testXmlByteArray);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.deserialization.impl.ResponseDeserializerImpl#fromXmlElement(org.w3c.dom.Element)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlElement() throws DeserializeException {
		final Response ref = testDeserializer.fromXmlElement(testXmlElement);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.deserialization.impl.ResponseDeserializerImpl#fromXmlString(java.lang.String)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlString() throws DeserializeException {
		final Response ref = testDeserializer.fromXmlString(testXmlString);
		assertNotNull(ref);
	}

}
