package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection;
import org.ehealth_connector.common.Code;

public class LaboratorySpecialtySection extends AbstractLaboratorySpecialtySection {

	public LaboratorySpecialtySection() {
		super();
	}

	public LaboratorySpecialtySection(Code code) {
		super(code);
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param code
	 *          the code for this section
	 * @param entry
	 *          the LaboratoryReportDataProcessingEntry
	 */
	public LaboratorySpecialtySection(Code code, LaboratoryReportDataProcessingEntry entry) {
		this(code);
		setLaboratoryReportDataProcessingEntry(entry);
	}

	public LaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	public org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryReportDataProcessingEntry getLaboratoryReportDataProcessingEntry() {
		if (!getMdht().getEntries().isEmpty() && getMdht().getEntries().get(
				0) instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) {
			return new org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryReportDataProcessingEntry(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) getMdht()
							.getEntries().get(0));
		}
		return null;
	}

	public void setLaboratoryReportDataProcessingEntry(
			org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryReportDataProcessingEntry entry) {
		getMdht().getEntries().clear();
		getMdht().getEntries().add(0, entry.copy());
	}
}
