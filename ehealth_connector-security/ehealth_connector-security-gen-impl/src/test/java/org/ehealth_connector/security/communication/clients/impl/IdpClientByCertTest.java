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

import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.ssl.SSLContexts;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.config.impl.IdpClientCertificateAuthConfigBuilder;
import org.ehealth_connector.security.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.ehealth_connector.security.deserialization.impl.AuthnRequestDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.pki.impl.PkiManagerImpl;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 * Testclass to test the IdpClientByCert
 */
public class IdpClientByCertTest extends InitializerTestHelper {

	private static Logger logger = LoggerFactory.getLogger(ServerTestHelper.class);

	private static HttpServer server;

	private static int httpPort;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitializerTestHelper.setUpBeforeClass();
		final SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(15000)
				.setTcpNoDelay(true).build();

		final URL url = IdpClientByCertTest.class.getResource("/testserver.p12");
		if (url != null) {

			final SSLContext sslContext = SSLContexts.custom()//
					.loadKeyMaterial(url, "changeit".toCharArray(), "changeit".toCharArray())//
					.loadTrustMaterial(url, "changeit".toCharArray(),
							TrustSelfSignedStrategy.INSTANCE)//
					.build();

			server = ServerBootstrap.bootstrap()//
					.setServerInfo("Test/1.1")//
					.setSocketConfig(socketConfig)//
					.setSslContext(sslContext)//
					.setSslSetupHandler(socket -> socket.setNeedClientAuth(true))//
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

		} else {
			logger.error("Keystore not found");
		}

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		server.stop();
	}

	private IdpClientCertificateAuthConfigImpl clientConfig;

	private AuthnRequest testAuthnRequest;

	private KeyStore testClientKeyStore;

	@Before
	public void setUp() throws Exception {

		testClientKeyStore = new PkiManagerImpl().loadStore(
				this.getClass().getResourceAsStream("/testKeystore.p12"), "changeit", "pkcs12");

		clientConfig = new IdpClientCertificateAuthConfigBuilder()//
				.url("https://localhost:" + httpPort + "/idp/authn")//
				.keyStore(testClientKeyStore)//
				.keyStorePassword("changeit")//
				.create();

		final Element xmlElement = loadXmlDokument("/saml2/AuthnRequest.xml");
		testAuthnRequest = new AuthnRequestDeserializerImpl().fromXmlElement(xmlElement);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.IdpClientByCert#getHttpClient()}.
	 *
	 * @throws ClientSendException
	 */
	@Test
	public void testGetHttpClient() throws ClientSendException {
		final IdpClientByCert icbc = new IdpClientByCert(clientConfig);
		final CloseableHttpClient httpClient = icbc.getHttpClient();
		assertNotNull(httpClient);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.IdpClientByCert#getRequestConfig()}.
	 */
	@Test
	public void testGetRequestConfig() {
		final IdpClientByCert icbc = new IdpClientByCert(clientConfig);
		final RequestConfig requestConfig = icbc.getRequestConfig();
		assertNotNull(requestConfig);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.IdpClientByCert#send(org.ehealth_connector.security.authentication.AuthnRequest)}.
	 *
	 * @throws ClientSendException
	 */
	@Test
	@Ignore("TODO: client/server ssl stuff has to be resolved.")
	public void testSend() throws ClientSendException {
		final IdpClientByCert icbc = new IdpClientByCert(clientConfig);
		final Response resp = icbc.send(testAuthnRequest);
		assertNotNull(resp);
	}

}
