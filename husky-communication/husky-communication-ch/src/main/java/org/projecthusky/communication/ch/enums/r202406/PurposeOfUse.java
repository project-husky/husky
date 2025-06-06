/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.r202406;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of EprPurposeOfUse values
 * <p>
 * EN: Purpose Of Use as per Annex 5 EPRO-FDHA, Extension 1.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.15.2<br>
 * Effective date: 2023-04-12 15:23<br>
 * Version: 202306.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2025-03-03")
public enum PurposeOfUse implements ValueSetEnumInterface {

    /**
     * EN: Automatic Upload.<br>
     * DE: Automatisches Hochladen.<br>
     * FR: Téléchargement automatique.<br>
     * IT: Caricamento automatico.<br>
     */
    AUTOMATIC_UPLOAD("AUTO",
                     "2.16.756.5.30.1.127.3.10.5",
                     "Automatic Upload",
                     "Automatic Upload",
                     "Automatisches Hochladen",
                     "Téléchargement automatique",
                     "Caricamento automatico"),
    /**
     * EN: Automatic upload of radiological contents.<br>
     * DE: Automatisches Hochladen von radiologischen Inhalten.<br>
     * FR: Téléchargement automatique de contenus radiologiques.<br>
     * IT: Caricamento automatico del contenuto radiologico.<br>
     */
    AUTOMATIC_UPLOAD_OF_RADIOLOGICAL_CONTENTS("DICOM_AUTO",
                                              "2.16.756.5.30.1.127.3.10.5",
                                              "Automatic upload of radiological contents",
                                              "Automatic upload of radiological contents",
                                              "Automatisches Hochladen von radiologischen Inhalten",
                                              "Téléchargement automatique de contenus radiologiques",
                                              "Caricamento automatico del contenuto radiologico"),
    /**
     * EN: Emergency Access.<br>
     * DE: Notfallzugriff.<br>
     * FR: Accès d’urgence.<br>
     * IT: Accesso di emergenza.<br>
     */
    EMERGENCY_ACCESS("EMER",
                     "2.16.756.5.30.1.127.3.10.5",
                     "Emergency Access",
                     "Emergency Access",
                     "Notfallzugriff",
                     "Accès d’urgence",
                     "Accesso di emergenza"),
    /**
     * EN: Normal Access.<br>
     * DE: Normaler Zugriff.<br>
     * FR: Accès normal.<br>
     * IT: Accesso normale.<br>
     */
    NORMAL_ACCESS("NORM",
                  "2.16.756.5.30.1.127.3.10.5",
                  "Normal Access",
                  "Normal Access",
                  "Normaler Zugriff",
                  "Accès normal",
                  "Accesso normale");

    /**
     * EN: Code for Automatic Upload.<br>
     * DE: Code für Automatisches Hochladen.<br>
     * FR: Code de Téléchargement automatique.<br>
     * IT: Code per Caricamento automatico.<br>
     */
    public static final String AUTOMATIC_UPLOAD_CODE = "AUTO";

    /**
     * EN: Code for Automatic upload of radiological contents.<br>
     * DE: Code für Automatisches Hochladen von radiologischen Inhalten.<br>
     * FR: Code de Téléchargement automatique de contenus radiologiques.<br>
     * IT: Code per Caricamento automatico del contenuto radiologico.<br>
     */
    public static final String AUTOMATIC_UPLOAD_OF_RADIOLOGICAL_CONTENTS_CODE = "DICOM_AUTO";

    /**
     * EN: Code for Emergency Access.<br>
     * DE: Code für Notfallzugriff.<br>
     * FR: Code de Accès d’urgence.<br>
     * IT: Code per Accesso di emergenza.<br>
     */
    public static final String EMERGENCY_ACCESS_CODE = "EMER";

    /**
     * EN: Code for Normal Access.<br>
     * DE: Code für Normaler Zugriff.<br>
     * FR: Code de Accès normal.<br>
     * IT: Code per Accesso normale.<br>
     */
    public static final String NORMAL_ACCESS_CODE = "NORM";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.15.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "EprPurposeOfUse";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.756.5.30.1.127.3.10.5";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static PurposeOfUse getEnum(@Nullable final String code) {
        for (final PurposeOfUse x : values()) {
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
            Enum.valueOf(PurposeOfUse.class,
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
        for (final PurposeOfUse x : values()) {
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
    PurposeOfUse(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
