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
 * Enumeration of ELGA_ActEncounterCode values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.5<br>
 * Effective date: 2013-09-12 00:00<br>
 * Version: null<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-21")
public enum ElgaActEncounterCode implements ValueSetEnumInterface {

    /**
     * EN: Ambulatory.<br>
     */
    AMBULATORY_L1("AMB",
                  "2.16.840.1.113883.5.4",
                  "Ambulatory",
                  "Ambulatory",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Emergency.<br>
     */
    EMERGENCY_L1("EMER",
                 "2.16.840.1.113883.5.4",
                 "Emergency",
                 "Emergency",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Home health.<br>
     */
    HOME_HEALTH_L1("HH",
                   "2.16.840.1.113883.5.4",
                   "Home health",
                   "Home health",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Inpatient acute.<br>
     */
    INPATIENT_ACUTE_L2("ACUTE",
                       "2.16.840.1.113883.5.4",
                       "Inpatient acute",
                       "Inpatient acute",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Inpatient encounter.<br>
     */
    INPATIENT_ENCOUNTER_L1("IMP",
                           "2.16.840.1.113883.5.4",
                           "Inpatient encounter",
                           "Inpatient encounter",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Inpatient non-acute.<br>
     */
    INPATIENT_NON_ACUTE_L2("NONAC",
                           "2.16.840.1.113883.5.4",
                           "Inpatient non-acute",
                           "Inpatient non-acute",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Virtual.<br>
     */
    VIRTUAL_L1("VR",
               "2.16.840.1.113883.5.4",
               "Virtual",
               "Virtual",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE");

    /**
     * EN: Code for Ambulatory.<br>
     */
    public static final String AMBULATORY_L1_CODE = "AMB";

    /**
     * EN: Code for Emergency.<br>
     */
    public static final String EMERGENCY_L1_CODE = "EMER";

    /**
     * EN: Code for Home health.<br>
     */
    public static final String HOME_HEALTH_L1_CODE = "HH";

    /**
     * EN: Code for Inpatient acute.<br>
     */
    public static final String INPATIENT_ACUTE_L2_CODE = "ACUTE";

    /**
     * EN: Code for Inpatient encounter.<br>
     */
    public static final String INPATIENT_ENCOUNTER_L1_CODE = "IMP";

    /**
     * EN: Code for Inpatient non-acute.<br>
     */
    public static final String INPATIENT_NON_ACUTE_L2_CODE = "NONAC";

    /**
     * EN: Code for Virtual.<br>
     */
    public static final String VIRTUAL_L1_CODE = "VR";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.5";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_ActEncounterCode";

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
    public static ElgaActEncounterCode getEnum(@Nullable final String code) {
        for (final ElgaActEncounterCode x : values()) {
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
            Enum.valueOf(ElgaActEncounterCode.class,
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
        for (final ElgaActEncounterCode x : values()) {
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
    ElgaActEncounterCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
