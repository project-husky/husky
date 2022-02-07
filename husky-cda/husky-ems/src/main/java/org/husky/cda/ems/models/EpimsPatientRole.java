package org.husky.cda.ems.models;

import javax.xml.bind.annotation.XmlElement;

import org.husky.common.hl7cdar2.POCDMT000040PatientRole;

public class EpimsPatientRole extends POCDMT000040PatientRole {

	@XmlElement(name = "patient", namespace = "urn:hl7-org:v3")
	protected EpimsPatient patient;

	public EpimsPatient getEpimsPatient() {
		return patient;
	}

	public void setEpimsPatient(EpimsPatient epimsPatient) {
		this.patient = epimsPatient;
	}

}
