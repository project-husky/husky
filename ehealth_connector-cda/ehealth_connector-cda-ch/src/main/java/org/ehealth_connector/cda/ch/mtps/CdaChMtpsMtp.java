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
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanSection;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChMtpsMtp extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp> {

	public CdaChMtpsMtp(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsMtp().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Medikamentöser Behandlungsplan"); 
			break;
		case FRENCH:
			setTitle("Plan de traitement médicamenteux"); 
			break;
		case ITALIAN:
			setTitle("Piano terapeutico farmacologico"); 
			break;
		case ENGLISH:
			setTitle("Medication Treatment Plan"); 
			break;
		}
		MedicationTreatmentPlanSection section = new MedicationTreatmentPlanSection(getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	public CdaChMtpsMtp() {
		this(LanguageCode.ENGLISH);
	}

	public CdaChMtpsMtp(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp doc) {
		super(doc);
	}
	
	public MedicationTreatmentPlanSection getMedicationTreatmentPlanSection() {
		if (this.getMdht().getMedicationTreatmentPlanSection()!=null) {
			return new MedicationTreatmentPlanSection(this.getMdht().getMedicationTreatmentPlanSection());
		}
		return null;
	}
}
