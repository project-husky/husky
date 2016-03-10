package org.ehealth_connector.cda.ch.lab.lrqc;

import org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList;
import org.ehealth_connector.common.enums.ObservationInterpretation;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public LaboratoryObservation() {
		super();
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param code
	 *          the code
	 * @param interpretationCode
	 *          the interpretation code
	 */
	public LaboratoryObservation(LabObsList code, ObservationInterpretation interpretationCode) {
		this();
		setCode(code);
		addInterpretationCode(interpretationCode);
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
