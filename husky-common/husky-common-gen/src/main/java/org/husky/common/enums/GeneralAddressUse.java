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

import org.husky.common.hl7cdar2.CE;
import org.husky.common.model.Code;

/**
 * <div class="en">Address uses that can apply to both postal and
 * telecommunication addresses. </div>
 */
public enum GeneralAddressUse {

	/**
	 * <div class="en">A flag indicating that the address is bad, in fact,
	 * useless.</div>
	 */
	BAD("BAD", "bad address"),

	/**
	 * <div class="en">An office address. First choice for business related
	 * contacts during business hours.</div>
	 */
	BUSINESS("WP", "work place"),

	/**
	 * <div class="en">Indicates a work place address or telecommunication
	 * address that reaches the individual or organization directly without
	 * intermediaries. For phones, often referred to as a 'private line'.</div>
	 *
	 */
	BUSINESS_DIRECT("DIR", "direct"),

	/**
	 * <div class="en">Indicates that the address is considered sensitive and
	 * should only be shared or published in accordance with organizational
	 * controls governing patient demographic information with increased
	 * sensitivity. Uses of Addresses. Lloyd to supply more complete
	 * description.</div>
	 */
	CONFIDENTIAL("CONF", "confidential address"),

	/**
	 * <div class="en">This address is no longer in use. Usage Note: Address may
	 * also carry valid time ranges. This code is used to cover the situations
	 * where it is known that the address is no longer valid, but no particular
	 * time range for its use is known.</div>
	 */
	OLD("OLD", "no longer in use"),

	/**
	 * <div class="en">A communication address at a home, attempted contacts for
	 * business purposes might intrude privacy and chances are one will contact
	 * family or other household members instead of the person one wishes to
	 * call. Typically used with urgent cases, or if no other contacts are
	 * available.</div>
	 */
	PRIVATE("H", "home address"),

	/**
	 * <div class="en">The primary home, to reach a person after business
	 * hours.</div>
	 */
	PRIVATE_PRIMARY("HP", "primary home"),

	/**
	 * <div class="en">A vacation home, to reach a person while on
	 * vacation.</div>
	 */
	PRIVATE_VACATION("HV", "vacation home"),

	/**
	 * <div class="en">Indicates a work place address or telecommunication
	 * address that is a 'standard' address which may reach a reception service,
	 * mail-room, or other intermediary prior to the target entity.</div>
	 *
	 */
	PUBLIC("PUB", "public"),

	/**
	 * <div class="en">A temporary address, may be good for visit or mailing.
	 * Note that an address history can provide more detailed information.</div>
	 *
	 */
	TEMPORARY("TMP", "temporary address");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "AddressUse";

	/** The Constant CODE_SYSTEM. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1119";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static GeneralAddressUse getEnum(String code) {
		for (final GeneralAddressUse x : values()) {
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
			Enum.valueOf(GeneralAddressUse.class, enumName);
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
		for (GeneralAddressUse x : values()) {
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

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	GeneralAddressUse(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		final var ce = new CE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
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
	public Code getCode() {
		return new Code(code, CODE_SYSTEM_OID, displayName);
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
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
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
