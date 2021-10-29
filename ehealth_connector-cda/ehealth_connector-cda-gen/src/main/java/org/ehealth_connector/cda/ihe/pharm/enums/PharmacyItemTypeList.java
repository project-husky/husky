/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.ehealth_connector.cda.ihe.pharm.enums;

import org.ehealth_connector.common.mdht.Code;

/**
 * The Enum OrderableDrugFrom MaterialForm (OID 2.16.840.1.113883.5.85)
 */
@Deprecated(forRemoval = true) // Replaced
public enum PharmacyItemTypeList {

	/** <div class="en"> Medication Treatment Plan Item</div> */
	MTPItem("MTPItem", "Medication Treatment Plan Item"),

	/** <div class="en"> Prescription Item</div> */
	PREItem("PREItem", "Prescription Item"),

	/** <div class="en"> Dispense Item</div> */
	DISItem("DISItem", "Dispense Item"),

	/** <div class="en"> Pharmaceutical Advice Item</div> */
	PADVItem("PADVItem", "Pharmaceutical Advice Item");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "IHE Pharmacy Item Type List";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "1.3.6.1.4.1.19376.1.9.2.2";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static PharmacyItemTypeList getEnum(String code) {
		for (final PharmacyItemTypeList x : values()) {
			if (x.code.equals(code)) {
				return x;
			}
		}
		return null;
	}

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameEn;

	/**
	 * Instantiates a new OrderableDrugFrom.
	 *
	 * @param code
	 *            the code
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameFr
	 *            the display name fr
	 */
	private PharmacyItemTypeList(String code, String displayNameEn) {
		this.code = code;
		this.displayNameEn = displayNameEn;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayNameEn);
		return ehcCode;
	}

}
