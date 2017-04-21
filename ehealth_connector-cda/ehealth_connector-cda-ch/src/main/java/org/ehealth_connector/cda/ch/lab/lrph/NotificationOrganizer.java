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
package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.common.enums.StatusCode;

/**
 * The Class NotificationOrganizer. <div class="en">A specimen act MAY contain
 * information about the reportable germs or the cumulation of epidemiologic
 * observations.</div> <div class="de">Eine Probenuntersuchung KANN nach der
 * Vorlage von IHE XD-LAB Angaben zur Meldepflicht von Erregernachweisen oder zu
 * Häufung von Beobachtungen resp. besonderen epidemiologisch relevanten
 * Ereignissen enthalten. </div>
 */
public class NotificationOrganizer extends org.ehealth_connector.cda.ihe.lab.NotificationOrganizer {

	/**
	 * Instantiates a new notification organizer.
	 */
	public NotificationOrganizer() {
		super();
		setStatusCode(StatusCode.COMPLETED);
	}

	/**
	 * Instantiates a new notification organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public NotificationOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer mdht) {
		super(mdht);
	}

	/**
	 * Instantiates a new notification organizer.
	 *
	 * @param observation
	 *            the observation
	 */
	// Required Elements
	public NotificationOrganizer(OutbreakIdentificationObservation observation) {
		this();
		setOutbreakIdentification(observation);
	}

	/**
	 * Gets the outbreak identification observation.
	 *
	 * @return the outbreak identification observation
	 */
	public OutbreakIdentificationObservation getOutbreakIdentificationObservation() {
		return new OutbreakIdentificationObservation(getMdht().getOutbreakIdentifications().get(0));
	}

	/**
	 * * <div class="en">This element will be added, according to
	 * [Melde-Verordnung EDI].</div> <div class="de">Dieses Element wird dann
	 * angegeben, wenn gemäss [Melde-Verordnung EDI] Beobachtungen über dem für
	 * den betreffenden Zeitpunkt und Ort zu erwartenden Niveau festgestellt
	 * werden, die sonst nicht innerhalb von 24 Stunden oder gar nicht gemeldet
	 * werden müssen. </div>
	 *
	 * @param outbreakIdentification
	 *            the outbreak identification
	 */
	public void setOutbreakIdentification(
			OutbreakIdentificationObservation outbreakIdentification) {
		if (!getMdht().getOutbreakIdentifications().isEmpty()) {
			getMdht().getComponents().clear();
			getMdht().addObservation(outbreakIdentification.copy());
		} else {
			getMdht().addObservation(outbreakIdentification.copy());
		}
	}
}
