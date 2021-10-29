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

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum EntityNameUse implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Alphabetic</div>
	 * <!-- @formatter:on -->
	 */
	ALPHABETIC("ABC", "2.16.840.1.113883.5.45", "Alphabetic", "Alphabetic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Artist/Stage</div>
	 * <!-- @formatter:on -->
	 */
	ARTIST_STAGE("A", "2.16.840.1.113883.5.45", "Artist/Stage", "Artist/Stage", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">assigned</div>
	 * <!-- @formatter:on -->
	 */
	ASSIGNED("ASGN", "2.16.840.1.113883.5.45", "assigned", "assigned", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ideographic</div>
	 * <!-- @formatter:on -->
	 */
	IDEOGRAPHIC("IDE", "2.16.840.1.113883.5.45", "Ideographic", "Ideographic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Indigenous/Tribal</div>
	 * <!-- @formatter:on -->
	 */
	INDIGENOUS_TRIBAL("I", "2.16.840.1.113883.5.45", "Indigenous/Tribal", "Indigenous/Tribal",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Legal</div>
	 * <!-- @formatter:on -->
	 */
	LEGAL("L", "2.16.840.1.113883.5.45", "Legal", "Legal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">License</div>
	 * <!-- @formatter:on -->
	 */
	LICENSE("C", "2.16.840.1.113883.5.45", "License", "License", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">official registry</div>
	 * <!-- @formatter:on -->
	 */
	OFFICIAL_REGISTRY("OR", "2.16.840.1.113883.5.45", "official registry", "official registry",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">phonetic</div>
	 * <!-- @formatter:on -->
	 */
	PHONETIC("PHON", "2.16.840.1.113883.5.45", "phonetic", "phonetic", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">pseudonym</div>
	 * <!-- @formatter:on -->
	 */
	PSEUDONYM("P", "2.16.840.1.113883.5.45", "pseudonym", "pseudonym", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Religious</div>
	 * <!-- @formatter:on -->
	 */
	RELIGIOUS("R", "2.16.840.1.113883.5.45", "Religious", "Religious", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">search v:HL7SearchUse</div>
	 * <!-- @formatter:on -->
	 */
	SEARCH_V_HL7SEARCHUSE("SRCH", "2.16.840.1.113883.5.45", "search v:HL7SearchUse",
			"search v:HL7SearchUse", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Soundex</div>
	 * <!-- @formatter:on -->
	 */
	SOUNDEX("SNDX", "2.16.840.1.113883.5.45", "Soundex", "Soundex", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Syllabic</div>
	 * <!-- @formatter:on -->
	 */
	SYLLABIC("SYL", "2.16.840.1.113883.5.45", "Syllabic", "Syllabic", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Alphabetic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALPHABETIC_CODE = "ABC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Artist/Stage</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ARTIST_STAGE_CODE = "A";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for assigned</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ASSIGNED_CODE = "ASGN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ideographic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IDEOGRAPHIC_CODE = "IDE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Indigenous/Tribal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INDIGENOUS_TRIBAL_CODE = "I";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Legal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LEGAL_CODE = "L";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for License</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LICENSE_CODE = "C";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for official registry</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OFFICIAL_REGISTRY_CODE = "OR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for phonetic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHONETIC_CODE = "PHON";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for pseudonym</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSEUDONYM_CODE = "P";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Religious</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RELIGIOUS_CODE = "R";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for search v:HL7SearchUse</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEARCH_V_HL7SEARCHUSE_CODE = "SRCH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Soundex</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SOUNDEX_CODE = "SNDX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Syllabic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYLLABIC_CODE = "SYL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.27";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ELGA_EntityNameUse";

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
	public static EntityNameUse getEnum(String code) {
		for (final EntityNameUse x : values()) {
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
			Enum.valueOf(EntityNameUse.class, enumName);
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
		for (final EntityNameUse x : values()) {
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
	EntityNameUse(String code, String codeSystem, String displayName, String displayNameEn,
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
