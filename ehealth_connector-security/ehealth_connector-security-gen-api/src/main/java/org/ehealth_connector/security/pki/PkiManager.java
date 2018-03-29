/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.pki;

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
 * <div class="de">Interface welches die methoden des PkiManagers beschreibt.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public interface PkiManager {

	/** The proprietary keystore implementation provided by the SUN provider. */
	public static final String TYPE_JKS = "jks";
	/** The proprietary keystore implementation provided by the SunJCE provider. */
	public static final String TYPE_JCEKS = "jceks";
	/** The transfer syntax for personal identity information as defined in PKCS #12. */
	public static final String TYPE_PKCS12 = "pkcs12";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create a new {@link java.security.KeyStore}. The Keystore is not saved.</div>
	 * <div class="de">Methode um einen neuen {@link java.security.KeyStore} zu erstellen. Der Keystore wird nicht gespeichert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param storeType
	 * <div class="en">the type of the key store (see {@link #TYPE_JKS}, @link #TYPE_JCEKS}, @link #TYPE_PKCS12}).</div>
	 * <div class="de">der typ des keystore (siehe {@link #TYPE_JKS}, {@link #TYPE_JCEKS}, {@link #TYPE_PKCS12}).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the {@link java.security.KeyStore} loaded from file.</div>
	 * <div class="de">der {@link java.security.KeyStore} geladen vom file.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures loading the KeyStore from filesystem.</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim laden des KeyStores aus dem Filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	KeyStore createNewStore(String storeType) throws KeyStoreException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to load the {@link java.security.KeyStore} from filesystem.</div>
	 * <div class="de">Methode welches de {@link java.security.KeyStore} vom Filesystem lädt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param storeInputStream
	 * <div class="en">the InputStream of the {@link java.security.KeyStore} file.</div>
	 * <div class="de">der InputStream des {@link java.security.KeyStore} files.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param storePassword
	 * <div class="en">the password of the {@link java.security.KeyStore}</div>
	 * <div class="de">das passwort des {@link java.security.KeyStore}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param storeType
	 * <div class="en">the type of the key store (see {@link #TYPE_JKS}, @link #TYPE_JCEKS}, @link #TYPE_PKCS12}).</div>
	 * <div class="de">der typ des keystore (siehe {@link #TYPE_JKS}, {@link #TYPE_JCEKS}, {@link #TYPE_PKCS12}).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the {@link java.security.KeyStore} loaded from file.</div>
	 * <div class="de">der {@link java.security.KeyStore} geladen vom file.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures loading the KeyStore</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim laden des KeyStores auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	KeyStore loadStore(InputStream storeInputStream, String storePassword, String storeType) throws KeyStoreException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to store a {@link java.security.KeyStore} into a file.</div>
	 * <div class="de">Methode zum speichern eines {@link java.security.KeyStore} in ein file.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param keyStore
	 * <div class="en">the keystore the certificate should be addded to</div>
	 * <div class="de">Der keystore dem das Zertifikat hinzugefügt werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param storeOutputStream
	 * <div class="en">the OutputStream of the file the keystore to be stored in</div>
	 * <div class="de">der OutputStream des files in dem der keystore gespeichert wird</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param storePassword
	 * <div class="en">the password of the {@link java.security.KeyStore}</div>
	 * <div class="de">das passwort des {@link java.security.KeyStore}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim speichern des KeyStores ins filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void storeStore(KeyStore keyStore, OutputStream storeOutputStream, String storePassword) throws KeyStoreException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to registers a Client Key/Certificate in the {@link java.security.KeyStore}.</div>
	 * <div class="de">Methode um ein ClientKey/Zertifikat im {@link java.security.KeyStore} zu registrieren.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param privateKeyPemPath
	 * <div class="en">the path of the file with the private key</div>
	 * <div class="de">der pfad des files mit dem privaten schlüssel</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param clientCertPemPath
	 * <div class="en">the path of the pem file of the certificate</div>
	 * <div class="de">der pfad des pem files des zertifikates</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param alias
	 * <div class="en">the alias the key and cert should be referenced with</div>
	 * <div class="de">der alias unter dem der schlüssel und das zertifikat referenziert werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param keyStore
	 * <div class="en">the keystore the client key/certificate should be addded to</div>
	 * <div class="de">Der keystore in dem der schlüssel/Zertifikat hinzugefügt werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param aKeyPassword
	 * <div class="en">the password of the key</div>
	 * <div class="de">das passwort des keys</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim speichern des KeyStores ins filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void addClientKeyAndCert(File privateKeyPemPath, File clientCertPemPath, String alias, KeyStore keyStore,
			String aKeyPassword) throws KeyStoreException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add a certificate to a keystore./div>
	 * <div class="de">Methode um ein &ooml;ffentliches Zertifikat im Key Store zu registrieren.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param publicCertPemPath
	 * <div class="en">the path of the file the certificate is stored in</div>
	 * <div class="de">der Pfad des Files des Zertifikates</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param alias
	 * <div class="en">the alias the cert should be referenced with</div>
	 * <div class="de">der alias unter dem das zertifikat referenziert werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param keyStore
	 * <div class="en">the keystore the certificate should be addded to</div>
	 * <div class="de">Der keystore dem das Zertifikat hinzugefügt werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim speichern des KeyStores ins filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void addPublicCert(File publicCertPemPath, String alias, KeyStore keyStore) throws KeyStoreException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Removes an Entry from the {@link java.security.KeyStore} referenced by an alias.</div>
	 * <div class="de">Entfernt ein Eintrag referenziert durch den Alias aus dem {@link java.security.KeyStore}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param alias
	 * <div class="en">the alias the key and cert should be referenced with</div>
	 * <div class="de">der alias unter dem der schlüssel und das zertifikat referenziert werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param keyStore
	 * <div class="en">the keystore the certificate should be removed from</div>
	 * <div class="de">Der keystore dem das Zertifikat entfernt werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim speichern des KeyStores ins filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void removeCert(String alias, KeyStore keyStore) throws KeyStoreException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to list all registered certificates.</div>
	 * <div class="de">Methode zum Auflisten der registrierten Zertifikate.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param keyStore
	 * <div class="en">the keystore</div>
	 * <div class="de">Der keystore</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">a {@link java.util.List} of all certificate aliases</div>
	 * <div class="de">Eine {@link java.util.List} von allen zertificate aliases</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim speichern des KeyStores ins filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<String> listCertificateAliases(KeyStore keyStore) throws KeyStoreException;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to list all registered certificates.</div>
	 * <div class="de">Methode zum Auflisten der registrierten Zerifikate.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param keyStore
	 * <div class="en">the keystore</div>
	 * <div class="de">Der keystore</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * 	<div class="en">a {@link java.util.List} of all certificates</div>
	 * <div class="de">Eine {@link java.util.List} von allen zertificaten</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws KeyStoreException
	 * <div class="en">will be thrown when an error occures storing the KeyStore to filesystem</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim speichern des KeyStores ins filesystem auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<Certificate> listCertificates(KeyStore keyStore) throws KeyStoreException;

}
