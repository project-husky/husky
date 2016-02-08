package org.ehealth_connector.cda.ch.lab.lrqc;

import java.io.OutputStream;

import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.common.ReferenceRange;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList getCodeAsEnum() {
		return null;
	}

	public String getNarrativeTextReference() {
		return null;
	}

	public void getObservationMedia(OutputStream outputStream) {

	}

	public ReferenceRange getReferenceRange() {
		return null;
	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList code) {

	}

	// Referenz auf menschenlesbaren Text im Text Element der Section
	public void setNarrativeTextReference(String reference) {

	}

	// http://motorcycleguy.blogspot.de/2010/11/progress-report-on-self-displaying-cda.html
	public void setObservationMedia(ObservationMediaEntry observationMedia) {
		// getMdht().addObservationMedia(observationMediaEntry.getMdht());
	}

	public void setReferenceRange(ReferenceRange referenceRange) {

	}
}
