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
package org.projecthusky.xua.communication.config.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;

import org.projecthusky.xua.pki.impl.PkiManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdpClientCertificateAuthConfigBuilderTest {

	private IdpClientCertificateAuthConfigBuilder builder;
	private KeyStore testClientKeyStore;
	private String testStorePassword;

	private InputStream getKeyStoreInputStream(String aKeyStorePath) throws FileNotFoundException {
		if (aKeyStorePath.startsWith("classpath:")) {
			return getClass().getResourceAsStream(aKeyStorePath.substring("classpath:".length()));
		} else if (aKeyStorePath.startsWith("file:")) {
			return new FileInputStream(aKeyStorePath.substring("file:".length()));
		} else {
			return new FileInputStream(aKeyStorePath);
		}
	}

	@BeforeEach
	public void setUp() throws Exception {
		builder = new IdpClientCertificateAuthConfigBuilder();

		testStorePassword = "changeit";

		testClientKeyStore = new PkiManagerImpl().loadStore(
				getKeyStoreInputStream("classpath:/testKeystore.p12"), testStorePassword, "pkcs12");

	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigBuilder#keyStore(java.security.KeyStore)}.
	 */
	@Test
	void testKeyStore() {
		final IdpClientCertificateAuthConfigImpl ref = builder.keyStore(testClientKeyStore)
				.create();
		assertNotNull(ref);
		assertEquals(testClientKeyStore, ref.getClientKeyStore());
	}

	@Test
	void testKeyStorePassword() {
		final IdpClientCertificateAuthConfigImpl ref = builder.keyStorePassword(testStorePassword)
				.create();
		assertNotNull(ref);
		assertArrayEquals(testStorePassword.toCharArray(), ref.getClientKeyStorePassword());
	}
}
