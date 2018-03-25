/*
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
package org.ehealth_connector.common.enums;

import org.apache.commons.lang3.EnumUtils;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * ISO 3166-1 alpha-3 Country Code
 */
public enum CountryCode {

	/**
	 * <div class="en">Austria</div> <div class="de">Österreich</div>
	 * <div class="fr">Autriche</div>
	 */
	AUSTRIA("AT", "AUT", "Austria"),
	/**
	 * <div class="en">Switzerland</div> <div class="de">Schweiz</div>
	 * <div class="fr">Suisse</div>
	 */
	SWITZERLAND("CH", "CHE", "Switzerland");

	public static final String CODE_SYSTEM_NAME = "ISO 3166-1 alpha-3";
	public static final String CODE_SYSTEM_OID = "1.0.3166.2.2.3";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static CountryCode getEnum(String code) {
		for (final CountryCode aLanguage : EnumUtils.getEnumList(CountryCode.class)) {
			if (aLanguage.getCodeAlpha3().equalsIgnoreCase(code)) {
				return aLanguage;
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
		return EnumUtils.isValidEnum(CountryCode.class, enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
	 * vorhanden ist.</div>
	 *
	 * @param codeValue
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final CountryCode aLang : EnumUtils.getEnumList(CountryCode.class)) {
			if (aLang.getCodeAlpha3().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	private String codeAlpha2;

	private String codeAlpha3;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param codeAlpha2
	 *            the ISO county code alpha 2
	 * @param codeAlpha3
	 *            the ISO county code alpha 2
	 * @param displayName
	 *            the displayName
	 */
	private CountryCode(String codeAlpha2, String codeAlpha3, String displayName) {
		this.codeAlpha2 = codeAlpha2;
		this.codeAlpha3 = codeAlpha3;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, codeAlpha3, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the actual ISO Country Code Alpha 2 as string</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeAlpha2() {
		return codeAlpha2;
	}

	/**
	 * <div class="en">Gets the actual ISO Country Code Alpha 3 as string</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeAlpha3() {
		return codeAlpha3;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CS getCS() {
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(codeAlpha3);
		return cs;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayName;
	}
}