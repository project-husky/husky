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
package org.ehealth_connector.cda.ch.lrep.v140.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Laboratory Specialties.<br/>Notes:<ul>    <li>Note 1:26436-6 (LABORATORY STUDIES) enables issuing a report putting together observations from multiple specialties (disciplines) in the same text block, allowing delivery of a global interpretation comment at the end of the text block that will be rendered at the end of the report.</li>    <li>Note 2:18721-1 (THERAPEUTIC DRUG MONITORING STUDIES) will be used for a section carrying pharmacology observations on a patient.</li>    <li>Note 3:Mycology and parasitology, as well as bacteriology, are part of the 18725-2 (MICROBIOLOGY STUDIES) specialty.</li>    <li>Note 4:Virology MAY be included in 18725-2 (MICROBIOLOGY STUDIES) specialty or 18727-8 (SEROLOGY STUDIES) or split between both specialties, depending upon the Content Creator Actor’s choice.</li></ul></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum LaboratorySpecialties implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BLOOD BANK STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	BLOOD_BANK_STUDIES("18717-9", "2.16.840.1.113883.6.1", "BLOOD BANK STUDIES",
			"BLOOD BANK STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BLOOD GAS STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	BLOOD_GAS_STUDIES("18767-4", "2.16.840.1.113883.6.1", "BLOOD GAS STUDIES", "BLOOD GAS STUDIES",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CELL COUNTS+DIFFERENTIAL STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	CELL_COUNTS_DIFFERENTIAL_STUDIES("18768-2", "2.16.840.1.113883.6.1",
			"CELL COUNTS+DIFFERENTIAL STUDIES", "CELL COUNTS+DIFFERENTIAL STUDIES", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CELL MARKER STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	CELL_MARKER_STUDIES("18718-7", "2.16.840.1.113883.6.1", "CELL MARKER STUDIES",
			"CELL MARKER STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CHEMISTRY CHALLENGE STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	CHEMISTRY_CHALLENGE_STUDIES("26437-4", "2.16.840.1.113883.6.1", "CHEMISTRY CHALLENGE STUDIES",
			"CHEMISTRY CHALLENGE STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CHEMISTRY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	CHEMISTRY_STUDIES("18719-5", "2.16.840.1.113883.6.1", "CHEMISTRY STUDIES", "CHEMISTRY STUDIES",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">COAGULATION STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	COAGULATION_STUDIES("18720-3", "2.16.840.1.113883.6.1", "COAGULATION STUDIES",
			"COAGULATION STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CYTOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	CYTOLOGY_STUDIES("26438-2", "2.16.840.1.113883.6.1", "CYTOLOGY STUDIES", "CYTOLOGY STUDIES",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FERTILITY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	FERTILITY_STUDIES("18722-9", "2.16.840.1.113883.6.1", "FERTILITY STUDIES", "FERTILITY STUDIES",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">HEMATOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	HEMATOLOGY_STUDIES("18723-7", "2.16.840.1.113883.6.1", "HEMATOLOGY STUDIES",
			"HEMATOLOGY STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">HLA STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	HLA_STUDIES("18724-5", "2.16.840.1.113883.6.1", "HLA STUDIES", "HLA STUDIES", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">LABORATORY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	LABORATORY_STUDIES("26436-6", "2.16.840.1.113883.6.1", "LABORATORY STUDIES",
			"LABORATORY STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MICROBIAL SUSCEPTIBILITY TESTS</div>
	 * <!-- @formatter:on -->
	 */
	MICROBIAL_SUSCEPTIBILITY_TESTS("18769-0", "2.16.840.1.113883.6.1",
			"MICROBIAL SUSCEPTIBILITY TESTS", "MICROBIAL SUSCEPTIBILITY TESTS", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MICROBIOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	MICROBIOLOGY_STUDIES("18725-2", "2.16.840.1.113883.6.1", "MICROBIOLOGY STUDIES",
			"MICROBIOLOGY STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MOLECULAR PATHOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	MOLECULAR_PATHOLOGY_STUDIES("26435-8", "2.16.840.1.113883.6.1", "MOLECULAR PATHOLOGY STUDIES",
			"MOLECULAR PATHOLOGY STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">SEROLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	SEROLOGY_STUDIES("18727-8", "2.16.840.1.113883.6.1", "SEROLOGY STUDIES", "SEROLOGY STUDIES",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">THERAPEUTIC DRUG MONITORING STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_DRUG_MONITORING_STUDIES("18721-1", "2.16.840.1.113883.6.1",
			"THERAPEUTIC DRUG MONITORING STUDIES", "THERAPEUTIC DRUG MONITORING STUDIES",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TOXICOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	TOXICOLOGY_STUDIES("18728-6", "2.16.840.1.113883.6.1", "TOXICOLOGY STUDIES",
			"TOXICOLOGY STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">URINALYSIS STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	URINALYSIS_STUDIES("18729-4", "2.16.840.1.113883.6.1", "URINALYSIS STUDIES",
			"URINALYSIS STUDIES", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BLOOD BANK STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BLOOD_BANK_STUDIES_CODE = "18717-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BLOOD GAS STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BLOOD_GAS_STUDIES_CODE = "18767-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CELL COUNTS+DIFFERENTIAL STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CELL_COUNTS_DIFFERENTIAL_STUDIES_CODE = "18768-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CELL MARKER STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CELL_MARKER_STUDIES_CODE = "18718-7";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CHEMISTRY CHALLENGE STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEMISTRY_CHALLENGE_STUDIES_CODE = "26437-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CHEMISTRY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEMISTRY_STUDIES_CODE = "18719-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for COAGULATION STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COAGULATION_STUDIES_CODE = "18720-3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CYTOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CYTOLOGY_STUDIES_CODE = "26438-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FERTILITY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FERTILITY_STUDIES_CODE = "18722-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for HEMATOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMATOLOGY_STUDIES_CODE = "18723-7";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for HLA STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HLA_STUDIES_CODE = "18724-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for LABORATORY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORATORY_STUDIES_CODE = "26436-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MICROBIAL SUSCEPTIBILITY TESTS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MICROBIAL_SUSCEPTIBILITY_TESTS_CODE = "18769-0";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MICROBIOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MICROBIOLOGY_STUDIES_CODE = "18725-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MOLECULAR PATHOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOLECULAR_PATHOLOGY_STUDIES_CODE = "26435-8";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for SEROLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SEROLOGY_STUDIES_CODE = "18727-8";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for THERAPEUTIC DRUG MONITORING STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_DRUG_MONITORING_STUDIES_CODE = "18721-1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TOXICOLOGY STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TOXICOLOGY_STUDIES_CODE = "18728-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for URINALYSIS STUDIES</div>
	 * <!-- @formatter:on -->
	 */
	public static final String URINALYSIS_STUDIES_CODE = "18729-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "1.3.6.1.4.1.19376.1.3.11.1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "LaboratorySpecialties";

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
	public static LaboratorySpecialties getEnum(String code) {
		for (final LaboratorySpecialties x : values()) {
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
			Enum.valueOf(LaboratorySpecialties.class, enumName);
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
		for (final LaboratorySpecialties x : values()) {
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
	LaboratorySpecialties(String code, String codeSystem, String displayName, String displayNameEn,
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
