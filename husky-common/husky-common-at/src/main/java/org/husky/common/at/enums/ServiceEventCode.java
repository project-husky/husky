/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.at.enums;

import java.util.HashMap;
import java.util.Map;

public enum ServiceEventCode implements ValueSetEnumInterfaceAt {

	HEALTH_INSURANCE_PRESCRIPTION("KASSEN", "1.2.40.0.10.1.4.3.4.3.3", "Kassenrezept",
			"Kassenrezept"),

	PRIVATE_PRESCRIPTION("PRIVAT", "1.2.40.0.10.1.4.3.4.3.3", "Privatrezept", "Privatrezept"),

	SUBSTITUTION_PRESCRIPTION("SUBST", "1.2.40.0.10.1.4.3.4.3.3", "Substitutionsrezept",
			"Substitutionsrezept"),

	SERVICE_IN_PATIENT_STAY("GDLSTATAUF", "1.2.40.0.34.5.21",
			"Gesundheitsdienstleistung im Rahmen eines stationären Aufenthalts",
			"Gesundheitsdienstleistung im Rahmen eines stationären Aufenthalts"),

	HEALTH_SERVICE_CARE("GDLPUB", "1.2.40.0.34.5.21",
			"Gesundheitsdienstleistung Pflege und Betreuung",
			"Gesundheitsdienstleistung Pflege und Betreuung"),

	BLOOD_GROUP_SEROLOGY("100", "1.2.40.0.34.5.11", "Blutgruppenserologie", "Blutgruppenserologie"),

	BLOOD_GAS_STUDIES("200", "1.2.40.0.34.5.11", "Blutgasanalytik", "Blutgasanalytik"),

	HEMATOLOGY_STUDIES("300", "1.2.40.0.34.5.11", "Hämatologie", "Hämatologie"),

	COAGULATION_STUDIES("400", "1.2.40.0.34.5.11", "Gerinnung/Hämostaseologie",
			"Gerinnung/Hämostaseologie"),

	CHEMISTRY_STUDIES("500", "1.2.40.0.34.5.11", "Klinische Chemie/Proteindiagnostik",
			"Klinische Chemie/Proteindiagnostik"),

	HORMONES_VITAMINS_TUMOURMARKER("600", "1.2.40.0.34.5.11", "Hormone/Vitamine/Tumormarker",
			"Hormone/Vitamine/Tumormarker"),

	TOXICOLOGY_STUDIES("900", "1.2.40.0.34.5.11", "Toxikologie", "Toxikologie"),

	THERAPEUTIC_DRUG_MONITORING_STUDIES("1000", "1.2.40.0.34.5.11", "Medikamente", "Medikamente"),

	INFECTIOUS_DISEASE_STUDIES("1100", "1.2.40.0.34.5.11", "Infektionsdiagnostik",
			"Infektionsdiagnostik"),

	AUTOIMMUNE_STUDIES("1300", "1.2.40.0.34.5.11", "Autoimmundiagnostik", "Autoimmundiagnostik"),

	ALLERGY_STUDIES("1800", "1.2.40.0.34.5.11", "Allergiediagnostik", "Allergiediagnostik"),

	URINALYSIS_STUDIES("1400", "1.2.40.0.34.5.11", "Urindiagnostik", "Urindiagnostik"),

	STOOL_STUDIES("1500", "1.2.40.0.34.5.11", "Stuhldiagnostik", "Stuhldiagnostik"),

	LIQUOR_STUDIES("1600", "1.2.40.0.34.5.11", "Liquordiagnostik", "Liquordiagnostik"),

	GENETIC_STUDIES("2300", "1.2.40.0.34.5.11", "Genetische Diagnostik", "Genetische Diagnostik"),

	OTHER_STUDIES("2500", "1.2.40.0.34.5.11", "Sonstige", "Sonstige"),

	MICROBIOLOGY_STUDIES("18725-2", "2.16.840.1.113883.6.1", "Microbiology studies",
			"Microbiology studies (set)");

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ServiceEventCode getEnum(String code) {
		for (final ServiceEventCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
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
			Enum.valueOf(ClassCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ServiceEventCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instanziiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
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
	ServiceEventCode(String code, String codeSystem, String displayName, String displayNameDe) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.GERMAN_AT, displayNameDe);
	}

	/**
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */

	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * den Code System Namen.</div>
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
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */

	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is
	 * returned.</div> <div class="de">Liefert display name gemäss Parameter,
	 * falls es keine Englische Übersetzung gibt, wird der default-Name
	 * zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayNameAt(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 *
	 * @return <div class="en">the value set identifier</div>
	 */

	@Override
	public String getValueSetId() {
		return null;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */

	@Override
	public String getValueSetName() {
		return null;
	}

}
