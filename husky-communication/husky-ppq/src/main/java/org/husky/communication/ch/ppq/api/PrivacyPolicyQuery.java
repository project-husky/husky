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
package org.husky.communication.ch.ppq.api;

import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.saml2.Base;

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
