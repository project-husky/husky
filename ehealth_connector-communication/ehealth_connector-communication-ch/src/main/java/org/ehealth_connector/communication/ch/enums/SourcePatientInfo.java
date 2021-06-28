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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of DocumentEntry.sourcePatientInfo.PID-8 values
 *
 * <div class="en">Patient’s gender as per Annex 3; EPRO-FDHA.</div>
 * <div class="de">Geschlecht der Patientin oder des Patienten gemäss Anhang 3 EPDV-EDI.</div>
 * <div class="fr">Sexe du patient selon l'annexe 3 ODEP-DFI.</div>
 * <div class="it">Sesso del paziente secondo l'allegato 3 OCIP-DFI.</div>
 *
 * Identifier: 2.16.840.1.113883.4.642.3.1
 * Effective date: 2021-04-01 17:04
 * Version: 202104.0-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-04-22")
public enum SourcePatientInfo implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Female</div>
	 * <div class="de">Weiblich</div>
	 * <div class="fr">Féminin</div>
	 * <div class="it">Femminile</div>
	 * <!-- @formatter:on -->
	 */
	FEMALE("female", "2.16.840.1.113883.4.642.1.2", "Female", "Female", "Weiblich", "Féminin",
			"Femminile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Male</div>
	 * <div class="de">Männlich</div>
	 * <div class="fr">Masculin</div>
	 * <div class="it">Maschile</div>
	 * <!-- @formatter:on -->
	 */
	MALE("male", "2.16.840.1.113883.4.642.1.2", "Male", "Male", "Männlich", "Masculin",
			"Maschile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Other</div>
	 * <div class="de">Anderes</div>
	 * <div class="fr">Autre</div>
	 * <div class="it">Altro</div>
	 * <!-- @formatter:on -->
	 */
	OTHER("other", "2.16.840.1.113883.4.642.1.2", "Other", "Other", "Anderes", "Autre", "Altro"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Unknown</div>
	 * <div class="de">Unbekannt</div>
	 * <div class="fr">Inconnu</div>
	 * <div class="it">Sconosciuto</div>
	 * <!-- @formatter:on -->
	 */
	UNKNOWN("unknown", "2.16.840.1.113883.4.642.1.2", "Unknown", "Unknown", "Unbekannt", "Inconnu",
			"Sconosciuto");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Female</div>
	 * <div class="de">Code für Weiblich</div>
	 * <div class="fr">Code de Féminin</div>
	 * <div class="it">Code per Femminile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FEMALE_CODE = "female";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Male</div>
	 * <div class="de">Code für Männlich</div>
	 * <div class="fr">Code de Masculin</div>
	 * <div class="it">Code per Maschile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MALE_CODE = "male";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Other</div>
	 * <div class="de">Code für Anderes</div>
	 * <div class="fr">Code de Autre</div>
	 * <div class="it">Code per Altro</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_CODE = "other";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Unknown</div>
	 * <div class="de">Code für Unbekannt</div>
	 * <div class="fr">Code de Inconnu</div>
	 * <div class="it">Code per Sconosciuto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNKNOWN_CODE = "unknown";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.4.642.3.1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.sourcePatientInfo.PID-8";

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
	public static SourcePatientInfo getEnum(final String code) {
		for (final SourcePatientInfo x : values()) {
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
			Enum.valueOf(SourcePatientInfo.class, enumName);
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
		for (final SourcePatientInfo x : values()) {
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
	SourcePatientInfo(final String code, final String codeSystem, final String displayName,
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
