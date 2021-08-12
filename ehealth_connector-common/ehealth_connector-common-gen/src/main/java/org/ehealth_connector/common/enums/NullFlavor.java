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
package org.ehealth_connector.common.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>    <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum NullFlavor implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">asked but unknown</div>
	 * <!-- @formatter:on -->
	 */
	ASKED_BUT_UNKNOWN("ASKU", "2.16.840.1.113883.5.1008", "asked but unknown", "asked but unknown",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">derived</div>
	 * <!-- @formatter:on -->
	 */
	DERIVED("DER", "2.16.840.1.113883.5.1008", "derived", "derived", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">invalid</div>
	 * <!-- @formatter:on -->
	 */
	INVALID("INV", "2.16.840.1.113883.5.1008", "invalid", "invalid", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">masked</div>
	 * <!-- @formatter:on -->
	 */
	MASKED("MSK", "2.16.840.1.113883.5.1008", "masked", "masked", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">negative infinity</div>
	 * <!-- @formatter:on -->
	 */
	NEGATIVE_INFINITY("NINF", "2.16.840.1.113883.5.1008", "negative infinity", "negative infinity",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">NoInformation</div>
	 * <!-- @formatter:on -->
	 */
	NOINFORMATION("NI", "2.16.840.1.113883.5.1008", "NoInformation", "NoInformation", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">not applicable</div>
	 * <!-- @formatter:on -->
	 */
	NOT_APPLICABLE("NA", "2.16.840.1.113883.5.1008", "not applicable", "not applicable",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">not asked</div>
	 * <!-- @formatter:on -->
	 */
	NOT_ASKED("NASK", "2.16.840.1.113883.5.1008", "not asked", "not asked", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Not available</div>
	 * <!-- @formatter:on -->
	 */
	NOT_AVAILABLE("NAVU", "2.16.840.1.113883.5.1008", "Not available", "Not available",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">other</div>
	 * <!-- @formatter:on -->
	 */
	OTHER("OTH", "2.16.840.1.113883.5.1008", "other", "other", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">positive infinity</div>
	 * <!-- @formatter:on -->
	 */
	POSITIVE_INFINITY("PINF", "2.16.840.1.113883.5.1008", "positive infinity", "positive infinity",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sufficient Quantity</div>
	 * <!-- @formatter:on -->
	 */
	SUFFICIENT_QUANTITY("QS", "2.16.840.1.113883.5.1008", "Sufficient Quantity",
			"Sufficient Quantity", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">temporarily unavailable</div>
	 * <!-- @formatter:on -->
	 */
	TEMPORARILY_UNAVAILABLE("NAV", "2.16.840.1.113883.5.1008", "temporarily unavailable",
			"temporarily unavailable", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">trace</div>
	 * <!-- @formatter:on -->
	 */
	TRACE("TRC", "2.16.840.1.113883.5.1008", "trace", "trace", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">unknown</div>
	 * <!-- @formatter:on -->
	 */
	UNKNOWN("UNK", "2.16.840.1.113883.5.1008", "unknown", "unknown", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">un-encoded</div>
	 * <!-- @formatter:on -->
	 */
	UN_ENCODED("UNC", "2.16.840.1.113883.5.1008", "un-encoded", "un-encoded", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for asked but unknown</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ASKED_BUT_UNKNOWN_CODE = "ASKU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for derived</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DERIVED_CODE = "DER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for invalid</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INVALID_CODE = "INV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for masked</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MASKED_CODE = "MSK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for negative infinity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEGATIVE_INFINITY_CODE = "NINF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for NoInformation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NOINFORMATION_CODE = "NI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for not applicable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NOT_APPLICABLE_CODE = "NA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for not asked</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NOT_ASKED_CODE = "NASK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Not available</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NOT_AVAILABLE_CODE = "NAVU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for other</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_CODE = "OTH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for positive infinity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSITIVE_INFINITY_CODE = "PINF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sufficient Quantity</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUFFICIENT_QUANTITY_CODE = "QS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for temporarily unavailable</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TEMPORARILY_UNAVAILABLE_CODE = "NAV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for trace</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRACE_CODE = "TRC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for unknown</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNKNOWN_CODE = "UNK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for un-encoded</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UN_ENCODED_CODE = "UNC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10609";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "NullFlavor";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static NullFlavor getEnum(String code) {
		for (final NullFlavor x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(NullFlavor.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final NullFlavor x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	NullFlavor(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
