package org.projecthusky.fhir.emed.ch.epr.narrative.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
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
import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public enum ProductCodeType implements ValueSetEnumInterface {

    GTIN("gtin", "GTIN code", "TOTRANSLATE", "Code GTIN", "TOTRANSLATE"),
    ATC("atc", "ATC code", "TOTRANSLATE", "Code ATC", "TOTRANSLATE");

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

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
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    ProductCodeType(@NonNull final String code,
                    @NonNull final String displayNameEn,
                    @NonNull final String displayNameDe,
                    @NonNull final String displayNameFr,
                    @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.displayNames = new String[4];
        this.displayNames[0] = Objects.requireNonNull(displayNameEn);
        this.displayNames[1] = Objects.requireNonNull(displayNameDe);
        this.displayNames[2] = Objects.requireNonNull(displayNameFr);
        this.displayNames[3] = Objects.requireNonNull(displayNameIt);
    }


    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return "";
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
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
            case GERMAN ->
                    this.displayNames[1];
            case FRENCH ->
                    this.displayNames[2];
            case ITALIAN ->
                    this.displayNames[3];
            default ->
                    this.displayNames[0];
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
        return "";
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return "";
    }
}
