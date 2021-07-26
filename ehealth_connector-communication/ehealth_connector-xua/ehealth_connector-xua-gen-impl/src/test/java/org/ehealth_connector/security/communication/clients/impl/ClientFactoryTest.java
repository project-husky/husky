/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

import org.ehealth_connector.security.communication.clients.IdpClient;
import org.ehealth_connector.security.communication.clients.XuaClient;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.ehealth_connector.security.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.security.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl;
import org.ehealth_connector.security.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.ehealth_connector.security.communication.config.impl.IdpClientCertificateAuthConfigBuilder;
import org.ehealth_connector.security.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigBuilder;
import org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigImpl;
import org.ehealth_connector.security.communication.config.impl.XuaClientConfigBuilderImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * <!-- @formatter:off -->
 * <div class="en">Testclass to test the client factory methods.</div>
 * <div class="de">Testklasse um die client factory methoden zu testen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ClientFactoryTest {

	private IdpClientViaHttpProxyConfigImpl testClientConfigurationHttpProxy;
	private IdpClientCertificateAuthConfigImpl testClientConfigurationAuthConfig;

	private IdpClientBasicAuthConfigImpl testClientBasicAuthConfig;
	private XuaClientConfig testClientConfigurationXua;

	public IdpClientByBrowserAndProtocolHandlerConfigImpl testIdpClientByBrowserAndProtocolHandlerConfig;

	/**
	 * setup the test parameters
	 */
	@Before
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
	 * {@link org.ehealth_connector.security.communication.clients.impl.ClientFactory#getIdpClient(org.ehealth_connector.security.communication.config.IdpClientConfig)}.
	 */
	@Test
	public void testGetIdpClientBasicAuth() {
		final IdpClient client = ClientFactory.getIdpClient(testClientBasicAuthConfig);
		assertNotNull(client);
		assertTrue(client instanceof IdpSoapBindingClientByBasicAuth);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.ClientFactory#getIdpClient(org.ehealth_connector.security.communication.config.IdpClientConfig)}.
	 */
	@Test
	public void testGetIdpClientCertificateAuth() {
		final IdpClient client = ClientFactory.getIdpClient(testClientConfigurationAuthConfig);
		assertNotNull(client);
		assertTrue(client instanceof IdpClientByCert);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.ClientFactory#getIdpClient(org.ehealth_connector.security.communication.config.IdpClientConfig)}.
	 */
	@Test
	public void testGetIdpClientHttpProxy() {
		final IdpClient client = ClientFactory.getIdpClient(testClientConfigurationHttpProxy);
		assertNotNull(client);
		assertTrue(client instanceof IdpClientByProxy);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.ClientFactory#getXuaClient(org.ehealth_connector.security.communication.config.XuaClientConfig)}.
	 */
	@Test
	public void testGetXuaClient() {
		final XuaClient client = ClientFactory.getXuaClient(testClientConfigurationXua);
		assertNotNull(client);
		assertTrue(client instanceof SimpleXuaClient);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.clients.impl.ClientFactory#getIdpClient(org.ehealth_connector.security.communication.config.IdpClientConfig)}.
	 */
	@Test
	public void testIdpClientByBrowserAndProtocolHandlerConfig() {
		final IdpClient client = ClientFactory
				.getIdpClient(testIdpClientByBrowserAndProtocolHandlerConfig);
		assertNotNull(client);
		assertTrue(client instanceof IdpClientByBrowserAndProtocolHandler);
	}

}
