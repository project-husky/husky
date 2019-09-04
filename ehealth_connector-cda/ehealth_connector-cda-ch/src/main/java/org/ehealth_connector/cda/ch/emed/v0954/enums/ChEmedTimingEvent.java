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
package org.ehealth_connector.cda.ch.emed.v0954.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ChEmedTimingEvent implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After breakfast</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_BREAKFAST("PCM", "2.16.840.1.113883.5.139", "After breakfast", "After breakfast", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After dinner</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_DINNER("PCV", "2.16.840.1.113883.5.139", "After dinner", "After dinner", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After lunch</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_LUNCH("PCD", "2.16.840.1.113883.5.139", "After lunch", "After lunch", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After meal</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_MEAL("PC", "2.16.840.1.113883.5.139", "After meal", "After meal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before breakfast</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_BREAKFAST("ACM", "2.16.840.1.113883.5.139", "Before breakfast", "Before breakfast", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before dinner</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_DINNER("ACV", "2.16.840.1.113883.5.139", "Before dinner", "Before dinner", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before lunch</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_LUNCH("ACD", "2.16.840.1.113883.5.139", "Before lunch", "Before lunch", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before meal</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_MEAL("AC", "2.16.840.1.113883.5.139", "Before meal", "Before meal", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before sleep</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_SLEEP("HS", "2.16.840.1.113883.5.139", "Before sleep", "Before sleep", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between breakfast and lunch</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_BREAKFAST_AND_LUNCH("ICM", "2.16.840.1.113883.5.139", "Between breakfast and lunch", "Between breakfast and lunch", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between dinner and the hour of sleep</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_DINNER_AND_THE_HOUR_OF_SLEEP("ICV", "2.16.840.1.113883.5.139", "Between dinner and the hour of sleep", "Between dinner and the hour of sleep", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between lunch and dinner</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_LUNCH_AND_DINNER("ICD", "2.16.840.1.113883.5.139", "Between lunch and dinner", "Between lunch and dinner", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between meals</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_MEALS("IC", "2.16.840.1.113883.5.139", "Between meals", "Between meals", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">During meals</div>
	 * <!-- @formatter:on -->
	 */
	DURING_MEALS("C", "2.16.840.1.113883.5.139", "During meals", "During meals", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Waking up</div>
	 * <!-- @formatter:on -->
	 */
	WAKING_UP("WAKE", "2.16.840.1.113883.5.139", "Waking up", "Waking up", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After breakfast</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_BREAKFAST_CODE = "PCM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After dinner</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_DINNER_CODE = "PCV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After lunch</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_LUNCH_CODE = "PCD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After meal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_MEAL_CODE = "PC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before breakfast</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_BREAKFAST_CODE = "ACM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before dinner</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_DINNER_CODE = "ACV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before lunch</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_LUNCH_CODE = "ACD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before meal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_MEAL_CODE = "AC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before sleep</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_SLEEP_CODE = "HS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between breakfast and lunch</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_BREAKFAST_AND_LUNCH_CODE = "ICM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between dinner and the hour of sleep</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_DINNER_AND_THE_HOUR_OF_SLEEP_CODE = "ICV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between lunch and dinner</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_LUNCH_AND_DINNER_CODE = "ICD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between meals</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_MEALS_CODE = "IC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for During meals</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DURING_MEALS_CODE = "C";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Waking up</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WAKING_UP_CODE = "WAKE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator fÃ¼r das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.77.4.11.2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "CH-EMED-TimingEvent";

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
	public static ChEmedTimingEvent getEnum(String code) {
		for (final ChEmedTimingEvent x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">PrÃ¼ft, ob der angegebene enum Teil dieses Value Sets ist.</div>
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
			Enum.valueOf(ChEmedTimingEvent.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">PrÃ¼ft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ChEmedTimingEvent x : values()) {
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
	ChEmedTimingEvent(String code, String codeSystem, String displayName, String displayNameEn, String displayNameDe, String displayNameFr, String displayNameIt) {
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
	 * <div class="de">Liefert display name gemÃ¤ss Parameter, falls es keine
	 * Englische Ãœbersetzung gibt, wird der default-Name zurÃ¼ckgegeben.</div>
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
