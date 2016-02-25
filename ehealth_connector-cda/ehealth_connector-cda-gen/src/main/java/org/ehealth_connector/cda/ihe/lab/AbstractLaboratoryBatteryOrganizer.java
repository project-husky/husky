package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public abstract class AbstractLaboratoryBatteryOrganizer extends
		MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer> {

	public AbstractLaboratoryBatteryOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init());
		setStatusCode(StatusCode.COMPLETED);
	}

	protected AbstractLaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}
}
