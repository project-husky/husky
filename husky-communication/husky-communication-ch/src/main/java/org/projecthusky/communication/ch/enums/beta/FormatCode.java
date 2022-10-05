/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.beta;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.formatCode values
 * <p>
 * EN: Document format as per Annex; EPRO-FDHA. This unambiguous code defines the format of the XDS document. Together with the mimetype, this should provide the potential consumer with sufficient information as to whether they are in a position to process the document.<br>
 * DE: Format des Dokumentes gemäss Anhang 3 EPDV-EDI. Dieser eindeutige Code definiert das Format des XDS Dokumentes. Zusammen mit dem mimeType, sollte es dem potentiellen Konsumenten genügend Informationen liefern, ob er in der Lage ist, das Dokument zu verarbeiten.<br>
 * FR: Format du document selon l'annexe 3 ODEP-DFI. Ce code univoque définit le format du document XDS. Combiné au mimeType, il doit fournir à l'utilisateur suffisamment d'informations pour savoir s'il est en mesure de traiter le document.<br>
 * IT: Formato del documento secondo l'allegato 3 OCIP-DFI. Questo codice univoco definisce il formato del documento XDS. Insieme al tipo MIME, intende fornire al potenziale consumatore sufficienti informazioni per capire se è in grado o meno di elaborare il documento.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.9<br>
 * Effective date: 2022-06-26 16:40<br>
 * Version: 202304.0-beta<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-09-29")
public enum FormatCode implements ValueSetEnumInterface {

    /**
     * EN: CDA-CH-EMED Medication Card document.<br>
     * DE: CDA-CH-EMED Medication Card document.<br>
     * FR: CDA-CH-EMED Medication Card document.<br>
     * IT: CDA-CH-EMED Medication Card document.<br>
     */
    CDA_CH_EMED_MEDICATION_CARD_DOCUMENT("urn:che:epr:cda-ch-emed:medication-card:2022",
                                         "2.16.756.5.30.1.127.3.10.10",
                                         "CDA-CH-EMED Medication Card document",
                                         "CDA-CH-EMED Medication Card document",
                                         "CDA-CH-EMED Medication Card document",
                                         "CDA-CH-EMED Medication Card document",
                                         "CDA-CH-EMED Medication Card document"),
    /**
     * EN: CDA Imaging Report with Structured Headings.<br>
     * DE: CDA Imaging Report with Structured Headings.<br>
     * FR: CDA Imaging Report with Structured Headings.<br>
     * IT: CDA Imaging Report with Structured Headings.<br>
     */
    CDA_IMAGING_REPORT_WITH_STRUCTURED_HEADINGS("urn:ihe:rad:CDA:ImagingReportStructuredHeadings:2013",
                                                "1.3.6.1.4.1.19376.1.2.3",
                                                "XDS-I Imaging Report with Structured Headings (XDS-I)",
                                                "CDA Imaging Report with Structured Headings",
                                                "CDA Imaging Report with Structured Headings",
                                                "CDA Imaging Report with Structured Headings",
                                                "CDA Imaging Report with Structured Headings"),
    /**
     * EN: CDA Laboratory Report.<br>
     * DE: CDA Laboratory Report.<br>
     * FR: CDA Laboratory Report.<br>
     * IT: CDA Laboratory Report.<br>
     */
    CDA_LABORATORY_REPORT("urn:ihe:lab:xd-lab:2008",
                          "1.3.6.1.4.1.19376.1.2.3",
                          "CDA Laboratory Report",
                          "CDA Laboratory Report",
                          "CDA Laboratory Report",
                          "CDA Laboratory Report",
                          "CDA Laboratory Report"),
    /**
     * EN: CDA Wrapped Text Report.<br>
     * DE: CDA Wrapped Text Report.<br>
     * FR: CDA Wrapped Text Report.<br>
     * IT: CDA Wrapped Text Report.<br>
     */
    CDA_WRAPPED_TEXT_REPORT("urn:ihe:rad:TEXT",
                            "1.3.6.1.4.1.19376.1.2.3",
                            "XDS-I CDA Wrapped Text Report (XDS-I)",
                            "CDA Wrapped Text Report",
                            "CDA Wrapped Text Report",
                            "CDA Wrapped Text Report",
                            "CDA Wrapped Text Report"),
    /**
     * EN: CH EMED Medication Card document.<br>
     * DE: CH EMED Medication Card document.<br>
     * FR: CH EMED Medication Card document.<br>
     * IT: CH EMED Medication Card document.<br>
     */
    CH_EMED_MEDICATION_CARD_DOCUMENT("urn:che:epr:ch-emed:medication-card:2022",
                                     "2.16.756.5.30.1.127.3.10.10",
                                     "CH EMED Medication Card document",
                                     "CH EMED Medication Card document",
                                     "CH EMED Medication Card document",
                                     "CH EMED Medication Card document",
                                     "CH EMED Medication Card document"),
    /**
     * EN: CH VACD Immunization Administration.<br>
     * DE: CH VACD Immunization Administration.<br>
     * FR: CH VACD Immunization Administration.<br>
     * IT: CH VACD Immunization Administration.<br>
     */
    CH_VACD_IMMUNIZATION_ADMINISTRATION("urn:che:epr:ch-vacd:immunization-administration:2022",
                                        "2.16.756.5.30.1.127.3.10.10",
                                        "CH VACD Immunization Administration",
                                        "CH VACD Immunization Administration",
                                        "CH VACD Immunization Administration",
                                        "CH VACD Immunization Administration",
                                        "CH VACD Immunization Administration"),
    /**
     * EN: CH VACD Vaccination Record.<br>
     * DE: CH VACD Vaccination Record.<br>
     * FR: CH VACD Vaccination Record.<br>
     * IT: CH VACD Vaccination Record.<br>
     */
    CH_VACD_VACCINATION_RECORD("urn:che:epr:ch-vacd:vaccination-record:2022",
                               "2.16.756.5.30.1.127.3.10.10",
                               "CH VACD Vaccination Record",
                               "CH VACD Vaccination Record",
                               "CH VACD Vaccination Record",
                               "CH VACD Vaccination Record",
                               "CH VACD Vaccination Record"),
    /**
     * EN: Community Dispense.<br>
     * DE: Community Dispense.<br>
     * FR: Community Dispense.<br>
     * IT: Community Dispense.<br>
     */
    COMMUNITY_DISPENSE("urn:ihe:pharm:dis:2010",
                       "1.3.6.1.4.1.19376.1.2.3",
                       "Community Dispense",
                       "Community Dispense",
                       "Community Dispense",
                       "Community Dispense",
                       "Community Dispense"),
    /**
     * EN: Community Medication List.<br>
     * DE: Community Medication List.<br>
     * FR: Community Medication List.<br>
     * IT: Community Medication List.<br>
     */
    COMMUNITY_MEDICATION_LIST("urn:ihe:pharm:pml:2013",
                              "1.3.6.1.4.1.19376.1.2.3",
                              "Community Medication List",
                              "Community Medication List",
                              "Community Medication List",
                              "Community Medication List",
                              "Community Medication List"),
    /**
     * EN: Community Medication Treatment Plan.<br>
     * DE: Community Medication Treatment Plan.<br>
     * FR: Community Medication Treatment Plan.<br>
     * IT: Community Medication Treatment Plan.<br>
     */
    COMMUNITY_MEDICATION_TREATMENT_PLAN("urn:ihe:pharm:mtp:2015",
                                        "1.3.6.1.4.1.19376.1.2.3",
                                        "Community Medication Treatment Plan",
                                        "Community Medication Treatment Plan",
                                        "Community Medication Treatment Plan",
                                        "Community Medication Treatment Plan",
                                        "Community Medication Treatment Plan"),
    /**
     * EN: Community Pharmaceutical Advice.<br>
     * DE: Community Pharmaceutical Advice.<br>
     * FR: Community Pharmaceutical Advice.<br>
     * IT: Community Pharmaceutical Advice.<br>
     */
    COMMUNITY_PHARMACEUTICAL_ADVICE("urn:ihe:pharm:padv:2010",
                                    "1.3.6.1.4.1.19376.1.2.3",
                                    "Community Pharmaceutical Advice",
                                    "Community Pharmaceutical Advice",
                                    "Community Pharmaceutical Advice",
                                    "Community Pharmaceutical Advice",
                                    "Community Pharmaceutical Advice"),
    /**
     * EN: Community Prescription.<br>
     * DE: Community Prescription.<br>
     * FR: Community Prescription.<br>
     * IT: Community Prescription.<br>
     */
    COMMUNITY_PRESCRIPTION("urn:ihe:pharm:pre:2010",
                           "1.3.6.1.4.1.19376.1.2.3",
                           "Community Prescription",
                           "Community Prescription",
                           "Community Prescription",
                           "Community Prescription",
                           "Community Prescription"),
    /**
     * EN: IHE KOS document.<br>
     * DE: KOS Dokument.<br>
     * FR: Document KOS.<br>
     * IT: Documento KOS .<br>
     */
    IHE_KOS_DOCUMENT("1.2.840.10008.5.1.4.1.1.88.59",
                     "1.2.840.10008.2.6.1",
                     "DICOM Manifest (DICOM KOS SOP Class UID)",
                     "IHE KOS document",
                     "KOS Dokument",
                     "Document KOS",
                     "Documento KOS "),
    /**
     * EN: Immunization Content (IC).<br>
     * DE: Immunization Content (IC).<br>
     * FR: Immunization Content (IC).<br>
     * IT: Immunization Content (IC).<br>
     */
    IMMUNIZATION_CONTENT("urn:ihe:pcc:ic:2009",
                         "1.3.6.1.4.1.19376.1.2.3",
                         "Immunization Content (IC)",
                         "Immunization Content (IC)",
                         "Immunization Content (IC)",
                         "Immunization Content (IC)",
                         "Immunization Content (IC)"),
    /**
     * EN: MimeType sufficient.<br>
     * DE: MimeType sufficient.<br>
     * FR: MimeType sufficient.<br>
     * IT: MimeType sufficient.<br>
     */
    MIMETYPE_SUFFICIENT("urn:ihe:iti:xds:2017:mimeTypeSufficient",
                        "1.3.6.1.4.1.19376.1.2.3",
                        "MimeType sufficient",
                        "MimeType sufficient",
                        "MimeType sufficient",
                        "MimeType sufficient",
                        "MimeType sufficient"),
    /**
     * EN: PDF Radiology Report.<br>
     * DE: PDF Radiology Report.<br>
     * FR: PDF Radiology Report.<br>
     * IT: PDF Radiology Report.<br>
     */
    PDF_RADIOLOGY_REPORT("urn:ihe:rad:PDF",
                         "1.3.6.1.4.1.19376.1.2.3",
                         "XDS-I PDF (XDS-I)",
                         "PDF Radiology Report",
                         "PDF Radiology Report",
                         "PDF Radiology Report",
                         "PDF Radiology Report"),
    /**
     * EN: Unstructured EPR document.<br>
     * DE: Unstrukturiertes EPD Dokument.<br>
     * FR: Document DEP non structuré.<br>
     * IT: Documento CIP non strutturato.<br>
     */
    UNSTRUCTURED_EPR_DOCUMENT("urn:che:epr:EPR_Unstructured_Document",
                              "2.16.756.5.30.1.127.3.10.10",
                              "Unstructured EPR document",
                              "Unstructured EPR document",
                              "Unstrukturiertes EPD Dokument",
                              "Document DEP non structuré",
                              "Documento CIP non strutturato");

    /**
     * EN: Code for CDA-CH-EMED Medication Card document.<br>
     * DE: Code für CDA-CH-EMED Medication Card document.<br>
     * FR: Code de CDA-CH-EMED Medication Card document.<br>
     * IT: Code per CDA-CH-EMED Medication Card document.<br>
     */
    public static final String CDA_CH_EMED_MEDICATION_CARD_DOCUMENT_CODE = "urn:che:epr:cda-ch-emed:medication-card:2022";

    /**
     * EN: Code for CDA Imaging Report with Structured Headings.<br>
     * DE: Code für CDA Imaging Report with Structured Headings.<br>
     * FR: Code de CDA Imaging Report with Structured Headings.<br>
     * IT: Code per CDA Imaging Report with Structured Headings.<br>
     */
    public static final String CDA_IMAGING_REPORT_WITH_STRUCTURED_HEADINGS_CODE = "urn:ihe:rad:CDA:ImagingReportStructuredHeadings:2013";

    /**
     * EN: Code for CDA Laboratory Report.<br>
     * DE: Code für CDA Laboratory Report.<br>
     * FR: Code de CDA Laboratory Report.<br>
     * IT: Code per CDA Laboratory Report.<br>
     */
    public static final String CDA_LABORATORY_REPORT_CODE = "urn:ihe:lab:xd-lab:2008";

    /**
     * EN: Code for CDA Wrapped Text Report.<br>
     * DE: Code für CDA Wrapped Text Report.<br>
     * FR: Code de CDA Wrapped Text Report.<br>
     * IT: Code per CDA Wrapped Text Report.<br>
     */
    public static final String CDA_WRAPPED_TEXT_REPORT_CODE = "urn:ihe:rad:TEXT";

    /**
     * EN: Code for CH EMED Medication Card document.<br>
     * DE: Code für CH EMED Medication Card document.<br>
     * FR: Code de CH EMED Medication Card document.<br>
     * IT: Code per CH EMED Medication Card document.<br>
     */
    public static final String CH_EMED_MEDICATION_CARD_DOCUMENT_CODE = "urn:che:epr:ch-emed:medication-card:2022";

    /**
     * EN: Code for CH VACD Immunization Administration.<br>
     * DE: Code für CH VACD Immunization Administration.<br>
     * FR: Code de CH VACD Immunization Administration.<br>
     * IT: Code per CH VACD Immunization Administration.<br>
     */
    public static final String CH_VACD_IMMUNIZATION_ADMINISTRATION_CODE = "urn:che:epr:ch-vacd:immunization-administration:2022";

    /**
     * EN: Code for CH VACD Vaccination Record.<br>
     * DE: Code für CH VACD Vaccination Record.<br>
     * FR: Code de CH VACD Vaccination Record.<br>
     * IT: Code per CH VACD Vaccination Record.<br>
     */
    public static final String CH_VACD_VACCINATION_RECORD_CODE = "urn:che:epr:ch-vacd:vaccination-record:2022";

    /**
     * EN: Code for Community Dispense.<br>
     * DE: Code für Community Dispense.<br>
     * FR: Code de Community Dispense.<br>
     * IT: Code per Community Dispense.<br>
     */
    public static final String COMMUNITY_DISPENSE_CODE = "urn:ihe:pharm:dis:2010";

    /**
     * EN: Code for Community Medication List.<br>
     * DE: Code für Community Medication List.<br>
     * FR: Code de Community Medication List.<br>
     * IT: Code per Community Medication List.<br>
     */
    public static final String COMMUNITY_MEDICATION_LIST_CODE = "urn:ihe:pharm:pml:2013";

    /**
     * EN: Code for Community Medication Treatment Plan.<br>
     * DE: Code für Community Medication Treatment Plan.<br>
     * FR: Code de Community Medication Treatment Plan.<br>
     * IT: Code per Community Medication Treatment Plan.<br>
     */
    public static final String COMMUNITY_MEDICATION_TREATMENT_PLAN_CODE = "urn:ihe:pharm:mtp:2015";

    /**
     * EN: Code for Community Pharmaceutical Advice.<br>
     * DE: Code für Community Pharmaceutical Advice.<br>
     * FR: Code de Community Pharmaceutical Advice.<br>
     * IT: Code per Community Pharmaceutical Advice.<br>
     */
    public static final String COMMUNITY_PHARMACEUTICAL_ADVICE_CODE = "urn:ihe:pharm:padv:2010";

    /**
     * EN: Code for Community Prescription.<br>
     * DE: Code für Community Prescription.<br>
     * FR: Code de Community Prescription.<br>
     * IT: Code per Community Prescription.<br>
     */
    public static final String COMMUNITY_PRESCRIPTION_CODE = "urn:ihe:pharm:pre:2010";

    /**
     * EN: Code for IHE KOS document.<br>
     * DE: Code für KOS Dokument.<br>
     * FR: Code de Document KOS.<br>
     * IT: Code per Documento KOS .<br>
     */
    public static final String IHE_KOS_DOCUMENT_CODE = "1.2.840.10008.5.1.4.1.1.88.59";

    /**
     * EN: Code for Immunization Content (IC).<br>
     * DE: Code für Immunization Content (IC).<br>
     * FR: Code de Immunization Content (IC).<br>
     * IT: Code per Immunization Content (IC).<br>
     */
    public static final String IMMUNIZATION_CONTENT_CODE = "urn:ihe:pcc:ic:2009";

    /**
     * EN: Code for MimeType sufficient.<br>
     * DE: Code für MimeType sufficient.<br>
     * FR: Code de MimeType sufficient.<br>
     * IT: Code per MimeType sufficient.<br>
     */
    public static final String MIMETYPE_SUFFICIENT_CODE = "urn:ihe:iti:xds:2017:mimeTypeSufficient";

    /**
     * EN: Code for PDF Radiology Report.<br>
     * DE: Code für PDF Radiology Report.<br>
     * FR: Code de PDF Radiology Report.<br>
     * IT: Code per PDF Radiology Report.<br>
     */
    public static final String PDF_RADIOLOGY_REPORT_CODE = "urn:ihe:rad:PDF";

    /**
     * EN: Code for Unstructured EPR document.<br>
     * DE: Code für Unstrukturiertes EPD Dokument.<br>
     * FR: Code de Document DEP non structuré.<br>
     * IT: Code per Documento CIP non strutturato.<br>
     */
    public static final String UNSTRUCTURED_EPR_DOCUMENT_CODE = "urn:che:epr:EPR_Unstructured_Document";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.9";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.formatCode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static FormatCode getEnum(@Nullable final String code) {
        for (final FormatCode x : values()) {
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
            Enum.valueOf(FormatCode.class,
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
        for (final FormatCode x : values()) {
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
    FormatCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
