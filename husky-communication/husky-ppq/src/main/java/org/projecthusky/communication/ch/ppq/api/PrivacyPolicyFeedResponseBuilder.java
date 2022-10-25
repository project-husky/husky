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
package org.projecthusky.communication.ch.ppq.api;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the PrivacyPolicyFeedResponseBuilder</div>
 * <div class="de">Interface welches die Methoden für den Privacy Policy Feed beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyFeedResponseBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of PrivacyPolicyFeedResponse with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des PrivacyPolicyFeedResponse mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new PrivacyPolicyFeedResponse instance with the params set</div>
	 *  <div class="de">eine neue PrivacyPolicyFeedResponse Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedResponse create();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the exception to be build.</div>
	 * <div class="de">Methode um eine Exception hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aException
	 *  <div class="en">the exception extracted from the message.</div>
	 * 	<div class="de">der Fehler der aus der Meldung gelesen wurde.</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedResponseBuilder exception(Exception aException);

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
	PrivacyPolicyFeedResponseBuilder method(PpfMethod aMethod);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the status of the PrivacyPolicyFeedResponse to be build.</div>
	 * <div class="de">Methode um ein Status dem PrivacyPolicyFeedResponse hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aStatus
	 *  <div class="en">the consent to be set</div>
	 * 	<div class="de">der Consent der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PrivacyPolicyFeedResponseBuilder status(String aStatus);

}
