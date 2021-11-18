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
package org.husky.communication.ch.ppq.impl.deserialization;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.husky.xua.deserialization.impl.OpenSaml2DeserializerImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

public class PrivacyPolicyQueryResponseDeserialiserTest extends InitializerTestHelper {

	private PrivacyPolicyQueryResponseDeserialiser testDeserializer;
	private byte[] testXmlByteArray;
	private Element testXmlElement;
	private String testXmlString;

	@BeforeEach
	public void setUp() throws Exception {
		testDeserializer = new PrivacyPolicyQueryResponseDeserialiser();
		testXmlByteArray = Files.readAllBytes(Paths
				.get(getClass().getResource("/xacml/xacml_policy_query_response.xml").toURI()));
		testXmlString = new String(testXmlByteArray);
		testXmlElement = new OpenSaml2DeserializerImpl<PrivacyPolicyQueryResponse>()
				.deserializeFromByteArrayToXmlElement(testXmlString.getBytes());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyQueryResponseDeserialiser#fromXmlByteArray(byte[])}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlByteArray() throws DeserializeException {
		final PrivacyPolicyQueryResponse ref = testDeserializer.fromXmlByteArray(testXmlByteArray);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyQueryResponseDeserialiser#fromXmlElement(org.w3c.dom.Element)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlElement() throws DeserializeException {
		final PrivacyPolicyQueryResponse ref = testDeserializer.fromXmlElement(testXmlElement);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyQueryResponseDeserialiser#fromXmlString(java.lang.String)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlString() throws DeserializeException {
		final PrivacyPolicyQueryResponse ref = testDeserializer.fromXmlString(testXmlString);
		assertNotNull(ref);
	}

}
