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

import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeed.PpfMethod;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the PrivacyPolicyFeedResponse.</div>
 * <div class="de">Interface welches die Methoden für den PrivacyPolicyFeedResponse beschreiben.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyFeedResponse {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the status of the Response.</div>
	 * <div class="de">Methode um den status der Antwort zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <!-- @formatter:off -->
	 * <div class="en">the status as string</div>
	 * <div class="de">den Status als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getStatus();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the method of the response.</div>
	 * <div class="de">Methode um die methode des requests zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the {@link org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeed.PpfMethod} which is set.</div>
	 * <div class="de">dei {@link org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeed.PpfMethod} die gesetzt ist.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	PpfMethod getMethod();

}
