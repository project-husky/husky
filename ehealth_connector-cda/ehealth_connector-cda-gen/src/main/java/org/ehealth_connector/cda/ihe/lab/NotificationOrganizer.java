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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class NotificationOrganizer. The document MAY contain a Notification
 * Organizer in an entryRelationship under the Specimen Act of a Laboratory Data
 * Processing Entry as demonstrated. This organizer SHALL be present when any of
 * the following Notifications are present: Notifiable Condition, Case
 * Identification, and/or Outbreak Identification.
 */
public class NotificationOrganizer extends
		MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer> {

	/**
	 * Instantiates a new notification organizer.
	 */
	public NotificationOrganizer() {
		super(LABFactory.eINSTANCE.createNotificationOrganizer().init());
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
		if (outbreakIdentification != null) {
			if (!getMdht().getOutbreakIdentifications().isEmpty()) {
				getMdht().getComponents().clear();
				getMdht().addObservation(outbreakIdentification.copy());
			} else {
				getMdht().addObservation(outbreakIdentification.copy());
			}
		}
	}
}
