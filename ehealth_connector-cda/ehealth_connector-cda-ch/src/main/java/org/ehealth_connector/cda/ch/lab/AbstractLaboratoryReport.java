package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection;
import org.openhealthtools.mdht.uml.cda.ch.CDACH;

public abstract class AbstractLaboratoryReport<EClinicalDocument> extends AbstractCdaCh<CDACH> {

	protected AbstractLaboratoryReport(CDACH doc) {
		this(doc, null, null, null);
	}

	protected AbstractLaboratoryReport(CDACH doc, LanguageCode languageCode) {
		this(doc, languageCode, null, null);
	}

	protected AbstractLaboratoryReport(CDACH doc, LanguageCode languageCode, String styleSheet,
			String css) {
		super(doc, styleSheet, css);
		// If the language code is null use default ENGLISH
		if (languageCode == null) {
			this.setLanguageCode(LanguageCode.ENGLISH);
		} else {
			this.setLanguageCode(languageCode);
		}
		// TODO Check if this work as expected
		super.initCda();
		setTitle(getSpecialitySectionTitle());
	}

	// LRPH: 1
	// LRTP: 1
	// LRQC: 1..*
	// Daher protected. In den jeweiligen Templates verfeinern.
	protected void addLaboratorySpecialtySection(AbstractLaboratorySpecialtySection section) {
		getMdht().addSection(section.getMdht());
	}

	private String getSpecialitySectionTitle() {
		switch (this.getLanguageCode()) {
		case FRENCH:
			return ("Rapport de laboratoire");
		case GERMAN:
			return ("Laborbefund");
		case ITALIAN:
			return ("Rapporto di laboratorio");
		case ENGLISH:
			return ("Laboratory Specialty Section");
		}
		return "";
	}
}
