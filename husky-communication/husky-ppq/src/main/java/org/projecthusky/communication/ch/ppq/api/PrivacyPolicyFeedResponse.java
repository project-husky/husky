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

import java.util.List;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the PrivacyPolicyFeedResponse.</div>
 * <div class="de">Interface welches die Methoden für den PrivacyPolicyFeedResponse beschreiben.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PrivacyPolicyFeedResponse {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the list of errors if available.</div>
	 * <div class="de">Liefert die Liste von Fehlern, falls vorhanden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link java.lang.Exception} with exceptions if available.</div>
	 * <div class="de">eine {@link java.util.List} von {@link java.lang.Exception} mit Fehlern, wenn vorhanden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<Exception> getExceptions();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the method of the response.</div>
	 * <div class="de">Methode um die Methode des Requests zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the {@link org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod} which is set.</div>
	 * <div class="de">die {@link org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod} die gesetzt ist.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	PpfMethod getMethod();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the status of the Response.</div>
	 * <div class="de">Methode um den Status der Antwort zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <!-- @formatter:off -->
	 * <div class="en">the status as string</div>
	 * <div class="de">den Status als String</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getStatus();

	/**
	 * Checks whether the response contains a successful status.
	 *
	 * @return True in case of success. False in case of failure
	 */
	Boolean isStatusSuccess();
}
