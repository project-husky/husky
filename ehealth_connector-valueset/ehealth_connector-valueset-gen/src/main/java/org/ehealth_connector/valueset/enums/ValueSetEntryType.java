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
 * <div class="en">This enum serves to properly handle a ValueSetEntry (e.g.,
 * implementing the tree structure). The content of the enum is as given by
 * ART-DECOR. In the case of a possible implementation of the interface to the
 * terminology server, a mapping to the entry types in the terminology server
 * need to be made here.</div>
 *
 * <div class="de">Dieses Enum dient dazu, dass ein ValueSetEntry richtig
 * behandelt werden kann (z.B. Abbilden der Baumstruktur). Der Inhalt des Enums
 * ist wie von ART-DECOR vorgegeben. Bei einer allfälligen Implementierung der
 * Schnittstelle zum Terminologieserver muss hier evtl. ein Mapping zu den Entry
 * Typen im Terminologieserver gemacht werden.</div>.
 */
public enum ValueSetEntryType {

	/**
	 * <div class="en">Abstract node as given by ART-DECOR.</div>
	 *
	 * <div class="de">Abstrakter Knoten gemäss ART-DECOR.</div>
	 */
	ABSTRACT("A", "abstract"),

	/**
	 * <div class="en">Deprecated node as given by ART-DECOR.</div>
	 *
	 * <div class="de">Veralteter Knoten gemäss ART-DECOR.</div>
	 */
	DEPRECATED("D", "deprecated"),

	/**
	 * <div class="en">Leaf node as given by ART-DECOR.</div>
	 *
	 * <div class="de">Endknoten gemäss ART-DECOR.</div>
	 */
	LEAF("L", "leaf"),

	/**
	 * <div class="en">Specializable node as given by ART-DECOR.</div>
	 *
	 * <div class="de">Spezialisierbarer Knoten gemäss ART-DECOR.</div>
	 */
	SPECIALIZABLE("S", "specializable");
	//@formatter:on

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 *
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ValueSetEntryType getEnum(String code) {
		for (final ValueSetEntryType x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div>
	 *
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse)
	 * eindeutiger Code</div>.
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 *
	 * <div class="de">Menschenlesbarer Name</div>.
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div>
	 *
	 * <div class="de">Instantiiert dieses Enum Object mittels eines Codes und
	 * einem Display Name</div>.
	 *
	 * @param code
	 *            the code
	 * @param displayName
	 *            the display name
	 */
	private ValueSetEntryType(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the code value.</div>
	 *
	 * <div class="de">Ruft den Wert des Codes ab.</div>
	 *
	 * @return the code value
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div>
	 *
	 * <div class="de">Ruft den Anzeigenamen ab.</div>
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return this.displayName;
	}
}
