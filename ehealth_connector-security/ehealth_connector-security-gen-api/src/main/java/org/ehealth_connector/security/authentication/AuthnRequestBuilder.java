/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication;

import java.util.Calendar;

/**
 * @since Jan 17, 2018 2:38:20 PM
 *
 */
public interface AuthnRequestBuilder<T> {

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt die Id des Requests.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param id
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> id(String id);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt das Issue Instance Feld des Requests.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param issueInstant
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> issueInstant(Calendar issueInstant);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Builds the assertion consumer service url attribute.</div>
	 * <div class="de">Buildet das assertion consumer service url attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aAssertionConsumerServiceURL
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> assertionConsumerServiceURL(String aAssertionConsumerServiceURL);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Builds the assertion consumer service url attribute.</div>
	 * <div class="de">Buildet das assertion consumer service index attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aAssertionConsumerServiceIndex
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> assertionConsumerServiceIndex(Integer aAssertionConsumerServiceIndex);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aAttributeConsumingServiceIndex
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> attributeConsumingServiceIndex(Integer aAttributeConsumingServiceIndex);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Building the destination attribute.</div>
	 * <div class="de">Bildet das destination attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aDestination
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> destination(String aDestination);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Building the provider name attribute.</div>
	 * <div class="de">Bildet das destination attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aProviderName
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> providerName(String aProviderName);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Building the protocol binding attribute.</div>
	 * <div class="de">Bildet das protocol binding attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aProtocolBinding
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> protocolBinding(String aProtocolBinding);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Building the consent attribute.</div>
	 * <div class="de">Bildet das consent attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aConsent
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> consent(String aConsent);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Building the forceAuthn attribute.</div>
	 * <div class="de">Bildet das forceAuthn attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aForceAuthn
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> forceAuthn(Boolean aForceAuthn);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Builds the Issuer element.</div>
	 * <div class="de">Buildet das Issuer element.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aIssuer
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> issuer(String aIssuer);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt das Flag Allow Create Name ID.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aNameIdPolicyAllowCreate
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> nameIdPolicyAllowCreate(Boolean aNameIdPolicyAllowCreate);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt das Format für die Name ID.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aNameIdPolicyFormat
	 * @return this AuthnRequestBuilder instance
	 */
	public AuthnRequestBuilder<T> nameIdPolicyFormat(String aNameIdPolicyFormat);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Creates the AuthnRequest.</div>
	 * <div class="de">Erstellt den AuthnRequest.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the AuthnRequest with params set
	 */
	public AuthnRequest<T> createAuthnRequest();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Creates the AuthnRequest.</div>
	 * <div class="de">Erstellt den AuthnRequest.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param aInternalObject the internal object of type T
	 * @return the AuthnRequest with params set
	 */
	public AuthnRequest<T> createAuthnRequest(T aInternalObject);

}
