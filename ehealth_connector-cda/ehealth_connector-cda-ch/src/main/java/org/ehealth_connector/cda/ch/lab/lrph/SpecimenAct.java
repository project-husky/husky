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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrph.enums.LrphSections;
import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class SpecimenAct <div class="de">Probenuntersuchung</div>.
 */
public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.AbstractSpecimenAct {

	/**
	 * Standard constructor.
	 */
	public SpecimenAct() {
		super();
	}

	/**
	 * Instantiates this class with the underlying MDHT object.
	 *
	 * @param mdht
	 *            the MDHT object
	 */
	public SpecimenAct(Act mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code for the SpecimenAct
	 * @param entry
	 *            the SpecimenCollectionEntry
	 * @param organizer
	 *            the LaboratoryBatteryOrganizer
	 */
	public SpecimenAct(LrphSections code,
			org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry entry,
			LaboratoryBatteryOrganizer organizer) {
		this();
		setCode(code);
		setSpecimenCollectionEntry(entry);
		addLaboratoryBatteryOrganizer(organizer);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Adds the laboratory isolate organizer.
	 *
	 * @param labIsolateOrganizer
	 *            the lab isolate organizer
	 */
	public void addLaboratoryIsolateOrganizer(
			org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer labIsolateOrganizer) {
		getMdht().addOrganizer(labIsolateOrganizer.copy());
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Gets the laboratory battery organizers.
	 *
	 * @return the laboratory battery organizers
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		final List<LaboratoryBatteryOrganizer> list = new ArrayList<LaboratoryBatteryOrganizer>();
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new LaboratoryBatteryOrganizer(iheOrganizer));
				}
			}
		}
		return list;
	}

	/**
	 * Gets the laboratory isolate organizers.
	 *
	 * @return the laboratory isolate organizers
	 */
	public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizers() {
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			final List<LaboratoryIsolateOrganizer> laboratoryOrganizerList = new ArrayList<LaboratoryIsolateOrganizer>();
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer iheLabIsolateOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer) organizer;
					laboratoryOrganizerList
							.add(new LaboratoryIsolateOrganizer(iheLabIsolateOrganizer));
				}
			}
			return laboratoryOrganizerList;
		}
		return null;
	}

	/**
	 * Gets the notification organizer.
	 *
	 * @return the notification organizer
	 */
	protected org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer getNotificationOrganizer() {
		for (final Organizer o : getMdht().getOrganizers()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) {
				return new NotificationOrganizer(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) o);
			}
		}
		return null;
	}

	/**
	 * Gets the outbreak identification.
	 *
	 * @return the outbreak identification
	 */
	public OutbreakIdentificationObservation getOutbreakIdentification() {
		if ((this.getNotificationOrganizer() != null) && (this.getNotificationOrganizer()
				.getOutbreakIdentificationObservation() != null)) {
			return this.getNotificationOrganizer().getOutbreakIdentificationObservation();
		}
		return null;
	}

	/**
	 * Gets the specimen collection entry.
	 *
	 * @return the specimen collection entry
	 */
	public SpecimenCollectionEntry getSpecimenCollectionEntry() {
		for (final EntryRelationship e : getMdht().getEntryRelationships()) {
			if (e.getProcedure() instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) {
				return new org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) e
								.getProcedure());
			}
		}
		return null;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(LrphSections code) {
		getMdht().setCode(code.getCE());
	}

	/**
	 * Sets the notification organizer.
	 *
	 * @param notificationOrganizer
	 *            the new notification organizer
	 */
	protected void setNotificationOrganizer(
			org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer notificationOrganizer) {
		// Check if the element already exist, if so, replace it, if not add it
		boolean added = false;
		for (Organizer o : getMdht().getOrganizers()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) {
				o = notificationOrganizer.copy();
				added = true;
			}
		}
		if (added == false) {
			getMdht().addOrganizer(notificationOrganizer.copy());
			final int nb = getMdht().getEntryRelationships().size() - 1;
			getMdht().getEntryRelationships().get(nb)
					.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		}
	}

	/**
	 * Sets the outbreak identification. Convenience Method that creates the
	 * NotificationOrganizer automatically.
	 *
	 * @param outbreakIdentification
	 *            the new outbreak identification
	 */
	public void setOutbreakIdentification(
			org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation outbreakIdentification) {
		this.setNotificationOrganizer(
				new org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer());
		this.getNotificationOrganizer().setOutbreakIdentification(outbreakIdentification);
	}

	/**
	 * Sets the specimen collection entry.
	 *
	 * @param entry
	 *            the new specimen collection entry
	 */
	public void setSpecimenCollectionEntry(
			org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry entry) {
		if (getSpecimenCollectionEntry() == null) {
			getMdht().addProcedure(entry.copy());
			CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
					x_ActRelationshipEntryRelationship.COMP);
		} else {
			for (final EntryRelationship er : getMdht().getEntryRelationships()) {
				if (er.getProcedure() instanceof SpecimenCollection) {
					er.setProcedure(entry.copy());
				}
			}
		}
	}

}
