package org.ehealth_connector.cda.ch.lab;

import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;

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
		setTitle(getSpecialitySectionTitle());
	}

	public void addReferralOrderingPhysician(ReferralOrderingPhysician physician) {
		getMdht().getParticipants().add(physician.copy());
	}

	public List<ReferralOrderingPhysician> getReferralOrderingPhysicians() {
		// TODO
		return null;
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
