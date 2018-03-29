/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication;

import java.util.Calendar;

import org.ehealth_connector.security.saml2.Subject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the authnrequest builder methods.</div>
 * <div class="de">Interface beschreibende methoden des authnrequest builders.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface AuthnRequestBuilder {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the id on the authnrequest.</div>
	 * <div class="de">Methode um die id im authnrequest zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 *
	 * @param id 
	 * 	<div class="en">the id string to be set</div>
	 *  <div class="de">der id string der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder id(String id);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the issueInstant on the authnrequest.</div>
	 * <div class="de">Methode um den issueInstant setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param issueInstant
	 * 	<div class="en">the issueInstant to be set</div>
	 * 	<div class="de">der issue instant der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder issueInstant(Calendar issueInstant);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the assertion consumer service url attribute.</div>
	 * <div class="de">Buildet das assertion consumer service url attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAssertionConsumerServiceURL
	 *  <div class="en">the assertion consumer service url to be set</div>
	 * 	<div class="de">die assertion consumer service url die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder assertionConsumerServiceURL(String aAssertionConsumerServiceURL);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the assertion consumer service url attribute.</div>
	 * <div class="de">Buildet das assertion consumer service index attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAssertionConsumerServiceIndex
	 *  <div class="en">the assertion consumer service index to be set</div>
	 * 	<div class="de">die assertion consumer service index die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder assertionConsumerServiceIndex(Integer aAssertionConsumerServiceIndex);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAttributeConsumingServiceIndex
	 *  <div class="en">the attribute consuming service index to be set</div>
	 * 	<div class="de">der attribute consuming service index der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder attributeConsumingServiceIndex(Integer aAttributeConsumingServiceIndex);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Building the destination attribute.</div>
	 * <div class="de">Bildet das destination attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aDestination
	 *  <div class="en">the destination to be set</div>
	 * 	<div class="de">die destination die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder destination(String aDestination);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Building the provider name attribute.</div>
	 * <div class="de">Bildet das destination attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aProviderName
	 *  <div class="en">the provider name to be set</div>
	 * 	<div class="de">der provider name der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder providerName(String aProviderName);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Building the protocol binding attribute.</div>
	 * <div class="de">Bildet das protocol binding attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aProtocolBinding
	 *  <div class="en">the protocol binding to be set</div>
	 * 	<div class="de">das protocol binding welches gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder protocolBinding(String aProtocolBinding);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Building the consent attribute.</div>
	 * <div class="de">Bildet das consent attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aConsent
	 *  <div class="en">the consent to be set</div>
	 * 	<div class="de">der consent der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder consent(String aConsent);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Building the forceAuthn attribute.</div>
	 * <div class="de">Bildet das forceAuthn attribute.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aForceAuthn
	 *  <div class="en">the force authn to be set</div>
	 * 	<div class="de">der force authn der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder forceAuthn(Boolean aForceAuthn);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the Issuer element.</div>
	 * <div class="de">Buildet das Issuer element.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param aIssuer
	 *  <div class="en">the issuer to be set</div>
	 * 	<div class="de">der issuer der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder issuer(String aIssuer);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt das Flag Allow Create Name ID.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param aNameIdPolicyAllowCreate
	 *  <div class="en">the nameidpolicy allowcreate to be set</div>
	 * 	<div class="de">die nameidpolicy allowcreate die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder nameIdPolicyAllowCreate(Boolean aNameIdPolicyAllowCreate);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt das Format für die Name ID.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aNameIdPolicyFormat
	 *  <div class="en">the nameidpolicy format to be set</div>
	 * 	<div class="de">das nameidpolicy format welches gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder nameIdPolicyFormat(String aNameIdPolicyFormat);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param aSubject
	 *  <div class="en">the subject to be set</div>
	 * 	<div class="de">das subject welches gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder subject(Subject aSubject);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Creates the AuthnRequest.</div>
	 * <div class="de">Erstellt den AuthnRequest.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new AuthnRequest instance with the params set</div>
	 *  <div class="de">eine neue AuthRequest instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequest create();

}
