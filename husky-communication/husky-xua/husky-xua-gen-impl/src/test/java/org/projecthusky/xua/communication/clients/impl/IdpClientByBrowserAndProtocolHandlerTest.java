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
package org.projecthusky.xua.communication.clients.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl;
import org.projecthusky.xua.deserialization.impl.AuthnRequestDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class IdpClientByBrowserAndProtocolHandlerTest extends ServerTestHelper {

	private static Logger logger = LoggerFactory
			.getLogger(IdpClientByBrowserAndProtocolHandlerTest.class);

	private static HttpServer server;

	@SuppressWarnings("unused")
	private static int httpPort;

	@BeforeAll
	public static void setUpBefore() throws IOException {
		final SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(15000)
				.setTcpNoDelay(true).build();

		server = ServerBootstrap.bootstrap().setServerInfo("Test/1.1").setSocketConfig(socketConfig)
				.registerHandler("*", new HttpRequestHandler() {

					@Override
					public void handle(HttpRequest request, HttpResponse response,
							HttpContext context) throws HttpException, IOException {
						logger.debug("The request %s", request.getRequestLine());
						response.setStatusCode(500);
						response.setEntity(new StringEntity("Hello this is a testserver"));
					}

				}).create();

		server.start();
		httpPort = server.getLocalPort();
	}

	@AfterAll
	public static void tearDownAfter() {
		server.stop();
	}

	private IdpClientByBrowserAndProtocolHandler client;

	private String testFilename;

	private AuthnRequest testAuthnRequest;

	/**
	 * set up test parameters
	 */
	@BeforeEach
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
	 * {@link org.projecthusky.xua.communication.clients.impl.IdpClientByBrowserAndProtocolHandler#readFromJARFile(java.lang.String)}.
	 *
	 * @throws IOException
	 */
	@Test
	void testReadFromJARFile() throws IOException {
		final String content = client.readFromJARFile(testFilename);
		assertNotNull(content);
		assertTrue(content.startsWith("org.opensaml.core.criterion.EntityIdCriterion"));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.IdpClientByBrowserAndProtocolHandler#send(org.projecthusky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws ClientSendException will be thrown if an error occoures
	 */
	@Test
	@Disabled("This test is not executable in this way.")
	void testSend() throws ClientSendException {

		final Object ref = client.send(testAuthnRequest);
		assertNotNull(ref);

	}

}
