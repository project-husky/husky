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
import org.ehealth_connector.cda.ihe.pharm.MedicationListSection;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsPml. See also CDA CH MTPS 7.4.2.2
 */
public class CdaChMtpsPml extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPml> {

	/**
	 * Instantiates a new cda ch mtps pml.
	 */
	public CdaChMtpsPml() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch mtps pml.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CdaChMtpsPml(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsPml().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Medikamentenliste");
			break;
		case FRENCH:
			setTitle("Liste de médicaments");
			break;
		case ITALIAN:
			setTitle("Lista farmaci");
			break;
		case ENGLISH:
			setTitle("Medication List");
		}
		MedicationListSection section = new MedicationListSection(getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps pml.
	 *
	 * @param doc
	 *            the doc
	 */
	public CdaChMtpsPml(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPml doc) {
		super(doc);
	}

	/**
	 * Gets the medication list section.
	 *
	 * @return the medication list section
	 */
	public MedicationListSection getMedicationListSection() {
		if (this.getMdht().getMedicationListSection() != null) {
			return new MedicationListSection(this.getMdht().getMedicationListSection());
		}
		return null;
	}
}
