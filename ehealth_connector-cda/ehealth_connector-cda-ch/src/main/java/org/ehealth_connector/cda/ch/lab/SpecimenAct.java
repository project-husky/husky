package org.ehealth_connector.cda.ch.lab;

import java.util.List;

import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.common.enums.StatusCode;

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

	public SpecimenCollectionEntry getSpecimenCollectionEntry() {
		return new SpecimenCollectionEntry(getMdht().getSpecimenCollections().get(0));
	}

	public void setSpecimenCollectionEntry(SpecimenCollectionEntry entry) {
		getMdht().getSpecimenCollections().add(entry.copy());
	}
}
