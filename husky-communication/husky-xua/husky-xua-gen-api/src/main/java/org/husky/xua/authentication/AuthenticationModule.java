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

import org.husky.xua.communication.config.IdpClientConfig;
import org.husky.xua.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the Authentication Module Interface</div>
 * <div class="de">Beschreibung der Methoden des Authentication Module Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AuthenticationModule {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the authentication assertion from an idp.</div>
	 * <div class="de">Methode um die Authentifizierungs-Assertion eines IdP zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAuthnRequest
	 * <div class="en">The AuthnRequest to be sent to the IdP.</div>
	 * <div class="de">Der AuthnRequest der zum IdP geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param clientConfiguration
	 * <div class="en">The client configuration to be used to communicate with the IdP service.</div>
	 * <div class="de">Die Client Konfiguration die gebraucht wird um mit dem Service des IdP zu kommunizieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The response to the AuthnRequest from IdP service. Response or Artifact String</div>
	 * <div class="de">Die Antwort auf eine AuthnRequest des IdP Services.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 * @throws ClientSendException
	 */
	Object invokeUserAuthentication(AuthnRequest aAuthnRequest, IdpClientConfig clientConfiguration)
			throws ClientSendException;

}
