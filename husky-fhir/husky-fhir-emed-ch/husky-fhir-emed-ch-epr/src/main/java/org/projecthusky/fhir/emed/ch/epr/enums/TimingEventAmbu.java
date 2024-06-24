/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.epr.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of TimingEventAmbu values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.77.12.11.2<br>
 * Effective date: 2022-04-15 09:00<br>
 * Version: 2022<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-06-24")
public enum TimingEventAmbu implements ValueSetEnumInterface, FhirValueSetEnumInterface {

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
         "Mezzogiorno");

    /**
     * EN: Code for Evening.<br>
     * DE: Code für Abend.<br>
     * FR: Code de Soirée.<br>
     * IT: Code per Sera.<br>
     */
    public static final String EVENING_CODE = "EVE";

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
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.77.12.11.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "TimingEventAmbu";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "http://fhir.ch/ig/ch-emed/CodeSystem/event-timing";

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
    TimingEventAmbu(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    public Coding getCoding() {
        return new Coding(this.getCodeSystemId(),
                          this.getCodeValue(),
                          this.getCodeSystemName());
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.getCodeSystemName()).addCoding(this.getCoding());
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getCodeSystemId().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static TimingEventAmbu getEnum(@Nullable final String code) {
        for (final TimingEventAmbu x : values()) {
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
            Enum.valueOf(TimingEventAmbu.class,
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
        for (final TimingEventAmbu x : values()) {
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
    public static TimingEventAmbu getEnum(@Nullable final Coding coding) {
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
