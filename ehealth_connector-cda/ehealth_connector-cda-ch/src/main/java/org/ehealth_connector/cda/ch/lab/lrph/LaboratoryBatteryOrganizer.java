package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;

public class LaboratoryBatteryOrganizer
		extends org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer {

	public LaboratoryBatteryOrganizer() {
		super();
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addIdForHiv(Identificator id) {
		getMdht().getIds().add(id.getIi());
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());
	}

	public List<Identificator> getIdForHivList() {
		return Util.convertIds(getMdht().getIds());
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
