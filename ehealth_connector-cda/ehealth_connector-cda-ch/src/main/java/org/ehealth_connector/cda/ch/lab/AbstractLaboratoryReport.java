package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public abstract class AbstractLaboratoryReport<EClinicalDocument extends ClinicalDocument>
		extends AbstractCdaCh<EClinicalDocument> {

	protected AbstractLaboratoryReport(EClinicalDocument doc) {
		this(doc, null, null, null);
	}

	protected AbstractLaboratoryReport(EClinicalDocument doc, LanguageCode languageCode) {
		this(doc, languageCode, null, null);
	}

	protected AbstractLaboratoryReport(EClinicalDocument doc, LanguageCode languageCode,
			String styleSheet, String css) {
		super(doc, styleSheet, css);
		// If the language code is null use default ENGLISH
		if (languageCode == null) {
			this.setLanguageCode(LanguageCode.ENGLISH);
		} else {
			this.setLanguageCode(languageCode);
		}
		super.initCda();
		setTitle(getDocumentAndSpecialitySectionTitle());
	}

	protected org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection createSpecialtySection(
			Code code) {
		org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection section = LABFactory.eINSTANCE
				.createLaboratorySpecialtySection().init();
		section.setTitle(Util.st(getDocumentAndSpecialitySectionTitle()));
		section.setCode(code.getCE());
		return section;
	}

	private String getDocumentAndSpecialitySectionTitle() {
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
