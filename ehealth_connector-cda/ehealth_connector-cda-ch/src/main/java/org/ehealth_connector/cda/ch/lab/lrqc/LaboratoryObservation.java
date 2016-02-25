package org.ehealth_connector.cda.ch.lab.lrqc;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public LaboratoryObservation() {
		super();
	}

	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	public org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList getCodeAsEnum() {
		if (getMdht().getCode() != null && getMdht().getCode().getCode() != null) {
			return org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList
					.getEnum(getMdht().getCode().getCode());
		}
		return null;
	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList code) {
		getMdht().setCode(code.getCD());
	}
}
