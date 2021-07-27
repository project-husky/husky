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
package org.ehealth_connector.xua.communication.config.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * <!-- @formatter:off -->
 * <div class="en">Testclass to test the IdpClientBasicAuthConfigBuilder.</div>
 * <div class="de">Testklasse um den IdpClientBasicAuthConfigBuilder zu testen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class IdpClientBasicAuthConfigBuilderImplTest {

	private IdpClientBasicAuthConfigBuilderImpl builder;
	private String testBasicAuthPassword;
	private String testBasicAuthUsername;
	private String testUrl;

	/**
	 * set up test parameters
	 */
	@Before
	public void setUp() throws Exception {
		builder = new IdpClientBasicAuthConfigBuilderImpl();

		testBasicAuthPassword = "MyTestPassword";
		testBasicAuthUsername = "MyTestUser";
		testUrl = "https://test.ch/url/with/no/end";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl#basicAuthPassword(java.lang.String)}.
	 */
	@Test
	public void testBasicAuthPassword() {
		final IdpClientBasicAuthConfigImpl config = builder.basicAuthPassword(testBasicAuthPassword)//
				.create();
		assertNotNull(config);
		assertEquals(testBasicAuthPassword, config.getBasicAuthPassword());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl#basicAuthUsername(java.lang.String)}.
	 */
	@Test
	public void testBasicAuthUsername() {
		final IdpClientBasicAuthConfigImpl config = builder.basicAuthUsername(testBasicAuthUsername)//
				.create();
		assertNotNull(config);
		assertEquals(testBasicAuthUsername, config.getBasicAuthUsername());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	public void testUrl() {
		final IdpClientBasicAuthConfigImpl config = builder.url(testUrl)//
				.create();
		assertNotNull(config);
		assertEquals(testUrl, config.getUrl());
	}

}
