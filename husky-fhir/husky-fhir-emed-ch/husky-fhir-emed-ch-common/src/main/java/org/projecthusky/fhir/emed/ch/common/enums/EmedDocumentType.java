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
package org.projecthusky.fhir.emed.ch.common.enums;

import org.projecthusky.communication.ch.enums.beta.ClassCode;
import org.projecthusky.communication.ch.enums.beta.FormatCode;
import org.projecthusky.communication.ch.enums.beta.TypeCode;

import java.util.Objects;

/**
 * Enumeration of the different kind of eMedication documents (CDA or FHIR).
 *
 * @author Quentin Ligier
 */
public enum EmedDocumentType {

    MTP(
            "MTP",
            TypeCode.RECORD_ARTIFACT,
            ClassCode.PRESCRIPTION_RECORD,
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE, // TODO
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationtreatmentplan"
    ),
    PRE(
            "PRE",
            TypeCode.MEDICAL_PRESCRIPTION_RECORD,
            ClassCode.PRESCRIPTION_RECORD,
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE, // TODO
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationprescription"
    ),
    DIS(
            "DIS",
            TypeCode.RECORD_ARTIFACT,
            ClassCode.PRESCRIPTION_RECORD,
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE, // TODO
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationdispense"
    ),
    PADV(
            "PADV",
            TypeCode.RECORD_ARTIFACT,
            ClassCode.PRESCRIPTION_RECORD,
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-pharmaceuticaladvice"
    ),
    PML(
            "PML",
            TypeCode.MEDICATION_SUMMARY_DOCUMENT,
            ClassCode.SUMMARY_CLINICAL_DOCUMENT,
            FormatCode.COMMUNITY_MEDICATION_LIST, // TODO
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationlist"
    ),
    PMLC(
            "PMLC",
            TypeCode.MEDICATION_SUMMARY_DOCUMENT,
            ClassCode.SUMMARY_CLINICAL_DOCUMENT,
            FormatCode.COMMUNITY_MEDICATION_LIST, // TODO
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationcard"
    );


    /**
     * The name of the eMedication document type.
     */
    private final String name;

    /**
     * The equivalent type code.
     */
    private final TypeCode typeCode;

    /**
     * The equivalent class code.
     */
    private final ClassCode classCode;

    /**
     * The format code in the IHE Format system (1.3.6.1.4.1.19376.1.2.3).
     */
    private final FormatCode formatCode;

    /**
     * The FHIR profile URN.
     */
    private final String profile;

    EmedDocumentType(final String name,
                     final TypeCode typeCode,
                     final ClassCode classCode,
                     final FormatCode formatCode,
                     final String profile) {
        this.name = Objects.requireNonNull(name);
        this.typeCode = Objects.requireNonNull(typeCode);
        this.classCode = Objects.requireNonNull(classCode);
        this.formatCode = Objects.requireNonNull(formatCode);
        this.profile = Objects.requireNonNull(profile);
    }

    /**
     * Returns the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the type code.
     */
    public TypeCode getTypeCode() {
        return this.typeCode;
    }

    /**
     * Returns the class code.
     */
    public ClassCode getClassCode() {
        return this.classCode;
    }

    /**
     * Returns the format code.
     */
    public FormatCode getFormatCode() {
        return this.formatCode;
    }

    /**
     * Returns the FHIR profile URN.
     */
    public String getProfile() {
        return this.profile;
    }
}
