package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public abstract class AbstractLaboratorySpecialtySection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection> {
	public AbstractLaboratorySpecialtySection() {
		super(LABFactory.eINSTANCE.createLaboratorySpecialtySection().init());
		setTitle(LanguageCode.ENGLISH);
	}

	public AbstractLaboratorySpecialtySection(Code code) {
		this();
		this.setCode(code);
	}

	public AbstractLaboratorySpecialtySection(Code code, LanguageCode languageCode) {
		this(code);
		setTitle(languageCode);
	}

	public AbstractLaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	public Code getCode() {
		return new Code(getMdht().getCode());
	}

	public String getTitle() {
		if (this.getMdht().getTitle() != null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}

	public void setCode(Code code) {
		getMdht().setCode(code.getCE());
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

	public void setTitle(String title) {
		getMdht().setTitle(Util.st(title));
	}
}
