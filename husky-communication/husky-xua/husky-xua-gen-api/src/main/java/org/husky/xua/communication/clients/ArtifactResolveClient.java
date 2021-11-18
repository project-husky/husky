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
package org.husky.xua.communication.clients;

import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.saml2.ArtifactResolve;
import org.husky.xua.saml2.ArtifactResponse;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
public interface ArtifactResolveClient {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to send an  ArtifactResolve.</div>
	 * <div class="de">Methode um einen  ArtifactResolve zu senden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aArtifactResolve
	 * <div class="en">the AuthnRequest to be sent.</div>
	 * <div class="de">Der AuthnRequest welcher geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the ArtifactResponse</div>
	 * <div class="de">Die ArtifactResponse.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	ArtifactResponse send(ArtifactResolve aArtifactResolve) throws ClientSendException;
}
