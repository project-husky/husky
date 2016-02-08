package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtEntryFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class LaboratoryReportDataProcessingEntry extends
		MdhtEntryFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry> {

	protected LaboratoryReportDataProcessingEntry() {
		super(LABFactory.eINSTANCE.createLaboratoryReportDataProcessingEntry().init());
	}

	protected LaboratoryReportDataProcessingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mdht) {
		super(mdht);
	}
}
