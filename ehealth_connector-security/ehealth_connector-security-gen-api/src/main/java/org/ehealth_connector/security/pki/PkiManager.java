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
package org.ehealth_connector.security.pki;

import java.io.File;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.List;

/**
 * @since Jan 16, 2018 1:50:13 PM
 *
 */
public interface PkiManager {
	/**
	 * Lädt den Key Store vom Filesystem.
	 *
	 * @param storePath
	 * @return
	 */
	KeyStore loadStore(File storePath);

	/**
	 * Erstellt einen neuen Key Store.
	 * 
	 * @param storePath
	 * @return
	 */
	KeyStore createNewStore(File storePath);

	/**
	 * Registriert ein Client Zertifikat im Key Store.
	 * 
	 * @param privateKeyPath
	 * @param clientCertPemPath
	 * @param alias
	 * @param keyStore
	 */
	void addClientCert(File privateKeyPath, File clientCertPemPath, String alias,
			KeyStore keyStore);

	/**
	 * Registriert ein öffentliches Zertifikat im Key Store.
	 * 
	 * @param publiCertPath
	 * @param keyStore
	 */
	void addPublicCert(File publiCertPath, KeyStore keyStore);

	/**
	 * Entfernt ein Zertifikat aus dem Key Store.
	 * 
	 * @param alias
	 * @param keyStore
	 */
	void removeCert(String alias, File keyStore);

	/**
	 * Exportiert einen Key Store in das Filesystem.
	 * 
	 * @param keyStore
	 * @param keyStorePath
	 */
	void storeStore(KeyStore keyStore, File keyStorePath);

	/**
	 * Gibt eine Liste der registrierten Zerifikate zurück.
	 * 
	 * @param keyStore
	 * @return
	 */
	List<String> listCertificateAliases(KeyStore keyStore);

	/**
	 * Gibt eine Liste der registrierten Zerifikate zurück.
	 * 
	 * @param keyStore
	 * @return
	 */
	List<Certificate> listCertificates(KeyStore keyStore);

}
