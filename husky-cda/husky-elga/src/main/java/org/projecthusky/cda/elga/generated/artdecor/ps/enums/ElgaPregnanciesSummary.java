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
 * Enumeration of ELGA_PregnanciesSummary values
 * <p>
 * EN: Value Set PregnanciesSummary.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.203<br>
 * Effective date: 2017-09-06 21:33<br>
 * Version: 201709(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-03-01")
public enum ElgaPregnanciesSummary implements ValueSetEnumInterface {

    /**
     * EN: [#] Abortions.<br>
     */
    _ABORTIONS("11612-9",
               "2.16.840.1.113883.6.1",
               "[#] Abortions",
               "[#] Abortions",
               "TOTRANSLATE",
               "TOTRANSLATE",
               "TOTRANSLATE"),
    /**
     * EN: [#] Abortions.induced.<br>
     */
    _ABORTIONS_INDUCED("11613-7",
                       "2.16.840.1.113883.6.1",
                       "[#] Abortions.induced",
                       "[#] Abortions.induced",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: [#] Abortions.spontaneous.<br>
     */
    _ABORTIONS_SPONTANEOUS("11614-5",
                           "2.16.840.1.113883.6.1",
                           "[#] Abortions.spontaneous",
                           "[#] Abortions.spontaneous",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: [#] Births.live.<br>
     */
    _BIRTHS_LIVE("11636-8",
                 "2.16.840.1.113883.6.1",
                 "[#] Births.live",
                 "[#] Births.live",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: [#] Births.preterm.<br>
     */
    _BIRTHS_PRETERM("11637-6",
                    "2.16.840.1.113883.6.1",
                    "[#] Births.preterm",
                    "[#] Births.preterm",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: [#] Births.still living.<br>
     */
    _BIRTHS_STILL_LIVING("11638-4",
                         "2.16.840.1.113883.6.1",
                         "[#] Births.still living",
                         "[#] Births.still living",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: [#] Births.term.<br>
     */
    _BIRTHS_TERM("11639-2",
                 "2.16.840.1.113883.6.1",
                 "[#] Births.term",
                 "[#] Births.term",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: [#] Births total.<br>
     */
    _BIRTHS_TOTAL("11640-0",
                  "2.16.840.1.113883.6.1",
                  "[#] Births total",
                  "[#] Births total",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: [#] Ectopic pregnancy.<br>
     */
    _ECTOPIC_PREGNANCY("33065-4",
                       "2.16.840.1.113883.6.1",
                       "[#] Ectopic pregnancy",
                       "[#] Ectopic pregnancy",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE");

    /**
     * EN: Code for [#] Abortions.<br>
     */
    public static final String _ABORTIONS_CODE = "11612-9";

    /**
     * EN: Code for [#] Abortions.induced.<br>
     */
    public static final String _ABORTIONS_INDUCED_CODE = "11613-7";

    /**
     * EN: Code for [#] Abortions.spontaneous.<br>
     */
    public static final String _ABORTIONS_SPONTANEOUS_CODE = "11614-5";

    /**
     * EN: Code for [#] Births.live.<br>
     */
    public static final String _BIRTHS_LIVE_CODE = "11636-8";

    /**
     * EN: Code for [#] Births.preterm.<br>
     */
    public static final String _BIRTHS_PRETERM_CODE = "11637-6";

    /**
     * EN: Code for [#] Births.still living.<br>
     */
    public static final String _BIRTHS_STILL_LIVING_CODE = "11638-4";

    /**
     * EN: Code for [#] Births.term.<br>
     */
    public static final String _BIRTHS_TERM_CODE = "11639-2";

    /**
     * EN: Code for [#] Births total.<br>
     */
    public static final String _BIRTHS_TOTAL_CODE = "11640-0";

    /**
     * EN: Code for [#] Ectopic pregnancy.<br>
     */
    public static final String _ECTOPIC_PREGNANCY_CODE = "33065-4";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.203";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_PregnanciesSummary";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.6.1";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaPregnanciesSummary getEnum(@Nullable final String code) {
        for (final ElgaPregnanciesSummary x : values()) {
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
            Enum.valueOf(ElgaPregnanciesSummary.class,
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
        for (final ElgaPregnanciesSummary x : values()) {
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
    ElgaPregnanciesSummary(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
