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
package org.husky.xua.communication.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigBuilder;
import org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdpClientViaHttpProxyConfigBuilderTest {

	private IdpClientViaHttpProxyConfigBuilder builder;
	private String testEnpointUrl;
	private String testProxyHost;
	private int testProxyPort;
	private String testProxyProtocol;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new IdpClientViaHttpProxyConfigBuilder();
		testEnpointUrl = "http://fed.hin.ch/saml/2.0/epd/";
		testProxyHost = "localhost";
		testProxyPort = 12345;
		testProxyProtocol = "smile";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#proxyHost(java.lang.String)}.
	 */
	@Test
	void testProxyHost() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.proxyHost(testProxyHost).create();
		assertNotNull(ref);
		assertEquals(testProxyHost, ref.getProxyHost());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#proxyPort(int)}.
	 */
	@Test
	void testProxyPort() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.proxyPort(testProxyPort).create();
		assertNotNull(ref);
		assertEquals(testProxyPort, ref.getProxyPort());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#proxyProtocol(java.lang.String)}.
	 */
	@Test
	void testProxyProtocol() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.proxyProtocol(testProxyProtocol)
				.create();
		assertNotNull(ref);
		assertEquals(testProxyProtocol, ref.getProxyProtocol());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#url(java.lang.String)}.
	 */
	@Test
	void testUrl() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.url(testEnpointUrl).create();
		assertNotNull(ref);
		assertEquals(testEnpointUrl, ref.getUrl());
	}

}
