package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.cda.ch.enums.StandardCdaBodySelections;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public LaboratoryObservation() {
		super();
	}

	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc getCodeAsEnum() {
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
		// TODO
		// super.setCode(code.);
	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed code) {
		setCode(code.getCode());
	}

	// Convenience function for special case HIV
	public void setHivRecency(StandardCdaBodySelections selection) {
		setCode(selection.getCode());
	}
}
