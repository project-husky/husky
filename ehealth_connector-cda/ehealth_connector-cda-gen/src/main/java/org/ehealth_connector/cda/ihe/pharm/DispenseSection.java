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
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE Pharm DispenseSection.
 */
public class DispenseSection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseSection> {

	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new dispense section.
	 */
	public DispenseSection() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new dispense section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public DispenseSection(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createDispenseSection().init());
		this.languageCode = languageCode;

		// mdht bug? dispense sections defines own code but is not honored in
		// modelling
		// <code code="10160-0" codeSystem="2.16.840.1.113883.6.1"
		// codeSystemName="LOINC" displayName="History of medication use"/>
		if ("10160-0".equals(getMdht().getCode().getCode())) {
			getMdht().getCode().setCode("60590-7");
			getMdht().getCode().setDisplayName("MEDICATION DISPENSED.BRIEF");
		}
		switch (this.languageCode) {
		case FRENCH:
			this.getMdht().setTitle(Util.st("Dispensation des médicaments"));
			break;
		case GERMAN:
			this.getMdht().setTitle(Util.st("Abgabe von Medikamenten"));
			break;
		case ITALIAN:
			this.getMdht().setTitle(Util.st("Dispensazioni di farmaci"));
			break;
		case ENGLISH:
			this.getMdht().setTitle(Util.st("Pharmacy Dispense"));
			break;
		}
	}

	/**
	 * Instantiates a new dispense section.
	 *
	 * @param section
	 *            the section
	 */
	public DispenseSection(org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseSection section) {
		super(section);
	}

	/**
	 * Gets the dispense item entry.
	 *
	 * @return the dispense item entry
	 */
	public DispenseItemEntry getDispenseItemEntry() {
		if (this.getMdht().getDispenseItemEntry() != null) {
			return new DispenseItemEntry(getMdht().getDispenseItemEntry());
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
	 * Sets the dispense item entry.
	 *
	 * @param entry
	 *            the new dispense item entry
	 */
	public void setDispenseItemEntry(DispenseItemEntry entry) {
		if (this.getMdht().getDispenseItemEntry() != null) {
			final EList<Entry> entries = this.getMdht().getEntries();
			if ((entries != null) && (entries.size() > 0)) {
				entries.get(0).setSupply(entry.getMdht());
				return;
			}
		}
		this.getMdht().addSupply(entry.getMdht());
	}

}
