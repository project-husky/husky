package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {

	public LaboratoryBatteryOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init());
		setStatusCode(StatusCode.COMPLETED);
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		// getMdht().getLaboratoryObservations().add(observation.copy());
		getMdht().addObservation(observation.copy());
	}

	// public List<LaboratoryObservation> getLaboratoryObservations() {
	// List<LaboratoryObservation> ol = new ArrayList<LaboratoryObservation>();
	// for (Observation o : getMdht().getObservations()) {
	// if (o instanceof LaboratoryObservation) {
	// org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation
	// mdhtLabObservation =
	// (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) o;
	// ol.add(new LaboratoryObservation(mdhtLabObservation));
	// }
	// }
	// return ol;
	// }

	public List<LaboratoryObservation> getLaboratoryObservations() {
		List<LaboratoryObservation> ol = new ArrayList<LaboratoryObservation>();
		for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation o : getMdht()
				.getLaboratoryObservations()) {
			ol.add(new LaboratoryObservation(o));
		}
		return ol;
	}

}
