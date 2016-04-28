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
import org.ehealth_connector.cda.ihe.pharm.PrescriptionSection;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsPre. See also CDA CH MTPS 7.4.2.4
 */
public class CdaChMtpsPre extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPre> {

	/**
	 * Instantiates a new cda ch mtps pre.
	 */
	public CdaChMtpsPre() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch mtps pre.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CdaChMtpsPre(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsPre().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Verordnung von Medikamenten"); // CDA CH MTPS 7.4.2.4
			break;
		case FRENCH:
			setTitle("Prescriptions des médicaments"); // CDA CH MTPS 7.4.2.4
			break;
		case ITALIAN:
			setTitle("Prescrizione farmacologica"); // CDA CH MTPS 7.4.2.4
			break;
		case ENGLISH:
			setTitle("Pharmacy Prescription");
			break;
		}
		final PrescriptionSection section = new PrescriptionSection(getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps pre.
	 *
	 * @param doc
	 *            the doc
	 */
	public CdaChMtpsPre(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPre doc) {
		super(doc);
	}

	/**
	 * Gets the prescription section.
	 *
	 * @return the prescription section
	 */
	public PrescriptionSection getPrescriptionSection() {
		if (this.getMdht().getPrescriptionSection() != null) {
			return new PrescriptionSection(this.getMdht().getPrescriptionSection());
		}
		return null;
	}

}