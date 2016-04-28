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

package org.ehealth_connector.cda.ihe.pharm.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 * The Enum MedicationsSpecialConditions see IHE PCC TF2 Table 6.3.4.16.7-1.
 */
public enum MedicationsSpecialConditions {

	/**
	 * <div class="en">Drug Treatment Unknown</div><div class="fr">Traitement
	 * médicamenteux inconnu</div>
	 */
	DRUG_TREATMENT_UNKNOWN("182904002", "Drug Treatment Unknown", "Traitement médicamenteux inconnu"),

	/**
	 * <div class="en">No Drug Therapy Prescribed</div><div class="fr">Aucun
	 * traitement médicamenteux prescrit</div>
	 */
	NO_DRUG_THERAPY_PRESCRIBED("182849000", "No Drug Therapy Prescribed", "Aucun traitement médicamenteux prescrit"),

	/**
	 * <div class="en">Patient Not On Self-Medications</div><div class="fr">Le
	 * patient indique qu’il ne prend pas de médicaments.</div>
	 */
	PATIENT_NOT_ON_SELF_MEDICATIONS("408350003", "Patient Not On Self-Medications", "Le patient indique qu’il ne prend pas de médicaments.");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "IHE PCC TF2 Table 6.3.4.16.7-1";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static MedicationsSpecialConditions getEnum(String code) {
		for (final MedicationsSpecialConditions x : values()) {
			if (x.code.equals(code)) {
				return x;
			}
		}
		return null;
	}

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameEn;

	/** The display name. */
	private String displayNameFr;

	/**
	 * Instantiates a new medications special conditions.
	 *
	 * @param code
	 *            the code
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameFr
	 *            the display name fr
	 */
	private MedicationsSpecialConditions(String code, String displayNameEn, String displayNameFr) {
		this.code = code;
		this.displayNameEn = displayNameEn;
		this.displayNameFr = displayNameFr;
	}

	/**
	 * Gets the code.
	 *
	 * @param languageCode
	 *            the language code
	 * @return the code
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null) {
			switch (languageCode) {
			case FRENCH:
				displayName = displayNameFr;
				break;
			default:
				displayName = displayNameEn;
				break;

			}
		}
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

}
