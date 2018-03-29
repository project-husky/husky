/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project
 * Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the
 * commit history of the forge. This code is made available under the terms of the Eclipse Public License v1.0.
 * Accompanying materials are made available under the terms of the Creative Commons Attribution-ShareAlike 4.0 License.
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2.validation;

import java.security.KeyStore;

import org.ehealth_connector.security.saml2.Response;

/**
 * @since Jan 17, 2018 2:36:04 PM
 *
 */
public interface ResponseValidator {

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt die Referenz zum Key Store mit den Schlüsseln zur Validierung.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param trustStore
	 */
	public void setPki(KeyStore trustStore);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Parst einen SAML Response, der als XML-String übergeben wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param samlResponse
	 * @return
	 */
	public Response parse(String samlResponse);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Parst einen SAML Response, der als XML-Objekt übergeben wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param samlResponse
	 * @return
	 */
	public Response parse(org.w3c.dom.Element samlResponse);

}
