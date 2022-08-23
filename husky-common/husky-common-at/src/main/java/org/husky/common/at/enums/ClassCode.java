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

public enum ClassCode implements ValueSetEnumInterfaceAt {

	DISCHARGE_SUMMARY("18842-5", "2.16.840.1.113883.6.1", "Discharge summary",
			"Entlassungsbrief"),

	NURSTE_TRANSFER_NOTE("28651-8", "2.16.840.1.113883.6.1", "Nurse Transfer note",
			"Pflegesituationsbericht"),

	LABORATORY_REPORT("11502-2", "2.16.840.1.113883.6.1", "Laboratory report",
			"Laborbefund"),

	DIAGNOSTIC_IMAGE_STUDY("18748-4", "2.16.840.1.113883.6.1", "Diagnostic imaging study",
			"Befund bildgebende Diagnostik"),

	KEY_IMAGES_DOCUMENT_RADIOLOGY("55113-5", "2.16.840.1.113883.6.1",
			"Key images Doc Radiology", "KOS Objekte"),

	PHYSICIAN_NOTE("75476-2", "2.16.840.1.113883.6.1", "Physician note",
			"Ärztlicher Befund"),

	HISTORY_IMMUNIZATION("11369-6", "2.16.840.1.113883.6.1",
			"HISTORY OF IMMUNIZATIONS", "Immunisierungsstatus"),

	TELEHEALTH_NOTE("75496-0", "2.16.840.1.113883.6.1", "Telehealth Note",
			"Telemedizin Bericht"),

	MEDICATIONS("52471-0", "2.16.840.1.113883.6.1", "Medications", "Medikation");

	/**
	 * Identifier of the value set
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.6.1";

	/**
	 * Name of the value set
	 */
	public static final String VALUE_SET_NAME = "ELGA_Dokumentenklassen";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * @return the enum
	 */
	public static ClassCode getEnum(String code) {
		for (final ClassCode x : values()) {
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
			Enum.valueOf(ClassCode.class, enumName);
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
		for (final ClassCode x : values()) {
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
	ClassCode(String code, String codeSystem, String displayName, String displayNameDe) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(org.husky.common.at.enums.LanguageCode.GERMAN_AT,
				displayNameDe);
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

	@Override
	public String getDisplayNameAt(
			org.husky.common.at.enums.LanguageCode languageCode) {
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
