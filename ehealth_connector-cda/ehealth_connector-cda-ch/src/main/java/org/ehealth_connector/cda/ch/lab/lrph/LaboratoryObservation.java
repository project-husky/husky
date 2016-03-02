package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.Date;

import org.ehealth_connector.cda.ch.enums.StandardCdaBodySelections;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed;
import org.ehealth_connector.common.enums.ObservationInterpretation;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public LaboratoryObservation() {
		super();
	}

	// Required Elements with Loinc Code
	public LaboratoryObservation(LabObsListLoinc code, ObservationInterpretation interpretationCode,
			Date effectiveTime) {
		this();
		setCode(code);
		setInterpretationCode(interpretationCode);
		setEffectiveTime(effectiveTime);
	}

	// Required Elements with Snomed Code
	public LaboratoryObservation(LabObsListSnomed code, ObservationInterpretation interpretationCode,
			Date effectiveTime) {
		this();
		setCode(code);
		setInterpretationCode(interpretationCode);
		setEffectiveTime(effectiveTime);
	}

	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc getCodeAsEnum() {
		if (getCode() != null) {
			return LabObsListLoinc.getEnum(getCode().getCode());
		}
		return null;
	}

	public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed getCodeAsSnomedEnum() {
		if (getCode() != null) {
			return LabObsListSnomed.getEnum(getCode().getCode());
		}
		return null;
	}

	// Convenience function for special case HIV
	public StandardCdaBodySelections getHivRecency() {
		if (getCode() != null && StandardCdaBodySelections.isInValueSet(getCode().getCode())) {
			return StandardCdaBodySelections.getEnum(getCode().getCode());
		}
		return null;
	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc code) {
		setCode(code.getCode());
	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed code) {
		setCode(code.getCode());
	}

	// Convenience function for special case HIV
	public void setHivRecency(StandardCdaBodySelections selection) {
		setCode(selection.getCode());
	}
}
