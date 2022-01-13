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

	/** <div class="de">Normal</div> <div class="fr"></div>. */
	LOW("L", CodeSystems.ConfidentialityCode.getCodeSystemId(), "low"),

	/** <div class="de">Normal</div> <div class="fr"></div>. */
	NORMAL("N", CodeSystems.ConfidentialityCode.getCodeSystemId(), "normal"),

	/** <div class="de">Vertraulich </div> <div class="fr"></div>. */
	RESTRICTED("R", CodeSystems.ConfidentialityCode.getCodeSystemId(), "restricted"),

	/** <div class="de">Streng vertraulich</div> <div class="fr"></div>. */
	VERY_RESTRICTED("V", CodeSystems.ConfidentialityCode.getCodeSystemId(), "very restricted");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.7";
	public static final String VALUE_SET_NAME = "ELGA_Confidentiality";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
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
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
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
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de">code</div>
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
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param oid
	 *            the oid
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private ConfidentialityCode(String code, String oid, String displayName) {
		this.code = code;
		this.displayName = displayName;
		this.oid = oid;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
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
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 *
	 * @return <div class="en">the code</div>
	 */

	@Override
	public Code getCode() {
		return new Code(oid, code, codeSystemName, displayName);
	}

	@Override
	public String getCodeSystemId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
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
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return this.oid;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 *
	 * @return <div class="en">the code</div>
	 */

	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
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
