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

import org.husky.common.hl7cdar2.CE;
import org.husky.common.model.Code;

/**
 * The Enum ConfidentialityCode contains the codes of the HL7 Vocabulary.
 */
public enum ConfidentialityCode implements ValueSetEnumInterfaceAt {

	LOW("L", CodeSystems.ConfidentialityCode.getCodeSystemId(), "low"),

	NORMAL("N", CodeSystems.ConfidentialityCode.getCodeSystemId(), "normal"),

	RESTRICTED("R", CodeSystems.ConfidentialityCode.getCodeSystemId(), "restricted"),

	VERY_RESTRICTED("V", CodeSystems.ConfidentialityCode.getCodeSystemId(), "very restricted");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.7";
	public static final String VALUE_SET_NAME = "ELGA_Confidentiality";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * @return the enum
	 */
	public static ConfidentialityCode getEnum(String code) {
		for (final ConfidentialityCode x : values()) {
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
			Enum.valueOf(ConfidentialityCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * Checks if a given code value is in this value set.
	 *
	 * @param codeValue
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (ConfidentialityCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/** The code. */
	private String code;

	/** The display name. */
	private String displayName;
	
	/** The code system name */
	private String codeSystemName;

	/** The oid. */
	private String oid;

	/**
	 * Instantiates this Enum Object with a given Code and Display Name
	 *
	 * @param code
	 * @param oid         the oid
	 * @param displayName
	 */
	private ConfidentialityCode(String code, String oid, String displayName) {
		this.code = code;
		this.displayName = displayName;
		this.oid = oid;
	}

	/**
	 * Gets the Code of this Enum as MDHT Object.
	 *
	 * @return The MDHT Code
	 */
	@Override
	public CE getCE() {
		final CE ce = new CE();
		ce.setCodeSystem(oid);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * Gets the ehealthconnector Code Object
	 *
	 * @return the code
	 */

	@Override
	public Code getCode() {
		return new Code(code, oid, codeSystemName, displayName);
	}

	@Override
	public String getCodeSystemId() {
		return VALUE_SET_ID;
	}

	/**
	 * Gets the code system name.
	 *
	 * @return the code system name
	 */

	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.oid);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * Gets the code system id.
	 * 
	 * @return the code system id
	 */
	public String getCodeSystemOid() {
		return this.oid;
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
	 * Gets the display name.
	 *
	 * @return the display name
	 */

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String getDisplayNameAt(LanguageCode languageCode) {
		return this.displayName;
	}

	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}

}
