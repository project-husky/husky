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
package org.ehealth_connector.xua.pki.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;

import org.ehealth_connector.xua.pki.PkiManager;
import org.ehealth_connector.xua.pki.impl.PkiManagerImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class PkiManagerImplTest {

	private String testCertAlias;
	private File testClientCertPemPath;
	private String testClientKeyAlias;
	private String testKeyAlias;
	private String testKeyStoreCreateType;
	private InputStream testKeyStoreJceksInStream;
	private InputStream testKeyStoreJksInStream;
	private InputStream testKeyStorePkcs12InStream;
	private String testOutputFile;
	private PkiManager testPkiManager;
	private File testPrivateKeyPemPath;
	private String testRemoveCertAlias;
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

	@Before
	public void setUp() throws Exception {
		testPkiManager = new PkiManagerImpl();

		testKeyStoreJceksInStream = getKeyStoreInputStream("classpath:/testKeystore.jceks");
		testKeyStoreJksInStream = getKeyStoreInputStream("classpath:/testKeystore.jks");
		testKeyStorePkcs12InStream = getKeyStoreInputStream("classpath:/testKeystore.p12");

		testStorePassword = "changeit";
		testKeyAlias = "mykey";

		testOutputFile = "./target/testOutputKeyStore";

		testKeyStoreCreateType = PkiManager.TYPE_PKCS12;

		testClientKeyAlias = "testClientKeyCert";

		testPrivateKeyPemPath = new File(getClass().getResource("/testClientKey_key.p8").getPath());
		testClientCertPemPath = new File(
				getClass().getResource("/testClientKey_crt.pem").getPath());

		testCertAlias = "testImportCert";

		testRemoveCertAlias = "testcertremove";

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#addClientCert(java.io.File, java.io.File, java.lang.String, java.security.KeyStore)}.
	 *
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testAddClientKeyAndCert() throws KeyStoreException, NoSuchAlgorithmException {
		final KeyStore ref = testPkiManager.createNewStore(testKeyStoreCreateType);
		testPkiManager.addClientKeyAndCert(testPrivateKeyPemPath, testClientCertPemPath,
				testClientKeyAlias, ref, testStorePassword);

		assertTrue(ref.isKeyEntry(testClientKeyAlias));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#addPublicCert(java.io.File, java.security.KeyStore)}.
	 *
	 * @throws KeyStoreException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testAddPublicCert() throws KeyStoreException, FileNotFoundException {
		final KeyStore keyStore = testPkiManager.createNewStore(testKeyStoreCreateType);
		testPkiManager.addPublicCert(testClientCertPemPath, testCertAlias, keyStore);
		LoggerFactory.getLogger(getClass()).info("" + Collections.list(keyStore.aliases()));
		assertTrue(keyStore.containsAlias(testCertAlias));
		assertTrue(keyStore.isCertificateEntry(testCertAlias));
		final X509Certificate ref1 = (X509Certificate) keyStore.getCertificate(testCertAlias);
		assertNotNull(ref1);
		LoggerFactory.getLogger(getClass()).info(ref1.getSubjectDN().toString());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#createNewStore(java.lang.String)}.
	 *
	 * @throws KeyStoreException
	 */
	@Test
	public void testCreateNewStore() throws KeyStoreException {
		final KeyStore ref = testPkiManager.createNewStore(testKeyStoreCreateType);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#listCertificateAliases(java.security.KeyStore)}.
	 *
	 * @throws KeyStoreException
	 */
	@Test
	public void testListCertificateAliases() throws KeyStoreException {
		final KeyStore ref = testPkiManager.loadStore(testKeyStorePkcs12InStream, testStorePassword,
				PkiManager.TYPE_PKCS12);
		final List<String> aliases = testPkiManager.listCertificateAliases(ref);
		assertNotNull(aliases);
		assertFalse(aliases.isEmpty());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#listCertificates(java.security.KeyStore)}.
	 *
	 * @throws KeyStoreException
	 */
	@Test
	public void testListCertificates() throws KeyStoreException {
		final KeyStore ref = testPkiManager.loadStore(testKeyStorePkcs12InStream, testStorePassword,
				PkiManager.TYPE_PKCS12);
		final List<Certificate> certificates = testPkiManager.listCertificates(ref);
		assertNotNull(certificates);
		assertFalse(certificates.isEmpty());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#loadStore(java.io.InputStream, java.lang.String, java.lang.String)}.
	 *
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws UnrecoverableKeyException
	 */
	@Test
	public void testLoadStoreJceks()
			throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
		final KeyStore ref = testPkiManager.loadStore(testKeyStoreJceksInStream, testStorePassword,
				PkiManager.TYPE_JCEKS);
		assertNotNull(ref);
		final Key refKey = ref.getKey(testKeyAlias, testStorePassword.toCharArray());
		assertNotNull(refKey);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#loadStore(java.io.InputStream, java.lang.String, java.lang.String)}.
	 *
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws UnrecoverableKeyException
	 */
	@Test
	public void testLoadStoreJks()
			throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
		final KeyStore ref = testPkiManager.loadStore(testKeyStoreJksInStream, testStorePassword,
				PkiManager.TYPE_JKS);
		assertNotNull(ref);
		final Key refKey = ref.getKey(testKeyAlias, testStorePassword.toCharArray());
		assertNotNull(refKey);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#loadStore(java.io.InputStream, java.lang.String, java.lang.String)}.
	 *
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws UnrecoverableKeyException
	 */
	@Test
	public void testLoadStorePkcs12()
			throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
		final KeyStore ref = testPkiManager.loadStore(testKeyStorePkcs12InStream, testStorePassword,
				PkiManager.TYPE_PKCS12);
		assertNotNull(ref);
		final Key refKey = ref.getKey(testKeyAlias, testStorePassword.toCharArray());
		assertNotNull(refKey);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#removeCert(java.lang.String, java.io.File)}.
	 *
	 * @throws KeyStoreException
	 */
	@Test
	public void testRemoveCert() throws KeyStoreException {
		final KeyStore ref = testPkiManager.loadStore(testKeyStorePkcs12InStream, testStorePassword,
				PkiManager.TYPE_PKCS12);
		assertNotNull(ref);
		testPkiManager.removeCert(testRemoveCertAlias, ref);

		assertFalse(ref.containsAlias(testRemoveCertAlias));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.pki.impl.PkiManagerImpl#storeStore(java.security.KeyStore, java.io.OutputStream, java.lang.String)}.
	 *
	 * @throws KeyStoreException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testStoreStore() throws KeyStoreException, FileNotFoundException {
		final KeyStore ref = testPkiManager.createNewStore(testKeyStoreCreateType);
		assertNotNull(ref);
		testPkiManager.storeStore(ref, new FileOutputStream(testOutputFile), testStorePassword);
		assertTrue(new File(testOutputFile).exists());
	}

}
