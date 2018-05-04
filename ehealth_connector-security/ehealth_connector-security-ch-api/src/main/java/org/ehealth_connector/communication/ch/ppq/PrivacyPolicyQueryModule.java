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
package org.ehealth_connector.communication.ch.ppq;

import org.ehealth_connector.communication.ch.ppq.config.PpqClientConfig;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.saml2.Response;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the CH:PPQ communication Interface</div>
 * <div class="de">Beschreibung der Methoden des CH:PPQ kommunikations Interface</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyQueryModule {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to invoke the PrivacyPolicyQuery.</div>
	 * <div class="de">Mkethode um die PrivacyPolicyQuery auszuführen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAssertion
	 * <div class="en">the Assertion to be added to the soap security header.</div>
	 * <div class="de">Die Assertion die dem SOAP Security Header hinzugefügt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param query
	 * <div class="en">the PrivacyPolicyQuery to be sent.</div>
	 * <div class="de">Die PrivacyPolicyQuery die gesendet werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param clientConfiguration
	 * <div class="en">the PpqClientConfig to configure the client.</div>
	 * <div class="de">Die PrivacyPolicyQuery  um den client zu konfigurieren.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the PrivacyPolicyQueryResponse be received.</div>
	 * <div class="de">Die PrivacyPolicyQueryResponse der empfangen wird.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws ClientSendException 
	 * <div class="en">will be thrown an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	Response invokePPQ(SecurityHeaderElement aAssertion, PrivacyPolicyQuery query, PpqClientConfig clientConfiguration)
			throws ClientSendException;

}
