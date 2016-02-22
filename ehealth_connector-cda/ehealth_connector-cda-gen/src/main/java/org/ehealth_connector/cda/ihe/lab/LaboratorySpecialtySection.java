package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class LaboratorySpecialtySection extends AbstractLaboratorySpecialtySection {

	public LaboratorySpecialtySection() {
		super(LABFactory.eINSTANCE.createLaboratorySpecialtySection().init());
	}

	public LaboratorySpecialtySection(Code code) {
		this();
		this.setCode(code);
	}

	public LaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	public LaboratoryReportDataProcessingEntry getLaboratoryReportDataProcessingEntry() {
		if (getMdht().getEntries() != null && !getMdht().getEntries().isEmpty()
				&& getMdht().getEntries().get(
						0) instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) {
			return new org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) getMdht()
							.getEntries().get(0));
		}
		return null;
	}
}
