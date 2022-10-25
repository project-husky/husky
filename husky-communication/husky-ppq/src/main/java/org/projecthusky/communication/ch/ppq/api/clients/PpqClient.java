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
package org.projecthusky.communication.ch.ppq.api.clients;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the privacy policy query client</div>
 * <div class="de">Interface welches die Methoden für den Privacy Policy Query Client beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PpqClient {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to send an PrivacyPolicyQuery.</div>
	 * <div class="de">Methode um eine PrivacyPolicyQuery zu senden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertion
	 * <div class="en">the Assertion to be sent in the soap security header</div>
	 * <div class="de">Die Assertion welches im soap security header mitgeschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param query
	 * <div class="en">the PrivacyPolicyQuery to be sent.</div>
	 * <div class="de">Das PrivacyPolicyQuery welches geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the Response</div>
	 * <div class="de">Die Response.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">Wird geworfen, wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyQueryResponse send(SecurityHeaderElement aAssertion, PrivacyPolicyQuery query)
			throws ClientSendException;

}
