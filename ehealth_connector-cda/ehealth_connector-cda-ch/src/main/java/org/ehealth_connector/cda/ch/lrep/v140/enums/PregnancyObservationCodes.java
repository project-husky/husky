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
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum PregnancyObservationCodes implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ABORTIONSINDUCED (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	ABORTIONSINDUCED_REPORTED("11613-7", "2.16.840.1.113883.6.1", "ABORTIONSINDUCED (REPORTED)",
			"ABORTIONSINDUCED (REPORTED)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ABORTIONSSPONTANEOUS(REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	ABORTIONSSPONTANEOUS_REPORTED("11614-5", "2.16.840.1.113883.6.1",
			"ABORTIONSSPONTANEOUS(REPORTED)", "ABORTIONSSPONTANEOUS(REPORTED)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ABORTIONS(REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	ABORTIONS_REPORTED("11612-9", "2.16.840.1.113883.6.1", "ABORTIONS(REPORTED)",
			"ABORTIONS(REPORTED)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BIRTHS LIVE (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	BIRTHS_LIVE_REPORTED("11636-8", "2.16.840.1.113883.6.1", "BIRTHS LIVE (REPORTED)",
			"BIRTHS LIVE (REPORTED)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Births.Preterm</div>
	 * <!-- @formatter:on -->
	 */
	BIRTHS_PRETERM("11637-6", "2.16.840.1.113883.6.1", "Births.Preterm", "Births.Preterm",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Births.stillborn</div>
	 * <!-- @formatter:on -->
	 */
	BIRTHS_STILLBORN("57062-2", "2.16.840.1.113883.6.1", "Births.stillborn", "Births.stillborn",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BIRTHS STILL LIVING (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	BIRTHS_STILL_LIVING_REPORTED("11638-4", "2.16.840.1.113883.6.1",
			"BIRTHS STILL LIVING (REPORTED)", "BIRTHS STILL LIVING (REPORTED)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Births.Term</div>
	 * <!-- @formatter:on -->
	 */
	BIRTHS_TERM("11639-2", "2.16.840.1.113883.6.1", "Births.Term", "Births.Term", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">BIRTHS TOTAL (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	BIRTHS_TOTAL_REPORTED("11640-0", "2.16.840.1.113883.6.1", "BIRTHS TOTAL (REPORTED)",
			"BIRTHS TOTAL (REPORTED)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Body weight at birth</div>
	 * <!-- @formatter:on -->
	 */
	BODY_WEIGHT_AT_BIRTH("8339-4", "2.16.840.1.113883.6.1", "Body weight at birth",
			"Body weight at birth", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DATE LAST MENSTRUAL PERIOD</div>
	 * <!-- @formatter:on -->
	 */
	DATE_LAST_MENSTRUAL_PERIOD("8665-2", "2.16.840.1.113883.6.1", "DATE LAST MENSTRUAL PERIOD",
			"DATE LAST MENSTRUAL PERIOD", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DELIVERY DATE (CLINICAL ESTIMATE)</div>
	 * <!-- @formatter:on -->
	 */
	DELIVERY_DATE_CLINICAL_ESTIMATE("11778-8", "2.16.840.1.113883.6.1",
			"DELIVERY DATE (CLINICAL ESTIMATE)", "DELIVERY DATE (CLINICAL ESTIMATE)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DELIVERY DATE (ESTIMATED FROM LAST MENSTRUAL PERIOD)</div>
	 * <!-- @formatter:on -->
	 */
	DELIVERY_DATE_ESTIMATED_FROM_LAST_MENSTRUAL_PERIOD("11779-6", "2.16.840.1.113883.6.1",
			"DELIVERY DATE (ESTIMATED FROM LAST MENSTRUAL PERIOD)",
			"DELIVERY DATE (ESTIMATED FROM LAST MENSTRUAL PERIOD)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DELIVERY DATE (ESTIMATED FROM OVULATION DATE)</div>
	 * <!-- @formatter:on -->
	 */
	DELIVERY_DATE_ESTIMATED_FROM_OVULATION_DATE("11780-4", "2.16.840.1.113883.6.1",
			"DELIVERY DATE (ESTIMATED FROM OVULATION DATE)",
			"DELIVERY DATE (ESTIMATED FROM OVULATION DATE)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Delivery risk</div>
	 * <!-- @formatter:on -->
	 */
	DELIVERY_RISK("42840-9", "2.16.840.1.113883.6.1", "Delivery risk", "Delivery risk",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">ECTOPIC PREGNANCY(REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	ECTOPIC_PREGNANCY_REPORTED("33065-4", "2.16.840.1.113883.6.1", "ECTOPIC PREGNANCY(REPORTED)",
			"ECTOPIC PREGNANCY(REPORTED)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FETUS, GESTATIONAL AGE (CLINICAL ESTIMATE)</div>
	 * <!-- @formatter:on -->
	 */
	FETUS_GESTATIONAL_AGE_CLINICAL_ESTIMATE("11884-4", "2.16.840.1.113883.6.1",
			"FETUS, GESTATIONAL AGE (CLINICAL ESTIMATE)",
			"FETUS, GESTATIONAL AGE (CLINICAL ESTIMATE)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FETUS, GESTATIONAL AGE (ESTIMATED FROM LAST MENSTRUAL PERIOD)</div>
	 * <!-- @formatter:on -->
	 */
	FETUS_GESTATIONAL_AGE_ESTIMATED_FROM_LAST_MENSTRUAL_PERIOD("11885-1", "2.16.840.1.113883.6.1",
			"FETUS, GESTATIONAL AGE (ESTIMATED FROM LAST MENSTRUAL PERIOD)",
			"FETUS, GESTATIONAL AGE (ESTIMATED FROM LAST MENSTRUAL PERIOD)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FETUS, GESTATIONAL AGE (ESTIMATED FROM OVULATION DATE)</div>
	 * <!-- @formatter:on -->
	 */
	FETUS_GESTATIONAL_AGE_ESTIMATED_FROM_OVULATION_DATE("11886-9", "2.16.840.1.113883.6.1",
			"FETUS, GESTATIONAL AGE (ESTIMATED FROM OVULATION DATE)",
			"FETUS, GESTATIONAL AGE (ESTIMATED FROM OVULATION DATE)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FETUS, GESTATIONAL AGE (ESTIMATED FROM SELECTED DELIVERY DATE)</div>
	 * <!-- @formatter:on -->
	 */
	FETUS_GESTATIONAL_AGE_ESTIMATED_FROM_SELECTED_DELIVERY_DATE("11887-7", "2.16.840.1.113883.6.1",
			"FETUS, GESTATIONAL AGE (ESTIMATED FROM SELECTED DELIVERY DATE)",
			"FETUS, GESTATIONAL AGE (ESTIMATED FROM SELECTED DELIVERY DATE)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gestational age</div>
	 * <!-- @formatter:on -->
	 */
	GESTATIONAL_AGE("49051-6", "2.16.840.1.113883.6.1", "Gestational age", "Gestational age",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Labor duration</div>
	 * <!-- @formatter:on -->
	 */
	LABOR_DURATION("32396-4", "2.16.840.1.113883.6.1", "Labor duration", "Labor duration",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Labor risk</div>
	 * <!-- @formatter:on -->
	 */
	LABOR_RISK("42839-1", "2.16.840.1.113883.6.1", "Labor risk", "Labor risk", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MENSTRUAL STATUS</div>
	 * <!-- @formatter:on -->
	 */
	MENSTRUAL_STATUS("8678-5", "2.16.840.1.113883.6.1", "MENSTRUAL STATUS", "MENSTRUAL STATUS",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Multiple pregnancy</div>
	 * <!-- @formatter:on -->
	 */
	MULTIPLE_PREGNANCY("45371-2", "2.16.840.1.113883.6.1", "Multiple pregnancy",
			"Multiple pregnancy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Place of service</div>
	 * <!-- @formatter:on -->
	 */
	PLACE_OF_SERVICE("52829-9", "2.16.840.1.113883.6.1", "Place of service", "Place of service",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pregnancies</div>
	 * <!-- @formatter:on -->
	 */
	PREGNANCIES("11996-6", "2.16.840.1.113883.6.1", "Pregnancies", "Pregnancies", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PREGNANCYSTATUS</div>
	 * <!-- @formatter:on -->
	 */
	PREGNANCYSTATUS("11449-6", "2.16.840.1.113883.6.1", "PREGNANCYSTATUS", "PREGNANCYSTATUS",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Procedure9</div>
	 * <!-- @formatter:on -->
	 */
	PROCEDURE9("29300-1", "2.16.840.1.113883.6.1", "Procedure9", "Procedure9", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Surgical operation note anesthesia</div>
	 * <!-- @formatter:on -->
	 */
	SURGICAL_OPERATION_NOTE_ANESTHESIA("8722-1", "2.16.840.1.113883.6.1",
			"Surgical operation note anesthesia", "Surgical operation note anesthesia",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ABORTIONSINDUCED (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ABORTIONSINDUCED_REPORTED_CODE = "11613-7";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ABORTIONSSPONTANEOUS(REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ABORTIONSSPONTANEOUS_REPORTED_CODE = "11614-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ABORTIONS(REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ABORTIONS_REPORTED_CODE = "11612-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BIRTHS LIVE (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIRTHS_LIVE_REPORTED_CODE = "11636-8";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Births.Preterm</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIRTHS_PRETERM_CODE = "11637-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Births.stillborn</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIRTHS_STILLBORN_CODE = "57062-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BIRTHS STILL LIVING (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIRTHS_STILL_LIVING_REPORTED_CODE = "11638-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Births.Term</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIRTHS_TERM_CODE = "11639-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for BIRTHS TOTAL (REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIRTHS_TOTAL_REPORTED_CODE = "11640-0";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Body weight at birth</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BODY_WEIGHT_AT_BIRTH_CODE = "8339-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DATE LAST MENSTRUAL PERIOD</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DATE_LAST_MENSTRUAL_PERIOD_CODE = "8665-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DELIVERY DATE (CLINICAL ESTIMATE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DELIVERY_DATE_CLINICAL_ESTIMATE_CODE = "11778-8";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DELIVERY DATE (ESTIMATED FROM LAST MENSTRUAL PERIOD)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DELIVERY_DATE_ESTIMATED_FROM_LAST_MENSTRUAL_PERIOD_CODE = "11779-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DELIVERY DATE (ESTIMATED FROM OVULATION DATE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DELIVERY_DATE_ESTIMATED_FROM_OVULATION_DATE_CODE = "11780-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Delivery risk</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DELIVERY_RISK_CODE = "42840-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for ECTOPIC PREGNANCY(REPORTED)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ECTOPIC_PREGNANCY_REPORTED_CODE = "33065-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FETUS, GESTATIONAL AGE (CLINICAL ESTIMATE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FETUS_GESTATIONAL_AGE_CLINICAL_ESTIMATE_CODE = "11884-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FETUS, GESTATIONAL AGE (ESTIMATED FROM LAST MENSTRUAL PERIOD)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FETUS_GESTATIONAL_AGE_ESTIMATED_FROM_LAST_MENSTRUAL_PERIOD_CODE = "11885-1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FETUS, GESTATIONAL AGE (ESTIMATED FROM OVULATION DATE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FETUS_GESTATIONAL_AGE_ESTIMATED_FROM_OVULATION_DATE_CODE = "11886-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FETUS, GESTATIONAL AGE (ESTIMATED FROM SELECTED DELIVERY DATE)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FETUS_GESTATIONAL_AGE_ESTIMATED_FROM_SELECTED_DELIVERY_DATE_CODE = "11887-7";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gestational age</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GESTATIONAL_AGE_CODE = "49051-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Labor duration</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABOR_DURATION_CODE = "32396-4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Labor risk</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABOR_RISK_CODE = "42839-1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MENSTRUAL STATUS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MENSTRUAL_STATUS_CODE = "8678-5";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Multiple pregnancy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MULTIPLE_PREGNANCY_CODE = "45371-2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Place of service</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLACE_OF_SERVICE_CODE = "52829-9";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pregnancies</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREGNANCIES_CODE = "11996-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PREGNANCYSTATUS</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREGNANCYSTATUS_CODE = "11449-6";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Procedure9</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROCEDURE9_CODE = "29300-1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Surgical operation note anesthesia</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SURGICAL_OPERATION_NOTE_ANESTHESIA_CODE = "8722-1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.78";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "PregnancyObservationCodes";

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
	public static PregnancyObservationCodes getEnum(String code) {
		for (final PregnancyObservationCodes x : values()) {
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
			Enum.valueOf(PregnancyObservationCodes.class, enumName);
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
		for (final PregnancyObservationCodes x : values()) {
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
	PregnancyObservationCodes(String code, String codeSystem, String displayName,
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
