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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilderFactory;

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.husky.xua.exceptions.DeserializeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Disabled
class PrivacyPolicyFeedDeserialiserTest extends InitializerTestHelper {

	private Logger mLogger = LoggerFactory.getLogger(getClass());

	private String testAddPolAssertionId;
	private String testDelPolAssertionId;
	private PrivacyPolicyFeedDeserialiser testDeserializer;
	private String testUpdPolAssertionId;

	private byte[] testXmlByteArrayAddPol;
	private byte[] testXmlByteArrayDelPol;
	private byte[] testXmlByteArrayUpdPol;

	private Element testXmlElementAddPol;
	private Element testXmlElementDelPol;
	private Element testXmlElementUpdPol;

	private String testXmlStringAddPol;
	private String testXmlStringDelPol;
	private String testXmlStringUpdPol;

	private Element getAssertionAsElement(byte[] xmlByteArray) throws DeserializeException {
		try {
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			final Document doc = dbf.newDocumentBuilder().newDocument();
			// marshaller.marshal(wsAssertion, doc);
			return doc.getDocumentElement();
		} catch (final Exception e) {
			mLogger.error("error in deserializing to Element.", e);
			throw new DeserializeException(e);
		}
	}

	@BeforeEach
	public void setUp() throws Exception {
		testDeserializer = new PrivacyPolicyFeedDeserialiser();
		testXmlByteArrayAddPol = Files.readAllBytes(Paths.get(
				getClass().getResource("/ch-ppq/add_policy_request_assertion_only.xml").toURI()));
		testXmlStringAddPol = new String(testXmlByteArrayAddPol);

		testXmlElementAddPol = getAssertionAsElement(Files.readAllBytes(
				Paths.get(getClass().getResource("/ch-ppq/add_policy_request.xml").toURI())));

		testXmlByteArrayUpdPol = Files.readAllBytes(Paths.get(getClass()
				.getResource("/ch-ppq/update_policy_request_assertion_only.xml").toURI()));
		testXmlStringUpdPol = new String(testXmlByteArrayAddPol);
		testXmlElementUpdPol = getAssertionAsElement(Files.readAllBytes(
				Paths.get(getClass().getResource("/ch-ppq/update_policy_request.xml").toURI())));

		testXmlByteArrayDelPol = Files.readAllBytes(Paths.get(getClass()
				.getResource("/ch-ppq/delete_policy_request_assertion_only.xml").toURI()));
		testXmlStringDelPol = new String(testXmlByteArrayDelPol);
		testXmlElementDelPol = getAssertionAsElement(Files.readAllBytes(
				Paths.get(getClass().getResource("/ch-ppq/delete_policy_request.xml").toURI())));

		testAddPolAssertionId = "_b882d240-45cd-4fa3-aa9f-65394115d0e0";
		testUpdPolAssertionId = "_b882d240-45cd-4fa3-aa9f-65394115d0e0";
		testDelPolAssertionId = "_9a71a18c-d7a7-4931-9168-150a8fbc5dc2";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlByteArray(byte[])}.
	 */
	@Test
	void testFromXmlByteArrayAddPol() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlByteArray(testXmlByteArrayAddPol);
		assertNotNull(ref);
		assertEquals(testAddPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlByteArray(byte[])}.
	 */
	@Test
	void testFromXmlByteArrayDelPol() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlByteArray(testXmlByteArrayDelPol);
		assertNotNull(ref);
		assertEquals(testDelPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlByteArray(byte[])}.
	 */
	@Test
	void testFromXmlByteArrayUpdPol() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlByteArray(testXmlByteArrayUpdPol);
		assertNotNull(ref);
		assertEquals(testUpdPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlElement(org.w3c.dom.Element)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlElementAddPolicy() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlElement(testXmlElementAddPol);
		assertNotNull(ref);
		assertEquals(testAddPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlElement(org.w3c.dom.Element)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlElementDeletePolicy() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlElement(testXmlElementDelPol);
		assertNotNull(ref);
		assertEquals(testDelPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlElement(org.w3c.dom.Element)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlElementUpdatePolicy() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlElement(testXmlElementUpdPol);
		assertNotNull(ref);
		assertEquals(testUpdPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlString(java.lang.String)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlStringAddPol() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlString(testXmlStringAddPol);
		assertNotNull(ref);
		assertEquals(testAddPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlString(java.lang.String)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlStringDelPol() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlString(testXmlStringDelPol);
		assertNotNull(ref);
		assertEquals(testDelPolAssertionId, ref.getAssertion().getID());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.deserialization.impl.PrivacyPolicyFeedDeserialiser#fromXmlString(java.lang.String)}.
	 *
	 * @throws DeserializeException
	 */
	@Test
	void testFromXmlStringUpdPol() throws DeserializeException {
		final PrivacyPolicyFeed ref = testDeserializer.fromXmlString(testXmlStringUpdPol);
		assertNotNull(ref);
		assertEquals(testUpdPolAssertionId, ref.getAssertion().getID());
	}

}
