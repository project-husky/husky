/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.common.at.enums;

import java.util.HashMap;
import java.util.Map;

public enum FormatCode implements ValueSetEnumInterfaceAt {

	ELGA_DOCUMENT_BASIC_2011("urn:elga:2011:EIS_Basic", "ELGA Dokument", "ELGA Dokument"),

	ELGA_DOCUMENT_BASIC_2013("urn:elga:2013:EIS_Basic", "ELGA Dokument", "ELGA Dokument"),

	ELGA_DOCUMENT_BASIC_2014("urn:elga:2014:EIS_Basic", "ELGA Dokument", "ELGA Dokument"),

	ELGA_DOCUMENT_BASIC_206("urn:elga:2015-v2.06:EIS_Basic", "ELGA Dokument v2.06",
			"ELGA Dokument v2.06"),

	ELGA_DOCUMENT_BASIC_2015("urn:elga:2015:EIS_Basic", "ELGA Dokument", "ELGA Dokument"),

	ELGA_NURSE_DISCHARGE_SUMMARY_BASIC("urn:elga:dissum-n:2014:EIS_Basic",
			"ELGA Entlassungsbrief Pflege, EIS Basic", "ELGA Entlassungsbrief Pflege, EIS Basic"),

	ELGA_NURSE_DISCHARGE_SUMMARY_ENHANCED("urn:elga:dissum-n:2014:EIS_Enhanced",
			"ELGA Entlassungsbrief Pflege, EIS Enhanced",
			"ELGA Entlassungsbrief Pflege, EIS Enhanced"),

	ELGA_NURSE_DISCHARGE_SUMMARY_FULL_SUPPORT("urn:elga:dissum-n:2014:EIS_FullSupport",
			"ELGA Entlassungsbrief Pflege, EIS Full Support",
			"ELGA Entlassungsbrief Pflege, EIS Full Support"),

	ELGA_NURSE_DISCHARGE_SUMMARY_BASIC_V206("urn:elga:dissum-n:2015-v2.06:EIS_Basic",
			"ELGA Entlassungsbrief Pflege, EIS Basic v2.06",
			"ELGA Entlassungsbrief Pflege, EIS Basic v2.06"),

	ELGA_NURSE_DISCHARGE_SUMMARY_ENHANCED_V206("urn:elga:dissum-n:2015-v2.06:EIS_Enhanced",
			"ELGA Entlassungsbrief Pflege, EIS Enhanced v2.06",
			"ELGA Entlassungsbrief Pflege, EIS Enhanced v2.06"),

	ELGA_NURSE_DISCHARGE_SUMMARY_FULL_SUPPORT_V206("urn:elga:dissum-n:2015-v2.06:EIS_FullSupport",
			"ELGA Entlassungsbrief Pflege, EIS Full Support v2.06",
			"ELGA Entlassungsbrief Pflege, EIS Full Support v2.06"),

	ELGA_NURSE_DISCHARGE_SUMMARY_BASIC_2015("urn:elga:dissum-n:2015:EIS_Basic",
			"ELGA Entlassungsbrief Pflege, EIS Basic", "ELGA Entlassungsbrief Pflege, EIS Basic"),

	ELGA_NURSE_DISCHARGE_SUMMARY_ENHANCED_2015("urn:elga:dissum-n:2015:EIS_Enhanced",
			"ELGA Entlassungsbrief Pflege, EIS Enhanced",
			"ELGA Entlassungsbrief Pflege, EIS Enhanced"),

	ELGA_NURSE_DISCHARGE_SUMMARY_FULL_SUPPORT_2015("urn:elga:dissum-n:2015:EIS_FullSupport",
			"ELGA Entlassungsbrief Pflege, EIS Full Support",
			"ELGA Entlassungsbrief Pflege, EIS Full Support"),

	ELGA_DISCHARGE_SUMMARY_BASIC_2011("urn:elga:dissum:2011:EIS_Basic", "ELGA Entlassungsbrief",
			"ELGA Entlassungsbrief"),

	ELGA_DISCHARGE_SUMMARY_ENHANCED_2011("urn:elga:dissum:2011:EIS_Enhanced",
			"ELGA Entlassungsbrief", "ELGA Entlassungsbrief"),

	ELGA_DISCHARGE_SUMMARY_FULL_SUPPORT_2011("urn:elga:dissum:2011:EIS_FullSupport",
			"ELGA Entlassungsbrief", "ELGA Entlassungsbrief"),

	ELGA_DISCHARGE_SUMMARY_BASIC_2013("urn:elga:dissum:2013:EIS_Basic", "ELGA Entlassungsbrief",
			"ELGA Entlassungsbrief"),

	ELGA_DISCHARGE_SUMMARY_ENHANCED_2013("urn:elga:dissum:2013:EIS_Enhanced",
			"ELGA Entlassungsbrief", "ELGA Entlassungsbrief"),

	ELGA_DISCHARGE_SUMMARY_FULL_SUPPORT_2013("urn:elga:dissum:2013:EIS_FullSupport",
			"ELGA Entlassungsbrief", "ELGA Entlassungsbrief"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_BASIC_2014("urn:elga:dissum:2014:EIS_Basic",
			"ELGA Entlassungsbrief Ärztlich, EIS Basic",
			"ELGA Entlassungsbrief Ärztlich, EIS Basic"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_ENHANCED_2014("urn:elga:dissum:2014:EIS_Enhanced",
			"ELGA Entlassungsbrief Ärztlich, EIS Enhanced",
			"ELGA Entlassungsbrief Ärztlich, EIS Enhanced"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_FULL_SUPPORT_2014("urn:elga:dissum:2014:EIS_FullSupport",
			"ELGA Entlassungsbrief Ärztlich, EIS Full Support",
			"ELGA Entlassungsbrief Ärztlich, EIS Full Support"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_BASIC_V206("urn:elga:dissum:2015-v2.06:EIS_Basic",
			"ELGA Entlassungsbrief Ärztlich, EIS Basic v2.06",
			"ELGA Entlassungsbrief Ärztlich, EIS Basic v2.06"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_ENHANCED_V206("urn:elga:dissum:2015-v2.06:EIS_Enhanced",
			"ELGA Entlassungsbrief Ärztlich, EIS Enhanced v2.06",
			"ELGA Entlassungsbrief Ärztlich, EIS Enhanced v2.06"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_FULL_SUPPORT_V206("urn:elga:dissum:2015-v2.06:EIS_FullSupport",
			"ELGA Entlassungsbrief Ärztlich, EIS Full Support v2.06",
			"ELGA Entlassungsbrief Ärztlich, EIS Full Support v2.06"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_BASIC_2015("urn:elga:dissum:2015:EIS_Basic",
			"ELGA Entlassungsbrief Ärztlich, EIS Basic",
			"ELGA Entlassungsbrief Ärztlich, EIS Basic"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_ENHANCED_2015("urn:elga:dissum:2015:EIS_Enhanced",
			"ELGA Entlassungsbrief Ärztlich, EIS Enhanced",
			"ELGA Entlassungsbrief Ärztlich, EIS Enhanced"),

	ELGA_MEDICAL_DISCHARGE_SUMMARY_FULL_SUPPORT_2015("urn:elga:dissum:2015:EIS_FullSupport",
			"ELGA Entlassungsbrief Ärztlich, EIS Full Support",
			"ELGA Entlassungsbrief Ärztlich, EIS Full Support"),

	ELGA_EMEDICATION_FULL_SUPPORT_2014("urn:elga:emedat:2014:EIS_FullSupport",
			"ELGA e-Medikation, EIS Full Support", "ELGA e-Medikation, EIS Full Support"),

	ELGA_EMEDICATION_FULL_SUPPORT_2015("urn:elga:emedat:2015", "ELGA e-Medikation",
			"ELGA e-Medikation"),

	ELGA_EMEDICATION_2015_V206("urn:elga:emedat:2015-v2.06", "ELGA e-Medikation v2.06",
			"ELGA e-Medikation v2.06"),

	ELGA_LAB_REPORT_BASIC_2011("urn:elga:lab:2011:EIS_Basic", "ELGA Befundbericht Labor",
			"ELGA Befundbericht Labor"),

	ELGA_LAB_REPORT_ENHANCED_2011("urn:elga:lab:2011:EIS_Enhanced", "ELGA Befundbericht Labor",
			"ELGA Befundbericht Labor"),

	ELGA_LAB_REPORT_FULL_SUPPORT_2011("urn:elga:lab:2011:EIS_FullSupport",
			"ELGA Befundbericht Labor", "ELGA Befundbericht Labor"),

	ELGA_LAB_REPORT_BASIC_2013("urn:elga:lab:2013:EIS_Basic", "ELGA Befundbericht Labor",
			"ELGA Befundbericht Labor"),

	ELGA_LAB_REPORT_ENHANCED_2013("urn:elga:lab:2013:EIS_Enhanced", "ELGA Befundbericht Labor",
			"ELGA Befundbericht Labor"),

	ELGA_LAB_REPORT_FULL_SUPPORT_2013("urn:elga:lab:2013:EIS_FullSupport",
			"ELGA Befundbericht Labor", "ELGA Befundbericht Labor"),

	ELGA_LAB_REPORT_BASIC_2014("urn:elga:lab:2014:EIS_Basic", "ELGA Laborbefund, EIS Basic",
			"ELGA Laborbefund, EIS Basic"),

	ELGA_LAB_REPORT_ENHANCED_2014("urn:elga:lab:2014:EIS_Enhanced",
			"ELGA Laborbefund, EIS Enhanced", "ELGA Laborbefund, EIS Enhanced"),

	ELGA_LAB_REPORT_FULL_SUPPORT_2014("urn:elga:lab:2014:EIS_FullSupport",
			"ELGA Laborbefund, EIS Full Support", "ELGA Laborbefund, EIS Full Support"),

	ELGA_LAB_REPORT_BASIC_V206_2015("urn:elga:lab:2015-v2.06:EIS_Basic",
			"ELGA Laborbefund, EIS Basic v2.06", "ELGA Laborbefund, EIS Basic v2.06"),

	ELGA_LAB_REPORT_ENHANCED_V206_2015("urn:elga:lab:2015-v2.06:EIS_Enhanced",
			"ELGA Laborbefund, EIS Enhanced v2.06", "ELGA Laborbefund, EIS Enhanced v2.06"),

	ELGA_LAB_REPORT_FULL_SUPPORT_V206_2015("urn:elga:lab:2015-v2.06:EIS_FullSupport",
			"ELGA Laborbefund, EIS Full Support v2.06", "ELGA Laborbefund, EIS Full Support v2.06"),

	ELGA_LAB_REPORT_BASIC_2015("urn:elga:lab:2015:EIS_Basic", "ELGA Laborbefund, EIS Basic",
			"ELGA Laborbefund, EIS Basic"),

	ELGA_LAB_REPORT_ENHANCED_2015("urn:elga:lab:2015:EIS_Enhanced",
			"ELGA Laborbefund, EIS Enhanced", "ELGA Laborbefund, EIS Enhanced"),

	ELGA_LAB_REPORT_FULL_SUPPORT_2015("urn:elga:lab:2015:EIS_FullSupport",
			"ELGA Laborbefund, EIS Full Support", "ELGA Laborbefund, EIS Full Support"),

	ELGA_NURSING_REPORT_BASIC_2015("urn:elga:nurse-tf:2015-v2.06:EIS_Basic",
			"ELGA Pflegesituationsbericht, EIS Basic v2.06",
			"ELGA Pflegesituationsbericht, EIS Basic v2.06"),

	ELGA_NURSING_REPORT_ENHANCED_2015("urn:elga:nurse-tf:2015-v2.06:EIS_Enhanced",
			"ELGA Pflegesituationsbericht, EIS Enhanced v2.06",
			"ELGA Pflegesituationsbericht, EIS Enhanced v2.06"),

	ELGA_NURSING_REPORT_FULL_SUPPORT_2015("urn:elga:nurse-tf:2015-v2.06:EIS_FullSupport",
			"ELGA Pflegesituationsbericht, EIS Full Support v2.06",
			"ELGA Pflegesituationsbericht, EIS Full Support v2.06"),

	ELGA_RADIOLOGY_REPORT_BASIC_2011("urn:elga:radio:2011:EIS_Basic",
			"ELGA Befundbericht Radiologie", "ELGA Befundbericht Radiologie"),

	ELGA_RADIOLOGY_REPORT_ENHANCED_2011("urn:elga:radio:2011:EIS_Enhanced",
			"ELGA Befundbericht Radiologie", "ELGA Befundbericht Radiologie"),

	ELGA_RADIOLOGY_REPORT_FULL_SUPPORT_2011("urn:elga:radio:2011:EIS_FullSupport",
			"ELGA Befundbericht Radiologie", "ELGA Befundbericht Radiologie"),

	ELGA_RADIOLOGY_REPORT_BASIC_2013("urn:elga:radio:2013:EIS_Basic",
			"ELGA Befundbericht Radiologie", "ELGA Befundbericht Radiologie"),

	ELGA_RADIOLOGY_REPORT_ENHANCED_2013("urn:elga:radio:2013:EIS_Enhanced",
			"ELGA Befundbericht Radiologie", "ELGA Befundbericht Radiologie"),

	ELGA_RADIOLOGY_REPORT_FULL_SUPPORT_2013("urn:elga:radio:2013:EIS_FullSupport",
			"ELGA Befundbericht Radiologie", "ELGA Befundbericht Radiologie"),

	ELGA_RADIOLOGY_REPORT_BASIC_2014("urn:elga:radio:2014:EIS_Basic",
			"ELGA Befund bildgebende Diagnostik, EIS Basic",
			"ELGA Befund bildgebende Diagnostik, EIS Basic"),

	ELGA_RADIOLOGY_REPORT_ENHANCED_2014("urn:elga:radio:2014:EIS_Enhanced",
			"ELGA Befund bildgebende Diagnostik, EIS Enhanced",
			"ELGA Befund bildgebende Diagnostik, EIS Enhanced"),

	ELGA_RADIOLOGY_REPORT_FULL_SUPPORT_2014("urn:elga:radio:2014:EIS_FullSupport",
			"ELGA Befund bildgebende Diagnostik,EIS Full Support",
			"ELGA Befund bildgebende Diagnostik,EIS Full Support"),

	ELGA_RADIOLOGY_REPORT_BASIC_V206_2015("urn:elga:radio:2015-v2.06:EIS_Basic",
			"ELGA Befund bildgebende Diagnostik, EIS Basic v2.06",
			"ELGA Befund bildgebende Diagnostik, EIS Basic v2.06"),

	ELGA_RADIOLOGY_REPORT_ENHANCED_V206_2015("urn:elga:radio:2015-v2.06:EIS_Enhanced",
			"ELGA Befund bildgebende Diagnostik, EIS Enhanced v2.06",
			"ELGA Befund bildgebende Diagnostik, EIS Enhanced v2.06"),

	ELGA_RADIOLOGY_REPORT_FULL_SUPPORT_V206_2015("urn:elga:radio:2015-v2.06:EIS_FullSupport",
			"ELGA Befund bildgebende Diagnostik, EIS Full Support v2.06",
			"ELGA Befund bildgebende Diagnostik, EIS Full Support v2.06"),

	ELGA_RADIOLOGY_REPORT_BASIC_2015("urn:elga:radio:2015:EIS_Basic",
			"ELGA Befund bildgebende Diagnostik, EIS Basic",
			"ELGA Befund bildgebende Diagnostik, EIS Basic"),

	ELGA_RADIOLOGY_REPORT_ENHANCED_2015("urn:elga:radio:2015:EIS_Enhanced",
			"ELGA Befund bildgebende Diagnostik, EIS Enhanced",
			"ELGA Befund bildgebende Diagnostik, EIS Enhanced"),

	ELGA_RADIOLOGY_REPORT_FULL_SUPPORT_2015("urn:elga:radio:2015:EIS_FullSupport",
			"ELGA Befund bildgebende Diagnostik,EIS Full Support",
			"ELGA Befund bildgebende Diagnostik,EIS Full Support"),

	ELGA_PHC_2017("urn:elga:phc:2017", "PHC Statusbericht", "PHC Statusbericht"),

	ELGA_IMMUNIZATION_RECORD_2019("urn:hl7-at:eImpf:2019", "HL7 Austria e-Impfpass 2019",
			"HL7 Austria e-Impfpass 2019");

	/**
	 * Identifier of the value set
	 */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.61";

	/**
	 * Name of the value set
	 */
	public static final String VALUE_SET_NAME = "ELGA_Formatcode";

	public static final String OID_FORMAT_CODE = "1.2.40.0.34.5.37";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * 
	 * @return the enum
	 */
	public static FormatCode getEnum(String code) {
		for (final FormatCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * Checks if a given enum is part of this value set.
	 *
	 * @param enumName
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(FormatCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * Checks if a given code value is in this value set.
	 *
	 * @param codeValue
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final FormatCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Machine interpretable and (inside this class) unique code
	 */
	private String code;

	/**
	 * Identifier of the referencing code system.
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * Instantiates this Enum Object with a given Code and Display Name
	 *
	 * @param code          code
	 * @param codeSystem    codeSystem
	 * @param displayName   the default display name
	 * @param displayNameDe the display name de
	 */
	FormatCode(String code, String displayName, String displayNameDe) {
		this.code = code;
		this.codeSystem = OID_FORMAT_CODE;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.GERMAN_AT, displayNameDe);
	}

	/**
	 * Gets the code system identifier.
	 *
	 * @return the code system identifier
	 */

	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * Gets the code system name.
	 *
	 * @return the code system identifier
	 */

	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * Gets the actual Code as string
	 *
	 * @return the code
	 */

	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * Gets the display name defined by the language param. If there is no english
	 * translation, the default display name is returned.
	 *
	 * @param languageCode the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayNameAt(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	public FormatCode[] getValues() {
		return values();
	}

	/**
	 * Gets the value set identifier.
	 *
	 * @return the value set identifier
	 */

	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * Gets the value set name.
	 *
	 * @return the value set name
	 */

	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}

}
