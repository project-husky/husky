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

import org.projecthusky.xua.communication.clients.IdpClient;
import org.projecthusky.xua.communication.clients.XuaClient;
import org.projecthusky.xua.communication.config.XuaClientConfig;
import org.projecthusky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigBuilder;
import org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientViaHttpProxyConfigBuilder;
import org.projecthusky.xua.communication.config.impl.IdpClientViaHttpProxyConfigImpl;
import org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <!-- @formatter:off -->
 * <div class="en">Testclass to test the client factory methods.</div>
 * <div class="de">Testklasse um die client factory methoden zu testen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
class ClientFactoryTest {

	private IdpClientViaHttpProxyConfigImpl testClientConfigurationHttpProxy;
	private IdpClientCertificateAuthConfigImpl testClientConfigurationAuthConfig;

	private IdpClientBasicAuthConfigImpl testClientBasicAuthConfig;
	private XuaClientConfig testClientConfigurationXua;

	public IdpClientByBrowserAndProtocolHandlerConfigImpl testIdpClientByBrowserAndProtocolHandlerConfig;

	/**
	 * setup the test parameters
	 * 
	 * @throws Exception on errors.
	 */
	@BeforeEach
	public void setUp() throws Exception {

		testClientConfigurationHttpProxy = new IdpClientViaHttpProxyConfigBuilder().create();

		testClientConfigurationAuthConfig = new IdpClientCertificateAuthConfigBuilder().create();

		testClientBasicAuthConfig = new IdpClientBasicAuthConfigBuilderImpl().create();

		testClientConfigurationXua = new XuaClientConfigBuilderImpl().create();

		testIdpClientByBrowserAndProtocolHandlerConfig = new IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl()
				.create();
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.ClientFactory#getIdpClient(org.projecthusky.xua.communication.config.IdpClientConfig)}.
	 */
	@Test
	void testGetIdpClientBasicAuth() {
		final IdpClient client = ClientFactory.getIdpClient(testClientBasicAuthConfig);
		assertNotNull(client);
		assertTrue(client instanceof IdpSoapBindingClientByBasicAuth);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.ClientFactory#getIdpClient(org.projecthusky.xua.communication.config.IdpClientConfig)}.
	 */
	@Test
	void testGetIdpClientCertificateAuth() {
		final IdpClient client = ClientFactory.getIdpClient(testClientConfigurationAuthConfig);
		assertNotNull(client);
		assertTrue(client instanceof IdpClientByCert);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.ClientFactory#getIdpClient(org.projecthusky.xua.communication.config.IdpClientConfig)}.
	 */
	@Test
	void testGetIdpClientHttpProxy() {
		final IdpClient client = ClientFactory.getIdpClient(testClientConfigurationHttpProxy);
		assertNotNull(client);
		assertTrue(client instanceof IdpClientByProxy);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.ClientFactory#getXuaClient(org.projecthusky.xua.communication.config.XuaClientConfig)}.
	 */
	@Test
	void testGetXuaClient() {
		final XuaClient client = ClientFactory.getXuaClient(testClientConfigurationXua);
		assertNotNull(client);
		assertTrue(client instanceof SimpleXuaClient);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.clients.impl.ClientFactory#getIdpClient(org.projecthusky.xua.communication.config.IdpClientConfig)}.
	 */
	@Test
	void testIdpClientByBrowserAndProtocolHandlerConfig() {
		final IdpClient client = ClientFactory.getIdpClient(testIdpClientByBrowserAndProtocolHandlerConfig);
		assertNotNull(client);
		assertTrue(client instanceof IdpClientByBrowserAndProtocolHandler);
	}

}
