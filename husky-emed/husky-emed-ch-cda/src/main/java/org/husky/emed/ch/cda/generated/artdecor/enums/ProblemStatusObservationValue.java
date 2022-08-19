/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of ProblemStatusObservation_value values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.11.2<br>
 * Effective date: 2016-09-26 13:58<br>
 * Version: 2014<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-07-11")
public enum ProblemStatusObservationValue implements ValueSetEnumInterface {

    /**
     * EN: Active.<br>
     */
    ACTIVE("55561003",
           "2.16.840.1.113883.6.96",
           "Active",
           "Active",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: Chronic.<br>
     */
    CHRONIC("90734009",
            "2.16.840.1.113883.6.96",
            "Chronic",
            "Chronic",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Inactive.<br>
     */
    INACTIVE("73425007",
             "2.16.840.1.113883.6.96",
             "Inactive",
             "Inactive",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Intermittent.<br>
     */
    INTERMITTENT("7087005",
                 "2.16.840.1.113883.6.96",
                 "Intermittent",
                 "Intermittent",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Recurrent.<br>
     */
    RECURRENT("255227004",
              "2.16.840.1.113883.6.96",
              "Recurrent",
              "Recurrent",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Resolved.<br>
     */
    RESOLVED("413322009",
             "2.16.840.1.113883.6.96",
             "Resolved",
             "Resolved",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Ruled out.<br>
     */
    RULED_OUT("410516002",
              "2.16.840.1.113883.6.96",
              "Ruled out",
              "Ruled out",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Rule out.<br>
     */
    RULE_OUT("415684004",
             "2.16.840.1.113883.6.96",
             "Rule out",
             "Rule out",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE");

    /**
     * EN: Code for Active.<br>
     */
    public static final String ACTIVE_CODE = "55561003";

    /**
     * EN: Code for Chronic.<br>
     */
    public static final String CHRONIC_CODE = "90734009";

    /**
     * EN: Code for Inactive.<br>
     */
    public static final String INACTIVE_CODE = "73425007";

    /**
     * EN: Code for Intermittent.<br>
     */
    public static final String INTERMITTENT_CODE = "7087005";

    /**
     * EN: Code for Recurrent.<br>
     */
    public static final String RECURRENT_CODE = "255227004";

    /**
     * EN: Code for Resolved.<br>
     */
    public static final String RESOLVED_CODE = "413322009";

    /**
     * EN: Code for Ruled out.<br>
     */
    public static final String RULED_OUT_CODE = "410516002";

    /**
     * EN: Code for Rule out.<br>
     */
    public static final String RULE_OUT_CODE = "415684004";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.3.6.1.4.1.19376.1.5.3.1.11.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ProblemStatusObservation_value";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.6.96";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ProblemStatusObservationValue getEnum(@Nullable final String code) {
        for (final ProblemStatusObservationValue x : values()) {
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
            Enum.valueOf(ProblemStatusObservationValue.class,
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
        for (final ProblemStatusObservationValue x : values()) {
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
    ProblemStatusObservationValue(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
