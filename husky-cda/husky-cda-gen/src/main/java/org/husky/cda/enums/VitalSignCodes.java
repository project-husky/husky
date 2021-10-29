/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.husky.cda.enums;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.model.Code;
import org.husky.common.utils.LangText;
import org.husky.common.utils.LangTexts;

/*
 *<div class="de">Codesystem: LOINC (2.16.840.1.113883.6.1).</div>
 */
public enum VitalSignCodes {
	//@formatter:off
	/** <div class="en">body height (measured)</div><div class="de">Körpergrösse (gemessen)</div>*/
	BODY_HEIGHT("8302-2", "Körpergrösse", "Hauteur du corps", null, "Body height"),
	/** <div class="en">body height lying</div><div class="de">Körpergrösse im Liegen</div>*/
	BODY_HEIGHT_LYING("8306-3", "Körpergrösse im Liegen", "Hauteur du corps allongé", null, "Body height lying"),
	/** <div class="en">body temperature</div><div class="de">Körpertemperatur</div>*/
	BODY_TEMPERATURE_CEL("8310-5", "Körpertemperatur", "Température du corps", null, "Body temperature"),
	/** <div class="en">body weight (measured)</div><div class="de">Körpergewicht (gewogen)</div>*/
	BODY_WEIGHT("3141-9", "Körpergewicht", "Poids corporel", null, "Body weight"),
	/** <div class="en">circumfence occipital frontal</div><div class="de">Kopfumfang okzipitofrontal</div>*/
	CIRCUMFRENCE_OCCIPITAL_FRONTAL("8287-5", "Kopfumfang okzipitofrontal", "Circonférence front occipital", null, "Circumfence occipital frontal"),
	/** <div class="en">heart beat</div><div class="de">Herzfrequenz</div>*/
	HEART_BEAT("8867-4", "Herzfrequenz", "Fréquence cardiaque", null, "Heart beat"),
	/** <div class="en">intravascular diastolic</div><div class="de">Intrvaskulärer diastolischer Druck</div>*/
	INTRAVASCULAR_DIASTOLIC("8462-4", "Intrvaskulärer diastolischer Druck", "Diastolique intravasculaire", null,"Intravascular diastolic"),
	/** <div class="en">intravascular systolic</div><div class="de">Intravaskulärer systolischer Druck</div>*/
	INTRAVASCULAR_SYSTOLIC("8480-6", "Intravaskulärer systolischer Druck", "Systolique intravasculaire", null, "Intravascular systolic"),
	/** <div class="en">oxygen saturation</div><div class="de">Sauerstoffsättigung</div>*/
	OXYGEN_SATURATION_PERCENT("2710-2", "Sauerstoffsättigung", "Saturation en oxygène", null, "Oxygen saturation"),
	/** <div class="en">respiration rate</div><div class="de">Atemfrequenz</div>*/
	RESPIRATION_RATE("9279-1", "Atemfrequenz", "Taux de respiration", null, "Respiration rate");
	//@formatter:on

	/**
	 * <div class="en">Gets the Enum constant corresponding to the LOINC
	 * code</div>
	 *
	 * @return <div class="en">the Enum constant</div>
	 */
	public static VitalSignCodes getEnum(String loincCode) {
		final VitalSignCodes[] values = values();
		for (final VitalSignCodes vitalSignCodes : values) {
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
		final var ret = new Code(CodeSystems.LOINC.getCodeSystemId(), loinc, null);
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

	public LangTexts getLangTexts() {
		var retVal = new LangTexts();
		retVal.add(new LangText(LanguageCode.GERMAN, descriptionDe));
		retVal.add(new LangText(LanguageCode.ENGLISH, descriptionEn));
		retVal.add(new LangText(LanguageCode.FRENCH, descriptionFr));
		retVal.add(new LangText(LanguageCode.ITALIAN, descriptionIt));
		return retVal;
	}

	/**
	 * <div class="en">Gets the corresponding LOINC code.</div>
	 *
	 * @return <div class="en">LOINC code as String</div>
	 */
	public String getLoinc() {
		return loinc;
	}

}