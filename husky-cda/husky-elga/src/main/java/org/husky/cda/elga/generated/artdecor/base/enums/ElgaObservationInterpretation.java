/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of ELGA_ObservationInterpretation values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.13<br>
 * Effective date: 2013-09-12 00:00<br>
 * Version: null<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-21")
public enum ElgaObservationInterpretation implements ValueSetEnumInterface {

    /**
     * EN: Abnormal Alert.<br>
     */
    ABNORMAL_ALERT_L2("AA",
                      "2.16.840.1.113883.5.83",
                      "Abnormal Alert",
                      "Abnormal Alert",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Abnormal.<br>
     */
    ABNORMAL_L1("A",
                "2.16.840.1.113883.5.83",
                "Abnormal",
                "Abnormal",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: decreased.<br>
     */
    DECREASED_L1("D",
                 "2.16.840.1.113883.5.83",
                 "decreased",
                 "decreased",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: High Alert.<br>
     */
    HIGH_ALERT_L2("HH",
                  "2.16.840.1.113883.5.83",
                  "High Alert",
                  "High Alert",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: High.<br>
     */
    HIGH_L1("H",
            "2.16.840.1.113883.5.83",
            "High",
            "High",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: high off scale.<br>
     */
    HIGH_OFF_SCALE_L1(">",
                      "2.16.840.1.113883.5.83",
                      "high off scale",
                      "high off scale",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: increased.<br>
     */
    INCREASED_L1("U",
                 "2.16.840.1.113883.5.83",
                 "increased",
                 "increased",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Indeterminate.<br>
     */
    INDETERMINATE_L1("IND",
                     "2.16.840.1.113883.5.83",
                     "Indeterminate",
                     "Indeterminate",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Intermediate.<br>
     */
    INTERMEDIATE_L1("I",
                    "2.16.840.1.113883.5.83",
                    "Intermediate",
                    "Intermediate",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Low Alert.<br>
     */
    LOW_ALERT_L2("LL",
                 "2.16.840.1.113883.5.83",
                 "Low Alert",
                 "Low Alert",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Low.<br>
     */
    LOW_L1("L",
           "2.16.840.1.113883.5.83",
           "Low",
           "Low",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: low off scale.<br>
     */
    LOW_OFF_SCALE_L1("<",
                     "2.16.840.1.113883.5.83",
                     "low off scale",
                     "low off scale",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Negative.<br>
     */
    NEGATIVE_L1("NEG",
                "2.16.840.1.113883.5.83",
                "Negative",
                "Negative",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: normal.<br>
     */
    NORMAL_L1("N",
              "2.16.840.1.113883.5.83",
              "normal",
              "normal",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: outside threshold.<br>
     */
    OUTSIDE_THRESHOLD_L1("EX",
                         "2.16.840.1.113883.5.83",
                         "outside threshold",
                         "outside threshold",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Positive.<br>
     */
    POSITIVE_L1("POS",
                "2.16.840.1.113883.5.83",
                "Positive",
                "Positive",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: Resistent.<br>
     */
    RESISTENT_L1("R",
                 "2.16.840.1.113883.5.83",
                 "Resistent",
                 "Resistent",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Susceptible.<br>
     */
    SUSCEPTIBLE_L1("S",
                   "2.16.840.1.113883.5.83",
                   "Susceptible",
                   "Susceptible",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE");

    /**
     * EN: Code for Abnormal Alert.<br>
     */
    public static final String ABNORMAL_ALERT_L2_CODE = "AA";

    /**
     * EN: Code for Abnormal.<br>
     */
    public static final String ABNORMAL_L1_CODE = "A";

    /**
     * EN: Code for decreased.<br>
     */
    public static final String DECREASED_L1_CODE = "D";

    /**
     * EN: Code for High Alert.<br>
     */
    public static final String HIGH_ALERT_L2_CODE = "HH";

    /**
     * EN: Code for High.<br>
     */
    public static final String HIGH_L1_CODE = "H";

    /**
     * EN: Code for high off scale.<br>
     */
    public static final String HIGH_OFF_SCALE_L1_CODE = ">";

    /**
     * EN: Code for increased.<br>
     */
    public static final String INCREASED_L1_CODE = "U";

    /**
     * EN: Code for Indeterminate.<br>
     */
    public static final String INDETERMINATE_L1_CODE = "IND";

    /**
     * EN: Code for Intermediate.<br>
     */
    public static final String INTERMEDIATE_L1_CODE = "I";

    /**
     * EN: Code for Low Alert.<br>
     */
    public static final String LOW_ALERT_L2_CODE = "LL";

    /**
     * EN: Code for Low.<br>
     */
    public static final String LOW_L1_CODE = "L";

    /**
     * EN: Code for low off scale.<br>
     */
    public static final String LOW_OFF_SCALE_L1_CODE = "<";

    /**
     * EN: Code for Negative.<br>
     */
    public static final String NEGATIVE_L1_CODE = "NEG";

    /**
     * EN: Code for normal.<br>
     */
    public static final String NORMAL_L1_CODE = "N";

    /**
     * EN: Code for outside threshold.<br>
     */
    public static final String OUTSIDE_THRESHOLD_L1_CODE = "EX";

    /**
     * EN: Code for Positive.<br>
     */
    public static final String POSITIVE_L1_CODE = "POS";

    /**
     * EN: Code for Resistent.<br>
     */
    public static final String RESISTENT_L1_CODE = "R";

    /**
     * EN: Code for Susceptible.<br>
     */
    public static final String SUSCEPTIBLE_L1_CODE = "S";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.13";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_ObservationInterpretation";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.83";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaObservationInterpretation getEnum(@Nullable final String code) {
        for (final ElgaObservationInterpretation x : values()) {
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
            Enum.valueOf(ElgaObservationInterpretation.class,
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
        for (final ElgaObservationInterpretation x : values()) {
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
    ElgaObservationInterpretation(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
