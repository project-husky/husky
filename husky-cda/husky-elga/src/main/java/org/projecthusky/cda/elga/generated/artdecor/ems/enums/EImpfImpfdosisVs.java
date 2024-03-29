/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of eImpf_Impfdosis_VS values
 * <p>
 * EN: Vaccine doses or partial vaccinations for immunisation, basic immunisation and boosters.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.6<br>
 * Effective date: 2021-06-22 00:00<br>
 * Version: 202106(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-01")
public enum EImpfImpfdosisVs implements ValueSetEnumInterface {

    /**
     * EN: Auffrischung.<br>
     */
    AUFFRISCHUNG("B",
                 "1.2.40.0.34.5.183",
                 "Auffrischung",
                 "Auffrischung",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Auffrischungsserie Teil 1.<br>
     */
    AUFFRISCHUNGSSERIE_TEIL_1("B.I",
                              "1.2.40.0.34.5.183",
                              "Auffrischungsserie Teil 1",
                              "Auffrischungsserie Teil 1",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Auffrischungsserie Teil 2.<br>
     */
    AUFFRISCHUNGSSERIE_TEIL_2("B.II",
                              "1.2.40.0.34.5.183",
                              "Auffrischungsserie Teil 2",
                              "Auffrischungsserie Teil 2",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Dosis 1.<br>
     */
    DOSIS_1("D1",
            "1.2.40.0.34.5.183",
            "Dosis 1",
            "Dosis 1",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 2.<br>
     */
    DOSIS_2("D2",
            "1.2.40.0.34.5.183",
            "Dosis 2",
            "Dosis 2",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 3.<br>
     */
    DOSIS_3("D3",
            "1.2.40.0.34.5.183",
            "Dosis 3",
            "Dosis 3",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 4.<br>
     */
    DOSIS_4("D4",
            "1.2.40.0.34.5.183",
            "Dosis 4",
            "Dosis 4",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 5.<br>
     */
    DOSIS_5("D5",
            "1.2.40.0.34.5.183",
            "Dosis 5",
            "Dosis 5",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 6.<br>
     */
    DOSIS_6("D6",
            "1.2.40.0.34.5.183",
            "Dosis 6",
            "Dosis 6",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 7.<br>
     */
    DOSIS_7("D7",
            "1.2.40.0.34.5.183",
            "Dosis 7",
            "Dosis 7",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 8.<br>
     */
    DOSIS_8("D8",
            "1.2.40.0.34.5.183",
            "Dosis 8",
            "Dosis 8",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Dosis 9.<br>
     */
    DOSIS_9("D9",
            "1.2.40.0.34.5.183",
            "Dosis 9",
            "Dosis 9",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE");

    /**
     * EN: Code for Auffrischung.<br>
     */
    public static final String AUFFRISCHUNG_CODE = "B";

    /**
     * EN: Code for Auffrischungsserie Teil 1.<br>
     */
    public static final String AUFFRISCHUNGSSERIE_TEIL_1_CODE = "B.I";

    /**
     * EN: Code for Auffrischungsserie Teil 2.<br>
     */
    public static final String AUFFRISCHUNGSSERIE_TEIL_2_CODE = "B.II";

    /**
     * EN: Code for Dosis 1.<br>
     */
    public static final String DOSIS_1_CODE = "D1";

    /**
     * EN: Code for Dosis 2.<br>
     */
    public static final String DOSIS_2_CODE = "D2";

    /**
     * EN: Code for Dosis 3.<br>
     */
    public static final String DOSIS_3_CODE = "D3";

    /**
     * EN: Code for Dosis 4.<br>
     */
    public static final String DOSIS_4_CODE = "D4";

    /**
     * EN: Code for Dosis 5.<br>
     */
    public static final String DOSIS_5_CODE = "D5";

    /**
     * EN: Code for Dosis 6.<br>
     */
    public static final String DOSIS_6_CODE = "D6";

    /**
     * EN: Code for Dosis 7.<br>
     */
    public static final String DOSIS_7_CODE = "D7";

    /**
     * EN: Code for Dosis 8.<br>
     */
    public static final String DOSIS_8_CODE = "D8";

    /**
     * EN: Code for Dosis 9.<br>
     */
    public static final String DOSIS_9_CODE = "D9";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.6";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "eImpf_Impfdosis_VS";

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
    public static EImpfImpfdosisVs getEnum(@Nullable final String code) {
        for (final EImpfImpfdosisVs x : values()) {
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
            Enum.valueOf(EImpfImpfdosisVs.class,
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
        for (final EImpfImpfdosisVs x : values()) {
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
    EImpfImpfdosisVs(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
