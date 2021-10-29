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

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of CH-EMED-TimingEvent values
 *
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.756.5.30.1.127.77.4.11.2
 * Effective date: 2020-07-10 00:28
 * Version: 2020
 * Status: DRAFT
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-05")
public enum ChEmedTimingEvent implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After breakfast</div>
	 * <div class="de">Nach dem Frühstück</div>
	 * <div class="fr">Après le petit-déjeuner</div>
	 * <div class="it">Dopo la prima colazione</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_BREAKFAST_L1("PCM", "2.16.840.1.113883.5.139", "After breakfast", "After breakfast",
			"Nach dem Frühstück", "Après le petit-déjeuner", "Dopo la prima colazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After dinner</div>
	 * <div class="de">Nach dem Abendessen</div>
	 * <div class="fr">Après le repas du soir</div>
	 * <div class="it">Dopo cena</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_DINNER_L1("PCV", "2.16.840.1.113883.5.139", "After dinner", "After dinner",
			"Nach dem Abendessen", "Après le repas du soir", "Dopo cena"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After lunch</div>
	 * <div class="de">Nach dem Mittagessen</div>
	 * <div class="fr">Après le repas de midi</div>
	 * <div class="it">Dopo pranzo</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_LUNCH_L1("PCD", "2.16.840.1.113883.5.139", "After lunch", "After lunch",
			"Nach dem Mittagessen", "Après le repas de midi", "Dopo pranzo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">After the meal</div>
	 * <div class="de">Nach dem Essen</div>
	 * <div class="fr">Après le repas</div>
	 * <div class="it">Dopo il pasto</div>
	 * <!-- @formatter:on -->
	 */
	AFTER_THE_MEAL_L1("PC", "2.16.840.1.113883.5.139", "After the meal", "After the meal",
			"Nach dem Essen", "Après le repas", "Dopo il pasto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before breakfast</div>
	 * <div class="de">Vor dem Frühstück</div>
	 * <div class="fr">Avant le petit-déjeuner</div>
	 * <div class="it">Prima di colazione</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_BREAKFAST_L1("ACM", "2.16.840.1.113883.5.139", "Before breakfast", "Before breakfast",
			"Vor dem Frühstück", "Avant le petit-déjeuner", "Prima di colazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before dinner</div>
	 * <div class="de">Vor dem Abendessen</div>
	 * <div class="fr">Avant le repas du soir</div>
	 * <div class="it">Prima di cena</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_DINNER_L1("ACV", "2.16.840.1.113883.5.139", "Before dinner", "Before dinner",
			"Vor dem Abendessen", "Avant le repas du soir", "Prima di cena"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before lunch</div>
	 * <div class="de">Vor dem Mittagessen</div>
	 * <div class="fr">Avant le repas de midi</div>
	 * <div class="it">Prima di pranzo</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_LUNCH_L1("ACD", "2.16.840.1.113883.5.139", "Before lunch", "Before lunch",
			"Vor dem Mittagessen", "Avant le repas de midi", "Prima di pranzo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before sleep</div>
	 * <div class="de">Vor dem Schlafengehen</div>
	 * <div class="fr">Avant le coucher</div>
	 * <div class="it">Prima di andare a dormire</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_SLEEP_L1("HS", "2.16.840.1.113883.5.139", "Before sleep", "Before sleep",
			"Vor dem Schlafengehen", "Avant le coucher", "Prima di andare a dormire"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Before the meal</div>
	 * <div class="de">Vor der Mahlzeit</div>
	 * <div class="fr">Avant le repas</div>
	 * <div class="it">Prima del pasto</div>
	 * <!-- @formatter:on -->
	 */
	BEFORE_THE_MEAL_L1("AC", "2.16.840.1.113883.5.139", "Before the meal", "Before the meal",
			"Vor der Mahlzeit", "Avant le repas", "Prima del pasto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between breakfast and lunch</div>
	 * <div class="de">Zwischen Frühstück und Mittagessen</div>
	 * <div class="fr">Entre le petit-déjeuner et le repas de midi</div>
	 * <div class="it">Tra colazione e pranzo</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_BREAKFAST_AND_LUNCH_L1("ICM", "2.16.840.1.113883.5.139", "Between breakfast and lunch",
			"Between breakfast and lunch", "Zwischen Frühstück und Mittagessen",
			"Entre le petit-déjeuner et le repas de midi", "Tra colazione e pranzo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between dinner and bedtime</div>
	 * <div class="de">Zwischen Abendessen und Schlafenszeit</div>
	 * <div class="fr">Entre le repas du soir et le coucher</div>
	 * <div class="it">Tra la cena e l'ora di andare a letto</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_DINNER_AND_BEDTIME_L1("ICV", "2.16.840.1.113883.5.139", "Between dinner and bedtime",
			"Between dinner and bedtime", "Zwischen Abendessen und Schlafenszeit",
			"Entre le repas du soir et le coucher", "Tra la cena e l'ora di andare a letto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between lunch and dinner</div>
	 * <div class="de">Zwischen Mittag- und Abendessen</div>
	 * <div class="fr">Entre le repas de midi et du soir</div>
	 * <div class="it">Tra pranzo e cena</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_LUNCH_AND_DINNER_L1("ICD", "2.16.840.1.113883.5.139", "Between lunch and dinner",
			"Between lunch and dinner", "Zwischen Mittag- und Abendessen",
			"Entre le repas de midi et du soir", "Tra pranzo e cena"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Between meals</div>
	 * <div class="de">Zwischen den Mahlzeiten</div>
	 * <div class="fr">Entre les repas</div>
	 * <div class="it">Tra un pasto e l'altro</div>
	 * <!-- @formatter:on -->
	 */
	BETWEEN_MEALS_L1("IC", "2.16.840.1.113883.5.139", "Between meals", "Between meals",
			"Zwischen den Mahlzeiten", "Entre les repas", "Tra un pasto e l'altro"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">During breakfast</div>
	 * <div class="de">Während des Frühstücks</div>
	 * <div class="fr">Pendant le petit-déjeuner</div>
	 * <div class="it">Durante la prima colazione</div>
	 * <!-- @formatter:on -->
	 */
	DURING_BREAKFAST_L2("CM", "2.16.840.1.113883.5.139", "During breakfast", "During breakfast",
			"Während des Frühstücks", "Pendant le petit-déjeuner",
			"Durante la prima colazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">During dinner</div>
	 * <div class="de">Während des Abendessens</div>
	 * <div class="fr">Pendant le repas du soir</div>
	 * <div class="it">Durante la cena</div>
	 * <!-- @formatter:on -->
	 */
	DURING_DINNER_L2("CV", "2.16.840.1.113883.5.139", "During dinner", "During dinner",
			"Während des Abendessens", "Pendant le repas du soir", "Durante la cena"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">During lunch</div>
	 * <div class="de">Während des Mittagessens</div>
	 * <div class="fr">Pendant le repas de midi</div>
	 * <div class="it">Durante il pranzo</div>
	 * <!-- @formatter:on -->
	 */
	DURING_LUNCH_L2("CD", "2.16.840.1.113883.5.139", "During lunch", "During lunch",
			"Während des Mittagessens", "Pendant le repas de midi", "Durante il pranzo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">During meals</div>
	 * <div class="de">Während der Mahlzeit</div>
	 * <div class="fr">Pendant le repas</div>
	 * <div class="it">Durante il pasto</div>
	 * <!-- @formatter:on -->
	 */
	DURING_MEALS_L1("C", "2.16.840.1.113883.5.139", "During meals", "During meals",
			"Während der Mahlzeit", "Pendant le repas", "Durante il pasto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Upon waking up</div>
	 * <div class="de">Beim Aufwachen</div>
	 * <div class="fr">Au réveil</div>
	 * <div class="it">Al risveglio</div>
	 * <!-- @formatter:on -->
	 */
	UPON_WAKING_UP_L1("WAKE", "2.16.840.1.113883.5.139", "Upon waking up", "Upon waking up",
			"Beim Aufwachen", "Au réveil", "Al risveglio");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After breakfast</div>
	 * <div class="de">Code für Nach dem Frühstück</div>
	 * <div class="fr">Code de Après le petit-déjeuner</div>
	 * <div class="it">Code per Dopo la prima colazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_BREAKFAST_L1_CODE = "PCM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After dinner</div>
	 * <div class="de">Code für Nach dem Abendessen</div>
	 * <div class="fr">Code de Après le repas du soir</div>
	 * <div class="it">Code per Dopo cena</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_DINNER_L1_CODE = "PCV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After lunch</div>
	 * <div class="de">Code für Nach dem Mittagessen</div>
	 * <div class="fr">Code de Après le repas de midi</div>
	 * <div class="it">Code per Dopo pranzo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_LUNCH_L1_CODE = "PCD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for After the meal</div>
	 * <div class="de">Code für Nach dem Essen</div>
	 * <div class="fr">Code de Après le repas</div>
	 * <div class="it">Code per Dopo il pasto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AFTER_THE_MEAL_L1_CODE = "PC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before breakfast</div>
	 * <div class="de">Code für Vor dem Frühstück</div>
	 * <div class="fr">Code de Avant le petit-déjeuner</div>
	 * <div class="it">Code per Prima di colazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_BREAKFAST_L1_CODE = "ACM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before dinner</div>
	 * <div class="de">Code für Vor dem Abendessen</div>
	 * <div class="fr">Code de Avant le repas du soir</div>
	 * <div class="it">Code per Prima di cena</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_DINNER_L1_CODE = "ACV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before lunch</div>
	 * <div class="de">Code für Vor dem Mittagessen</div>
	 * <div class="fr">Code de Avant le repas de midi</div>
	 * <div class="it">Code per Prima di pranzo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_LUNCH_L1_CODE = "ACD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before sleep</div>
	 * <div class="de">Code für Vor dem Schlafengehen</div>
	 * <div class="fr">Code de Avant le coucher</div>
	 * <div class="it">Code per Prima di andare a dormire</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_SLEEP_L1_CODE = "HS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Before the meal</div>
	 * <div class="de">Code für Vor der Mahlzeit</div>
	 * <div class="fr">Code de Avant le repas</div>
	 * <div class="it">Code per Prima del pasto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BEFORE_THE_MEAL_L1_CODE = "AC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between breakfast and lunch</div>
	 * <div class="de">Code für Zwischen Frühstück und Mittagessen</div>
	 * <div class="fr">Code de Entre le petit-déjeuner et le repas de midi</div>
	 * <div class="it">Code per Tra colazione e pranzo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_BREAKFAST_AND_LUNCH_L1_CODE = "ICM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between dinner and bedtime</div>
	 * <div class="de">Code für Zwischen Abendessen und Schlafenszeit</div>
	 * <div class="fr">Code de Entre le repas du soir et le coucher</div>
	 * <div class="it">Code per Tra la cena e l'ora di andare a letto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_DINNER_AND_BEDTIME_L1_CODE = "ICV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between lunch and dinner</div>
	 * <div class="de">Code für Zwischen Mittag- und Abendessen</div>
	 * <div class="fr">Code de Entre le repas de midi et du soir</div>
	 * <div class="it">Code per Tra pranzo e cena</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_LUNCH_AND_DINNER_L1_CODE = "ICD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Between meals</div>
	 * <div class="de">Code für Zwischen den Mahlzeiten</div>
	 * <div class="fr">Code de Entre les repas</div>
	 * <div class="it">Code per Tra un pasto e l'altro</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BETWEEN_MEALS_L1_CODE = "IC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for During breakfast</div>
	 * <div class="de">Code für Während des Frühstücks</div>
	 * <div class="fr">Code de Pendant le petit-déjeuner</div>
	 * <div class="it">Code per Durante la prima colazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DURING_BREAKFAST_L2_CODE = "CM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for During dinner</div>
	 * <div class="de">Code für Während des Abendessens</div>
	 * <div class="fr">Code de Pendant le repas du soir</div>
	 * <div class="it">Code per Durante la cena</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DURING_DINNER_L2_CODE = "CV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for During lunch</div>
	 * <div class="de">Code für Während des Mittagessens</div>
	 * <div class="fr">Code de Pendant le repas de midi</div>
	 * <div class="it">Code per Durante il pranzo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DURING_LUNCH_L2_CODE = "CD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for During meals</div>
	 * <div class="de">Code für Während der Mahlzeit</div>
	 * <div class="fr">Code de Pendant le repas</div>
	 * <div class="it">Code per Durante il pasto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DURING_MEALS_L1_CODE = "C";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Upon waking up</div>
	 * <div class="de">Code für Beim Aufwachen</div>
	 * <div class="fr">Code de Au réveil</div>
	 * <div class="it">Code per Al risveglio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UPON_WAKING_UP_L1_CODE = "WAKE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
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
	public static ChEmedTimingEvent getEnum(final String code) {
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
			Enum.valueOf(ChEmedTimingEvent.class, enumName);
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
	ChEmedTimingEvent(final String code, final String codeSystem, final String displayName,
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
