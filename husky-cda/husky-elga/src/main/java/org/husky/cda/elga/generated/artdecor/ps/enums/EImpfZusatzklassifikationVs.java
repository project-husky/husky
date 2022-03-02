/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ps.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of eImpf_Zusatzklassifikation_VS values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.62<br>
 * Effective date: 2021-10-04 00:00<br>
 * Version: 202110(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-03-01")
public enum EImpfZusatzklassifikationVs implements ValueSetEnumInterface {

    /**
     * EN: Arbeitsplatz/Betriebe.<br>
     */
    ARBEITSPLATZ_BETRIEBE_L1("IS002",
                             "1.2.40.0.34.5.183",
                             "Arbeitsplatz/Betriebe",
                             "Arbeitsplatz/Betriebe",
                             "TOTRANSLATE",
                             "TOTRANSLATE",
                             "TOTRANSLATE"),
    /**
     * EN: Bildungseinrichtung.<br>
     */
    BILDUNGSEINRICHTUNG_L1("IS001",
                           "1.2.40.0.34.5.183",
                           "Bildungseinrichtung",
                           "Bildungseinrichtung",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Impfstelle (Impfsetting).<br>
     */
    IMPFSTELLE_IMPFSETTING("46224007",
                           "2.16.840.1.113883.6.96",
                           "Impfstelle (Impfsetting)",
                           "Impfstelle (Impfsetting)",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Krankenhaus inkl. Kur- und Rehaeinrichtungen.<br>
     */
    KRANKENHAUS_INKL_KUR_UND_REHAEINRICHTUNGEN_L1("IS003",
                                                  "1.2.40.0.34.5.183",
                                                  "Krankenhaus inkl. Kur- und Rehaeinrichtungen",
                                                  "Krankenhaus inkl. Kur- und Rehaeinrichtungen",
                                                  "TOTRANSLATE",
                                                  "TOTRANSLATE",
                                                  "TOTRANSLATE"),
    /**
     * EN: Ordination.<br>
     */
    ORDINATION_L1("IS004",
                  "1.2.40.0.34.5.183",
                  "Ordination",
                  "Ordination",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: Wohnbereich und Betreuungseinrichtungen.<br>
     */
    WOHNBEREICH_UND_BETREUUNGSEINRICHTUNGEN_L1("IS006",
                                               "1.2.40.0.34.5.183",
                                               "Wohnbereich und Betreuungseinrichtungen",
                                               "Wohnbereich und Betreuungseinrichtungen",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE"),
    /**
     * EN: Öffentliche Impfstelle/Impfstraße.<br>
     */
    _FFENTLICHE_IMPFSTELLE_IMPFSTRASSE_L1("IS005",
                                          "1.2.40.0.34.5.183",
                                          "Öffentliche Impfstelle/Impfstraße",
                                          "Öffentliche Impfstelle/Impfstraße",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE");

    /**
     * EN: Code for Arbeitsplatz/Betriebe.<br>
     */
    public static final String ARBEITSPLATZ_BETRIEBE_L1_CODE = "IS002";

    /**
     * EN: Code for Bildungseinrichtung.<br>
     */
    public static final String BILDUNGSEINRICHTUNG_L1_CODE = "IS001";

    /**
     * EN: Code for Impfstelle (Impfsetting).<br>
     */
    public static final String IMPFSTELLE_IMPFSETTING_CODE = "46224007";

    /**
     * EN: Code for Krankenhaus inkl. Kur- und Rehaeinrichtungen.<br>
     */
    public static final String KRANKENHAUS_INKL_KUR_UND_REHAEINRICHTUNGEN_L1_CODE = "IS003";

    /**
     * EN: Code for Ordination.<br>
     */
    public static final String ORDINATION_L1_CODE = "IS004";

    /**
     * EN: Code for Wohnbereich und Betreuungseinrichtungen.<br>
     */
    public static final String WOHNBEREICH_UND_BETREUUNGSEINRICHTUNGEN_L1_CODE = "IS006";

    /**
     * EN: Code for Öffentliche Impfstelle/Impfstraße.<br>
     */
    public static final String _FFENTLICHE_IMPFSTELLE_IMPFSTRASSE_L1_CODE = "IS005";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.62";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "eImpf_Zusatzklassifikation_VS";

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
    public static EImpfZusatzklassifikationVs getEnum(@Nullable final String code) {
        for (final EImpfZusatzklassifikationVs x : values()) {
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
            Enum.valueOf(EImpfZusatzklassifikationVs.class,
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
        for (final EImpfZusatzklassifikationVs x : values()) {
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
    EImpfZusatzklassifikationVs(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
