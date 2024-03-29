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

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the privacy policy admin client</div>
 * <div class="de">Interface welches die Methoden für den Privacy Policy Admin Client beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PpfClient {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to send an Add, Update or DeletePolicyRequest.</div>
	 * <div class="de">Methode um einen  Add, Update oder DeletePolicyRequest zu senden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertion
	 * <div class="en">the Assertion to be sent in the soap security header</div>
	 * <div class="de">Die Assertion welche im SOAP security header mitgeschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param request
	 * <div class="en">the PrivacyPolicyFeed to be sent.</div>
	 * <div class="de">Die PrivacyPolicyFeed welche geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the PrivacyPolicyFeedResponse</div>
	 * <div class="de">Die PrivacyPolicyFeedResponse.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedResponse send(SecurityHeaderElement aAssertion, PrivacyPolicyFeed request)
			throws ClientSendException;

}
