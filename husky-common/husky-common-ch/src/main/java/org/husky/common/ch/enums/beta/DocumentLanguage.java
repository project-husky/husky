/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.ch.enums.beta;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.languageCode values
 * <p>
 * EN: Document language as per Annex 3 EPRO-FDHA. Defines the language in which the document was written.<br>
 * DE: Sprache des Dokumentes gemäss Anhang 3 EPDV-EDI. Definiert die Sprache in welcher das Dokument verfasst wurde.<br>
 * FR: Langue du document selon l'annexe 3 ODEP-DFI. Définit la langue dans laquelle est rédigé le document.<br>
 * IT: Lingua del documento secondo l'allegato 3 OCIP-DFI. Definisce la lingua nella quale è stato redatto il documento.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.13<br>
 * Effective date: 2021-04-01 17:03<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-09-29")
public enum DocumentLanguage implements ValueSetEnumInterface {

    /**
     * EN: Arabic.<br>
     * DE: Arabisch.<br>
     * FR: Arabe.<br>
     * IT: Arabo.<br>
     */
    ARABIC("ar",
           "2.16.840.1.113883.6.316",
           "Arabic",
           "Arabic",
           "Arabisch",
           "Arabe",
           "Arabo"),
    /**
     * EN: Bengali.<br>
     * DE: Bengalisch.<br>
     * FR: Bengali.<br>
     * IT: Bengalese.<br>
     */
    BENGALI("bn",
            "2.16.840.1.113883.6.316",
            "Bengali",
            "Bengali",
            "Bengalisch",
            "Bengali",
            "Bengalese"),
    /**
     * EN: Chinese.<br>
     * DE: Chinesisch.<br>
     * FR: Chinois.<br>
     * IT: Cinese.<br>
     */
    CHINESE("zh",
            "2.16.840.1.113883.6.316",
            "Chinese",
            "Chinese",
            "Chinesisch",
            "Chinois",
            "Cinese"),
    /**
     * EN: Chinese (China).<br>
     * DE: Chinesisch (China).<br>
     * FR: Chinois (Chine).<br>
     * IT: Cinese (Cina).<br>
     */
    CHINESE_CHINA("zh-CN",
                  "2.16.840.1.113883.6.316",
                  "Chinese (China)",
                  "Chinese (China)",
                  "Chinesisch (China)",
                  "Chinois (Chine)",
                  "Cinese (Cina)"),
    /**
     * EN: Chinese (Hong Kong).<br>
     * DE: Chinesisch (Hong Kong).<br>
     * FR: Chinois (Hong Kong).<br>
     * IT: Cinese (Hong Kong).<br>
     */
    CHINESE_HONG_KONG("zh-HK",
                      "2.16.840.1.113883.6.316",
                      "Chinese (Hong Kong)",
                      "Chinese (Hong Kong)",
                      "Chinesisch (Hong Kong)",
                      "Chinois (Hong Kong)",
                      "Cinese (Hong Kong)"),
    /**
     * EN: Chinese (Singapore).<br>
     * DE: Chinesisch (Singapur).<br>
     * FR: Chinois (Singapour).<br>
     * IT: Cinese (Singapore).<br>
     */
    CHINESE_SINGAPORE("zh-SG",
                      "2.16.840.1.113883.6.316",
                      "Chinese (Singapore)",
                      "Chinese (Singapore)",
                      "Chinesisch (Singapur)",
                      "Chinois (Singapour)",
                      "Cinese (Singapore)"),
    /**
     * EN: Chinese (Taiwan).<br>
     * DE: Chinesisch (Taiwan).<br>
     * FR: Chinois (Taïwan).<br>
     * IT: Cinese (Taiwan).<br>
     */
    CHINESE_TAIWAN("zh-TW",
                   "2.16.840.1.113883.6.316",
                   "Chinese (Taiwan)",
                   "Chinese (Taiwan)",
                   "Chinesisch (Taiwan)",
                   "Chinois (Taïwan)",
                   "Cinese (Taiwan)"),
    /**
     * EN: Croatian.<br>
     * DE: Kroatisch.<br>
     * FR: Croate.<br>
     * IT: Croato.<br>
     */
    CROATIAN("hr",
             "2.16.840.1.113883.6.316",
             "Croatian",
             "Croatian",
             "Kroatisch",
             "Croate",
             "Croato"),
    /**
     * EN: Czech.<br>
     * DE: Tschechisch.<br>
     * FR: Tchèque.<br>
     * IT: Ceco.<br>
     */
    CZECH("cs",
          "2.16.840.1.113883.6.316",
          "Czech",
          "Czech",
          "Tschechisch",
          "Tchèque",
          "Ceco"),
    /**
     * EN: Danish.<br>
     * DE: Dänisch.<br>
     * FR: Danois.<br>
     * IT: Danese.<br>
     */
    DANISH("da",
           "2.16.840.1.113883.6.316",
           "Danish",
           "Danish",
           "Dänisch",
           "Danois",
           "Danese"),
    /**
     * EN: Dutch.<br>
     * DE: Niederländisch.<br>
     * FR: Néerlandais.<br>
     * IT: Olandese.<br>
     */
    DUTCH("nl",
          "2.16.840.1.113883.6.316",
          "Dutch",
          "Dutch",
          "Niederländisch",
          "Néerlandais",
          "Olandese"),
    /**
     * EN: Dutch (Belgium).<br>
     * DE: Niederländisch (Belgien).<br>
     * FR: Néerlandais (Belgique).<br>
     * IT: Olandese (Belgio).<br>
     */
    DUTCH_BELGIUM("nl-BE",
                  "2.16.840.1.113883.6.316",
                  "Dutch (Belgium)",
                  "Dutch (Belgium)",
                  "Niederländisch (Belgien)",
                  "Néerlandais (Belgique)",
                  "Olandese (Belgio)"),
    /**
     * EN: Dutch (Netherlands).<br>
     * DE: Niederländisch (Niederlande).<br>
     * FR: Néerlandais (Pays-Bas).<br>
     * IT: Olandese (Paesi Bassi).<br>
     */
    DUTCH_NETHERLANDS("nl-NL",
                      "2.16.840.1.113883.6.316",
                      "Dutch (Netherlands)",
                      "Dutch (Netherlands)",
                      "Niederländisch (Niederlande)",
                      "Néerlandais (Pays-Bas)",
                      "Olandese (Paesi Bassi)"),
    /**
     * EN: English.<br>
     * DE: Englisch.<br>
     * FR: Anglais.<br>
     * IT: Inglese.<br>
     */
    ENGLISH("en",
            "2.16.840.1.113883.6.316",
            "English",
            "English",
            "Englisch",
            "Anglais",
            "Inglese"),
    /**
     * EN: English (Australia).<br>
     * DE: Englisch (Australien).<br>
     * FR: Anglais (Australie).<br>
     * IT: Inglese (Australia).<br>
     */
    ENGLISH_AUSTRALIA("en-AU",
                      "2.16.840.1.113883.6.316",
                      "English (Australia)",
                      "English (Australia)",
                      "Englisch (Australien)",
                      "Anglais (Australie)",
                      "Inglese (Australia)"),
    /**
     * EN: English (Canada).<br>
     * DE: Englisch (Kanada).<br>
     * FR: Anglais (Canada).<br>
     * IT: Inglese (Canada).<br>
     */
    ENGLISH_CANADA("en-CA",
                   "2.16.840.1.113883.6.316",
                   "English (Canada)",
                   "English (Canada)",
                   "Englisch (Kanada)",
                   "Anglais (Canada)",
                   "Inglese (Canada)"),
    /**
     * EN: English (Great Britain).<br>
     * DE: Englisch (Grossbritannien).<br>
     * FR: Anglais (Grande Bretagne).<br>
     * IT: Inglese (Gran Bretagna).<br>
     */
    ENGLISH_GREAT_BRITAIN("en-GB",
                          "2.16.840.1.113883.6.316",
                          "English (Great Britain)",
                          "English (Great Britain)",
                          "Englisch (Grossbritannien)",
                          "Anglais (Grande Bretagne)",
                          "Inglese (Gran Bretagna)"),
    /**
     * EN: English (India).<br>
     * DE: Englisch (Indien).<br>
     * FR: Anglais (Inde).<br>
     * IT: Inglese (India).<br>
     */
    ENGLISH_INDIA("en-IN",
                  "2.16.840.1.113883.6.316",
                  "English (India)",
                  "English (India)",
                  "Englisch (Indien)",
                  "Anglais (Inde)",
                  "Inglese (India)"),
    /**
     * EN: English (New Zealand).<br>
     * DE: Englisch (Neuseeland).<br>
     * FR: Anglais (Nouvelle Zélande).<br>
     * IT: Inglese (Nuova Zelanda).<br>
     */
    ENGLISH_NEW_ZEALAND("en-NZ",
                        "2.16.840.1.113883.6.316",
                        "English (New Zealand)",
                        "English (New Zealand)",
                        "Englisch (Neuseeland)",
                        "Anglais (Nouvelle Zélande)",
                        "Inglese (Nuova Zelanda)"),
    /**
     * EN: English (Singapore).<br>
     * DE: Englisch (Singapur).<br>
     * FR: Anglais (Singapour).<br>
     * IT: Inglese (Singapore).<br>
     */
    ENGLISH_SINGAPORE("en-SG",
                      "2.16.840.1.113883.6.316",
                      "English (Singapore)",
                      "English (Singapore)",
                      "Englisch (Singapur)",
                      "Anglais (Singapour)",
                      "Inglese (Singapore)"),
    /**
     * EN: English (United States).<br>
     * DE: Englisch (USA).<br>
     * FR: Anglais (États Unis).<br>
     * IT: Inglese (Stati Uniti).<br>
     */
    ENGLISH_UNITED_STATES("en-US",
                          "2.16.840.1.113883.6.316",
                          "English (United States)",
                          "English (United States)",
                          "Englisch (USA)",
                          "Anglais (États Unis)",
                          "Inglese (Stati Uniti)"),
    /**
     * EN: Finnish.<br>
     * DE: Finnisch.<br>
     * FR: Finnois.<br>
     * IT: Finlandese.<br>
     */
    FINNISH("fi",
            "2.16.840.1.113883.6.316",
            "Finnish",
            "Finnish",
            "Finnisch",
            "Finnois",
            "Finlandese"),
    /**
     * EN: French.<br>
     * DE: Französisch.<br>
     * FR: Français.<br>
     * IT: Francese.<br>
     */
    FRENCH("fr",
           "2.16.840.1.113883.6.316",
           "French",
           "French",
           "Französisch",
           "Français",
           "Francese"),
    /**
     * EN: French (Belgium).<br>
     * DE: Französisch (Belgien).<br>
     * FR: Français (Belgique).<br>
     * IT: Francese (Belgio).<br>
     */
    FRENCH_BELGIUM("fr-BE",
                   "2.16.840.1.113883.6.316",
                   "French (Belgium)",
                   "French (Belgium)",
                   "Französisch (Belgien)",
                   "Français (Belgique)",
                   "Francese (Belgio)"),
    /**
     * EN: French (France).<br>
     * DE: Französisch (Frankreich).<br>
     * FR: Français (France).<br>
     * IT: Francese (Francia).<br>
     */
    FRENCH_FRANCE("fr-FR",
                  "2.16.840.1.113883.6.316",
                  "French (France)",
                  "French (France)",
                  "Französisch (Frankreich)",
                  "Français (France)",
                  "Francese (Francia)"),
    /**
     * EN: French (Switzerland).<br>
     * DE: Französisch (Schweiz).<br>
     * FR: Français (Suisse).<br>
     * IT: Francese (Svizzera).<br>
     */
    FRENCH_SWITZERLAND("fr-CH",
                       "2.16.840.1.113883.6.316",
                       "French (Switzerland)",
                       "French (Switzerland)",
                       "Französisch (Schweiz)",
                       "Français (Suisse)",
                       "Francese (Svizzera)"),
    /**
     * EN: Frysian.<br>
     * DE: Friesisch.<br>
     * FR: Frison.<br>
     * IT: Frisone.<br>
     */
    FRYSIAN("fy",
            "2.16.840.1.113883.6.316",
            "Frysian",
            "Frysian",
            "Friesisch",
            "Frison",
            "Frisone"),
    /**
     * EN: Frysian (Netherlands).<br>
     * DE: Friesisch (Niederlande).<br>
     * FR: Frison (Pays-Bas).<br>
     * IT: Frisone (Paesi Bassi).<br>
     */
    FRYSIAN_NETHERLANDS("fy-NL",
                        "2.16.840.1.113883.6.316",
                        "Frysian (Netherlands)",
                        "Frysian (Netherlands)",
                        "Friesisch (Niederlande)",
                        "Frison (Pays-Bas)",
                        "Frisone (Paesi Bassi)"),
    /**
     * EN: German.<br>
     * DE: Deutsch.<br>
     * FR: Allemand.<br>
     * IT: Tedesco.<br>
     */
    GERMAN("de",
           "2.16.840.1.113883.6.316",
           "German",
           "German",
           "Deutsch",
           "Allemand",
           "Tedesco"),
    /**
     * EN: German (Austria).<br>
     * DE: Deutsch (Österreich).<br>
     * FR: Allemand (Autriche).<br>
     * IT: Tedesco (Austria).<br>
     */
    GERMAN_AUSTRIA("de-AT",
                   "2.16.840.1.113883.6.316",
                   "German (Austria)",
                   "German (Austria)",
                   "Deutsch (Österreich)",
                   "Allemand (Autriche)",
                   "Tedesco (Austria)"),
    /**
     * EN: German (Germany).<br>
     * DE: Deutsch (Deutschland).<br>
     * FR: Allemand (Allemagne).<br>
     * IT: Tedesco (Germania).<br>
     */
    GERMAN_GERMANY("de-DE",
                   "2.16.840.1.113883.6.316",
                   "German (Germany)",
                   "German (Germany)",
                   "Deutsch (Deutschland)",
                   "Allemand (Allemagne)",
                   "Tedesco (Germania)"),
    /**
     * EN: German (Switzerland).<br>
     * DE: Deutsch (Schweiz).<br>
     * FR: Allemand (Suisse).<br>
     * IT: Tedesco (Svizzera).<br>
     */
    GERMAN_SWITZERLAND("de-CH",
                       "2.16.840.1.113883.6.316",
                       "German (Switzerland)",
                       "German (Switzerland)",
                       "Deutsch (Schweiz)",
                       "Allemand (Suisse)",
                       "Tedesco (Svizzera)"),
    /**
     * EN: Greek.<br>
     * DE: Griechisch.<br>
     * FR: Grec.<br>
     * IT: Greco.<br>
     */
    GREEK("el",
          "2.16.840.1.113883.6.316",
          "Greek",
          "Greek",
          "Griechisch",
          "Grec",
          "Greco"),
    /**
     * EN: Hindi.<br>
     * DE: Hindi.<br>
     * FR: Hindi.<br>
     * IT: Hindi.<br>
     */
    HINDI("hi",
          "2.16.840.1.113883.6.316",
          "Hindi",
          "Hindi",
          "Hindi",
          "Hindi",
          "Hindi"),
    /**
     * EN: Italian.<br>
     * DE: Italienisch.<br>
     * FR: Italien.<br>
     * IT: Italiano.<br>
     */
    ITALIAN("it",
            "2.16.840.1.113883.6.316",
            "Italian",
            "Italian",
            "Italienisch",
            "Italien",
            "Italiano"),
    /**
     * EN: Italian (Italy).<br>
     * DE: Italienisch (Italien).<br>
     * FR: Italien (Italie).<br>
     * IT: Italiano (Italia).<br>
     */
    ITALIAN_ITALY("it-IT",
                  "2.16.840.1.113883.6.316",
                  "Italian (Italy)",
                  "Italian (Italy)",
                  "Italienisch (Italien)",
                  "Italien (Italie)",
                  "Italiano (Italia)"),
    /**
     * EN: Italian (Switzerland).<br>
     * DE: Italienisch (Schweiz).<br>
     * FR: Italien (Suisse).<br>
     * IT: Italiano (Svizzera).<br>
     */
    ITALIAN_SWITZERLAND("it-CH",
                        "2.16.840.1.113883.6.316",
                        "Italian (Switzerland)",
                        "Italian (Switzerland)",
                        "Italienisch (Schweiz)",
                        "Italien (Suisse)",
                        "Italiano (Svizzera)"),
    /**
     * EN: Japanese.<br>
     * DE: Japanisch.<br>
     * FR: Japonais.<br>
     * IT: Giapponese.<br>
     */
    JAPANESE("ja",
             "2.16.840.1.113883.6.316",
             "Japanese",
             "Japanese",
             "Japanisch",
             "Japonais",
             "Giapponese"),
    /**
     * EN: Korean.<br>
     * DE: Koreanisch.<br>
     * FR: Coréen.<br>
     * IT: Coreano.<br>
     */
    KOREAN("ko",
           "2.16.840.1.113883.6.316",
           "Korean",
           "Korean",
           "Koreanisch",
           "Coréen",
           "Coreano"),
    /**
     * EN: Norwegian.<br>
     * DE: Norwegisch.<br>
     * FR: Norvégien.<br>
     * IT: Norvegese.<br>
     */
    NORWEGIAN("no",
              "2.16.840.1.113883.6.316",
              "Norwegian",
              "Norwegian",
              "Norwegisch",
              "Norvégien",
              "Norvegese"),
    /**
     * EN: Norwegian (Norway).<br>
     * DE: Norwegisch (Norwegen).<br>
     * FR: Norvégien (Norvège).<br>
     * IT: Norvegese (Norvegia).<br>
     */
    NORWEGIAN_NORWAY("no-NO",
                     "2.16.840.1.113883.6.316",
                     "Norwegian (Norway)",
                     "Norwegian (Norway)",
                     "Norwegisch (Norwegen)",
                     "Norvégien (Norvège)",
                     "Norvegese (Norvegia)"),
    /**
     * EN: Other language.<br>
     * DE: Andere Sprache.<br>
     * FR: Autre langue.<br>
     * IT: Altra lingua.<br>
     */
    OTHER_LANGUAGE("OTHER",
                   "2.16.756.5.30.1.127.3.10.12",
                   "Other language",
                   "Other language",
                   "Andere Sprache",
                   "Autre langue",
                   "Altra lingua"),
    /**
     * EN: Polish.<br>
     * DE: Polnisch.<br>
     * FR: Polonais.<br>
     * IT: Polacco.<br>
     */
    POLISH("pl",
           "2.16.840.1.113883.6.316",
           "Polish",
           "Polish",
           "Polnisch",
           "Polonais",
           "Polacco"),
    /**
     * EN: Portuguese.<br>
     * DE: Portugiesisch.<br>
     * FR: Portugais.<br>
     * IT: Portoghese.<br>
     */
    PORTUGUESE("pt",
               "2.16.840.1.113883.6.316",
               "Portuguese",
               "Portuguese",
               "Portugiesisch",
               "Portugais",
               "Portoghese"),
    /**
     * EN: Portuguese (Brazil).<br>
     * DE: Portugiesisch (Brasilien).<br>
     * FR: Portugais (Brésil).<br>
     * IT: Portoghese (Brasile).<br>
     */
    PORTUGUESE_BRAZIL("pt-BR",
                      "2.16.840.1.113883.6.316",
                      "Portuguese (Brazil)",
                      "Portuguese (Brazil)",
                      "Portugiesisch (Brasilien)",
                      "Portugais (Brésil)",
                      "Portoghese (Brasile)"),
    /**
     * EN: Punjabi.<br>
     * DE: Panjabi.<br>
     * FR: Panjabi.<br>
     * IT: Panjabi.<br>
     */
    PUNJABI("pa",
            "2.16.840.1.113883.6.316",
            "Punjabi",
            "Punjabi",
            "Panjabi",
            "Panjabi",
            "Panjabi"),
    /**
     * EN: Romansh.<br>
     * DE: Rätoromanisch.<br>
     * FR: Rhéto-roman.<br>
     * IT: Romancio.<br>
     */
    ROMANSH("rm",
            "2.16.840.1.113883.6.316",
            "Romansh",
            "Romansh",
            "Rätoromanisch",
            "Rhéto-roman",
            "Romancio"),
    /**
     * EN: Russian.<br>
     * DE: Russisch.<br>
     * FR: Russe.<br>
     * IT: Russo.<br>
     */
    RUSSIAN("ru",
            "2.16.840.1.113883.6.316",
            "Russian",
            "Russian",
            "Russisch",
            "Russe",
            "Russo"),
    /**
     * EN: Russian (Russia).<br>
     * DE: Russisch (Russland).<br>
     * FR: Russe (Russie).<br>
     * IT: Russo (Russia).<br>
     */
    RUSSIAN_RUSSIA("ru-RU",
                   "2.16.840.1.113883.6.316",
                   "Russian (Russia)",
                   "Russian (Russia)",
                   "Russisch (Russland)",
                   "Russe (Russie)",
                   "Russo (Russia)"),
    /**
     * EN: Serbian.<br>
     * DE: Serbisch.<br>
     * FR: Serbe.<br>
     * IT: Serbo.<br>
     */
    SERBIAN("sr",
            "2.16.840.1.113883.6.316",
            "Serbian",
            "Serbian",
            "Serbisch",
            "Serbe",
            "Serbo"),
    /**
     * EN: Serbian (Serbia).<br>
     * DE: Serbisch (Serbien).<br>
     * FR: Serbe (Serbie).<br>
     * IT: Serbo (Serbia).<br>
     */
    SERBIAN_SERBIA("sr-RS",
                   "2.16.840.1.113883.6.316",
                   "Serbian (Serbia)",
                   "Serbian (Serbia)",
                   "Serbisch (Serbien)",
                   "Serbe (Serbie)",
                   "Serbo (Serbia)"),
    /**
     * EN: Spanish.<br>
     * DE: Spanisch.<br>
     * FR: Espagnol.<br>
     * IT: Spagnolo.<br>
     */
    SPANISH("es",
            "2.16.840.1.113883.6.316",
            "Spanish",
            "Spanish",
            "Spanisch",
            "Espagnol",
            "Spagnolo"),
    /**
     * EN: Spanish (Argentina).<br>
     * DE: Spanisch (Argentinien).<br>
     * FR: Espagnol (Argentine).<br>
     * IT: Spagnolo (Argentina).<br>
     */
    SPANISH_ARGENTINA("es-AR",
                      "2.16.840.1.113883.6.316",
                      "Spanish (Argentina)",
                      "Spanish (Argentina)",
                      "Spanisch (Argentinien)",
                      "Espagnol (Argentine)",
                      "Spagnolo (Argentina)"),
    /**
     * EN: Spanish (Spain).<br>
     * DE: Spanisch (Spanien).<br>
     * FR: Espagnol (Espagne).<br>
     * IT: Spagnolo (Spagna).<br>
     */
    SPANISH_SPAIN("es-ES",
                  "2.16.840.1.113883.6.316",
                  "Spanish (Spain)",
                  "Spanish (Spain)",
                  "Spanisch (Spanien)",
                  "Espagnol (Espagne)",
                  "Spagnolo (Spagna)"),
    /**
     * EN: Spanish (Uruguay).<br>
     * DE: Spanisch (Uruguay).<br>
     * FR: Espagnol (Uruguay).<br>
     * IT: Spagnolo (Uruguay).<br>
     */
    SPANISH_URUGUAY("es-UY",
                    "2.16.840.1.113883.6.316",
                    "Spanish (Uruguay)",
                    "Spanish (Uruguay)",
                    "Spanisch (Uruguay)",
                    "Espagnol (Uruguay)",
                    "Spagnolo (Uruguay)"),
    /**
     * EN: Swedish.<br>
     * DE: Schwedisch.<br>
     * FR: Suédois.<br>
     * IT: Svedese.<br>
     */
    SWEDISH("sv",
            "2.16.840.1.113883.6.316",
            "Swedish",
            "Swedish",
            "Schwedisch",
            "Suédois",
            "Svedese"),
    /**
     * EN: Swedish (Sweden).<br>
     * DE: Schwedisch (Schweden).<br>
     * FR: Suédois (Suède).<br>
     * IT: Svedese (Svezia).<br>
     */
    SWEDISH_SWEDEN("sv-SE",
                   "2.16.840.1.113883.6.316",
                   "Swedish (Sweden)",
                   "Swedish (Sweden)",
                   "Schwedisch (Schweden)",
                   "Suédois (Suède)",
                   "Svedese (Svezia)"),
    /**
     * EN: Telegu.<br>
     * DE: Telugu.<br>
     * FR: Telugu.<br>
     * IT: Telugu.<br>
     */
    TELEGU("te",
           "2.16.840.1.113883.6.316",
           "Telegu",
           "Telegu",
           "Telugu",
           "Telugu",
           "Telugu");

    /**
     * EN: Code for Arabic.<br>
     * DE: Code für Arabisch.<br>
     * FR: Code de Arabe.<br>
     * IT: Code per Arabo.<br>
     */
    public static final String ARABIC_CODE = "ar";

    /**
     * EN: Code for Bengali.<br>
     * DE: Code für Bengalisch.<br>
     * FR: Code de Bengali.<br>
     * IT: Code per Bengalese.<br>
     */
    public static final String BENGALI_CODE = "bn";

    /**
     * EN: Code for Chinese.<br>
     * DE: Code für Chinesisch.<br>
     * FR: Code de Chinois.<br>
     * IT: Code per Cinese.<br>
     */
    public static final String CHINESE_CODE = "zh";

    /**
     * EN: Code for Chinese (China).<br>
     * DE: Code für Chinesisch (China).<br>
     * FR: Code de Chinois (Chine).<br>
     * IT: Code per Cinese (Cina).<br>
     */
    public static final String CHINESE_CHINA_CODE = "zh-CN";

    /**
     * EN: Code for Chinese (Hong Kong).<br>
     * DE: Code für Chinesisch (Hong Kong).<br>
     * FR: Code de Chinois (Hong Kong).<br>
     * IT: Code per Cinese (Hong Kong).<br>
     */
    public static final String CHINESE_HONG_KONG_CODE = "zh-HK";

    /**
     * EN: Code for Chinese (Singapore).<br>
     * DE: Code für Chinesisch (Singapur).<br>
     * FR: Code de Chinois (Singapour).<br>
     * IT: Code per Cinese (Singapore).<br>
     */
    public static final String CHINESE_SINGAPORE_CODE = "zh-SG";

    /**
     * EN: Code for Chinese (Taiwan).<br>
     * DE: Code für Chinesisch (Taiwan).<br>
     * FR: Code de Chinois (Taïwan).<br>
     * IT: Code per Cinese (Taiwan).<br>
     */
    public static final String CHINESE_TAIWAN_CODE = "zh-TW";

    /**
     * EN: Code for Croatian.<br>
     * DE: Code für Kroatisch.<br>
     * FR: Code de Croate.<br>
     * IT: Code per Croato.<br>
     */
    public static final String CROATIAN_CODE = "hr";

    /**
     * EN: Code for Czech.<br>
     * DE: Code für Tschechisch.<br>
     * FR: Code de Tchèque.<br>
     * IT: Code per Ceco.<br>
     */
    public static final String CZECH_CODE = "cs";

    /**
     * EN: Code for Danish.<br>
     * DE: Code für Dänisch.<br>
     * FR: Code de Danois.<br>
     * IT: Code per Danese.<br>
     */
    public static final String DANISH_CODE = "da";

    /**
     * EN: Code for Dutch.<br>
     * DE: Code für Niederländisch.<br>
     * FR: Code de Néerlandais.<br>
     * IT: Code per Olandese.<br>
     */
    public static final String DUTCH_CODE = "nl";

    /**
     * EN: Code for Dutch (Belgium).<br>
     * DE: Code für Niederländisch (Belgien).<br>
     * FR: Code de Néerlandais (Belgique).<br>
     * IT: Code per Olandese (Belgio).<br>
     */
    public static final String DUTCH_BELGIUM_CODE = "nl-BE";

    /**
     * EN: Code for Dutch (Netherlands).<br>
     * DE: Code für Niederländisch (Niederlande).<br>
     * FR: Code de Néerlandais (Pays-Bas).<br>
     * IT: Code per Olandese (Paesi Bassi).<br>
     */
    public static final String DUTCH_NETHERLANDS_CODE = "nl-NL";

    /**
     * EN: Code for English.<br>
     * DE: Code für Englisch.<br>
     * FR: Code de Anglais.<br>
     * IT: Code per Inglese.<br>
     */
    public static final String ENGLISH_CODE = "en";

    /**
     * EN: Code for English (Australia).<br>
     * DE: Code für Englisch (Australien).<br>
     * FR: Code de Anglais (Australie).<br>
     * IT: Code per Inglese (Australia).<br>
     */
    public static final String ENGLISH_AUSTRALIA_CODE = "en-AU";

    /**
     * EN: Code for English (Canada).<br>
     * DE: Code für Englisch (Kanada).<br>
     * FR: Code de Anglais (Canada).<br>
     * IT: Code per Inglese (Canada).<br>
     */
    public static final String ENGLISH_CANADA_CODE = "en-CA";

    /**
     * EN: Code for English (Great Britain).<br>
     * DE: Code für Englisch (Grossbritannien).<br>
     * FR: Code de Anglais (Grande Bretagne).<br>
     * IT: Code per Inglese (Gran Bretagna).<br>
     */
    public static final String ENGLISH_GREAT_BRITAIN_CODE = "en-GB";

    /**
     * EN: Code for English (India).<br>
     * DE: Code für Englisch (Indien).<br>
     * FR: Code de Anglais (Inde).<br>
     * IT: Code per Inglese (India).<br>
     */
    public static final String ENGLISH_INDIA_CODE = "en-IN";

    /**
     * EN: Code for English (New Zealand).<br>
     * DE: Code für Englisch (Neuseeland).<br>
     * FR: Code de Anglais (Nouvelle Zélande).<br>
     * IT: Code per Inglese (Nuova Zelanda).<br>
     */
    public static final String ENGLISH_NEW_ZEALAND_CODE = "en-NZ";

    /**
     * EN: Code for English (Singapore).<br>
     * DE: Code für Englisch (Singapur).<br>
     * FR: Code de Anglais (Singapour).<br>
     * IT: Code per Inglese (Singapore).<br>
     */
    public static final String ENGLISH_SINGAPORE_CODE = "en-SG";

    /**
     * EN: Code for English (United States).<br>
     * DE: Code für Englisch (USA).<br>
     * FR: Code de Anglais (États Unis).<br>
     * IT: Code per Inglese (Stati Uniti).<br>
     */
    public static final String ENGLISH_UNITED_STATES_CODE = "en-US";

    /**
     * EN: Code for Finnish.<br>
     * DE: Code für Finnisch.<br>
     * FR: Code de Finnois.<br>
     * IT: Code per Finlandese.<br>
     */
    public static final String FINNISH_CODE = "fi";

    /**
     * EN: Code for French.<br>
     * DE: Code für Französisch.<br>
     * FR: Code de Français.<br>
     * IT: Code per Francese.<br>
     */
    public static final String FRENCH_CODE = "fr";

    /**
     * EN: Code for French (Belgium).<br>
     * DE: Code für Französisch (Belgien).<br>
     * FR: Code de Français (Belgique).<br>
     * IT: Code per Francese (Belgio).<br>
     */
    public static final String FRENCH_BELGIUM_CODE = "fr-BE";

    /**
     * EN: Code for French (France).<br>
     * DE: Code für Französisch (Frankreich).<br>
     * FR: Code de Français (France).<br>
     * IT: Code per Francese (Francia).<br>
     */
    public static final String FRENCH_FRANCE_CODE = "fr-FR";

    /**
     * EN: Code for French (Switzerland).<br>
     * DE: Code für Französisch (Schweiz).<br>
     * FR: Code de Français (Suisse).<br>
     * IT: Code per Francese (Svizzera).<br>
     */
    public static final String FRENCH_SWITZERLAND_CODE = "fr-CH";

    /**
     * EN: Code for Frysian.<br>
     * DE: Code für Friesisch.<br>
     * FR: Code de Frison.<br>
     * IT: Code per Frisone.<br>
     */
    public static final String FRYSIAN_CODE = "fy";

    /**
     * EN: Code for Frysian (Netherlands).<br>
     * DE: Code für Friesisch (Niederlande).<br>
     * FR: Code de Frison (Pays-Bas).<br>
     * IT: Code per Frisone (Paesi Bassi).<br>
     */
    public static final String FRYSIAN_NETHERLANDS_CODE = "fy-NL";

    /**
     * EN: Code for German.<br>
     * DE: Code für Deutsch.<br>
     * FR: Code de Allemand.<br>
     * IT: Code per Tedesco.<br>
     */
    public static final String GERMAN_CODE = "de";

    /**
     * EN: Code for German (Austria).<br>
     * DE: Code für Deutsch (Österreich).<br>
     * FR: Code de Allemand (Autriche).<br>
     * IT: Code per Tedesco (Austria).<br>
     */
    public static final String GERMAN_AUSTRIA_CODE = "de-AT";

    /**
     * EN: Code for German (Germany).<br>
     * DE: Code für Deutsch (Deutschland).<br>
     * FR: Code de Allemand (Allemagne).<br>
     * IT: Code per Tedesco (Germania).<br>
     */
    public static final String GERMAN_GERMANY_CODE = "de-DE";

    /**
     * EN: Code for German (Switzerland).<br>
     * DE: Code für Deutsch (Schweiz).<br>
     * FR: Code de Allemand (Suisse).<br>
     * IT: Code per Tedesco (Svizzera).<br>
     */
    public static final String GERMAN_SWITZERLAND_CODE = "de-CH";

    /**
     * EN: Code for Greek.<br>
     * DE: Code für Griechisch.<br>
     * FR: Code de Grec.<br>
     * IT: Code per Greco.<br>
     */
    public static final String GREEK_CODE = "el";

    /**
     * EN: Code for Hindi.<br>
     * DE: Code für Hindi.<br>
     * FR: Code de Hindi.<br>
     * IT: Code per Hindi.<br>
     */
    public static final String HINDI_CODE = "hi";

    /**
     * EN: Code for Italian.<br>
     * DE: Code für Italienisch.<br>
     * FR: Code de Italien.<br>
     * IT: Code per Italiano.<br>
     */
    public static final String ITALIAN_CODE = "it";

    /**
     * EN: Code for Italian (Italy).<br>
     * DE: Code für Italienisch (Italien).<br>
     * FR: Code de Italien (Italie).<br>
     * IT: Code per Italiano (Italia).<br>
     */
    public static final String ITALIAN_ITALY_CODE = "it-IT";

    /**
     * EN: Code for Italian (Switzerland).<br>
     * DE: Code für Italienisch (Schweiz).<br>
     * FR: Code de Italien (Suisse).<br>
     * IT: Code per Italiano (Svizzera).<br>
     */
    public static final String ITALIAN_SWITZERLAND_CODE = "it-CH";

    /**
     * EN: Code for Japanese.<br>
     * DE: Code für Japanisch.<br>
     * FR: Code de Japonais.<br>
     * IT: Code per Giapponese.<br>
     */
    public static final String JAPANESE_CODE = "ja";

    /**
     * EN: Code for Korean.<br>
     * DE: Code für Koreanisch.<br>
     * FR: Code de Coréen.<br>
     * IT: Code per Coreano.<br>
     */
    public static final String KOREAN_CODE = "ko";

    /**
     * EN: Code for Norwegian.<br>
     * DE: Code für Norwegisch.<br>
     * FR: Code de Norvégien.<br>
     * IT: Code per Norvegese.<br>
     */
    public static final String NORWEGIAN_CODE = "no";

    /**
     * EN: Code for Norwegian (Norway).<br>
     * DE: Code für Norwegisch (Norwegen).<br>
     * FR: Code de Norvégien (Norvège).<br>
     * IT: Code per Norvegese (Norvegia).<br>
     */
    public static final String NORWEGIAN_NORWAY_CODE = "no-NO";

    /**
     * EN: Code for Other language.<br>
     * DE: Code für Andere Sprache.<br>
     * FR: Code de Autre langue.<br>
     * IT: Code per Altra lingua.<br>
     */
    public static final String OTHER_LANGUAGE_CODE = "OTHER";

    /**
     * EN: Code for Polish.<br>
     * DE: Code für Polnisch.<br>
     * FR: Code de Polonais.<br>
     * IT: Code per Polacco.<br>
     */
    public static final String POLISH_CODE = "pl";

    /**
     * EN: Code for Portuguese.<br>
     * DE: Code für Portugiesisch.<br>
     * FR: Code de Portugais.<br>
     * IT: Code per Portoghese.<br>
     */
    public static final String PORTUGUESE_CODE = "pt";

    /**
     * EN: Code for Portuguese (Brazil).<br>
     * DE: Code für Portugiesisch (Brasilien).<br>
     * FR: Code de Portugais (Brésil).<br>
     * IT: Code per Portoghese (Brasile).<br>
     */
    public static final String PORTUGUESE_BRAZIL_CODE = "pt-BR";

    /**
     * EN: Code for Punjabi.<br>
     * DE: Code für Panjabi.<br>
     * FR: Code de Panjabi.<br>
     * IT: Code per Panjabi.<br>
     */
    public static final String PUNJABI_CODE = "pa";

    /**
     * EN: Code for Romansh.<br>
     * DE: Code für Rätoromanisch.<br>
     * FR: Code de Rhéto-roman.<br>
     * IT: Code per Romancio.<br>
     */
    public static final String ROMANSH_CODE = "rm";

    /**
     * EN: Code for Russian.<br>
     * DE: Code für Russisch.<br>
     * FR: Code de Russe.<br>
     * IT: Code per Russo.<br>
     */
    public static final String RUSSIAN_CODE = "ru";

    /**
     * EN: Code for Russian (Russia).<br>
     * DE: Code für Russisch (Russland).<br>
     * FR: Code de Russe (Russie).<br>
     * IT: Code per Russo (Russia).<br>
     */
    public static final String RUSSIAN_RUSSIA_CODE = "ru-RU";

    /**
     * EN: Code for Serbian.<br>
     * DE: Code für Serbisch.<br>
     * FR: Code de Serbe.<br>
     * IT: Code per Serbo.<br>
     */
    public static final String SERBIAN_CODE = "sr";

    /**
     * EN: Code for Serbian (Serbia).<br>
     * DE: Code für Serbisch (Serbien).<br>
     * FR: Code de Serbe (Serbie).<br>
     * IT: Code per Serbo (Serbia).<br>
     */
    public static final String SERBIAN_SERBIA_CODE = "sr-RS";

    /**
     * EN: Code for Spanish.<br>
     * DE: Code für Spanisch.<br>
     * FR: Code de Espagnol.<br>
     * IT: Code per Spagnolo.<br>
     */
    public static final String SPANISH_CODE = "es";

    /**
     * EN: Code for Spanish (Argentina).<br>
     * DE: Code für Spanisch (Argentinien).<br>
     * FR: Code de Espagnol (Argentine).<br>
     * IT: Code per Spagnolo (Argentina).<br>
     */
    public static final String SPANISH_ARGENTINA_CODE = "es-AR";

    /**
     * EN: Code for Spanish (Spain).<br>
     * DE: Code für Spanisch (Spanien).<br>
     * FR: Code de Espagnol (Espagne).<br>
     * IT: Code per Spagnolo (Spagna).<br>
     */
    public static final String SPANISH_SPAIN_CODE = "es-ES";

    /**
     * EN: Code for Spanish (Uruguay).<br>
     * DE: Code für Spanisch (Uruguay).<br>
     * FR: Code de Espagnol (Uruguay).<br>
     * IT: Code per Spagnolo (Uruguay).<br>
     */
    public static final String SPANISH_URUGUAY_CODE = "es-UY";

    /**
     * EN: Code for Swedish.<br>
     * DE: Code für Schwedisch.<br>
     * FR: Code de Suédois.<br>
     * IT: Code per Svedese.<br>
     */
    public static final String SWEDISH_CODE = "sv";

    /**
     * EN: Code for Swedish (Sweden).<br>
     * DE: Code für Schwedisch (Schweden).<br>
     * FR: Code de Suédois (Suède).<br>
     * IT: Code per Svedese (Svezia).<br>
     */
    public static final String SWEDISH_SWEDEN_CODE = "sv-SE";

    /**
     * EN: Code for Telegu.<br>
     * DE: Code für Telugu.<br>
     * FR: Code de Telugu.<br>
     * IT: Code per Telugu.<br>
     */
    public static final String TELEGU_CODE = "te";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.13";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.languageCode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static DocumentLanguage getEnum(@Nullable final String code) {
        for (final DocumentLanguage x : values()) {
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
    public static boolean isEnumOfValueSet(@Nullable final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(DocumentLanguage.class,
                         enumName);
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
    public static boolean isInValueSet(@Nullable final String codeValue) {
        for (final DocumentLanguage x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String codeSystem;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

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
    DocumentLanguage(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.codeSystem = Objects.requireNonNull(codeSystem);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
        final var codeSystem = CodeSystems.getEnum(this.codeSystem);
        if (codeSystem != null) {
            return codeSystem.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    @NonNull
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @Override
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch(languageCode) {
            case ENGLISH ->
                this.displayNames[1];
            case GERMAN ->
                this.displayNames[2];
            case FRENCH ->
                this.displayNames[3];
            case ITALIAN ->
                this.displayNames[4];
            default ->
                "TOTRANSLATE";
        };
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    @NonNull
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
