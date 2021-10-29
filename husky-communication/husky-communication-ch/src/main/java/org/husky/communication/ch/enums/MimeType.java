/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.mimeType values
 * <p>
 * EN: MIME type of the document as per Annex; EPRO-FDHA.<br>
 * DE: MIME Typ des Dokumentes gemäss Anhang 3 EPDG.<br>
 * FR: MIME Type du document selon l'annexe 3 ODEP-DFI.<br>
 * IT: Tipo MIME del documento secondo l'allegato 3 OCIP-DFI.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.16<br>
 * Effective date: 2021-04-01 17:07<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum MimeType implements ValueSetEnumInterface {

    /**
     * EN: CDA Level 1 Multipart<br>
     * DE: CDA Level 1 Multipart<br>
     * FR: CDA Level 1 Multipart<br>
     * IT: CDA Level 1 Multipart<br>
     */
    CDA_LEVEL_1_MULTIPART("multipart/x-hl7-cda-level1",
                          "2.16.840.1.113883.5.79",
                          "CDA Level 1 Multipart",
                          "CDA Level 1 Multipart",
                          "CDA Level 1 Multipart",
                          "CDA Level 1 Multipart",
                          "CDA Level 1 Multipart"),
    /**
     * EN: CSV Comma-separated Values<br>
     * DE: CSV Comma-separated Values<br>
     * FR: CSV Comma-separated Values<br>
     * IT: CSV Comma-separated Values<br>
     */
    CSV_COMMA_SEPARATED_VALUES("text/csv",
                               "2.16.840.1.113883.5.79",
                               "CSV Comma-separated Values",
                               "CSV Comma-separated Values",
                               "CSV Comma-separated Values",
                               "CSV Comma-separated Values",
                               "CSV Comma-separated Values"),
    /**
     * EN: DICOM<br>
     * DE: DICOM<br>
     * FR: DICOM<br>
     * IT: DICOM<br>
     */
    DICOM("application/dicom",
          "2.16.840.1.113883.5.79",
          "DICOM",
          "DICOM",
          "DICOM",
          "DICOM",
          "DICOM"),
    /**
     * EN: Extensible 3D Graphics (VRML)<br>
     * DE: Extensible 3D Graphics (VRML)<br>
     * FR: Extensible 3D Graphics (VRML)<br>
     * IT: Extensible 3D Graphics (VRML)<br>
     */
    EXTENSIBLE_3D_GRAPHICS_VRML("model/x3d-vrml",
                                "2.16.840.1.113883.5.79",
                                "Extensible 3D Graphics (VRML)",
                                "Extensible 3D Graphics (VRML)",
                                "Extensible 3D Graphics (VRML)",
                                "Extensible 3D Graphics (VRML)",
                                "Extensible 3D Graphics (VRML)"),
    /**
     * EN: Extensible 3D Graphics (XML)<br>
     * DE: Extensible 3D Graphics (XML)<br>
     * FR: Extensible 3D Graphics (XML)<br>
     * IT: Extensible 3D Graphics (XML)<br>
     */
    EXTENSIBLE_3D_GRAPHICS_XML("model/x3d+xml",
                               "2.16.840.1.113883.5.79",
                               "Extensible 3D Graphics (XML)",
                               "Extensible 3D Graphics (XML)",
                               "Extensible 3D Graphics (XML)",
                               "Extensible 3D Graphics (XML)",
                               "Extensible 3D Graphics (XML)"),
    /**
     * EN: FHIR (JSON)<br>
     * DE: FHIR (JSON)<br>
     * FR: FHIR (JSON)<br>
     * IT: FHIR (JSON)<br>
     */
    FHIR_JSON("application/fhir+json",
              "2.16.840.1.113883.5.79",
              "FHIR (JSON)",
              "FHIR (JSON)",
              "FHIR (JSON)",
              "FHIR (JSON)",
              "FHIR (JSON)"),
    /**
     * EN: FHIR (XML)<br>
     * DE: FHIR (XML)<br>
     * FR: FHIR (XML)<br>
     * IT: FHIR (XML)<br>
     */
    FHIR_XML("application/fhir+xml",
             "2.16.840.1.113883.5.79",
             "FHIR (XML)",
             "FHIR (XML)",
             "FHIR (XML)",
             "FHIR (XML)",
             "FHIR (XML)"),
    /**
     * EN: GIF Graphics Interchange Format<br>
     * DE: GIF Graphics Interchange Format<br>
     * FR: GIF Graphics Interchange Format<br>
     * IT: GIF Graphics Interchange Format<br>
     */
    GIF_GRAPHICS_INTERCHANGE_FORMAT("image/gif",
                                    "2.16.840.1.113883.5.79",
                                    "GIF Graphics Interchange Format",
                                    "GIF Graphics Interchange Format",
                                    "GIF Graphics Interchange Format",
                                    "GIF Graphics Interchange Format",
                                    "GIF Graphics Interchange Format"),
    /**
     * EN: JPEG 2000 Compound Image File<br>
     * DE: JPEG 2000 Compound Image File<br>
     * FR: JPEG 2000 Compound Image File<br>
     * IT: JPEG 2000 Compound Image File<br>
     */
    JPEG_2000_COMPOUND_IMAGE_FILE("image/jpm",
                                  "2.16.840.1.113883.5.79",
                                  "JPEG 2000 Compound Image File",
                                  "JPEG 2000 Compound Image File",
                                  "JPEG 2000 Compound Image File",
                                  "JPEG 2000 Compound Image File",
                                  "JPEG 2000 Compound Image File"),
    /**
     * EN: JPEG 2000 Core Image File<br>
     * DE: JPEG 2000 Core Image File<br>
     * FR: JPEG 2000 Core Image File<br>
     * IT: JPEG 2000 Core Image File<br>
     */
    JPEG_2000_CORE_IMAGE_FILE("image/jp2",
                              "2.16.840.1.113883.5.79",
                              "JPEG 2000 Core Image File",
                              "JPEG 2000 Core Image File",
                              "JPEG 2000 Core Image File",
                              "JPEG 2000 Core Image File",
                              "JPEG 2000 Core Image File"),
    /**
     * EN: JPEG 2000 Image File<br>
     * DE: JPEG 2000 Image File<br>
     * FR: JPEG 2000 Image File<br>
     * IT: JPEG 2000 Image File<br>
     */
    JPEG_2000_IMAGE_FILE("image/jpx",
                         "2.16.840.1.113883.5.79",
                         "JPEG 2000 Image File",
                         "JPEG 2000 Image File",
                         "JPEG 2000 Image File",
                         "JPEG 2000 Image File",
                         "JPEG 2000 Image File"),
    /**
     * EN: JPEG Image<br>
     * DE: JPEG Image<br>
     * FR: JPEG Image<br>
     * IT: JPEG Image<br>
     */
    JPEG_IMAGE("image/jpeg",
               "2.16.840.1.113883.5.79",
               "JPEG Image",
               "JPEG Image",
               "JPEG Image",
               "JPEG Image",
               "JPEG Image"),
    /**
     * EN: Motion JPEG 2000<br>
     * DE: Motion JPEG 2000<br>
     * FR: Motion JPEG 2000<br>
     * IT: Motion JPEG 2000<br>
     */
    MOTION_JPEG_2000("video/mj2",
                     "2.16.840.1.113883.5.79",
                     "Motion JPEG 2000",
                     "Motion JPEG 2000",
                     "Motion JPEG 2000",
                     "Motion JPEG 2000",
                     "Motion JPEG 2000"),
    /**
     * EN: MP4 Audio<br>
     * DE: MP4 Audio<br>
     * FR: MP4 Audio<br>
     * IT: MP4 Audio<br>
     */
    MP4_AUDIO("audio/mp4",
              "2.16.840.1.113883.5.79",
              "MP4 Audio",
              "MP4 Audio",
              "MP4 Audio",
              "MP4 Audio",
              "MP4 Audio"),
    /**
     * EN: MPEG-4 Part 14<br>
     * DE: MPEG-4 Part 14<br>
     * FR: MPEG-4 Part 14<br>
     * IT: MPEG-4 Part 14<br>
     */
    MPEG_4_PART_14("video/mp4",
                   "2.16.840.1.113883.5.79",
                   "MPEG-4 Part 14",
                   "MPEG-4 Part 14",
                   "MPEG-4 Part 14",
                   "MPEG-4 Part 14",
                   "MPEG-4 Part 14"),
    /**
     * EN: MPEG audio layer 3<br>
     * DE: MPEG audio layer 3<br>
     * FR: MPEG audio layer 3<br>
     * IT: MPEG audio layer 3<br>
     */
    MPEG_AUDIO_LAYER_3("audio/mpeg",
                       "2.16.840.1.113883.5.79",
                       "MPEG audio layer 3",
                       "MPEG audio layer 3",
                       "MPEG audio layer 3",
                       "MPEG audio layer 3",
                       "MPEG audio layer 3"),
    /**
     * EN: MPEG Video<br>
     * DE: MPEG Video<br>
     * FR: MPEG Video<br>
     * IT: MPEG Video<br>
     */
    MPEG_VIDEO("video/mpeg",
               "2.16.840.1.113883.5.79",
               "MPEG Video",
               "MPEG Video",
               "MPEG Video",
               "MPEG Video",
               "MPEG Video"),
    /**
     * EN: Multilingual Multipart<br>
     * DE: Multilingual Multipart<br>
     * FR: Multilingual Multipart<br>
     * IT: Multilingual Multipart<br>
     */
    MULTILINGUAL_MULTIPART("multipart/multilingual",
                           "2.16.840.1.113883.5.79",
                           "Multilingual Multipart",
                           "Multilingual Multipart",
                           "Multilingual Multipart",
                           "Multilingual Multipart",
                           "Multilingual Multipart"),
    /**
     * EN: PDF<br>
     * DE: PDF<br>
     * FR: PDF<br>
     * IT: PDF<br>
     */
    PDF("application/pdf",
        "2.16.840.1.113883.5.79",
        "PDF",
        "PDF",
        "PDF",
        "PDF",
        "PDF"),
    /**
     * EN: Plain Text<br>
     * DE: Plain Text<br>
     * FR: Plain Text<br>
     * IT: Plain Text<br>
     */
    PLAIN_TEXT("text/plain",
               "2.16.840.1.113883.5.79",
               "Plain Text",
               "Plain Text",
               "Plain Text",
               "Plain Text",
               "Plain Text"),
    /**
     * EN: PNG Portable Network Graphics<br>
     * DE: PNG Portable Network Graphics<br>
     * FR: PNG Portable Network Graphics<br>
     * IT: PNG Portable Network Graphics<br>
     */
    PNG_PORTABLE_NETWORK_GRAPHICS("image/png",
                                  "2.16.840.1.113883.5.79",
                                  "PNG Portable Network Graphics",
                                  "PNG Portable Network Graphics",
                                  "PNG Portable Network Graphics",
                                  "PNG Portable Network Graphics",
                                  "PNG Portable Network Graphics"),
    /**
     * EN: Signed Multipart<br>
     * DE: Signed Multipart<br>
     * FR: Signed Multipart<br>
     * IT: Signed Multipart<br>
     */
    SIGNED_MULTIPART("multipart/signed",
                     "2.16.840.1.113883.5.79",
                     "Signed Multipart",
                     "Signed Multipart",
                     "Signed Multipart",
                     "Signed Multipart",
                     "Signed Multipart"),
    /**
     * EN: TIFF Image<br>
     * DE: TIFF Image<br>
     * FR: TIFF Image<br>
     * IT: TIFF Image<br>
     */
    TIFF_IMAGE("image/tiff",
               "2.16.840.1.113883.5.79",
               "TIFF Image",
               "TIFF Image",
               "TIFF Image",
               "TIFF Image",
               "TIFF Image"),
    /**
     * EN: Virtual Reality Modeling Language<br>
     * DE: Virtual Reality Modeling Language<br>
     * FR: Virtual Reality Modeling Language<br>
     * IT: Virtual Reality Modeling Language<br>
     */
    VIRTUAL_REALITY_MODELING_LANGUAGE("model/vrml",
                                      "2.16.840.1.113883.5.79",
                                      "Virtual Reality Modeling Language",
                                      "Virtual Reality Modeling Language",
                                      "Virtual Reality Modeling Language",
                                      "Virtual Reality Modeling Language",
                                      "Virtual Reality Modeling Language"),
    /**
     * EN: XML-Text<br>
     * DE: XML-Text<br>
     * FR: XML-Text<br>
     * IT: XML-Text<br>
     */
    XML_TEXT("text/xml",
             "2.16.840.1.113883.5.79",
             "XML-Text",
             "XML-Text",
             "XML-Text",
             "XML-Text",
             "XML-Text");

    /**
     * EN: Code for CDA Level 1 Multipart<br>
     * DE: Code für CDA Level 1 Multipart<br>
     * FR: Code de CDA Level 1 Multipart<br>
     * IT: Code per CDA Level 1 Multipart<br>
     */
    public static final String CDA_LEVEL_1_MULTIPART_CODE = "multipart/x-hl7-cda-level1";

    /**
     * EN: Code for CSV Comma-separated Values<br>
     * DE: Code für CSV Comma-separated Values<br>
     * FR: Code de CSV Comma-separated Values<br>
     * IT: Code per CSV Comma-separated Values<br>
     */
    public static final String CSV_COMMA_SEPARATED_VALUES_CODE = "text/csv";

    /**
     * EN: Code for DICOM<br>
     * DE: Code für DICOM<br>
     * FR: Code de DICOM<br>
     * IT: Code per DICOM<br>
     */
    public static final String DICOM_CODE = "application/dicom";

    /**
     * EN: Code for Extensible 3D Graphics (VRML)<br>
     * DE: Code für Extensible 3D Graphics (VRML)<br>
     * FR: Code de Extensible 3D Graphics (VRML)<br>
     * IT: Code per Extensible 3D Graphics (VRML)<br>
     */
    public static final String EXTENSIBLE_3D_GRAPHICS_VRML_CODE = "model/x3d-vrml";

    /**
     * EN: Code for Extensible 3D Graphics (XML)<br>
     * DE: Code für Extensible 3D Graphics (XML)<br>
     * FR: Code de Extensible 3D Graphics (XML)<br>
     * IT: Code per Extensible 3D Graphics (XML)<br>
     */
    public static final String EXTENSIBLE_3D_GRAPHICS_XML_CODE = "model/x3d+xml";

    /**
     * EN: Code for FHIR (JSON)<br>
     * DE: Code für FHIR (JSON)<br>
     * FR: Code de FHIR (JSON)<br>
     * IT: Code per FHIR (JSON)<br>
     */
    public static final String FHIR_JSON_CODE = "application/fhir+json";

    /**
     * EN: Code for FHIR (XML)<br>
     * DE: Code für FHIR (XML)<br>
     * FR: Code de FHIR (XML)<br>
     * IT: Code per FHIR (XML)<br>
     */
    public static final String FHIR_XML_CODE = "application/fhir+xml";

    /**
     * EN: Code for GIF Graphics Interchange Format<br>
     * DE: Code für GIF Graphics Interchange Format<br>
     * FR: Code de GIF Graphics Interchange Format<br>
     * IT: Code per GIF Graphics Interchange Format<br>
     */
    public static final String GIF_GRAPHICS_INTERCHANGE_FORMAT_CODE = "image/gif";

    /**
     * EN: Code for JPEG 2000 Compound Image File<br>
     * DE: Code für JPEG 2000 Compound Image File<br>
     * FR: Code de JPEG 2000 Compound Image File<br>
     * IT: Code per JPEG 2000 Compound Image File<br>
     */
    public static final String JPEG_2000_COMPOUND_IMAGE_FILE_CODE = "image/jpm";

    /**
     * EN: Code for JPEG 2000 Core Image File<br>
     * DE: Code für JPEG 2000 Core Image File<br>
     * FR: Code de JPEG 2000 Core Image File<br>
     * IT: Code per JPEG 2000 Core Image File<br>
     */
    public static final String JPEG_2000_CORE_IMAGE_FILE_CODE = "image/jp2";

    /**
     * EN: Code for JPEG 2000 Image File<br>
     * DE: Code für JPEG 2000 Image File<br>
     * FR: Code de JPEG 2000 Image File<br>
     * IT: Code per JPEG 2000 Image File<br>
     */
    public static final String JPEG_2000_IMAGE_FILE_CODE = "image/jpx";

    /**
     * EN: Code for JPEG Image<br>
     * DE: Code für JPEG Image<br>
     * FR: Code de JPEG Image<br>
     * IT: Code per JPEG Image<br>
     */
    public static final String JPEG_IMAGE_CODE = "image/jpeg";

    /**
     * EN: Code for Motion JPEG 2000<br>
     * DE: Code für Motion JPEG 2000<br>
     * FR: Code de Motion JPEG 2000<br>
     * IT: Code per Motion JPEG 2000<br>
     */
    public static final String MOTION_JPEG_2000_CODE = "video/mj2";

    /**
     * EN: Code for MP4 Audio<br>
     * DE: Code für MP4 Audio<br>
     * FR: Code de MP4 Audio<br>
     * IT: Code per MP4 Audio<br>
     */
    public static final String MP4_AUDIO_CODE = "audio/mp4";

    /**
     * EN: Code for MPEG-4 Part 14<br>
     * DE: Code für MPEG-4 Part 14<br>
     * FR: Code de MPEG-4 Part 14<br>
     * IT: Code per MPEG-4 Part 14<br>
     */
    public static final String MPEG_4_PART_14_CODE = "video/mp4";

    /**
     * EN: Code for MPEG audio layer 3<br>
     * DE: Code für MPEG audio layer 3<br>
     * FR: Code de MPEG audio layer 3<br>
     * IT: Code per MPEG audio layer 3<br>
     */
    public static final String MPEG_AUDIO_LAYER_3_CODE = "audio/mpeg";

    /**
     * EN: Code for MPEG Video<br>
     * DE: Code für MPEG Video<br>
     * FR: Code de MPEG Video<br>
     * IT: Code per MPEG Video<br>
     */
    public static final String MPEG_VIDEO_CODE = "video/mpeg";

    /**
     * EN: Code for Multilingual Multipart<br>
     * DE: Code für Multilingual Multipart<br>
     * FR: Code de Multilingual Multipart<br>
     * IT: Code per Multilingual Multipart<br>
     */
    public static final String MULTILINGUAL_MULTIPART_CODE = "multipart/multilingual";

    /**
     * EN: Code for PDF<br>
     * DE: Code für PDF<br>
     * FR: Code de PDF<br>
     * IT: Code per PDF<br>
     */
    public static final String PDF_CODE = "application/pdf";

    /**
     * EN: Code for Plain Text<br>
     * DE: Code für Plain Text<br>
     * FR: Code de Plain Text<br>
     * IT: Code per Plain Text<br>
     */
    public static final String PLAIN_TEXT_CODE = "text/plain";

    /**
     * EN: Code for PNG Portable Network Graphics<br>
     * DE: Code für PNG Portable Network Graphics<br>
     * FR: Code de PNG Portable Network Graphics<br>
     * IT: Code per PNG Portable Network Graphics<br>
     */
    public static final String PNG_PORTABLE_NETWORK_GRAPHICS_CODE = "image/png";

    /**
     * EN: Code for Signed Multipart<br>
     * DE: Code für Signed Multipart<br>
     * FR: Code de Signed Multipart<br>
     * IT: Code per Signed Multipart<br>
     */
    public static final String SIGNED_MULTIPART_CODE = "multipart/signed";

    /**
     * EN: Code for TIFF Image<br>
     * DE: Code für TIFF Image<br>
     * FR: Code de TIFF Image<br>
     * IT: Code per TIFF Image<br>
     */
    public static final String TIFF_IMAGE_CODE = "image/tiff";

    /**
     * EN: Code for Virtual Reality Modeling Language<br>
     * DE: Code für Virtual Reality Modeling Language<br>
     * FR: Code de Virtual Reality Modeling Language<br>
     * IT: Code per Virtual Reality Modeling Language<br>
     */
    public static final String VIRTUAL_REALITY_MODELING_LANGUAGE_CODE = "model/vrml";

    /**
     * EN: Code for XML-Text<br>
     * DE: Code für XML-Text<br>
     * FR: Code de XML-Text<br>
     * IT: Code per XML-Text<br>
     */
    public static final String XML_TEXT_CODE = "text/xml";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.16";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.mimeType";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static MimeType getEnum(final String code) {
        for (final MimeType x : values()) {
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
    public static boolean isEnumOfValueSet(final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(MimeType.class,
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
    public static boolean isInValueSet(final String codeValue) {
        for (final MimeType x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    private String code;

    /**
     * Identifier of the referencing code system.
     */
    private String codeSystem;

    /**
     * The display names per language.
     */
    private Map<LanguageCode, String> displayNames;

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
    MimeType(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
        this.code = code;
        this.codeSystem = codeSystem;
        this.displayNames = new HashMap<>();
        this.displayNames.put(null,
                              displayName);
        this.displayNames.put(LanguageCode.ENGLISH,
                              displayNameEn);
        this.displayNames.put(LanguageCode.GERMAN,
                              displayNameDe);
        this.displayNames.put(LanguageCode.FRENCH,
                              displayNameFr);
        this.displayNames.put(LanguageCode.ITALIAN,
                              displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemName() {
        final CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
        if (cs != null) {
            return cs.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param. If there is no english translation, the default display name
     *      is returned.
     *
     * @param languageCode The language code to get the display name for.
     * @return the display name in the desired language. if language not found, display name in german will be returned.
     */
    @Override
    public String getDisplayName(final LanguageCode languageCode) {
        final String displayName = this.displayNames.get(languageCode);
        if (displayName == null && languageCode == LanguageCode.ENGLISH) {
            return this.displayNames.get(null);
        }
        return displayName;
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
