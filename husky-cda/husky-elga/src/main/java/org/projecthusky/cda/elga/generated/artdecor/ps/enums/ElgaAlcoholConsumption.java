/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of ELGA_AlcoholConsumption values
 * <p>
 * EN: Value Set Frequency of Alcohol Consumption.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.30<br>
 * Effective date: 2019-01-25 21:52<br>
 * Version: null<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-03-01")
public enum ElgaAlcoholConsumption implements ValueSetEnumInterface {

    /**
     * EN: Alcohol consumption not known.<br>
     */
    ALCOHOL_CONSUMPTION_NOT_KNOWN("Alcohol_notknown",
                                  "1.2.40.0.34.5.179",
                                  "Alcohol consumption not known",
                                  "Alcohol consumption not known",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: 4 or more times a week.<br>
     */
    FOUR_OR_MORE_TIMES_A_WEEK("LA18929-2",
                              "1.3.6.1.4.1.12009.10.1.1334",
                              "4 or more times a week",
                              "4 or more times a week",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Monthly or less.<br>
     */
    MONTHLY_OR_LESS("LA18926-8",
                    "1.3.6.1.4.1.12009.10.1.1334",
                    "Monthly or less",
                    "Monthly or less",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Never.<br>
     */
    NEVER("LA6270-8",
          "1.3.6.1.4.1.12009.10.1.1334",
          "Never",
          "Never",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: 2-3 times a week.<br>
     */
    TWO_3_TIMES_A_WEEK("LA18928-4",
                       "1.3.6.1.4.1.12009.10.1.1334",
                       "2-3 times a week",
                       "2-3 times a week",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: 2-4 times a month.<br>
     */
    TWO_4_TIMES_A_MONTH("LA18927-6",
                        "1.3.6.1.4.1.12009.10.1.1334",
                        "2-4 times a month",
                        "2-4 times a month",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE");

    /**
     * EN: Code for Alcohol consumption not known.<br>
     */
    public static final String ALCOHOL_CONSUMPTION_NOT_KNOWN_CODE = "Alcohol_notknown";

    /**
     * EN: Code for 4 or more times a week.<br>
     */
    public static final String FOUR_OR_MORE_TIMES_A_WEEK_CODE = "LA18929-2";

    /**
     * EN: Code for Monthly or less.<br>
     */
    public static final String MONTHLY_OR_LESS_CODE = "LA18926-8";

    /**
     * EN: Code for Never.<br>
     */
    public static final String NEVER_CODE = "LA6270-8";

    /**
     * EN: Code for 2-3 times a week.<br>
     */
    public static final String TWO_3_TIMES_A_WEEK_CODE = "LA18928-4";

    /**
     * EN: Code for 2-4 times a month.<br>
     */
    public static final String TWO_4_TIMES_A_MONTH_CODE = "LA18927-6";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.30";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_AlcoholConsumption";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaAlcoholConsumption getEnum(@Nullable final String code) {
        for (final ElgaAlcoholConsumption x : values()) {
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
            Enum.valueOf(ElgaAlcoholConsumption.class,
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
        for (final ElgaAlcoholConsumption x : values()) {
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
    ElgaAlcoholConsumption(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
