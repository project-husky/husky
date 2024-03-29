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

public enum AuthorRole implements ValueSetEnumInterfaceAt {

	DENTIST("701", "1.2.40.0.34.5.3", "Zahnärztin/Zahnarzt"),

	HOSPITAL("702", "1.2.40.0.34.5.3", "Krankenanstalt"),

	PHARMACIST("704", "1.2.40.0.34.5.3", "Apotheke"),

	PHYSICIAN("700", "1.2.40.0.34.5.3", "Arzt/Ärztin"),

	CARE_HOME("703", "1.2.40.0.34.5.3", "Einrichtung der Pflege"),

	ELGA_CONSULTING("705", "1.2.40.0.34.5.3", "ELGA-Beratung"),

	ELGA_OFFICE_OF_OMBUDSMAN("706", "1.2.40.0.34.5.3", "ELGA-Ombudsstelle"),

	ELGA_OBJECTION_OFFICE("607", "1.2.40.0.34.5.158", "ELGA-Widerspruchstelle"),

	ELGA_RULES_ADMINISTRATOR("608", "1.2.40.0.34.5.158", "ELGA-Regelwerkadministration"),

	ELGA_SECURITY_ADMINISTRATOR("609", "1.2.40.0.34.5.158", "ELGA-Sicherheitsadministration"),

	ELGA_PARTICIPANT("610", "1.2.40.0.34.5.158", "ELGA-Teilnehmerin/Teilnehmer"),

	AUTHORIZED_ELGA_PARTICIPANT("611", "1.2.40.0.34.5.158", "ELGA-Vollmachtnehmende Person");

	public static final String PHYSICIAN_CODE = "700";
	public static final String DENTIST_CODE = "701";
	public static final String HOSPITAL_CODE = "702";
	public static final String CARE_HOME_CODE = "703";
	public static final String PHARMACY_CODE = "704";
	public static final String ELGA_CONSULTING_CODE = "705";
	public static final String ELGA_OFFICE_OF_OMBUDSMAN_CODE = "706";
	public static final String ELGA_OBJECTION_OFFICE_CODE = "607";
	public static final String ELGA_RULES_ADMINISTRATOR_CODE = "608";
	public static final String ELGA_SECURITY_ADMINISTRATOR_CODE = "609";
	public static final String ELGA_PARTICIPANT_CODE = "610";
	public static final String AUTHORIZED_ELGA_PARTICIPANT_CODE = "611";

	/**
	 * Identifier of the value set
	 */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.26";

	/**
	 * Name of the value set
	 */
	public static final String VALUE_SET_NAME = "ELGA_Rollen";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * 
	 * @return the enum
	 */
	public static AuthorRole getEnum(String code) {
		for (final AuthorRole x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * Checks if a given enum is part of this value set.
	 *
	 * @param enumName enumName
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(AuthorRole.class, enumName);
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
		for (final AuthorRole x : values()) {
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
	 * @param code        code
	 * @param codeSystem  codeSystem
	 * @param displayName the default display name
	 */
	AuthorRole(String code, String codeSystem, String displayName) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
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
