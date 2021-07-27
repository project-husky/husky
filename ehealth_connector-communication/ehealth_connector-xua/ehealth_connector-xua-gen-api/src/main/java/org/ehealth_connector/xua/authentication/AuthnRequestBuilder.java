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
package org.ehealth_connector.xua.authentication;

import org.ehealth_connector.xua.saml2.BaseBuilder;
import org.ehealth_connector.xua.saml2.Subject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the AuthnRequest builder methods.</div>
 * <div class="de">Interface welches die Methoden des AuthnRequest Builders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AuthnRequestBuilder extends BaseBuilder<AuthnRequestBuilder> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the assertion consumer service index in the AuthnRequest.</div>
	 * <div class="de">Buildet den Assertion Consumer Service Index im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertionConsumerServiceIndex
	 *  <div class="en">the assertion consumer service index to be set</div>
	 * 	<div class="de">Der Assertion Consumer Service Index der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder assertionConsumerServiceIndex(Integer aAssertionConsumerServiceIndex);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the assertion consumer service url on the AuthnRequest.</div>
	 * <div class="de">Bildet die Assertion Consumer W`Service url im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertionConsumerServiceURL
	 *  <div class="en">the assertion consumer service url to be set</div>
	 * 	<div class="de">die Assertion Consumer Service URL die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder assertionConsumerServiceUrl(String aAssertionConsumerServiceURL);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the attribute consumer service index on the AuthnRequest.</div>
	 * <div class="de">Buildet den Attribute Consumer Service Index im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAttributeConsumingServiceIndex
	 *  <div class="en">the attribute consuming service index to be set</div>
	 * 	<div class="de">der Attribute Consuming Service Index der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder attributeConsumingServiceIndex(Integer aAttributeConsumingServiceIndex);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Building the consent on the AuthnRequest.</div>
	 * <div class="de">Bildet den Consent im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aConsent
	 *  <div class="en">the consent to be set</div>
	 * 	<div class="de">der Consent der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder consent(String aConsent);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of AuthnRequest with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des AuthnRequests mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new AuthnRequest instance with the params set</div>
	 *  <div class="de">eine neue AuthRequest Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequest create();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Building the destination on the AuthnRequest.</div>
	 * <div class="de">Bildet die Destination im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aDestination
	 *  <div class="en">the destination to be set</div>
	 * 	<div class="de">die Destination die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder destination(String aDestination);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Building the forceAuthn attribute in the AuthnRequest.</div>
	 * <div class="de">Bildet das forceAuthn Attribut im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aForceAuthn
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder forceAuthn(Boolean aForceAuthn);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the NameIDpolicy.AllowCreate attribute in the AuthnRequest.</div>
	 * <div class="de">Bildet das NameIDpolicy.AllowCreate Attribut im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNameIdPolicyAllowCreate
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder nameIdPolicyAllowCreate(Boolean aNameIdPolicyAllowCreate);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the NameIDpolicy.Format attribute in the AuthnRequest.</div>
	 * <div class="de">Bildet das NameIDpolicy.Format Attribut im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNameIdPolicyFormat
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder nameIdPolicyFormat(String aNameIdPolicyFormat);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Building the ProtocolBinding attribute in the AuthnRequest.</div>
	 * <div class="de">Bildet das ProtocolBinding Attribut im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aProtocolBinding
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder protocolBinding(String aProtocolBinding);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the ProviderID attribute in the AuthnRequest.</div>
	 * <div class="de">Bildet das ProviderID Attribut im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aProviderID
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AuthnRequestBuilder providerId(String aProviderID);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Building the provider name on the AuthnRequest.</div>
	 * <div class="de">Bildet das Proivider Namen im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aProviderName
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder providerName(String aProviderName);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the subject attribute in the AuthnRequest.</div>
	 * <div class="de">Bildet das Subject Attribut im AuthnRequest.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSubject
	 *  <div class="en">the value to be set</div>
	 * 	<div class="de">der Wert der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AuthnRequestBuilder subject(Subject aSubject);

}
