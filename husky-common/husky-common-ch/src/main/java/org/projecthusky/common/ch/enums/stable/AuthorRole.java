/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.common.ch.enums.stable;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.author.authorRole values
 * <p>
 * EN: Role of the author. This code defines the role of the author of the document. This is a sub-attribute of epd_xds_author.<br>
 * DE: Rolle des Autors. Dieser Code definiert die Rolle des Authors vom Dokument. Dies ist ein Sub-Attribut von epd_xds_author.<br>
 * FR: Rôle de l'auteur. Ce code définit le rôle de l'auteur du document. Il s'agit d'un sous-attribut de epd_xds_author.<br>
 * IT: Ruolo dell'autore. Questo codice definisce il ruolo dell'autore del documento. È un sottoattributo di epd_xds_author.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.1.3<br>
 * Effective date: 2022-06-24 10:44<br>
 * Version: 202306.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-02")
public enum AuthorRole implements ValueSetEnumInterface {

    /**
     * EN: Assistant.<br>
     * DE: Hilfsperson.<br>
     * FR: Auxiliaire.<br>
     * IT: Persona ausiliara.<br>
     */
    ASSISTANT("ASS",
              "2.16.756.5.30.1.127.3.10.6",
              "Assistant",
              "Assistant",
              "Hilfsperson",
              "Auxiliaire",
              "Persona ausiliara"),
    /**
     * EN: Healthcare professional.<br>
     * DE: Gesundheitsfachperson.<br>
     * FR: Professionnel de la santé.<br>
     * IT: Professionista della salute.<br>
     */
    HEALTHCARE_PROFESSIONAL("HCP",
                            "2.16.756.5.30.1.127.3.10.6",
                            "Healthcare professional",
                            "Healthcare professional",
                            "Gesundheitsfachperson",
                            "Professionnel de la santé",
                            "Professionista della salute"),
    /**
     * EN: Patient.<br>
     * DE: Patient.<br>
     * FR: Patient.<br>
     * IT: Paziente.<br>
     */
    PATIENT("PAT",
            "2.16.756.5.30.1.127.3.10.6",
            "Patient",
            "Patient",
            "Patient",
            "Patient",
            "Paziente"),
    /**
     * EN: Representative.<br>
     * DE: Stellvertretung.<br>
     * FR: Représentant.<br>
     * IT: Rappresentante.<br>
     */
    REPRESENTATIVE("REP",
                   "2.16.756.5.30.1.127.3.10.6",
                   "Representative",
                   "Representative",
                   "Stellvertretung",
                   "Représentant",
                   "Rappresentante"),
    /**
     * EN: Technical user.<br>
     * DE: Technischer Benutzer.<br>
     * FR: Utilisateur technique.<br>
     * IT: Utente tecnico.<br>
     */
    TECHNICAL_USER("TCU",
                   "2.16.756.5.30.1.127.3.10.6",
                   "Technical user",
                   "Technical user",
                   "Technischer Benutzer",
                   "Utilisateur technique",
                   "Utente tecnico");

    /**
     * EN: Code for Assistant.<br>
     * DE: Code für Hilfsperson.<br>
     * FR: Code de Auxiliaire.<br>
     * IT: Code per Persona ausiliara.<br>
     */
    public static final String ASSISTANT_CODE = "ASS";

    /**
     * EN: Code for Healthcare professional.<br>
     * DE: Code für Gesundheitsfachperson.<br>
     * FR: Code de Professionnel de la santé.<br>
     * IT: Code per Professionista della salute.<br>
     */
    public static final String HEALTHCARE_PROFESSIONAL_CODE = "HCP";

    /**
     * EN: Code for Patient.<br>
     * DE: Code für Patient.<br>
     * FR: Code de Patient.<br>
     * IT: Code per Paziente.<br>
     */
    public static final String PATIENT_CODE = "PAT";

    /**
     * EN: Code for Representative.<br>
     * DE: Code für Stellvertretung.<br>
     * FR: Code de Représentant.<br>
     * IT: Code per Rappresentante.<br>
     */
    public static final String REPRESENTATIVE_CODE = "REP";

    /**
     * EN: Code for Technical user.<br>
     * DE: Code für Technischer Benutzer.<br>
     * FR: Code de Utilisateur technique.<br>
     * IT: Code per Utente tecnico.<br>
     */
    public static final String TECHNICAL_USER_CODE = "TCU";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.1.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.author.authorRole";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.756.5.30.1.127.3.10.6";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static AuthorRole getEnum(@Nullable final String code) {
        for (final AuthorRole x : values()) {
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
            Enum.valueOf(AuthorRole.class,
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
        for (final AuthorRole x : values()) {
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
    AuthorRole(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
