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
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.ch.enums.ValueSetEnumInterface;

/**
 *<!-- @formatter:off -->
 * <div class="en">Document language as per Annex 3&amp;#160; EPRO-FDHA, Chapter 2.7. Defines the language in which the document was written.&lt;br clear="none"/&gt;</div>
 * <div class="de">Sprache des Dokumentes gemäss Anhang 3 EPDV-EDI, Kapitel 2.7. Definiert die Sprache in welcher das Dokument verfasst wurde.&lt;br clear="none"/&gt;</div>
 * <div class="fr">Langue du document selon l'annexe 3 ODEP-DFI, chapitre 2.7. Définit la langue dans laquelle est rédigé le document.&lt;br clear="none"/&gt;</div>
 * <div class="it">Lingua del documento secondo l'allegato 3 OCIP-DFI, capitolo 2.7. Definisce la lingua nella quale è stato redatto il documento.&lt;br clear="none"/&gt;</div>
 *<!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum DocumentLanguage implements ValueSetEnumInterface {

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">English</div>
	 * <div class="de">Englisch</div>
	 * <div class="fr">Anglais</div>
	 * <div class="it">Inglese</div>
	 *<!-- @formatter:on -->
	 */
	ENGLISH("en-US", "2.16.840.1.113883.6.316", "English language (qualifier value)", "English", "Englisch", "Anglais", "Inglese"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">French</div>
	 * <div class="de">Französisch</div>
	 * <div class="fr">Français </div>
	 * <div class="it">Francese</div>
	 *<!-- @formatter:on -->
	 */
	FRENCH("fr-CH", "2.16.840.1.113883.6.316", "French", "French", "Französisch", "Français ", "Francese"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">German</div>
	 * <div class="de">Deutsch</div>
	 * <div class="fr">Allemand</div>
	 * <div class="it">Tedesco</div>
	 *<!-- @formatter:on -->
	 */
	GERMAN("de-CH", "2.16.840.1.113883.6.316", "German ", "German", "Deutsch", "Allemand", "Tedesco"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Italian</div>
	 * <div class="de">Italienisch</div>
	 * <div class="fr">Italien</div>
	 * <div class="it">Italiano</div>
	 *<!-- @formatter:on -->
	 */
	ITALIAN("it-CH", "2.16.840.1.113883.6.316", "Italian ", "Italian", "Italienisch", "Italien", "Italiano"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Rhaeto-Romanic </div>
	 * <div class="de">Rätoromanisch</div>
	 * <div class="fr">Rhéto-roman</div>
	 * <div class="it">Romancio</div>
	 *<!-- @formatter:on -->
	 */
	RHAETO_ROMANIC("rm", "2.16.840.1.113883.6.316", "Rhaeto-Romanic", "Rhaeto-Romanic ", "Rätoromanisch", "Rhéto-roman", "Romancio");

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for English</div>
	 * <div class="de">Code für Englisch</div>
	 * <div class="fr">Code de Anglais</div>
	 * <div class="it">Code per Inglese</div>
	 *<!-- @formatter:on -->
	 */
	public static final String ENGLISH_CODE = "en-US";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for French</div>
	 * <div class="de">Code für Französisch</div>
	 * <div class="fr">Code de Français </div>
	 * <div class="it">Code per Francese</div>
	 *<!-- @formatter:on -->
	 */
	public static final String FRENCH_CODE = "fr-CH";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for German</div>
	 * <div class="de">Code für Deutsch</div>
	 * <div class="fr">Code de Allemand</div>
	 * <div class="it">Code per Tedesco</div>
	 *<!-- @formatter:on -->
	 */
	public static final String GERMAN_CODE = "de-CH";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Italian</div>
	 * <div class="de">Code für Italienisch</div>
	 * <div class="fr">Code de Italien</div>
	 * <div class="it">Code per Italiano</div>
	 *<!-- @formatter:on -->
	 */
	public static final String ITALIAN_CODE = "it-CH";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Rhaeto-Romanic </div>
	 * <div class="de">Code für Rätoromanisch</div>
	 * <div class="fr">Code de Rhéto-roman</div>
	 * <div class="it">Code per Romancio</div>
	 *<!-- @formatter:on -->
	 */
	public static final String RHAETO_ROMANIC_CODE = "rm";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator fÃ¼r das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.13";

	/**
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "EprDocumentLanguage";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static DocumentLanguage getEnum(String code) {
		for (final DocumentLanguage x : values()) {
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
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(DocumentLanguage.class, enumName);
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
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final DocumentLanguage x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse)
	 * eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes
	 * und einem Display Name</div>.
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
	DocumentLanguage(String code, String codeSystem, String displayName, String displayNameEn, String displayNameDe, String displayNameFr, String displayNameIt) {
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
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * den Code System Namen.</div>
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
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
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
	 * <div class="en">Gets the value set identifier.</div> <div class="de">Liefert
	 * den Value Set Identifikator.</div>
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
