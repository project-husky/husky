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
package org.ehealth_connector.cda.ch.enums;

import org.ehealth_connector.common.enums.LanguageCode;

import java.util.HashMap;
import java.util.Map;

/**
 * <div class="en">Unit of times used in emed</div>
 */
public enum UnitsOfTime {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">day</div>
	 * <div class="de">Tag</div>
	 * <div class="fr">jour</div>
	 * <div class="it">giorno</div>
	 * <!-- @formatter:on -->
	 */
	DAY("d", 3, "Day", "day(s)", "Tag(e)", "jour(s)", "giorno(i)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hour</div>
	 * <div class="de">Stunde</div>
	 * <div class="fr">heure</div>
	 * <div class="it">ora</div>
	 * <!-- @formatter:on -->
	 */
	HOUR("h", 2, "Hour", "hour(s)", "Stunde(n)", "heure(s)", "ora(e)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Minute</div>
	 * <div class="de">Minute</div>
	 * <div class="fr">minute</div>
	 * <div class="it">minuto</div>
	 * <!-- @formatter:on -->
	 */
	MINUTE("min", 1, "Minute", "minute(s)", "Minute(n)", "minute(s)", "minuto(i)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">month</div>
	 * <div class="de">Monat</div>
	 * <div class="fr">mois</div>
	 * <div class="it">mese</div>
	 * <!-- @formatter:on -->
	 */
	MONTH("mo", 5, "Month", "month(s)", "Monat(e)", "mois", "mese(i)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Second</div>
	 * <div class="de">Sekunde</div>
	 * <div class="fr">seconde</div>
	 * <div class="it">secondo</div>
	 * <!-- @formatter:on -->
	 */
	SECOND("s", 0, "Second", "second(s)", "Sekunde(n)", "seconde(s)", "secondo(i)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">week</div>
	 * <div class="de">Woche</div>
	 * <div class="fr">semaine</div>
	 * <div class="it">settimana</div>
	 * <!-- @formatter:on -->
	 */
	WEEK("wk", 4, "Week", "week(s)", "Woche(n)", "semaine(s)", "settimana(e)"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">year</div>
	 * <div class="de">Jahr</div>
	 * <div class="fr">année</div>
	 * <div class="it">anno</div>
	 * <!-- @formatter:on -->
	 */
	YEAR("a", 6, "Year", "year(s)", "Jahr(e)", "année(s)", "anno(i)");

	/**
	 * <div class="en">get an unit time by its code</div>
	 * 
	 * @param code
	 *            code of the unit of time
	 * @return the UnitOfTime
	 */
	public static UnitsOfTime getEnum(String code) {
		for (final UnitsOfTime x : values()) {
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
			Enum.valueOf(UnitsOfTime.class, enumName);
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
		for (final UnitsOfTime x : values()) {
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
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <!-- @formatter:on -->
	 */
	private int pos;

	/**
	 * List of unit time ordered
	 */
	String[] unitsOfTimeOrdered = new String[] { "s", "min", "h", "d", "wk", "mo", "a" };

	/**
	 * list of value of unit time sorted, each value represent one unit of the
	 * next unit in the table ex : 60s = 1m / 60min=1h / 24h = 1d
	 */
	Integer[] unitsOfTimeOrderedTime = new Integer[] { 60, 60, 24, 7, 4, 12, 1 };

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param pos
	 *            position in array
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
	UnitsOfTime(String code, int pos, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.pos = pos;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */

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

	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <div class="en">get the next unit time</div>
	 * 
	 * @return the next unit time of the curent value
	 */
	public UnitsOfTime getNext() {
		int nextPos = this.pos + 1;
		if (nextPos >= unitsOfTimeOrdered.length)
			return null;
		return getEnum(unitsOfTimeOrdered[nextPos]);
	}

	/**
	 * <div class="en"> Get the next unit time "timed"</div>
	 * 
	 * @return the next unit time "timed"
	 */
	public Integer getUnitTimed() {
		return this.unitsOfTimeOrderedTime[this.pos];
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	public String toString() {
		return getCodeValue();
	}

}