package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;

public class LaboratoryBatteryOrganizer
		extends org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer {

	public LaboratoryBatteryOrganizer() {
		super();
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	// Required Elements
	public LaboratoryBatteryOrganizer(StatusCode status, LaboratoryObservation observation) {
		this();
		setStatusCode(status);
		addLaboratoryObservation(observation);
	}

	public void addIdForHiv(Identificator id) {
		getMdht().getIds().add(id.getIi());
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());

		int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);
	}

	public List<Identificator> getIdForHivList() {
		return Util.convertIds(getMdht().getIds());
	}

	public List<LaboratoryObservation> getLaboratoryObservations() {
		List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (Observation o : getMdht().getObservations()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) {
				loList.add(new LaboratoryObservation(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) o));
			}
		}
		return loList;
	}
}
