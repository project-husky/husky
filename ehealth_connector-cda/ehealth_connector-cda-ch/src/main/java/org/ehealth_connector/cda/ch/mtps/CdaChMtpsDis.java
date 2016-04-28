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

package org.ehealth_connector.cda.ch.mtps;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ihe.pharm.DispenseSection;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsDis. see also CDA CH MTPS 7.4.2.5
 */
public class CdaChMtpsDis extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis> {

	/**
	 * Instantiates a new cda ch mtps dis.
	 */
	public CdaChMtpsDis() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch mtps dis.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CdaChMtpsDis(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsDis().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Dispensation des médicaments"); // CDA CH MTPS 7.4.2.5
			break;
		case GERMAN:
			this.setTitle("Abgabe von Medikamenten"); // CDA CH MTPS 7.4.2.5
			break;
		case ITALIAN:
			setTitle("Dispensazioni di farmaci"); // CDA CH MTPS 7.4.2.5
			break;
		case ENGLISH:
			setTitle("Medication dispensed"); // IHE PHARM DIS L350
			break;
		}
		final DispenseSection dispenseSection = new DispenseSection(languageCode);
		this.getDoc().addSection(dispenseSection.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps dis.
	 *
	 * @param doc
	 *            mdht model document
	 */
	public CdaChMtpsDis(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis doc) {
		super(doc);
	}

	/**
	 * Gets the dispense section.
	 *
	 * @return the dispense section
	 */
	public DispenseSection getDispenseSection() {
		return new DispenseSection(this.getMdht().getDispenseSection());
	}
}
