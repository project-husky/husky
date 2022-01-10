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

import org.husky.common.hl7cdar2.CS;
import org.husky.common.model.Code;

/*
*<div class="de">Die Codes beschreiben die möglichen Zustände einer Aktion</div>
*<div class="fr"></div>
*/
public enum StatusCode {

	/**
	 * <div class="en"></div> <div class="de">nicht mehr gewollt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	ABORTED(EnumConstants.ABORTED_CODE, EnumConstants.ABORTED_CODE),
	/**
	 * <div class="en"></div> <div class="de">aktiv</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	ACTIVE(EnumConstants.ACTIVE_CODE, EnumConstants.ACTIVE_CODE),
	/**
	 * <div class="en"></div> <div class="de">abgebrochen</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	CANCELLED(EnumConstants.CANCELLED_CODE, EnumConstants.CANCELLED_CODE),
	/**
	 * <div class="en"></div> <div class="de">erledigt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	COMPLETED(EnumConstants.COMPLETED_CODE, EnumConstants.COMPLETED_CODE),
	/**
	 * <div class="en"></div> <div class="de">abwartend</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	HELD("held", "held"),
	/**
	 * <div class="en"></div> <div class="de">aktuell</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	NEW("new", "new"),
	/**
	 * <div class="en"></div> <div class="de">ausgesetzt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	SUSPENDED(EnumConstants.SUSPENDED_CODE, EnumConstants.SUSPENDED_CODE);

	public static final String ABORTED_CODE = EnumConstants.ABORTED_CODE;
	public static final String ACTIVE_CODE = EnumConstants.ACTIVE_CODE;
	public static final String CANCELLED_CODE = EnumConstants.CANCELLED_CODE;
	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "ActStatus";
	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.14";
	public static final String COMPLETED_CODE = EnumConstants.COMPLETED_CODE;
	public static final String HELD_CODE = "held";

	public static final String NEW_CODE = "new";

	public static final String SUSPENDED_CODE = EnumConstants.SUSPENDED_CODE;

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static StatusCode getEnum(String code) {
		for (final StatusCode x : values()) {
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
			Enum.valueOf(StatusCode.class, enumName);
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
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final StatusCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private StatusCode(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the husky Code Object</div>
	 * <div class="de">Liefert das husky Code Objekt</div>
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
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CS getCS() {
		final CS cs = new CS();
		cs.setCode(code);
		return cs;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

}