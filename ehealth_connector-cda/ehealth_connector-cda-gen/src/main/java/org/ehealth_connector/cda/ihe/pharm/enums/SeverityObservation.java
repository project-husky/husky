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

package org.ehealth_connector.cda.ihe.pharm.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 * The Enum SeverityObservation HL7 ObservationValue (OID
 * 2.16.840.1.113883.5.1063)
 */
public enum SeverityObservation {

	/** <div class="en"> High</div><div class="fr">Sévère</div> */
	HIGH("H", "High", "Sévère"),

	/** <div class="en"> Low</div><div class="fr">Peu sévère</div> */
	LOW("L", "Low", "Peu sévère"),

	/** <div class="en"> Moderate</div><div class="fr">Modéré</div> */
	MODERATE("M", "Moderate", "Modéré");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "SeverityObservation";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1063";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static SeverityObservation getEnum(String code) {
		for (final SeverityObservation x : values()) {
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
	 * Instantiates a new SeverityObservation.
	 *
	 * @param code
	 *            the code
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameFr
	 *            the display name fr
	 */
	private SeverityObservation(String code, String displayNameEn, String displayNameFr) {
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
