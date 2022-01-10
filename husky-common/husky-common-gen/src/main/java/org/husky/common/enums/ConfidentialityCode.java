/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;





/**
 * The Enum ConfidentialityCode contains the codes of the HL7 Vocabulary.
 */
public enum ConfidentialityCode implements ValueSetEnumInterface {
	
	

	/** <div class="de">Normal</div> <div class="fr"></div>. */
	LOW("L", EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID, "low"),

	/** <div class="de">Normal</div> <div class="fr"></div>. */
	MODERATE("M", EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID, "moderate"),

	/** <div class="de">Normal</div> <div class="fr"></div>. */
	NORMAL("N", EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID, "normal"),

	/** <div class="de">Vertraulich </div> <div class="fr"></div>. */
	RESTRICTED("R", EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID, "restricted"),

	/** <div class="de">Vertraulich </div> <div class="fr"></div>. */
	UNRESTRICTED("U", EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID, "unestricted"),

	/** <div class="de">Streng vertraulich</div> <div class="fr"></div>. */
	VERY_RESTRICTED("V", EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID, "very restricted");

	
	
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
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 *
	 * @return <div class="en">the code</div>
	 */
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

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	@Override
	public @NonNull String getCodeSystemId() {
		return this.oid;
	}

	@Override
	public @NonNull String getDisplayName(@Nullable LanguageCode languageCode) {
		return getDisplayName();
	}

	@Override
	public @NonNull String getValueSetId() {
		return EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_OID;
	}

	@Override
	public @NonNull String getValueSetName() {
		return EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert code
	 * system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	@Override
	public @NonNull String getCodeSystemName() {
		return EnumConstants.CONFIDENTIALITY_CODE_SYSTEM_NAME;
	}
}
