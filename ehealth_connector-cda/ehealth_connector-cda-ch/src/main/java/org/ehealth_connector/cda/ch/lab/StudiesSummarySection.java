package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class StudiesSummarySection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection> {

	public StudiesSummarySection() {
		super(CHFactory.eINSTANCE.createStudiesSummarySection().init());
	}

	public StudiesSummarySection(LanguageCode languageCode) {
		this();
		switch (languageCode) {
		case FRENCH:
			setTitle("Groupe sanguin");
			break;
		case GERMAN:
			this.setTitle("Blutgruppe");
			break;
		case ITALIAN:
			setTitle("Gruppo sanguigno");
			break;
		case ENGLISH:
			setTitle("Blood Group");
			break;
		}
	}

	public StudiesSummarySection(org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection mdht) {
		super(mdht);
	}

	public BloodGroupObservation getBloodGroup() {
		return null;
	}

	public String getTitle() {
		if (this.getMdht().getTitle() != null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}

	public void setBloodGroup(BloodGroupObservation bloodGroup) {

	}

	public void setTitle(String title) {
		getMdht().setTitle(Util.st(title));
	}
}
