package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification;

public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.SpecimenAct {

	public SpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
	}

	public void addLaboratoryIsolateOrganizer(LaboratoryIsolateOrganizer labIsolateOrganizer) {
		getMdht().addOrganizer((Organizer) labIsolateOrganizer);
	}

	public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizers() {
		if (getMdht() != null && getMdht().getLaboratoryIsolateOrganizers() != null) {
			ArrayList<LaboratoryIsolateOrganizer> laboratoryOrganizerList = new ArrayList<LaboratoryIsolateOrganizer>();
			for (Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer) {
					org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer iheLabIsolateOrganizer = (org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer) organizer;
					laboratoryOrganizerList.add(new LaboratoryIsolateOrganizer(iheLabIsolateOrganizer));
				}
			}
			return laboratoryOrganizerList;
		}
		return null;
	}

	protected NotificationOrganizer getNotificationOragnizer() {
		return null;

	}

	public OutbreakIdentification getOutbreakIdentification() {
		return null;

	}

	protected void setNotificationOrganizer(NotificationOrganizer notificationOrganizer) {

	}

	// Convenience Method that creates the NotificationOrganizer automatically
	public void setOutbreakIdentification(OutbreakIdentification outbreakIdentification) {

	}
}
