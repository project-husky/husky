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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE Pharm PrescriptionSection
 */
public class PrescriptionSection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionSection> {

	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new dispense section.
	 */
	public PrescriptionSection() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new dispense section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PrescriptionSection(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPrescriptionSection().init());
		this.setLanguageCode(languageCode);

		// mdht bug? prescription sections defines own code but is not honored
		// in
		// modelling
		// <code code="10160-0" codeSystem="2.16.840.1.113883.6.1"
		// codeSystemName="LOINC" displayName="History of medication use"/>
		if ("10160-0".equals(getMdht().getCode().getCode())) {
			getMdht().getCode().setCode("57828-6");
			getMdht().getCode().setDisplayName("PRESCRIPTIONS");
		}
		if (languageCode == LanguageCode.FRENCH)
			this.getMdht().setTitle(Util.st("Prescription médicamenteuse"));
		if (languageCode == LanguageCode.GERMAN)
			this.getMdht().setTitle(Util.st("Arzneimittelverordnung"));
		if (languageCode == LanguageCode.ITALIAN)
			this.getMdht().setTitle(Util.st("Prescrizione di droga"));
		if (languageCode == LanguageCode.ENGLISH)
			this.getMdht().setTitle(Util.st("Prescription for medication"));
	}

	/**
	 * Instantiates a new dispense section.
	 *
	 * @param section
	 *            the section
	 */
	public PrescriptionSection(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionSection section) {
		super(section);
	}

	/**
	 * Adds the prescription item entry.
	 *
	 * @param entry
	 *            the entry
	 */
	public void addPrescriptionItemEntry(PrescriptionItemEntry entry) {
		this.getMdht().addSubstanceAdministration(entry.getMdht());
	}

	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	/**
	 * Gets the prescription item entries.
	 *
	 * @return the prescription item entries
	 */
	public List<PrescriptionItemEntry> getPrescriptionItemEntries() {
		final List<PrescriptionItemEntry> entries = new ArrayList<PrescriptionItemEntry>();
		for (org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry entry : getMdht()
				.getPrescriptionItemEntries()) {
			entries.add(new PrescriptionItemEntry(entry));
		}
		return entries;
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

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

}
