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

import org.husky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl;
import org.husky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdpClientByBrowserAndProtocolHandlerConfigBuilderImplTest {

	private IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl builder;
	private String testProtocolHandlerName;
	private String testUrl;

	/**
	 * Initialization of the test.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		builder = new IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl();
		testUrl = "https://test.ch/url/with/no/end";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl#protocolHandlerName(java.lang.String)}.
	 */
	@Test
	void testProtocolHandlerName() {
		final IdpClientByBrowserAndProtocolHandlerConfigImpl config = builder
				.protocolHandlerName(testProtocolHandlerName)//
				.create();
		assertNotNull(config);
		assertEquals(testProtocolHandlerName, config.getProtocolHandlerName());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	void testUrl() {
		final IdpClientByBrowserAndProtocolHandlerConfigImpl config = builder.url(testUrl)//
				.create();
		assertNotNull(config);
		assertEquals(testUrl, config.getUrl());
	}

}
