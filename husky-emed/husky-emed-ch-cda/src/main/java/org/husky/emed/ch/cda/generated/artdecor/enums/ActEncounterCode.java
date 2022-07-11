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
 * Enumeration of ActEncounterCode values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>Domain provides codes that qualify the ActEncounterClass (ENC)</p>.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.13955<br>
 * Effective date: 2017-12-17 00:00<br>
 * Version: DEFN=UV=VO=1402-20171217<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-07-11")
public enum ActEncounterCode implements ValueSetEnumInterface {

    /**
     * EN: ambulatory.<br>
     */
    AMBULATORY_L1("AMB",
                  "2.16.840.1.113883.5.4",
                  "ambulatory",
                  "ambulatory",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: emergency.<br>
     */
    EMERGENCY_L1("EMER",
                 "2.16.840.1.113883.5.4",
                 "emergency",
                 "emergency",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: field.<br>
     */
    FIELD_L1("FLD",
             "2.16.840.1.113883.5.4",
             "field",
             "field",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: home health.<br>
     */
    HOME_HEALTH_L1("HH",
                   "2.16.840.1.113883.5.4",
                   "home health",
                   "home health",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: inpatient acute.<br>
     */
    INPATIENT_ACUTE_L2("ACUTE",
                       "2.16.840.1.113883.5.4",
                       "inpatient acute",
                       "inpatient acute",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: inpatient encounter.<br>
     */
    INPATIENT_ENCOUNTER_L1("IMP",
                           "2.16.840.1.113883.5.4",
                           "inpatient encounter",
                           "inpatient encounter",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: inpatient non-acute.<br>
     */
    INPATIENT_NON_ACUTE_L2("NONAC",
                           "2.16.840.1.113883.5.4",
                           "inpatient non-acute",
                           "inpatient non-acute",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: observation encounter.<br>
     */
    OBSERVATION_ENCOUNTER_L1("OBSENC",
                             "2.16.840.1.113883.5.4",
                             "observation encounter",
                             "observation encounter",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: pre-admission.<br>
     */
    PRE_ADMISSION_L1("PRENC",
                     "2.16.840.1.113883.5.4",
                     "pre-admission",
                     "pre-admission",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: short stay.<br>
     */
    SHORT_STAY_L1("SS",
                  "2.16.840.1.113883.5.4",
                  "short stay",
                  "short stay",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: virtual.<br>
     */
    VIRTUAL_L1("VR",
               "2.16.840.1.113883.5.4",
               "virtual",
               "virtual",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE");

    /**
     * EN: Code for ambulatory.<br>
     */
    public static final String AMBULATORY_L1_CODE = "AMB";

    /**
     * EN: Code for emergency.<br>
     */
    public static final String EMERGENCY_L1_CODE = "EMER";

    /**
     * EN: Code for field.<br>
     */
    public static final String FIELD_L1_CODE = "FLD";

    /**
     * EN: Code for home health.<br>
     */
    public static final String HOME_HEALTH_L1_CODE = "HH";

    /**
     * EN: Code for inpatient acute.<br>
     */
    public static final String INPATIENT_ACUTE_L2_CODE = "ACUTE";

    /**
     * EN: Code for inpatient encounter.<br>
     */
    public static final String INPATIENT_ENCOUNTER_L1_CODE = "IMP";

    /**
     * EN: Code for inpatient non-acute.<br>
     */
    public static final String INPATIENT_NON_ACUTE_L2_CODE = "NONAC";

    /**
     * EN: Code for observation encounter.<br>
     */
    public static final String OBSERVATION_ENCOUNTER_L1_CODE = "OBSENC";

    /**
     * EN: Code for pre-admission.<br>
     */
    public static final String PRE_ADMISSION_L1_CODE = "PRENC";

    /**
     * EN: Code for short stay.<br>
     */
    public static final String SHORT_STAY_L1_CODE = "SS";

    /**
     * EN: Code for virtual.<br>
     */
    public static final String VIRTUAL_L1_CODE = "VR";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.13955";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ActEncounterCode";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.4";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ActEncounterCode getEnum(@Nullable final String code) {
        for (final ActEncounterCode x : values()) {
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
            Enum.valueOf(ActEncounterCode.class,
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
        for (final ActEncounterCode x : values()) {
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
    ActEncounterCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
