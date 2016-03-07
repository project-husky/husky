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
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.pharm.PharmaceuticalAdviceSection;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsPadv. see also CDA CH MTPS 7.4.2.6
 */
public class CdaChMtpsPadv
		extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv> {

	/**
	 * Instantiates a new cda ch mtps padv.
	 */
	public CdaChMtpsPadv() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch mtps padv.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CdaChMtpsPadv(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsPadv().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Conseils sur les médicaments"); // CDA CH MTPS 7.4.2.6
			break;
		case GERMAN:
			this.setTitle("Hinweise zur Medikation"); // CDA CH MTPS 7.4.2.6
			break;
		case ITALIAN:
			setTitle("Consigli sui farmaci"); // CDA CH MTPS 7.4.2.6
			break;
		case ENGLISH:
			setTitle("Pharmacy Pharmaceutical Advice"); // CDA CH MTPS 7.4.2.6
			break;
		}
		PharmaceuticalAdviceSection section = new PharmaceuticalAdviceSection(getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps padv.
	 *
	 * @param doc
	 *            the doc
	 */
	public CdaChMtpsPadv(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv doc) {
		super(doc);
	}

	/**
	 * Gets the pharmaceutical advice section.
	 *
	 * @return the pharmaceutical advice section
	 */
	public PharmaceuticalAdviceSection getPharmaceuticalAdviceSection() {
		return new PharmaceuticalAdviceSection(this.getMdht().getPharmaceuticalAdviceSection());
	}
}