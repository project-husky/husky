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
package org.ehealth_connector.security.communication.config.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class IdpClientViaHttpProxyConfigBuilderTest {

	private IdpClientViaHttpProxyConfigBuilder builder;
	private String testEnpointUrl;
	private String testProxyHost;
	private int testProxyPort;
	private String testProxyProtocol;

	@Before
	public void setUp() throws Exception {
		builder = new IdpClientViaHttpProxyConfigBuilder();
		testEnpointUrl = "http://fed.hin.ch/saml/2.0/epd/";
		testProxyHost = "localhost";
		testProxyPort = 12345;
		testProxyProtocol = "smile";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#proxyHost(java.lang.String)}.
	 */
	@Test
	public void testProxyHost() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.proxyHost(testProxyHost).create();
		assertNotNull(ref);
		assertEquals(testProxyHost, ref.getProxyHost());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#proxyPort(int)}.
	 */
	@Test
	public void testProxyPort() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.proxyPort(testProxyPort).create();
		assertNotNull(ref);
		assertEquals(testProxyPort, ref.getProxyPort());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#proxyProtocol(java.lang.String)}.
	 */
	@Test
	public void testProxyProtocol() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.proxyProtocol(testProxyProtocol)
				.create();
		assertNotNull(ref);
		assertEquals(testProxyProtocol, ref.getProxyProtocol());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigBuilder#url(java.lang.String)}.
	 */
	@Test
	public void testUrl() {
		final IdpClientViaHttpProxyConfigImpl ref = builder.url(testEnpointUrl).create();
		assertNotNull(ref);
		assertEquals(testEnpointUrl, ref.getUrl());
	}

}
