package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.List;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;

public class LaboratoryBatteryOrganizer
		extends org.ehealth_connector.cda.ch.lab.LaboratoryBatteryOrganizer {

	public LaboratoryBatteryOrganizer() {
		super();
	}

	public void addIdForHiv(Identificator id) {
		getMdht().getIds().add(id.getIi());
	}

	public List<Identificator> getIdForHivList() {
		return Util.convertIds(getMdht().getIds());
	}
}
