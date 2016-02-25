package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.MdhtSectionFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class StudiesSummarySection
		extends MdhtSectionFacade<org.openhealthtools.mdht.uml.cda.ch.StudiesSummarySection> {

	public StudiesSummarySection() {
		super(CHFactory.eINSTANCE.createStudiesSummarySection().init(), "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.Body.StudiesSummaryL2");
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
		if (!getMdht().getBloodgroupObservations().isEmpty()) {
			return new BloodGroupObservation(getMdht().getBloodgroupObservations().get(0));
		}
		return null;
	}

	public void setBloodGroup(BloodGroupObservation bloodGroup) {
		if (!getMdht().getBloodgroupObservations().isEmpty()) {
			getMdht().getEntries().clear();
			getMdht().addObservation(bloodGroup.copy());
		} else {
			getMdht().addObservation(bloodGroup.copy());
		}
	}
}
