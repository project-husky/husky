package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.ch.edes.VitalSignObservation;
import org.ehealth_connector.cda.ch.lab.enums.VitalSignObservationCode;

public class VitalSignsObservation extends VitalSignObservation {
	// Swiss specific VitalSignObserations
	// Es MUSS ein LOINC Code aus dem Value Set CDA-CH-LRTP vitalSignList
	// verwendet werden (siehe Kapitel 5.6.5 Liste der Vitalzeichen“ auf Seite 52)
	public VitalSignObservationCode getCodeEnum() {
		return null;

	}

	public void setCode(VitalSignObservationCode code) {

	}
}
