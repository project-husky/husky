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
 * <div class="en">Interface describing the XuaClientConfigBuilder methods.</div>
 * <div class="de">Interface beschreibende methoden des XuaClientConfigBuilder.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface XuaClientConfigBuilder extends ClientConfigBuilder {

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder url(String aEndpointUri);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the port name of the security token webservice.</div>
	 * <div class="de">Methode um den Port Namen des security token webservices zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param portName
	 * <div class="en">the port name</div>
	 * <div class="de">der Port Name</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle instanz des builders</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XuaClientConfigBuilder portName(String portName);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the namespace of the port name of the security token webservice.</div>
	 * <div class="de">Methode um den Namespace des Port Namen des security token webservices zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param portName
	 * <div class="en">the namespace of the port name</div>
	 * <div class="de">der Namespace des Port Namens</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle instanz des builders</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XuaClientConfigBuilder portNamespace(String portNamespace);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the service  name of the security token webservice.</div>
	 * <div class="de">Methode um den Service Namen des security token webservices zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param portName
	 * <div class="en">the service name</div>
	 * <div class="de">der Service Namen</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle instanz des builders</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XuaClientConfigBuilder serviceName(String serviceName);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the namespace of the service name of the security token webservice.</div>
	 * <div class="de">Methode um den Namespace des Service Namen des security token webservices zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param portName
	 * <div class="en">the namespace of the port name</div>
	 * <div class="de">der Namespace des Port Namens</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle instanz des builders</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XuaClientConfigBuilder serviceNamespace(String serviceNamespace);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of XuaClientConfig with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des XuaClientConfig mit den gesetzten parametern.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new XuaClientConfig instance with the params set</div>
	 *  <div class="de">eine neue XuaClientConfig instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XuaClientConfig create();
}
