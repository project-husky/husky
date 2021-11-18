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
package org.husky.xua.communication.config;

import org.husky.xua.communication.config.SoapClientConfig.SoapVersion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the ClientConfigBuilder methods.</div>
 * <div class="de">Interface welches die Methoden des ClientConfigBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SoapClientConfigBuilder extends ClientConfigBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the client keystore to access the security token webservice.</div>
	 * <div class="de">Methode um den Schlüsselspeicher für den Zugriff auf den Security Token Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param clientKeyStoreFile
	 * <div class="en">the client keystore file</div>
	 * <div class="de">der Client KeyStore file</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder clientKeyStore(String clientKeyStoreFile);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the password for the client keystore.</div>
	 * <div class="de">Methode um das Passwort für den Schlüsselspeicher zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param clientKeyStorePassword
	 * <div class="en">the client keystore password</div>
	 * <div class="de">das Schlüsselspeicher Passwort</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the type of the client keystore.</div>
	 * <div class="de">Methode um den Typ des Schlüsselspeichers zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param clientKeyStoreType
	 * <div class="en">the client keystore type</div>
	 * <div class="de">der Schlüsselspeichertyp</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder clientKeyStoreType(String clientKeyStoreType);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port name of the security token webservice.</div>
	 * <div class="de">Methode um den Port Namen des Security Token Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param portName
	 * <div class="en">the port name</div>
	 * <div class="de">der Port Name</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder portName(String portName);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the namespace of the port name of the security token webservice.</div>
	 * <div class="de">Methode um den Namespace des Port Namen des Security Token Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param portNamespace
	 * <div class="en">the namespace of the port name</div>
	 * <div class="de">der Namespace des Port Namens</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder portNamespace(String portNamespace);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the service  name of the security token webservice.</div>
	 * <div class="de">Methode um den Service Namen des Security Token Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param serviceName
	 * <div class="en">the service name</div>
	 * <div class="de">der Service Namen</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder serviceName(String serviceName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the namespace of the service name of the security token webservice.</div>
	 * <div class="de">Methode um den Namespace des Service Namen des Security Token Webservices zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param serviceNamespace
	 * <div class="en">the namespace of the port name</div>
	 * <div class="de">der Namespace des Port Namens</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder serviceNamespace(String serviceNamespace);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the simple flag.</div>
	 * <div class="de">Methode um den das Simple Flag zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSimple
	 * <div class="en">true or false as value to be set</div>
	 * <div class="de">true oder false als Wert, der gesetzt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder simple(boolean aSimple);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the SOAP version.</div>
	 * <div class="de">Method um die SOAP version zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param soapVersion
	 * <div class="en">SoapVersion value to be set</div>
	 * <div class="de">SoapVersion Wert, der gesetzt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SoapClientConfigBuilder soapVersion(SoapVersion soapVersion);

}
