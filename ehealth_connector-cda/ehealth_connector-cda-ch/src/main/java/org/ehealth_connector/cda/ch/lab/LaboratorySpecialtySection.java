package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Entry;

public class LaboratorySpecialtySection
		extends org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection {

	private LanguageCode languageCode;

	public LaboratorySpecialtySection(Code code, LanguageCode languageCode) {
		super(code);
		switch (this.languageCode) {
		case GERMAN:
			this.getMdht().setTitle(Util.st("Laborbefund"));
			break;
		case FRENCH:
			this.getMdht().setTitle(Util.st("Rapport de laboratoire"));
			break;
		case ITALIAN:
			this.getMdht().setTitle(Util.st("Rapporto di laboratorio"));
			break;
		case ENGLISH:
			this.getMdht().setTitle(Util.st("Laboratory Specialty Section"));
			break;
		}
	}

	public LaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	public LaboratoryReportDataProcessingEntry getLaboratoryReportDataProcessingEntry() {
		if (getMdht() != null && getMdht().getEntries() != null && !getMdht().getEntries().isEmpty()) {
			return (LaboratoryReportDataProcessingEntry) getMdht().getEntries().get(0);
		}
		return null;
	}

	public void setLaboratoryReportDataProcessingEntry(
			LaboratoryReportDataProcessingEntry labReportDataProcessingEntry) {
		getMdht().getEntries().add((Entry) labReportDataProcessingEntry);
	}

}
