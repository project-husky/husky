/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

package org.ehealth_connector.common.enums;

import java.util.HashMap;
import java.util.Map;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Codesystem: HL7 ObservationInterpretation (OID: 2.16.840.1.113883.5.83).</div>
 *<div class="fr">Domaine de valeurs pour « Code dinterprétation »</div>
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
	NORMAL("N",	"Normal", "", "", ""),

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
	NEG("NEG", "Negative", "Negativ", "Négatif", "Negativo");
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
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
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
		return this.displayName;
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