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
 * The Enum SeverityObservation HL7 ObservationValue (OID 2.16.840.1.113883.5.1063)
 */
public enum SeverityObservation {

	/** <div class="en"> High</div><div class="fr">Sévère</div> */ 
	H("H","High","Sévère"),
	
	/** <div class="en"> Moderate</div><div class="fr">Modéré</div> */ 
	M("M","Moderate","Modéré"),
	
	/** <div class="en"> Low</div><div class="fr">Peu sévère</div> */ 
	L("L","Low","Peu sévère");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "SeverityObservation";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1063";

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameEn;

	/** The display name. */
	private String displayNameFr;
	
	/**
	 * Instantiates a new SeverityObservation.
	 *
	 * @param code the code
	 * @param displayNameEn the display name en
	 * @param displayNameFr the display name fr
	 */
	private SeverityObservation(String code, String displayNameEn, String displayNameFr) {
		this.code = code;
		this.displayNameEn = displayNameEn;
		this.displayNameFr = displayNameFr;
	}



	/**
	 * Gets the code.
	 *
	 * @param languageCode the language code
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
	

	/**
	 * Gets the enum.
	 *
	 * @param code the code
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
	
}
