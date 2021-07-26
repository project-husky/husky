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
package org.ehealth_connector.security.communication.clients;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the identity provider client.</div>
 * <div class="de">Interface welches die Methoden für den Identity Provider Client beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface IdpClient {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to send an AuthnRequest.</div>
	 * <div class="de">Methode um einen AuthnRequest zu senden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAuthnRequest
	 * <div class="en">the AuthnRequest to be sent.</div>
	 * <div class="de">Der AuthnRequest welcher geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the idp response</div>
	 * <div class="de">Die IdP Response.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Object send(AuthnRequest aAuthnRequest) throws ClientSendException;
}
