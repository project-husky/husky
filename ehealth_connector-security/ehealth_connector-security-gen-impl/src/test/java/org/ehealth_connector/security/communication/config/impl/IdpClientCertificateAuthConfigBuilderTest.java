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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;

import org.ehealth_connector.security.serialization.pki.PkiManagerImpl;
import org.junit.Before;
import org.junit.Test;

public class IdpClientCertificateAuthConfigBuilderTest {

	private IdpClientCertificateAuthConfigBuilder builder;
	private KeyStore testClientKeyStore;
	private String testStorePassword;

	@Before
	public void setUp() throws Exception {
		builder = new IdpClientCertificateAuthConfigBuilder();

		testStorePassword = "changeit";

		testClientKeyStore = new PkiManagerImpl().loadStore(
				getKeyStoreInputStream("classpath:/testKeystore.p12"), testStorePassword, "pkcs12");

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.config.impl.IdpClientCertificateAuthConfigBuilder#keyStore(java.security.KeyStore)}.
	 */
	@Test
	public void testKeyStore() {
		final IdpClientCertificateAuthConfigImpl ref = builder.keyStore(testClientKeyStore)
				.create();
		assertNotNull(ref);
		assertEquals(testClientKeyStore, ref.getClientKeyStore());
	}

	@Test
	public void testKeyStorePassword() {
		final IdpClientCertificateAuthConfigImpl ref = builder.keyStorePassword(testStorePassword)
				.create();
		assertNotNull(ref);
		assertArrayEquals(testStorePassword.toCharArray(), ref.getClientKeyStorePassword());
	}

	private InputStream getKeyStoreInputStream(String aKeyStorePath) throws FileNotFoundException {
		if (aKeyStorePath.startsWith("classpath:")) {
			return getClass().getResourceAsStream(aKeyStorePath.substring("classpath:".length()));
		} else if (aKeyStorePath.startsWith("file:")) {
			return new FileInputStream(aKeyStorePath.substring("file:".length()));
		} else {
			return new FileInputStream(aKeyStorePath);
		}
	}
}
