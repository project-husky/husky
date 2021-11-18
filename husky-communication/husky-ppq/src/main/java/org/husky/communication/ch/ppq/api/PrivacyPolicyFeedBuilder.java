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
package org.husky.communication.ch.ppq.api;

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the PrivacyPolicyFeedBuilder.</div>
 * <div class="de">Interface welches die Methoden für den PrivacyPolicyFeedBuilder beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyFeedBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of PrivacyPolicyFeed with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des PrivacyPolicyFeed mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new PrivacyPolicyFeed instance with the params set</div>
	 *  <div class="de">eine neue PrivacyPolicyFeed Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	PrivacyPolicyFeed create();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the method of the PrivacyPolicyFeedResponse to be build.</div>
	 * <div class="de">Methode um eine Methode dem PrivacyPolicyFeedResponse hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aMethod
	 *  <div class="en">the method of the request which will be set</div>
	 * 	<div class="de">die Methode des Requests die gesetzt werden soll.</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedBuilder method(PpfMethod aMethod);
}
