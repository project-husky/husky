package org.ehealth_connector.cda.ihe.lab;

import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class LaboratoryReportDataProcessingEntry
		extends AbstractLaboratoryReportDataProcessingEntry {
	public LaboratoryReportDataProcessingEntry() {
		super(LABFactory.eINSTANCE.createLaboratoryReportDataProcessingEntry().init());
	}

	public LaboratoryReportDataProcessingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mdht) {
		super(mdht);
	}

	public org.ehealth_connector.cda.ihe.lab.SpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new SpecimenAct(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct) getMdht().getAct());
		}
		return null;
	}

	public SpecimenAct getSpecimenActIhe() {
		if (getMdht().getAct() != null) {
			return new SpecimenAct(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct) getMdht().getAct());
		}
		return null;
	}

	public void setSpecimenAct(org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct specimenAct) {
		getMdht().setAct(specimenAct.getMdht());
	}
}
