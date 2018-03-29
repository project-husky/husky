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
package org.ehealth_connector.security.authentication;

import java.net.URL;

import org.ehealth_connector.security.saml2.Assertion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the authentication module.</div>
 * <div class="de">Interface beschreibend die methoden des authentication modules.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * Fügt eine SAML 2 Assertion 3 in den WS Security Header ein.
 * <!-- @formatter:on -->
 */
public interface AuthentcationModule {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to the endpoint url of the web service.</div>
	 * <div class="de">Methode um den Web Service Endpunkt zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param url
	 * <!-- @formatter:on -->
	 */
	public void setEndpointURL(URL url);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param assertion
	 * <!-- @formatter:on -->
	 */
	public void setSecurityHeader(Assertion assertion);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Führt den XML Soap Web Service aus, der über die Endpoint URL definiert wurde.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 *
	 * @param synchron
	 * @param query
	 */
	public void invokeUserAuthentication(boolean synchron, AuthenticateUser query);

}
