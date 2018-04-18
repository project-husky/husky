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
 * <div class="en">Interface describing the methods for the PrivacyPolicyFeedBuilder.</div>
 * <div class="de">Interface welches die Methoden für den PrivacyPolicyFeedBuilder beschreiben.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyFeedBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the method of the PrivacyPolicyFeedResponse to be build.</div>
	 * <div class="de">Methode um ein method dem PrivacyPolicyFeedResponse hinzuzufügen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aMethod
	 *  <div class="en">the method of the request which will be set</div>
	 * 	<div class="de">die Methode des Requests die gesetzt werden soll.</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedBuilder method(PpfMethod aMethod);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of PrivacyPolicyFeed with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des PrivacyPolicyFeed mit den gesetzten parametern.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new PrivacyPolicyFeed instance with the params set</div>
	 *  <div class="de">eine neue PrivacyPolicyFeed instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	PrivacyPolicyFeed create();
}
