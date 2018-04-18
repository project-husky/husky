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
package org.ehealth_connector.communication.ch.clients;

import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQueryResponse;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.saml2.Assertion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the privacy policy client</div>
 * <div class="de">Interface welches die Methoden für den Privacy Policy Client beschreiben.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PpqClient {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to send an PrivacyPolicyQuery.</div>
	 * <div class="de">Methode um einene PrivacyPolicyQuery zu senden.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAssertion
	 * <div class="en">the Assertion to be sent in the soap security header</div>
	 * <div class="de">Die Assertion welches im soap security header mitgeschickt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param query
	 * <div class="en">the PrivacyPolicyQuery to be sent.</div>
	 * <div class="de">Die PrivacyPolicyQuery welches geschickt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the PrivacyPolicyQueryResponse</div>
	 * <div class="de">Die PrivacyPolicyQueryResponse.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyQueryResponse send(Assertion aAssertion, PrivacyPolicyQuery query) throws ClientSendException;

}
