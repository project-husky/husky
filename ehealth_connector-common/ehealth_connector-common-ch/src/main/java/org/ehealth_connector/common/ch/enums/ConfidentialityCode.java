/*
 *
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
package org.ehealth_connector.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.LanguageCode;

/**
 * <div class="en">Document confidentiality as per Annex 3&amp;#160; EPRO-FDHA,
 * Chapter 2.4.&lt;br clear="none"/&gt;</div>
 * <div class="de">Vertraulichkeitsstufe gemäss Anhang 3 EPDV-EDI, Kapitel
 * 2.4.&lt;br clear="none"/&gt;</div> <div class="fr">Niveau de confidentialité
 * selon l'annexe 3 ODEP-DFI, chapitre 2.4.&lt;br clear="none"/&gt;</div>
 * <div class="it">Grado di riservatezza secondo l'allegato 3 OCIP-DFI, capitolo
 * 2.4.&lt;br clear="none"/&gt;</div>
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ConfidentialityCode implements ValueSetEnumInterface {

	/**
	 * <div class="en">normal</div> <div class="de">normal</div>
	 * <div class="fr">normal</div> <div class="it">normale</div>
	 */
	NORMAL("1051000195109", "2.16.840.1.113883.6.96", "Normal (qualifier value)", "normal",
			"normal", "normal", "normale"),
	/**
	 * <div class="en">restricted</div> <div class="de">eingeschränkt</div>
	 * <div class="fr">limité</div> <div class="it">limitato</div>
	 */
	RESTRICTED("1131000195104", "2.16.840.1.113883.6.96", "Restricted (qualifier value)",
			"restricted", "eingeschränkt", "limité", "limitato"),
	/**
	 * <div class="en">secret</div> <div class="de">geheim</div>
	 * <div class="fr">confidentiel</div> <div class="it">segreto</div>
	 */
	SECRET("1141000195107", "2.16.840.1.113883.6.96", "Secret (qualifier value)", "secret",
			"geheim", "confidentiel", "segreto");

	/**
	 * <div class="en">Code for normal</div> <div class="de">Code für
	 * normal</div> <div class="fr">Code de normal</div> <div class="it">Code
	 * per normale</div>
	 */
	public static final String NORMAL_CODE = "1051000195109";

	/**
	 * <div class="en">Code for restricted</div> <div class="de">Code für
	 * eingeschränkt</div> <div class="fr">Code de limité</div>
	 * <div class="it">Code per limitato</div>
	 */
	public static final String RESTRICTED_CODE = "1131000195104";

	/**
	 * <div class="en">Code for secret</div> <div class="de">Code für
	 * geheim</div> <div class="fr">Code de confidentiel</div>
	 * <div class="it">Code per segreto</div>
	 */
	public static final String SECRET_CODE = "1141000195107";

	/**
	 * <div class="en">Name of the value set</div> <div class="de">Name des
	 * Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "epd_xds_confidentialityCode";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator fÃ¼r das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.5";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ConfidentialityCode getEnum(String code) {
		for (final ConfidentialityCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">PrÃ¼ft, ob der gegebene enum Teil dieses Value Sets
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
			Enum.valueOf(ConfidentialityCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">PrÃ¼ft, ob der gegebene code in diesem Value Set
	 * vorhanden ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ConfidentialityCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

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
	ConfidentialityCode(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
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
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemValue() {
		return this.codeSystem;
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
	 * returned.</div> <div class="de">Liefert display name gemÃ¤ss Parameter,
	 * falls es keine Englische Ãœbersetzung gibt, wird der default-Name
	 * zurÃ¼ckgegeben.</div>
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
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
