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

import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE MedicationTreatmentPlanItemEntry.
 */
public class MedicationTreatmentPlanItemEntry extends MedicationItemEntry {

	/**
	 * Instantiates a new medication treatment plan item entry.
	 */
	public MedicationTreatmentPlanItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new medication treatment plan item entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public MedicationTreatmentPlanItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createMedicationTreatmentPlanItemEntry().init());
	}

	/**
	 * Instantiates a new medication treatment plan item entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public MedicationTreatmentPlanItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry mdht) {
		super(mdht);
	}

}
