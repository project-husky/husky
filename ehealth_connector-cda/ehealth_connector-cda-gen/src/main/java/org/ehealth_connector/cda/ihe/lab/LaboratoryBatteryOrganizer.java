package org.ehealth_connector.cda.ihe.lab;

import java.util.List;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class LaboratoryBatteryOrganizer extends
		MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer> {

	public LaboratoryBatteryOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init());
	}

	protected LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		//
	}

	public List<LaboratoryObservation> getLaboratoryObservations() {
		return null;
	}

}
