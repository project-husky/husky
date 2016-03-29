/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
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
}
