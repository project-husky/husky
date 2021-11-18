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
package org.husky.xua.authentication;

import org.husky.xua.saml2.Base;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of AuthnRequest.</div>
 * <div class="de">Interface welches die Methoden für den AuthnRequest beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AuthnRequest extends Base {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the assertion consumer service index.</div>
	 * <div class="de">Methode um den Assertion Consumer Service Index zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the assertion consumer service index as integer</div>
	 *  <div class="de">der Assertion Consumer Service index Wert als string</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	Integer getAssertionConsumerServiceIndex();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get assertion consumer service url.</div>
	 * <div class="de">Methode um die Assertion Consumer Service URL zu holen .</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the assertion consumer service url as string
	 */
	String getAssertionConsumerServiceUrl();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get attribute consumer service index.</div>
	 * <div class="de">Methode um den Attribute Consumer Service Index zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the attribute consumer service index as integer
	 */
	Integer getAttributeConsumingServiceIndex();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the consent.</div>
	 * <div class="de">Methode um den Consent zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return the consent as string
	 * <!-- @formatter:on -->
	 */
	String getConsent();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the destination.</div>
	 * <div class="de">Methode um die Destination zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the destination value.</div>
	 * <div class="de">der Inhalt von Destination.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getDestination();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the ForceAuthn value.</div>
	 * <div class="de">Methode um den ForceAuthn wert zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the force authn value
	 */
	Boolean getForceAuthn();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameIdPolicy.AllowCreate value.</div>
	 * <div class="de">Methode um den NameIdPolicy.AllowCreate Wert zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 * <div class="en">the NameIdPolicy.AllowCreate value.</div>
	 * <div class="de">the NameIdPolicy.AllowCreate Wert</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Boolean getNameIdPolicyAllowCreate();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameIdPolicy.Format value.</div>
	 * <div class="de">Methode um den NameIdPolicy.Format Wert zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the NameIdPolicy.Format as string
	 */
	String getNameIdPolicyFormat();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the ProtocolBinding value.</div>
	 * <div class="de">Methode um den ProtocolBinding Wert zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the ProtocolBinding value as string</div>
	 *  <div class="de">der ProtocolBinding Wert als string</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getProtocolBinding();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the provider name.</div>
	 * <div class="de">Methode um den Provider Namen zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the provider name as string
	 */
	String getProviderName();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <<div class="en">Method to get the subject value.</div>
	 * <div class="de">Methode um das Subject zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the subject
	 */
	SubjectType getSubject();
}
