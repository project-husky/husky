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
package org.ehealth_connector.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of DocumentEntry.languageCode values
 *
 * <div class="en">Document language as per Annex 3 EPRO-FDHA. Defines the language in which the document was written.</div>
 * <div class="de">Sprache des Dokumentes gemäss Anhang 3 EPDV-EDI. Definiert die Sprache in welcher das Dokument verfasst wurde.</div>
 * <div class="fr">Langue du document selon l'annexe 3 ODEP-DFI. Définit la langue dans laquelle est rédigé le document.</div>
 * <div class="it">Lingua del documento secondo l'allegato 3 OCIP-DFI. Definisce la lingua nella quale è stato redatto il documento.</div>
 *
 * Identifier: 2.16.756.5.30.1.127.3.10.1.13
 * Effective date: 2021-04-01 17:03
 * Version: 202104.0-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-04-22")
public enum DocumentLanguage implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Arabic</div>
	 * <div class="de">Arabisch</div>
	 * <div class="fr">Arabe</div>
	 * <div class="it">Arabo</div>
	 * <!-- @formatter:on -->
	 */
	ARABIC("ar", "2.16.840.1.113883.6.316", "Arabic", "Arabic", "Arabisch", "Arabe", "Arabo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bengali</div>
	 * <div class="de">Bengalisch</div>
	 * <div class="fr">Bengali</div>
	 * <div class="it">Bengalese</div>
	 * <!-- @formatter:on -->
	 */
	BENGALI("bn", "2.16.840.1.113883.6.316", "Bengali", "Bengali", "Bengalisch", "Bengali",
			"Bengalese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chinese</div>
	 * <div class="de">Chinesisch</div>
	 * <div class="fr">Chinois</div>
	 * <div class="it">Cinese</div>
	 * <!-- @formatter:on -->
	 */
	CHINESE("zh", "2.16.840.1.113883.6.316", "Chinese", "Chinese", "Chinesisch", "Chinois",
			"Cinese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chinese (China)</div>
	 * <div class="de">Chinesisch (China)</div>
	 * <div class="fr">Chinois (Chine)</div>
	 * <div class="it">Cinese (Cina)</div>
	 * <!-- @formatter:on -->
	 */
	CHINESE_CHINA("zh-CN", "2.16.840.1.113883.6.316", "Chinese (China)", "Chinese (China)",
			"Chinesisch (China)", "Chinois (Chine)", "Cinese (Cina)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chinese (Hong Kong)</div>
	 * <div class="de">Chinesisch (Hong Kong)</div>
	 * <div class="fr">Chinois (Hong Kong)</div>
	 * <div class="it">Cinese (Hong Kong)</div>
	 * <!-- @formatter:on -->
	 */
	CHINESE_HONG_KONG("zh-HK", "2.16.840.1.113883.6.316", "Chinese (Hong Kong)",
			"Chinese (Hong Kong)", "Chinesisch (Hong Kong)", "Chinois (Hong Kong)",
			"Cinese (Hong Kong)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chinese (Singapore)</div>
	 * <div class="de">Chinesisch (Singapur)</div>
	 * <div class="fr">Chinois (Singapour)</div>
	 * <div class="it">Cinese (Singapore)</div>
	 * <!-- @formatter:on -->
	 */
	CHINESE_SINGAPORE("zh-SG", "2.16.840.1.113883.6.316", "Chinese (Singapore)",
			"Chinese (Singapore)", "Chinesisch (Singapur)", "Chinois (Singapour)",
			"Cinese (Singapore)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chinese (Taiwan)</div>
	 * <div class="de">Chinesisch (Taiwan)</div>
	 * <div class="fr">Chinois (Taïwan)</div>
	 * <div class="it">Cinese (Taiwan)</div>
	 * <!-- @formatter:on -->
	 */
	CHINESE_TAIWAN("zh-TW", "2.16.840.1.113883.6.316", "Chinese (Taiwan)", "Chinese (Taiwan)",
			"Chinesisch (Taiwan)", "Chinois (Taïwan)", "Cinese (Taiwan)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Croatian</div>
	 * <div class="de">Kroatisch</div>
	 * <div class="fr">Croate</div>
	 * <div class="it">Croato</div>
	 * <!-- @formatter:on -->
	 */
	CROATIAN("hr", "2.16.840.1.113883.6.316", "Croatian", "Croatian", "Kroatisch", "Croate",
			"Croato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Czech</div>
	 * <div class="de">Tschechisch</div>
	 * <div class="fr">Tchèque</div>
	 * <div class="it">Ceco</div>
	 * <!-- @formatter:on -->
	 */
	CZECH("cs", "2.16.840.1.113883.6.316", "Czech", "Czech", "Tschechisch", "Tchèque", "Ceco"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Danish</div>
	 * <div class="de">Dänisch</div>
	 * <div class="fr">Danois</div>
	 * <div class="it">Danese</div>
	 * <!-- @formatter:on -->
	 */
	DANISH("da", "2.16.840.1.113883.6.316", "Danish", "Danish", "Dänisch", "Danois", "Danese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dutch</div>
	 * <div class="de">Niederländisch</div>
	 * <div class="fr">Néerlandais</div>
	 * <div class="it">Olandese</div>
	 * <!-- @formatter:on -->
	 */
	DUTCH("nl", "2.16.840.1.113883.6.316", "Dutch", "Dutch", "Niederländisch", "Néerlandais",
			"Olandese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dutch (Belgium)</div>
	 * <div class="de">Niederländisch (Belgien)</div>
	 * <div class="fr">Néerlandais (Belgique)</div>
	 * <div class="it">Olandese (Belgio)</div>
	 * <!-- @formatter:on -->
	 */
	DUTCH_BELGIUM("nl-BE", "2.16.840.1.113883.6.316", "Dutch (Belgium)", "Dutch (Belgium)",
			"Niederländisch (Belgien)", "Néerlandais (Belgique)", "Olandese (Belgio)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dutch (Netherlands)</div>
	 * <div class="de">Niederländisch (Niederlande)</div>
	 * <div class="fr">Néerlandais (Pays-Bas)</div>
	 * <div class="it">Olandese (Paesi Bassi)</div>
	 * <!-- @formatter:on -->
	 */
	DUTCH_NETHERLANDS("nl-NL", "2.16.840.1.113883.6.316", "Dutch (Netherlands)",
			"Dutch (Netherlands)", "Niederländisch (Niederlande)", "Néerlandais (Pays-Bas)",
			"Olandese (Paesi Bassi)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English</div>
	 * <div class="de">Englisch</div>
	 * <div class="fr">Anglais</div>
	 * <div class="it">Inglese</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH("en", "2.16.840.1.113883.6.316", "English", "English", "Englisch", "Anglais",
			"Inglese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (Australia)</div>
	 * <div class="de">Englisch (Australien)</div>
	 * <div class="fr">Anglais (Australie)</div>
	 * <div class="it">Inglese (Australia)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_AUSTRALIA("en-AU", "2.16.840.1.113883.6.316", "English (Australia)",
			"English (Australia)", "Englisch (Australien)", "Anglais (Australie)",
			"Inglese (Australia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (Canada)</div>
	 * <div class="de">Englisch (Kanada)</div>
	 * <div class="fr">Anglais (Canada)</div>
	 * <div class="it">Inglese (Canada)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_CANADA("en-CA", "2.16.840.1.113883.6.316", "English (Canada)", "English (Canada)",
			"Englisch (Kanada)", "Anglais (Canada)", "Inglese (Canada)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (Great Britain)</div>
	 * <div class="de">Englisch (Grossbritannien)</div>
	 * <div class="fr">Anglais (Grande Bretagne)</div>
	 * <div class="it">Inglese (Gran Bretagna)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_GREAT_BRITAIN("en-GB", "2.16.840.1.113883.6.316", "English (Great Britain)",
			"English (Great Britain)", "Englisch (Grossbritannien)", "Anglais (Grande Bretagne)",
			"Inglese (Gran Bretagna)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (India)</div>
	 * <div class="de">Englisch (Indien)</div>
	 * <div class="fr">Anglais (Inde)</div>
	 * <div class="it">Inglese (India)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_INDIA("en-IN", "2.16.840.1.113883.6.316", "English (India)", "English (India)",
			"Englisch (Indien)", "Anglais (Inde)", "Inglese (India)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (New Zealand)</div>
	 * <div class="de">Englisch (Neuseeland)</div>
	 * <div class="fr">Anglais (Nouvelle Zélande)</div>
	 * <div class="it">Inglese (Nuova Zelanda)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_NEW_ZEALAND("en-NZ", "2.16.840.1.113883.6.316", "English (New Zealand)",
			"English (New Zealand)", "Englisch (Neuseeland)", "Anglais (Nouvelle Zélande)",
			"Inglese (Nuova Zelanda)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (Singapore)</div>
	 * <div class="de">Englisch (Singapur)</div>
	 * <div class="fr">Anglais (Singapour)</div>
	 * <div class="it">Inglese (Singapore)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_SINGAPORE("en-SG", "2.16.840.1.113883.6.316", "English (Singapore)",
			"English (Singapore)", "Englisch (Singapur)", "Anglais (Singapour)",
			"Inglese (Singapore)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">English (United States)</div>
	 * <div class="de">Englisch (USA)</div>
	 * <div class="fr">Anglais (États Unis)</div>
	 * <div class="it">Inglese (Stati Uniti)</div>
	 * <!-- @formatter:on -->
	 */
	ENGLISH_UNITED_STATES("en-US", "2.16.840.1.113883.6.316", "English (United States)",
			"English (United States)", "Englisch (USA)", "Anglais (États Unis)",
			"Inglese (Stati Uniti)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Finnish</div>
	 * <div class="de">Finnisch</div>
	 * <div class="fr">Finnois</div>
	 * <div class="it">Finlandese</div>
	 * <!-- @formatter:on -->
	 */
	FINNISH("fi", "2.16.840.1.113883.6.316", "Finnish", "Finnish", "Finnisch", "Finnois",
			"Finlandese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">French</div>
	 * <div class="de">Französisch</div>
	 * <div class="fr">Français</div>
	 * <div class="it">Francese</div>
	 * <!-- @formatter:on -->
	 */
	FRENCH("fr", "2.16.840.1.113883.6.316", "French", "French", "Französisch", "Français",
			"Francese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">French (Belgium)</div>
	 * <div class="de">Französisch (Belgien)</div>
	 * <div class="fr">Français (Belgique)</div>
	 * <div class="it">Francese (Belgio)</div>
	 * <!-- @formatter:on -->
	 */
	FRENCH_BELGIUM("fr-BE", "2.16.840.1.113883.6.316", "French (Belgium)", "French (Belgium)",
			"Französisch (Belgien)", "Français (Belgique)", "Francese (Belgio)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">French (France)</div>
	 * <div class="de">Französisch (Frankreich)</div>
	 * <div class="fr">Français (France)</div>
	 * <div class="it">Francese (Francia)</div>
	 * <!-- @formatter:on -->
	 */
	FRENCH_FRANCE("fr-FR", "2.16.840.1.113883.6.316", "French (France)", "French (France)",
			"Französisch (Frankreich)", "Français (France)", "Francese (Francia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">French (Switzerland)</div>
	 * <div class="de">Französisch (Schweiz)</div>
	 * <div class="fr">Français (Suisse)</div>
	 * <div class="it">Francese (Svizzera)</div>
	 * <!-- @formatter:on -->
	 */
	FRENCH_SWITZERLAND("fr-CH", "2.16.840.1.113883.6.316", "French (Switzerland)",
			"French (Switzerland)", "Französisch (Schweiz)", "Français (Suisse)",
			"Francese (Svizzera)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Frysian</div>
	 * <div class="de">Friesisch</div>
	 * <div class="fr">Frison</div>
	 * <div class="it">Frisone</div>
	 * <!-- @formatter:on -->
	 */
	FRYSIAN("fy", "2.16.840.1.113883.6.316", "Frysian", "Frysian", "Friesisch", "Frison",
			"Frisone"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Frysian (Netherlands)</div>
	 * <div class="de">Friesisch (Niederlande)</div>
	 * <div class="fr">Frison (Pays-Bas)</div>
	 * <div class="it">Frisone (Paesi Bassi)</div>
	 * <!-- @formatter:on -->
	 */
	FRYSIAN_NETHERLANDS("fy-NL", "2.16.840.1.113883.6.316", "Frysian (Netherlands)",
			"Frysian (Netherlands)", "Friesisch (Niederlande)", "Frison (Pays-Bas)",
			"Frisone (Paesi Bassi)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">German</div>
	 * <div class="de">Deutsch</div>
	 * <div class="fr">Allemand</div>
	 * <div class="it">Tedesco</div>
	 * <!-- @formatter:on -->
	 */
	GERMAN("de", "2.16.840.1.113883.6.316", "German", "German", "Deutsch", "Allemand", "Tedesco"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">German (Austria)</div>
	 * <div class="de">Deutsch (Österreich)</div>
	 * <div class="fr">Allemand (Autriche)</div>
	 * <div class="it">Tedesco (Austria)</div>
	 * <!-- @formatter:on -->
	 */
	GERMAN_AUSTRIA("de-AT", "2.16.840.1.113883.6.316", "German (Austria)", "German (Austria)",
			"Deutsch (Österreich)", "Allemand (Autriche)", "Tedesco (Austria)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">German (Germany)</div>
	 * <div class="de">Deutsch (Deutschland)</div>
	 * <div class="fr">Allemand (Allemagne)</div>
	 * <div class="it">Tedesco (Germania)</div>
	 * <!-- @formatter:on -->
	 */
	GERMAN_GERMANY("de-DE", "2.16.840.1.113883.6.316", "German (Germany)", "German (Germany)",
			"Deutsch (Deutschland)", "Allemand (Allemagne)", "Tedesco (Germania)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">German (Switzerland)</div>
	 * <div class="de">Deutsch (Schweiz)</div>
	 * <div class="fr">Allemand (Suisse)</div>
	 * <div class="it">Tedesco (Svizzera)</div>
	 * <!-- @formatter:on -->
	 */
	GERMAN_SWITZERLAND("de-CH", "2.16.840.1.113883.6.316", "German (Switzerland)",
			"German (Switzerland)", "Deutsch (Schweiz)", "Allemand (Suisse)", "Tedesco (Svizzera)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Greek</div>
	 * <div class="de">Griechisch</div>
	 * <div class="fr">Grec</div>
	 * <div class="it">Greco</div>
	 * <!-- @formatter:on -->
	 */
	GREEK("el", "2.16.840.1.113883.6.316", "Greek", "Greek", "Griechisch", "Grec", "Greco"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hindi</div>
	 * <div class="de">Hindi</div>
	 * <div class="fr">Hindi</div>
	 * <div class="it">Hindi</div>
	 * <!-- @formatter:on -->
	 */
	HINDI("hi", "2.16.840.1.113883.6.316", "Hindi", "Hindi", "Hindi", "Hindi", "Hindi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Italian</div>
	 * <div class="de">Italienisch</div>
	 * <div class="fr">Italien</div>
	 * <div class="it">Italiano</div>
	 * <!-- @formatter:on -->
	 */
	ITALIAN("it", "2.16.840.1.113883.6.316", "Italian", "Italian", "Italienisch", "Italien",
			"Italiano"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Italian (Italy)</div>
	 * <div class="de">Italienisch (Italien)</div>
	 * <div class="fr">Italien (Italie)</div>
	 * <div class="it">Italiano (Italia)</div>
	 * <!-- @formatter:on -->
	 */
	ITALIAN_ITALY("it-IT", "2.16.840.1.113883.6.316", "Italian (Italy)", "Italian (Italy)",
			"Italienisch (Italien)", "Italien (Italie)", "Italiano (Italia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Italian (Switzerland)</div>
	 * <div class="de">Italienisch (Schweiz)</div>
	 * <div class="fr">Italien (Suisse)</div>
	 * <div class="it">Italiano (Svizzera)</div>
	 * <!-- @formatter:on -->
	 */
	ITALIAN_SWITZERLAND("it-CH", "2.16.840.1.113883.6.316", "Italian (Switzerland)",
			"Italian (Switzerland)", "Italienisch (Schweiz)", "Italien (Suisse)",
			"Italiano (Svizzera)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Japanese</div>
	 * <div class="de">Japanisch</div>
	 * <div class="fr">Japonais</div>
	 * <div class="it">Giapponese</div>
	 * <!-- @formatter:on -->
	 */
	JAPANESE("ja", "2.16.840.1.113883.6.316", "Japanese", "Japanese", "Japanisch", "Japonais",
			"Giapponese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Korean</div>
	 * <div class="de">Koreanisch</div>
	 * <div class="fr">Coréen</div>
	 * <div class="it">Coreano</div>
	 * <!-- @formatter:on -->
	 */
	KOREAN("ko", "2.16.840.1.113883.6.316", "Korean", "Korean", "Koreanisch", "Coréen", "Coreano"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Norwegian</div>
	 * <div class="de">Norwegisch</div>
	 * <div class="fr">Norvégien</div>
	 * <div class="it">Norvegese</div>
	 * <!-- @formatter:on -->
	 */
	NORWEGIAN("no", "2.16.840.1.113883.6.316", "Norwegian", "Norwegian", "Norwegisch", "Norvégien",
			"Norvegese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Norwegian (Norway)</div>
	 * <div class="de">Norwegisch (Norwegen)</div>
	 * <div class="fr">Norvégien (Norvège)</div>
	 * <div class="it">Norvegese (Norvegia)</div>
	 * <!-- @formatter:on -->
	 */
	NORWEGIAN_NORWAY("no-NO", "2.16.840.1.113883.6.316", "Norwegian (Norway)", "Norwegian (Norway)",
			"Norwegisch (Norwegen)", "Norvégien (Norvège)", "Norvegese (Norvegia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Other language</div>
	 * <div class="de">Andere Sprache</div>
	 * <div class="fr">Autre langue</div>
	 * <div class="it">Altra lingua</div>
	 * <!-- @formatter:on -->
	 */
	OTHER_LANGUAGE("OTHER", "2.16.756.5.30.1.127.3.10.12", "Other language", "Other language",
			"Andere Sprache", "Autre langue", "Altra lingua"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Polish</div>
	 * <div class="de">Polnisch</div>
	 * <div class="fr">Polonais</div>
	 * <div class="it">Polacco</div>
	 * <!-- @formatter:on -->
	 */
	POLISH("pl", "2.16.840.1.113883.6.316", "Polish", "Polish", "Polnisch", "Polonais", "Polacco"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Portuguese</div>
	 * <div class="de">Portugiesisch</div>
	 * <div class="fr">Portugais</div>
	 * <div class="it">Portoghese</div>
	 * <!-- @formatter:on -->
	 */
	PORTUGUESE("pt", "2.16.840.1.113883.6.316", "Portuguese", "Portuguese", "Portugiesisch",
			"Portugais", "Portoghese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Portuguese (Brazil)</div>
	 * <div class="de">Portugiesisch (Brasilien)</div>
	 * <div class="fr">Portugais (Brésil)</div>
	 * <div class="it">Portoghese (Brasile)</div>
	 * <!-- @formatter:on -->
	 */
	PORTUGUESE_BRAZIL("pt-BR", "2.16.840.1.113883.6.316", "Portuguese (Brazil)",
			"Portuguese (Brazil)", "Portugiesisch (Brasilien)", "Portugais (Brésil)",
			"Portoghese (Brasile)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Punjabi</div>
	 * <div class="de">Panjabi</div>
	 * <div class="fr">Panjabi</div>
	 * <div class="it">Panjabi</div>
	 * <!-- @formatter:on -->
	 */
	PUNJABI("pa", "2.16.840.1.113883.6.316", "Punjabi", "Punjabi", "Panjabi", "Panjabi", "Panjabi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Romansh</div>
	 * <div class="de">Rätoromanisch</div>
	 * <div class="fr">Rhéto-roman</div>
	 * <div class="it">Romancio</div>
	 * <!-- @formatter:on -->
	 */
	ROMANSH("rm", "2.16.840.1.113883.6.316", "Romansh", "Romansh", "Rätoromanisch", "Rhéto-roman",
			"Romancio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Russian</div>
	 * <div class="de">Russisch</div>
	 * <div class="fr">Russe</div>
	 * <div class="it">Russo</div>
	 * <!-- @formatter:on -->
	 */
	RUSSIAN("ru", "2.16.840.1.113883.6.316", "Russian", "Russian", "Russisch", "Russe", "Russo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Russian (Russia)</div>
	 * <div class="de">Russisch (Russland)</div>
	 * <div class="fr">Russe (Russie)</div>
	 * <div class="it">Russo (Russia)</div>
	 * <!-- @formatter:on -->
	 */
	RUSSIAN_RUSSIA("ru-RU", "2.16.840.1.113883.6.316", "Russian (Russia)", "Russian (Russia)",
			"Russisch (Russland)", "Russe (Russie)", "Russo (Russia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Serbian</div>
	 * <div class="de">Serbisch</div>
	 * <div class="fr">Serbe</div>
	 * <div class="it">Serbo</div>
	 * <!-- @formatter:on -->
	 */
	SERBIAN("sr", "2.16.840.1.113883.6.316", "Serbian", "Serbian", "Serbisch", "Serbe", "Serbo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Serbian (Serbia)</div>
	 * <div class="de">Serbisch (Serbien)</div>
	 * <div class="fr">Serbe (Serbie)</div>
	 * <div class="it">Serbo (Serbia)</div>
	 * <!-- @formatter:on -->
	 */
	SERBIAN_SERBIA("sr-RS", "2.16.840.1.113883.6.316", "Serbian (Serbia)", "Serbian (Serbia)",
			"Serbisch (Serbien)", "Serbe (Serbie)", "Serbo (Serbia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Spanish</div>
	 * <div class="de">Spanisch</div>
	 * <div class="fr">Espagnol</div>
	 * <div class="it">Spagnolo</div>
	 * <!-- @formatter:on -->
	 */
	SPANISH("es", "2.16.840.1.113883.6.316", "Spanish", "Spanish", "Spanisch", "Espagnol",
			"Spagnolo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Spanish (Argentina)</div>
	 * <div class="de">Spanisch (Argentinien)</div>
	 * <div class="fr">Espagnol (Argentine)</div>
	 * <div class="it">Spagnolo (Argentina)</div>
	 * <!-- @formatter:on -->
	 */
	SPANISH_ARGENTINA("es-AR", "2.16.840.1.113883.6.316", "Spanish (Argentina)",
			"Spanish (Argentina)", "Spanisch (Argentinien)", "Espagnol (Argentine)",
			"Spagnolo (Argentina)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Spanish (Spain)</div>
	 * <div class="de">Spanisch (Spanien)</div>
	 * <div class="fr">Espagnol (Espagne)</div>
	 * <div class="it">Spagnolo (Spagna)</div>
	 * <!-- @formatter:on -->
	 */
	SPANISH_SPAIN("es-ES", "2.16.840.1.113883.6.316", "Spanish (Spain)", "Spanish (Spain)",
			"Spanisch (Spanien)", "Espagnol (Espagne)", "Spagnolo (Spagna)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Spanish (Uruguay)</div>
	 * <div class="de">Spanisch (Uruguay)</div>
	 * <div class="fr">Espagnol (Uruguay)</div>
	 * <div class="it">Spagnolo (Uruguay)</div>
	 * <!-- @formatter:on -->
	 */
	SPANISH_URUGUAY("es-UY", "2.16.840.1.113883.6.316", "Spanish (Uruguay)", "Spanish (Uruguay)",
			"Spanisch (Uruguay)", "Espagnol (Uruguay)", "Spagnolo (Uruguay)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swedish</div>
	 * <div class="de">Schwedisch</div>
	 * <div class="fr">Suédois</div>
	 * <div class="it">Svedese</div>
	 * <!-- @formatter:on -->
	 */
	SWEDISH("sv", "2.16.840.1.113883.6.316", "Swedish", "Swedish", "Schwedisch", "Suédois",
			"Svedese"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Swedish (Sweden)</div>
	 * <div class="de">Schwedisch (Schweden)</div>
	 * <div class="fr">Suédois (Suède)</div>
	 * <div class="it">Svedese (Svezia)</div>
	 * <!-- @formatter:on -->
	 */
	SWEDISH_SWEDEN("sv-SE", "2.16.840.1.113883.6.316", "Swedish (Sweden)", "Swedish (Sweden)",
			"Schwedisch (Schweden)", "Suédois (Suède)", "Svedese (Svezia)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Telegu</div>
	 * <div class="de">Telugu</div>
	 * <div class="fr">Telugu</div>
	 * <div class="it">Telugu</div>
	 * <!-- @formatter:on -->
	 */
	TELEGU("te", "2.16.840.1.113883.6.316", "Telegu", "Telegu", "Telugu", "Telugu", "Telugu");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Arabic</div>
	 * <div class="de">Code für Arabisch</div>
	 * <div class="fr">Code de Arabe</div>
	 * <div class="it">Code per Arabo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ARABIC_CODE = "ar";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bengali</div>
	 * <div class="de">Code für Bengalisch</div>
	 * <div class="fr">Code de Bengali</div>
	 * <div class="it">Code per Bengalese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BENGALI_CODE = "bn";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chinese</div>
	 * <div class="de">Code für Chinesisch</div>
	 * <div class="fr">Code de Chinois</div>
	 * <div class="it">Code per Cinese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHINESE_CODE = "zh";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chinese (China)</div>
	 * <div class="de">Code für Chinesisch (China)</div>
	 * <div class="fr">Code de Chinois (Chine)</div>
	 * <div class="it">Code per Cinese (Cina)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHINESE_CHINA_CODE = "zh-CN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chinese (Hong Kong)</div>
	 * <div class="de">Code für Chinesisch (Hong Kong)</div>
	 * <div class="fr">Code de Chinois (Hong Kong)</div>
	 * <div class="it">Code per Cinese (Hong Kong)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHINESE_HONG_KONG_CODE = "zh-HK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chinese (Singapore)</div>
	 * <div class="de">Code für Chinesisch (Singapur)</div>
	 * <div class="fr">Code de Chinois (Singapour)</div>
	 * <div class="it">Code per Cinese (Singapore)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHINESE_SINGAPORE_CODE = "zh-SG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chinese (Taiwan)</div>
	 * <div class="de">Code für Chinesisch (Taiwan)</div>
	 * <div class="fr">Code de Chinois (Taïwan)</div>
	 * <div class="it">Code per Cinese (Taiwan)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHINESE_TAIWAN_CODE = "zh-TW";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Croatian</div>
	 * <div class="de">Code für Kroatisch</div>
	 * <div class="fr">Code de Croate</div>
	 * <div class="it">Code per Croato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CROATIAN_CODE = "hr";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Czech</div>
	 * <div class="de">Code für Tschechisch</div>
	 * <div class="fr">Code de Tchèque</div>
	 * <div class="it">Code per Ceco</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CZECH_CODE = "cs";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Danish</div>
	 * <div class="de">Code für Dänisch</div>
	 * <div class="fr">Code de Danois</div>
	 * <div class="it">Code per Danese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DANISH_CODE = "da";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dutch</div>
	 * <div class="de">Code für Niederländisch</div>
	 * <div class="fr">Code de Néerlandais</div>
	 * <div class="it">Code per Olandese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DUTCH_CODE = "nl";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dutch (Belgium)</div>
	 * <div class="de">Code für Niederländisch (Belgien)</div>
	 * <div class="fr">Code de Néerlandais (Belgique)</div>
	 * <div class="it">Code per Olandese (Belgio)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DUTCH_BELGIUM_CODE = "nl-BE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dutch (Netherlands)</div>
	 * <div class="de">Code für Niederländisch (Niederlande)</div>
	 * <div class="fr">Code de Néerlandais (Pays-Bas)</div>
	 * <div class="it">Code per Olandese (Paesi Bassi)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DUTCH_NETHERLANDS_CODE = "nl-NL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English</div>
	 * <div class="de">Code für Englisch</div>
	 * <div class="fr">Code de Anglais</div>
	 * <div class="it">Code per Inglese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_CODE = "en";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (Australia)</div>
	 * <div class="de">Code für Englisch (Australien)</div>
	 * <div class="fr">Code de Anglais (Australie)</div>
	 * <div class="it">Code per Inglese (Australia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_AUSTRALIA_CODE = "en-AU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (Canada)</div>
	 * <div class="de">Code für Englisch (Kanada)</div>
	 * <div class="fr">Code de Anglais (Canada)</div>
	 * <div class="it">Code per Inglese (Canada)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_CANADA_CODE = "en-CA";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (Great Britain)</div>
	 * <div class="de">Code für Englisch (Grossbritannien)</div>
	 * <div class="fr">Code de Anglais (Grande Bretagne)</div>
	 * <div class="it">Code per Inglese (Gran Bretagna)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_GREAT_BRITAIN_CODE = "en-GB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (India)</div>
	 * <div class="de">Code für Englisch (Indien)</div>
	 * <div class="fr">Code de Anglais (Inde)</div>
	 * <div class="it">Code per Inglese (India)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_INDIA_CODE = "en-IN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (New Zealand)</div>
	 * <div class="de">Code für Englisch (Neuseeland)</div>
	 * <div class="fr">Code de Anglais (Nouvelle Zélande)</div>
	 * <div class="it">Code per Inglese (Nuova Zelanda)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_NEW_ZEALAND_CODE = "en-NZ";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (Singapore)</div>
	 * <div class="de">Code für Englisch (Singapur)</div>
	 * <div class="fr">Code de Anglais (Singapour)</div>
	 * <div class="it">Code per Inglese (Singapore)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_SINGAPORE_CODE = "en-SG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for English (United States)</div>
	 * <div class="de">Code für Englisch (USA)</div>
	 * <div class="fr">Code de Anglais (États Unis)</div>
	 * <div class="it">Code per Inglese (Stati Uniti)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENGLISH_UNITED_STATES_CODE = "en-US";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Finnish</div>
	 * <div class="de">Code für Finnisch</div>
	 * <div class="fr">Code de Finnois</div>
	 * <div class="it">Code per Finlandese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FINNISH_CODE = "fi";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for French</div>
	 * <div class="de">Code für Französisch</div>
	 * <div class="fr">Code de Français</div>
	 * <div class="it">Code per Francese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRENCH_CODE = "fr";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for French (Belgium)</div>
	 * <div class="de">Code für Französisch (Belgien)</div>
	 * <div class="fr">Code de Français (Belgique)</div>
	 * <div class="it">Code per Francese (Belgio)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRENCH_BELGIUM_CODE = "fr-BE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for French (France)</div>
	 * <div class="de">Code für Französisch (Frankreich)</div>
	 * <div class="fr">Code de Français (France)</div>
	 * <div class="it">Code per Francese (Francia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRENCH_FRANCE_CODE = "fr-FR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for French (Switzerland)</div>
	 * <div class="de">Code für Französisch (Schweiz)</div>
	 * <div class="fr">Code de Français (Suisse)</div>
	 * <div class="it">Code per Francese (Svizzera)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRENCH_SWITZERLAND_CODE = "fr-CH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Frysian</div>
	 * <div class="de">Code für Friesisch</div>
	 * <div class="fr">Code de Frison</div>
	 * <div class="it">Code per Frisone</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRYSIAN_CODE = "fy";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Frysian (Netherlands)</div>
	 * <div class="de">Code für Friesisch (Niederlande)</div>
	 * <div class="fr">Code de Frison (Pays-Bas)</div>
	 * <div class="it">Code per Frisone (Paesi Bassi)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FRYSIAN_NETHERLANDS_CODE = "fy-NL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for German</div>
	 * <div class="de">Code für Deutsch</div>
	 * <div class="fr">Code de Allemand</div>
	 * <div class="it">Code per Tedesco</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GERMAN_CODE = "de";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for German (Austria)</div>
	 * <div class="de">Code für Deutsch (Österreich)</div>
	 * <div class="fr">Code de Allemand (Autriche)</div>
	 * <div class="it">Code per Tedesco (Austria)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GERMAN_AUSTRIA_CODE = "de-AT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for German (Germany)</div>
	 * <div class="de">Code für Deutsch (Deutschland)</div>
	 * <div class="fr">Code de Allemand (Allemagne)</div>
	 * <div class="it">Code per Tedesco (Germania)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GERMAN_GERMANY_CODE = "de-DE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for German (Switzerland)</div>
	 * <div class="de">Code für Deutsch (Schweiz)</div>
	 * <div class="fr">Code de Allemand (Suisse)</div>
	 * <div class="it">Code per Tedesco (Svizzera)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GERMAN_SWITZERLAND_CODE = "de-CH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Greek</div>
	 * <div class="de">Code für Griechisch</div>
	 * <div class="fr">Code de Grec</div>
	 * <div class="it">Code per Greco</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GREEK_CODE = "el";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hindi</div>
	 * <div class="de">Code für Hindi</div>
	 * <div class="fr">Code de Hindi</div>
	 * <div class="it">Code per Hindi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HINDI_CODE = "hi";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Italian</div>
	 * <div class="de">Code für Italienisch</div>
	 * <div class="fr">Code de Italien</div>
	 * <div class="it">Code per Italiano</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ITALIAN_CODE = "it";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Italian (Italy)</div>
	 * <div class="de">Code für Italienisch (Italien)</div>
	 * <div class="fr">Code de Italien (Italie)</div>
	 * <div class="it">Code per Italiano (Italia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ITALIAN_ITALY_CODE = "it-IT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Italian (Switzerland)</div>
	 * <div class="de">Code für Italienisch (Schweiz)</div>
	 * <div class="fr">Code de Italien (Suisse)</div>
	 * <div class="it">Code per Italiano (Svizzera)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ITALIAN_SWITZERLAND_CODE = "it-CH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Japanese</div>
	 * <div class="de">Code für Japanisch</div>
	 * <div class="fr">Code de Japonais</div>
	 * <div class="it">Code per Giapponese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JAPANESE_CODE = "ja";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Korean</div>
	 * <div class="de">Code für Koreanisch</div>
	 * <div class="fr">Code de Coréen</div>
	 * <div class="it">Code per Coreano</div>
	 * <!-- @formatter:on -->
	 */
	public static final String KOREAN_CODE = "ko";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Norwegian</div>
	 * <div class="de">Code für Norwegisch</div>
	 * <div class="fr">Code de Norvégien</div>
	 * <div class="it">Code per Norvegese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NORWEGIAN_CODE = "no";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Norwegian (Norway)</div>
	 * <div class="de">Code für Norwegisch (Norwegen)</div>
	 * <div class="fr">Code de Norvégien (Norvège)</div>
	 * <div class="it">Code per Norvegese (Norvegia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NORWEGIAN_NORWAY_CODE = "no-NO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Other language</div>
	 * <div class="de">Code für Andere Sprache</div>
	 * <div class="fr">Code de Autre langue</div>
	 * <div class="it">Code per Altra lingua</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_LANGUAGE_CODE = "OTHER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Polish</div>
	 * <div class="de">Code für Polnisch</div>
	 * <div class="fr">Code de Polonais</div>
	 * <div class="it">Code per Polacco</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POLISH_CODE = "pl";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Portuguese</div>
	 * <div class="de">Code für Portugiesisch</div>
	 * <div class="fr">Code de Portugais</div>
	 * <div class="it">Code per Portoghese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PORTUGUESE_CODE = "pt";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Portuguese (Brazil)</div>
	 * <div class="de">Code für Portugiesisch (Brasilien)</div>
	 * <div class="fr">Code de Portugais (Brésil)</div>
	 * <div class="it">Code per Portoghese (Brasile)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PORTUGUESE_BRAZIL_CODE = "pt-BR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Punjabi</div>
	 * <div class="de">Code für Panjabi</div>
	 * <div class="fr">Code de Panjabi</div>
	 * <div class="it">Code per Panjabi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PUNJABI_CODE = "pa";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Romansh</div>
	 * <div class="de">Code für Rätoromanisch</div>
	 * <div class="fr">Code de Rhéto-roman</div>
	 * <div class="it">Code per Romancio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROMANSH_CODE = "rm";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Russian</div>
	 * <div class="de">Code für Russisch</div>
	 * <div class="fr">Code de Russe</div>
	 * <div class="it">Code per Russo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RUSSIAN_CODE = "ru";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Russian (Russia)</div>
	 * <div class="de">Code für Russisch (Russland)</div>
	 * <div class="fr">Code de Russe (Russie)</div>
	 * <div class="it">Code per Russo (Russia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RUSSIAN_RUSSIA_CODE = "ru-RU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Serbian</div>
	 * <div class="de">Code für Serbisch</div>
	 * <div class="fr">Code de Serbe</div>
	 * <div class="it">Code per Serbo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SERBIAN_CODE = "sr";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Serbian (Serbia)</div>
	 * <div class="de">Code für Serbisch (Serbien)</div>
	 * <div class="fr">Code de Serbe (Serbie)</div>
	 * <div class="it">Code per Serbo (Serbia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SERBIAN_SERBIA_CODE = "sr-RS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Spanish</div>
	 * <div class="de">Code für Spanisch</div>
	 * <div class="fr">Code de Espagnol</div>
	 * <div class="it">Code per Spagnolo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPANISH_CODE = "es";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Spanish (Argentina)</div>
	 * <div class="de">Code für Spanisch (Argentinien)</div>
	 * <div class="fr">Code de Espagnol (Argentine)</div>
	 * <div class="it">Code per Spagnolo (Argentina)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPANISH_ARGENTINA_CODE = "es-AR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Spanish (Spain)</div>
	 * <div class="de">Code für Spanisch (Spanien)</div>
	 * <div class="fr">Code de Espagnol (Espagne)</div>
	 * <div class="it">Code per Spagnolo (Spagna)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPANISH_SPAIN_CODE = "es-ES";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Spanish (Uruguay)</div>
	 * <div class="de">Code für Spanisch (Uruguay)</div>
	 * <div class="fr">Code de Espagnol (Uruguay)</div>
	 * <div class="it">Code per Spagnolo (Uruguay)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPANISH_URUGUAY_CODE = "es-UY";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swedish</div>
	 * <div class="de">Code für Schwedisch</div>
	 * <div class="fr">Code de Suédois</div>
	 * <div class="it">Code per Svedese</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWEDISH_CODE = "sv";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Swedish (Sweden)</div>
	 * <div class="de">Code für Schwedisch (Schweden)</div>
	 * <div class="fr">Code de Suédois (Suède)</div>
	 * <div class="it">Code per Svedese (Svezia)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SWEDISH_SWEDEN_CODE = "sv-SE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Telegu</div>
	 * <div class="de">Code für Telugu</div>
	 * <div class="fr">Code de Telugu</div>
	 * <div class="it">Code per Telugu</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TELEGU_CODE = "te";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.13";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.languageCode";

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
	public static DocumentLanguage getEnum(final String code) {
		for (final DocumentLanguage x : values()) {
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
			Enum.valueOf(DocumentLanguage.class, enumName);
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
		for (final DocumentLanguage x : values()) {
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
	DocumentLanguage(final String code, final String codeSystem, final String displayName,
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
