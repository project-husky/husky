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
 * <div class="en">Interface describing the methods of idp client configuration.</div>
 * <div class="de">Interface beschreibt die Methoden für die IdP Client Konfiguration.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface XuaClientConfig extends ClientConfig {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the port name of the security token webservice.</div>
	 * <div class="de">Methode um den Port Namen des security token webservices zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the port name of the security token webservice.</div>
	 * <div class="de">der Port Namen des security token webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getPortName();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the namespace of the port name of the security token webservice.</div>
	 * <div class="de">Methode um den Namespace des Port Namens des security token webservices zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the namespace of the port name of the security token webservice.</div>
	 * <div class="de">der Namespace des Port Namen des security token webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getPortNamespace();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the service name of the security token webservice.</div>
	 * <div class="de">Methode um den Service Namen des security token webservices zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the service name of the security token webservice.</div>
	 * <div class="de">der Service Namen des security token webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getServiceName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the namespace of the service name of the security token webservice.</div>
	 * <div class="de">Methode um den Namespace des Service Namens des security token webservices zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the namespace of the service name of the security token webservice.</div>
	 * <div class="de">der Namespace des service Namen des security token webservices</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getServiceNamespace();
}
