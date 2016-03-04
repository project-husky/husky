package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ObservationMedia;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;

public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {
	public LaboratoryBatteryOrganizer() {
		super();
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param observation
	 *          the observation
	 */
	public LaboratoryBatteryOrganizer(LaboratoryObservation observation) {
		this();
		addLaboratoryObservation(observation);
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());

		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);

	}

	public void addObservationMediaEntry(ObservationMediaEntry observationMedia) {
		getMdht().addObservationMedia(observationMedia.copy());
	}

	public List<LaboratoryObservation> getLaboratoryObservations() {
		List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo : getMdht()
				.getLaboratoryObservations()) {
			loList.add(new LaboratoryObservation(lo));
		}
		return loList;
	}

	public List<ObservationMediaEntry> getObservationMediaEntries() {
		List<ObservationMediaEntry> ol = new ArrayList<ObservationMediaEntry>();
		for (ObservationMedia om : getMdht().getObservationMedia()) {
			ol.add(new ObservationMediaEntry(om));
		}
		return ol;
	}
}
