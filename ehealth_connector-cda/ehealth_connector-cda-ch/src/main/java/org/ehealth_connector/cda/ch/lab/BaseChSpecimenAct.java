/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.ihe.lab.NotificationOrganizer;
import org.ehealth_connector.cda.ihe.lab.OutbreakIdentificationObservation;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The base SpecimenAct.
 */
public class BaseChSpecimenAct extends org.ehealth_connector.cda.ihe.lab.BaseLaboratoryAct {

	/**
	 * Instantiates a new specimen act.
	 */
	public BaseChSpecimenAct() {
		super();
		super.setStatusCode(StatusCode.COMPLETED.getCode());
	}

	/**
	 * Instantiates a new specimen act.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public BaseChSpecimenAct(Act mdht) {
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
	 * @param nonHumanSubject
	 *            the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public BaseChSpecimenAct(org.ehealth_connector.cda.ch.lab.lrqc.enums.SpecialtySections code,
			SpecimenCollectionEntry entry,
			org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer organizer,
			NonHumanSubject nonHumanSubject) {
		this();
		setCode(code.getCode());
		addSpecimenCollectionEntry(entry);
		addLaboratoryBatteryOrganizer(organizer);
		setNonHumanSubject(nonHumanSubject);
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
	 * @param nonHumanSubject
	 *            the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public BaseChSpecimenAct(org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections code,
			SpecimenCollectionEntry entry,
			org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryBatteryOrganizer organizer,
			NonHumanSubject nonHumanSubject) {
		this();
		setCode(code.getCode());
		addSpecimenCollectionEntry(entry);
		addLaboratoryBatteryOrganizer(organizer);
		setNonHumanSubject(nonHumanSubject);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		Organizer organizer = laboratoryBatteryOrganizer.copy();
		getMdht().addOrganizer(organizer);
		// Set the right type for the entryRelationship
		CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
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
		if (labIsolateOrganizer != null) {
			getMdht().addOrganizer(labIsolateOrganizer.copy());
			CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
					x_ActRelationshipEntryRelationship.COMP);
		}
	}

	/**
	 * Adds the specimen collection entry.
	 *
	 * @param entry
	 *            the entry
	 */
	public void addSpecimenCollectionEntry(SpecimenCollectionEntry entry) {
		getMdht().addProcedure(entry.copy());
		CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		return new Code(getMdht().getCode());
	}

	/**
	 * Gets the laboratory battery organizers.
	 *
	 * @return the laboratory battery organizers
	 */
	public List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer> getLrphLaboratoryBatteryOrganizers() {
		final List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer> list = new ArrayList<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer>();
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer(
							iheOrganizer));
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
	public List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer> getLrphLaboratoryIsolateOrganizers() {
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			final List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer> laboratoryOrganizerList = new ArrayList<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer>();
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer iheLabIsolateOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer) organizer;
					laboratoryOrganizerList.add(
							new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer(
									iheLabIsolateOrganizer));
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
	protected org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer getLrphNotificationOrganizer() {
		for (final Organizer o : getMdht().getOrganizers()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) {
				return new org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) o);
			}
		}
		return null;
	}

	/**
	 * Gets the laboratory battery organizers.
	 *
	 * @return the laboratory battery organizers
	 */
	public List<org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer> getLrqcLaboratoryBatteryOrganizers() {
		final List<org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer> list = new ArrayList<org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer>();
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer(
							iheOrganizer));
				}
			}
		}
		return list;
	}

	/**
	 * Gets information regarding the specimen.
	 *
	 * @return nonHumanSubject the specimen <div class="de">Angaben zur
	 *         Probe.</div>
	 */
	public NonHumanSubject getNonHumanSubject() {
		if (getMdht().getSubject() != null) {
			return new NonHumanSubject(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.NonHumanSubject) getMdht()
							.getSubject());
		}
		return null;
	}

	/**
	 * Gets the notification organizer.
	 *
	 * @return the notification organizer
	 */
	public NotificationOrganizer getNotificationOrganizer() {
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
	 * Gets a list with all specimen collection entries.
	 *
	 * @return the specimen collection entries list
	 */
	public List<SpecimenCollectionEntry> getSpecimenCollectionEntries() {
		final List<SpecimenCollectionEntry> scel = new ArrayList<SpecimenCollectionEntry>();
		for (final EntryRelationship e : getMdht().getEntryRelationships()) {
			if (e.getProcedure() instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) {
				scel.add(new SpecimenCollectionEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) e
								.getProcedure()));
			}
		}
		return scel;
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
	public void setCode(org.ehealth_connector.cda.ch.lab.lrqc.enums.SpecialtySections code) {
		getMdht().setCode(code.getCE());
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections code) {
		getMdht().setCode(code.getCE());
	}

	/**
	 * Sets information regarding the specimen.
	 *
	 * @param nonHumanSubject
	 *            the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public void setNonHumanSubject(NonHumanSubject nonHumanSubject) {
		getMdht().setSubject(nonHumanSubject.copy());
	}

	/**
	 * Sets the notification organizer.
	 *
	 * @param notificationOrganizer
	 *            the new notification organizer
	 */
	public void setNotificationOrganizer(NotificationOrganizer notificationOrganizer) {
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
		if (outbreakIdentification != null) {
			this.setNotificationOrganizer(
					new org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer());
			this.getNotificationOrganizer().setOutbreakIdentification(outbreakIdentification);
		}
	}

	/**
	 * Sets the specimen collection entry.
	 *
	 * @param entry
	 *            the new specimen collection entry
	 */
	public void setSpecimenCollectionEntry(
			org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry entry) {
		if (entry != null) {
			if (getSpecimenCollectionEntry() == null) {
				getMdht().addProcedure(entry.copy());
				CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
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
}
