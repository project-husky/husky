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
package org.ehealth_connector.security.ch.ppq;

import org.ehealth_connector.security.hl7v3.InstanceIdentifier;
import org.ehealth_connector.security.saml2.Base;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the PatentPrivacyQuery Interface</div>
 * <div class="de">Beschreibung der Methoden des PatentPrivacyQuery Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyQuery extends Base {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the consent value.</div>
	 * <div class="de">Methode um den Inhalt des Consent zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the consent value as string</div>
	 *  <div class="de">der Inhalt des Consent als String</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getConsent();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the destination value.</div>
	 * <div class="de">Methode um den Inhalt der Destination zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the destination value as string</div>
	 *  <div class="de">der Inhalt der Destination als String</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getDestination();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the InstanceIdentifier value.</div>
	 * <div class="de">Methode um den InstanceIdentifier zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return
	 *  <div class="en">the InstanceIdentifier </div>
	 *  <div class="de">den InstanceIdentifier</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	InstanceIdentifier getInstanceIdentifier();

}
