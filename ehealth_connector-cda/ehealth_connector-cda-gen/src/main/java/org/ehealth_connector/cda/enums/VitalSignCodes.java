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

package org.ehealth_connector.cda.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodeSystems;

/*
 *<div class="de">Codesystem: LOINC (2.16.840.1.113883.6.1).</div>
 */
public enum VitalSignCodes {
	//@formatter:off
	BODY_HEIGHT("8302-2", "Körpergrösse (gemessen)", null, null, "body height (measured)"),
	BODY_HEIGHT_LYING("8306-3", "Körpergrösse im Liegen", null, null, "body height lying"),
	BODY_TEMPERATURE_CEL("8310-5", "Körpertemperatur", null, null, "body temperature"),
	BODY_WEIGHT("3141-9", "Körpergewicht (gewogen)", null, null, "body weight (measured)"),
	CIRCUMFRENCE_OCCIPITAL_FRONTAL("8287-5", "Kopfumfang okzipitofrontal", null, null, "circumfence occipital frontal"),
	HEART_BEAT("8867-4", "Herzfrequenz", null, null, "heart beat"),
	INTRAVASCULAR_DIASTOLIC("8462-4", "Intrvaskulärer diastolischer Druck", null, null,"intravascular diastolic"),
	INTRAVASCULAR_SYSTOLIC("8480-6", "Intravaskulärer systolischer Druck", null, null, "intravascular systolic"),
	OXYGEN_SATURATION_PERCENT("2710-2", "Sauerstoffsättigung", null, null, "oxygen saturation"),
	RESPIRATION_RATE("9279-1", "Atemfrequenz", null, null, "respiration rate");
	//@formatter:on

	/**
	 * <div class="en">Gets the Enum constant corresponding to the LOINC
	 * code</div>
	 *
	 * @return <div class="en">the Enum constant</div>
	 */
	public static VitalSignCodes getEnum(String loincCode) {
		VitalSignCodes[] values = values();
		for (VitalSignCodes vitalSignCodes : values) {
			if (vitalSignCodes.getLoinc().equals(loincCode)) {
				return vitalSignCodes;
			}
		}
		return null;
	}

	private String descriptionDe;
	private String descriptionEn;
	private String descriptionFr;
	private String descriptionIt;

	private String loinc;

	private VitalSignCodes(String loinc, String descriptionDe, String descriptionFr,
			String descriptionIt, String descriptionEn) {
		this.loinc = loinc;
		this.descriptionDe = descriptionDe;
		this.descriptionFr = descriptionFr;
		this.descriptionIt = descriptionIt;
		this.descriptionEn = descriptionEn;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ret = new Code(CodeSystems.LOINC, loinc);
		ret.setDisplayName(getDisplayName(null));
		return ret;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName(LanguageCode lc) {
		String lcStr = LanguageCode.ENGLISH.getCodeValue();
		if (lc != null) {
			lcStr = lc.getCodeValue().toLowerCase();
		}
		if (lcStr.equals(LanguageCode.GERMAN.getCodeValue().toLowerCase()))
			return getDisplayNameDe();
		if (lcStr.equals(LanguageCode.FRENCH.getCodeValue().toLowerCase()))
			return getDisplayNameFr();
		if (lcStr.equals(LanguageCode.ITALIAN.getCodeValue().toLowerCase()))
			return getDisplayNameIt();
		if ("de".equals(lcStr))
			return getDisplayNameDe();
		if ("fr".equals(lcStr))
			return getDisplayNameFr();
		if ("it".equals(lcStr))
			return getDisplayNameIt();
		if ("en".equals(lcStr))
			return getDisplayNameEn();
		return getDisplayNameDe();
	}

	/**
	 * <div class="en">Gets the corresponding LOINC code.</div>
	 *
	 * @return <div class="en">LOINC code as String</div>
	 */
	public String getLoinc() {
		return loinc;
	}

	private String getDisplayNameDe() {
		if (descriptionDe != null) {
			return descriptionDe;
		}
		return getDisplayNameEn();
	}

	private String getDisplayNameEn() {
		if (descriptionEn != null) {
			return descriptionEn;
		}
		return name();
	}

	private String getDisplayNameFr() {
		if (descriptionFr != null) {
			return descriptionFr;
		}
		return getDisplayNameEn();
	}

	private String getDisplayNameIt() {
		if (descriptionIt != null) {
			return descriptionIt;
		}
		return getDisplayNameEn();
	}

}