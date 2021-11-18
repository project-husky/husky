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
package org.husky.xua.crypt;

import java.security.KeyStore;

import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.exceptions.SigningException;
import org.husky.xua.saml2.ArtifactResolve;

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
