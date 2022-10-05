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
 * Enumeration of PostalAddressUse values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.10637<br>
 * Effective date: 2013-01-31 00:00<br>
 * Version: null<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-04-19")
public enum PostalAddressUse implements ValueSetEnumInterface {

    /**
     * EN: bad address.<br>
     */
    BAD_ADDRESS("BAD",
                "2.16.840.1.113883.5.1119",
                "bad address",
                "bad address",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: confidential.<br>
     */
    CONFIDENTIAL("CONF",
                 "2.16.840.1.113883.5.1119",
                 "confidential",
                 "confidential",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: direct.<br>
     */
    DIRECT("DIR",
           "2.16.840.1.113883.5.1119",
           "direct",
           "direct",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: home address.<br>
     */
    HOME_ADDRESS("H",
                 "2.16.840.1.113883.5.1119",
                 "home address",
                 "home address",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: physical visit address.<br>
     */
    PHYSICAL_VISIT_ADDRESS("PHYS",
                           "2.16.840.1.113883.5.1119",
                           "physical visit address",
                           "physical visit address",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: postal address.<br>
     */
    POSTAL_ADDRESS("PST",
                   "2.16.840.1.113883.5.1119",
                   "postal address",
                   "postal address",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: primary home.<br>
     */
    PRIMARY_HOME("HP",
                 "2.16.840.1.113883.5.1119",
                 "primary home",
                 "primary home",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: public.<br>
     */
    PUBLIC("PUB",
           "2.16.840.1.113883.5.1119",
           "public",
           "public",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: temporary.<br>
     */
    TEMPORARY("TMP",
              "2.16.840.1.113883.5.1119",
              "temporary",
              "temporary",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: vacation home.<br>
     */
    VACATION_HOME("HV",
                  "2.16.840.1.113883.5.1119",
                  "vacation home",
                  "vacation home",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: work place.<br>
     */
    WORK_PLACE("WP",
               "2.16.840.1.113883.5.1119",
               "work place",
               "work place",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE");

    /**
     * EN: Code for bad address.<br>
     */
    public static final String BAD_ADDRESS_CODE = "BAD";

    /**
     * EN: Code for confidential.<br>
     */
    public static final String CONFIDENTIAL_CODE = "CONF";

    /**
     * EN: Code for direct.<br>
     */
    public static final String DIRECT_CODE = "DIR";

    /**
     * EN: Code for home address.<br>
     */
    public static final String HOME_ADDRESS_CODE = "H";

    /**
     * EN: Code for physical visit address.<br>
     */
    public static final String PHYSICAL_VISIT_ADDRESS_CODE = "PHYS";

    /**
     * EN: Code for postal address.<br>
     */
    public static final String POSTAL_ADDRESS_CODE = "PST";

    /**
     * EN: Code for primary home.<br>
     */
    public static final String PRIMARY_HOME_CODE = "HP";

    /**
     * EN: Code for public.<br>
     */
    public static final String PUBLIC_CODE = "PUB";

    /**
     * EN: Code for temporary.<br>
     */
    public static final String TEMPORARY_CODE = "TMP";

    /**
     * EN: Code for vacation home.<br>
     */
    public static final String VACATION_HOME_CODE = "HV";

    /**
     * EN: Code for work place.<br>
     */
    public static final String WORK_PLACE_CODE = "WP";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.10637";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "PostalAddressUse";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.1119";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static PostalAddressUse getEnum(@Nullable final String code) {
        for (final PostalAddressUse x : values()) {
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
            Enum.valueOf(PostalAddressUse.class,
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
        for (final PostalAddressUse x : values()) {
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
    PostalAddressUse(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
