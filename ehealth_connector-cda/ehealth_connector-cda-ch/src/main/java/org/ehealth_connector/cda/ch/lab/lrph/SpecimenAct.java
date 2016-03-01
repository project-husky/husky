package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.AbstractSpecimenAct {

	public SpecimenAct() {
		super();
	}

	public SpecimenAct(Act mdht) {
		super(mdht);
	}

	// Required Elements
	public SpecimenAct(Code code, org.ehealth_connector.cda.ch.lab.lrph.SpecimenCollectionEntry entry,
			LaboratoryBatteryOrganizer organizer) {
		this();
		setCode(code);
		setSpecimenCollectionEntry(entry);
		addLaboratoryBatteryOrganizer(organizer);
	}

	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	public void addLaboratoryIsolateOrganizer(
			org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer labIsolateOrganizer) {
		getMdht().addOrganizer(labIsolateOrganizer.copy());
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		ArrayList<LaboratoryBatteryOrganizer> list = new ArrayList<LaboratoryBatteryOrganizer>();
		if (getMdht() != null && getMdht().getOrganizers() != null) {
			for (Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new LaboratoryBatteryOrganizer(iheOrganizer));
				}
			}
		}
		return list;
	}

	public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizers() {
		if (getMdht() != null && getMdht().getOrganizers() != null) {
			ArrayList<LaboratoryIsolateOrganizer> laboratoryOrganizerList = new ArrayList<LaboratoryIsolateOrganizer>();
			for (Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer) {
					org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer iheLabIsolateOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer) organizer;
					laboratoryOrganizerList.add(new LaboratoryIsolateOrganizer(iheLabIsolateOrganizer));
				}
			}
			return laboratoryOrganizerList;
		}
		return null;
	}

	protected org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer getNotificationOrganizer() {
		for (Organizer o : getMdht().getOrganizers()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) {
				return new NotificationOrganizer(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer) o);
			}
		}
		return null;
		// TODO
		// return new org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer(
		// getMdht().getNotificationOrganizers().get(0));
	}

	public OutbreakIdentificationObservation getOutbreakIdentification() {
		return this.getNotificationOrganizer().getOutbreakIdentificationObservation();
	}

	public SpecimenCollectionEntry getSpecimenCollectionEntry() {
		for (EntryRelationship e : getMdht().getEntryRelationships()) {
			if (e.getProcedure() instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) {
				return new org.ehealth_connector.cda.ch.lab.lrph.SpecimenCollectionEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) e.getProcedure());
			}
		}
		return null;
	}

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
		}
	}

	// Convenience Method that creates the NotificationOrganizer automatically
	public void setOutbreakIdentification(
			org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation outbreakIdentification) {
		this.setNotificationOrganizer(
				new org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer());
		this.getNotificationOrganizer().setOutbreakIdentification(outbreakIdentification);
	}

	public void setSpecimenCollectionEntry(
			org.ehealth_connector.cda.ch.lab.lrph.SpecimenCollectionEntry entry) {
		getMdht().addProcedure(entry.copy());
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

}
