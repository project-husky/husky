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
package org.ehealth_connector.security.communication.config;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of sopa client configuration.</div>
 * <div class="de">Interface beschreibt die Methoden für die SOAP Client Konfiguration.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface SoapClientConfig extends ClientConfig {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the port name of the  webservice.</div>
	 * <div class="de">Methode um den Port Namen des security zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the port name of the webservice.</div>
	 * <div class="de">der Port Namen des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getPortName();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the namespace of the port name of the webservice.</div>
	 * <div class="de">Methode um den Namespace des Port Namens des security zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the namespace of the port name of the webservice.</div>
	 * <div class="de">der Namespace des Port Namen des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getPortNamespace();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the service name of the webservice.</div>
	 * <div class="de">Methode um den Service Namen des security zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the service name of the webservice.</div>
	 * <div class="de">der Service Namen des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getServiceName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the namespace of the service name of the webservice.</div>
	 * <div class="de">Methode um den Namespace des Service Namens des security zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the namespace of the service name of the webservice.</div>
	 * <div class="de">der Namespace des service Namen des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getServiceNamespace();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port name of the service name of the webservice.</div>
	 * <div class="de">Methode um den port name des Service Namens des security zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param portName
	 * <div class="en">the name of the port of the webservice.</div>
	 * <div class="de">der Name des ports Namen des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setPortName(String portName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port namespace of the port name of the webservice.</div>
	 * <div class="de">Methode um den port namespace des port Namens des security zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param portNamespace
	 * <div class="en">the namespace of the port of the webservice.</div>
	 * <div class="de">der Nmespace des ports des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setPortNamespace(String portNamespace);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port namespace of the port name of the webservice.</div>
	 * <div class="de">Methode um den port namespace des port Namens des security zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param serviceName
	 * <div class="en">the namespace of the port of the webservice.</div>
	 * <div class="de">der Nmespace des ports des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setServiceName(String serviceName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the service namespace of the service name of the webservice.</div>
	 * <div class="de">Methode um den service namespace des service namens des webservice zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param serviceName
	 * <div class="en">the namespace of the serice name of the webservice.</div>
	 * <div class="de">der Namespace des service Namen des webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setServiceNamespace(String serviceNamespace);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the client keystore.</div>
	 * <div class="de">Methode um den Client Keystore zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the Client Keystore.</div>
	 * <div class="de">der Client Keystore.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getKeyStore();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the client keystore password.</div>
	 * <div class="de">Methode um das Passwort des Client Keystores zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the client keystore password.</div>
	 * <div class="de">der Client Keystore Passwort.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getKeyStorePassword();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the client keystore type.</div>
	 * <div class="de">Methode um den typ des Client Keystores zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the client keystore type.</div>
	 * <div class="de">der Client Keystore Typ.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getKeyStoreType();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore.</div>
	 * <div class="de">Methode den Client Keystore zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param keyStoreFile
	 * <div class="en">the keystore file.</div>
	 * <div class="de">das Keystore File.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setKeyStore(String keyStoreFile);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore password.</div>
	 * <div class="de">Methode das Passwort des Client Keystores zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param keyStorePassword
	 * <div class="en">the keystore password.</div>
	 * <div class="de">das Passwort des Keystores.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setKeyStorePassword(String keyStorePassword);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore type.</div>
	 * <div class="de">Methode den Typ des Client Keystores zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param keyStorePassword
	 * <div class="en">the keystore ty1p1e.</div>
	 * <div class="de">der Typ des Keystores.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	void setKeyStoreType(String keyStoreType);

	boolean isSimple();

}
