package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtSectionFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public abstract class AbstractLaboratorySpecialtySection
		extends MdhtSectionFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection> {
	public AbstractLaboratorySpecialtySection() {
		super(LABFactory.eINSTANCE.createLaboratorySpecialtySection().init());
		setTitle(LanguageCode.ENGLISH);
	}

	public AbstractLaboratorySpecialtySection(Code code) {
		this();
		setCode(code);
	}

	public AbstractLaboratorySpecialtySection(Code code, LanguageCode languageCode) {
		this(code);
		setTitle(languageCode);
	}

	public AbstractLaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	public void setLaboratoryReportDataProcessingEntry(LaboratoryReportDataProcessingEntry entry) {
		getMdht().getEntries().clear();
		getMdht().getEntries().add(entry.getMdht());
	}

	public void setTitle(LanguageCode languageCode) {
		switch (languageCode) {
		case FRENCH:
			setTitle("Rapport de laboratoire");
			break;
		case GERMAN:
			this.setTitle("Laborbefund");
			break;
		case ITALIAN:
			setTitle("Rapporto di laboratorio");
			break;
		case ENGLISH:
			setTitle("Laboratory Specialty Section");
			break;
		}
	}
}
