package org.ehealth_connector.cda.ch.lab.lrph;

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

	public org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct(getMdht().getAct());
		}
		return null;
	}

	public void setSpecimenAct(org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct specimenAct) {
		getMdht().setAct(specimenAct.getMdht());
	}
}
