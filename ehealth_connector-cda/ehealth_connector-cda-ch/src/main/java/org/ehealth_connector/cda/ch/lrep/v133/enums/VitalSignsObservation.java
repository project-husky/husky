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
package org.ehealth_connector.cda.ch.lrep.v133.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">IHE PCC TF VOL2 6.3.4.22.2</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum VitalSignsObservation implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Body height</div>
	 * <!-- @formatter:on -->
	 */
	BODY_HEIGHT("8302-2", "2.16.840.1.113883.6.1", "Body height", "Body height", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Body height --lying</div>
	 * <!-- @formatter:on -->
	 */
	BODY_HEIGHT_LYING("8306-3", "2.16.840.1.113883.6.1", "Body height --lying",
			"Body height --lying", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Body temperature</div>
	 * <!-- @formatter:on -->
	 */
	BODY_TEMPERATURE("8310-5", "2.16.840.1.113883.6.1", "Body temperature", "Body temperature",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Body weight Measured</div>
	 * <!-- @formatter:on -->
	 */
	BODY_WEIGHT_MEASURED("3141-9", "2.16.840.1.113883.6.1", "Body weight Measured",
			"Body weight Measured", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diastolic blood pressure</div>
	 * <!-- @formatter:on -->
	 */
	DIASTOLIC_BLOOD_PRESSURE("8462-4", "2.16.840.1.113883.6.1", "Diastolic blood pressure",
			"Diastolic blood pressure", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Head Occipital-frontal circumference by Tape measure</div>
	 * <!-- @formatter:on -->
	 */
	HEAD_OCCIPITAL_FRONTAL_CIRCUMFERENCE_BY_TAPE_MEASURE("8287-5", "2.16.840.1.113883.6.1",
			"Head Occipital-frontal circumference by Tape measure",
			"Head Occipital-frontal circumference by Tape measure", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Heart rate</div>
	 * <!-- @formatter:on -->
	 */
	HEART_RATE("8867-4", "2.16.840.1.113883.6.1", "Heart rate", "Heart rate", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oxygen/Inspired gas Respiratory system --on ventilator</div>
	 * <!-- @formatter:on -->
	 */
	OXYGEN_INSPIRED_GAS_RESPIRATORY_SYSTEM_ON_VENTILATOR("19996-8", "2.16.840.1.113883.6.1",
			"Oxygen/Inspired gas Respiratory system --on ventilator",
			"Oxygen/Inspired gas Respiratory system --on ventilator", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oxygen/Inspired gas setting</div>
	 * <!-- @formatter:on -->
	 */
	OXYGEN_INSPIRED_GAS_SETTING("19994-3", "2.16.840.1.113883.6.1", "Oxygen/Inspired gas setting",
			"Oxygen/Inspired gas setting", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oxygen saturation (deprecated)</div>
	 * <!-- @formatter:on -->
	 */
	OXYGEN_SATURATION_DEPRECATED("2710-2", "2.16.840.1.113883.6.1",
			"Oxygen saturation (deprecated)", "Oxygen saturation (deprecated)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oxygen saturation in Arterial blood by Pulse oximetry</div>
	 * <!-- @formatter:on -->
	 */
	OXYGEN_SATURATION_IN_ARTERIAL_BLOOD_BY_PULSE_OXIMETRY("59408-5", "2.16.840.1.113883.6.1",
			"Oxygen saturation in Arterial blood by Pulse oximetry",
			"Oxygen saturation in Arterial blood by Pulse oximetry", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Respiratory rate</div>
	 * <!-- @formatter:on -->
	 */
	RESPIRATORY_RATE("9279-1", "2.16.840.1.113883.6.1", "Respiratory rate", "Respiratory rate",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Systolic blood pressure</div>
	 * <!-- @formatter:on -->
	 */
	SYSTOLIC_BLOOD_PRESSURE("8480-6", "2.16.840.1.113883.6.1", "Systolic blood pressure",
			"Systolic blood pressure", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Body height</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODY_HEIGHT_CODE = "8302-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Body height --lying</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODY_HEIGHT_LYING_CODE = "8306-3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Body temperature</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODY_TEMPERATURE_CODE = "8310-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Body weight Measured</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODY_WEIGHT_MEASURED_CODE = "3141-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diastolic blood pressure</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIASTOLIC_BLOOD_PRESSURE_CODE = "8462-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Head Occipital-frontal circumference by Tape measure</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEAD_OCCIPITAL_FRONTAL_CIRCUMFERENCE_BY_TAPE_MEASURE_CODE = "8287-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Heart rate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEART_RATE_CODE = "8867-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oxygen/Inspired gas Respiratory system --on ventilator</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OXYGEN_INSPIRED_GAS_RESPIRATORY_SYSTEM_ON_VENTILATOR_CODE = "19996-8";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oxygen/Inspired gas setting</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OXYGEN_INSPIRED_GAS_SETTING_CODE = "19994-3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oxygen saturation (deprecated)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OXYGEN_SATURATION_DEPRECATED_CODE = "2710-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oxygen saturation in Arterial blood by Pulse oximetry</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OXYGEN_SATURATION_IN_ARTERIAL_BLOOD_BY_PULSE_OXIMETRY_CODE = "59408-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Respiratory rate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESPIRATORY_RATE_CODE = "9279-1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Systolic blood pressure</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SYSTOLIC_BLOOD_PRESSURE_CODE = "8480-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "VitalSignsObservation";

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
	public static VitalSignsObservation getEnum(String code) {
		for (final VitalSignsObservation x : values()) {
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
			Enum.valueOf(VitalSignsObservation.class, enumName);
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
		for (final VitalSignsObservation x : values()) {
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
	VitalSignsObservation(String code, String codeSystem, String displayName, String displayNameEn,
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
