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
 * Enumeration of elga-practicesetting values
 * <p>
 * EN: Describes the assignment of a document to a medical area. These codes are used within XDS Metadata attribute "practiceSettingCode". Terminologies are inherited from "Österreichische Strukturplan Gesundheit" as far as possilbe. Opposite to this piece of work, some concepts are newly introduced. Where differentiation was reasonable, concepts were conducted in more detail. More concepts will be added if necessary, especially for physiotherapy, ergotherapy a.s.f.. A CDA implementation guide may specify the use of this codes. <br/>.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.75<br>
 * Effective date: 2020-05-25 09:52<br>
 * Version: 202005(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2026-02-19")
public enum ElgaPracticesetting implements ValueSetEnumInterface {

    /**
     * EN: Akutgeriatrie/Remobilisation.<br>
     */
    AKUTGERIATRIE_REMOBILISATION("F056",
                                 "1.2.40.0.34.5.12",
                                 "Akutgeriatrie/Remobilisation",
                                 "Akutgeriatrie/Remobilisation",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Allgemeinmedizin.<br>
     */
    ALLGEMEINMEDIZIN("F001",
                     "1.2.40.0.34.5.12",
                     "Allgemeinmedizin",
                     "Allgemeinmedizin",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Anästhesiologie und Intensivmedizin.<br>
     */
    AN_STHESIOLOGIE_UND_INTENSIVMEDIZIN("F002",
                                        "1.2.40.0.34.5.12",
                                        "Anästhesiologie und Intensivmedizin",
                                        "Anästhesiologie und Intensivmedizin",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Augenheilkunde.<br>
     */
    AUGENHEILKUNDE("F005",
                   "1.2.40.0.34.5.12",
                   "Augenheilkunde",
                   "Augenheilkunde",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Blutgruppenserologie und Transfusionsmedizin.<br>
     */
    BLUTGRUPPENSEROLOGIE_UND_TRANSFUSIONSMEDIZIN("F006",
                                                 "1.2.40.0.34.5.12",
                                                 "Blutgruppenserologie und Transfusionsmedizin",
                                                 "Blutgruppenserologie und Transfusionsmedizin",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: Chirurgie.<br>
     */
    CHIRURGIE("F007",
              "1.2.40.0.34.5.12",
              "Chirurgie",
              "Chirurgie",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Dermatologie.<br>
     */
    DERMATOLOGIE("F015",
                 "1.2.40.0.34.5.12",
                 "Dermatologie",
                 "Dermatologie",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Gesundheits- und Krankenpflege.<br>
     */
    GESUNDHEITS_UND_KRANKENPFLEGE("F057",
                                  "1.2.40.0.34.5.12",
                                  "Gesundheits- und Krankenpflege",
                                  "Gesundheits- und Krankenpflege",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Gynäkologie und Geburtshilfe.<br>
     */
    GYN_KOLOGIE_UND_GEBURTSHILFE("F010",
                                 "1.2.40.0.34.5.12",
                                 "Gynäkologie und Geburtshilfe",
                                 "Gynäkologie und Geburtshilfe",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Hals-, Nasen- und Ohrenheilkunde.<br>
     */
    HALS_NASEN_UND_OHRENHEILKUNDE("F014",
                                  "1.2.40.0.34.5.12",
                                  "Hals-, Nasen- und Ohrenheilkunde",
                                  "Hals-, Nasen- und Ohrenheilkunde",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Herzchirurgie.<br>
     */
    HERZCHIRURGIE("F058",
                  "1.2.40.0.34.5.12",
                  "Herzchirurgie",
                  "Herzchirurgie",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Innere Medizin.<br>
     */
    INNERE_MEDIZIN("F019",
                   "1.2.40.0.34.5.12",
                   "Innere Medizin",
                   "Innere Medizin",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: InterdisziplinÃ¤rer Bereich.<br>
     */
    INTERDISZIPLIN_RER_BEREICH("F023",
                               "1.2.40.0.34.5.12",
                               "InterdisziplinÃ¤rer Bereich",
                               "InterdisziplinÃ¤rer Bereich",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Kinder- und Jugendchirurgie.<br>
     */
    KINDER_UND_JUGENDCHIRURGIE("F026",
                               "1.2.40.0.34.5.12",
                               "Kinder- und Jugendchirurgie",
                               "Kinder- und Jugendchirurgie",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Kinder- und Jugendheilkunde.<br>
     */
    KINDER_UND_JUGENDHEILKUNDE("F027",
                               "1.2.40.0.34.5.12",
                               "Kinder- und Jugendheilkunde",
                               "Kinder- und Jugendheilkunde",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Kinder- und Jugendpsychiatrie.<br>
     */
    KINDER_UND_JUGENDPSYCHIATRIE("F025",
                                 "1.2.40.0.34.5.12",
                                 "Kinder- und Jugendpsychiatrie",
                                 "Kinder- und Jugendpsychiatrie",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE",
                                 "TOTRANSLATE"),
    /**
     * EN: Klinische Psychologie.<br>
     */
    KLINISCHE_PSYCHOLOGIE("F059",
                          "1.2.40.0.34.5.12",
                          "Klinische Psychologie",
                          "Klinische Psychologie",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Krankenhauspflege.<br>
     */
    KRANKENHAUSPFLEGE("F066",
                      "1.2.40.0.34.5.12",
                      "Krankenhauspflege",
                      "Krankenhauspflege",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Kur- und Prävention.<br>
     */
    KUR_UND_PR_VENTION("F060",
                       "1.2.40.0.34.5.12",
                       "Kur- und Prävention",
                       "Kur- und Prävention",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Labordiagnostik.<br>
     */
    LABORDIAGNOSTIK("F028",
                    "1.2.40.0.34.5.12",
                    "Labordiagnostik",
                    "Labordiagnostik",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Mikrobiologie.<br>
     */
    MIKROBIOLOGIE("F016",
                  "1.2.40.0.34.5.12",
                  "Mikrobiologie",
                  "Mikrobiologie",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Mund-, Kiefer- und Gesichtschirurgie.<br>
     */
    MUND_KIEFER_UND_GESICHTSCHIRURGIE("F029",
                                      "1.2.40.0.34.5.12",
                                      "Mund-, Kiefer- und Gesichtschirurgie",
                                      "Mund-, Kiefer- und Gesichtschirurgie",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: Neurochirurgie.<br>
     */
    NEUROCHIRURGIE("F031",
                   "1.2.40.0.34.5.12",
                   "Neurochirurgie",
                   "Neurochirurgie",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Neurologie.<br>
     */
    NEUROLOGIE("F032",
               "1.2.40.0.34.5.12",
               "Neurologie",
               "Neurologie",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Nuklearmedizin.<br>
     */
    NUKLEARMEDIZIN("F033",
                   "1.2.40.0.34.5.12",
                   "Nuklearmedizin",
                   "Nuklearmedizin",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Orthopädie und orthopädische Chirurgie.<br>
     */
    ORTHOP_DIE_UND_ORTHOP_DISCHE_CHIRURGIE("F035",
                                           "1.2.40.0.34.5.12",
                                           "Orthopädie und orthopädische Chirurgie",
                                           "Orthopädie und orthopädische Chirurgie",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Palliativmedizin.<br>
     */
    PALLIATIVMEDIZIN("F036",
                     "1.2.40.0.34.5.12",
                     "Palliativmedizin",
                     "Palliativmedizin",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Pathologie.<br>
     */
    PATHOLOGIE("F037",
               "1.2.40.0.34.5.12",
               "Pathologie",
               "Pathologie",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Patienten Verwaltung.<br>
     */
    PATIENTEN_VERWALTUNG("F065",
                         "1.2.40.0.34.5.12",
                         "Patienten Verwaltung",
                         "Patienten Verwaltung",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Physikalische Medizin und Rehabilitation.<br>
     */
    PHYSIKALISCHE_MEDIZIN_UND_REHABILITATION("F040",
                                             "1.2.40.0.34.5.12",
                                             "Physikalische Medizin und Rehabilitation",
                                             "Physikalische Medizin und Rehabilitation",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE"),
    /**
     * EN: Plastische Chirurgie.<br>
     */
    PLASTISCHE_CHIRURGIE("F041",
                         "1.2.40.0.34.5.12",
                         "Plastische Chirurgie",
                         "Plastische Chirurgie",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Psychiatrie.<br>
     */
    PSYCHIATRIE("F042",
                "1.2.40.0.34.5.12",
                "Psychiatrie",
                "Psychiatrie",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Psychosomatik.<br>
     */
    PSYCHOSOMATIK("F061",
                  "1.2.40.0.34.5.12",
                  "Psychosomatik",
                  "Psychosomatik",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Pulmologie.<br>
     */
    PULMOLOGIE("F043",
               "1.2.40.0.34.5.12",
               "Pulmologie",
               "Pulmologie",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Radiologie.<br>
     */
    RADIOLOGIE("F044",
               "1.2.40.0.34.5.12",
               "Radiologie",
               "Radiologie",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Radioonkologie.<br>
     */
    RADIOONKOLOGIE("F062",
                   "1.2.40.0.34.5.12",
                   "Radioonkologie",
                   "Radioonkologie",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Rechtliche Dokumente.<br>
     */
    RECHTLICHE_DOKUMENTE("F063",
                         "1.2.40.0.34.5.12",
                         "Rechtliche Dokumente",
                         "Rechtliche Dokumente",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Remobilisation/Nachsorge.<br>
     */
    REMOBILISATION_NACHSORGE("F048",
                             "1.2.40.0.34.5.12",
                             "Remobilisation/Nachsorge",
                             "Remobilisation/Nachsorge",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Thoraxchirurgie.<br>
     */
    THORAXCHIRURGIE("F064",
                    "1.2.40.0.34.5.12",
                    "Thoraxchirurgie",
                    "Thoraxchirurgie",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Unfallchirurgie.<br>
     */
    UNFALLCHIRURGIE("F052",
                    "1.2.40.0.34.5.12",
                    "Unfallchirurgie",
                    "Unfallchirurgie",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Urologie.<br>
     */
    UROLOGIE("F053",
             "1.2.40.0.34.5.12",
             "Urologie",
             "Urologie",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Zahn-, Mund- und Kieferheilkunde.<br>
     */
    ZAHN_MUND_UND_KIEFERHEILKUNDE("F055",
                                  "1.2.40.0.34.5.12",
                                  "Zahn-, Mund- und Kieferheilkunde",
                                  "Zahn-, Mund- und Kieferheilkunde",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE");

    /**
     * EN: Code for Akutgeriatrie/Remobilisation.<br>
     */
    public static final String AKUTGERIATRIE_REMOBILISATION_CODE = "F056";

    /**
     * EN: Code for Allgemeinmedizin.<br>
     */
    public static final String ALLGEMEINMEDIZIN_CODE = "F001";

    /**
     * EN: Code for Anästhesiologie und Intensivmedizin.<br>
     */
    public static final String AN_STHESIOLOGIE_UND_INTENSIVMEDIZIN_CODE = "F002";

    /**
     * EN: Code for Augenheilkunde.<br>
     */
    public static final String AUGENHEILKUNDE_CODE = "F005";

    /**
     * EN: Code for Blutgruppenserologie und Transfusionsmedizin.<br>
     */
    public static final String BLUTGRUPPENSEROLOGIE_UND_TRANSFUSIONSMEDIZIN_CODE = "F006";

    /**
     * EN: Code for Chirurgie.<br>
     */
    public static final String CHIRURGIE_CODE = "F007";

    /**
     * EN: Code for Dermatologie.<br>
     */
    public static final String DERMATOLOGIE_CODE = "F015";

    /**
     * EN: Code for Gesundheits- und Krankenpflege.<br>
     */
    public static final String GESUNDHEITS_UND_KRANKENPFLEGE_CODE = "F057";

    /**
     * EN: Code for Gynäkologie und Geburtshilfe.<br>
     */
    public static final String GYN_KOLOGIE_UND_GEBURTSHILFE_CODE = "F010";

    /**
     * EN: Code for Hals-, Nasen- und Ohrenheilkunde.<br>
     */
    public static final String HALS_NASEN_UND_OHRENHEILKUNDE_CODE = "F014";

    /**
     * EN: Code for Herzchirurgie.<br>
     */
    public static final String HERZCHIRURGIE_CODE = "F058";

    /**
     * EN: Code for Innere Medizin.<br>
     */
    public static final String INNERE_MEDIZIN_CODE = "F019";

    /**
     * EN: Code for InterdisziplinÃ¤rer Bereich.<br>
     */
    public static final String INTERDISZIPLIN_RER_BEREICH_CODE = "F023";

    /**
     * EN: Code for Kinder- und Jugendchirurgie.<br>
     */
    public static final String KINDER_UND_JUGENDCHIRURGIE_CODE = "F026";

    /**
     * EN: Code for Kinder- und Jugendheilkunde.<br>
     */
    public static final String KINDER_UND_JUGENDHEILKUNDE_CODE = "F027";

    /**
     * EN: Code for Kinder- und Jugendpsychiatrie.<br>
     */
    public static final String KINDER_UND_JUGENDPSYCHIATRIE_CODE = "F025";

    /**
     * EN: Code for Klinische Psychologie.<br>
     */
    public static final String KLINISCHE_PSYCHOLOGIE_CODE = "F059";

    /**
     * EN: Code for Krankenhauspflege.<br>
     */
    public static final String KRANKENHAUSPFLEGE_CODE = "F066";

    /**
     * EN: Code for Kur- und Prävention.<br>
     */
    public static final String KUR_UND_PR_VENTION_CODE = "F060";

    /**
     * EN: Code for Labordiagnostik.<br>
     */
    public static final String LABORDIAGNOSTIK_CODE = "F028";

    /**
     * EN: Code for Mikrobiologie.<br>
     */
    public static final String MIKROBIOLOGIE_CODE = "F016";

    /**
     * EN: Code for Mund-, Kiefer- und Gesichtschirurgie.<br>
     */
    public static final String MUND_KIEFER_UND_GESICHTSCHIRURGIE_CODE = "F029";

    /**
     * EN: Code for Neurochirurgie.<br>
     */
    public static final String NEUROCHIRURGIE_CODE = "F031";

    /**
     * EN: Code for Neurologie.<br>
     */
    public static final String NEUROLOGIE_CODE = "F032";

    /**
     * EN: Code for Nuklearmedizin.<br>
     */
    public static final String NUKLEARMEDIZIN_CODE = "F033";

    /**
     * EN: Code for Orthopädie und orthopädische Chirurgie.<br>
     */
    public static final String ORTHOP_DIE_UND_ORTHOP_DISCHE_CHIRURGIE_CODE = "F035";

    /**
     * EN: Code for Palliativmedizin.<br>
     */
    public static final String PALLIATIVMEDIZIN_CODE = "F036";

    /**
     * EN: Code for Pathologie.<br>
     */
    public static final String PATHOLOGIE_CODE = "F037";

    /**
     * EN: Code for Patienten Verwaltung.<br>
     */
    public static final String PATIENTEN_VERWALTUNG_CODE = "F065";

    /**
     * EN: Code for Physikalische Medizin und Rehabilitation.<br>
     */
    public static final String PHYSIKALISCHE_MEDIZIN_UND_REHABILITATION_CODE = "F040";

    /**
     * EN: Code for Plastische Chirurgie.<br>
     */
    public static final String PLASTISCHE_CHIRURGIE_CODE = "F041";

    /**
     * EN: Code for Psychiatrie.<br>
     */
    public static final String PSYCHIATRIE_CODE = "F042";

    /**
     * EN: Code for Psychosomatik.<br>
     */
    public static final String PSYCHOSOMATIK_CODE = "F061";

    /**
     * EN: Code for Pulmologie.<br>
     */
    public static final String PULMOLOGIE_CODE = "F043";

    /**
     * EN: Code for Radiologie.<br>
     */
    public static final String RADIOLOGIE_CODE = "F044";

    /**
     * EN: Code for Radioonkologie.<br>
     */
    public static final String RADIOONKOLOGIE_CODE = "F062";

    /**
     * EN: Code for Rechtliche Dokumente.<br>
     */
    public static final String RECHTLICHE_DOKUMENTE_CODE = "F063";

    /**
     * EN: Code for Remobilisation/Nachsorge.<br>
     */
    public static final String REMOBILISATION_NACHSORGE_CODE = "F048";

    /**
     * EN: Code for Thoraxchirurgie.<br>
     */
    public static final String THORAXCHIRURGIE_CODE = "F064";

    /**
     * EN: Code for Unfallchirurgie.<br>
     */
    public static final String UNFALLCHIRURGIE_CODE = "F052";

    /**
     * EN: Code for Urologie.<br>
     */
    public static final String UROLOGIE_CODE = "F053";

    /**
     * EN: Code for Zahn-, Mund- und Kieferheilkunde.<br>
     */
    public static final String ZAHN_MUND_UND_KIEFERHEILKUNDE_CODE = "F055";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.75";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "elga-practicesetting";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "1.2.40.0.34.5.12";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaPracticesetting getEnum(@Nullable final String code) {
        for (final ElgaPracticesetting x : values()) {
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
            Enum.valueOf(ElgaPracticesetting.class,
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
        for (final ElgaPracticesetting x : values()) {
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
    ElgaPracticesetting(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
