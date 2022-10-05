/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.common.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Enumeration of NullFlavor values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p>.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.10609<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-04-19")
public enum NullFlavor implements ValueSetEnumInterface {

    /**
     * EN: asked but unknown.<br>
     */
    ASKED_BUT_UNKNOWN_L2("ASKU",
                         "2.16.840.1.113883.5.1008",
                         "asked but unknown",
                         "asked but unknown",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: derived.<br>
     */
    DERIVED_L2("DER",
               "2.16.840.1.113883.5.1008",
               "derived",
               "derived",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: invalid.<br>
     */
    INVALID_L1("INV",
               "2.16.840.1.113883.5.1008",
               "invalid",
               "invalid",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: masked.<br>
     */
    MASKED_L1("MSK",
              "2.16.840.1.113883.5.1008",
              "masked",
              "masked",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: negative infinity.<br>
     */
    NEGATIVE_INFINITY_L3("NINF",
                         "2.16.840.1.113883.5.1008",
                         "negative infinity",
                         "negative infinity",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: NoInformation.<br>
     */
    NOINFORMATION("NI",
                  "2.16.840.1.113883.5.1008",
                  "NoInformation",
                  "NoInformation",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: not applicable.<br>
     */
    NOT_APPLICABLE_L1("NA",
                      "2.16.840.1.113883.5.1008",
                      "not applicable",
                      "not applicable",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: not asked.<br>
     */
    NOT_ASKED_L2("NASK",
                 "2.16.840.1.113883.5.1008",
                 "not asked",
                 "not asked",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Not available.<br>
     */
    NOT_AVAILABLE_L2("NAVU",
                     "2.16.840.1.113883.5.1008",
                     "Not available",
                     "Not available",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: other.<br>
     */
    OTHER_L2("OTH",
             "2.16.840.1.113883.5.1008",
             "other",
             "other",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: positive infinity.<br>
     */
    POSITIVE_INFINITY_L3("PINF",
                         "2.16.840.1.113883.5.1008",
                         "positive infinity",
                         "positive infinity",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Sufficient Quantity.<br>
     */
    SUFFICIENT_QUANTITY_L2("QS",
                           "2.16.840.1.113883.5.1008",
                           "Sufficient Quantity",
                           "Sufficient Quantity",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: temporarily unavailable.<br>
     */
    TEMPORARILY_UNAVAILABLE_L3("NAV",
                               "2.16.840.1.113883.5.1008",
                               "temporarily unavailable",
                               "temporarily unavailable",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: trace.<br>
     */
    TRACE_L2("TRC",
             "2.16.840.1.113883.5.1008",
             "trace",
             "trace",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: unknown.<br>
     */
    UNKNOWN_L1("UNK",
               "2.16.840.1.113883.5.1008",
               "unknown",
               "unknown",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: un-encoded.<br>
     */
    UN_ENCODED_L2("UNC",
                  "2.16.840.1.113883.5.1008",
                  "un-encoded",
                  "un-encoded",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE");

    /**
     * EN: Code for asked but unknown.<br>
     */
    public static final String ASKED_BUT_UNKNOWN_L2_CODE = "ASKU";

    /**
     * EN: Code for derived.<br>
     */
    public static final String DERIVED_L2_CODE = "DER";

    /**
     * EN: Code for invalid.<br>
     */
    public static final String INVALID_L1_CODE = "INV";

    /**
     * EN: Code for masked.<br>
     */
    public static final String MASKED_L1_CODE = "MSK";

    /**
     * EN: Code for negative infinity.<br>
     */
    public static final String NEGATIVE_INFINITY_L3_CODE = "NINF";

    /**
     * EN: Code for NoInformation.<br>
     */
    public static final String NOINFORMATION_CODE = "NI";

    /**
     * EN: Code for not applicable.<br>
     */
    public static final String NOT_APPLICABLE_L1_CODE = "NA";

    /**
     * EN: Code for not asked.<br>
     */
    public static final String NOT_ASKED_L2_CODE = "NASK";

    /**
     * EN: Code for Not available.<br>
     */
    public static final String NOT_AVAILABLE_L2_CODE = "NAVU";

    /**
     * EN: Code for other.<br>
     */
    public static final String OTHER_L2_CODE = "OTH";

    /**
     * EN: Code for positive infinity.<br>
     */
    public static final String POSITIVE_INFINITY_L3_CODE = "PINF";

    /**
     * EN: Code for Sufficient Quantity.<br>
     */
    public static final String SUFFICIENT_QUANTITY_L2_CODE = "QS";

    /**
     * EN: Code for temporarily unavailable.<br>
     */
    public static final String TEMPORARILY_UNAVAILABLE_L3_CODE = "NAV";

    /**
     * EN: Code for trace.<br>
     */
    public static final String TRACE_L2_CODE = "TRC";

    /**
     * EN: Code for unknown.<br>
     */
    public static final String UNKNOWN_L1_CODE = "UNK";

    /**
     * EN: Code for un-encoded.<br>
     */
    public static final String UN_ENCODED_L2_CODE = "UNC";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10609";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "NullFlavor";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.1008";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static NullFlavor getEnum(@Nullable final String code) {
        for (final NullFlavor x : values()) {
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
            Enum.valueOf(NullFlavor.class,
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
        for (final NullFlavor x : values()) {
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
    NullFlavor(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
