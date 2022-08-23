/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of eImpf_SpecialCaseVaccination_VS values
 * <p>
 * EN: Special cases for vaccination entries (Immunization Entry, Immunization Recommendation Entry). Contains information protected by copyright of SNOMED International. Any use of SNOMED CT in Austria requires a valid affiliate license or sublicense. The corresponding license is free of charge, provided that the use only takes place in Austria and fulfills the conditions of the Affiliate License Agreement. Affiliate licenses can be requested directly from the respective NRC via the Member Licensing and Distribution Service (MLDS). https://mlds.ihtsdotools.org/#/landing/AT?lang=de.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.10.3<br>
 * Effective date: 2022-02-03 00:00<br>
 * Version: 202202(-beta)<br>
 * Status: DRAFT
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-18")
public enum EImpfSpecialCaseVaccinationVs implements ValueSetEnumInterface {

    /**
     * EN: Acquired immunity, function.<br>
     */
    ACQUIRED_IMMUNITY_FUNCTION_L1("191441008",
                                  "2.16.840.1.113883.6.96",
                                  "Acquired immunity, function",
                                  "Acquired immunity, function",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
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
     * EN: Date immunization due.<br>
     */
    DATE_IMMUNIZATION_DUE_L1("789539003",
                             "2.16.840.1.113883.6.96",
                             "Date immunization due",
                             "Date immunization due",
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
     * EN: Gelb-leer.<br>
     */
    GELB_LEER("_Gelb-leer",
              "1.2.40.0.34.5.183",
              "Gelb-leer",
              "Gelb-leer",
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
     * EN: History of infectious disease.<br>
     */
    HISTORY_OF_INFECTIOUS_DISEASE_L1("161413004",
                                     "2.16.840.1.113883.6.96",
                                     "History of infectious disease",
                                     "History of infectious disease",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Immunization contraindicated.<br>
     */
    IMMUNIZATION_CONTRAINDICATED_L1("266758009",
                                    "2.16.840.1.113883.6.96",
                                    "Immunization contraindicated",
                                    "Immunization contraindicated",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: Immunization due.<br>
     */
    IMMUNIZATION_DUE_L1("171279008",
                        "2.16.840.1.113883.6.96",
                        "Immunization due",
                        "Immunization due",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Immunization overdue.<br>
     */
    IMMUNIZATION_OVERDUE_L1("789540001",
                            "2.16.840.1.113883.6.96",
                            "Immunization overdue",
                            "Immunization overdue",
                            "TOTRANSLATE",
                            "TOTRANSLATE",
                            "TOTRANSLATE"),
    /**
     * EN: Inadequate immune status.<br>
     */
    INADEQUATE_IMMUNE_STATUS_L1("424272000",
                                "2.16.840.1.113883.6.96",
                                "Inadequate immune status",
                                "Inadequate immune status",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: No immunization history record.<br>
     */
    NO_IMMUNIZATION_HISTORY_RECORD_L1("171288004",
                                      "2.16.840.1.113883.6.96",
                                      "No immunization history record",
                                      "No immunization history record",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: Requires vaccination.<br>
     */
    REQUIRES_VACCINATION_L1("723620004",
                            "2.16.840.1.113883.6.96",
                            "Requires vaccination",
                            "Requires vaccination",
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
     * EN: Up-to-date with immunizations.<br>
     */
    UP_TO_DATE_WITH_IMMUNIZATIONS_L1("171258008",
                                     "2.16.840.1.113883.6.96",
                                     "Up-to-date with immunizations",
                                     "Up-to-date with immunizations",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Vaccination given.<br>
     */
    VACCINATION_GIVEN_L1("713404003",
                         "2.16.840.1.113883.6.96",
                         "Vaccination given",
                         "Vaccination given",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Vaccination needed.<br>
     */
    VACCINATION_NEEDED_L1("122541000119104",
                          "2.16.840.1.113883.6.96",
                          "Vaccination needed",
                          "Vaccination needed",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE");

    /**
     * EN: Code for Acquired immunity, function.<br>
     */
    public static final String ACQUIRED_IMMUNITY_FUNCTION_L1_CODE = "191441008";

    /**
     * EN: Code for Ausnahme.<br>
     */
    public static final String AUSNAHME_CODE = "_Ausnahme";

    /**
     * EN: Code for Blau.<br>
     */
    public static final String BLAU_CODE = "_Blau";

    /**
     * EN: Code for Date immunization due.<br>
     */
    public static final String DATE_IMMUNIZATION_DUE_L1_CODE = "789539003";

    /**
     * EN: Code for Gelb.<br>
     */
    public static final String GELB_CODE = "_Gelb";

    /**
     * EN: Code for Gelb-leer.<br>
     */
    public static final String GELB_LEER_CODE = "_Gelb-leer";

    /**
     * EN: Code for Grün.<br>
     */
    public static final String GR_N_CODE = "_Grün";

    /**
     * EN: Code for History of infectious disease.<br>
     */
    public static final String HISTORY_OF_INFECTIOUS_DISEASE_L1_CODE = "161413004";

    /**
     * EN: Code for Immunization contraindicated.<br>
     */
    public static final String IMMUNIZATION_CONTRAINDICATED_L1_CODE = "266758009";

    /**
     * EN: Code for Immunization due.<br>
     */
    public static final String IMMUNIZATION_DUE_L1_CODE = "171279008";

    /**
     * EN: Code for Immunization overdue.<br>
     */
    public static final String IMMUNIZATION_OVERDUE_L1_CODE = "789540001";

    /**
     * EN: Code for Inadequate immune status.<br>
     */
    public static final String INADEQUATE_IMMUNE_STATUS_L1_CODE = "424272000";

    /**
     * EN: Code for No immunization history record.<br>
     */
    public static final String NO_IMMUNIZATION_HISTORY_RECORD_L1_CODE = "171288004";

    /**
     * EN: Code for Requires vaccination.<br>
     */
    public static final String REQUIRES_VACCINATION_L1_CODE = "723620004";

    /**
     * EN: Code for Rot.<br>
     */
    public static final String ROT_CODE = "_Rot";

    /**
     * EN: Code for Up-to-date with immunizations.<br>
     */
    public static final String UP_TO_DATE_WITH_IMMUNIZATIONS_L1_CODE = "171258008";

    /**
     * EN: Code for Vaccination given.<br>
     */
    public static final String VACCINATION_GIVEN_L1_CODE = "713404003";

    /**
     * EN: Code for Vaccination needed.<br>
     */
    public static final String VACCINATION_NEEDED_L1_CODE = "122541000119104";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.6.0.10.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "eImpf_SpecialCaseVaccination_VS";

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
    public static EImpfSpecialCaseVaccinationVs getEnum(@Nullable final String code) {
        for (final EImpfSpecialCaseVaccinationVs x : values()) {
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
            Enum.valueOf(EImpfSpecialCaseVaccinationVs.class,
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
        for (final EImpfSpecialCaseVaccinationVs x : values()) {
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
    EImpfSpecialCaseVaccinationVs(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
