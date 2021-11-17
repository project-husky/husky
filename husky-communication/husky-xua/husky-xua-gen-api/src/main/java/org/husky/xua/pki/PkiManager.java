/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.xua.pki;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.List;

/**
 *
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the PkiManager.</div>
 * <div class="de">Interface welches die Methoden des PkiManagers beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public interface PkiManager {

	/**
	 * The proprietary keystore implementation provided by the SunJCE provider.
	 */
	public static final String TYPE_JCEKS = "jceks";
	/** The proprietary keystore implementation provided by the SUN provider. */
	public static final String TYPE_JKS = "jks";
	/**
	 * The transfer syntax for personal identity information as defined in PKCS
	 * #12.
	 */
	public static final String TYPE_PKCS12 = "pkcs12";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to registers a Client Key/Certificate in the {@link java.security.KeyStore}.</div>
	 * <div class="de">Methode um ein ClientKey/Zertifikat im {@link java.security.KeyStore} zu registrieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param privateKeyPemPath
	 * <div class="en">the path of the file with the private key</div>
	 * <div class="de">der Pfad des Ffiles mit dem privaten Schlüssel</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param clientCertPemPath
	 * <div class="en">the path of the pem file of the certificate</div>
	 * <div class="de">der Pfad des pem Files des Zertifikates</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param alias
	 * <div class="en">the alias the key and cert should be referenced with</div>
	 * <div class="de">der Alias unter dem der Schlüssel und das Zertifikat referenziert werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param keyStore
	 * <div class="en">the keystore the client key/certificate should be addded to</div>
	 * <div class="de">Der keystore in dem Schlüssel/Zertifikat hinzugefügt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aKeyPassword
	 * <div class="en">the password of the key</div>
	 * <div class="de">das Passwort des Keys</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Speichern des KeyStores ins Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void addClientKeyAndCert(File privateKeyPemPath, File clientCertPemPath, String alias,
			KeyStore keyStore, String aKeyPassword) throws KeyStoreException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add a certificate to a keystore./div>
	 * <div class="de">Methode um ein öffentliches Zertifikat im Key Store zu registrieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param publicCertPemPath
	 * <div class="en">the path of the file the certificate is stored in</div>
	 * <div class="de">der Pfad des Files des Zertifikates</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param alias
	 * <div class="en">the alias the cert should be referenced with</div>
	 * <div class="de">der Alias unter dem das Zertifikat referenziert werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param keyStore
	 * <div class="en">the keystore the certificate should be addded to</div>
	 * <div class="de">Der Keystore dem das Zertifikat hinzugefügt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Speichern des KeyStores ins Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void addPublicCert(File publicCertPemPath, String alias, KeyStore keyStore)
			throws KeyStoreException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create a new {@link java.security.KeyStore}. The Keystore is not saved.</div>
	 * <div class="de">Methode um einen neuen {@link java.security.KeyStore} zu erstellen. Der Keystore wird nicht gespeichert.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param storeType
	 * <div class="en">the type of the key store (see {@link #TYPE_JKS}, @link #TYPE_JCEKS}, @link #TYPE_PKCS12}).</div>
	 * <div class="de">der Typ des Keystore (siehe {@link #TYPE_JKS}, {@link #TYPE_JCEKS}, {@link #TYPE_PKCS12}).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the {@link java.security.KeyStore} loaded from file.</div>
	 * <div class="de">der {@link java.security.KeyStore} geladen vom File.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures loading the KeyStore from filesystem.</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Laden des KeyStores aus dem Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	KeyStore createNewStore(String storeType) throws KeyStoreException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to list all registered certificates.</div>
	 * <div class="de">Methode zum Auflisten der registrierten Zertifikate.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStore
	 * <div class="en">the keystore</div>
	 * <div class="de">Der Keystore</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">a {@link java.util.List} of all certificate aliases</div>
	 * <div class="de">Eine {@link java.util.List} von allen Zertifikat Aliases</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Speichern des KeyStores ins Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<String> listCertificateAliases(KeyStore keyStore) throws KeyStoreException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to list all registered certificates.</div>
	 * <div class="de">Methode zum Auflisten der registrierten Zerifikate.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStore
	 * <div class="en">the keystore</div>
	 * <div class="de">Der Keystore</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">a {@link java.util.List} of all certificates</div>
	 * <div class="de">Eine {@link java.util.List} von allen Zertifikaten</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Speichern des KeyStores ins Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<Certificate> listCertificates(KeyStore keyStore) throws KeyStoreException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to load the {@link java.security.KeyStore} from filesystem.</div>
	 * <div class="de">Methode welches den {@link java.security.KeyStore} vom Filesystem lädt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param storeInputStream
	 * <div class="en">the InputStream of the {@link java.security.KeyStore} file.</div>
	 * <div class="de">der InputStream des {@link java.security.KeyStore} Files.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param storePassword
	 * <div class="en">the password of the {@link java.security.KeyStore}</div>
	 * <div class="de">das Passwort des {@link java.security.KeyStore}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param storeType
	 * <div class="en">the type of the key store (see {@link #TYPE_JKS}, @link #TYPE_JCEKS}, @link #TYPE_PKCS12}).</div>
	 * <div class="de">der Typ des Keystore (siehe {@link #TYPE_JKS}, {@link #TYPE_JCEKS}, {@link #TYPE_PKCS12}).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the {@link java.security.KeyStore} loaded from file.</div>
	 * <div class="de">der {@link java.security.KeyStore} geladen vom File.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures loading the KeyStore</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Laden des KeyStores auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	KeyStore loadStore(InputStream storeInputStream, String storePassword, String storeType)
			throws KeyStoreException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Removes an Entry from the {@link java.security.KeyStore} referenced by an alias.</div>
	 * <div class="de">Entfernt ein Eintrag referenziert durch den Alias aus dem {@link java.security.KeyStore}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param alias
	 * <div class="en">the alias the key and cert should be referenced with</div>
	 * <div class="de">der Alias unter dem der Schlüssel und das Zertifikat referenziert werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param keyStore
	 * <div class="en">the keystore the certificate should be removed from</div>
	 * <div class="de">Der Keystore dem das Zertifikat entfernt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Speichern des KeyStores ins Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void removeCert(String alias, KeyStore keyStore) throws KeyStoreException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to store a {@link java.security.KeyStore} into a file.</div>
	 * <div class="de">Methode zum Speichern eines {@link java.security.KeyStore} in ein File.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStore
	 * <div class="en">the keystore the certificate should be addded to</div>
	 * <div class="de">Der Keystore dem das Zertifikat hinzugefügt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param storeOutputStream
	 * <div class="en">the OutputStream of the file the keystore to be stored in</div>
	 * <div class="de">der OutputStream des Files in dem der Keystore gespeichert wird</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param storePassword
	 * <div class="en">the password of the {@link java.security.KeyStore}</div>
	 * <div class="de">das Passwort des {@link java.security.KeyStore}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Speichern des KeyStores ins Filesystem auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void storeStore(KeyStore keyStore, OutputStream storeOutputStream, String storePassword)
			throws KeyStoreException;

}
