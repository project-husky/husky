/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project
 * Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the
 * commit history of the forge. This code is made available under the terms of the Eclipse Public License v1.0.
 * Accompanying materials are made available under the terms of the Creative Commons Attribution-ShareAlike 4.0 License.
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication;

import java.net.URL;

import org.ehealth_connector.security.saml2.Assertion;

/**
 * @since Jan 17, 2018 3:06:22 PM
 *
 */
public interface AuthentcationModule {

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt den Web Service Endpunkt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param url
	 */
	public void setEndpointURL(URL url);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Fügt eine SAML 2 Assertion 3 in den WS Security Header ein.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param assertion
	 */
	public void setSecurityHeader(Assertion assertion);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Führt den XML Soap Web Service aus, der über die Endpoint URL definiert wurde.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param synchron
	 * @param query
	 */
	public void invokeUserAuthentication(boolean synchron, AuthenticateUser query);

}
