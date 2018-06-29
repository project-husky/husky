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
package org.ehealth_connector.security.communication.clients.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl;
import org.ehealth_connector.security.deserialization.impl.AuthnRequestDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.saml2.Response;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public class IdpClientByBrowserAndProtocolHandlerTest extends ServerTestHelper {

	private IdpClientByBrowserAndProtocolHandler client;
	private String testFilename;

	private AuthnRequest testAuthnRequest;

	private Response testResponse;

	/**
	 * set up test parameters
	 */
	@Before
	public void setUp() throws Exception {

		testFilename = "/credential-criteria-registry.properties";

		client = new IdpClientByBrowserAndProtocolHandler(
				new IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl()
						.url("http://localhost:" + getHttpPort() + "/testit").create());
		final Element xmlElement = loadXmlDokument("/saml2/AuthnRequest.xml");
		testAuthnRequest = new AuthnRequestDeserializerImpl().fromXmlElement(xmlElement);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.IdpClientByBrowserAndProtocolHandler#readFromJARFile(java.lang.String)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testReadFromJARFile() throws IOException {
		final String content = client.readFromJARFile(testFilename);
		assertNotNull(content);
		assertTrue(content.startsWith("org.opensaml.core.criterion.EntityIdCriterion"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.IdpClientByBrowserAndProtocolHandler#send(org.ehealth_connector.security.authentication.AuthnRequest)}.
	 * 
	 * @throws ClientSendException
	 */
	@Test
	@Ignore("This test is not executable in this way.")
	public void testSend() throws ClientSendException {

		final Response ref = client.send(testAuthnRequest);
		assertNotNull(ref);

	}

}
