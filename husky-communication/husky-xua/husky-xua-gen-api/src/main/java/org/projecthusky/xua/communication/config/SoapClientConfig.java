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
package org.projecthusky.xua.communication.config;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of sopa client configuration.</div>
 * <div class="de">Interface welches die Methoden für die SOAP Client Konfiguration beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SoapClientConfig extends ClientConfig {

	public enum SoapVersion {
		SOAP_11, // http://schemas.xmlsoap.org/soap/envelope/
		SOAP_12 // http://www.w3.org/2003/05/soap-envelope
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the client keystore.</div>
	 * <div class="de">Methode um den Client Keystore zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Client Keystore.</div>
	 * <div class="de">der Client Keystore.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getKeyStore();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the client keystore password.</div>
	 * <div class="de">Methode um das Passwort des Client Keystores zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the client keystore password.</div>
	 * <div class="de">das Client Keystore Passwort.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getKeyStorePassword();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the client keystore type.</div>
	 * <div class="de">Methode um den Typ des Client Keystores zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the client keystore type.</div>
	 * <div class="de">der Client Keystore Typ.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getKeyStoreType();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the port name of the webservice.</div>
	 * <div class="de">Methode um den Port Namen des Webservices zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the port name of the webservice.</div>
	 * <div class="de">der Port Namen des Webservices</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getPortName();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the namespace of the port name of the webservice.</div>
	 * <div class="de">Methode um den Namespace des Port Namens des Webservices zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the namespace of the port name of the webservice.</div>
	 * <div class="de">der Namespace des Port Namen des Webservices</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getPortNamespace();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the service name of the webservice.</div>
	 * <div class="de">Methode um den Service Namen des Webservices zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the name of the webservice.</div>
	 * <div class="de">der Namen des Webservices</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getServiceName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the namespace of the service name of the webservice.</div>
	 * <div class="de">Methode um den Namespace des Service Namens des Webservices zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the namespace of the name of the webservice.</div>
	 * <div class="de">der Namespace des Namens des Webservices.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getServiceNamespace();

	SoapVersion getSoapVersion();

	boolean isSimple();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore.</div>
	 * <div class="de">Methode den Client Keystore zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStoreFile
	 * <div class="en">the keystore file.</div>
	 * <div class="de">das Keystore File.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setKeyStore(String keyStoreFile);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore password.</div>
	 * <div class="de">Methode das Passwort des Client Keystores zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStorePassword
	 * <div class="en">the keystore password.</div>
	 * <div class="de">das Passwort des Keystores.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setKeyStorePassword(String keyStorePassword);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore type.</div>
	 * <div class="de">Methode den Typ des Client Keystores zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStoreType
	 * <div class="en">the keystore type.</div>
	 * <div class="de">der Typ des Keystores.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setKeyStoreType(String keyStoreType);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port name of the webservice.</div>
	 * <div class="de">Methode um den Port Namen des Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param portName
	 * <div class="en">the name of the port of the webservice.</div>
	 * <div class="de">der Port Name des Webservices</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setPortName(String portName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port namespace of the port name of the webservice.</div>
	 * <div class="de">Methode um den Namespace des Port Namens des Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param portNamespace
	 * <div class="en">the namespace of the port of the webservice.</div>
	 * <div class="de">der Nmespace des ports des webservices</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setPortNamespace(String portNamespace);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the name of the webservice.</div>
	 * <div class="de">Methode um den Namen des Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param serviceName
	 * <div class="en">the service name.</div>
	 * <div class="de">der Namen des Webservices.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setServiceName(String serviceName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the namespace of the service name of the webservice.</div>
	 * <div class="de">Methode um den Namespace des Service Namens des Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param serviceNamespace
	 * <div class="en">the namespace of the serivce name of the webservice.</div>
	 * <div class="de">der Namespace des Service Namens des Webservices.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setServiceNamespace(String serviceNamespace);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the soap version of the webservice.</div>
	 * <div class="de">Methode um die SOAP Version des Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param version
	 * <div class="en">The version of the soap message to be set. Has influence on the namespace of the SOAP:ENV.</div>
	 * <div class="de">Die version die für die soap message gesetzt werden muss. Hat einen einfluss auf den Namespace des SOAP:ENV.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setSoapVersion(SoapVersion version);
}
