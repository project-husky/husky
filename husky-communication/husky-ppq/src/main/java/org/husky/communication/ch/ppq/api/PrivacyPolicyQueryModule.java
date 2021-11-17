/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.ppq.api;

import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the CH:PPQ communication Interface</div>
 * <div class="de">Beschreibung der Methoden des CH:PPQ Kommunikations-Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyQueryModule {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to invoke the PrivacyPolicyFeed.</div>
	 * <div class="de">Methode um die PrivacyPolicyFeed auszuführen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertion
	 * <div class="en">the Assertion to be added to the soap security header.</div>
	 * <div class="de">Die Assertion die dem SOAP Security Header hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param feed
	 * <div class="en">the PrivacyPolicyFeed to be sent.</div>
	 * <div class="de">Die PrivacyPolicyFeed die gesendet werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param clientConfiguration
	 * <div class="en">the PpClientConfig to configure the client.</div>
	 * <div class="de">Die PrivacyPolicyQuery um den Client zu konfigurieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the PrivacyPolicyFeedResponse be received.</div>
	 * <div class="de">Die PrivacyPolicyFeedResponse die empfangen wird.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedResponse invokePrivacyPolicyFeed(SecurityHeaderElement aAssertion,
			PrivacyPolicyFeed feed, PpClientConfig clientConfiguration) throws ClientSendException;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to invoke the PrivacyPolicyQuery.</div>
	 * <div class="de">Methode um die PrivacyPolicyQuery auszuführen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAssertion
	 * <div class="en">the Assertion to be added to the soap security header.</div>
	 * <div class="de">Die Assertion die dem SOAP Security Header hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param query
	 * <div class="en">the PrivacyPolicyQuery to be sent.</div>
	 * <div class="de">Die PrivacyPolicyQuery die gesendet werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param clientConfiguration
	 * <div class="en">the PpClientConfig to configure the client.</div>
	 * <div class="de">Die PrivacyPolicyQuery um den Client zu konfigurieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the PrivacyPolicyQueryResponse be received.</div>
	 * <div class="de">Die PrivacyPolicyQueryResponse die empfangen wird.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyQueryResponse invokePrivacyPolicyQuery(SecurityHeaderElement aAssertion, PrivacyPolicyQuery query,
			PpClientConfig clientConfiguration) throws ClientSendException;

}
