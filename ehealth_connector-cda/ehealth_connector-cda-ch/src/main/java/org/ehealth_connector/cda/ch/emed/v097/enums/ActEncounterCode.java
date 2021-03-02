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
package org.ehealth_connector.cda.ch.emed.v097.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>Domain provides codes that qualify the ActEncounterClass (ENC)</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-02")
public enum ActEncounterCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ambulatory</div>
	 * <!-- @formatter:on -->
	 */
	AMBULATORY_L1("AMB", "2.16.840.1.113883.5.4", "ambulatory", "ambulatory", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">emergency</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_L1("EMER", "2.16.840.1.113883.5.4", "emergency", "emergency", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">field</div>
	 * <!-- @formatter:on -->
	 */
	FIELD_L1("FLD", "2.16.840.1.113883.5.4", "field", "field", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">home health</div>
	 * <!-- @formatter:on -->
	 */
	HOME_HEALTH_L1("HH", "2.16.840.1.113883.5.4", "home health", "home health", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">inpatient acute</div>
	 * <!-- @formatter:on -->
	 */
	INPATIENT_ACUTE_L2("ACUTE", "2.16.840.1.113883.5.4", "inpatient acute", "inpatient acute",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">inpatient encounter</div>
	 * <!-- @formatter:on -->
	 */
	INPATIENT_ENCOUNTER_L1("IMP", "2.16.840.1.113883.5.4", "inpatient encounter",
			"inpatient encounter", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">inpatient non-acute</div>
	 * <!-- @formatter:on -->
	 */
	INPATIENT_NON_ACUTE_L2("NONAC", "2.16.840.1.113883.5.4", "inpatient non-acute",
			"inpatient non-acute", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">observation encounter</div>
	 * <!-- @formatter:on -->
	 */
	OBSERVATION_ENCOUNTER_L1("OBSENC", "2.16.840.1.113883.5.4", "observation encounter",
			"observation encounter", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">pre-admission</div>
	 * <!-- @formatter:on -->
	 */
	PRE_ADMISSION_L1("PRENC", "2.16.840.1.113883.5.4", "pre-admission", "pre-admission",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">short stay</div>
	 * <!-- @formatter:on -->
	 */
	SHORT_STAY_L1("SS", "2.16.840.1.113883.5.4", "short stay", "short stay", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">virtual</div>
	 * <!-- @formatter:on -->
	 */
	VIRTUAL_L1("VR", "2.16.840.1.113883.5.4", "virtual", "virtual", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ambulatory</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMBULATORY_L1_CODE = "AMB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for emergency</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_L1_CODE = "EMER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for field</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FIELD_L1_CODE = "FLD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for home health</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOME_HEALTH_L1_CODE = "HH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for inpatient acute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INPATIENT_ACUTE_L2_CODE = "ACUTE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for inpatient encounter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INPATIENT_ENCOUNTER_L1_CODE = "IMP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for inpatient non-acute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INPATIENT_NON_ACUTE_L2_CODE = "NONAC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for observation encounter</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSERVATION_ENCOUNTER_L1_CODE = "OBSENC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for pre-admission</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRE_ADMISSION_L1_CODE = "PRENC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for short stay</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SHORT_STAY_L1_CODE = "SS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for virtual</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIRTUAL_L1_CODE = "VR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.13955";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ActEncounterCode";

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
	public static ActEncounterCode getEnum(final String code) {
		for (final ActEncounterCode x : values()) {
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
	public static boolean isEnumOfValueSet(final String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(ActEncounterCode.class, enumName);
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
	public static boolean isInValueSet(final String codeValue) {
		for (final ActEncounterCode x : values()) {
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
	ActEncounterCode(final String code, final String codeSystem, final String displayName,
			final String displayNameEn, final String displayNameDe, final String displayNameFr,
			final String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayNames = new HashMap<>();
		this.displayNames.put(null, displayName);
		this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
		this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
		this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
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
		String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
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
