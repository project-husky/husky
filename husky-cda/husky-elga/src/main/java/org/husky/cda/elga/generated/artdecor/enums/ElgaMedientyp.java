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
 * Enumeration of ELGA_Medientyp values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.2.40.0.34.10.42<br>
 * Effective date: 2015-10-01 00:00<br>
 * Version: 3.3<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-02-18")
public enum ElgaMedientyp implements ValueSetEnumInterface {

    /**
     * EN: Mime Type application/dicom.<br>
     */
    MIME_TYPE_APPLICATION_DICOM("application/dicom",
                                "1.2.840.10003.5.109",
                                "Mime Type application/dicom",
                                "Mime Type application/dicom",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: Mime Type application/pdf.<br>
     */
    MIME_TYPE_APPLICATION_PDF("application/pdf",
                              "1.2.840.10003.5.109",
                              "Mime Type application/pdf",
                              "Mime Type application/pdf",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Mime Type audio/mpeg.<br>
     */
    MIME_TYPE_AUDIO_MPEG("audio/mpeg",
                         "1.2.840.10003.5.109",
                         "Mime Type audio/mpeg",
                         "Mime Type audio/mpeg",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Mime Type image/gif.<br>
     */
    MIME_TYPE_IMAGE_GIF("image/gif",
                        "1.2.840.10003.5.109",
                        "Mime Type image/gif",
                        "Mime Type image/gif",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Mime Type image/jpeg.<br>
     */
    MIME_TYPE_IMAGE_JPEG("image/jpeg",
                         "1.2.840.10003.5.109",
                         "Mime Type image/jpeg",
                         "Mime Type image/jpeg",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE"),
    /**
     * EN: Mime Type image/png.<br>
     */
    MIME_TYPE_IMAGE_PNG("image/png",
                        "1.2.840.10003.5.109",
                        "Mime Type image/png",
                        "Mime Type image/png",
                        "TOTRANSLATE",
                        "TOTRANSLATE",
                        "TOTRANSLATE"),
    /**
     * EN: Mime Type text/xml.<br>
     */
    MIME_TYPE_TEXT_XML("text/xml",
                       "1.2.840.10003.5.109",
                       "Mime Type text/xml",
                       "Mime Type text/xml",
                       "TOTRANSLATE",
                       "TOTRANSLATE",
                       "TOTRANSLATE"),
    /**
     * EN: Mime Type video/mpeg.<br>
     */
    MIME_TYPE_VIDEO_MPEG("video/mpeg",
                         "1.2.840.10003.5.109",
                         "Mime Type video/mpeg",
                         "Mime Type video/mpeg",
                         "TOTRANSLATE",
                         "TOTRANSLATE",
                         "TOTRANSLATE");

    /**
     * EN: Code for Mime Type application/dicom.<br>
     */
    public static final String MIME_TYPE_APPLICATION_DICOM_CODE = "application/dicom";

    /**
     * EN: Code for Mime Type application/pdf.<br>
     */
    public static final String MIME_TYPE_APPLICATION_PDF_CODE = "application/pdf";

    /**
     * EN: Code for Mime Type audio/mpeg.<br>
     */
    public static final String MIME_TYPE_AUDIO_MPEG_CODE = "audio/mpeg";

    /**
     * EN: Code for Mime Type image/gif.<br>
     */
    public static final String MIME_TYPE_IMAGE_GIF_CODE = "image/gif";

    /**
     * EN: Code for Mime Type image/jpeg.<br>
     */
    public static final String MIME_TYPE_IMAGE_JPEG_CODE = "image/jpeg";

    /**
     * EN: Code for Mime Type image/png.<br>
     */
    public static final String MIME_TYPE_IMAGE_PNG_CODE = "image/png";

    /**
     * EN: Code for Mime Type text/xml.<br>
     */
    public static final String MIME_TYPE_TEXT_XML_CODE = "text/xml";

    /**
     * EN: Code for Mime Type video/mpeg.<br>
     */
    public static final String MIME_TYPE_VIDEO_MPEG_CODE = "video/mpeg";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.2.40.0.34.10.42";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ELGA_Medientyp";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "1.2.840.10003.5.109";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ElgaMedientyp getEnum(@Nullable final String code) {
        for (final ElgaMedientyp x : values()) {
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
            Enum.valueOf(ElgaMedientyp.class,
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
        for (final ElgaMedientyp x : values()) {
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
    ElgaMedientyp(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
