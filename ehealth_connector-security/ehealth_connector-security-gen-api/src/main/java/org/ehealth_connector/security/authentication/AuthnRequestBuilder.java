/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication;

import org.ehealth_connector.security.saml2.BaseBuilder;
import org.ehealth_connector.security.saml2.Subject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the authnrequest builder methods.</div>
 * <div class="de">Interface beschreibende methoden des authnrequest builders.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface AuthnRequestBuilder extends BaseBuilder<AuthnRequestBuilder> {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the assertion consumer service url on the authnrequest.</div>
	 * <div class="de">Bildet das assertion consumer service url im authnrequest.</div>
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
	 * <div class="en">Builds the assertion consumer service index on the authnrequest.</div>
	 * <div class="de">Buildet das assertion consumer service index im authnrequest.</div>
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
	 * <div class="en">Builds the attribute consumer service index on the authnrequest.</div>
	 * <div class="de">Buildet den attribute consumer service index im authnrequest.</div>
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
	 * <div class="en">Building the destination on the authnrequest.</div>
	 * <div class="de">Bildet das destination im authnrequest.</div>
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
	 * <div class="en">Building the provider name on the authnrequest.</div>
	 * <div class="de">Bildet das destination im authnrequest.</div>
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
	 * <div class="en">Building the protocol binding on the authnrequest.</div>
	 * <div class="de">Bildet das protocol binding im authnrequest.</div>
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
	 * <div class="en">Building the consent on the authnrequest.</div>
	 * <div class="de">Bildet das consent im authnrequest.</div>
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
	 * <div class="en">Building the forceAuthn on the authnrequest.</div>
	 * <div class="de">Bildet das forceAuthn im authnrequest.</div>
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
	 * <div class="en">Builds the NameIDpolicy.AllowCreate on the authnrequest.</div>
	 * <div class="de">Bildet das NameIDpolicy.AllowCreate im authnrequest.</div>
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
	 * <div class="en">Builds the NameIDpolicy.Format on the authnrequest.</div>
	 * <div class="de">Bildet das NameIDpolicy.Format im authnrequest.</div>
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
	 * <div class="en">Builds the subject on the authnrequest.</div>
	 * <div class="de">Bildet das subject im authnrequest.</div>
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
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of AuthnRequest with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des AuthnRequests mit den gesetzten parametern.</div>
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
