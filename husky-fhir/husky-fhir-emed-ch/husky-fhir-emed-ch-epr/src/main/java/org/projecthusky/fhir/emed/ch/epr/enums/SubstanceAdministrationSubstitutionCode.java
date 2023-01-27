/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.emed.ch.epr.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public enum SubstanceAdministrationSubstitutionCode implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: equivalent.<br> DE: Äquivalent.<br> FR: équivalent.<br> IT: equivalente.<br>
     */
    EQUIVALENT("E",
               "http://terminology.hl7.org/CodeSystem/v3-substanceAdminSubstitution",
               "equivalent",
               "equivalent",
               "Äquivalent",
               "équivalent",
               "equivalente"),

    /**
     * EN: none.<br> DE: nicht autorisiert.<br> FR: non autorisé.<br> IT: non autorizzato.<br>
     */
    NONE("N",
         "http://terminology.hl7.org/CodeSystem/v3-substanceAdminSubstitution",
         "none",
         "none",
         "nicht autorisiert",
         "non autorisé",
         "non autorizzato");

    /**
     * EN: Code for equivalent.<br> DE: Code für Äquivalent.<br> FR: Code de équivalent.<br> IT: Code per
     * equivalente.<br>
     */
    public static final String EQUIVALENT_CODE = "E";

    /**
     * EN: Code for none.<br> DE: Code für nicht autorisiert.<br> FR: Code de non autorisé.<br> IT: Code per non
     * autorizzato.<br>
     */
    public static final String NONE_CODE = "N";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "substance-admin-substitution-code";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "SubstanceAdministrationSubstitutionCode";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "http://terminology.hl7.org/CodeSystem/v3-substanceAdminSubstitution";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static SubstanceAdministrationSubstitutionCode getEnum(@Nullable final String code) {
        for (final SubstanceAdministrationSubstitutionCode x : values()) {
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
            Enum.valueOf(SubstanceAdministrationSubstitutionCode.class, enumName);
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
        for (final SubstanceAdministrationSubstitutionCode x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static SubstanceAdministrationSubstitutionCode fromCoding(final Coding coding) {
        for (final SubstanceAdministrationSubstitutionCode x : values()) {
            if (x.isEqualTo(coding)) {
                return x;
            }
        }
        return null;
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
    SubstanceAdministrationSubstitutionCode(@NonNull final String code,
                                            @NonNull final String codeSystem,
                                            @NonNull final String displayName,
                                            @NonNull final String displayNameEn,
                                            @NonNull final String displayNameDe,
                                            @NonNull final String displayNameFr,
                                            @NonNull final String displayNameIt) {
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
        return switch (languageCode) {
            case ENGLISH -> this.displayNames[1];
            case GERMAN -> this.displayNames[2];
            case FRENCH -> this.displayNames[3];
            case ITALIAN -> this.displayNames[4];
            default -> "TOTRANSLATE";
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

    @Override
    public Coding getCoding() {
        return new Coding(this.codeSystem, this.code, this.getDisplayName());
    }

    @Override
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept(this.getCoding());
    }

    @Override
    public boolean isEqualTo(final Coding coding) {
        return Objects.equals(this.code, coding.getCode()) && Objects.equals(this.codeSystem, coding.getSystem());
    }
}
