/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project
 * Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the
 * commit history of the forge. This code is made available under the terms of the Eclipse Public License v1.0.
 * Accompanying materials are made available under the terms of the Creative Commons Attribution-ShareAlike 4.0 License.
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.crypt;

import java.security.KeyStore;

import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.Response;

/**
 * @since Jan 16, 2018 2:20:16 PM
 *
 */
public interface SignCryptModule {
	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt die Referenz zum Key Store mit den Schlüsseln zur Signierung.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param keyStore
	 * @param trustStore
	 */
	public void setPki(KeyStore keyStore, KeyStore trustStore);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Entschlüsselt einen SAML Response, der als XML-String übergeben wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param samlResponse
	 * @return
	 */
	public Response decryptFromStringResponse(String samlResponse);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Entschlüsselt einen SAML Response, der als XML-Objekt übergeben wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param samlResponse
	 * @return
	 */
	public Response decryptFromXmlResponse(org.w3c.dom.Element samlResponse);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Entschlüsselt eine SAML Assertion, die als XML-String übergeben wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param samlAssertion
	 * @return
	 */
	public Assertion decryptFromStringAssertion(String samlAssertion);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Entschlüsselt eine SAML Assertion, die als XML-Objekt übergeben wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param samlAssertion
	 * @return
	 */
	public Assertion decryptFromXmlAssertion(org.w3c.dom.Element samlAssertion);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Verschlüsselt eine SAML Assertion.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param assertion
	 * @param trustAlias
	 * @return
	 */
	public org.w3c.dom.Element encryptAssertionToXml(Assertion assertion, String trustAlias);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Verschlüsselt einen SAML Response.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param response
	 * @param trustAlias
	 * @return
	 */
	public org.w3c.dom.Element encryptResponseToXml(Response response, String trustAlias);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Signiert eine SAML Assertion.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param assertion
	 * @param keyAlias
	 * @return
	 */
	public org.w3c.dom.Element signAssertionToXml(Assertion assertion, String keyAlias);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Verschlüsselt und signiert eine SAML Assertion.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param assertion
	 * @param trustAlias
	 * @param keyAlias
	 * @return
	 */
	public org.w3c.dom.Element encryptAndSign(Assertion assertion, String trustAlias,
			String keyAlias);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Wandelt das Element (z.B. Assertion oder Response) vom XML Element in einen String um.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param element
	 * @return
	 */
	public String toString(org.w3c.dom.Element element);
}
