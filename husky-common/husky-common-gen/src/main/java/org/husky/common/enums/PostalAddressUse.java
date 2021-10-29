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
package org.husky.common.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum PostalAddressUse implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">bad address</div>
	 * <!-- @formatter:on -->
	 */
	BAD_ADDRESS("BAD", "2.16.840.1.113883.5.1119", "bad address", "bad address", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">confidential</div>
	 * <!-- @formatter:on -->
	 */
	CONFIDENTIAL("CONF", "2.16.840.1.113883.5.1119", "confidential", "confidential", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">direct</div>
	 * <!-- @formatter:on -->
	 */
	DIRECT("DIR", "2.16.840.1.113883.5.1119", "direct", "direct", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">home address</div>
	 * <!-- @formatter:on -->
	 */
	HOME_ADDRESS("H", "2.16.840.1.113883.5.1119", "home address", "home address", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">physical visit address</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_VISIT_ADDRESS("PHYS", "2.16.840.1.113883.5.1119", "physical visit address",
			"physical visit address", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">postal address</div>
	 * <!-- @formatter:on -->
	 */
	POSTAL_ADDRESS("PST", "2.16.840.1.113883.5.1119", "postal address", "postal address",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">primary home</div>
	 * <!-- @formatter:on -->
	 */
	PRIMARY_HOME("HP", "2.16.840.1.113883.5.1119", "primary home", "primary home", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">public</div>
	 * <!-- @formatter:on -->
	 */
	PUBLIC("PUB", "2.16.840.1.113883.5.1119", "public", "public", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">temporary</div>
	 * <!-- @formatter:on -->
	 */
	TEMPORARY("TMP", "2.16.840.1.113883.5.1119", "temporary", "temporary", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">vacation home</div>
	 * <!-- @formatter:on -->
	 */
	VACATION_HOME("HV", "2.16.840.1.113883.5.1119", "vacation home", "vacation home", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">work place</div>
	 * <!-- @formatter:on -->
	 */
	WORK_PLACE("WP", "2.16.840.1.113883.5.1119", "work place", "work place", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for bad address</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BAD_ADDRESS_CODE = "BAD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for confidential</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONFIDENTIAL_CODE = "CONF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for direct</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIRECT_CODE = "DIR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for home address</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOME_ADDRESS_CODE = "H";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for physical visit address</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_VISIT_ADDRESS_CODE = "PHYS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for postal address</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSTAL_ADDRESS_CODE = "PST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for primary home</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRIMARY_HOME_CODE = "HP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for public</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PUBLIC_CODE = "PUB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for temporary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TEMPORARY_CODE = "TMP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for vacation home</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VACATION_HOME_CODE = "HV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for work place</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WORK_PLACE_CODE = "WP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10637";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "PostalAddressUse";

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
	public static PostalAddressUse getEnum(String code) {
		for (final PostalAddressUse x : values()) {
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
			Enum.valueOf(PostalAddressUse.class, enumName);
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
		for (final PostalAddressUse x : values()) {
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
	PostalAddressUse(String code, String codeSystem, String displayName, String displayNameEn,
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
