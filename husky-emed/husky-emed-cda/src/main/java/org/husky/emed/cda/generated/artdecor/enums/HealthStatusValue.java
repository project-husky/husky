/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of HealthStatus_value values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.11.3<br>
 * Effective date: 2016-09-26 14:09<br>
 * Version: 2014<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-12-09")
public enum HealthStatusValue implements ValueSetEnumInterface {

    /**
     * EN: Alive and well.<br>
     */
    ALIVE_AND_WELL("81323004",
                   "2.16.840.1.113883.6.96",
                   "Alive and well",
                   "Alive and well",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Chronically ill.<br>
     */
    CHRONICALLY_ILL("161901003",
                    "2.16.840.1.113883.6.96",
                    "Chronically ill",
                    "Chronically ill",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Deceased.<br>
     */
    DECEASED("419099009",
             "2.16.840.1.113883.6.96",
             "Deceased",
             "Deceased",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Disabled.<br>
     */
    DISABLED("21134002",
             "2.16.840.1.113883.6.96",
             "Disabled",
             "Disabled",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: In remission.<br>
     */
    IN_REMISSION("313386006",
                 "2.16.840.1.113883.6.96",
                 "In remission",
                 "In remission",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Severely disabled.<br>
     */
    SEVERELY_DISABLED("161045001",
                      "2.16.840.1.113883.6.96",
                      "Severely disabled",
                      "Severely disabled",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Severely ill.<br>
     */
    SEVERELY_ILL("271593001",
                 "2.16.840.1.113883.6.96",
                 "Severely ill",
                 "Severely ill",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Symptom free.<br>
     */
    SYMPTOM_FREE("162467007",
                 "2.16.840.1.113883.6.96",
                 "Symptom free",
                 "Symptom free",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE");

    /**
     * EN: Code for Alive and well.<br>
     */
    public static final String ALIVE_AND_WELL_CODE = "81323004";

    /**
     * EN: Code for Chronically ill.<br>
     */
    public static final String CHRONICALLY_ILL_CODE = "161901003";

    /**
     * EN: Code for Deceased.<br>
     */
    public static final String DECEASED_CODE = "419099009";

    /**
     * EN: Code for Disabled.<br>
     */
    public static final String DISABLED_CODE = "21134002";

    /**
     * EN: Code for In remission.<br>
     */
    public static final String IN_REMISSION_CODE = "313386006";

    /**
     * EN: Code for Severely disabled.<br>
     */
    public static final String SEVERELY_DISABLED_CODE = "161045001";

    /**
     * EN: Code for Severely ill.<br>
     */
    public static final String SEVERELY_ILL_CODE = "271593001";

    /**
     * EN: Code for Symptom free.<br>
     */
    public static final String SYMPTOM_FREE_CODE = "162467007";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.3.6.1.4.1.19376.1.5.3.1.11.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "HealthStatus_value";

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
    public static HealthStatusValue getEnum(@Nullable final String code) {
        for (final HealthStatusValue x : values()) {
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
            Enum.valueOf(HealthStatusValue.class,
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
        for (final HealthStatusValue x : values()) {
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
    HealthStatusValue(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
