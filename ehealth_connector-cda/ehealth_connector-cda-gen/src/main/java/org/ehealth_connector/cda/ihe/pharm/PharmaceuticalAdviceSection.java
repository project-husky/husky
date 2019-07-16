/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE Pharm PharmaceuticalAdviceSection.
 */
public class PharmaceuticalAdviceSection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceSection> {

	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new pharmaceutical advice section.
	 */
	public PharmaceuticalAdviceSection() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new dispense section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PharmaceuticalAdviceSection(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmaceuticalAdviceSection().init());
		this.languageCode = languageCode;

		// mdht bug? dispense sections defines own code but is not honored in
		// modelling
		// <code code="10160-0" codeSystem="2.16.840.1.113883.6.1"
		// codeSystemName="LOINC" displayName="History of medication use"/>
		if ("10160-0".equals(getMdht().getCode().getCode())) {
			getMdht().getCode().setCode("61357-0");
			getMdht().getCode().setDisplayName("MEDICATION PHARMACEUTICAL ADVICE.BRIEF");
		}
		switch (this.languageCode) {
		case GERMAN:
			this.getMdht().setTitle(Util.st("Pharmazeutische Beratung"));
			break;
		case FRENCH:
			this.getMdht().setTitle(Util.st("Conseil pharmaceutique"));
			break;
		case ITALIAN:
			this.getMdht().setTitle(Util.st("Consiglio farmaceutica"));
			break;
		case ENGLISH:
			this.getMdht().setTitle(Util.st("Pharmaceutical Advice"));
			break;
		}
	}

	/**
	 * Instantiates a new pharmaceutical advice section.
	 *
	 * @param section
	 *            the section
	 */
	public PharmaceuticalAdviceSection(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceSection section) {
		super(section);
	}

	/**
	 * Gets the pharmaceutical advice item entry.
	 *
	 * @return the pharmaceutical advice item entry
	 */
	public PharmaceuticalAdviceItemEntry getPharmaceuticalAdviceItemEntry() {
		if (this.getMdht().getPharmaceuticalAdviceItemEntry() != null) {
			return new PharmaceuticalAdviceItemEntry(getMdht().getPharmaceuticalAdviceItemEntry());
		}
		return null;
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

	/**
	 * Sets the pharmaceutical advice item entry.
	 *
	 * @param entry
	 *            the new pharmaceutical advice item entry
	 */
	public void setPharmaceuticalAdviceItemEntry(PharmaceuticalAdviceItemEntry entry) {
		if (this.getMdht().getPharmaceuticalAdviceItemEntry() != null) {
			final EList<Entry> entries = this.getMdht().getEntries();
			if ((entries != null) && (entries.size() > 0)) {
				entries.get(0).setObservation(entry.getMdht());
				return;
			}
		}
		this.getMdht().addObservation(entry.getMdht());
	}

}
