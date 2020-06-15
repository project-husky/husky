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
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum SwissVaccinationPlanImmunizations implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BCG vaccination</div>
	 * <!-- @formatter:on -->
	 */
	BCG_VACCINATION("42284007", "2.16.840.1.113883.6.96", "BCG vaccination", "BCG vaccination",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diphtheria vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	DIPHTHERIA_VACCINATION_PROCEDURE("76668005", "2.16.840.1.113883.6.96",
			"Diphtheria vaccination (procedure)", "Diphtheria vaccination (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Haemophilus influenzae type b vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINATION_PROCEDURE("127787002", "2.16.840.1.113883.6.96",
			"Haemophilus influenzae type b vaccination (procedure)",
			"Haemophilus influenzae type b vaccination (procedure)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hepatitis A immunization (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	HEPATITIS_A_IMMUNIZATION_PROCEDURE("243789007", "2.16.840.1.113883.6.96",
			"Hepatitis A immunization (procedure)", "Hepatitis A immunization (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hepatitis B vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	HEPATITIS_B_VACCINATION_PROCEDURE("16584000", "2.16.840.1.113883.6.96",
			"Hepatitis B vaccination (procedure)", "Hepatitis B vaccination (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Influenza vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	INFLUENZA_VACCINATION_PROCEDURE("86198006", "2.16.840.1.113883.6.96",
			"Influenza vaccination (procedure)", "Influenza vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Japanese encephalitis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	JAPANESE_ENCEPHALITIS_VACCINATION_PROCEDURE("314759000", "2.16.840.1.113883.6.96",
			"Japanese encephalitis vaccination (procedure)",
			"Japanese encephalitis vaccination (procedure)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Measles vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	MEASLES_VACCINATION_PROCEDURE("47435007", "2.16.840.1.113883.6.96",
			"Measles vaccination (procedure)", "Measles vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Meningococcus vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	MENINGOCOCCUS_VACCINATION_PROCEDURE("41088001", "2.16.840.1.113883.6.96",
			"Meningococcus vaccination (procedure)", "Meningococcus vaccination (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mumps vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	MUMPS_VACCINATION_PROCEDURE("50583002", "2.16.840.1.113883.6.96",
			"Mumps vaccination (procedure)", "Mumps vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pertussis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	PERTUSSIS_VACCINATION_PROCEDURE("39343008", "2.16.840.1.113883.6.96",
			"Pertussis vaccination (procedure)", "Pertussis vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pneumococcal vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	PNEUMOCOCCAL_VACCINATION_PROCEDURE("12866006", "2.16.840.1.113883.6.96",
			"Pneumococcal vaccination (procedure)", "Pneumococcal vaccination (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Poliomyelitis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	POLIOMYELITIS_VACCINATION_PROCEDURE("72093006", "2.16.840.1.113883.6.96",
			"Poliomyelitis vaccination (procedure)", "Poliomyelitis vaccination (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rabies vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	RABIES_VACCINATION_PROCEDURE("34631000", "2.16.840.1.113883.6.96",
			"Rabies vaccination (procedure)", "Rabies vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rubella vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	RUBELLA_VACCINATION_PROCEDURE("82314000", "2.16.840.1.113883.6.96",
			"Rubella vaccination (procedure)", "Rubella vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tetanus vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	TETANUS_VACCINATION_PROCEDURE("127786006", "2.16.840.1.113883.6.96",
			"Tetanus vaccination (procedure)", "Tetanus vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tick-borne encephalitis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	TICK_BORNE_ENCEPHALITIS_VACCINATION_PROCEDURE("281658005", "2.16.840.1.113883.6.96",
			"Tick-borne encephalitis vaccination (procedure)",
			"Tick-borne encephalitis vaccination (procedure)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Typhoid vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	TYPHOID_VACCINATION_PROCEDURE("15483003", "2.16.840.1.113883.6.96",
			"Typhoid vaccination (procedure)", "Typhoid vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vaccination for human papillomavirus (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	VACCINATION_FOR_HUMAN_PAPILLOMAVIRUS_PROCEDURE("428570002", "2.16.840.1.113883.6.96",
			"Vaccination for human papillomavirus (procedure)",
			"Vaccination for human papillomavirus (procedure)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Varicella vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	VARICELLA_VACCINATION_PROCEDURE("68525005", "2.16.840.1.113883.6.96",
			"Varicella vaccination (procedure)", "Varicella vaccination (procedure)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Yellow fever vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	YELLOW_FEVER_VACCINATION_PROCEDURE("67308009", "2.16.840.1.113883.6.96",
			"Yellow fever vaccination (procedure)", "Yellow fever vaccination (procedure)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BCG vaccination</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BCG_VACCINATION_CODE = "42284007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diphtheria vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIPHTHERIA_VACCINATION_PROCEDURE_CODE = "76668005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Haemophilus influenzae type b vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINATION_PROCEDURE_CODE = "127787002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hepatitis A immunization (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEPATITIS_A_IMMUNIZATION_PROCEDURE_CODE = "243789007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hepatitis B vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEPATITIS_B_VACCINATION_PROCEDURE_CODE = "16584000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Influenza vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFLUENZA_VACCINATION_PROCEDURE_CODE = "86198006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Japanese encephalitis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JAPANESE_ENCEPHALITIS_VACCINATION_PROCEDURE_CODE = "314759000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Measles vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEASLES_VACCINATION_PROCEDURE_CODE = "47435007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Meningococcus vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MENINGOCOCCUS_VACCINATION_PROCEDURE_CODE = "41088001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mumps vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUMPS_VACCINATION_PROCEDURE_CODE = "50583002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pertussis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PERTUSSIS_VACCINATION_PROCEDURE_CODE = "39343008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pneumococcal vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PNEUMOCOCCAL_VACCINATION_PROCEDURE_CODE = "12866006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Poliomyelitis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POLIOMYELITIS_VACCINATION_PROCEDURE_CODE = "72093006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rabies vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RABIES_VACCINATION_PROCEDURE_CODE = "34631000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rubella vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RUBELLA_VACCINATION_PROCEDURE_CODE = "82314000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tetanus vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TETANUS_VACCINATION_PROCEDURE_CODE = "127786006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tick-borne encephalitis vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TICK_BORNE_ENCEPHALITIS_VACCINATION_PROCEDURE_CODE = "281658005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Typhoid vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TYPHOID_VACCINATION_PROCEDURE_CODE = "15483003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vaccination for human papillomavirus (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VACCINATION_FOR_HUMAN_PAPILLOMAVIRUS_PROCEDURE_CODE = "428570002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Varicella vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VARICELLA_VACCINATION_PROCEDURE_CODE = "68525005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Yellow fever vaccination (procedure)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String YELLOW_FEVER_VACCINATION_PROCEDURE_CODE = "67308009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.71";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "SwissVaccinationPlanImmunizations";

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
	public static SwissVaccinationPlanImmunizations getEnum(String code) {
		for (final SwissVaccinationPlanImmunizations x : values()) {
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
			Enum.valueOf(SwissVaccinationPlanImmunizations.class, enumName);
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
		for (final SwissVaccinationPlanImmunizations x : values()) {
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
	SwissVaccinationPlanImmunizations(String code, String codeSystem, String displayName,
			String displayNameEn, String displayNameDe, String displayNameFr,
			String displayNameIt) {
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
