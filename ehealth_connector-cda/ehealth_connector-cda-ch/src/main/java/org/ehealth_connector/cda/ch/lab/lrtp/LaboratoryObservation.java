package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.List;

import org.ehealth_connector.common.ReferenceRange;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public void addSoasInfoEntry(SoasInfoEntry entry) {

	}

	public org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsListLoinc getCodeAsLoincEnum() {
		return null;
	}

	public org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsListSnomed getCodeAsSnomedEnum() {
		return null;
	}

	public ReferenceRange getReferenceRange() {
		return null;
	}

	public List<SoasInfoEntry> getSoasInfoEnties() {
		return null;

	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsListLoinc code) {

	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsListSnomed code) {

	}

	public void setReferenceRange(ReferenceRange referenceRange) {

	}
}
