/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of eimpf-impfschema values
 * <p>
 * EN: Rules on vaccine doses for obtaining or refreshing (boosting) basic immunisation.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.5<br>
 * Effective date: 2025-10-19 15:43<br>
 * Version: 2.27.0+20251016<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2026-02-19")
public enum EimpfImpfschema implements ValueSetEnumInterface {

    /**
     * EN: Chikungunya.<br>
     */
    CHIKUNGUNYA("SCHEMA256",
                "1.2.40.0.34.5.183",
                "Chikungunya",
                "Chikungunya",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Cholera.<br>
     */
    CHOLERA("SCHEMA203",
            "1.2.40.0.34.5.183",
            "Cholera",
            "Cholera",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Cholera Grundschema, Erstimpfung 2-6 Jahre.<br>
     */
    CHOLERA_GRUNDSCHEMA_ERSTIMPFUNG_2_6_JAHRE("SCHEMA076",
                                              "1.2.40.0.34.5.183",
                                              "Cholera Grundschema, Erstimpfung 2-6 Jahre",
                                              "Cholera Grundschema, Erstimpfung 2-6 Jahre",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: Cholera Grundschema, Erstimpfung ab 6 Jahren.<br>
     */
    CHOLERA_GRUNDSCHEMA_ERSTIMPFUNG_AB_6_JAHREN("SCHEMA078",
                                                "1.2.40.0.34.5.183",
                                                "Cholera Grundschema, Erstimpfung ab 6 Jahren",
                                                "Cholera Grundschema, Erstimpfung ab 6 Jahren",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE"),
    /**
     * EN: COVID-19.<br>
     */
    COVID_19("SCHEMA204",
             "1.2.40.0.34.5.183",
             "COVID-19",
             "COVID-19",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: COVID-19 Grundschema.<br>
     */
    COVID_19_GRUNDSCHEMA("SCHEMA122",
                         "1.2.40.0.34.5.183",
                         "COVID-19 Grundschema",
                         "COVID-19 Grundschema",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: COVID-19 Grundschema, Kleinkind.<br>
     */
    COVID_19_GRUNDSCHEMA_KLEINKIND("SCHEMA117",
                                   "1.2.40.0.34.5.183",
                                   "COVID-19 Grundschema, Kleinkind",
                                   "COVID-19 Grundschema, Kleinkind",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: COVID-19, Indikation.<br>
     */
    COVID_19_INDIKATION("SCHEMA205",
                        "1.2.40.0.34.5.183",
                        "COVID-19, Indikation",
                        "COVID-19, Indikation",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: COVID-19 Indikationsschema.<br>
     */
    COVID_19_INDIKATIONSSCHEMA("SCHEMA110",
                               "1.2.40.0.34.5.183",
                               "COVID-19 Indikationsschema",
                               "COVID-19 Indikationsschema",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: COVID-19, Indikation Grundimmunisierung bis 5 Jahre.<br>
     */
    COVID_19_INDIKATION_GRUNDIMMUNISIERUNG_BIS_5_JAHRE("SCHEMA260",
                                                       "1.2.40.0.34.5.183",
                                                       "COVID-19, Indikation Grundimmunisierung bis 5 Jahre",
                                                       "COVID-19, Indikation Grundimmunisierung bis 5 Jahre",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE"),
    /**
     * EN: Dengue.<br>
     */
    DENGUE("SCHEMA206",
           "1.2.40.0.34.5.183",
           "Dengue",
           "Dengue",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Dengue-Fieber Grundschema, 2 Dosen.<br>
     */
    DENGUE_FIEBER_GRUNDSCHEMA_2_DOSEN("SCHEMA119",
                                      "1.2.40.0.34.5.183",
                                      "Dengue-Fieber Grundschema, 2 Dosen",
                                      "Dengue-Fieber Grundschema, 2 Dosen",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: Di-Te-Pert.<br>
     */
    DI_TE_PERT("SCHEMA207",
               "1.2.40.0.34.5.183",
               "Di-Te-Pert",
               "Di-Te-Pert",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Di-Te-Pert-IPV.<br>
     */
    DI_TE_PERT_IPV("SCHEMA208",
                   "1.2.40.0.34.5.183",
                   "Di-Te-Pert-IPV",
                   "Di-Te-Pert-IPV",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Di-Te-Pert-IPV, Indikation.<br>
     */
    DI_TE_PERT_IPV_INDIKATION("SCHEMA259",
                              "1.2.40.0.34.5.183",
                              "Di-Te-Pert-IPV, Indikation",
                              "Di-Te-Pert-IPV, Indikation",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: FSME.<br>
     */
    FSME("SCHEMA209",
         "1.2.40.0.34.5.183",
         "FSME",
         "FSME",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: FSME, beschleunigtes konventionelles Schema.<br>
     */
    FSME_BESCHLEUNIGTES_KONVENTIONELLES_SCHEMA("SCHEMA210",
                                               "1.2.40.0.34.5.183",
                                               "FSME, beschleunigtes konventionelles Schema",
                                               "FSME, beschleunigtes konventionelles Schema",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE"),
    /**
     * EN: FSME beschleunigtes konventionelles Schema, Encepur.<br>
     */
    FSME_BESCHLEUNIGTES_KONVENTIONELLES_SCHEMA_ENCEPUR("SCHEMA126",
                                                       "1.2.40.0.34.5.183",
                                                       "FSME beschleunigtes konventionelles Schema, Encepur",
                                                       "FSME beschleunigtes konventionelles Schema, Encepur",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE"),
    /**
     * EN: FSME Grundschema, Encepur.<br>
     */
    FSME_GRUNDSCHEMA_ENCEPUR("SCHEMA006",
                             "1.2.40.0.34.5.183",
                             "FSME Grundschema, Encepur",
                             "FSME Grundschema, Encepur",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: FSME Grundschema, Encepur, Erstimpfung bis 1 Jahr.<br>
     */
    FSME_GRUNDSCHEMA_ENCEPUR_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA008",
                                                    "1.2.40.0.34.5.183",
                                                    "FSME Grundschema, Encepur, Erstimpfung bis 1 Jahr",
                                                    "FSME Grundschema, Encepur, Erstimpfung bis 1 Jahr",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: FSME Grundschema, FSME-Immun.<br>
     */
    FSME_GRUNDSCHEMA_FSME_IMMUN("SCHEMA005",
                                "1.2.40.0.34.5.183",
                                "FSME Grundschema, FSME-Immun",
                                "FSME Grundschema, FSME-Immun",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: FSME Grundschema, FSME-Immun, Erstimpfung bis 1 Jahr.<br>
     */
    FSME_GRUNDSCHEMA_FSME_IMMUN_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA007",
                                                       "1.2.40.0.34.5.183",
                                                       "FSME Grundschema, FSME-Immun, Erstimpfung bis 1 Jahr",
                                                       "FSME Grundschema, FSME-Immun, Erstimpfung bis 1 Jahr",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE"),
    /**
     * EN: FSME, Schnellschema.<br>
     */
    FSME_SCHNELLSCHEMA("SCHEMA211",
                       "1.2.40.0.34.5.183",
                       "FSME, Schnellschema",
                       "FSME, Schnellschema",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: FSME Schnellschema, Encepur.<br>
     */
    FSME_SCHNELLSCHEMA_ENCEPUR("SCHEMA010",
                               "1.2.40.0.34.5.183",
                               "FSME Schnellschema, Encepur",
                               "FSME Schnellschema, Encepur",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: FSME Schnellschema, FSME-Immun.<br>
     */
    FSME_SCHNELLSCHEMA_FSME_IMMUN("SCHEMA009",
                                  "1.2.40.0.34.5.183",
                                  "FSME Schnellschema, FSME-Immun",
                                  "FSME Schnellschema, FSME-Immun",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Gelbfieber.<br>
     */
    GELBFIEBER("SCHEMA212",
               "1.2.40.0.34.5.183",
               "Gelbfieber",
               "Gelbfieber",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Gelbfieber Grundschema, ab dem vollendeten 9. Lebensmonat.<br>
     */
    GELBFIEBER_GRUNDSCHEMA_AB_DEM_VOLLENDETEN_9_LEBENSMONAT("SCHEMA065",
                                                            "1.2.40.0.34.5.183",
                                                            "Gelbfieber Grundschema, ab dem vollendeten 9. Lebensmonat",
                                                            "Gelbfieber Grundschema, ab dem vollendeten 9. Lebensmonat",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE"),
    /**
     * EN: Haemophilus influenzae Typ B Indikationsschema.<br>
     */
    HAEMOPHILUS_INFLUENZAE_TYP_B_INDIKATIONSSCHEMA("SCHEMA011",
                                                   "1.2.40.0.34.5.183",
                                                   "Haemophilus influenzae Typ B Indikationsschema",
                                                   "Haemophilus influenzae Typ B Indikationsschema",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Hepatitis A.<br>
     */
    HEPATITIS_A("SCHEMA213",
                "1.2.40.0.34.5.183",
                "Hepatitis A",
                "Hepatitis A",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Hepatitis AB.<br>
     */
    HEPATITIS_AB("SCHEMA215",
                 "1.2.40.0.34.5.183",
                 "Hepatitis AB",
                 "Hepatitis AB",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Hepatitis AB Grundschema.<br>
     */
    HEPATITIS_AB_GRUNDSCHEMA("SCHEMA013",
                             "1.2.40.0.34.5.183",
                             "Hepatitis AB Grundschema",
                             "Hepatitis AB Grundschema",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Hepatitis AB Schnellschema.<br>
     */
    HEPATITIS_AB_SCHNELLSCHEMA("SCHEMA015",
                               "1.2.40.0.34.5.183",
                               "Hepatitis AB Schnellschema",
                               "Hepatitis AB Schnellschema",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Hepatitis AB, Schnellschema.<br>
     */
    // HEPATITIS_AB_SCHNELLSCHEMA("SCHEMA258",
    //                            "1.2.40.0.34.5.183",
    //                            "Hepatitis AB, Schnellschema",
    //                            "Hepatitis AB, Schnellschema",
    //                            "TOTRANSLATE",
    //                            "TOTRANSLATE",
    //                            "TOTRANSLATE"),
    /**
     * EN: Hepatitis A Monokomponente Grundschema.<br>
     */
    HEPATITIS_A_MONOKOMPONENTE_GRUNDSCHEMA("SCHEMA014",
                                           "1.2.40.0.34.5.183",
                                           "Hepatitis A Monokomponente Grundschema",
                                           "Hepatitis A Monokomponente Grundschema",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Hepatitis A Monokomponente Indikationsschema.<br>
     */
    HEPATITIS_A_MONOKOMPONENTE_INDIKATIONSSCHEMA("SCHEMA012",
                                                 "1.2.40.0.34.5.183",
                                                 "Hepatitis A Monokomponente Indikationsschema",
                                                 "Hepatitis A Monokomponente Indikationsschema",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: Hepatitis A &amp; Typhus Grundschema.<br>
     */
    HEPATITIS_A_TYPHUS_GRUNDSCHEMA("SCHEMA016",
                                   "1.2.40.0.34.5.183",
                                   "Hepatitis A & Typhus Grundschema",
                                   "Hepatitis A & Typhus Grundschema",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Hepatitis B.<br>
     */
    HEPATITIS_B("SCHEMA216",
                "1.2.40.0.34.5.183",
                "Hepatitis B",
                "Hepatitis B",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Hepatitis B, Indikation.<br>
     */
    HEPATITIS_B_INDIKATION("SCHEMA217",
                           "1.2.40.0.34.5.183",
                           "Hepatitis B, Indikation",
                           "Hepatitis B, Indikation",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Hepatitis B, Indikation Prophylaxe Neugeborener.<br>
     */
    HEPATITIS_B_INDIKATION_PROPHYLAXE_NEUGEBORENER("SCHEMA218",
                                                   "1.2.40.0.34.5.183",
                                                   "Hepatitis B, Indikation Prophylaxe Neugeborener",
                                                   "Hepatitis B, Indikation Prophylaxe Neugeborener",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Hepatitis B Monokomponente Grundschema.<br>
     */
    HEPATITIS_B_MONOKOMPONENTE_GRUNDSCHEMA("SCHEMA017",
                                           "1.2.40.0.34.5.183",
                                           "Hepatitis B Monokomponente Grundschema",
                                           "Hepatitis B Monokomponente Grundschema",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Hepatitis B Monokomponente Indikationsschema.<br>
     */
    HEPATITIS_B_MONOKOMPONENTE_INDIKATIONSSCHEMA("SCHEMA085",
                                                 "1.2.40.0.34.5.183",
                                                 "Hepatitis B Monokomponente Indikationsschema",
                                                 "Hepatitis B Monokomponente Indikationsschema",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: Hepatitis B Monokomponente Schnellschema durch Indikation.<br>
     */
    HEPATITIS_B_MONOKOMPONENTE_SCHNELLSCHEMA_DURCH_INDIKATION("SCHEMA102",
                                                              "1.2.40.0.34.5.183",
                                                              "Hepatitis B Monokomponente Schnellschema durch Indikation",
                                                              "Hepatitis B Monokomponente Schnellschema durch Indikation",
                                                              "TOTRANSLATE",
                                                              "TOTRANSLATE",
                                                              "TOTRANSLATE"),
    /**
     * EN: Hepatitis B Non-/Low-Responder Indikationsschema.<br>
     */
    HEPATITIS_B_NON_LOW_RESPONDER_INDIKATIONSSCHEMA("SCHEMA019",
                                                    "1.2.40.0.34.5.183",
                                                    "Hepatitis B Non-/Low-Responder Indikationsschema",
                                                    "Hepatitis B Non-/Low-Responder Indikationsschema",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Hepatitis B Prophylaxe Neugeborener Indikationsschema.<br>
     */
    HEPATITIS_B_PROPHYLAXE_NEUGEBORENER_INDIKATIONSSCHEMA("SCHEMA103",
                                                          "1.2.40.0.34.5.183",
                                                          "Hepatitis B Prophylaxe Neugeborener Indikationsschema",
                                                          "Hepatitis B Prophylaxe Neugeborener Indikationsschema",
                                                          "TOTRANSLATE",
                                                          "TOTRANSLATE",
                                                          "TOTRANSLATE"),
    /**
     * EN: Hepatitis B, Schnellschema.<br>
     */
    HEPATITIS_B_SCHNELLSCHEMA("SCHEMA219",
                              "1.2.40.0.34.5.183",
                              "Hepatitis B, Schnellschema",
                              "Hepatitis B, Schnellschema",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Herpes Zoster.<br>
     */
    HERPES_ZOSTER("SCHEMA220",
                  "1.2.40.0.34.5.183",
                  "Herpes Zoster",
                  "Herpes Zoster",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Herpes Zoster Grundschema, ab 50 Jahren.<br>
     */
    HERPES_ZOSTER_GRUNDSCHEMA_AB_50_JAHREN("SCHEMA064",
                                           "1.2.40.0.34.5.183",
                                           "Herpes Zoster Grundschema, ab 50 Jahren",
                                           "Herpes Zoster Grundschema, ab 50 Jahren",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Herpes Zoster Grundschema, nach Zostavax.<br>
     */
    HERPES_ZOSTER_GRUNDSCHEMA_NACH_ZOSTAVAX("SCHEMA091",
                                            "1.2.40.0.34.5.183",
                                            "Herpes Zoster Grundschema, nach Zostavax",
                                            "Herpes Zoster Grundschema, nach Zostavax",
                                            "TOTRANSLATE",
                                            "TOTRANSLATE",
                                            "TOTRANSLATE"),
    /**
     * EN: Herpes Zoster, Indikation.<br>
     */
    HERPES_ZOSTER_INDIKATION("SCHEMA221",
                             "1.2.40.0.34.5.183",
                             "Herpes Zoster, Indikation",
                             "Herpes Zoster, Indikation",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Herpes Zoster Indikationsschema, ab 18 Jahren.<br>
     */
    HERPES_ZOSTER_INDIKATIONSSCHEMA_AB_18_JAHREN("SCHEMA092",
                                                 "1.2.40.0.34.5.183",
                                                 "Herpes Zoster Indikationsschema, ab 18 Jahren",
                                                 "Herpes Zoster Indikationsschema, ab 18 Jahren",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: HiB, Indikation.<br>
     */
    HIB_INDIKATION("SCHEMA222",
                   "1.2.40.0.34.5.183",
                   "HiB, Indikation",
                   "HiB, Indikation",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: HPV.<br>
     */
    HPV("SCHEMA223",
        "1.2.40.0.34.5.183",
        "HPV",
        "HPV",
        "TOTRANSLATE",
        "TOTRANSLATE",
        "TOTRANSLATE"),
    /**
     * EN: HPV Grundschema.<br>
     */
    HPV_GRUNDSCHEMA("SCHEMA020",
                    "1.2.40.0.34.5.183",
                    "HPV Grundschema",
                    "HPV Grundschema",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: HPV Grundschema, ab 21 Jahren.<br>
     */
    HPV_GRUNDSCHEMA_AB_21_JAHREN("SCHEMA021",
                                 "1.2.40.0.34.5.183",
                                 "HPV Grundschema, ab 21 Jahren",
                                 "HPV Grundschema, ab 21 Jahren",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: HPV, Indikation.<br>
     */
    HPV_INDIKATION("SCHEMA224",
                   "1.2.40.0.34.5.183",
                   "HPV, Indikation",
                   "HPV, Indikation",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: HPV Indikationsschema.<br>
     */
    HPV_INDIKATIONSSCHEMA("SCHEMA022",
                          "1.2.40.0.34.5.183",
                          "HPV Indikationsschema",
                          "HPV Indikationsschema",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Influenza.<br>
     */
    INFLUENZA("SCHEMA225",
              "1.2.40.0.34.5.183",
              "Influenza",
              "Influenza",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Influenza Grundschema, Einmalimpfung.<br>
     */
    INFLUENZA_GRUNDSCHEMA_EINMALIMPFUNG("SCHEMA024",
                                        "1.2.40.0.34.5.183",
                                        "Influenza Grundschema, Einmalimpfung",
                                        "Influenza Grundschema, Einmalimpfung",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Influenza Grundschema, Erstimpfung Kinder.<br>
     */
    INFLUENZA_GRUNDSCHEMA_ERSTIMPFUNG_KINDER("SCHEMA023",
                                             "1.2.40.0.34.5.183",
                                             "Influenza Grundschema, Erstimpfung Kinder",
                                             "Influenza Grundschema, Erstimpfung Kinder",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE"),
    /**
     * EN: Influenza, Indikation.<br>
     */
    INFLUENZA_INDIKATION("SCHEMA226",
                         "1.2.40.0.34.5.183",
                         "Influenza, Indikation",
                         "Influenza, Indikation",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Influenza Indikationsschema.<br>
     */
    INFLUENZA_INDIKATIONSSCHEMA("SCHEMA104",
                                "1.2.40.0.34.5.183",
                                "Influenza Indikationsschema",
                                "Influenza Indikationsschema",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: Japanische Enzephalitis.<br>
     */
    JAPANISCHE_ENZEPHALITIS("SCHEMA227",
                            "1.2.40.0.34.5.183",
                            "Japanische Enzephalitis",
                            "Japanische Enzephalitis",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Japanische Enzephalitis Grundschema, ab 2 Monaten.<br>
     */
    JAPANISCHE_ENZEPHALITIS_GRUNDSCHEMA_AB_2_MONATEN("SCHEMA066",
                                                     "1.2.40.0.34.5.183",
                                                     "Japanische Enzephalitis Grundschema, ab 2 Monaten",
                                                     "Japanische Enzephalitis Grundschema, ab 2 Monaten",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE"),
    /**
     * EN: Japanische Enzephalitis, Schnellschema.<br>
     */
    JAPANISCHE_ENZEPHALITIS_SCHNELLSCHEMA("SCHEMA228",
                                          "1.2.40.0.34.5.183",
                                          "Japanische Enzephalitis, Schnellschema",
                                          "Japanische Enzephalitis, Schnellschema",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE"),
    /**
     * EN: Japanische Enzephalitis Schnellschema, ab 18 Jahren.<br>
     */
    JAPANISCHE_ENZEPHALITIS_SCHNELLSCHEMA_AB_18_JAHREN("SCHEMA067",
                                                       "1.2.40.0.34.5.183",
                                                       "Japanische Enzephalitis Schnellschema, ab 18 Jahren",
                                                       "Japanische Enzephalitis Schnellschema, ab 18 Jahren",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE("SCHEMA082",
                             "1.2.40.0.34.5.183",
                             "Kombinationsschema Di-Te",
                             "Kombinationsschema Di-Te",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-IPV.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_IPV("SCHEMA105",
                                 "1.2.40.0.34.5.183",
                                 "Kombinationsschema Di-Te-IPV",
                                 "Kombinationsschema Di-Te-IPV",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-Pert.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_PERT("SCHEMA081",
                                  "1.2.40.0.34.5.183",
                                  "Kombinationsschema Di-Te-Pert",
                                  "Kombinationsschema Di-Te-Pert",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung ab 1 Jahr.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_PERT_HIB_IPV_HEPB_ERSTIMPFUNG_AB_1_JAHR("SCHEMA002",
                                                                     "1.2.40.0.34.5.183",
                                                                     "Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung ab 1 Jahr",
                                                                     "Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung ab 1 Jahr",
                                                                     "TOTRANSLATE",
                                                                     "TOTRANSLATE",
                                                                     "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung bis 1 Jahr.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_PERT_HIB_IPV_HEPB_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA001",
                                                                      "1.2.40.0.34.5.183",
                                                                      "Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung bis 1 Jahr",
                                                                      "Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung bis 1 Jahr",
                                                                      "TOTRANSLATE",
                                                                      "TOTRANSLATE",
                                                                      "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Indikation.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_PERT_HIB_IPV_HEPB_INDIKATION("SCHEMA004",
                                                          "1.2.40.0.34.5.183",
                                                          "Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Indikation",
                                                          "Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Indikation",
                                                          "TOTRANSLATE",
                                                          "TOTRANSLATE",
                                                          "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-Pert-IPV.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_PERT_IPV("SCHEMA080",
                                      "1.2.40.0.34.5.183",
                                      "Kombinationsschema Di-Te-Pert-IPV",
                                      "Kombinationsschema Di-Te-Pert-IPV",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema Di-Te-Pert-IPV-HepB, Erstimpfung ab 6 Jahren.<br>
     */
    KOMBINATIONSSCHEMA_DI_TE_PERT_IPV_HEPB_ERSTIMPFUNG_AB_6_JAHREN("SCHEMA003",
                                                                   "1.2.40.0.34.5.183",
                                                                   "Kombinationsschema Di-Te-Pert-IPV-HepB, Erstimpfung ab 6 Jahren",
                                                                   "Kombinationsschema Di-Te-Pert-IPV-HepB, Erstimpfung ab 6 Jahren",
                                                                   "TOTRANSLATE",
                                                                   "TOTRANSLATE",
                                                                   "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMRV.<br>
     */
    KOMBINATIONSSCHEMA_MMRV_AB_12_MONATEN_MMRV_MMRV("SCHEMA101",
                                                    "1.2.40.0.34.5.183",
                                                    "Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMRV",
                                                    "Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMRV",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMR - V.<br>
     */
    KOMBINATIONSSCHEMA_MMRV_AB_12_MONATEN_MMRV_MMR_V("SCHEMA114",
                                                     "1.2.40.0.34.5.183",
                                                     "Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMR - V",
                                                     "Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMR - V",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema MMRV, ab 12 Monaten, MMR - MMRV - V.<br>
     */
    KOMBINATIONSSCHEMA_MMRV_AB_12_MONATEN_MMR_MMRV_V("SCHEMA062",
                                                     "1.2.40.0.34.5.183",
                                                     "Kombinationsschema MMRV, ab 12 Monaten, MMR - MMRV - V",
                                                     "Kombinationsschema MMRV, ab 12 Monaten, MMR - MMRV - V",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMRV.<br>
     */
    KOMBINATIONSSCHEMA_MMRV_AB_9_MONATEN_MMRV_MMRV("SCHEMA100",
                                                   "1.2.40.0.34.5.183",
                                                   "Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMRV",
                                                   "Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMRV",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMR - V.<br>
     */
    KOMBINATIONSSCHEMA_MMRV_AB_9_MONATEN_MMRV_MMR_V("SCHEMA113",
                                                    "1.2.40.0.34.5.183",
                                                    "Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMR - V",
                                                    "Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMR - V",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Kombinationsschema MMRV, ab 9 Monaten, MMR - MMRV - V.<br>
     */
    KOMBINATIONSSCHEMA_MMRV_AB_9_MONATEN_MMR_MMRV_V("SCHEMA061",
                                                    "1.2.40.0.34.5.183",
                                                    "Kombinationsschema MMRV, ab 9 Monaten, MMR - MMRV - V",
                                                    "Kombinationsschema MMRV, ab 9 Monaten, MMR - MMRV - V",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY.<br>
     */
    MENINGOKOKKEN_ACWY("SCHEMA229",
                       "1.2.40.0.34.5.183",
                       "Meningokokken ACWY",
                       "Meningokokken ACWY",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY, ab 1 Jahr.<br>
     */
    MENINGOKOKKEN_ACWY_AB_1_JAHR("SCHEMA125",
                                 "1.2.40.0.34.5.183",
                                 "Meningokokken ACWY, ab 1 Jahr",
                                 "Meningokokken ACWY, ab 1 Jahr",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Grundschema, ab 10 Jahren.<br>
     */
    MENINGOKOKKEN_ACWY_GRUNDSCHEMA_AB_10_JAHREN("SCHEMA039",
                                                "1.2.40.0.34.5.183",
                                                "Meningokokken ACWY Grundschema, ab 10 Jahren",
                                                "Meningokokken ACWY Grundschema, ab 10 Jahren",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY, Indikation.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATION("SCHEMA230",
                                  "1.2.40.0.34.5.183",
                                  "Meningokokken ACWY, Indikation",
                                  "Meningokokken ACWY, Indikation",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Indikationsschema, ab 1 Jahr.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_AB_1_JAHR("SCHEMA040",
                                                   "1.2.40.0.34.5.183",
                                                   "Meningokokken ACWY Indikationsschema, ab 1 Jahr",
                                                   "Meningokokken ACWY Indikationsschema, ab 1 Jahr",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Indikationsschema, Erstimpfung bis 1 Jahr.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA041",
                                                                "1.2.40.0.34.5.183",
                                                                "Meningokokken ACWY Indikationsschema, Erstimpfung bis 1 Jahr",
                                                                "Meningokokken ACWY Indikationsschema, Erstimpfung bis 1 Jahr",
                                                                "TOTRANSLATE",
                                                                "TOTRANSLATE",
                                                                "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Indikationsschema, Menveo ab 2 Jahre.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_MENVEO_AB_2_JAHRE("SCHEMA109",
                                                           "1.2.40.0.34.5.183",
                                                           "Meningokokken ACWY Indikationsschema, Menveo ab 2 Jahre",
                                                           "Meningokokken ACWY Indikationsschema, Menveo ab 2 Jahre",
                                                           "TOTRANSLATE",
                                                           "TOTRANSLATE",
                                                           "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Indikationsschema, Nimenrix ab 1 Jahr.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_NIMENRIX_AB_1_JAHR("SCHEMA108",
                                                            "1.2.40.0.34.5.183",
                                                            "Meningokokken ACWY Indikationsschema, Nimenrix ab 1 Jahr",
                                                            "Meningokokken ACWY Indikationsschema, Nimenrix ab 1 Jahr",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Indikationsschema, Nimenrix ab 6 Monate.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_NIMENRIX_AB_6_MONATE("SCHEMA107",
                                                              "1.2.40.0.34.5.183",
                                                              "Meningokokken ACWY Indikationsschema, Nimenrix ab 6 Monate",
                                                              "Meningokokken ACWY Indikationsschema, Nimenrix ab 6 Monate",
                                                              "TOTRANSLATE",
                                                              "TOTRANSLATE",
                                                              "TOTRANSLATE"),
    /**
     * EN: Meningokokken ACWY Indikationsschema, Nimenrix bis 6 Monate.<br>
     */
    MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_NIMENRIX_BIS_6_MONATE("SCHEMA106",
                                                               "1.2.40.0.34.5.183",
                                                               "Meningokokken ACWY Indikationsschema, Nimenrix bis 6 Monate",
                                                               "Meningokokken ACWY Indikationsschema, Nimenrix bis 6 Monate",
                                                               "TOTRANSLATE",
                                                               "TOTRANSLATE",
                                                               "TOTRANSLATE"),
    /**
     * EN: Meningokokken B.<br>
     */
    MENINGOKOKKEN_B("SCHEMA231",
                    "1.2.40.0.34.5.183",
                    "Meningokokken B",
                    "Meningokokken B",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Grundschema, Erstimpfung 10-25 Jahre, Trumenba.<br>
     */
    MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_10_25_JAHRE_TRUMENBA("SCHEMA079",
                                                                 "1.2.40.0.34.5.183",
                                                                 "Meningokokken B Grundschema, Erstimpfung 10-25 Jahre, Trumenba",
                                                                 "Meningokokken B Grundschema, Erstimpfung 10-25 Jahre, Trumenba",
                                                                 "TOTRANSLATE",
                                                                 "TOTRANSLATE",
                                                                 "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Grundschema, Erstimpfung 12-23 Monate.<br>
     */
    MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_12_23_MONATE("SCHEMA031",
                                                         "1.2.40.0.34.5.183",
                                                         "Meningokokken B Grundschema, Erstimpfung 12-23 Monate",
                                                         "Meningokokken B Grundschema, Erstimpfung 12-23 Monate",
                                                         "TOTRANSLATE",
                                                         "TOTRANSLATE",
                                                         "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Grundschema, Erstimpfung 2-25 Jahre, Bexsero.<br>
     */
    MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_2_25_JAHRE_BEXSERO("SCHEMA032",
                                                               "1.2.40.0.34.5.183",
                                                               "Meningokokken B Grundschema, Erstimpfung 2-25 Jahre, Bexsero",
                                                               "Meningokokken B Grundschema, Erstimpfung 2-25 Jahre, Bexsero",
                                                               "TOTRANSLATE",
                                                               "TOTRANSLATE",
                                                               "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Grundschema, Erstimpfung 2-5 Monate.<br>
     */
    MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_2_5_MONATE("SCHEMA029",
                                                       "1.2.40.0.34.5.183",
                                                       "Meningokokken B Grundschema, Erstimpfung 2-5 Monate",
                                                       "Meningokokken B Grundschema, Erstimpfung 2-5 Monate",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE",
                                                       "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Grundschema, Erstimpfung 2-5 Monate, 4 Dosen.<br>
     */
    MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_2_5_MONATE_4_DOSEN("SCHEMA028",
                                                               "1.2.40.0.34.5.183",
                                                               "Meningokokken B Grundschema, Erstimpfung 2-5 Monate, 4 Dosen",
                                                               "Meningokokken B Grundschema, Erstimpfung 2-5 Monate, 4 Dosen",
                                                               "TOTRANSLATE",
                                                               "TOTRANSLATE",
                                                               "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Grundschema, Erstimpfung 6-11 Monate.<br>
     */
    MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_6_11_MONATE("SCHEMA030",
                                                        "1.2.40.0.34.5.183",
                                                        "Meningokokken B Grundschema, Erstimpfung 6-11 Monate",
                                                        "Meningokokken B Grundschema, Erstimpfung 6-11 Monate",
                                                        "TOTRANSLATE",
                                                        "TOTRANSLATE",
                                                        "TOTRANSLATE"),
    /**
     * EN: Meningokokken B, Indikation.<br>
     */
    MENINGOKOKKEN_B_INDIKATION("SCHEMA232",
                               "1.2.40.0.34.5.183",
                               "Meningokokken B, Indikation",
                               "Meningokokken B, Indikation",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Indikationsschema, ab 25 Jahren, Bexsero.<br>
     */
    MENINGOKOKKEN_B_INDIKATIONSSCHEMA_AB_25_JAHREN_BEXSERO("SCHEMA033",
                                                           "1.2.40.0.34.5.183",
                                                           "Meningokokken B Indikationsschema, ab 25 Jahren, Bexsero",
                                                           "Meningokokken B Indikationsschema, ab 25 Jahren, Bexsero",
                                                           "TOTRANSLATE",
                                                           "TOTRANSLATE",
                                                           "TOTRANSLATE"),
    /**
     * EN: Meningokokken B Indikationsschema, ab 25 Jahren, Trumenba.<br>
     */
    MENINGOKOKKEN_B_INDIKATIONSSCHEMA_AB_25_JAHREN_TRUMENBA("SCHEMA034",
                                                            "1.2.40.0.34.5.183",
                                                            "Meningokokken B Indikationsschema, ab 25 Jahren, Trumenba",
                                                            "Meningokokken B Indikationsschema, ab 25 Jahren, Trumenba",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE"),
    /**
     * EN: Meningokokken C.<br>
     */
    MENINGOKOKKEN_C("SCHEMA233",
                    "1.2.40.0.34.5.183",
                    "Meningokokken C",
                    "Meningokokken C",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Meningokokken C Grundschema, ab 1 Jahr.<br>
     */
    MENINGOKOKKEN_C_GRUNDSCHEMA_AB_1_JAHR("SCHEMA038",
                                          "1.2.40.0.34.5.183",
                                          "Meningokokken C Grundschema, ab 1 Jahr",
                                          "Meningokokken C Grundschema, ab 1 Jahr",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE"),
    /**
     * EN: Meningokokken C Indikationsschema, 2-12 Monate, Menjugate.<br>
     */
    MENINGOKOKKEN_C_INDIKATIONSSCHEMA_2_12_MONATE_MENJUGATE("SCHEMA036",
                                                            "1.2.40.0.34.5.183",
                                                            "Meningokokken C Indikationsschema, 2-12 Monate, Menjugate",
                                                            "Meningokokken C Indikationsschema, 2-12 Monate, Menjugate",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE"),
    /**
     * EN: Meningokokken C Indikationsschema, 2-4 Monate, Neisvac C.<br>
     */
    MENINGOKOKKEN_C_INDIKATIONSSCHEMA_2_4_MONATE_NEISVAC_C("SCHEMA035",
                                                           "1.2.40.0.34.5.183",
                                                           "Meningokokken C Indikationsschema, 2-4 Monate, Neisvac C",
                                                           "Meningokokken C Indikationsschema, 2-4 Monate, Neisvac C",
                                                           "TOTRANSLATE",
                                                           "TOTRANSLATE",
                                                           "TOTRANSLATE"),
    /**
     * EN: Meningokokken C Indikationsschema, 4-12 Monate, Neisvac C.<br>
     */
    MENINGOKOKKEN_C_INDIKATIONSSCHEMA_4_12_MONATE_NEISVAC_C("SCHEMA037",
                                                            "1.2.40.0.34.5.183",
                                                            "Meningokokken C Indikationsschema, 4-12 Monate, Neisvac C",
                                                            "Meningokokken C Indikationsschema, 4-12 Monate, Neisvac C",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE"),
    /**
     * EN: MMR.<br>
     */
    MMR("SCHEMA234",
        "1.2.40.0.34.5.183",
        "MMR",
        "MMR",
        "TOTRANSLATE",
        "TOTRANSLATE",
        "TOTRANSLATE"),
    /**
     * EN: MMRV.<br>
     */
    MMRV("SCHEMA237",
         "1.2.40.0.34.5.183",
         "MMRV",
         "MMRV",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: MMR Grundschema, ab 1 Jahr.<br>
     */
    MMR_GRUNDSCHEMA_AB_1_JAHR("SCHEMA093",
                              "1.2.40.0.34.5.183",
                              "MMR Grundschema, ab 1 Jahr",
                              "MMR Grundschema, ab 1 Jahr",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: MMR Grundschema ab 9 Monaten.<br>
     */
    MMR_GRUNDSCHEMA_AB_9_MONATEN("SCHEMA025",
                                 "1.2.40.0.34.5.183",
                                 "MMR Grundschema ab 9 Monaten",
                                 "MMR Grundschema ab 9 Monaten",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: MMR, Indikation.<br>
     */
    MMR_INDIKATION("SCHEMA236",
                   "1.2.40.0.34.5.183",
                   "MMR, Indikation",
                   "MMR, Indikation",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: MMR Indikationsschema, Erstimpfung 6-8 Monate.<br>
     */
    MMR_INDIKATIONSSCHEMA_ERSTIMPFUNG_6_8_MONATE("SCHEMA027",
                                                 "1.2.40.0.34.5.183",
                                                 "MMR Indikationsschema, Erstimpfung 6-8 Monate",
                                                 "MMR Indikationsschema, Erstimpfung 6-8 Monate",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: MMR - MMRV - V.<br>
     */
    MMR_MMRV_V("SCHEMA235",
               "1.2.40.0.34.5.183",
               "MMR - MMRV - V",
               "MMR - MMRV - V",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Mpox.<br>
     */
    MPOX("SCHEMA238",
         "1.2.40.0.34.5.183",
         "Mpox",
         "Mpox",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: Mpox/Pocken Indikationsschema.<br>
     */
    MPOX_POCKEN_INDIKATIONSSCHEMA("SCHEMA111",
                                  "1.2.40.0.34.5.183",
                                  "Mpox/Pocken Indikationsschema",
                                  "Mpox/Pocken Indikationsschema",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Mpox/Pocken Indikationsschema, einmalige Impfung.<br>
     */
    MPOX_POCKEN_INDIKATIONSSCHEMA_EINMALIGE_IMPFUNG("SCHEMA115",
                                                    "1.2.40.0.34.5.183",
                                                    "Mpox/Pocken Indikationsschema, einmalige Impfung",
                                                    "Mpox/Pocken Indikationsschema, einmalige Impfung",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Pneumokokken.<br>
     */
    PNEUMOKOKKEN("SCHEMA239",
                 "1.2.40.0.34.5.183",
                 "Pneumokokken",
                 "Pneumokokken",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Pneumokokken, Frühgeborene (3+1).<br>
     */
    PNEUMOKOKKEN_FR_HGEBORENE_3_1("SCHEMA241",
                                  "1.2.40.0.34.5.183",
                                  "Pneumokokken, Frühgeborene (3+1)",
                                  "Pneumokokken, Frühgeborene (3+1)",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Pneumokokken, Frühgeborene mit Indikation (3+1).<br>
     */
    PNEUMOKOKKEN_FR_HGEBORENE_MIT_INDIKATION_3_1("SCHEMA243",
                                                 "1.2.40.0.34.5.183",
                                                 "Pneumokokken, Frühgeborene mit Indikation (3+1)",
                                                 "Pneumokokken, Frühgeborene mit Indikation (3+1)",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Grundschema, ab 60 Jahre.<br>
     */
    PNEUMOKOKKEN_GRUNDSCHEMA_AB_60_JAHRE("SCHEMA098",
                                         "1.2.40.0.34.5.183",
                                         "Pneumokokken Grundschema, ab 60 Jahre",
                                         "Pneumokokken Grundschema, ab 60 Jahre",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Grundschema, Erstimpfung 1-2 Jahre.<br>
     */
    PNEUMOKOKKEN_GRUNDSCHEMA_ERSTIMPFUNG_1_2_JAHRE("SCHEMA043",
                                                   "1.2.40.0.34.5.183",
                                                   "Pneumokokken Grundschema, Erstimpfung 1-2 Jahre",
                                                   "Pneumokokken Grundschema, Erstimpfung 1-2 Jahre",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Grundschema, Erstimpfung 2-5 Jahre.<br>
     */
    PNEUMOKOKKEN_GRUNDSCHEMA_ERSTIMPFUNG_2_5_JAHRE("SCHEMA097",
                                                   "1.2.40.0.34.5.183",
                                                   "Pneumokokken Grundschema, Erstimpfung 2-5 Jahre",
                                                   "Pneumokokken Grundschema, Erstimpfung 2-5 Jahre",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Grundschema, Erstimpfung bis 1 Jahr.<br>
     */
    PNEUMOKOKKEN_GRUNDSCHEMA_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA042",
                                                    "1.2.40.0.34.5.183",
                                                    "Pneumokokken Grundschema, Erstimpfung bis 1 Jahr",
                                                    "Pneumokokken Grundschema, Erstimpfung bis 1 Jahr",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Pneumokokken, Indikation.<br>
     */
    PNEUMOKOKKEN_INDIKATION("SCHEMA242",
                            "1.2.40.0.34.5.183",
                            "Pneumokokken, Indikation",
                            "Pneumokokken, Indikation",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Indikationsschema (erhöhtes Risiko), ab 50 Jahren.<br>
     */
    PNEUMOKOKKEN_INDIKATIONSSCHEMA_ERH_HTES_RISIKO_AB_50_JAHREN("SCHEMA116",
                                                                "1.2.40.0.34.5.183",
                                                                "Pneumokokken Indikationsschema (erhöhtes Risiko), ab 50 Jahren",
                                                                "Pneumokokken Indikationsschema (erhöhtes Risiko), ab 50 Jahren",
                                                                "TOTRANSLATE",
                                                                "TOTRANSLATE",
                                                                "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Indikationsschema, Frühgeborene.<br>
     */
    PNEUMOKOKKEN_INDIKATIONSSCHEMA_FR_HGEBORENE("SCHEMA118",
                                                "1.2.40.0.34.5.183",
                                                "Pneumokokken Indikationsschema, Frühgeborene",
                                                "Pneumokokken Indikationsschema, Frühgeborene",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung ab 3 Jahren.<br>
     */
    PNEUMOKOKKEN_INDIKATIONSSCHEMA_HOHES_RISIKO_ERSTIMPFUNG_AB_3_JAHREN("SCHEMA046",
                                                                        "1.2.40.0.34.5.183",
                                                                        "Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung ab 3 Jahren",
                                                                        "Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung ab 3 Jahren",
                                                                        "TOTRANSLATE",
                                                                        "TOTRANSLATE",
                                                                        "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung bis 1 Jahr.<br>
     */
    PNEUMOKOKKEN_INDIKATIONSSCHEMA_HOHES_RISIKO_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA044",
                                                                       "1.2.40.0.34.5.183",
                                                                       "Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung bis 1 Jahr",
                                                                       "Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung bis 1 Jahr",
                                                                       "TOTRANSLATE",
                                                                       "TOTRANSLATE",
                                                                       "TOTRANSLATE"),
    /**
     * EN: Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung im 2. Lebensjahr.<br>
     */
    PNEUMOKOKKEN_INDIKATIONSSCHEMA_HOHES_RISIKO_ERSTIMPFUNG_IM_2_LEBENSJAHR("SCHEMA045",
                                                                            "1.2.40.0.34.5.183",
                                                                            "Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung im 2. Lebensjahr",
                                                                            "Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung im 2. Lebensjahr",
                                                                            "TOTRANSLATE",
                                                                            "TOTRANSLATE",
                                                                            "TOTRANSLATE"),
    /**
     * EN: Poliomyelitis Indikationsschema ab dem vollendeten 1. Lebensjahr.<br>
     */
    POLIOMYELITIS_INDIKATIONSSCHEMA_AB_DEM_VOLLENDETEN_1_LEBENSJAHR("SCHEMA120",
                                                                    "1.2.40.0.34.5.183",
                                                                    "Poliomyelitis Indikationsschema ab dem vollendeten 1. Lebensjahr",
                                                                    "Poliomyelitis Indikationsschema ab dem vollendeten 1. Lebensjahr",
                                                                    "TOTRANSLATE",
                                                                    "TOTRANSLATE",
                                                                    "TOTRANSLATE"),
    /**
     * EN: Poliomyelitis Indikationsschema ab dem vollendeten 2. Lebensmonat.<br>
     */
    POLIOMYELITIS_INDIKATIONSSCHEMA_AB_DEM_VOLLENDETEN_2_LEBENSMONAT("SCHEMA084",
                                                                     "1.2.40.0.34.5.183",
                                                                     "Poliomyelitis Indikationsschema ab dem vollendeten 2. Lebensmonat",
                                                                     "Poliomyelitis Indikationsschema ab dem vollendeten 2. Lebensmonat",
                                                                     "TOTRANSLATE",
                                                                     "TOTRANSLATE",
                                                                     "TOTRANSLATE"),
    /**
     * EN: Rotavirus.<br>
     */
    ROTAVIRUS("SCHEMA244",
              "1.2.40.0.34.5.183",
              "Rotavirus",
              "Rotavirus",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 20.-24. Lebenswoche, Rotarix.<br>
     */
    ROTAVIRUS_GRUNDSCHEMA_1_DOSIS_ERSTIMPFUNG_AB_DER_VOLLENDETEN_20_24_LEBENSWOCHE_ROTARIX("SCHEMA052",
                                                                                           "1.2.40.0.34.5.183",
                                                                                           "Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 20.-24. Lebenswoche, Rotarix",
                                                                                           "Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 20.-24. Lebenswoche, Rotarix",
                                                                                           "TOTRANSLATE",
                                                                                           "TOTRANSLATE",
                                                                                           "TOTRANSLATE"),
    /**
     * EN: Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 28.-32. Lebenswoche, Rotateq.<br>
     */
    ROTAVIRUS_GRUNDSCHEMA_1_DOSIS_ERSTIMPFUNG_AB_DER_VOLLENDETEN_28_32_LEBENSWOCHE_ROTATEQ("SCHEMA053",
                                                                                           "1.2.40.0.34.5.183",
                                                                                           "Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 28.-32. Lebenswoche, Rotateq",
                                                                                           "Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 28.-32. Lebenswoche, Rotateq",
                                                                                           "TOTRANSLATE",
                                                                                           "TOTRANSLATE",
                                                                                           "TOTRANSLATE"),
    /**
     * EN: Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 24.-28. Lebenswoche, Rotateq.<br>
     */
    ROTAVIRUS_GRUNDSCHEMA_2_DOSEN_ERSTIMPFUNG_AB_DER_VOLLENDETEN_24_28_LEBENSWOCHE_ROTATEQ("SCHEMA051",
                                                                                           "1.2.40.0.34.5.183",
                                                                                           "Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 24.-28. Lebenswoche, Rotateq",
                                                                                           "Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 24.-28. Lebenswoche, Rotateq",
                                                                                           "TOTRANSLATE",
                                                                                           "TOTRANSLATE",
                                                                                           "TOTRANSLATE"),
    /**
     * EN: Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 6.-20. Lebenswoche, Rotarix.<br>
     */
    ROTAVIRUS_GRUNDSCHEMA_2_DOSEN_ERSTIMPFUNG_AB_DER_VOLLENDETEN_6_20_LEBENSWOCHE_ROTARIX("SCHEMA050",
                                                                                          "1.2.40.0.34.5.183",
                                                                                          "Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 6.-20. Lebenswoche, Rotarix",
                                                                                          "Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 6.-20. Lebenswoche, Rotarix",
                                                                                          "TOTRANSLATE",
                                                                                          "TOTRANSLATE",
                                                                                          "TOTRANSLATE"),
    /**
     * EN: Rotavirus Grundschema, 3 Dosen, Erstimpfung ab der vollendeten 6.- 24. Lebenswoche, Rotateq.<br>
     */
    ROTAVIRUS_GRUNDSCHEMA_3_DOSEN_ERSTIMPFUNG_AB_DER_VOLLENDETEN_6_24_LEBENSWOCHE_ROTATEQ("SCHEMA054",
                                                                                          "1.2.40.0.34.5.183",
                                                                                          "Rotavirus Grundschema, 3 Dosen, Erstimpfung ab der vollendeten 6.- 24. Lebenswoche, Rotateq",
                                                                                          "Rotavirus Grundschema, 3 Dosen, Erstimpfung ab der vollendeten 6.- 24. Lebenswoche, Rotateq",
                                                                                          "TOTRANSLATE",
                                                                                          "TOTRANSLATE",
                                                                                          "TOTRANSLATE"),
    /**
     * EN: RSV.<br>
     */
    RSV("SCHEMA245",
        "1.2.40.0.34.5.183",
        "RSV",
        "RSV",
        "TOTRANSLATE",
        "TOTRANSLATE",
        "TOTRANSLATE"),
    /**
     * EN: RSV Grundschema.<br>
     */
    RSV_GRUNDSCHEMA("SCHEMA121",
                    "1.2.40.0.34.5.183",
                    "RSV Grundschema",
                    "RSV Grundschema",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Auslandsimpfung.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_AUSLANDSIMPFUNG("SCHEMA090",
                                           "1.2.40.0.34.5.183",
                                           "SARS-CoV-2 Grundschema, Auslandsimpfung",
                                           "SARS-CoV-2 Grundschema, Auslandsimpfung",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Comirnaty.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_COMIRNATY("SCHEMA086",
                                     "1.2.40.0.34.5.183",
                                     "SARS-CoV-2 Grundschema, Comirnaty",
                                     "SARS-CoV-2 Grundschema, Comirnaty",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Jcovden.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_JCOVDEN("SCHEMA089",
                                   "1.2.40.0.34.5.183",
                                   "SARS-CoV-2 Grundschema, Jcovden",
                                   "SARS-CoV-2 Grundschema, Jcovden",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Nuvaxovid.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_NUVAXOVID("SCHEMA099",
                                     "1.2.40.0.34.5.183",
                                     "SARS-CoV-2 Grundschema, Nuvaxovid",
                                     "SARS-CoV-2 Grundschema, Nuvaxovid",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Spikevax.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_SPIKEVAX("SCHEMA087",
                                    "1.2.40.0.34.5.183",
                                    "SARS-CoV-2 Grundschema, Spikevax",
                                    "SARS-CoV-2 Grundschema, Spikevax",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Valneva.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_VALNEVA("SCHEMA112",
                                   "1.2.40.0.34.5.183",
                                   "SARS-CoV-2 Grundschema, Valneva",
                                   "SARS-CoV-2 Grundschema, Valneva",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Grundschema, Vaxzevria.<br>
     */
    SARS_COV_2_GRUNDSCHEMA_VAXZEVRIA("SCHEMA088",
                                     "1.2.40.0.34.5.183",
                                     "SARS-CoV-2 Grundschema, Vaxzevria",
                                     "SARS-CoV-2 Grundschema, Vaxzevria",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 heterologes Schema (Impfstoffwechsel).<br>
     */
    SARS_COV_2_HETEROLOGES_SCHEMA_IMPFSTOFFWECHSEL("SCHEMA096",
                                                   "1.2.40.0.34.5.183",
                                                   "SARS-CoV-2 heterologes Schema (Impfstoffwechsel)",
                                                   "SARS-CoV-2 heterologes Schema (Impfstoffwechsel)",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Indikationsschema, Comirnaty.<br>
     */
    SARS_COV_2_INDIKATIONSSCHEMA_COMIRNATY("SCHEMA094",
                                           "1.2.40.0.34.5.183",
                                           "SARS-CoV-2 Indikationsschema, Comirnaty",
                                           "SARS-CoV-2 Indikationsschema, Comirnaty",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: SARS-CoV-2 Indikationsschema, Spikevax.<br>
     */
    SARS_COV_2_INDIKATIONSSCHEMA_SPIKEVAX("SCHEMA095",
                                          "1.2.40.0.34.5.183",
                                          "SARS-CoV-2 Indikationsschema, Spikevax",
                                          "SARS-CoV-2 Indikationsschema, Spikevax",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE"),
    /**
     * EN: 6-fach (2+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen.<br>
     */
    SIX_FACH_2_1_DI_TE_PERT_HIB_IPV_HEPB_INKL_AUFFRISCHUNGSIMPFUNGEN("SCHEMA201",
                                                                     "1.2.40.0.34.5.183",
                                                                     "6-fach (2+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen",
                                                                     "6-fach (2+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen",
                                                                     "TOTRANSLATE",
                                                                     "TOTRANSLATE",
                                                                     "TOTRANSLATE"),
    /**
     * EN: 6-fach (3+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen, Indikation.<br>
     */
    SIX_FACH_3_1_DI_TE_PERT_HIB_IPV_HEPB_INKL_AUFFRISCHUNGSIMPFUNGEN_INDIKATION("SCHEMA202",
                                                                                "1.2.40.0.34.5.183",
                                                                                "6-fach (3+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen, Indikation",
                                                                                "6-fach (3+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen, Indikation",
                                                                                "TOTRANSLATE",
                                                                                "TOTRANSLATE",
                                                                                "TOTRANSLATE"),
    /**
     * EN: Tetanus Monokomponente.<br>
     */
    TETANUS_MONOKOMPONENTE("SCHEMA083",
                           "1.2.40.0.34.5.183",
                           "Tetanus Monokomponente",
                           "Tetanus Monokomponente",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Tollwut.<br>
     */
    TOLLWUT("SCHEMA246",
            "1.2.40.0.34.5.183",
            "Tollwut",
            "Tollwut",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Tollwut Grundschema.<br>
     */
    TOLLWUT_GRUNDSCHEMA("SCHEMA070",
                        "1.2.40.0.34.5.183",
                        "Tollwut Grundschema",
                        "Tollwut Grundschema",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionelles Schema, Essen 4 Dosen.<br>
     */
    TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_ESSEN_4_DOSEN("SCHEMA072",
                                                     "1.2.40.0.34.5.183",
                                                     "Tollwut postexpositionelles Schema, Essen 4 Dosen",
                                                     "Tollwut postexpositionelles Schema, Essen 4 Dosen",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionelles Schema, Essen 5 Dosen.<br>
     */
    TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_ESSEN_5_DOSEN("SCHEMA073",
                                                     "1.2.40.0.34.5.183",
                                                     "Tollwut postexpositionelles Schema, Essen 5 Dosen",
                                                     "Tollwut postexpositionelles Schema, Essen 5 Dosen",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE",
                                                     "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionelles Schema, mit Tollwut-Vorimpfung.<br>
     */
    TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_MIT_TOLLWUT_VORIMPFUNG("SCHEMA075",
                                                              "1.2.40.0.34.5.183",
                                                              "Tollwut postexpositionelles Schema, mit Tollwut-Vorimpfung",
                                                              "Tollwut postexpositionelles Schema, mit Tollwut-Vorimpfung",
                                                              "TOTRANSLATE",
                                                              "TOTRANSLATE",
                                                              "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionelles Schema, Zagreb.<br>
     */
    TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_ZAGREB("SCHEMA074",
                                              "1.2.40.0.34.5.183",
                                              "Tollwut postexpositionelles Schema, Zagreb",
                                              "Tollwut postexpositionelles Schema, Zagreb",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionell, Essen.<br>
     */
    TOLLWUT_POSTEXPOSITIONELL_ESSEN("SCHEMA247",
                                    "1.2.40.0.34.5.183",
                                    "Tollwut postexpositionell, Essen",
                                    "Tollwut postexpositionell, Essen",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionell, mit Vorimpfung.<br>
     */
    TOLLWUT_POSTEXPOSITIONELL_MIT_VORIMPFUNG("SCHEMA248",
                                             "1.2.40.0.34.5.183",
                                             "Tollwut postexpositionell, mit Vorimpfung",
                                             "Tollwut postexpositionell, mit Vorimpfung",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE"),
    /**
     * EN: Tollwut postexpositionell, Zagreb.<br>
     */
    TOLLWUT_POSTEXPOSITIONELL_ZAGREB("SCHEMA249",
                                     "1.2.40.0.34.5.183",
                                     "Tollwut postexpositionell, Zagreb",
                                     "Tollwut postexpositionell, Zagreb",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Tollwut Schnellschema.<br>
     */
    TOLLWUT_SCHNELLSCHEMA("SCHEMA071",
                          "1.2.40.0.34.5.183",
                          "Tollwut Schnellschema",
                          "Tollwut Schnellschema",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Tollwut, Schnellschema.<br>
     */
    // TOLLWUT_SCHNELLSCHEMA("SCHEMA250",
    //                       "1.2.40.0.34.5.183",
    //                       "Tollwut, Schnellschema",
    //                       "Tollwut, Schnellschema",
    //                       "TOTRANSLATE",
    //                       "TOTRANSLATE",
    //                       "TOTRANSLATE"),
    /**
     * EN: Tollwut Schnellschema (WHO).<br>
     */
    TOLLWUT_SCHNELLSCHEMA_WHO("SCHEMA123",
                              "1.2.40.0.34.5.183",
                              "Tollwut Schnellschema (WHO)",
                              "Tollwut Schnellschema (WHO)",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Tollwut, Schnellschema (WHO).<br>
     */
    // TOLLWUT_SCHNELLSCHEMA_WHO("SCHEMA251",
    //                           "1.2.40.0.34.5.183",
    //                           "Tollwut, Schnellschema (WHO)",
    //                           "Tollwut, Schnellschema (WHO)",
    //                           "TOTRANSLATE",
    //                           "TOTRANSLATE",
    //                           "TOTRANSLATE"),
    /**
     * EN: Tollwut Schnellschema (WHO), intradermal.<br>
     */
    TOLLWUT_SCHNELLSCHEMA_WHO_INTRADERMAL("SCHEMA124",
                                          "1.2.40.0.34.5.183",
                                          "Tollwut Schnellschema (WHO), intradermal",
                                          "Tollwut Schnellschema (WHO), intradermal",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE"),
    /**
     * EN: Tollwut, Schnellschema (WHO) intradermal.<br>
     */
    // TOLLWUT_SCHNELLSCHEMA_WHO_INTRADERMAL("SCHEMA252",
    //                                       "1.2.40.0.34.5.183",
    //                                       "Tollwut, Schnellschema (WHO) intradermal",
    //                                       "Tollwut, Schnellschema (WHO) intradermal",
    //                                       "TOTRANSLATE",
    //                                       "TOTRANSLATE",
    //                                       "TOTRANSLATE"),
    /**
     * EN: Typhus.<br>
     */
    TYPHUS("SCHEMA253",
           "1.2.40.0.34.5.183",
           "Typhus",
           "Typhus",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Typhus Grundschema, Injektion.<br>
     */
    TYPHUS_GRUNDSCHEMA_INJEKTION("SCHEMA068",
                                 "1.2.40.0.34.5.183",
                                 "Typhus Grundschema, Injektion",
                                 "Typhus Grundschema, Injektion",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Typhus Grundschema, Oral.<br>
     */
    TYPHUS_GRUNDSCHEMA_ORAL("SCHEMA069",
                            "1.2.40.0.34.5.183",
                            "Typhus Grundschema, Oral",
                            "Typhus Grundschema, Oral",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Varizellen.<br>
     */
    VARIZELLEN("SCHEMA254",
               "1.2.40.0.34.5.183",
               "Varizellen",
               "Varizellen",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Varizellen Grundschema, ab 1 Jahr.<br>
     */
    VARIZELLEN_GRUNDSCHEMA_AB_1_JAHR("SCHEMA060",
                                     "1.2.40.0.34.5.183",
                                     "Varizellen Grundschema, ab 1 Jahr",
                                     "Varizellen Grundschema, ab 1 Jahr",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Varizellen, Indikation.<br>
     */
    VARIZELLEN_INDIKATION("SCHEMA255",
                          "1.2.40.0.34.5.183",
                          "Varizellen, Indikation",
                          "Varizellen, Indikation",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Varizellen Indikationsschema, Erstimpfung bis 1 Jahr.<br>
     */
    VARIZELLEN_INDIKATIONSSCHEMA_ERSTIMPFUNG_BIS_1_JAHR("SCHEMA063",
                                                        "1.2.40.0.34.5.183",
                                                        "Varizellen Indikationsschema, Erstimpfung bis 1 Jahr",
                                                        "Varizellen Indikationsschema, Erstimpfung bis 1 Jahr",
                                                        "TOTRANSLATE",
                                                        "TOTRANSLATE",
                                                        "TOTRANSLATE"),
    /**
     * EN: Zoonotische Influenza (H5N8).<br>
     */
    ZOONOTISCHE_INFLUENZA_H5N8("SCHEMA257",
                               "1.2.40.0.34.5.183",
                               "Zoonotische Influenza (H5N8)",
                               "Zoonotische Influenza (H5N8)",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE");

    /**
     * EN: Code for Chikungunya.<br>
     */
    public static final String CHIKUNGUNYA_CODE = "SCHEMA256";

    /**
     * EN: Code for Cholera.<br>
     */
    public static final String CHOLERA_CODE = "SCHEMA203";

    /**
     * EN: Code for Cholera Grundschema, Erstimpfung 2-6 Jahre.<br>
     */
    public static final String CHOLERA_GRUNDSCHEMA_ERSTIMPFUNG_2_6_JAHRE_CODE = "SCHEMA076";

    /**
     * EN: Code for Cholera Grundschema, Erstimpfung ab 6 Jahren.<br>
     */
    public static final String CHOLERA_GRUNDSCHEMA_ERSTIMPFUNG_AB_6_JAHREN_CODE = "SCHEMA078";

    /**
     * EN: Code for COVID-19.<br>
     */
    public static final String COVID_19_CODE = "SCHEMA204";

    /**
     * EN: Code for COVID-19 Grundschema.<br>
     */
    public static final String COVID_19_GRUNDSCHEMA_CODE = "SCHEMA122";

    /**
     * EN: Code for COVID-19 Grundschema, Kleinkind.<br>
     */
    public static final String COVID_19_GRUNDSCHEMA_KLEINKIND_CODE = "SCHEMA117";

    /**
     * EN: Code for COVID-19, Indikation.<br>
     */
    public static final String COVID_19_INDIKATION_CODE = "SCHEMA205";

    /**
     * EN: Code for COVID-19 Indikationsschema.<br>
     */
    public static final String COVID_19_INDIKATIONSSCHEMA_CODE = "SCHEMA110";

    /**
     * EN: Code for COVID-19, Indikation Grundimmunisierung bis 5 Jahre.<br>
     */
    public static final String COVID_19_INDIKATION_GRUNDIMMUNISIERUNG_BIS_5_JAHRE_CODE = "SCHEMA260";

    /**
     * EN: Code for Dengue.<br>
     */
    public static final String DENGUE_CODE = "SCHEMA206";

    /**
     * EN: Code for Dengue-Fieber Grundschema, 2 Dosen.<br>
     */
    public static final String DENGUE_FIEBER_GRUNDSCHEMA_2_DOSEN_CODE = "SCHEMA119";

    /**
     * EN: Code for Di-Te-Pert.<br>
     */
    public static final String DI_TE_PERT_CODE = "SCHEMA207";

    /**
     * EN: Code for Di-Te-Pert-IPV.<br>
     */
    public static final String DI_TE_PERT_IPV_CODE = "SCHEMA208";

    /**
     * EN: Code for Di-Te-Pert-IPV, Indikation.<br>
     */
    public static final String DI_TE_PERT_IPV_INDIKATION_CODE = "SCHEMA259";

    /**
     * EN: Code for FSME.<br>
     */
    public static final String FSME_CODE = "SCHEMA209";

    /**
     * EN: Code for FSME, beschleunigtes konventionelles Schema.<br>
     */
    public static final String FSME_BESCHLEUNIGTES_KONVENTIONELLES_SCHEMA_CODE = "SCHEMA210";

    /**
     * EN: Code for FSME beschleunigtes konventionelles Schema, Encepur.<br>
     */
    public static final String FSME_BESCHLEUNIGTES_KONVENTIONELLES_SCHEMA_ENCEPUR_CODE = "SCHEMA126";

    /**
     * EN: Code for FSME Grundschema, Encepur.<br>
     */
    public static final String FSME_GRUNDSCHEMA_ENCEPUR_CODE = "SCHEMA006";

    /**
     * EN: Code for FSME Grundschema, Encepur, Erstimpfung bis 1 Jahr.<br>
     */
    public static final String FSME_GRUNDSCHEMA_ENCEPUR_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA008";

    /**
     * EN: Code for FSME Grundschema, FSME-Immun.<br>
     */
    public static final String FSME_GRUNDSCHEMA_FSME_IMMUN_CODE = "SCHEMA005";

    /**
     * EN: Code for FSME Grundschema, FSME-Immun, Erstimpfung bis 1 Jahr.<br>
     */
    public static final String FSME_GRUNDSCHEMA_FSME_IMMUN_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA007";

    /**
     * EN: Code for FSME, Schnellschema.<br>
     */
    public static final String FSME_SCHNELLSCHEMA_CODE = "SCHEMA211";

    /**
     * EN: Code for FSME Schnellschema, Encepur.<br>
     */
    public static final String FSME_SCHNELLSCHEMA_ENCEPUR_CODE = "SCHEMA010";

    /**
     * EN: Code for FSME Schnellschema, FSME-Immun.<br>
     */
    public static final String FSME_SCHNELLSCHEMA_FSME_IMMUN_CODE = "SCHEMA009";

    /**
     * EN: Code for Gelbfieber.<br>
     */
    public static final String GELBFIEBER_CODE = "SCHEMA212";

    /**
     * EN: Code for Gelbfieber Grundschema, ab dem vollendeten 9. Lebensmonat.<br>
     */
    public static final String GELBFIEBER_GRUNDSCHEMA_AB_DEM_VOLLENDETEN_9_LEBENSMONAT_CODE = "SCHEMA065";

    /**
     * EN: Code for Haemophilus influenzae Typ B Indikationsschema.<br>
     */
    public static final String HAEMOPHILUS_INFLUENZAE_TYP_B_INDIKATIONSSCHEMA_CODE = "SCHEMA011";

    /**
     * EN: Code for Hepatitis A.<br>
     */
    public static final String HEPATITIS_A_CODE = "SCHEMA213";

    /**
     * EN: Code for Hepatitis AB.<br>
     */
    public static final String HEPATITIS_AB_CODE = "SCHEMA215";

    /**
     * EN: Code for Hepatitis AB Grundschema.<br>
     */
    public static final String HEPATITIS_AB_GRUNDSCHEMA_CODE = "SCHEMA013";

    /**
     * EN: Code for Hepatitis AB Schnellschema.<br>
     */
    public static final String HEPATITIS_AB_SCHNELLSCHEMA_CODE = "SCHEMA015";

    /**
     * EN: Code for Hepatitis AB, Schnellschema.<br>
     */
    // public static final String HEPATITIS_AB_SCHNELLSCHEMA_CODE = "SCHEMA258";

    /**
     * EN: Code for Hepatitis A Monokomponente Grundschema.<br>
     */
    public static final String HEPATITIS_A_MONOKOMPONENTE_GRUNDSCHEMA_CODE = "SCHEMA014";

    /**
     * EN: Code for Hepatitis A Monokomponente Indikationsschema.<br>
     */
    public static final String HEPATITIS_A_MONOKOMPONENTE_INDIKATIONSSCHEMA_CODE = "SCHEMA012";

    /**
     * EN: Code for Hepatitis A &amp; Typhus Grundschema.<br>
     */
    public static final String HEPATITIS_A_TYPHUS_GRUNDSCHEMA_CODE = "SCHEMA016";

    /**
     * EN: Code for Hepatitis B.<br>
     */
    public static final String HEPATITIS_B_CODE = "SCHEMA216";

    /**
     * EN: Code for Hepatitis B, Indikation.<br>
     */
    public static final String HEPATITIS_B_INDIKATION_CODE = "SCHEMA217";

    /**
     * EN: Code for Hepatitis B, Indikation Prophylaxe Neugeborener.<br>
     */
    public static final String HEPATITIS_B_INDIKATION_PROPHYLAXE_NEUGEBORENER_CODE = "SCHEMA218";

    /**
     * EN: Code for Hepatitis B Monokomponente Grundschema.<br>
     */
    public static final String HEPATITIS_B_MONOKOMPONENTE_GRUNDSCHEMA_CODE = "SCHEMA017";

    /**
     * EN: Code for Hepatitis B Monokomponente Indikationsschema.<br>
     */
    public static final String HEPATITIS_B_MONOKOMPONENTE_INDIKATIONSSCHEMA_CODE = "SCHEMA085";

    /**
     * EN: Code for Hepatitis B Monokomponente Schnellschema durch Indikation.<br>
     */
    public static final String HEPATITIS_B_MONOKOMPONENTE_SCHNELLSCHEMA_DURCH_INDIKATION_CODE = "SCHEMA102";

    /**
     * EN: Code for Hepatitis B Non-/Low-Responder Indikationsschema.<br>
     */
    public static final String HEPATITIS_B_NON_LOW_RESPONDER_INDIKATIONSSCHEMA_CODE = "SCHEMA019";

    /**
     * EN: Code for Hepatitis B Prophylaxe Neugeborener Indikationsschema.<br>
     */
    public static final String HEPATITIS_B_PROPHYLAXE_NEUGEBORENER_INDIKATIONSSCHEMA_CODE = "SCHEMA103";

    /**
     * EN: Code for Hepatitis B, Schnellschema.<br>
     */
    public static final String HEPATITIS_B_SCHNELLSCHEMA_CODE = "SCHEMA219";

    /**
     * EN: Code for Herpes Zoster.<br>
     */
    public static final String HERPES_ZOSTER_CODE = "SCHEMA220";

    /**
     * EN: Code for Herpes Zoster Grundschema, ab 50 Jahren.<br>
     */
    public static final String HERPES_ZOSTER_GRUNDSCHEMA_AB_50_JAHREN_CODE = "SCHEMA064";

    /**
     * EN: Code for Herpes Zoster Grundschema, nach Zostavax.<br>
     */
    public static final String HERPES_ZOSTER_GRUNDSCHEMA_NACH_ZOSTAVAX_CODE = "SCHEMA091";

    /**
     * EN: Code for Herpes Zoster, Indikation.<br>
     */
    public static final String HERPES_ZOSTER_INDIKATION_CODE = "SCHEMA221";

    /**
     * EN: Code for Herpes Zoster Indikationsschema, ab 18 Jahren.<br>
     */
    public static final String HERPES_ZOSTER_INDIKATIONSSCHEMA_AB_18_JAHREN_CODE = "SCHEMA092";

    /**
     * EN: Code for HiB, Indikation.<br>
     */
    public static final String HIB_INDIKATION_CODE = "SCHEMA222";

    /**
     * EN: Code for HPV.<br>
     */
    public static final String HPV_CODE = "SCHEMA223";

    /**
     * EN: Code for HPV Grundschema.<br>
     */
    public static final String HPV_GRUNDSCHEMA_CODE = "SCHEMA020";

    /**
     * EN: Code for HPV Grundschema, ab 21 Jahren.<br>
     */
    public static final String HPV_GRUNDSCHEMA_AB_21_JAHREN_CODE = "SCHEMA021";

    /**
     * EN: Code for HPV, Indikation.<br>
     */
    public static final String HPV_INDIKATION_CODE = "SCHEMA224";

    /**
     * EN: Code for HPV Indikationsschema.<br>
     */
    public static final String HPV_INDIKATIONSSCHEMA_CODE = "SCHEMA022";

    /**
     * EN: Code for Influenza.<br>
     */
    public static final String INFLUENZA_CODE = "SCHEMA225";

    /**
     * EN: Code for Influenza Grundschema, Einmalimpfung.<br>
     */
    public static final String INFLUENZA_GRUNDSCHEMA_EINMALIMPFUNG_CODE = "SCHEMA024";

    /**
     * EN: Code for Influenza Grundschema, Erstimpfung Kinder.<br>
     */
    public static final String INFLUENZA_GRUNDSCHEMA_ERSTIMPFUNG_KINDER_CODE = "SCHEMA023";

    /**
     * EN: Code for Influenza, Indikation.<br>
     */
    public static final String INFLUENZA_INDIKATION_CODE = "SCHEMA226";

    /**
     * EN: Code for Influenza Indikationsschema.<br>
     */
    public static final String INFLUENZA_INDIKATIONSSCHEMA_CODE = "SCHEMA104";

    /**
     * EN: Code for Japanische Enzephalitis.<br>
     */
    public static final String JAPANISCHE_ENZEPHALITIS_CODE = "SCHEMA227";

    /**
     * EN: Code for Japanische Enzephalitis Grundschema, ab 2 Monaten.<br>
     */
    public static final String JAPANISCHE_ENZEPHALITIS_GRUNDSCHEMA_AB_2_MONATEN_CODE = "SCHEMA066";

    /**
     * EN: Code for Japanische Enzephalitis, Schnellschema.<br>
     */
    public static final String JAPANISCHE_ENZEPHALITIS_SCHNELLSCHEMA_CODE = "SCHEMA228";

    /**
     * EN: Code for Japanische Enzephalitis Schnellschema, ab 18 Jahren.<br>
     */
    public static final String JAPANISCHE_ENZEPHALITIS_SCHNELLSCHEMA_AB_18_JAHREN_CODE = "SCHEMA067";

    /**
     * EN: Code for Kombinationsschema Di-Te.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_CODE = "SCHEMA082";

    /**
     * EN: Code for Kombinationsschema Di-Te-IPV.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_IPV_CODE = "SCHEMA105";

    /**
     * EN: Code for Kombinationsschema Di-Te-Pert.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_PERT_CODE = "SCHEMA081";

    /**
     * EN: Code for Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung ab 1 Jahr.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_PERT_HIB_IPV_HEPB_ERSTIMPFUNG_AB_1_JAHR_CODE = "SCHEMA002";

    /**
     * EN: Code for Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Erstimpfung bis 1 Jahr.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_PERT_HIB_IPV_HEPB_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA001";

    /**
     * EN: Code for Kombinationsschema Di-Te-Pert-HiB-IPV-HepB, Indikation.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_PERT_HIB_IPV_HEPB_INDIKATION_CODE = "SCHEMA004";

    /**
     * EN: Code for Kombinationsschema Di-Te-Pert-IPV.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_PERT_IPV_CODE = "SCHEMA080";

    /**
     * EN: Code for Kombinationsschema Di-Te-Pert-IPV-HepB, Erstimpfung ab 6 Jahren.<br>
     */
    public static final String KOMBINATIONSSCHEMA_DI_TE_PERT_IPV_HEPB_ERSTIMPFUNG_AB_6_JAHREN_CODE = "SCHEMA003";

    /**
     * EN: Code for Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMRV.<br>
     */
    public static final String KOMBINATIONSSCHEMA_MMRV_AB_12_MONATEN_MMRV_MMRV_CODE = "SCHEMA101";

    /**
     * EN: Code for Kombinationsschema MMRV, ab 12 Monaten, MMRV - MMR - V.<br>
     */
    public static final String KOMBINATIONSSCHEMA_MMRV_AB_12_MONATEN_MMRV_MMR_V_CODE = "SCHEMA114";

    /**
     * EN: Code for Kombinationsschema MMRV, ab 12 Monaten, MMR - MMRV - V.<br>
     */
    public static final String KOMBINATIONSSCHEMA_MMRV_AB_12_MONATEN_MMR_MMRV_V_CODE = "SCHEMA062";

    /**
     * EN: Code for Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMRV.<br>
     */
    public static final String KOMBINATIONSSCHEMA_MMRV_AB_9_MONATEN_MMRV_MMRV_CODE = "SCHEMA100";

    /**
     * EN: Code for Kombinationsschema MMRV, ab 9 Monaten, MMRV - MMR - V.<br>
     */
    public static final String KOMBINATIONSSCHEMA_MMRV_AB_9_MONATEN_MMRV_MMR_V_CODE = "SCHEMA113";

    /**
     * EN: Code for Kombinationsschema MMRV, ab 9 Monaten, MMR - MMRV - V.<br>
     */
    public static final String KOMBINATIONSSCHEMA_MMRV_AB_9_MONATEN_MMR_MMRV_V_CODE = "SCHEMA061";

    /**
     * EN: Code for Meningokokken ACWY.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_CODE = "SCHEMA229";

    /**
     * EN: Code for Meningokokken ACWY, ab 1 Jahr.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_AB_1_JAHR_CODE = "SCHEMA125";

    /**
     * EN: Code for Meningokokken ACWY Grundschema, ab 10 Jahren.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_GRUNDSCHEMA_AB_10_JAHREN_CODE = "SCHEMA039";

    /**
     * EN: Code for Meningokokken ACWY, Indikation.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATION_CODE = "SCHEMA230";

    /**
     * EN: Code for Meningokokken ACWY Indikationsschema, ab 1 Jahr.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_AB_1_JAHR_CODE = "SCHEMA040";

    /**
     * EN: Code for Meningokokken ACWY Indikationsschema, Erstimpfung bis 1 Jahr.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA041";

    /**
     * EN: Code for Meningokokken ACWY Indikationsschema, Menveo ab 2 Jahre.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_MENVEO_AB_2_JAHRE_CODE = "SCHEMA109";

    /**
     * EN: Code for Meningokokken ACWY Indikationsschema, Nimenrix ab 1 Jahr.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_NIMENRIX_AB_1_JAHR_CODE = "SCHEMA108";

    /**
     * EN: Code for Meningokokken ACWY Indikationsschema, Nimenrix ab 6 Monate.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_NIMENRIX_AB_6_MONATE_CODE = "SCHEMA107";

    /**
     * EN: Code for Meningokokken ACWY Indikationsschema, Nimenrix bis 6 Monate.<br>
     */
    public static final String MENINGOKOKKEN_ACWY_INDIKATIONSSCHEMA_NIMENRIX_BIS_6_MONATE_CODE = "SCHEMA106";

    /**
     * EN: Code for Meningokokken B.<br>
     */
    public static final String MENINGOKOKKEN_B_CODE = "SCHEMA231";

    /**
     * EN: Code for Meningokokken B Grundschema, Erstimpfung 10-25 Jahre, Trumenba.<br>
     */
    public static final String MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_10_25_JAHRE_TRUMENBA_CODE = "SCHEMA079";

    /**
     * EN: Code for Meningokokken B Grundschema, Erstimpfung 12-23 Monate.<br>
     */
    public static final String MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_12_23_MONATE_CODE = "SCHEMA031";

    /**
     * EN: Code for Meningokokken B Grundschema, Erstimpfung 2-25 Jahre, Bexsero.<br>
     */
    public static final String MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_2_25_JAHRE_BEXSERO_CODE = "SCHEMA032";

    /**
     * EN: Code for Meningokokken B Grundschema, Erstimpfung 2-5 Monate.<br>
     */
    public static final String MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_2_5_MONATE_CODE = "SCHEMA029";

    /**
     * EN: Code for Meningokokken B Grundschema, Erstimpfung 2-5 Monate, 4 Dosen.<br>
     */
    public static final String MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_2_5_MONATE_4_DOSEN_CODE = "SCHEMA028";

    /**
     * EN: Code for Meningokokken B Grundschema, Erstimpfung 6-11 Monate.<br>
     */
    public static final String MENINGOKOKKEN_B_GRUNDSCHEMA_ERSTIMPFUNG_6_11_MONATE_CODE = "SCHEMA030";

    /**
     * EN: Code for Meningokokken B, Indikation.<br>
     */
    public static final String MENINGOKOKKEN_B_INDIKATION_CODE = "SCHEMA232";

    /**
     * EN: Code for Meningokokken B Indikationsschema, ab 25 Jahren, Bexsero.<br>
     */
    public static final String MENINGOKOKKEN_B_INDIKATIONSSCHEMA_AB_25_JAHREN_BEXSERO_CODE = "SCHEMA033";

    /**
     * EN: Code for Meningokokken B Indikationsschema, ab 25 Jahren, Trumenba.<br>
     */
    public static final String MENINGOKOKKEN_B_INDIKATIONSSCHEMA_AB_25_JAHREN_TRUMENBA_CODE = "SCHEMA034";

    /**
     * EN: Code for Meningokokken C.<br>
     */
    public static final String MENINGOKOKKEN_C_CODE = "SCHEMA233";

    /**
     * EN: Code for Meningokokken C Grundschema, ab 1 Jahr.<br>
     */
    public static final String MENINGOKOKKEN_C_GRUNDSCHEMA_AB_1_JAHR_CODE = "SCHEMA038";

    /**
     * EN: Code for Meningokokken C Indikationsschema, 2-12 Monate, Menjugate.<br>
     */
    public static final String MENINGOKOKKEN_C_INDIKATIONSSCHEMA_2_12_MONATE_MENJUGATE_CODE = "SCHEMA036";

    /**
     * EN: Code for Meningokokken C Indikationsschema, 2-4 Monate, Neisvac C.<br>
     */
    public static final String MENINGOKOKKEN_C_INDIKATIONSSCHEMA_2_4_MONATE_NEISVAC_C_CODE = "SCHEMA035";

    /**
     * EN: Code for Meningokokken C Indikationsschema, 4-12 Monate, Neisvac C.<br>
     */
    public static final String MENINGOKOKKEN_C_INDIKATIONSSCHEMA_4_12_MONATE_NEISVAC_C_CODE = "SCHEMA037";

    /**
     * EN: Code for MMR.<br>
     */
    public static final String MMR_CODE = "SCHEMA234";

    /**
     * EN: Code for MMRV.<br>
     */
    public static final String MMRV_CODE = "SCHEMA237";

    /**
     * EN: Code for MMR Grundschema, ab 1 Jahr.<br>
     */
    public static final String MMR_GRUNDSCHEMA_AB_1_JAHR_CODE = "SCHEMA093";

    /**
     * EN: Code for MMR Grundschema ab 9 Monaten.<br>
     */
    public static final String MMR_GRUNDSCHEMA_AB_9_MONATEN_CODE = "SCHEMA025";

    /**
     * EN: Code for MMR, Indikation.<br>
     */
    public static final String MMR_INDIKATION_CODE = "SCHEMA236";

    /**
     * EN: Code for MMR Indikationsschema, Erstimpfung 6-8 Monate.<br>
     */
    public static final String MMR_INDIKATIONSSCHEMA_ERSTIMPFUNG_6_8_MONATE_CODE = "SCHEMA027";

    /**
     * EN: Code for MMR - MMRV - V.<br>
     */
    public static final String MMR_MMRV_V_CODE = "SCHEMA235";

    /**
     * EN: Code for Mpox.<br>
     */
    public static final String MPOX_CODE = "SCHEMA238";

    /**
     * EN: Code for Mpox/Pocken Indikationsschema.<br>
     */
    public static final String MPOX_POCKEN_INDIKATIONSSCHEMA_CODE = "SCHEMA111";

    /**
     * EN: Code for Mpox/Pocken Indikationsschema, einmalige Impfung.<br>
     */
    public static final String MPOX_POCKEN_INDIKATIONSSCHEMA_EINMALIGE_IMPFUNG_CODE = "SCHEMA115";

    /**
     * EN: Code for Pneumokokken.<br>
     */
    public static final String PNEUMOKOKKEN_CODE = "SCHEMA239";

    /**
     * EN: Code for Pneumokokken, Frühgeborene (3+1).<br>
     */
    public static final String PNEUMOKOKKEN_FR_HGEBORENE_3_1_CODE = "SCHEMA241";

    /**
     * EN: Code for Pneumokokken, Frühgeborene mit Indikation (3+1).<br>
     */
    public static final String PNEUMOKOKKEN_FR_HGEBORENE_MIT_INDIKATION_3_1_CODE = "SCHEMA243";

    /**
     * EN: Code for Pneumokokken Grundschema, ab 60 Jahre.<br>
     */
    public static final String PNEUMOKOKKEN_GRUNDSCHEMA_AB_60_JAHRE_CODE = "SCHEMA098";

    /**
     * EN: Code for Pneumokokken Grundschema, Erstimpfung 1-2 Jahre.<br>
     */
    public static final String PNEUMOKOKKEN_GRUNDSCHEMA_ERSTIMPFUNG_1_2_JAHRE_CODE = "SCHEMA043";

    /**
     * EN: Code for Pneumokokken Grundschema, Erstimpfung 2-5 Jahre.<br>
     */
    public static final String PNEUMOKOKKEN_GRUNDSCHEMA_ERSTIMPFUNG_2_5_JAHRE_CODE = "SCHEMA097";

    /**
     * EN: Code for Pneumokokken Grundschema, Erstimpfung bis 1 Jahr.<br>
     */
    public static final String PNEUMOKOKKEN_GRUNDSCHEMA_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA042";

    /**
     * EN: Code for Pneumokokken, Indikation.<br>
     */
    public static final String PNEUMOKOKKEN_INDIKATION_CODE = "SCHEMA242";

    /**
     * EN: Code for Pneumokokken Indikationsschema (erhöhtes Risiko), ab 50 Jahren.<br>
     */
    public static final String PNEUMOKOKKEN_INDIKATIONSSCHEMA_ERH_HTES_RISIKO_AB_50_JAHREN_CODE = "SCHEMA116";

    /**
     * EN: Code for Pneumokokken Indikationsschema, Frühgeborene.<br>
     */
    public static final String PNEUMOKOKKEN_INDIKATIONSSCHEMA_FR_HGEBORENE_CODE = "SCHEMA118";

    /**
     * EN: Code for Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung ab 3 Jahren.<br>
     */
    public static final String PNEUMOKOKKEN_INDIKATIONSSCHEMA_HOHES_RISIKO_ERSTIMPFUNG_AB_3_JAHREN_CODE = "SCHEMA046";

    /**
     * EN: Code for Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung bis 1 Jahr.<br>
     */
    public static final String PNEUMOKOKKEN_INDIKATIONSSCHEMA_HOHES_RISIKO_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA044";

    /**
     * EN: Code for Pneumokokken Indikationsschema (hohes Risiko), Erstimpfung im 2. Lebensjahr.<br>
     */
    public static final String PNEUMOKOKKEN_INDIKATIONSSCHEMA_HOHES_RISIKO_ERSTIMPFUNG_IM_2_LEBENSJAHR_CODE = "SCHEMA045";

    /**
     * EN: Code for Poliomyelitis Indikationsschema ab dem vollendeten 1. Lebensjahr.<br>
     */
    public static final String POLIOMYELITIS_INDIKATIONSSCHEMA_AB_DEM_VOLLENDETEN_1_LEBENSJAHR_CODE = "SCHEMA120";

    /**
     * EN: Code for Poliomyelitis Indikationsschema ab dem vollendeten 2. Lebensmonat.<br>
     */
    public static final String POLIOMYELITIS_INDIKATIONSSCHEMA_AB_DEM_VOLLENDETEN_2_LEBENSMONAT_CODE = "SCHEMA084";

    /**
     * EN: Code for Rotavirus.<br>
     */
    public static final String ROTAVIRUS_CODE = "SCHEMA244";

    /**
     * EN: Code for Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 20.-24. Lebenswoche, Rotarix.<br>
     */
    public static final String ROTAVIRUS_GRUNDSCHEMA_1_DOSIS_ERSTIMPFUNG_AB_DER_VOLLENDETEN_20_24_LEBENSWOCHE_ROTARIX_CODE = "SCHEMA052";

    /**
     * EN: Code for Rotavirus Grundschema, 1 Dosis, Erstimpfung ab der vollendeten 28.-32. Lebenswoche, Rotateq.<br>
     */
    public static final String ROTAVIRUS_GRUNDSCHEMA_1_DOSIS_ERSTIMPFUNG_AB_DER_VOLLENDETEN_28_32_LEBENSWOCHE_ROTATEQ_CODE = "SCHEMA053";

    /**
     * EN: Code for Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 24.-28. Lebenswoche, Rotateq.<br>
     */
    public static final String ROTAVIRUS_GRUNDSCHEMA_2_DOSEN_ERSTIMPFUNG_AB_DER_VOLLENDETEN_24_28_LEBENSWOCHE_ROTATEQ_CODE = "SCHEMA051";

    /**
     * EN: Code for Rotavirus Grundschema, 2 Dosen, Erstimpfung ab der vollendeten 6.-20. Lebenswoche, Rotarix.<br>
     */
    public static final String ROTAVIRUS_GRUNDSCHEMA_2_DOSEN_ERSTIMPFUNG_AB_DER_VOLLENDETEN_6_20_LEBENSWOCHE_ROTARIX_CODE = "SCHEMA050";

    /**
     * EN: Code for Rotavirus Grundschema, 3 Dosen, Erstimpfung ab der vollendeten 6.- 24. Lebenswoche, Rotateq.<br>
     */
    public static final String ROTAVIRUS_GRUNDSCHEMA_3_DOSEN_ERSTIMPFUNG_AB_DER_VOLLENDETEN_6_24_LEBENSWOCHE_ROTATEQ_CODE = "SCHEMA054";

    /**
     * EN: Code for RSV.<br>
     */
    public static final String RSV_CODE = "SCHEMA245";

    /**
     * EN: Code for RSV Grundschema.<br>
     */
    public static final String RSV_GRUNDSCHEMA_CODE = "SCHEMA121";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Auslandsimpfung.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_AUSLANDSIMPFUNG_CODE = "SCHEMA090";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Comirnaty.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_COMIRNATY_CODE = "SCHEMA086";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Jcovden.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_JCOVDEN_CODE = "SCHEMA089";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Nuvaxovid.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_NUVAXOVID_CODE = "SCHEMA099";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Spikevax.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_SPIKEVAX_CODE = "SCHEMA087";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Valneva.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_VALNEVA_CODE = "SCHEMA112";

    /**
     * EN: Code for SARS-CoV-2 Grundschema, Vaxzevria.<br>
     */
    public static final String SARS_COV_2_GRUNDSCHEMA_VAXZEVRIA_CODE = "SCHEMA088";

    /**
     * EN: Code for SARS-CoV-2 heterologes Schema (Impfstoffwechsel).<br>
     */
    public static final String SARS_COV_2_HETEROLOGES_SCHEMA_IMPFSTOFFWECHSEL_CODE = "SCHEMA096";

    /**
     * EN: Code for SARS-CoV-2 Indikationsschema, Comirnaty.<br>
     */
    public static final String SARS_COV_2_INDIKATIONSSCHEMA_COMIRNATY_CODE = "SCHEMA094";

    /**
     * EN: Code for SARS-CoV-2 Indikationsschema, Spikevax.<br>
     */
    public static final String SARS_COV_2_INDIKATIONSSCHEMA_SPIKEVAX_CODE = "SCHEMA095";

    /**
     * EN: Code for 6-fach (2+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen.<br>
     */
    public static final String SIX_FACH_2_1_DI_TE_PERT_HIB_IPV_HEPB_INKL_AUFFRISCHUNGSIMPFUNGEN_CODE = "SCHEMA201";

    /**
     * EN: Code for 6-fach (3+1) Di-Te-Pert-HiB-IPV-HepB inkl. Auffrischungsimpfungen, Indikation.<br>
     */
    public static final String SIX_FACH_3_1_DI_TE_PERT_HIB_IPV_HEPB_INKL_AUFFRISCHUNGSIMPFUNGEN_INDIKATION_CODE = "SCHEMA202";

    /**
     * EN: Code for Tetanus Monokomponente.<br>
     */
    public static final String TETANUS_MONOKOMPONENTE_CODE = "SCHEMA083";

    /**
     * EN: Code for Tollwut.<br>
     */
    public static final String TOLLWUT_CODE = "SCHEMA246";

    /**
     * EN: Code for Tollwut Grundschema.<br>
     */
    public static final String TOLLWUT_GRUNDSCHEMA_CODE = "SCHEMA070";

    /**
     * EN: Code for Tollwut postexpositionelles Schema, Essen 4 Dosen.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_ESSEN_4_DOSEN_CODE = "SCHEMA072";

    /**
     * EN: Code for Tollwut postexpositionelles Schema, Essen 5 Dosen.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_ESSEN_5_DOSEN_CODE = "SCHEMA073";

    /**
     * EN: Code for Tollwut postexpositionelles Schema, mit Tollwut-Vorimpfung.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_MIT_TOLLWUT_VORIMPFUNG_CODE = "SCHEMA075";

    /**
     * EN: Code for Tollwut postexpositionelles Schema, Zagreb.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELLES_SCHEMA_ZAGREB_CODE = "SCHEMA074";

    /**
     * EN: Code for Tollwut postexpositionell, Essen.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELL_ESSEN_CODE = "SCHEMA247";

    /**
     * EN: Code for Tollwut postexpositionell, mit Vorimpfung.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELL_MIT_VORIMPFUNG_CODE = "SCHEMA248";

    /**
     * EN: Code for Tollwut postexpositionell, Zagreb.<br>
     */
    public static final String TOLLWUT_POSTEXPOSITIONELL_ZAGREB_CODE = "SCHEMA249";

    /**
     * EN: Code for Tollwut Schnellschema.<br>
     */
    public static final String TOLLWUT_SCHNELLSCHEMA_CODE = "SCHEMA071";

    /**
     * EN: Code for Tollwut, Schnellschema.<br>
     */
    // public static final String TOLLWUT_SCHNELLSCHEMA_CODE = "SCHEMA250";

    /**
     * EN: Code for Tollwut Schnellschema (WHO).<br>
     */
    public static final String TOLLWUT_SCHNELLSCHEMA_WHO_CODE = "SCHEMA123";

    /**
     * EN: Code for Tollwut, Schnellschema (WHO).<br>
     */
    // public static final String TOLLWUT_SCHNELLSCHEMA_WHO_CODE = "SCHEMA251";

    /**
     * EN: Code for Tollwut Schnellschema (WHO), intradermal.<br>
     */
    public static final String TOLLWUT_SCHNELLSCHEMA_WHO_INTRADERMAL_CODE = "SCHEMA124";

    /**
     * EN: Code for Tollwut, Schnellschema (WHO) intradermal.<br>
     */
    // public static final String TOLLWUT_SCHNELLSCHEMA_WHO_INTRADERMAL_CODE = "SCHEMA252";

    /**
     * EN: Code for Typhus.<br>
     */
    public static final String TYPHUS_CODE = "SCHEMA253";

    /**
     * EN: Code for Typhus Grundschema, Injektion.<br>
     */
    public static final String TYPHUS_GRUNDSCHEMA_INJEKTION_CODE = "SCHEMA068";

    /**
     * EN: Code for Typhus Grundschema, Oral.<br>
     */
    public static final String TYPHUS_GRUNDSCHEMA_ORAL_CODE = "SCHEMA069";

    /**
     * EN: Code for Varizellen.<br>
     */
    public static final String VARIZELLEN_CODE = "SCHEMA254";

    /**
     * EN: Code for Varizellen Grundschema, ab 1 Jahr.<br>
     */
    public static final String VARIZELLEN_GRUNDSCHEMA_AB_1_JAHR_CODE = "SCHEMA060";

    /**
     * EN: Code for Varizellen, Indikation.<br>
     */
    public static final String VARIZELLEN_INDIKATION_CODE = "SCHEMA255";

    /**
     * EN: Code for Varizellen Indikationsschema, Erstimpfung bis 1 Jahr.<br>
     */
    public static final String VARIZELLEN_INDIKATIONSSCHEMA_ERSTIMPFUNG_BIS_1_JAHR_CODE = "SCHEMA063";

    /**
     * EN: Code for Zoonotische Influenza (H5N8).<br>
     */
    public static final String ZOONOTISCHE_INFLUENZA_H5N8_CODE = "SCHEMA257";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.5";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "eimpf-impfschema";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "1.2.40.0.34.5.183";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EimpfImpfschema getEnum(@Nullable final String code) {
        for (final EimpfImpfschema x : values()) {
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
            Enum.valueOf(EimpfImpfschema.class,
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
        for (final EimpfImpfschema x : values()) {
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
    EimpfImpfschema(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
