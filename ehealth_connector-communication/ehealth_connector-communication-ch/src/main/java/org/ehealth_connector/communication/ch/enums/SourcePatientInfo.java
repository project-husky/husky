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
 * Enumeration of DocumentEntry.sourcePatientInfo.PID-8 values
 * <p>
 * EN: Patient’s gender as per Annex 3; EPRO-FDHA.<br>
 * DE: Geschlecht der Patientin oder des Patienten gemäss Anhang 3 EPDV-EDI.<br>
 * FR: Sexe du patient selon l'annexe 3 ODEP-DFI.<br>
 * IT: Sesso del paziente secondo l'allegato 3 OCIP-DFI.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.4.642.3.1<br>
 * Effective date: 2021-04-01 17:04<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum SourcePatientInfo implements ValueSetEnumInterface {

	/**
	 * EN: Female<br>
	 * DE: Weiblich<br>
	 * FR: Féminin<br>
	 * IT: Femminile<br>
	 */
	FEMALE("female", "2.16.840.1.113883.4.642.1.2", "Female", "Female", "Weiblich", "Féminin", "Femminile"),
	/**
	 * EN: Male<br>
	 * DE: Männlich<br>
	 * FR: Masculin<br>
	 * IT: Maschile<br>
	 */
	MALE("male", "2.16.840.1.113883.4.642.1.2", "Male", "Male", "Männlich", "Masculin", "Maschile"),
	/**
	 * EN: Other<br>
	 * DE: Anderes<br>
	 * FR: Autre<br>
	 * IT: Altro<br>
	 */
	OTHER("other", "2.16.840.1.113883.4.642.1.2", "Other", "Other", "Anderes", "Autre", "Altro"),
	/**
	 * EN: Unknown<br>
	 * DE: Unbekannt<br>
	 * FR: Inconnu<br>
	 * IT: Sconosciuto<br>
	 */
	UNKNOWN("unknown", "2.16.840.1.113883.4.642.1.2", "Unknown", "Unknown", "Unbekannt", "Inconnu", "Sconosciuto");

	/**
	 * EN: Code for Female<br>
	 * DE: Code für Weiblich<br>
	 * FR: Code de Féminin<br>
	 * IT: Code per Femminile<br>
	 */
	public static final String FEMALE_CODE = "female";

	/**
	 * EN: Code for Male<br>
	 * DE: Code für Männlich<br>
	 * FR: Code de Masculin<br>
	 * IT: Code per Maschile<br>
	 */
	public static final String MALE_CODE = "male";

	/**
	 * EN: Code for Other<br>
	 * DE: Code für Anderes<br>
	 * FR: Code de Autre<br>
	 * IT: Code per Altro<br>
	 */
	public static final String OTHER_CODE = "other";

	/**
	 * EN: Code for Unknown<br>
	 * DE: Code für Unbekannt<br>
	 * FR: Code de Inconnu<br>
	 * IT: Code per Sconosciuto<br>
	 */
	public static final String UNKNOWN_CODE = "unknown";

	/**
	 * Identifier of the value set.
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.4.642.3.1";

	/**
	 * Name of the value set.
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.sourcePatientInfo.PID-8";

	/**
	 * Gets the Enum with a given code.
	 *
	 * @param code The code value.
	 * @return the enum value found or {@code null}.
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
	 * Checks if a given enum is part of this value set.
	 *
	 * @param enumName The name of the enum.
	 * @return {@code true} if the name is found in this value set, {@code false} otherwise.
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
	 * Checks if a given code value is in this value set.
	 *
	 * @param codeValue The code value.
	 * @return {@code true} if the value is found in this value set, {@code false} otherwise.
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
	 * Machine interpretable and (inside this class) unique code.
	 */
	private String code;

	/**
	 * Identifier of the referencing code system.
	 */
	private String codeSystem;

	/**
	 * The display names per language.
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * Instantiates this enum with a given code and display names.
	 *
	 * @param code          The code value.
	 * @param codeSystem    The code system (OID).
	 * @param displayName   The default display name.
	 * @param displayNameEn The display name in English.
	 * @param displayNameDe The display name in German.
	 * @param displayNameFr The display name in French.
	 * @param displayNameIt The display name in Italian.
	 */
	SourcePatientInfo(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
	 * Gets the code system identifier.
	 *
	 * @return the code system identifier.
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * Gets the code system name.
	 *
	 * @return the code system identifier.
	 */
	@Override
	public String getCodeSystemName() {
		final CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null) {
			return cs.getCodeSystemName();
		}
		return "";
	}

	/**
	 * Gets the code value as a string.
	 *
	 * @return the code value.
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * Gets the display name defined by the language param. If there is no english translation, the default display name
	 *      is returned.
	 *
	 * @param languageCode The language code to get the display name for.
	 * @return the display name in the desired language. if language not found, display name in german will be returned.
	 */
	@Override
	public String getDisplayName(final LanguageCode languageCode) {
		final String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * Gets the value set identifier.
	 *
	 * @return the value set identifier.
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * Gets the value set name.
	 *
	 * @return the value set name.
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
