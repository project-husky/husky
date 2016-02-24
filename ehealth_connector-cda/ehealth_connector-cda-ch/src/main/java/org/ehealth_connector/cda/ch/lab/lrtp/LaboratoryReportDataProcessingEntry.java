package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryReportDataProcessingEntry;

public class LaboratoryReportDataProcessingEntry
		extends AbstractLaboratoryReportDataProcessingEntry {
	public LaboratoryReportDataProcessingEntry() {
		super();
	}

	public LaboratoryReportDataProcessingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mdht) {
		super(mdht);
	}

	public org.ehealth_connector.cda.ch.lab.lrtp.SpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new org.ehealth_connector.cda.ch.lab.lrtp.SpecimenAct(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct) getMdht().getAct());
		}
		return null;
	}

	public void setSpecimenAct(org.ehealth_connector.cda.ch.lab.lrtp.SpecimenAct specimenAct) {
		getMdht().setAct(specimenAct.getMdht());
	}
}