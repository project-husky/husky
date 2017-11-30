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
package org.ehealth_connector.cda.ch.lab.lrtp.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.LangTexts;

/**
 * The Enum VitalSignList.
 */
/*
 * <div class="en">List of vital signs</div> <div class="de">Liste der
 * Vitalzeichen</div>
 */
public enum VitalSignList {

	//@formatter:off
	/** <div class="en">Body height</div>. */
	BODY_HEIGHT("8302-2", "Körpergrösse", "Hauteur du corps", null, "Body height", "20140101", ""),

	/** <div class="en">Body temperature</div>. */
	BODY_TEMPERATURE("8310-5", "Körpertemperatur", "Température du corps", null, "Body temperature", "20140101", ""),

	/** <div class="en">Body weight Measured</div>. */
	BODY_WEIGHT_MEASURED("3141-9", "Körpergewicht", "Poids corporel", null, "Body weight", "20140101", ""),

	/** <div class="en">Diastolic blood pressure</div>. */
	DIASTOLIC_BLOOD_PRESSURE("8462-4", "Intrvaskulärer diastolischer Druck", "Diastolique intravasculaire", null,"Intravascular diastolic", "20140101", ""),

	/** <div class="en">Heart rate</div>. */
	HEART_RATE("8867-4", "Herzfrequenz", "Fréquence cardiaque", null, "Heart beat", "20140101", ""),

	/** <div class="en">Systolic blood pressure</div>. */
	SYSTOLIC_BLOOD_PRESSURE("8480-6", "Intravaskulärer systolischer Druck", "Systolique intravasculaire", null, "Intravascular systolic", "20140101", "");

	//@formatter:on

	/**
	 * <div class="en">Gets the Enum constant corresponding to the LOINC
	 * code</div>
	 *
	 * @return <div class="en">the Enum constant</div>
	 */
	public static VitalSignList getEnum(String loincCode) {
		final VitalSignList[] values = values();
		for (final VitalSignList VitalSignList : values) {
			if (VitalSignList.getLoinc().equals(loincCode)) {
				return VitalSignList;
			}
		}
		return null;
	}

	private String descriptionDe;
	private String descriptionEn;
	private String descriptionFr;
	private String descriptionIt;

	private String loinc;

	private VitalSignList(String loinc, String descriptionDe, String descriptionFr,
			String descriptionIt, String descriptionEn, String validFrom, String validTo) {
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
		final Code ret = new Code(CodeSystems.LOINC, loinc);
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
		LangTexts retVal = new LangTexts();
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