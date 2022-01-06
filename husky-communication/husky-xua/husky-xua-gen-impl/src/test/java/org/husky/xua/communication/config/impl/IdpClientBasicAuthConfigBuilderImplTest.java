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

import org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <!-- @formatter:off -->
 * <div class="en">Testclass to test the IdpClientBasicAuthConfigBuilder.</div>
 * <div class="de">Testklasse um den IdpClientBasicAuthConfigBuilder zu testen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
class IdpClientBasicAuthConfigBuilderImplTest {

	private IdpClientBasicAuthConfigBuilderImpl builder;
	private String testBasicAuthPassword;
	private String testBasicAuthUsername;
	private String testUrl;

	/**
	 * set up test parameters
	 */
	@BeforeEach
	public void setUp() throws Exception {
		builder = new IdpClientBasicAuthConfigBuilderImpl();

		testBasicAuthPassword = "MyTestPassword";
		testBasicAuthUsername = "MyTestUser";
		testUrl = "https://test.ch/url/with/no/end";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl#basicAuthPassword(java.lang.String)}.
	 */
	@Test
	void testBasicAuthPassword() {
		final IdpClientBasicAuthConfigImpl config = builder.basicAuthPassword(testBasicAuthPassword)//
				.create();
		assertNotNull(config);
		assertEquals(testBasicAuthPassword, config.getBasicAuthPassword());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl#basicAuthUsername(java.lang.String)}.
	 */
	@Test
	void testBasicAuthUsername() {
		final IdpClientBasicAuthConfigImpl config = builder.basicAuthUsername(testBasicAuthUsername)//
				.create();
		assertNotNull(config);
		assertEquals(testBasicAuthUsername, config.getBasicAuthUsername());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	void testUrl() {
		final IdpClientBasicAuthConfigImpl config = builder.url(testUrl)//
				.create();
		assertNotNull(config);
		assertEquals(testUrl, config.getUrl());
	}

}
