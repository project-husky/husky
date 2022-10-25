/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.stable;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.sourcePatientInfo.PID-8 values
 * <p>
 * EN: Patient’s gender as per Annex 3; EPRO-FDHA.<br>
 * DE: Geschlecht der Patientin oder des Patienten gemäss Anhang 3 EPDV-EDI.<br>
 * FR: Sexe du patient selon l'annexe 3 ODEP-DFI.<br>
 * IT: Sesso del paziente secondo l'allegato 3 OCIP-DFI.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.4.642.3.1<br>
 * Effective date: 2021-04-01 17:04<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-09-29")
public enum SourcePatientInfo implements ValueSetEnumInterface {

    /**
     * EN: Female.<br>
     * DE: Weiblich.<br>
     * FR: Féminin.<br>
     * IT: Femminile.<br>
     */
    FEMALE("female",
           "2.16.840.1.113883.4.642.1.2",
           "Female",
           "Female",
           "Weiblich",
           "Féminin",
           "Femminile"),
    /**
     * EN: Male.<br>
     * DE: Männlich.<br>
     * FR: Masculin.<br>
     * IT: Maschile.<br>
     */
    MALE("male",
         "2.16.840.1.113883.4.642.1.2",
         "Male",
         "Male",
         "Männlich",
         "Masculin",
         "Maschile"),
    /**
     * EN: Other.<br>
     * DE: Anderes.<br>
     * FR: Autre.<br>
     * IT: Altro.<br>
     */
    OTHER("other",
          "2.16.840.1.113883.4.642.1.2",
          "Other",
          "Other",
          "Anderes",
          "Autre",
          "Altro"),
    /**
     * EN: Unknown.<br>
     * DE: Unbekannt.<br>
     * FR: Inconnu.<br>
     * IT: Sconosciuto.<br>
     */
    UNKNOWN("unknown",
            "2.16.840.1.113883.4.642.1.2",
            "Unknown",
            "Unknown",
            "Unbekannt",
            "Inconnu",
            "Sconosciuto");

    /**
     * EN: Code for Female.<br>
     * DE: Code für Weiblich.<br>
     * FR: Code de Féminin.<br>
     * IT: Code per Femminile.<br>
     */
    public static final String FEMALE_CODE = "female";

    /**
     * EN: Code for Male.<br>
     * DE: Code für Männlich.<br>
     * FR: Code de Masculin.<br>
     * IT: Code per Maschile.<br>
     */
    public static final String MALE_CODE = "male";

    /**
     * EN: Code for Other.<br>
     * DE: Code für Anderes.<br>
     * FR: Code de Autre.<br>
     * IT: Code per Altro.<br>
     */
    public static final String OTHER_CODE = "other";

    /**
     * EN: Code for Unknown.<br>
     * DE: Code für Unbekannt.<br>
     * FR: Code de Inconnu.<br>
     * IT: Code per Sconosciuto.<br>
     */
    public static final String UNKNOWN_CODE = "unknown";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.4.642.3.1";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.sourcePatientInfo.PID-8";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.4.642.1.2";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static SourcePatientInfo getEnum(@Nullable final String code) {
        for (final SourcePatientInfo x : values()) {
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
            Enum.valueOf(SourcePatientInfo.class,
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
        for (final SourcePatientInfo x : values()) {
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
    SourcePatientInfo(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
