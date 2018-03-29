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
package org.ehealth_connector.security.deserialization.impl;

import static org.junit.Assert.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.utilities.impl.AbstractTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

public class ResponseDeserializerImplTest extends AbstractTestHelper {

	private ResponseDeserializerImpl testDeserializer;
	private String testXmlString;
	private byte[] testXmlByteArray;
	private Element testXmlElement;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		testDeserializer = new ResponseDeserializerImpl();
		testXmlByteArray = Files.readAllBytes(Paths.get(getClass().getResource("/saml2/Response.xml").toURI()));
		testXmlString = new String(testXmlByteArray);
		testXmlElement = new OpenSaml2DeserializerImpl().deserializeFromByteArrayToXmlElement(testXmlString.getBytes());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl#fromXmlElement(org.w3c.dom.Element)}.
	 * 
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlElement() throws DeserializeException {
		final Response ref = testDeserializer.fromXmlElement(testXmlElement);
		assertNotNull(ref);
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl#fromXmlString(java.lang.String)}.
	 * 
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlString() throws DeserializeException {
		final Response ref = testDeserializer.fromXmlString(testXmlString);
		assertNotNull(ref);
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl#fromXmlByteArray(byte[])}.
	 * 
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlByteArray() throws DeserializeException {
		final Response ref = testDeserializer.fromXmlByteArray(testXmlByteArray);
		assertNotNull(ref);
	}

}
