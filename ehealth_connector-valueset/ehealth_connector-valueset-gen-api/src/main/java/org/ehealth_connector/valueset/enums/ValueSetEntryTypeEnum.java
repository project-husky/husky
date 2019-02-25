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
package org.ehealth_connector.valueset.enums;

/**
 * Java Prototype for Value Set Management Concept.
 */
public enum ValueSetEntryTypeEnum {

	/**
	 * <div class="en"></div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	LEAF("L", "leaf"),
	/**
	 * <div class="en"></div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	SPECIALIZABLE("S", "specializable"),
	/**
	 * <div class="en"></div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	ABSTRACT("A", "abstract"),
	/**
	 * <div class="en"></div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	DEPRECATED("D", "deprecated");

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
	private ValueSetEntryTypeEnum(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public String getCodeValue() {
		return this.code;
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
