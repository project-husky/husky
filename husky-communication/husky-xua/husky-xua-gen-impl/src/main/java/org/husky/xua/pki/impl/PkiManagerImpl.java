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
package org.husky.xua.pki.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;

import org.husky.xua.pki.PkiManager;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of PkiManager</div>
 * <div class="de">Implementations Klasse von PkiManager</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PkiManagerImpl implements PkiManager {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#addClientKeyAndCert(java.io.File,
	 *      java.io.File, java.lang.String, java.security.KeyStore,
	 *      java.lang.String)
	 */
	@Override
	public void addClientKeyAndCert(File privateKeyPemPath, File clientCertPemPath, String alias,
			KeyStore keyStore, String aKeyPassword) throws KeyStoreException {
		try {
			final var fact = CertificateFactory.getInstance("X.509");
			final var is = new FileInputStream(clientCertPemPath);
			final X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
			final var chain = new Certificate[] { cer };

			final var keyUri = privateKeyPemPath.toURI();

			var privateKeyContent = new String(Files.readAllBytes(Paths.get(keyUri)), StandardCharsets.UTF_8);

			privateKeyContent = privateKeyContent.replace("\n", "").replace("\r", "")
					.replace("-----BEGIN PRIVATE KEY-----", "")
					.replace("-----END PRIVATE KEY-----", "");

			final var kf = KeyFactory.getInstance("RSA");
			byte[] temp = Base64.getDecoder().decode(privateKeyContent);
			final var keySpecPKCS8 = new PKCS8EncodedKeySpec(temp);
			final PrivateKey privKey = kf.generatePrivate(keySpecPKCS8);

			keyStore.setKeyEntry(alias.toLowerCase(), privKey, aKeyPassword.toCharArray(), chain);
		} catch (NoSuchAlgorithmException | CertificateException | IOException
				| InvalidKeySpecException e) {
			throw new KeyStoreException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#addPublicCert(java.io.File,
	 *      java.lang.String, java.security.KeyStore)
	 */
	@Override
	public void addPublicCert(File publiCertPath, String alias, KeyStore keyStore)
			throws KeyStoreException {
		try {
			final var fact = CertificateFactory.getInstance("X.509");
			final var is = new FileInputStream(publiCertPath);
			final X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
			keyStore.setCertificateEntry(alias.toLowerCase(), cer);
		} catch (CertificateException | IOException | KeyStoreException e) {
			throw new KeyStoreException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#createNewStore(java.lang.String)
	 */
	@Override
	public KeyStore createNewStore(String storeType) throws KeyStoreException {
		final var keyStore = KeyStore.getInstance(storeType);
		try {
			keyStore.load(null, null);
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			throw new KeyStoreException(e);
		}
		return keyStore;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#listCertificateAliases(java.security.KeyStore)
	 */
	@Override
	public List<String> listCertificateAliases(KeyStore keyStore) throws KeyStoreException {
		final List<String> retVal = new ArrayList<>();
		final Enumeration<String> aliases = keyStore.aliases();
		while (aliases.hasMoreElements()) {
			final String alias = aliases.nextElement();
			if (keyStore.isCertificateEntry(alias) || keyStore.isKeyEntry(alias)) {
				retVal.add(alias.toLowerCase());
			}
		}
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#listCertificates(java.security.KeyStore)
	 */
	@Override
	public List<Certificate> listCertificates(KeyStore keyStore) throws KeyStoreException {
		final List<Certificate> retVal = new ArrayList<>();
		final List<String> aliases = listCertificateAliases(keyStore);
		for (final String alias : aliases) {
			retVal.add(keyStore.getCertificate(alias.toLowerCase()));
		}
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#loadStore(java.io.InputStream,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public KeyStore loadStore(InputStream storeInputStream, String storePassword, String storeType)
			throws KeyStoreException {
		try {
			final var keyStore = KeyStore.getInstance(storeType);
			keyStore.load(storeInputStream, storePassword.toCharArray());
			return keyStore;
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			throw new KeyStoreException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#removeCert(java.lang.String,
	 *      java.security.KeyStore)
	 */
	@Override
	public void removeCert(String alias, KeyStore keyStore) throws KeyStoreException {
		if (keyStore.isCertificateEntry(alias.toLowerCase())) {
			keyStore.deleteEntry(alias.toLowerCase());
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.pki.PkiManager#storeStore(java.security.KeyStore,
	 *      java.io.OutputStream, java.lang.String)
	 */
	@Override
	public void storeStore(KeyStore keyStore, OutputStream storeOutputStream, String storePassword)
			throws KeyStoreException {
		try {
			keyStore.store(storeOutputStream, storePassword.toCharArray());
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			throw new KeyStoreException(e);
		}

	}

}
