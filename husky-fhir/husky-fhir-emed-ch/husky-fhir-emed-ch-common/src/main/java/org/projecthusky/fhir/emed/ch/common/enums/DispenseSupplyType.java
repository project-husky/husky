/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.common.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of DispenseSupplyType values
 * <p>
 * EN: No designation found.<br>
 * DE: IHE DIS 6.3.4.5.3.4 Code.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.77.4.11.7<br>
 * Effective date: 2017-01-10 20:44<br>
 * Version: 2021<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-18")
public enum DispenseSupplyType implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: First Fill - Complete.<br>
     * DE: Erstbefüllung - Voll.<br>
     * FR: Premier remplissage - complet.<br>
     * IT: Prima consegna - completa.<br>
     */
    FIRST_FILL_COMPLETE("FFC",
                        "2.16.840.1.113883.5.4",
                        "First Fill - Complete",
                        "First Fill - Complete",
                        "Erstbefüllung - Voll",
                        "Premier remplissage - complet",
                        "Prima consegna - completa"),
    /**
     * EN: First Fill - Part Fill.<br>
     * DE: Erstbefüllung - Teilbefüllung.<br>
     * FR: Premier remplissage - partiel.<br>
     * IT: Prima consegna - parziale.<br>
     */
    FIRST_FILL_PART_FILL("FFP",
                         "2.16.840.1.113883.5.4",
                         "First Fill - Part Fill",
                         "First Fill - Part Fill",
                         "Erstbefüllung - Teilbefüllung",
                         "Premier remplissage - partiel",
                         "Prima consegna - parziale"),
    /**
     * EN: Refill - Complete.<br>
     * DE: Nachfüllung - Voll.<br>
     * FR: Prochain remplissage - complet.<br>
     * IT: Consegna successiva - completa.<br>
     */
    REFILL_COMPLETE("RFC",
                    "2.16.840.1.113883.5.4",
                    "Refill - Complete",
                    "Refill - Complete",
                    "Nachfüllung - Voll",
                    "Prochain remplissage - complet",
                    "Consegna successiva - completa"),
    /**
     * EN: Refill - Part Fill.<br>
     * DE: Nachfüllung - Teilbefüllung.<br>
     * FR: Prochain remplissage - partiel.<br>
     * IT: Consegna successiva - parziale.<br>
     */
    REFILL_PART_FILL("RFP",
                     "2.16.840.1.113883.5.4",
                     "Refill - Part Fill",
                     "Refill - Part Fill",
                     "Nachfüllung - Teilbefüllung",
                     "Prochain remplissage - partiel",
                     "Consegna successiva - parziale");

    /**
     * EN: Code for First Fill - Complete.<br>
     * DE: Code für Erstbefüllung - Voll.<br>
     * FR: Code de Premier remplissage - complet.<br>
     * IT: Code per Prima consegna - completa.<br>
     */
    public static final String FIRST_FILL_COMPLETE_CODE = "FFC";

    /**
     * EN: Code for First Fill - Part Fill.<br>
     * DE: Code für Erstbefüllung - Teilbefüllung.<br>
     * FR: Code de Premier remplissage - partiel.<br>
     * IT: Code per Prima consegna - parziale.<br>
     */
    public static final String FIRST_FILL_PART_FILL_CODE = "FFP";

    /**
     * EN: Code for Refill - Complete.<br>
     * DE: Code für Nachfüllung - Voll.<br>
     * FR: Code de Prochain remplissage - complet.<br>
     * IT: Code per Consegna successiva - completa.<br>
     */
    public static final String REFILL_COMPLETE_CODE = "RFC";

    /**
     * EN: Code for Refill - Part Fill.<br>
     * DE: Code für Nachfüllung - Teilbefüllung.<br>
     * FR: Code de Prochain remplissage - partiel.<br>
     * IT: Code per Consegna successiva - parziale.<br>
     */
    public static final String REFILL_PART_FILL_CODE = "RFP";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.77.4.11.7";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DispenseSupplyType";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.4";

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
    DispenseSupplyType(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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

    /**
     * Returns the code system, as used in FHIR.
     */
    @Override
    @NonNull
    public String getFhirSystem() {
        if (this.getCodeSystemId().startsWith("http")) {
            return this.getCodeSystemId();
        }
        return Oids.PREFIX_OID + this.getCodeSystemId();
    }

    /**
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    @NonNull
    public Coding getCoding() {
        return new Coding(this.getFhirSystem(),
                          this.getCodeValue(),
                          this.displayNames[0]);
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    @NonNull
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.displayNames[0]).addCoding(this.getCoding());
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getFhirSystem().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static DispenseSupplyType getEnum(@Nullable final String code) {
        for (final DispenseSupplyType x : values()) {
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
            Enum.valueOf(DispenseSupplyType.class,
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
        for (final DispenseSupplyType x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Enum with a given FHIR Coding.
     *
     * @param coding The FHIR Coding.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static DispenseSupplyType getEnum(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given FHIR Coding is in this value set.
     *
     * @param coding The FHIR Coding.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return true;
            }
        }
        return false;
    }
}
