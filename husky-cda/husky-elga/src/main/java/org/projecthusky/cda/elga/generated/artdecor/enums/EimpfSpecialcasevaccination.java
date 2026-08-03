/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of eimpf-specialcasevaccination values
 * <p>
 * EN: Special cases for vaccination entries (Immunization Entry, Immunization Recommendation Entry). Contains information protected by copyright of SNOMED International. Any use of SNOMED CT in Austria requires a valid affiliate license or sublicense. The corresponding license is free of charge, provided that the use only takes place in Austria and fulfills the conditions of the Affiliate License Agreement. Affiliate licenses can be requested directly from the respective NRC via the Member Licensing and Distribution Service (MLDS). https://mlds.ihtsdotools.org/#/landing/AT?lang=de.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.3<br>
 * Effective date: 2022-06-10 00:00<br>
 * Version: 202206(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2026-02-19")
public enum EimpfSpecialcasevaccination implements ValueSetEnumInterface {

    /**
     * EN: Ausnahme.<br>
     */
    AUSNAHME("_Ausnahme",
             "1.2.40.0.34.5.183",
             "Ausnahme",
             "Ausnahme",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Blau.<br>
     */
    BLAU("_Blau",
         "1.2.40.0.34.5.183",
         "Blau",
         "Blau",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: Durchgemachte Infektionskrankheit.<br>
     */
    DURCHGEMACHTE_INFEKTIONSKRANKHEIT_L1("161413004",
                                         "2.16.840.1.113883.6.96",
                                         "Durchgemachte Infektionskrankheit",
                                         "Durchgemachte Infektionskrankheit",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Erfordert Impfung.<br>
     */
    ERFORDERT_IMPFUNG_L1("723620004",
                         "2.16.840.1.113883.6.96",
                         "Erfordert Impfung",
                         "Erfordert Impfung",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Gelb.<br>
     */
    GELB("_Gelb",
         "1.2.40.0.34.5.183",
         "Gelb",
         "Gelb",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: Grau.<br>
     */
    GRAU("_Grau",
         "1.2.40.0.34.5.183",
         "Grau",
         "Grau",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: Grün.<br>
     */
    GR_N("_Grün",
         "1.2.40.0.34.5.183",
         "Grün",
         "Grün",
         "TOTRANSLATE",
         "TOTRANSLATE",
         "TOTRANSLATE"),
    /**
     * EN: Immunität erworben.<br>
     */
    IMMUNIT_T_ERWORBEN_L1("191441008",
                          "2.16.840.1.113883.6.96",
                          "Immunität erworben",
                          "Immunität erworben",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Impfschutz auf dem neuesten Stand.<br>
     */
    IMPFSCHUTZ_AUF_DEM_NEUESTEN_STAND_L1("171258008",
                                         "2.16.840.1.113883.6.96",
                                         "Impfschutz auf dem neuesten Stand",
                                         "Impfschutz auf dem neuesten Stand",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Impftermin anstehend.<br>
     */
    IMPFTERMIN_ANSTEHEND_L1("789539003",
                            "2.16.840.1.113883.6.96",
                            "Impftermin anstehend",
                            "Impftermin anstehend",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Impfung überfällig.<br>
     */
    IMPFUNG_BERF_LLIG_L1("789540001",
                         "2.16.840.1.113883.6.96",
                         "Impfung überfällig",
                         "Impfung überfällig",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Impfung fällig.<br>
     */
    IMPFUNG_F_LLIG_L1("171279008",
                      "2.16.840.1.113883.6.96",
                      "Impfung fällig",
                      "Impfung fällig",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Impfung kontraindiziert.<br>
     */
    IMPFUNG_KONTRAINDIZIERT_L1("266758009",
                               "2.16.840.1.113883.6.96",
                               "Impfung kontraindiziert",
                               "Impfung kontraindiziert",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE"),
    /**
     * EN: Impfung notwendig.<br>
     */
    IMPFUNG_NOTWENDIG_L1("122541000119104",
                         "2.16.840.1.113883.6.96",
                         "Impfung notwendig",
                         "Impfung notwendig",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Impfung verabreicht.<br>
     */
    IMPFUNG_VERABREICHT_L1("713404003",
                           "2.16.840.1.113883.6.96",
                           "Impfung verabreicht",
                           "Impfung verabreicht",
                           "TOTRANSLATE",
                           "TOTRANSLATE",
                           "TOTRANSLATE"),
    /**
     * EN: Keine Aufzeichnungen über Impfungen.<br>
     */
    KEINE_AUFZEICHNUNGEN_BER_IMPFUNGEN_L1("171288004",
                                          "2.16.840.1.113883.6.96",
                                          "Keine Aufzeichnungen über Impfungen",
                                          "Keine Aufzeichnungen über Impfungen",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE",
                                          "TOTRANSLATE"),
    /**
     * EN: Rot.<br>
     */
    ROT("_Rot",
        "1.2.40.0.34.5.183",
        "Rot",
        "Rot",
        "TOTRANSLATE",
        "TOTRANSLATE",
        "TOTRANSLATE"),
    /**
     * EN: Unzureichende Immunität.<br>
     */
    UNZUREICHENDE_IMMUNIT_T_L1("424272000",
                               "2.16.840.1.113883.6.96",
                               "Unzureichende Immunität",
                               "Unzureichende Immunität",
                               "TOTRANSLATE",
                               "TOTRANSLATE",
                               "TOTRANSLATE");

    /**
     * EN: Code for Ausnahme.<br>
     */
    public static final String AUSNAHME_CODE = "_Ausnahme";

    /**
     * EN: Code for Blau.<br>
     */
    public static final String BLAU_CODE = "_Blau";

    /**
     * EN: Code for Durchgemachte Infektionskrankheit.<br>
     */
    public static final String DURCHGEMACHTE_INFEKTIONSKRANKHEIT_L1_CODE = "161413004";

    /**
     * EN: Code for Erfordert Impfung.<br>
     */
    public static final String ERFORDERT_IMPFUNG_L1_CODE = "723620004";

    /**
     * EN: Code for Gelb.<br>
     */
    public static final String GELB_CODE = "_Gelb";

    /**
     * EN: Code for Grau.<br>
     */
    public static final String GRAU_CODE = "_Grau";

    /**
     * EN: Code for Grün.<br>
     */
    public static final String GR_N_CODE = "_Grün";

    /**
     * EN: Code for Immunität erworben.<br>
     */
    public static final String IMMUNIT_T_ERWORBEN_L1_CODE = "191441008";

    /**
     * EN: Code for Impfschutz auf dem neuesten Stand.<br>
     */
    public static final String IMPFSCHUTZ_AUF_DEM_NEUESTEN_STAND_L1_CODE = "171258008";

    /**
     * EN: Code for Impftermin anstehend.<br>
     */
    public static final String IMPFTERMIN_ANSTEHEND_L1_CODE = "789539003";

    /**
     * EN: Code for Impfung überfällig.<br>
     */
    public static final String IMPFUNG_BERF_LLIG_L1_CODE = "789540001";

    /**
     * EN: Code for Impfung fällig.<br>
     */
    public static final String IMPFUNG_F_LLIG_L1_CODE = "171279008";

    /**
     * EN: Code for Impfung kontraindiziert.<br>
     */
    public static final String IMPFUNG_KONTRAINDIZIERT_L1_CODE = "266758009";

    /**
     * EN: Code for Impfung notwendig.<br>
     */
    public static final String IMPFUNG_NOTWENDIG_L1_CODE = "122541000119104";

    /**
     * EN: Code for Impfung verabreicht.<br>
     */
    public static final String IMPFUNG_VERABREICHT_L1_CODE = "713404003";

    /**
     * EN: Code for Keine Aufzeichnungen über Impfungen.<br>
     */
    public static final String KEINE_AUFZEICHNUNGEN_BER_IMPFUNGEN_L1_CODE = "171288004";

    /**
     * EN: Code for Rot.<br>
     */
    public static final String ROT_CODE = "_Rot";

    /**
     * EN: Code for Unzureichende Immunität.<br>
     */
    public static final String UNZUREICHENDE_IMMUNIT_T_L1_CODE = "424272000";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "eimpf-specialcasevaccination";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "1.2.40.0.34.5.183";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EimpfSpecialcasevaccination getEnum(@Nullable final String code) {
        for (final EimpfSpecialcasevaccination x : values()) {
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
            Enum.valueOf(EimpfSpecialcasevaccination.class,
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
        for (final EimpfSpecialcasevaccination x : values()) {
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
    EimpfSpecialcasevaccination(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
