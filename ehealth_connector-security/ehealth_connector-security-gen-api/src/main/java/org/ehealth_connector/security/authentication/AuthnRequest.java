/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.authentication;

import org.ehealth_connector.security.saml2.Base;
import org.ehealth_connector.security.saml2.Subject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of authnrequest.</div>
 * <div class="de">Interface beschreibt die methoden für den authnrequest.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AuthnRequest extends Base {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the assertion consumer service index.</div>
	 * <div class="de">Methode um den assertion consumer service index zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the assertion consumer service index as integer</div>
	 *  <div class="de">der assertion consumer service index wert als string</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	Integer getAssertionConsumerServiceIndex();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get assertion consumer service url.</div>
	 * <div class="de">Method um die assertion consumer service url zu holen .</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the assertion consumer service url as string
	 */
	String getAssertionConsumerServiceURL();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get attribute consumer service index.</div>
	 * <div class="de">Method um den attribute consumer service index zu holen.</div>
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
	 * <div class="de">Methode um den consent zu holen.</div>
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
	 * <div class="de">Methode um die destination zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the destination value.</div>
	 * <div class="de">the Destination Wert</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getDestination();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the forceauthn value.</div>
	 * <div class="de">Methode um den forceauthn wert zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return the force authn value
	 */
	Boolean getForceAuthn();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the nameidpolicy allowcreate value.</div>
	 * <div class="de">Methode um den nameidpolicy allowcreate wert zu holen.</div>
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
	 * <div class="en">Method to get the nameidpolicy format value.</div>
	 * <div class="de">Methode um den nameidpolicy format wert zu holen.</div>
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
	 * <div class="en">Method to get the protocol binding value.</div>
	 * <div class="de">Methode um den protocol binding wert zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the protocol binding value as string</div>
	 *  <div class="de">der protocol binding wert als string</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getProtocolBinding();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the provider name.</div>
	 * <div class="de">Methode um den provider name zu holen.</div>
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
	Subject getSubject();
}
