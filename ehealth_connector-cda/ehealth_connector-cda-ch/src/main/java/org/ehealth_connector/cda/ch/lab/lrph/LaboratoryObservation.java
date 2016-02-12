package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.cda.ch.enums.StandardCdaBodySelections;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc getCodeAsEnum() {
		return null;
	}

	public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed getCodeAsSnomedEnum() {
		return null;
	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc code) {

	}

	public void setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed code) {

	}

	// Convenience function for special case HIV
	public void setHivRecency(StandardCdaBodySelections selection) {

	}
}
