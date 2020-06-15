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
package org.ehealth_connector.cda.ch.vacd.v210.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>    <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A code or set of codes (e.g., for routine, emergency,) specifying the urgency under which the Act happened, can happen, is happening, is intended to happen, or is requested/demanded to happen.</p><p>    <i>Discussion:</i> This attribute is used in orders to indicate the ordered priority, and in event documentation it indicates the actual priority used to perform the act. In definition mood it indicates the available priorities.</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ActPriority implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ASAP</div>
	 * <!-- @formatter:on -->
	 */
	ASAP("A", "2.16.840.1.113883.5.7", "ASAP", "ASAP", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">as needed</div>
	 * <!-- @formatter:on -->
	 */
	AS_NEEDED("PRN", "2.16.840.1.113883.5.7", "as needed", "as needed", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">callback for scheduling</div>
	 * <!-- @formatter:on -->
	 */
	CALLBACK_FOR_SCHEDULING("CS", "2.16.840.1.113883.5.7", "callback for scheduling",
			"callback for scheduling", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">callback results</div>
	 * <!-- @formatter:on -->
	 */
	CALLBACK_RESULTS("CR", "2.16.840.1.113883.5.7", "callback results", "callback results",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">elective</div>
	 * <!-- @formatter:on -->
	 */
	ELECTIVE("EL", "2.16.840.1.113883.5.7", "elective", "elective", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">emergency</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY("EM", "2.16.840.1.113883.5.7", "emergency", "emergency", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">preop</div>
	 * <!-- @formatter:on -->
	 */
	PREOP("P", "2.16.840.1.113883.5.7", "preop", "preop", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">routine</div>
	 * <!-- @formatter:on -->
	 */
	ROUTINE("R", "2.16.840.1.113883.5.7", "routine", "routine", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">rush reporting</div>
	 * <!-- @formatter:on -->
	 */
	RUSH_REPORTING("RR", "2.16.840.1.113883.5.7", "rush reporting", "rush reporting", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">stat</div>
	 * <!-- @formatter:on -->
	 */
	STAT("S", "2.16.840.1.113883.5.7", "stat", "stat", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">timing critical</div>
	 * <!-- @formatter:on -->
	 */
	TIMING_CRITICAL("T", "2.16.840.1.113883.5.7", "timing critical", "timing critical",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">urgent</div>
	 * <!-- @formatter:on -->
	 */
	URGENT("UR", "2.16.840.1.113883.5.7", "urgent", "urgent", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">use as directed</div>
	 * <!-- @formatter:on -->
	 */
	USE_AS_DIRECTED("UD", "2.16.840.1.113883.5.7", "use as directed", "use as directed",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ASAP</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ASAP_CODE = "A";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for as needed</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AS_NEEDED_CODE = "PRN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for callback for scheduling</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CALLBACK_FOR_SCHEDULING_CODE = "CS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for callback results</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CALLBACK_RESULTS_CODE = "CR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for elective</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ELECTIVE_CODE = "EL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for emergency</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_CODE = "EM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for preop</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREOP_CODE = "P";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for routine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROUTINE_CODE = "R";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for rush reporting</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RUSH_REPORTING_CODE = "RR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for stat</div>
	 * <!-- @formatter:on -->
	 */
	public static final String STAT_CODE = "S";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for timing critical</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TIMING_CRITICAL_CODE = "T";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for urgent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URGENT_CODE = "UR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for use as directed</div>
	 * <!-- @formatter:on -->
	 */
	public static final String USE_AS_DIRECTED_CODE = "UD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.16866";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ActPriority";

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
	public static ActPriority getEnum(String code) {
		for (final ActPriority x : values()) {
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
			Enum.valueOf(ActPriority.class, enumName);
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
		for (final ActPriority x : values()) {
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
	ActPriority(String code, String codeSystem, String displayName, String displayNameEn,
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
