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

import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigBuilder;
import org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.projecthusky.xua.deserialization.impl.AuthnRequestDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.pki.impl.PkiManagerImpl;
import org.projecthusky.xua.saml2.Response;
import org.projecthusky.xua.utilities.impl.InitializerTestHelper;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.ssl.TrustSelfSignedStrategy;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.ssl.SSLContexts;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		InitializerTestHelper.setUpBeforeClass();
		final SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(15000, TimeUnit.MILLISECONDS)
				.setTcpNoDelay(true).build();

		final URL url = IdpClientByCertTest.class.getResource("/testserver.p12");
		if (url != null) {

			final SSLContext sslContext = SSLContexts.custom()//
					.loadKeyMaterial(url, "changeit".toCharArray(), "changeit".toCharArray())//
					.loadTrustMaterial(url, "changeit".toCharArray(),
							TrustSelfSignedStrategy.INSTANCE)//
					.build();

			server = ServerBootstrap.bootstrap()//
//					.setServerInfo("Test/1.1")//
					.setSocketConfig(socketConfig)//
					.setSslContext(sslContext)//
					.setSslSetupHandler(socket -> socket.setNeedClientAuth(true))//
					.register("*", new HttpRequestHandler() {

						@Override
						public void handle(ClassicHttpRequest request, ClassicHttpResponse response,
								HttpContext context) throws HttpException, IOException {
							logger.debug("The request %s", request.getRequestUri());
							response.setCode(500);
							response.setEntity(new StringEntity("Hello this is a testserver"));
						}

					}).create();

			server.start();
			httpPort = server.getLocalPort();

		} else {
			logger.error("Keystore not found");
		}

	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		server.stop();
	}

	private IdpClientCertificateAuthConfigImpl clientConfig;

	private AuthnRequest testAuthnRequest;

	private KeyStore testClientKeyStore;

	@BeforeEach
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
	 * {@link org.projecthusky.xua.communication.clients.impl.IdpClientByCert#getHttpClient()}.
	 *
	 * @throws ClientSendException
	 */
	@Test
	void testGetHttpClient() throws ClientSendException {
		final IdpClientByCert icbc = new IdpClientByCert(clientConfig);
		final CloseableHttpClient httpClient = icbc.getHttpClient();
		assertNotNull(httpClient);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.IdpClientByCert#getRequestConfig()}.
	 */
	@Test
	void testGetRequestConfig() {
		final IdpClientByCert icbc = new IdpClientByCert(clientConfig);
		final RequestConfig requestConfig = icbc.getRequestConfig();
		assertNotNull(requestConfig);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.IdpClientByCert#send(org.projecthusky.xua.authentication.AuthnRequest)}.
	 *
	 * @throws ClientSendException will be thrown if an error occures.
	 */
	@Test
	@Disabled("TODO: client/server ssl stuff has to be resolved.")
	void testSend() throws ClientSendException {
		final IdpClientByCert icbc = new IdpClientByCert(clientConfig);
		final Response resp = icbc.send(testAuthnRequest);
		assertNotNull(resp);
	}

}
