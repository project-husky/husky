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

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param act
	 *          the SpecimentAct
	 */
	public LaboratoryReportDataProcessingEntry(SpecimenAct act) {
		this();
		setSpecimenAct(act);
	}

	public org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct(getMdht().getAct());
		}
		return null;
	}

	public void setSpecimenAct(org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct specimenAct) {
		getMdht().setAct(specimenAct.copy());
	}
}
