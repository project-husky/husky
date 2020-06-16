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
package org.ehealth_connector.cda.ch.emed.v096.enums;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

/**
 * <!-- @formatter:off -->
 * <div class="en"><p>Note this class was updated manually to add the missings translation, if we regenerate with the art decor generator thoses modification will be missing</p>
 * <p>
 *     <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26
 * </p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ActSubstanceAdminSubstitutionCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">equivalent</div>
	 * <div class="de">Äquivalent</div>
	 * <div class="fr">équivalent</div>
	 * <div class="it">equivalente</div>
	 * <!-- @formatter:on -->
	 */
	EQUIVALENT("E", "2.16.840.1.113883.5.139", "equivalent",
			"equivalent", "Äquivalent", "équivalent", "equivalente"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">equivalent composition</div>
	 * <div class="de">ähnliche Zusammensetzung</div>
	 * <div class="fr">composition équivalente</div>
	 * <div class="it">composizione simile</div>
	 * <!-- @formatter:on -->
	 */
	EQUIVALENT_COMPOSITION("EC", "2.16.840.1.113883.5.139", "equivalent composition",
			"equivalent composition", "ähnliche Zusammensetzung", "composition équivalente", "composizione simile"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">brand composition</div>
	 * <div class="de">Äquivalent desselben Herstellers</div>
	 * <div class="fr">équivalent même fabriquant</div>
	 * <div class="it">equivalente dello stesso produttore</div>
	 * <!-- @formatter:on -->
	 */
	BRAND_COMPOSITION("BC", "2.16.840.1.113883.5.139", "brand composition",
			"brand composition", "Äquivalent desselben Herstellers", "équivalent même fabriquant", "equivalente dello stesso produttore"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">generic composition</div>
	 * <div class="de">identische Zusammensetzung</div>
	 * <div class="fr">composition identique</div>
	 * <div class="it">composizione identica</div>
	 * <!-- @formatter:on -->
	 */
	GENERIC_COMPOSITION("G", "2.16.840.1.113883.5.139", "generic composition",
			"generic composition", "identische Zusammensetzung", "composition identique", "composizione identica"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">therapeutic alternative</div>
	 * <div class="de">therapeutische Alternative</div>
	 * <div class="fr">alternative thérapeutique</div>
	 * <div class="it">alternativa terapeutica</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_ALTERNATIVE("TE", "2.16.840.1.113883.5.139", "therapeutic alternative",
			"therapeutic alternative", "therapeutische Alternative", "alternative thérapeutique", "alternativa terapeutica"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">therapeutic brand</div>
	 * <div class="de">therapeutische Alternative gleicher Hersteller</div>
	 * <div class="fr">alternative thérapeutique même fabricant</div>
	 * <div class="it">alternativa terapeutica stesso produttore</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_BRAND("TB", "2.16.840.1.113883.5.139", "therapeutic brand",
			"therapeutic brand", "therapeutische Alternative gleicher Hersteller", "alternative thérapeutique même fabricant", "alternativa terapeutica stesso produttore"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">therapeutic generic</div>
	 * <div class="de">gleiche therapeutische Wirkung</div>
	 * <div class="fr">effet thérapeutique identique</div>
	 * <div class="it">stesso effetto terapeutico</div>
	 * <!-- @formatter:on -->
	 */
	THERAPEUTIC_GENERIC("TG", "2.16.840.1.113883.5.139", "therapeutic generic",
			"therapeutic generic", "gleiche therapeutische Wirkung", "effet thérapeutique identique", "stesso effetto terapeutico"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">formulary</div>
	 * <div class="de">dieselbe Formel</div>
	 * <div class="fr">même formule</div>
	 * <div class="it">stessa formula</div>
	 * <!-- @formatter:on -->
	 */
	FORMULARY("F", "2.16.840.1.113883.5.139", "formulary",
			"formulary", "dieselbe Formel", "même formule", "stessa formula"),

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">none</div>
	 * <div class="de">nicht autorisiert</div>
	 * <div class="fr">non autorisé</div>
	 * <div class="it">non autorizzato</div>
	 * <!-- @formatter:on -->
	 */
	NONE("N", "2.16.840.1.113883.5.139", "none",
			"none", "nicht autorisiert", "non autorisé", "non autorizzato");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for equivalent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EQUIVALENT_CODE = "E";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for equivalent composition</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EQUIVALENT_COMPOSITION_CODE = "EC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for brand composition</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BRAND_COMPOSITION_CODE = "BC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for generic composition</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERIC_COMPOSITION_CODE = "G";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for therapeutic alternative</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_ALTERNATIVE_CODE = "TE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for therapeutic brand</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_BRAND_CODE = "TB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for therapeutic generic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THERAPEUTIC_GENERIC_CODE = "TG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for formulary</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FORMULARY_CODE = "F";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for none</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NONE_CODE = "N";



	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.16621";

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
	public static ActSubstanceAdminSubstitutionCode getEnum(String code) {
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
	public static boolean isEnumOfValueSet(String enumName) {
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
	public static boolean isInValueSet(String codeValue) {
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
	ActSubstanceAdminSubstitutionCode(String code, String codeSystem, String displayName,
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
