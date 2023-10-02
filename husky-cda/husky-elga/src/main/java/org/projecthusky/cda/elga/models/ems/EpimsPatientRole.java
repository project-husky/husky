package org.projecthusky.cda.elga.models.ems;

import javax.xml.bind.annotation.XmlElement;

import org.projecthusky.common.hl7cdar2.POCDMT000040PatientRole;

public class EpimsPatientRole extends POCDMT000040PatientRole {

	@XmlElement(name = "patient", namespace = "urn:hl7-org:v3")
	protected EpimsPatient patient;

	@Override
	public EpimsPatient getPatient() {
		return patient;
	}

	public void setPatient(EpimsPatient epimsPatient) {
		this.patient = epimsPatient;
	}

}
