package org.projecthusky.fhir.emed.ch.common.enums;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

import java.util.Objects;

/**
 * Enumeration for the <a href="https://fhir.ch/ig/ch-term/ValueSet-ech-10-linetype.html">eCH-010 Address Line Type</a>
 * value set.
 * <p>
 *     Version: CH TERM 3.1.0
 * </p>
 */
public enum AddressLineType implements ValueSetEnumInterface, FhirValueSetEnumInterface {
    ADDRESS_LINE_1("addressLine1",
            "http://fhir.ch/ig/ch-core/CodeSystem/ech-10",
            "addressLine1",
            "addressLine1",
            "Addresszeile 1 (optional)",
            "Ligne d'adresse 1 (facultatif)",
            "addressLine1"),
    ADDRESS_LINE_2("addressLine2",
            "http://fhir.ch/ig/ch-core/CodeSystem/ech-10",
            "addressLine2",
            "addressLine2",
            "Adresszeile 2 (optional)",
            "Ligne d'adresse 2 (facultatif)",
            "addressLine2"
            ),
    STREET("street",
            "http://fhir.ch/ig/ch-core/CodeSystem/ech-10",
            "street",
            "street",
            "Adressierung Strasse / Wohnung (optional)",
            "Adressage rue / appartement (facultatif)",
            "street"
            ),
    POST_OFFICE_BOX_TEXT("postOfficeBoxText",
            "http://fhir.ch/ig/ch-core/CodeSystem/ech-10",
            "postOfficeBoxText",
            "postOfficeBoxText",
            "Adressierung Postfach (optional)",
            "Adressage case postale (facultatif)",
            "postOfficeBoxText"
            );

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "http://fhir.ch/ig/ch-core/ValueSet/ech-10-linetype";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ECH10AddressLine";

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
    AddressLineType (final @NonNull String code, final @NonNull String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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

    @Override
    public @NonNull Coding getCoding(LanguageCode languageCode) {
        return new Coding(this.getFhirSystem(),
                this.getCodeValue(),
                this.getDisplayName(languageCode));
    }

    @Override
    public @NonNull CodeableConcept getCodeableConcept(LanguageCode languageCode) {
        return new CodeableConcept().setText(this.getDisplayName(languageCode)).addCoding(this.getCoding(languageCode));
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
    public static AddressLineType getEnum(@Nullable final String code) {
        for (final AddressLineType x : values()) {
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
            Enum.valueOf(AddressLineType.class,
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
        for (final AddressLineType x : values()) {
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
    public static AddressLineType getEnum(@Nullable final Coding coding) {
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
