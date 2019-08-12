/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE Pharm MedicationTreatmentPlanSection.
 */
public class MedicationTreatmentPlanSection extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanSection> {

	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new medication treatment plan section.
	 */
	public MedicationTreatmentPlanSection() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new medication treatment plan section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public MedicationTreatmentPlanSection(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createMedicationTreatmentPlanSection().init());
		this.languageCode = languageCode;
		switch (this.languageCode) {
		case GERMAN:
			this.getMdht().setTitle(Util.st("Medikamentöser Behandlungsplan"));
			break;
		case FRENCH:
			this.getMdht().setTitle(Util.st("Plan de traitement médicamenteux"));
			break;
		case ITALIAN:
			this.getMdht().setTitle(Util.st("Piano terapeutico farmacologico"));
			break;
		case ENGLISH:
			this.getMdht().setTitle(Util.st("Medication Treatment Plan"));
			break;
		}
	}

	/**
	 * Instantiates a new medication treatment plan section.
	 *
	 * @param section
	 *            the section
	 */
	public MedicationTreatmentPlanSection(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanSection section) {
		super(section);
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		if (this.getMdht().getTitle() != null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}

}
