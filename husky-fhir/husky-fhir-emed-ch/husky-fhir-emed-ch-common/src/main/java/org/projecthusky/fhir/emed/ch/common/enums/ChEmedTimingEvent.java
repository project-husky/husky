/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.common.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of CH-EMED-TimingEvent values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.77.4.11.2<br>
 * Effective date: 2020-07-10 00:28<br>
 * Version: 2022<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-18")
public enum ChEmedTimingEvent implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: Afternoon.<br>
     * DE: Nachmittag.<br>
     * FR: Après-midi.<br>
     * IT: Pomeriggio.<br>
     */
    AFTERNOON("AFT",
              "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
              "Afternoon",
              "Afternoon",
              "Nachmittag",
              "Après-midi",
              "Pomeriggio"),
    /**
     * EN: After breakfast.<br>
     * DE: Nach dem Frühstück.<br>
     * FR: Après le petit-déjeuner.<br>
     * IT: Dopo la prima colazione.<br>
     */
    AFTER_BREAKFAST("PCM",
                    "2.16.840.1.113883.5.139",
                    "After breakfast",
                    "After breakfast",
                    "Nach dem Frühstück",
                    "Après le petit-déjeuner",
                    "Dopo la prima colazione"),
    /**
     * EN: After dinner.<br>
     * DE: Nach dem Abendessen.<br>
     * FR: Après le repas du soir.<br>
     * IT: Dopo cena.<br>
     */
    AFTER_DINNER("PCV",
                 "2.16.840.1.113883.5.139",
                 "After dinner",
                 "After dinner",
                 "Nach dem Abendessen",
                 "Après le repas du soir",
                 "Dopo cena"),
    /**
     * EN: After lunch.<br>
     * DE: Nach dem Mittagessen.<br>
     * FR: Après le repas de midi.<br>
     * IT: Dopo pranzo.<br>
     */
    AFTER_LUNCH("PCD",
                "2.16.840.1.113883.5.139",
                "After lunch",
                "After lunch",
                "Nach dem Mittagessen",
                "Après le repas de midi",
                "Dopo pranzo"),
    /**
     * EN: After Sleep.<br>
     * DE: Nach dem Einschlafen.<br>
     * FR: Après le coucher.<br>
     * IT: Dopo il sonno.<br>
     */
    AFTER_SLEEP("PHS",
                "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                "After Sleep",
                "After Sleep",
                "Nach dem Einschlafen",
                "Après le coucher",
                "Dopo il sonno"),
    /**
     * EN: After the meal.<br>
     * DE: Nach dem Essen.<br>
     * FR: Après le repas.<br>
     * IT: Dopo il pasto.<br>
     */
    AFTER_THE_MEAL("PC",
                   "2.16.840.1.113883.5.139",
                   "After the meal",
                   "After the meal",
                   "Nach dem Essen",
                   "Après le repas",
                   "Dopo il pasto"),
    /**
     * EN: Before breakfast.<br>
     * DE: Vor dem Frühstück.<br>
     * FR: Avant le petit-déjeuner.<br>
     * IT: Prima di colazione.<br>
     */
    BEFORE_BREAKFAST("ACM",
                     "2.16.840.1.113883.5.139",
                     "Before breakfast",
                     "Before breakfast",
                     "Vor dem Frühstück",
                     "Avant le petit-déjeuner",
                     "Prima di colazione"),
    /**
     * EN: Before dinner.<br>
     * DE: Vor dem Abendessen.<br>
     * FR: Avant le repas du soir.<br>
     * IT: Prima di cena.<br>
     */
    BEFORE_DINNER("ACV",
                  "2.16.840.1.113883.5.139",
                  "Before dinner",
                  "Before dinner",
                  "Vor dem Abendessen",
                  "Avant le repas du soir",
                  "Prima di cena"),
    /**
     * EN: Before lunch.<br>
     * DE: Vor dem Mittagessen.<br>
     * FR: Avant le repas de midi.<br>
     * IT: Prima di pranzo.<br>
     */
    BEFORE_LUNCH("ACD",
                 "2.16.840.1.113883.5.139",
                 "Before lunch",
                 "Before lunch",
                 "Vor dem Mittagessen",
                 "Avant le repas de midi",
                 "Prima di pranzo"),
    /**
     * EN: Before sleep.<br>
     * DE: Vor dem Schlafengehen.<br>
     * FR: Avant le coucher.<br>
     * IT: Prima di andare a dormire.<br>
     */
    BEFORE_SLEEP("HS",
                 "2.16.840.1.113883.5.139",
                 "Before sleep",
                 "Before sleep",
                 "Vor dem Schlafengehen",
                 "Avant le coucher",
                 "Prima di andare a dormire"),
    /**
     * EN: Before the meal.<br>
     * DE: Vor der Mahlzeit.<br>
     * FR: Avant le repas.<br>
     * IT: Prima del pasto.<br>
     */
    BEFORE_THE_MEAL("AC",
                    "2.16.840.1.113883.5.139",
                    "Before the meal",
                    "Before the meal",
                    "Vor der Mahlzeit",
                    "Avant le repas",
                    "Prima del pasto"),
    /**
     * EN: During breakfast.<br>
     * DE: Während des Frühstücks.<br>
     * FR: Pendant le petit-déjeuner.<br>
     * IT: Durante la prima colazione.<br>
     */
    DURING_BREAKFAST("CM",
                     "2.16.840.1.113883.5.139",
                     "During breakfast",
                     "During breakfast",
                     "Während des Frühstücks",
                     "Pendant le petit-déjeuner",
                     "Durante la prima colazione"),
    /**
     * EN: During dinner.<br>
     * DE: Während des Abendessens.<br>
     * FR: Pendant le repas du soir.<br>
     * IT: Durante la cena.<br>
     */
    DURING_DINNER("CV",
                  "2.16.840.1.113883.5.139",
                  "During dinner",
                  "During dinner",
                  "Während des Abendessens",
                  "Pendant le repas du soir",
                  "Durante la cena"),
    /**
     * EN: During lunch.<br>
     * DE: Während des Mittagessens.<br>
     * FR: Pendant le repas de midi.<br>
     * IT: Durante il pranzo.<br>
     */
    DURING_LUNCH("CD",
                 "2.16.840.1.113883.5.139",
                 "During lunch",
                 "During lunch",
                 "Während des Mittagessens",
                 "Pendant le repas de midi",
                 "Durante il pranzo"),
    /**
     * EN: During meals.<br>
     * DE: Während der Mahlzeit.<br>
     * FR: Pendant le repas.<br>
     * IT: Durante il pasto.<br>
     */
    DURING_MEALS("C",
                 "2.16.840.1.113883.5.139",
                 "During meals",
                 "During meals",
                 "Während der Mahlzeit",
                 "Pendant le repas",
                 "Durante il pasto"),
    /**
     * EN: Early Afternoon.<br>
     * DE: Früher Nachmittag.<br>
     * FR: Début d’après-midi.<br>
     * IT: Primo pomeriggio.<br>
     */
    EARLY_AFTERNOON("AFT.early",
                    "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                    "Early Afternoon",
                    "Early Afternoon",
                    "Früher Nachmittag",
                    "Début d’après-midi",
                    "Primo pomeriggio"),
    /**
     * EN: Early Evening.<br>
     * DE: Früher Abend.<br>
     * FR: Début de soirée.<br>
     * IT: Prima serata.<br>
     */
    EARLY_EVENING("EVE.early",
                  "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                  "Early Evening",
                  "Early Evening",
                  "Früher Abend",
                  "Début de soirée",
                  "Prima serata"),
    /**
     * EN: Early Morning.<br>
     * DE: Früher Morgen.<br>
     * FR: Début de matinée.<br>
     * IT: Prima mattina.<br>
     */
    EARLY_MORNING("MORN.early",
                  "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                  "Early Morning",
                  "Early Morning",
                  "Früher Morgen",
                  "Début de matinée",
                  "Prima mattina"),
    /**
     * EN: Evening.<br>
     * DE: Abend.<br>
     * FR: Soirée.<br>
     * IT: Sera.<br>
     */
    EVENING("EVE",
            "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
            "Evening",
            "Evening",
            "Abend",
            "Soirée",
            "Sera"),
    /**
     * EN: Late Afternoon.<br>
     * DE: Später Nachmittag.<br>
     * FR: Fin d’après-midi.<br>
     * IT: Tardo pomeriggio.<br>
     */
    LATE_AFTERNOON("AFT.late",
                   "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                   "Late Afternoon",
                   "Late Afternoon",
                   "Später Nachmittag",
                   "Fin d’après-midi",
                   "Tardo pomeriggio"),
    /**
     * EN: Late Evening.<br>
     * DE: Später Abend.<br>
     * FR: Fin de soirée.<br>
     * IT: Tarda serata.<br>
     */
    LATE_EVENING("EVE.late",
                 "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                 "Late Evening",
                 "Late Evening",
                 "Später Abend",
                 "Fin de soirée",
                 "Tarda serata"),
    /**
     * EN: Late Morning.<br>
     * DE: Später Morgen.<br>
     * FR: Fin de matinée.<br>
     * IT: Tarda mattinata.<br>
     */
    LATE_MORNING("MORN.late",
                 "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
                 "Late Morning",
                 "Late Morning",
                 "Später Morgen",
                 "Fin de matinée",
                 "Tarda mattinata"),
    /**
     * EN: Morning.<br>
     * DE: Morgen.<br>
     * FR: Matinée.<br>
     * IT: Mattina.<br>
     */
    MORNING("MORN",
            "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
            "Morning",
            "Morning",
            "Morgen",
            "Matinée",
            "Mattina"),
    /**
     * EN: Night.<br>
     * DE: Nacht.<br>
     * FR: Nuit.<br>
     * IT: Notte.<br>
     */
    NIGHT("NIGHT",
          "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
          "Night",
          "Night",
          "Nacht",
          "Nuit",
          "Notte"),
    /**
     * EN: Noon.<br>
     * DE: Mittag.<br>
     * FR: Midi.<br>
     * IT: Mezzogiorno.<br>
     */
    NOON("NOON",
         "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing",
         "Noon",
         "Noon",
         "Mittag",
         "Midi",
         "Mezzogiorno"),
    /**
     * EN: Upon waking up.<br>
     * DE: Beim Aufwachen.<br>
     * FR: Au réveil.<br>
     * IT: Al risveglio.<br>
     */
    UPON_WAKING_UP("WAKE",
                   "2.16.840.1.113883.5.139",
                   "Upon waking up",
                   "Upon waking up",
                   "Beim Aufwachen",
                   "Au réveil",
                   "Al risveglio");

    /**
     * EN: Code for Afternoon.<br>
     * DE: Code für Nachmittag.<br>
     * FR: Code de Après-midi.<br>
     * IT: Code per Pomeriggio.<br>
     */
    public static final String AFTERNOON_CODE = "AFT";

    /**
     * EN: Code for After breakfast.<br>
     * DE: Code für Nach dem Frühstück.<br>
     * FR: Code de Après le petit-déjeuner.<br>
     * IT: Code per Dopo la prima colazione.<br>
     */
    public static final String AFTER_BREAKFAST_CODE = "PCM";

    /**
     * EN: Code for After dinner.<br>
     * DE: Code für Nach dem Abendessen.<br>
     * FR: Code de Après le repas du soir.<br>
     * IT: Code per Dopo cena.<br>
     */
    public static final String AFTER_DINNER_CODE = "PCV";

    /**
     * EN: Code for After lunch.<br>
     * DE: Code für Nach dem Mittagessen.<br>
     * FR: Code de Après le repas de midi.<br>
     * IT: Code per Dopo pranzo.<br>
     */
    public static final String AFTER_LUNCH_CODE = "PCD";

    /**
     * EN: Code for After Sleep.<br>
     * DE: Code für Nach dem Einschlafen.<br>
     * FR: Code de Après le coucher.<br>
     * IT: Code per Dopo il sonno.<br>
     */
    public static final String AFTER_SLEEP_CODE = "PHS";

    /**
     * EN: Code for After the meal.<br>
     * DE: Code für Nach dem Essen.<br>
     * FR: Code de Après le repas.<br>
     * IT: Code per Dopo il pasto.<br>
     */
    public static final String AFTER_THE_MEAL_CODE = "PC";

    /**
     * EN: Code for Before breakfast.<br>
     * DE: Code für Vor dem Frühstück.<br>
     * FR: Code de Avant le petit-déjeuner.<br>
     * IT: Code per Prima di colazione.<br>
     */
    public static final String BEFORE_BREAKFAST_CODE = "ACM";

    /**
     * EN: Code for Before dinner.<br>
     * DE: Code für Vor dem Abendessen.<br>
     * FR: Code de Avant le repas du soir.<br>
     * IT: Code per Prima di cena.<br>
     */
    public static final String BEFORE_DINNER_CODE = "ACV";

    /**
     * EN: Code for Before lunch.<br>
     * DE: Code für Vor dem Mittagessen.<br>
     * FR: Code de Avant le repas de midi.<br>
     * IT: Code per Prima di pranzo.<br>
     */
    public static final String BEFORE_LUNCH_CODE = "ACD";

    /**
     * EN: Code for Before sleep.<br>
     * DE: Code für Vor dem Schlafengehen.<br>
     * FR: Code de Avant le coucher.<br>
     * IT: Code per Prima di andare a dormire.<br>
     */
    public static final String BEFORE_SLEEP_CODE = "HS";

    /**
     * EN: Code for Before the meal.<br>
     * DE: Code für Vor der Mahlzeit.<br>
     * FR: Code de Avant le repas.<br>
     * IT: Code per Prima del pasto.<br>
     */
    public static final String BEFORE_THE_MEAL_CODE = "AC";

    /**
     * EN: Code for During breakfast.<br>
     * DE: Code für Während des Frühstücks.<br>
     * FR: Code de Pendant le petit-déjeuner.<br>
     * IT: Code per Durante la prima colazione.<br>
     */
    public static final String DURING_BREAKFAST_CODE = "CM";

    /**
     * EN: Code for During dinner.<br>
     * DE: Code für Während des Abendessens.<br>
     * FR: Code de Pendant le repas du soir.<br>
     * IT: Code per Durante la cena.<br>
     */
    public static final String DURING_DINNER_CODE = "CV";

    /**
     * EN: Code for During lunch.<br>
     * DE: Code für Während des Mittagessens.<br>
     * FR: Code de Pendant le repas de midi.<br>
     * IT: Code per Durante il pranzo.<br>
     */
    public static final String DURING_LUNCH_CODE = "CD";

    /**
     * EN: Code for During meals.<br>
     * DE: Code für Während der Mahlzeit.<br>
     * FR: Code de Pendant le repas.<br>
     * IT: Code per Durante il pasto.<br>
     */
    public static final String DURING_MEALS_CODE = "C";

    /**
     * EN: Code for Early Afternoon.<br>
     * DE: Code für Früher Nachmittag.<br>
     * FR: Code de Début d’après-midi.<br>
     * IT: Code per Primo pomeriggio.<br>
     */
    public static final String EARLY_AFTERNOON_CODE = "AFT.early";

    /**
     * EN: Code for Early Evening.<br>
     * DE: Code für Früher Abend.<br>
     * FR: Code de Début de soirée.<br>
     * IT: Code per Prima serata.<br>
     */
    public static final String EARLY_EVENING_CODE = "EVE.early";

    /**
     * EN: Code for Early Morning.<br>
     * DE: Code für Früher Morgen.<br>
     * FR: Code de Début de matinée.<br>
     * IT: Code per Prima mattina.<br>
     */
    public static final String EARLY_MORNING_CODE = "MORN.early";

    /**
     * EN: Code for Evening.<br>
     * DE: Code für Abend.<br>
     * FR: Code de Soirée.<br>
     * IT: Code per Sera.<br>
     */
    public static final String EVENING_CODE = "EVE";

    /**
     * EN: Code for Late Afternoon.<br>
     * DE: Code für Später Nachmittag.<br>
     * FR: Code de Fin d’après-midi.<br>
     * IT: Code per Tardo pomeriggio.<br>
     */
    public static final String LATE_AFTERNOON_CODE = "AFT.late";

    /**
     * EN: Code for Late Evening.<br>
     * DE: Code für Später Abend.<br>
     * FR: Code de Fin de soirée.<br>
     * IT: Code per Tarda serata.<br>
     */
    public static final String LATE_EVENING_CODE = "EVE.late";

    /**
     * EN: Code for Late Morning.<br>
     * DE: Code für Später Morgen.<br>
     * FR: Code de Fin de matinée.<br>
     * IT: Code per Tarda mattinata.<br>
     */
    public static final String LATE_MORNING_CODE = "MORN.late";

    /**
     * EN: Code for Morning.<br>
     * DE: Code für Morgen.<br>
     * FR: Code de Matinée.<br>
     * IT: Code per Mattina.<br>
     */
    public static final String MORNING_CODE = "MORN";

    /**
     * EN: Code for Night.<br>
     * DE: Code für Nacht.<br>
     * FR: Code de Nuit.<br>
     * IT: Code per Notte.<br>
     */
    public static final String NIGHT_CODE = "NIGHT";

    /**
     * EN: Code for Noon.<br>
     * DE: Code für Mittag.<br>
     * FR: Code de Midi.<br>
     * IT: Code per Mezzogiorno.<br>
     */
    public static final String NOON_CODE = "NOON";

    /**
     * EN: Code for Upon waking up.<br>
     * DE: Code für Beim Aufwachen.<br>
     * FR: Code de Au réveil.<br>
     * IT: Code per Al risveglio.<br>
     */
    public static final String UPON_WAKING_UP_CODE = "WAKE";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.77.4.11.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "CH-EMED-TimingEvent";

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
    ChEmedTimingEvent(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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

    /**
     * Returns the code system, as used in FHIR.
     */
    @Override
    @NonNull
    public String getFhirSystem() {
        if (this.getCodeSystemId().startsWith("http")) {
            return this.getCodeSystemId();
        }
        return Oids.PREFIX_OID + this.getCodeSystemId();
    }

    /**
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    @NonNull
    public Coding getCoding() {
        return new Coding(this.getFhirSystem(),
                          this.getCodeValue(),
                          this.displayNames[0]);
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    @NonNull
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.displayNames[0]).addCoding(this.getCoding());
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getFhirSystem().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ChEmedTimingEvent getEnum(@Nullable final String code) {
        for (final ChEmedTimingEvent x : values()) {
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
            Enum.valueOf(ChEmedTimingEvent.class,
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
        for (final ChEmedTimingEvent x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Enum with a given FHIR Coding.
     *
     * @param coding The FHIR Coding.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ChEmedTimingEvent getEnum(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given FHIR Coding is in this value set.
     *
     * @param coding The FHIR Coding.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return true;
            }
        }
        return false;
    }
}
