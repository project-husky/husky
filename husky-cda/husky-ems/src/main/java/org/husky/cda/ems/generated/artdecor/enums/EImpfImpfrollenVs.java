/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of eImpf_Impfrollen_VS values
 * <p>
 * EN: Professional groups from the Health Telematics Regulation that carry out vaccinations.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.11<br>
 * Effective date: 2020-12-17 00:00<br>
 * Version: 202012(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-01")
public enum EImpfImpfrollenVs implements ValueSetEnumInterface {

    /**
     * EN: Approbierte Ärztin/Approbierter Arzt.<br>
     */
    APPROBIERTE_RZTIN_APPROBIERTER_ARZT("101",
                                        "1.2.40.0.34.5.2",
                                        "Approbierte Ärztin/Approbierter Arzt",
                                        "Approbierte Ärztin/Approbierter Arzt",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger.<br>
     */
    DIPLOMIERTE_GESUNDHEITS_UND_KRANKENSCHWESTER_DIPLOMIERTER_GESUNDHEITS_UND_KRANKENPFLEGER("212",
                                                                                             "1.2.40.0.34.5.2",
                                                                                             "Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger",
                                                                                             "Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger",
                                                                                             "TOTRANSLATE",
                                                                                             "TOTRANSLATE",
                                                                                             "TOTRANSLATE"),
    /**
     * EN: Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger.<br>
     */
    DIPLOMIERTE_KINDERKRANKENSCHWESTER_DIPLOMIERTER_KINDERKRANKENPFLEGER("213",
                                                                         "1.2.40.0.34.5.2",
                                                                         "Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger",
                                                                         "Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger",
                                                                         "TOTRANSLATE",
                                                                         "TOTRANSLATE",
                                                                         "TOTRANSLATE"),
    /**
     * EN: Diplomierte psychiatrische Gesundheits- und Krankenschwester/Diplomierter psychiatrischer Gesundheits- und Krankenpfleger.<br>
     */
    DIPLOMIERTE_PSYCHIATRISCHE_GESUNDHEITS_UND_KRANKENSCHWESTER_DIPLOMIERTER_PSYCHIATRISCHER_GESUNDHEITS_UND_KRANKENPFLEGER("214",
                                                                                                                            "1.2.40.0.34.5.2",
                                                                                                                            "Diplomierte psychiatrische Gesundheits- und Krankenschwester/Diplomierter psychiatrischer Gesundheits- und Krankenpfleger",
                                                                                                                            "Diplomierte psychiatrische Gesundheits- und Krankenschwester/Diplomierter psychiatrischer Gesundheits- und Krankenpfleger",
                                                                                                                            "TOTRANSLATE",
                                                                                                                            "TOTRANSLATE",
                                                                                                                            "TOTRANSLATE"),
    /**
     * EN: Fachärztin/Facharzt.<br>
     */
    FACH_RZTIN_FACHARZT("158",
                        "1.2.40.0.34.5.2",
                        "Fachärztin/Facharzt",
                        "Fachärztin/Facharzt",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Hebamme.<br>
     */
    HEBAMME("204",
            "1.2.40.0.34.5.2",
            "Hebamme",
            "Hebamme",
            "TOTRANSLATE",
            "TOTRANSLATE",
            "TOTRANSLATE"),
    /**
     * EN: Ärztin/Arzt für Allgemeinmedizin.<br>
     */
    _RZTIN_ARZT_F_R_ALLGEMEINMEDIZIN("100",
                                     "1.2.40.0.34.5.2",
                                     "Ärztin/Arzt für Allgemeinmedizin",
                                     "Ärztin/Arzt für Allgemeinmedizin",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE");

    /**
     * EN: Code for Approbierte Ärztin/Approbierter Arzt.<br>
     */
    public static final String APPROBIERTE_RZTIN_APPROBIERTER_ARZT_CODE = "101";

    /**
     * EN: Code for Diplomierte Gesundheits- und Krankenschwester/Diplomierter Gesundheits- und Krankenpfleger.<br>
     */
    public static final String DIPLOMIERTE_GESUNDHEITS_UND_KRANKENSCHWESTER_DIPLOMIERTER_GESUNDHEITS_UND_KRANKENPFLEGER_CODE = "212";

    /**
     * EN: Code for Diplomierte Kinderkrankenschwester/Diplomierter Kinderkrankenpfleger.<br>
     */
    public static final String DIPLOMIERTE_KINDERKRANKENSCHWESTER_DIPLOMIERTER_KINDERKRANKENPFLEGER_CODE = "213";

    /**
     * EN: Code for Diplomierte psychiatrische Gesundheits- und Krankenschwester/Diplomierter psychiatrischer Gesundheits- und Krankenpfleger.<br>
     */
    public static final String DIPLOMIERTE_PSYCHIATRISCHE_GESUNDHEITS_UND_KRANKENSCHWESTER_DIPLOMIERTER_PSYCHIATRISCHER_GESUNDHEITS_UND_KRANKENPFLEGER_CODE = "214";

    /**
     * EN: Code for Fachärztin/Facharzt.<br>
     */
    public static final String FACH_RZTIN_FACHARZT_CODE = "158";

    /**
     * EN: Code for Hebamme.<br>
     */
    public static final String HEBAMME_CODE = "204";

    /**
     * EN: Code for Ärztin/Arzt für Allgemeinmedizin.<br>
     */
    public static final String _RZTIN_ARZT_F_R_ALLGEMEINMEDIZIN_CODE = "100";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.11";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "eImpf_Impfrollen_VS";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "1.2.40.0.34.5.2";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EImpfImpfrollenVs getEnum(@Nullable final String code) {
        for (final EImpfImpfrollenVs x : values()) {
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
            Enum.valueOf(EImpfImpfrollenVs.class,
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
        for (final EImpfImpfrollenVs x : values()) {
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
    EImpfImpfrollenVs(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
