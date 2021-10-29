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
 * Enumeration of ActSubstanceAdminSubstitutionCode values
 *
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.756.5.30.1.1.11.81
 * Effective date: 2020-07-10 00:52
 * Version: 2020
 * Status: DRAFT
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-05")
public enum ActSubstanceAdminSubstitutionCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">brand composition</div>
	 * <div class="de">Äquivalent, andere Marke</div>
	 * <div class="fr">équivalent même fabriquant</div>
	 * <div class="it">equivalente dello stesso produttore</div>
	 * <!-- @formatter:on -->
	 */
	BRAND_COMPOSITION_L3("BC", "2.16.840.1.113883.5.1070", "brand composition", "brand composition",
			"Äquivalent, andere Marke", "équivalent même fabriquant",
			"equivalente dello stesso produttore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">equivalent composition</div>
	 * <div class="de">äquivalente Zusammensetzung</div>
	 * <div class="fr">composition équivalente</div>
	 * <div class="it">composizione simile</div>
	 * <!-- @formatter:on -->
	 */
	EQUIVALENT_COMPOSITION_L2("EC", "2.16.840.1.113883.5.1070", "equivalent composition",
			"equivalent composition", "äquivalente Zusammensetzung", "composition équivalente",
			"composizione simile"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">equivalent</div>
	 * <div class="de">Äquivalent</div>
	 * <div class="fr">équivalent</div>
	 * <div class="it">equivalente</div>
	 * <!-- @formatter:on -->
	 */
	EQUIVALENT_L1("E", "2.16.840.1.113883.5.1070", "equivalent", "equivalent", "Äquivalent",
			"équivalent", "equivalente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">generic composition</div>
	 * <div class="de">Äquivalent, Generikum</div>
	 * <div class="fr">composition identique</div>
	 * <div class="it">composizione identica</div>
	 * <!-- @formatter:on -->
	 */
	GENERIC_COMPOSITION_L3("G", "2.16.840.1.113883.5.1070", "generic composition",
			"generic composition", "Äquivalent, Generikum", "composition identique",
			"composizione identica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">none</div>
	 * <div class="de">nicht autorisiert</div>
	 * <div class="fr">non autorisé</div>
	 * <div class="it">non autorizzato</div>
	 * <!-- @formatter:on -->
	 */
	NONE_L1("N", "2.16.840.1.113883.5.1070", "none", "none", "nicht autorisiert", "non autorisé",
			"non autorizzato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">therapeutic alternative</div>
	 * <div class="de">therapeutische Alternative</div>
	 * <div class="fr">alternative thérapeutique</div>
	 * <div class="it">alternativa terapeutica</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_ALTERNATIVE_L2("TE", "2.16.840.1.113883.5.1070", "therapeutic alternative",
			"therapeutic alternative", "therapeutische Alternative", "alternative thérapeutique",
			"alternativa terapeutica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">therapeutic brand</div>
	 * <div class="de">therapeutische Alternative, andere Marke</div>
	 * <div class="fr">alternative thérapeutique même fabricant</div>
	 * <div class="it">alternativa terapeutica stesso produttore</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_BRAND_L3("TB", "2.16.840.1.113883.5.1070", "therapeutic brand", "therapeutic brand",
			"therapeutische Alternative, andere Marke",
			"alternative thérapeutique même fabricant",
			"alternativa terapeutica stesso produttore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">therapeutic generic</div>
	 * <div class="de">therapeutische Alternative, Generikum</div>
	 * <div class="fr">effet thérapeutique identique</div>
	 * <div class="it">stesso effetto terapeutico</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_GENERIC_L3("TG", "2.16.840.1.113883.5.1070", "therapeutic generic",
			"therapeutic generic", "therapeutische Alternative, Generikum",
			"effet thérapeutique identique", "stesso effetto terapeutico");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for brand composition</div>
	 * <div class="de">Code für Äquivalent, andere Marke</div>
	 * <div class="fr">Code de équivalent même fabriquant</div>
	 * <div class="it">Code per equivalente dello stesso produttore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BRAND_COMPOSITION_L3_CODE = "BC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for equivalent composition</div>
	 * <div class="de">Code für äquivalente Zusammensetzung</div>
	 * <div class="fr">Code de composition équivalente</div>
	 * <div class="it">Code per composizione simile</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EQUIVALENT_COMPOSITION_L2_CODE = "EC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for equivalent</div>
	 * <div class="de">Code für Äquivalent</div>
	 * <div class="fr">Code de équivalent</div>
	 * <div class="it">Code per equivalente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EQUIVALENT_L1_CODE = "E";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for generic composition</div>
	 * <div class="de">Code für Äquivalent, Generikum</div>
	 * <div class="fr">Code de composition identique</div>
	 * <div class="it">Code per composizione identica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERIC_COMPOSITION_L3_CODE = "G";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for none</div>
	 * <div class="de">Code für nicht autorisiert</div>
	 * <div class="fr">Code de non autorisé</div>
	 * <div class="it">Code per non autorizzato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NONE_L1_CODE = "N";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for therapeutic alternative</div>
	 * <div class="de">Code für therapeutische Alternative</div>
	 * <div class="fr">Code de alternative thérapeutique</div>
	 * <div class="it">Code per alternativa terapeutica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_ALTERNATIVE_L2_CODE = "TE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for therapeutic brand</div>
	 * <div class="de">Code für therapeutische Alternative, andere Marke</div>
	 * <div class="fr">Code de alternative thérapeutique même fabricant</div>
	 * <div class="it">Code per alternativa terapeutica stesso produttore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_BRAND_L3_CODE = "TB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for therapeutic generic</div>
	 * <div class="de">Code für therapeutische Alternative, Generikum</div>
	 * <div class="fr">Code de effet thérapeutique identique</div>
	 * <div class="it">Code per stesso effetto terapeutico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_GENERIC_L3_CODE = "TG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.81";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ActSubstanceAdminSubstitutionCode";

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
	public static ActSubstanceAdminSubstitutionCode getEnum(final String code) {
		for (final ActSubstanceAdminSubstitutionCode x : values()) {
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
			Enum.valueOf(ActSubstanceAdminSubstitutionCode.class, enumName);
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
		for (final ActSubstanceAdminSubstitutionCode x : values()) {
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
	ActSubstanceAdminSubstitutionCode(final String code, final String codeSystem,
			final String displayName, final String displayNameEn, final String displayNameDe,
			final String displayNameFr, final String displayNameIt) {
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
