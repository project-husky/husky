package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation;
import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public abstract class AbstractSpecimenAct
		extends org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct {

	public AbstractSpecimenAct() {
		super();
	}

	public AbstractSpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
		super.setStatusCode(StatusCode.COMPLETED.getCode());
	}

	public void addLaboratoryIsolateOrganizer(LaboratoryIsolateOrganizer labIsolateOrganizer) {
		getMdht().addOrganizer(labIsolateOrganizer.copy());
	}

	public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizers() {
		if (getMdht() != null && getMdht().getLaboratoryIsolateOrganizers() != null) {
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

	public org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer getNotificationOrganizer() {
		return new org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer(
				getMdht().getNotificationOrganizers().get(0));
	}

	public OutbreakIdentificationObservation getOutbreakIdentification() {
		return this.getNotificationOrganizer().getOutbreakIdentificationObservation();
	}

	public SpecimenCollectionEntry getSpecimenCollectionEntry() {
		return new SpecimenCollectionEntry(getMdht().getSpecimenCollections().get(0));
	}

	public void setNotificationOrganizer(
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

	public void setSpecimenCollectionEntry(SpecimenCollectionEntry entry) {
		getMdht().addProcedure(entry.copy());
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}
}
