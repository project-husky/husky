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

import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.communication.ch.enums.stable.ClassCode;
import org.projecthusky.communication.ch.enums.stable.FormatCode;
import org.projecthusky.communication.ch.enums.stable.TypeCode;

import java.util.Objects;

/**
 * Enumeration of the different kind of eMedication documents (FHIR).
 *
 * @author Quentin Ligier
 */
@Getter
public enum EmedDocumentType {

    MTP(
            "MTP",
            TypeCode.MEDICATION_TREATMENT_PLAN,
            ClassCode.CARE_PLAN,
            FormatCode.CH_EMED_MEDICATION_TREATMENT_PLAN_DOCUMENT,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationtreatmentplan",
            "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationtreatmentplan"
    ),
    PRE(
            "PRE",
            TypeCode.MEDICAL_PRESCRIPTION_RECORD,
            ClassCode.PRESCRIPTION,
            FormatCode.CH_EMED_MEDICATION_PRESCRIPTION_DOCUMENT,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationprescription",
            "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationprescription"
    ),
    DIS(
            "DIS",
            TypeCode.MEDICATION_DISPENSE,
            ClassCode.EVENT_REPORT,
            FormatCode.CH_EMED_MEDICATION_DISPENSE_DOCUMENT,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationdispense",
            "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationdispense"
    ),
    PADV(
            "PADV",
            TypeCode.RECORD_ARTIFACT,
            ClassCode.PRESCRIPTION,
            FormatCode.CH_EMED_PHARMACEUTICAL_ADVICE_DOCUMENT,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-pharmaceuticaladvice",
            "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-pharmaceuticaladvice"
    ),
    PML(
            "PML",
            TypeCode.MEDICATION_LIST,
            ClassCode.SUMMARY,
            FormatCode.CH_EMED_MEDICATION_LIST_DOCUMENT,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationlist",
            "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationlist"
    ),
    PMLC(
            "PMLC",
            TypeCode.MEDICATION_CARD_DOCUMENT,
            ClassCode.SUMMARY,
            FormatCode.CH_EMED_MEDICATION_CARD_DOCUMENT,
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationcard",
            "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationcard"
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
     * The CH EMED FHIR profile URN.
     */
    private final String profile;

    /**
     * The CH EMED EPR FHIR profile URN
     */
    private final String profileEpr;

    EmedDocumentType(final String name,
                     final TypeCode typeCode,
                     final ClassCode classCode,
                     final FormatCode formatCode,
                     final String profile,
                     final String profileEpr) {
        this.name = Objects.requireNonNull(name);
        this.typeCode = Objects.requireNonNull(typeCode);
        this.classCode = Objects.requireNonNull(classCode);
        this.formatCode = Objects.requireNonNull(formatCode);
        this.profile = Objects.requireNonNull(profile);
        this.profileEpr = Objects.requireNonNull(profileEpr);
    }

    /**
     * Convenience method that gets the corresponding {@link EmedDocumentType} for the received profile URL. The profile
     * URL can be either a CH EMED or a CH EMED EPR document profile URL.
     * <p>
     *     If the URL does not match either a  CH EMED or CH EMED EPR document bundle profile URL, the method returns
     *     {@code null}
     * </p>
     * <p>
     *     Note that this method does not handle pinned URLs, it expects versionless URLs.
     * </p>
     * @param profileUrl The string containing a URL profile, expected to be either a CH EMED or a CH EMED EPR document
     *                   bundle profile URL.
     * @return The corresponding {@link EmedDocumentType} if the profile matches either its CH EMED or its CH EMED EPR
     *         official URL; {@code null} otherwise.
     */
    public static @Nullable EmedDocumentType fromProfileUrl(final String profileUrl) {
        Objects.requireNonNull(profileUrl, "The profile URL cannot be null.");
        for (EmedDocumentType type : EmedDocumentType.values()) {
            if (type.getProfile().equals(profileUrl)) return type;
            if (type.getProfileEpr().equals(profileUrl)) return type;
        }
        return null;
    }
}
