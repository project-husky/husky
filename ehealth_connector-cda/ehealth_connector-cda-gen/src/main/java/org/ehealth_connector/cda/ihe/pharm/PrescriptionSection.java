/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE Pharm PrescriptionSection 
 */
public class PrescriptionSection extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionSection> {
	
	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new dispense section.
	 *
	 * @param languageCode the language code
	 */
	public PrescriptionSection(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPrescriptionSection().init());
		this.languageCode = languageCode;
		
		// mdht bug? prescription sections defines own code but is not honored in modelling
        // <code code="10160-0" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC" displayName="History of medication use"/>
		if ("10160-0".equals(getMdht().getCode().getCode())) {
			getMdht().getCode().setCode("57828-6");
			getMdht().getCode().setDisplayName("PRESCRIPTIONS");
		}
		switch (this.languageCode) {
		case GERMAN:
			this.getMdht().setTitle(Util.st("Arzneimittelverordnung"));
			break;
		case FRENCH:
			this.getMdht().setTitle(Util.st("Prescription médicamenteuse"));
			break;
		case ITALIAN:
			this.getMdht().setTitle(Util.st("Prescrizione di droga"));
			break;
		case ENGLISH:
			this.getMdht().setTitle(Util.st("Prescription for medication"));
			break;
		}
	}
	
	/**
	 * Instantiates a new dispense section.
	 */
	public PrescriptionSection() {
		this(LanguageCode.ENGLISH);
	}


	/**
	 * Instantiates a new dispense section.
	 *
	 * @param section the section
	 */
	public PrescriptionSection(org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionSection section) {
		super(section);
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		if (this.getMdht().getTitle()!=null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}


}
