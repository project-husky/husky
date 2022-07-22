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
 * Enumeration of ELGA_PersonalRelationship values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.17<br>
 * Effective date: 2011-12-19 00:00<br>
 * Version: null<br>
 * Status: DEPRECATED
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-21")
public enum ElgaPersonalRelationship implements ValueSetEnumInterface {

    /**
     * EN: adopted child.<br>
     */
    ADOPTED_CHILD("CHLDADOPT",
                  "2.16.840.1.113883.5.111",
                  "adopted child",
                  "adopted child",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: adopted daughter.<br>
     */
    ADOPTED_DAUGHTER("DAUADOPT",
                     "2.16.840.1.113883.5.111",
                     "adopted daughter",
                     "adopted daughter",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: adopted son.<br>
     */
    ADOPTED_SON("SONADOPT",
                "2.16.840.1.113883.5.111",
                "adopted son",
                "adopted son",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: aunt.<br>
     */
    AUNT("AUNT",
         "2.16.840.1.113883.5.111",
         "aunt",
         "aunt",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: child.<br>
     */
    CHILD("CHILD",
          "2.16.840.1.113883.5.111",
          "child",
          "child",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: child in-law.<br>
     */
    CHILD_IN_LAW("CHLDINLAW",
                 "2.16.840.1.113883.5.111",
                 "child in-law",
                 "child in-law",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: cousin.<br>
     */
    COUSIN("COUSN",
           "2.16.840.1.113883.5.111",
           "cousin",
           "cousin",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: daughter.<br>
     */
    DAUGHTER("DAUC",
             "2.16.840.1.113883.5.111",
             "daughter",
             "daughter",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: daughter in-law.<br>
     */
    DAUGHTER_IN_LAW("DAUINLAW",
                    "2.16.840.1.113883.5.111",
                    "daughter in-law",
                    "daughter in-law",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: domestic partner.<br>
     */
    DOMESTIC_PARTNER("DOMPART",
                     "2.16.840.1.113883.5.111",
                     "domestic partner",
                     "domestic partner",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: family member.<br>
     */
    FAMILY_MEMBER("FAMMEMB",
                  "2.16.840.1.113883.5.111",
                  "family member",
                  "family member",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: father.<br>
     */
    FATHER("FTH",
           "2.16.840.1.113883.5.111",
           "father",
           "father",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: father-in-law.<br>
     */
    FATHER_IN_LAW("FTHINLAW",
                  "2.16.840.1.113883.5.111",
                  "father-in-law",
                  "father-in-law",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: foster child.<br>
     */
    FOSTER_CHILD("CHLDFOST",
                 "2.16.840.1.113883.5.111",
                 "foster child",
                 "foster child",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: foster daughter.<br>
     */
    FOSTER_DAUGHTER("DAUFOST",
                    "2.16.840.1.113883.5.111",
                    "foster daughter",
                    "foster daughter",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: foster son.<br>
     */
    FOSTER_SON("SONFOST",
               "2.16.840.1.113883.5.111",
               "foster son",
               "foster son",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: grandchild.<br>
     */
    GRANDCHILD("GRNDCHILD",
               "2.16.840.1.113883.5.111",
               "grandchild",
               "grandchild",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: grandparent.<br>
     */
    GRANDPARENT("GRPRN",
                "2.16.840.1.113883.5.111",
                "grandparent",
                "grandparent",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: great grandparent.<br>
     */
    GREAT_GRANDPARENT("GGRPRN",
                      "2.16.840.1.113883.5.111",
                      "great grandparent",
                      "great grandparent",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: husband.<br>
     */
    HUSBAND_L1("HUSB",
               "2.16.840.1.113883.5.111",
               "husband",
               "husband",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: mother.<br>
     */
    MOTHER("MTH",
           "2.16.840.1.113883.5.111",
           "mother",
           "mother",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: mother-in-law.<br>
     */
    MOTHER_IN_LAW("MTHINLAW",
                  "2.16.840.1.113883.5.111",
                  "mother-in-law",
                  "mother-in-law",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: natural child.<br>
     */
    NATURAL_CHILD("NCHILD",
                  "2.16.840.1.113883.5.111",
                  "natural child",
                  "natural child",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: natural daughter.<br>
     */
    NATURAL_DAUGHTER("DAU",
                     "2.16.840.1.113883.5.111",
                     "natural daughter",
                     "natural daughter",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: natural son.<br>
     */
    NATURAL_SON("SON",
                "2.16.840.1.113883.5.111",
                "natural son",
                "natural son",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: neighbor.<br>
     */
    NEIGHBOR("NBOR",
             "2.16.840.1.113883.5.111",
             "neighbor",
             "neighbor",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: niece/nephew.<br>
     */
    NIECE_NEPHEW("NIENEPH",
                 "2.16.840.1.113883.5.111",
                 "niece/nephew",
                 "niece/nephew",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: parent.<br>
     */
    PARENT("PRN",
           "2.16.840.1.113883.5.111",
           "parent",
           "parent",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: parent in-law.<br>
     */
    PARENT_IN_LAW("PRNINLAW",
                  "2.16.840.1.113883.5.111",
                  "parent in-law",
                  "parent in-law",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: roommate.<br>
     */
    ROOMMATE("ROOM",
             "2.16.840.1.113883.5.111",
             "roommate",
             "roommate",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: sibling.<br>
     */
    SIBLING("SIB",
            "2.16.840.1.113883.5.111",
            "sibling",
            "sibling",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: significant other.<br>
     */
    SIGNIFICANT_OTHER("SIGOTHR",
                      "2.16.840.1.113883.5.111",
                      "significant other",
                      "significant other",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: son.<br>
     */
    SON("SONC",
        "2.16.840.1.113883.5.111",
        "son",
        "son",
        "TOTRANSLATE",
        "TOTRANSLATE",
        "TOTRANSLATE"),
    /**
     * EN: son in-law.<br>
     */
    SON_IN_LAW("SONINLAW",
               "2.16.840.1.113883.5.111",
               "son in-law",
               "son in-law",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: spouse.<br>
     */
    SPOUSE("SPS",
           "2.16.840.1.113883.5.111",
           "spouse",
           "spouse",
           "TOTRANSLATE",
           "TOTRANSLATE",
           "TOTRANSLATE"),
    /**
     * EN: stepdaughter.<br>
     */
    STEPDAUGHTER("STPDAU",
                 "2.16.840.1.113883.5.111",
                 "stepdaughter",
                 "stepdaughter",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: stepson.<br>
     */
    STEPSON("STPSON",
            "2.16.840.1.113883.5.111",
            "stepson",
            "stepson",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: step child.<br>
     */
    STEP_CHILD("STPCHLD",
               "2.16.840.1.113883.5.111",
               "step child",
               "step child",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: uncle.<br>
     */
    UNCLE("UNCLE",
          "2.16.840.1.113883.5.111",
          "uncle",
          "uncle",
          "TOTRANSLATE",
          "TOTRANSLATE",
          "TOTRANSLATE"),
    /**
     * EN: unrelated friend.<br>
     */
    UNRELATED_FRIEND("FRND",
                     "2.16.840.1.113883.5.111",
                     "unrelated friend",
                     "unrelated friend",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: wife.<br>
     */
    WIFE_L1("WIFE",
            "2.16.840.1.113883.5.111",
            "wife",
            "wife",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE");

    /**
     * EN: Code for adopted child.<br>
     */
    public static final String ADOPTED_CHILD_CODE = "CHLDADOPT";

    /**
     * EN: Code for adopted daughter.<br>
     */
    public static final String ADOPTED_DAUGHTER_CODE = "DAUADOPT";

    /**
     * EN: Code for adopted son.<br>
     */
    public static final String ADOPTED_SON_CODE = "SONADOPT";

    /**
     * EN: Code for aunt.<br>
     */
    public static final String AUNT_CODE = "AUNT";

    /**
     * EN: Code for child.<br>
     */
    public static final String CHILD_CODE = "CHILD";

    /**
     * EN: Code for child in-law.<br>
     */
    public static final String CHILD_IN_LAW_CODE = "CHLDINLAW";

    /**
     * EN: Code for cousin.<br>
     */
    public static final String COUSIN_CODE = "COUSN";

    /**
     * EN: Code for daughter.<br>
     */
    public static final String DAUGHTER_CODE = "DAUC";

    /**
     * EN: Code for daughter in-law.<br>
     */
    public static final String DAUGHTER_IN_LAW_CODE = "DAUINLAW";

    /**
     * EN: Code for domestic partner.<br>
     */
    public static final String DOMESTIC_PARTNER_CODE = "DOMPART";

    /**
     * EN: Code for family member.<br>
     */
    public static final String FAMILY_MEMBER_CODE = "FAMMEMB";

    /**
     * EN: Code for father.<br>
     */
    public static final String FATHER_CODE = "FTH";

    /**
     * EN: Code for father-in-law.<br>
     */
    public static final String FATHER_IN_LAW_CODE = "FTHINLAW";

    /**
     * EN: Code for foster child.<br>
     */
    public static final String FOSTER_CHILD_CODE = "CHLDFOST";

    /**
     * EN: Code for foster daughter.<br>
     */
    public static final String FOSTER_DAUGHTER_CODE = "DAUFOST";

    /**
     * EN: Code for foster son.<br>
     */
    public static final String FOSTER_SON_CODE = "SONFOST";

    /**
     * EN: Code for grandchild.<br>
     */
    public static final String GRANDCHILD_CODE = "GRNDCHILD";

    /**
     * EN: Code for grandparent.<br>
     */
    public static final String GRANDPARENT_CODE = "GRPRN";

    /**
     * EN: Code for great grandparent.<br>
     */
    public static final String GREAT_GRANDPARENT_CODE = "GGRPRN";

    /**
     * EN: Code for husband.<br>
     */
    public static final String HUSBAND_L1_CODE = "HUSB";

    /**
     * EN: Code for mother.<br>
     */
    public static final String MOTHER_CODE = "MTH";

    /**
     * EN: Code for mother-in-law.<br>
     */
    public static final String MOTHER_IN_LAW_CODE = "MTHINLAW";

    /**
     * EN: Code for natural child.<br>
     */
    public static final String NATURAL_CHILD_CODE = "NCHILD";

    /**
     * EN: Code for natural daughter.<br>
     */
    public static final String NATURAL_DAUGHTER_CODE = "DAU";

    /**
     * EN: Code for natural son.<br>
     */
    public static final String NATURAL_SON_CODE = "SON";

    /**
     * EN: Code for neighbor.<br>
     */
    public static final String NEIGHBOR_CODE = "NBOR";

    /**
     * EN: Code for niece/nephew.<br>
     */
    public static final String NIECE_NEPHEW_CODE = "NIENEPH";

    /**
     * EN: Code for parent.<br>
     */
    public static final String PARENT_CODE = "PRN";

    /**
     * EN: Code for parent in-law.<br>
     */
    public static final String PARENT_IN_LAW_CODE = "PRNINLAW";

    /**
     * EN: Code for roommate.<br>
     */
    public static final String ROOMMATE_CODE = "ROOM";

    /**
     * EN: Code for sibling.<br>
     */
    public static final String SIBLING_CODE = "SIB";

    /**
     * EN: Code for significant other.<br>
     */
    public static final String SIGNIFICANT_OTHER_CODE = "SIGOTHR";

    /**
     * EN: Code for son.<br>
     */
    public static final String SON_CODE = "SONC";

    /**
     * EN: Code for son in-law.<br>
     */
    public static final String SON_IN_LAW_CODE = "SONINLAW";

    /**
     * EN: Code for spouse.<br>
     */
    public static final String SPOUSE_CODE = "SPS";

    /**
     * EN: Code for stepdaughter.<br>
     */
    public static final String STEPDAUGHTER_CODE = "STPDAU";

    /**
     * EN: Code for stepson.<br>
     */
    public static final String STEPSON_CODE = "STPSON";

    /**
     * EN: Code for step child.<br>
     */
    public static final String STEP_CHILD_CODE = "STPCHLD";

    /**
     * EN: Code for uncle.<br>
     */
    public static final String UNCLE_CODE = "UNCLE";

    /**
     * EN: Code for unrelated friend.<br>
     */
    public static final String UNRELATED_FRIEND_CODE = "FRND";

    /**
     * EN: Code for wife.<br>
     */
    public static final String WIFE_L1_CODE = "WIFE";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.17";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_PersonalRelationship";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.111";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaPersonalRelationship getEnum(@Nullable final String code) {
        for (final ElgaPersonalRelationship x : values()) {
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
            Enum.valueOf(ElgaPersonalRelationship.class,
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
        for (final ElgaPersonalRelationship x : values()) {
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
    ElgaPersonalRelationship(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
