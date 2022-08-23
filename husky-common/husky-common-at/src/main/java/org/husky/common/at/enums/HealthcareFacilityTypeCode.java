/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.at.enums;

import java.util.HashMap;
import java.util.Map;

public enum HealthcareFacilityTypeCode implements ValueSetEnumInterfaceAt {

	GENERAL_PRACTITIONER("100", "Ärztin/Arzt für Allgemeinmedizin",
			"Ärztin/Arzt für Allgemeinmedizin"),

	APPROBATED_PHYSICIANS("101", "Approbierte Ärztin/Approbierter Arzt",
			"Approbierte Ärztin/Approbierter Arzt"),

	DENTIST("155", "Zahnärztin/Zahnarzt", "Zahnärztin/Zahnarzt"),

	SPECIALIST("158", "Fachärztin/Facharzt", "Fachärztin/Facharzt"),

	NURSING_PERSONAL("212",
			"Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger",
			"Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger"),

	CHILDREN_NURSING_PERSONAL("213",
			"Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger",
			"Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger"),

	GENERAL_HOSPITAL("300", "Allgemeine Krankenanstalt", "Allgemeine Krankenanstalt"),

	SPECIAL_HOSPITAL("301", "Sonderkrankenanstalt", "Sonderkrankenanstalt"),

	NURSING_HOME("301", "Pflegeanstalt", "Pflegeanstalt"),

	SANATORIUM("303", "Sanatorium", "Sanatorium"),

	INDEPENDENT_OUTPATIENT_CLINIC("304", "Selbstständiges Ambulatorium",
			"Selbstständiges Ambulatorium"),

	CARE_FACILITY("305", "Pflegeeinrichtung", "Pflegeeinrichtung"),

	MOBILE_CARE("306", "Mobile Pflege", "Mobile Pflege"),

	KUR_SANATORIUM("307", "Kuranstalt", "Kuranstalt"),

	DIAGNOSTIC_INSTITUTION("310", "Untersuchungsanstalt", "Untersuchungsanstalt"),

	PHARMACY("311", "Öffentliche Apotheke", "Öffentliche Apotheke"),

	DENTIST_GROUP_PRACTICE("319", "Zahnärztliche Gruppenpraxis", "Zahnärztliche Gruppenpraxis"),

	PHYSICIAN_GROUP_PRACTICE("320", "Ärztliche Gruppenpraxis", "Ärztliche Gruppenpraxis"),

	SOCIAL_INSURANCE("406", "Sozialversicherung", "Sozialversicherung");

	public static final String GENERAL_PRACTITIONER_CODE = "100";

	public static final String APPROBATED_PHYSICIANS_CODE = "101";

	public static final String DENTIST_CODE = "155";

	public static final String SPECIALIST_CODE = "158";

	public static final String NURSING_PERSONAL_CODE = "212";

	public static final String CHILDREN_NURSING_PERSONAL_CODE = "213";

	public static final String GENERAL_HOSPITAL_CODE = "300";

	public static final String SPECIAL_HOSPITAL_CODE = "301";

	public static final String NURSING_HOME_CODE = "302";

	public static final String SANATORIUM_CODE = "303";

	public static final String INDEPENDENT_OUTPATIENT_CLINIC_CODE = "304";

	public static final String CARE_FACILITY_CODE = "305";

	public static final String MOBILE_CARE_CODE = "306";

	public static final String KUR_SANATORIUM_CODE = "307";

	public static final String DIAGNOSTIC_INSTITUTION_CODE = "310";

	public static final String PHARMACY_CODE = "311";

	public static final String DENTIST_GROUP_PRACTICE_CODE = "319";

	public static final String PHYSICIAN_GROUP_PRACTICE_CODE = "320";

	public static final String SOCIAL_INSURANCE_CODE = "406";

	/**
	 * Identifier of the value set
	 */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.72";

	/**
	 * Name of the value set
	 */
	public static final String VALUE_SET_NAME = "ELGA_HealthcareFacilityTypeCode";

	public static final String OID_HEALTHCAREFACILITYTYPES = "1.2.40.0.34.5.2";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * @return the enum
	 */
	public static HealthcareFacilityTypeCode getEnum(String code) {
		for (final HealthcareFacilityTypeCode x : values()) {
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
			Enum.valueOf(HealthcareFacilityTypeCode.class, enumName);
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
		for (final HealthcareFacilityTypeCode x : values()) {
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
	 * @param displayNameEn the display name en
	 * @param displayNameDe the display name de
	 * @param displayNameFr the display name fr
	 * @param displayNameIt the display name it
	 */
	HealthcareFacilityTypeCode(String code, String displayName, String displayNameDe) {
		this.code = code;
		this.codeSystem = OID_HEALTHCAREFACILITYTYPES;
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
	 * Gets the code system name
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
