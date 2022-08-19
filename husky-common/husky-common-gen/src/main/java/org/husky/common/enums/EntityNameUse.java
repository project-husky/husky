/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Enumeration of ELGA_EntityNameUse values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.27<br>
 * Effective date: 2011-12-19 00:00<br>
 * Version: null<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-04-19")
public enum EntityNameUse implements ValueSetEnumInterface {

    /**
     * EN: Alphabetic.<br>
     */
    ALPHABETIC_L1("ABC",
                  "2.16.840.1.113883.5.45",
                  "Alphabetic",
                  "Alphabetic",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Artist/Stage.<br>
     */
    ARTIST_STAGE_L1("A",
                    "2.16.840.1.113883.5.45",
                    "Artist/Stage",
                    "Artist/Stage",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: assigned.<br>
     */
    ASSIGNED("ASGN",
             "2.16.840.1.113883.5.45",
             "assigned",
             "assigned",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Ideographic.<br>
     */
    IDEOGRAPHIC_L1("IDE",
                   "2.16.840.1.113883.5.45",
                   "Ideographic",
                   "Ideographic",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Indigenous/Tribal.<br>
     */
    INDIGENOUS_TRIBAL("I",
                      "2.16.840.1.113883.5.45",
                      "Indigenous/Tribal",
                      "Indigenous/Tribal",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Legal.<br>
     */
    LEGAL("L",
          "2.16.840.1.113883.5.45",
          "Legal",
          "Legal",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: License.<br>
     */
    LICENSE("C",
            "2.16.840.1.113883.5.45",
            "License",
            "License",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: official registry.<br>
     */
    OFFICIAL_REGISTRY_L1("OR",
                         "2.16.840.1.113883.5.45",
                         "official registry",
                         "official registry",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: phonetic.<br>
     */
    PHONETIC_L1("PHON",
                "2.16.840.1.113883.5.45",
                "phonetic",
                "phonetic",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: pseudonym.<br>
     */
    PSEUDONYM("P",
              "2.16.840.1.113883.5.45",
              "pseudonym",
              "pseudonym",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: Religious.<br>
     */
    RELIGIOUS("R",
              "2.16.840.1.113883.5.45",
              "Religious",
              "Religious",
              "TOTRANSLATE",
              "TOTRANSLATE",
              "TOTRANSLATE"),
    /**
     * EN: search v:HL7SearchUse.<br>
     */
    SEARCH_V_HL7SEARCHUSE("SRCH",
                          "2.16.840.1.113883.5.45",
                          "search v:HL7SearchUse",
                          "search v:HL7SearchUse",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Soundex.<br>
     */
    SOUNDEX_L1("SNDX",
               "2.16.840.1.113883.5.45",
               "Soundex",
               "Soundex",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: Syllabic.<br>
     */
    SYLLABIC_L1("SYL",
                "2.16.840.1.113883.5.45",
                "Syllabic",
                "Syllabic",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE");

    /**
     * EN: Code for Alphabetic.<br>
     */
    public static final String ALPHABETIC_L1_CODE = "ABC";

    /**
     * EN: Code for Artist/Stage.<br>
     */
    public static final String ARTIST_STAGE_L1_CODE = "A";

    /**
     * EN: Code for assigned.<br>
     */
    public static final String ASSIGNED_CODE = "ASGN";

    /**
     * EN: Code for Ideographic.<br>
     */
    public static final String IDEOGRAPHIC_L1_CODE = "IDE";

    /**
     * EN: Code for Indigenous/Tribal.<br>
     */
    public static final String INDIGENOUS_TRIBAL_CODE = "I";

    /**
     * EN: Code for Legal.<br>
     */
    public static final String LEGAL_CODE = "L";

    /**
     * EN: Code for License.<br>
     */
    public static final String LICENSE_CODE = "C";

    /**
     * EN: Code for official registry.<br>
     */
    public static final String OFFICIAL_REGISTRY_L1_CODE = "OR";

    /**
     * EN: Code for phonetic.<br>
     */
    public static final String PHONETIC_L1_CODE = "PHON";

    /**
     * EN: Code for pseudonym.<br>
     */
    public static final String PSEUDONYM_CODE = "P";

    /**
     * EN: Code for Religious.<br>
     */
    public static final String RELIGIOUS_CODE = "R";

    /**
     * EN: Code for search v:HL7SearchUse.<br>
     */
    public static final String SEARCH_V_HL7SEARCHUSE_CODE = "SRCH";

    /**
     * EN: Code for Soundex.<br>
     */
    public static final String SOUNDEX_L1_CODE = "SNDX";

    /**
     * EN: Code for Syllabic.<br>
     */
    public static final String SYLLABIC_L1_CODE = "SYL";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.27";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_EntityNameUse";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.45";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EntityNameUse getEnum(@Nullable final String code) {
        for (final EntityNameUse x : values()) {
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
            Enum.valueOf(EntityNameUse.class,
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
        for (final EntityNameUse x : values()) {
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
    EntityNameUse(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
