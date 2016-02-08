package org.ehealth_connector.cda.ch.lab;

import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification;

public abstract class SpecimenAct extends org.ehealth_connector.cda.ihe.lab.SpecimenAct {

	public SpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
		super.setStatusCode(StatusCode.COMPLETED.getCode());
	}

	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		getMdht().getLaboratoryBatteryOrganizers();
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

	public void setOutbreakIdentification(OutbreakIdentification outbreakIdentification) {

	}
}
