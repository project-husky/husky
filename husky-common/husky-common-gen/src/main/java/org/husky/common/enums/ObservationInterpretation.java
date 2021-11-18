/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.husky.common.enums;

import java.util.HashMap;
import java.util.Map;

import org.husky.common.hl7cdar2.CE;
import org.husky.common.model.Code;

/**
 * <div class="en">The Enum containing the supported ObservationInterpretation
 * codes.</div> <div class="de">Codesystem: HL7 ObservationInterpretation (OID:
 * 2.16.840.1.113883.5.83).</div> <div class="fr">Domaine de valeurs pour « Code
 * dinterprétation »</div>
 */
public enum ObservationInterpretation {

	//@formatter:off
	/**
	 * <div class="en">Abnormal</div>
	 * <div class="de">Anormal</div>
	 * <div class="fr">Anormalement</div>
	 * <div class="it">Anormalmente</div>
	 * */
	ABNORMAL("A", "Abnormal", "Anormal", "Anormalement", "Anormalmente"),

	/**
	 * <div class="en">Abnormal alert</div>
	 * <div class="de">Anormal alarmierend</div>
	 * <div class="fr">Alerte anormale</div>
	 * <div class="it">Allarme anomalo</div>
	 * */
	ABNORMAL_ALERT("AA", "Abnormal alert", "Anormal alarmierend", "Alerte anormale", "Avviso anomalo"),

	/**
	 * <div class="en">High</div>
	 * <div class="de">Hoch</div>
	 * <div class="fr">Haut</div>
	 * <div class="it">Alto</div>
	 * */
	HIGH("H", "High", "Hoch", "Haut", "Alto"),

	/**
	 * <div class="en">High alert</div>
	 * <div class="de">Hoch alarmierend</div>
	 * <div class="fr">Alerte haut</div>
	 * <div class="it">Allarme alto</div>
	 * */
	HIGH_ALERT("HH", "High alert", "Hoch alarmierend", "Alerte haut", "Allarme alto"),

	/**
	 * <div class="en">Low</div>
	 * <div class="de">Tief</div>
	 * <div class="fr">Bas</div>
	 * <div class="it">Basso</div>
	 * */
	LOW("L", "Low", "Tief", "Bas", "Basso"),

	/**
	 * <div class="en">Low alert</div>
	 * <div class="de">Tief alarmierend</div>
	 * <div class="fr">Alerte bas</div>
	 * <div class="it">Allarme basso</div>
	 * */
	LOW_ALERT("LL", "Low alert", "Tief alarmierend", "Alerte bas", "Allarme basso"),

	/**
	 * <div class="en">Normal</div>
	 * <div class="de">Normal</div>
	 * <div class="fr">Normal</div>
	 * <div class="it">Normale</div>
	 * */
	NORMAL("N",	"Normal", "Normal", "Normal", "Normale"),

	/**
	 * <div class="en">Positive</div>
	 * <div class="de">Positiv</div>
	 * <div class="fr">Positif</div>
	 * <div class="it">Positivo</div>
	 * */
	POS("POS", "Positive", "Positiv", "Positif", "Positivo"),

	/**
	 * <div class="en">Negative</div>
	 * <div class="de">Negativ</div>
	 * <div class="fr">Négatif</div>
	 * <div class="it">Negativo</div>
	 * */
	NEG("NEG", "Negative", "Negativ", "Négatif", "Negativo"),

	/**
	 * <div class="en">Susceptible</div>
	 * <div class="de">Sensibel</div>
	 * <div class="fr">Sensible</div>
	 * <div class="it">Sensitivo</div>
	 * */
	SUSCEPTIBLE("S", "Susceptible", "Sensibel", "Sensible", "Sensitivo"),

	/**
	 * <div class="en">Susceptible-dose dependent</div>
	 * <div class="de">Sensibel (dosierungsabhängig)</div>
	 * <div class="fr">Sensible (en fonction du dosage)</div>
	 * <div class="it">Sensitivo (dose-dipendente)</div>
	 * */
	SUSCEPTIBLE_DOSE_DEPENDENT("SDD", "Susceptible-dose dependent", "Sensibel", "Sensibel (dosierungsabhängig)", "Sensitivo (dose-dipendente)"),

	/**
	 * <div class="en">Resistant</div>
	 * <div class="de">Resistent</div>
	 * <div class="fr">Résistant</div>
	 * <div class="it">Resistente</div>
	 * */
	RESISTANT("R", "Resistant", "Resistent", "Résistant", "Resistente"),

	/**
	 * <div class="en">Intermediate</div>
	 * <div class="de">Intermediär</div>
	 * <div class="fr">Intermédiaire</div>
	 * <div class="it">Intermedio</div>
	 * */
	INTERMEDIATE("I", "Intermediate", "Intermediär", "Intermédiaire", "Intermedio");

	//@formatter:on

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "HL7ObservationInterpretation ";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.83";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ObservationInterpretation getEnum(String code) {
		for (final ObservationInterpretation x : values()) {
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
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(ObservationInterpretation.class, enumName);
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
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ObservationInterpretation x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/** The display names per language */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantsiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayNameEn
	 *            the display name de
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	private ObservationInterpretation(String code, String displayNameEn, String displayNameDe,
			String displayNameFr, String displayNameIt) {
		this.code = code;

		displayNames = new HashMap<>();
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		final var ce = new CE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the husky Code Object</div>
	 * <div class="de">Liefert das husky Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		return new Code(code, CODE_SYSTEM_OID, displayName);
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return getDisplayName(LanguageCode.ENGLISH);
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * language is unknow, german name is returned</div> <div class="de">Liefert
	 * display name gemäss Parameter, falls die Sprache unbekannt ist, wird
	 * standartmässig deutsch geliefert.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null && displayNames.get(languageCode) != null) {
			displayName = displayNames.get(languageCode);
		} else {
			displayName = displayNames.get(LanguageCode.GERMAN);
		}
		return displayName;
	}

}