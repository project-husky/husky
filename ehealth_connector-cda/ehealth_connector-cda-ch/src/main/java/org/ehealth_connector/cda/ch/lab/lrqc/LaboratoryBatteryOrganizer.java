package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer;

public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {
	public LaboratoryBatteryOrganizer() {
		super();
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());
	}

	public List<LaboratoryObservation> getLaboratoryObservations() {
		List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo : getMdht()
				.getLaboratoryObservations()) {
			loList.add(new LaboratoryObservation(lo));
		}
		return loList;
	}
}
