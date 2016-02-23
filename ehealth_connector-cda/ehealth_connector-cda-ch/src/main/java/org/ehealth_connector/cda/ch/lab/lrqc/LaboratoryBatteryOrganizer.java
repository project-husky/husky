package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ObservationMedia;

public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {
	public LaboratoryBatteryOrganizer() {
		super();
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addObservationMediaEntry(ObservationMediaEntry observationMedia) {
		getMdht().addObservationMedia(observationMedia.copy());
	}

	public List<ObservationMediaEntry> getObservationMediaEntries() {
		List<ObservationMediaEntry> ol = new ArrayList<ObservationMediaEntry>();
		for (ObservationMedia om : getMdht().getObservationMedia()) {
			ol.add(new ObservationMediaEntry(om));
		}
		return ol;
	}

}
