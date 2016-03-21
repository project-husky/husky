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

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;

/**
 * The Enum SubstanceAdminSubstitution HL7 ObservationValue (OID
 * 2.16.840.1.113883.5.1063)
 */
public enum SubstanceAdminSubstitution {

	/**
	 * <div class="en"> brand composition</div><div class="fr">marque
	 * équivalente</div>
	 */
	BRAND_COMPOSITION("BC", "brand composition", "marque équivalente"),

	/** <div class="en"> equivalent</div><div class="fr">équivalent</div> */
	EQUIVALENT("E", "equivalent", "équivalent"),

	/**
	 * <div class="en"> equivalent composition</div><div class="fr">composition
	 * équivalente</div>
	 */
	EQUIVALENT_COMPOSITION("EC", "equivalent composition", "composition équivalente"),

	/**
	 * <div class="en"> formulary</div><div class="fr">formulaire guidelines</div>
	 */
	FORMULARY("F", "formulary", "formulaire guidelines"),

	/**
	 * <div class="en"> generic composition</div><div class="fr">générique
	 * équivalent</div>
	 */
	GENERIC_COMPOSITION("G", "generic composition", "générique équivalent"),

	/** <div class="en"> none</div><div class="fr">aucune</div> */
	NONE("N", "none", "aucune"),

	/**
	 * <div class="en"> therapeutic alternative</div><div class="fr">alternative
	 * thérapeutique</div>
	 */
	THERAPEUTIC_ALTERNATIVE("TE", "therapeutic alternative", "alternative thérapeutique"),

	/**
	 * <div class="en"> therapeutic brand</div><div class="fr">marque
	 * thérapeutiquement équivalente</div>
	 */
	THERAPEUTIC_BRAND("TB", "therapeutic brand", "marque thérapeutiquement équivalente"),

	/**
	 * <div class="en"> therapeutic generic</div><div class="fr">générique
	 * thérapeutique</div>
	 */
	THERAPEUTIC_GENERIC("TG", "therapeutic generic", "générique thérapeutique");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "HL7 SubstanceAdminSubstitution";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1070";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *          the code
	 * @return the enum
	 */
	public static SubstanceAdminSubstitution getEnum(String code) {
		for (final SubstanceAdminSubstitution x : values()) {
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
	 * Instantiates a new SubstanceAdminSubstitution.
	 *
	 * @param code
	 *          the code
	 * @param displayNameEn
	 *          the display name en
	 * @param displayNameFr
	 *          the display name fr
	 */
	private SubstanceAdminSubstitution(String code, String displayNameEn, String displayNameFr) {
		this.code = code;
		this.displayNameEn = displayNameEn;
		this.displayNameFr = displayNameFr;
	}

	/**
	 * Gets the code.
	 *
	 * @param languageCode
	 *          the language code
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
