/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.security.crypt;

import java.security.KeyStore;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.exceptions.SigningException;
import org.ehealth_connector.security.saml2.ArtifactResolve;

/**
 *
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the sign and crypt module.</div>
 * <div class="de">Interface welches die Methoden des sign und crypt modules beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
 */
public interface SignCryptModule {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the key and truststore and the corresponding passwords.</div>
	 * <div class="de">Methode um den key und trust store und deren Passwörter zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param keyStore
	 *  <div class="en">the keystore to be set.</div>
	 *  <div class="de">der Keystore der gesetzt werden soll.</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @param aKeyStorePassword
	 * 	<div class="en">the password of the keystore to be set.</div>
	 *  <div class="de">das Passwort zum Keystore</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @param trustStore
	 *  <div class="en">the truststore to be set.</div>
	 *  <div class="de">der Truststore der gesetzt werden soll.</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @param aTrustStorePassword
	 *  <div class="en">the password of the truststore to be set.</div>
	 *  <div class="de">das Passwort zum Truststore</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setPki(KeyStore keyStore, String aKeyStorePassword, KeyStore trustStore,
			String aTrustStorePassword);

	void signArtifactResolve(ArtifactResolve artifactResolve, String aSigningAlias)
			throws SigningException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to sign an AuthnRequest.</div>
	 * <div class="de">Methode um einen AuthnRequest zu signieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @param aAuthnRequest
	 * <div class="en">the AuthnRequest to be signed</div>
	 *  <div class="de">der AuthnRequest der signiert werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @param aSigningAlias
	 * <div class="en">the alias of the key in the keystore to be used for signing</div>
	 *  <div class="de">der Alias des Keys aus dem Keystore welcher zum signieren gebraucht werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @throws SigningException
	 * <div class="en">will be thrown when an error occures signing the AuthnRequest</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Signieren des Authnrequests auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 */
	void signAuthnRequest(AuthnRequest aAuthnRequest, String aSigningAlias) throws SigningException;

}
