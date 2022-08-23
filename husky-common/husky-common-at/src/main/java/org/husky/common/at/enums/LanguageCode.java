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

import org.apache.commons.lang3.EnumUtils;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.model.Code;

public enum LanguageCode {

	ENGLISH("en", "English"), GERMAN_AT("de-AT", "German");

	public static final String CODE_SYSTEM_NAME = "";
	public static final String CODE_SYSTEM_OID = "ISO 3166";

	public static final String ENGLISH_CODE = "en";
	public static final String GERMAN_CODE = "de-AT";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * 
	 * @return the enum
	 */
	public static LanguageCode getEnum(String code) {
		for (final LanguageCode aLanguage : EnumUtils.getEnumList(LanguageCode.class)) {
			if (aLanguage.getCodeValue().equalsIgnoreCase(code)) {
				return aLanguage;
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
		return EnumUtils.isValidEnum(LanguageCode.class, enumName);
	}

	/**
	 * Checks if a given code value is in this value set.
	 *
	 * @param codeValue
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final LanguageCode aLang : EnumUtils.getEnumList(LanguageCode.class)) {
			if (aLang.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	private String code;

	private String displayName;

	/**
	 * Instantiates this Enum Object with a given Code and Display Name
	 *
	 * @param code
	 * @param displayName
	 */
	private LanguageCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * Gets the ehealthconnector Code Object
	 *
	 * @return the code
	 */
	public Code getCode() {
		return new Code(CODE_SYSTEM_OID, code, displayName);
	}

	/**
	 * Gets the code system name.
	 *
	 * @return the code system name
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * Gets the code system id.
	 *
	 * @return the code system id
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * Gets the actual Code as string
	 *
	 * @return the code
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * Gets the Code of this Enum as MDHT Object.
	 *
	 * @return The MDHT Code
	 */
	public CS getCS() {
		final CS cs = new CS();
		cs.setCode(code);
		return cs;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}
}
