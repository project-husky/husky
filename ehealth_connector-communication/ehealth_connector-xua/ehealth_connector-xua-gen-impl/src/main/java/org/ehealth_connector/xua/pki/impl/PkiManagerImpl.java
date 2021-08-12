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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
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

import org.ehealth_connector.xua.pki.PkiManager;

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
	 * @see org.ehealth_connector.xua.pki.PkiManager#addClientKeyAndCert(java.io.File,
	 *      java.io.File, java.lang.String, java.security.KeyStore,
	 *      java.lang.String)
	 */
	@Override
	public void addClientKeyAndCert(File privateKeyPemPath, File clientCertPemPath, String alias,
			KeyStore keyStore, String aKeyPassword) throws KeyStoreException {
		try {
			final CertificateFactory fact = CertificateFactory.getInstance("X.509");
			final FileInputStream is = new FileInputStream(clientCertPemPath);
			final X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
			final Certificate[] chain = new Certificate[] { cer };

			final URI keyUri = privateKeyPemPath.toURI();

			String privateKeyContent = new String(Files.readAllBytes(Paths.get(keyUri)), "UTF-8");

			privateKeyContent = privateKeyContent.replaceAll("\\n", "").replaceAll("\\r", "")
					.replace("-----BEGIN PRIVATE KEY-----", "")
					.replace("-----END PRIVATE KEY-----", "");

			final KeyFactory kf = KeyFactory.getInstance("RSA");
			byte[] temp = Base64.getDecoder().decode(privateKeyContent);
			final PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(temp);
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#addPublicCert(java.io.File,
	 *      java.lang.String, java.security.KeyStore)
	 */
	@Override
	public void addPublicCert(File publiCertPath, String alias, KeyStore keyStore)
			throws KeyStoreException {
		try {
			final CertificateFactory fact = CertificateFactory.getInstance("X.509");
			final FileInputStream is = new FileInputStream(publiCertPath);
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#createNewStore(java.lang.String)
	 */
	@Override
	public KeyStore createNewStore(String storeType) throws KeyStoreException {
		final KeyStore keyStore = KeyStore.getInstance(storeType);
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#listCertificateAliases(java.security.KeyStore)
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#listCertificates(java.security.KeyStore)
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#loadStore(java.io.InputStream,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public KeyStore loadStore(InputStream storeInputStream, String storePassword, String storeType)
			throws KeyStoreException {
		try {
			final KeyStore keyStore = KeyStore.getInstance(storeType);
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#removeCert(java.lang.String,
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
	 * @see org.ehealth_connector.xua.pki.PkiManager#storeStore(java.security.KeyStore,
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
