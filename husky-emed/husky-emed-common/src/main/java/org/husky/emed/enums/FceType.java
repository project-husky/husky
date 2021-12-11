/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.enums;

import org.husky.communication.ch.enums.ClassCode;
import org.husky.communication.ch.enums.FormatCode;
import org.husky.communication.ch.enums.MimeType;
import org.husky.communication.ch.enums.TypeCode;

import java.util.Objects;

/**
 * Enum of the types of FHIR-CH-EMED documents.
 *
 * @author Quentin Ligier
 */
public enum FceType {

    MTP_JSON(
            EmedDocumentType.MTP.getName(),
            FormatCode.COMMUNITY_MEDICATION_TREATMENT_PLAN,
            EmedDocumentType.MTP.getTypeCode(),
            EmedDocumentType.MTP.getClassCode(),
            MimeType.FHIR_JSON_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationtreatmentplan"
    ),
    PRE_JSON(
            EmedDocumentType.PRE.getName(),
            FormatCode.COMMUNITY_PRESCRIPTION,
            EmedDocumentType.PRE.getTypeCode(),
            EmedDocumentType.PRE.getClassCode(),
            MimeType.FHIR_JSON_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationprescription"
    ),
    DIS_JSON(
            EmedDocumentType.DIS.getName(),
            FormatCode.COMMUNITY_DISPENSE,
            EmedDocumentType.DIS.getTypeCode(),
            EmedDocumentType.DIS.getClassCode(),
            MimeType.FHIR_JSON_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationdispense"
    ),
    PADV_JSON(
            EmedDocumentType.PADV.getName(),
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE,
            EmedDocumentType.PADV.getTypeCode(),
            EmedDocumentType.PADV.getClassCode(),
            MimeType.FHIR_JSON_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-pharmaceuticaladvice"
    ),
    PML_JSON(
            EmedDocumentType.PML.getName(),
            FormatCode.COMMUNITY_MEDICATION_LIST,
            EmedDocumentType.PML.getTypeCode(),
            EmedDocumentType.PML.getClassCode(),
            MimeType.FHIR_JSON_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationlist"
    ),
    PMLC_JSON(
            EmedDocumentType.PMLC.getName(),
            // TODO: The right format code should be urn:ch:cda-ch-emed:medication-card:2018 but it's not added to the
            // value set yet
            FormatCode.COMMUNITY_MEDICATION_LIST,
            EmedDocumentType.PMLC.getTypeCode(),
            EmedDocumentType.PMLC.getClassCode(),
            MimeType.FHIR_JSON_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationcard"
    ),
    MTP_XML(
            EmedDocumentType.MTP.getName(),
            FormatCode.COMMUNITY_MEDICATION_TREATMENT_PLAN,
            EmedDocumentType.MTP.getTypeCode(),
            EmedDocumentType.MTP.getClassCode(),
            MimeType.FHIR_XML_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationtreatmentplan"
    ),
    PRE_XML(
            EmedDocumentType.PRE.getName(),
            FormatCode.COMMUNITY_PRESCRIPTION,
            EmedDocumentType.PRE.getTypeCode(),
            EmedDocumentType.PRE.getClassCode(),
            MimeType.FHIR_XML_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationprescription"
    ),
    DIS_XML(
            EmedDocumentType.DIS.getName(),
            FormatCode.COMMUNITY_DISPENSE,
            EmedDocumentType.DIS.getTypeCode(),
            EmedDocumentType.DIS.getClassCode(),
            MimeType.FHIR_XML_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationdispense"
    ),
    PADV_XML(
            EmedDocumentType.PADV.getName(),
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE,
            EmedDocumentType.PADV.getTypeCode(),
            EmedDocumentType.PADV.getClassCode(),
            MimeType.FHIR_XML_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-pharmaceuticaladvice"
    ),
    PML_XML(
            EmedDocumentType.PML.getName(),
            FormatCode.COMMUNITY_MEDICATION_LIST,
            EmedDocumentType.PML.getTypeCode(),
            EmedDocumentType.PML.getClassCode(),
            MimeType.FHIR_XML_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationlist"
    ),
    PMLC_XML(
            EmedDocumentType.PMLC.getName(),
            // TODO: The right format code should be urn:ch:cda-ch-emed:medication-card:2018 but it's not added to the
            // value set yet
            FormatCode.COMMUNITY_MEDICATION_LIST,
            EmedDocumentType.PMLC.getTypeCode(),
            EmedDocumentType.PMLC.getClassCode(),
            MimeType.FHIR_XML_CODE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationcard"
    );

    /**
     * The name of the CDA-CH-EMED type.
     */
    private final String name;

    /**
     * The format code in the IHE Format system (1.3.6.1.4.1.19376.1.2.3).
     */
    private final FormatCode formatCode;

    /**
     * The equivalent type code.
     */
    private final TypeCode typeCode;

    /**
     * The equivalent class code.
     */
    private final ClassCode classCode;

    /**
     * The MIME type.
     */
    private final String mimeType;

    /**
     * The FHIR profile URN.
     */
    private final String profile;

    FceType(final String name,
            final FormatCode formatCode,
            final TypeCode typeCode,
            final ClassCode classCode,
            final String mimeType,
            final String profile) {
        this.name = Objects.requireNonNull(name);
        this.formatCode = Objects.requireNonNull(formatCode);
        this.typeCode = Objects.requireNonNull(typeCode);
        this.classCode = Objects.requireNonNull(classCode);
        this.mimeType = Objects.requireNonNull(mimeType);
        this.profile = Objects.requireNonNull(profile);
    }

    /**
     * Returns the value of the type's format code.
     */
    public String getFormatCodeValue() {
        return this.formatCode.getCodeValue();
    }

    public String getName() {
        return this.name;
    }

    public FormatCode getFormatCode() {
        return this.formatCode;
    }

    public TypeCode getTypeCode() {
        return this.typeCode;
    }

    public ClassCode getClassCode() {
        return this.classCode;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getProfile() {
        return this.profile;
    }
}
