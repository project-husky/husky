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
package org.ehealth_connector.security.communication.config.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public class IdpClientByBrowserAndProtocolHandlerConfigBuilderImplTest {

	private IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl builder;
	private String testProtocolHandlerName;
	private String testUrl;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @throws java.lang.Exception
	 * <!-- @formatter:on -->
	 */
	@Before
	public void setUp() throws Exception {
		builder = new IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl();
		testUrl = "https://test.ch/url/with/no/end";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl#protocolHandlerName(java.lang.String)}.
	 */
	@Test
	public void testProtocolHandlerName() {
		final IdpClientByBrowserAndProtocolHandlerConfigImpl config = builder
				.protocolHandlerName(testProtocolHandlerName)//
				.create();
		assertNotNull(config);
		assertEquals(testProtocolHandlerName, config.getProtocolHandlerName());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	public void testUrl() {
		final IdpClientByBrowserAndProtocolHandlerConfigImpl config = builder.url(testUrl)//
				.create();
		assertNotNull(config);
		assertEquals(testUrl, config.getUrl());
	}

}
