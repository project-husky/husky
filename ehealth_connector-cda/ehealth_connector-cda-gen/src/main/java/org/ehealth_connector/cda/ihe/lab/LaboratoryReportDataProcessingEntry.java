package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtEntryFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class LaboratoryReportDataProcessingEntry extends
		MdhtEntryFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry> {

	public LaboratoryReportDataProcessingEntry() {
		super(LABFactory.eINSTANCE.createLaboratoryReportDataProcessingEntry().init());
	}

	public LaboratoryReportDataProcessingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mdht) {
		super(mdht);
	}

	protected SpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new SpecimenAct(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct) getMdht().getAct());
		}
		return null;
	}

	protected void setSpecimenAct(SpecimenAct specimenAct) {
		getMdht().setAct(specimenAct.getMdht());
	}
}
