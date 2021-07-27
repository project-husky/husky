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
package org.ehealth_connector.xua.communication.clients;

import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.saml2.ArtifactResolve;
import org.ehealth_connector.xua.saml2.ArtifactResponse;

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
