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
package org.ehealth_connector.security.serialization.pki;

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

import org.ehealth_connector.security.pki.PkiManager;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class PkiManagerImplTest {

	private PkiManager testPkiManager;
	private InputStream testKeyStoreJceksInStream;
	private InputStream testKeyStoreJksInStream;
	private InputStream testKeyStorePkcs12InStream;
	private String testKeyStoreCreateType;
	private String testStorePassword;
	private String testKeyAlias;
	private String testOutputFile;
	private String testClientKeyAlias;
	private File testPrivateKeyPemPath;
	private File testClientCertPemPath;
	private String testCertAlias;
	private File testCertPath;
	private String testRemoveCertAlias;

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
		testPrivateKeyPemPath = new File("./src/test/resources/testClientKey_key.p8");
		testClientCertPemPath = new File("./src/test/resources/testClientKey_crt.pem");

		testCertAlias = "testImportCert";
		testCertPath = new File("./src/test/resources/testCert_crt.pem");

		testRemoveCertAlias = "testcertremove";

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#addClientCert(java.io.File, java.io.File, java.lang.String, java.security.KeyStore)}.
	 *
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testAddClientKeyAndCert() throws KeyStoreException, NoSuchAlgorithmException {
		// final KeyStore ref =
		// testPkiManager.createNewStore(testKeyStoreCreateType);
		// testPkiManager.addClientKeyAndCert(testPrivateKeyPemPath,
		// testClientCertPemPath, testClientKeyAlias, ref,
		// testStorePassword);
		//
		// assertTrue(ref.isKeyEntry(testClientKeyAlias));

		// TODO: This fails with the following exception
		// java.security.KeyStoreException: java.net.URISyntaxException: Illegal
		// character in authority at index 7:
		// file://C:\src\ehc-Metadata\ehealthconnector\ehealth_connector-security\ehealth_connector-security-gen-impl\.\src\test\resources\testClientKey_key.p8
		// at
		// org.ehealth_connector.security.serialization.pki.PkiManagerImpl.addClientKeyAndCert(PkiManagerImpl.java:136)
		// at
		// org.ehealth_connector.security.serialization.pki.PkiManagerImplTest.testAddClientKeyAndCert(PkiManagerImplTest.java:173)
		// at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		// at
		// sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
		// at
		// sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		// at java.lang.reflect.Method.invoke(Method.java:497)
		// at
		// org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
		// at
		// org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
		// at
		// org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
		// at
		// org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
		// at
		// org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
		// at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
		// at
		// org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
		// at
		// org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
		// at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
		// at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
		// at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
		// at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
		// at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
		// at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
		// at
		// org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)
		// at
		// org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
		// at
		// org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)
		// at
		// org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)
		// at
		// org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)
		// at
		// org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)
		// Caused by: java.net.URISyntaxException: Illegal character in
		// authority at index 7:
		// file://C:\src\ehc-Metadata\ehealthconnector\ehealth_connector-security\ehealth_connector-security-gen-impl\.\src\test\resources\testClientKey_key.p8
		// at java.net.URI$Parser.fail(URI.java:2848)
		// at java.net.URI$Parser.parseAuthority(URI.java:3186)
		// at java.net.URI$Parser.parseHierarchical(URI.java:3097)
		// at java.net.URI$Parser.parse(URI.java:3053)
		// at java.net.URI.<init>(URI.java:588)
		// at
		// org.ehealth_connector.security.serialization.pki.PkiManagerImpl.addClientKeyAndCert(PkiManagerImpl.java:122)
		// ... 25 more
		//

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#addPublicCert(java.io.File, java.security.KeyStore)}.
	 *
	 * @throws KeyStoreException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testAddPublicCert() throws KeyStoreException, FileNotFoundException {
		final KeyStore keyStore = testPkiManager.createNewStore(testKeyStoreCreateType);
		testPkiManager.addPublicCert(testCertPath, testCertAlias, keyStore);
		LoggerFactory.getLogger(getClass()).info("" + Collections.list(keyStore.aliases()));
		assertTrue(keyStore.containsAlias(testCertAlias));
		assertTrue(keyStore.isCertificateEntry(testCertAlias));
		final X509Certificate ref1 = (X509Certificate) keyStore.getCertificate(testCertAlias);
		assertNotNull(ref1);
		LoggerFactory.getLogger(getClass()).info(ref1.getSubjectDN().toString());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#createNewStore(java.lang.String)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#listCertificateAliases(java.security.KeyStore)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#listCertificates(java.security.KeyStore)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#loadStore(java.io.InputStream, java.lang.String, java.lang.String)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#loadStore(java.io.InputStream, java.lang.String, java.lang.String)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#loadStore(java.io.InputStream, java.lang.String, java.lang.String)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#removeCert(java.lang.String, java.io.File)}.
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
	 * {@link org.ehealth_connector.security.serialization.pki.PkiManagerImpl#storeStore(java.security.KeyStore, java.io.OutputStream, java.lang.String)}.
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
