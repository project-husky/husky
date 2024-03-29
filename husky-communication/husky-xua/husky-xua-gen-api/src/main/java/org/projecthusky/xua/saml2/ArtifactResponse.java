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
package org.projecthusky.xua.saml2;

import java.util.List;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of ArtifactResponse. </div>
 * <div class="de">Interface welches die Methoden von ArtifactResponse beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface ArtifactResponse extends SignatureBase {

	/**
	 *
	 * <!-- @formatter:off -->
	 *<div class="en">Method to get Consent value.</div>
	 * <div class="de">Methode um den Consent wert zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Destination value as {@link java.lang.String}.</div>
	 * <div class="de">der Destination Wert als {@link java.lang.String}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getConsent();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get Destination value.</div>
	 * <div class="de">Methode um den Inhalt der Destination zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Destination value as {@link java.lang.String}.</div>
	 * <div class="de">der Inhalt der Destination als {@link java.lang.String}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getDestination();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get InResponseTo value.</div>
	 * <div class="de">Methode um den InResponseTo zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the InResponseTo value as {@link java.lang.String}.</div>
	 * <div class="de">der InResponseTo Wert als {@link java.lang.String}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getInResponseTo();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get a list of Response.</div>
	 * <div class="de">Methode um die Liste von Responses zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *@return
	 * <div class="en">a {@link java.util.List} of {@link org.projecthusky.xua.saml2.Response}.</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.projecthusky.xua.saml2.Response}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<Response> getResponses();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Status.</div>
	 * <div class="de">Methode um den Status zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Status value as {@link org.projecthusky.xua.saml2.Status}.</div>
	 * <div class="de">der Status als {@link org.projecthusky.xua.saml2.Status}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Status getStatus();

}
