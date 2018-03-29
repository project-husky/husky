/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.deserialization.impl;

import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.utilities.impl.AbstractTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

/**
 * @since Feb 21, 2018 3:06:55 PM
 *
 */
public class AuthnRequestDeserializerImplTest extends AbstractTestHelper {

	private AuthnRequestDeserializerImpl testDeserializer;
	private String testXmlString;
	private Element testXmlElement;

	/**
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();

		testDeserializer = new AuthnRequestDeserializerImpl();

		testXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<saml2p:AuthnRequest xmlns:saml2p=\"urn:oasis:names:tc:SAML:2.0:protocol\" "
				+ "AssertionConsumerServiceURL=\"https://test.it.now.ch/do/it/now/good\" "
				+ "Destination=\"https://test.soe.healthcare/idp\" " + "ID=\"296b30cf-0ffc-434d-8ea1-3117d89e631d\" "
				+ "IssueInstant=\"2018-02-21T12:49:01.539Z\" " + "ProtocolBinding=\"POST\" "
				+ "ProviderName=\"IG eHealthConnector\" " + "Version=\"2.0\">\n"
				+ "	<saml2:Issuer xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">MyIssuer</saml2:Issuer>\n"
				+ "	<saml2p:NameIDPolicy AllowCreate=\"true\" Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:transient\"/>\n"
				+ "</saml2p:AuthnRequest>";

		testXmlElement = new OpenSaml2DeserializerImpl().deserializeFromByteArrayToXmlElement(testXmlString.getBytes());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.deserialization.impl.AuthnRequestDeserializerImpl#fromXmlElement(org.w3c.dom.Element)}.
	 * 
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlElement() throws DeserializeException {
		final AuthnRequest<org.opensaml.saml2.core.AuthnRequest> ref = testDeserializer.fromXmlElement(testXmlElement);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.deserialization.impl.AuthnRequestDeserializerImpl#fromXmlElement(org.w3c.dom.Element)}.
	 * 
	 * @throws DeserializeException
	 */
	@Test(expected = DeserializeException.class)
	public void testFromXmlElement_InputNull() throws DeserializeException {
		final AuthnRequest<org.opensaml.saml2.core.AuthnRequest> ref = testDeserializer.fromXmlElement(null);
		assertNotNull(ref);
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.deserialization.impl.AuthnRequestDeserializerImpl#fromXmlString(java.lang.String)}.
	 * 
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlString() throws DeserializeException {
		final AuthnRequest<org.opensaml.saml2.core.AuthnRequest> ref = testDeserializer.fromXmlString(testXmlString);
		assertNotNull(ref);
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.deserialization.impl.AuthnRequestDeserializerImpl#fromXmlByteArray(byte[])}.
	 * 
	 * @throws DeserializeException
	 */
	@Test
	public void testFromXmlByteArray() throws DeserializeException {
		final AuthnRequest<org.opensaml.saml2.core.AuthnRequest> ref = testDeserializer
				.fromXmlByteArray(testXmlString.getBytes());
		assertNotNull(ref);
	}

}
