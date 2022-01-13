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

/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.enums;

import org.husky.communication.ch.enums.ClassCode;
import org.husky.communication.ch.enums.TypeCode;

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
            ClassCode.PRESCRIPTION_RECORD
    ),
    PRE(
            "PRE",
            TypeCode.MEDICAL_PRESCRIPTION_RECORD,
            ClassCode.PRESCRIPTION_RECORD
    ),
    DIS(
            "DIS",
            TypeCode.RECORD_ARTIFACT,
            ClassCode.PRESCRIPTION_RECORD
    ),
    PADV(
            "PADV",
            TypeCode.RECORD_ARTIFACT,
            ClassCode.PRESCRIPTION_RECORD
    ),
    PML(
            "PML",
            TypeCode.MEDICATION_SUMMARY_DOCUMENT,
            ClassCode.SUMMARY_CLINICAL_DOCUMENT
    ),
    PMLC(
            "PMLC",
            TypeCode.MEDICATION_SUMMARY_DOCUMENT,
            ClassCode.SUMMARY_CLINICAL_DOCUMENT
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

    EmedDocumentType(final String name,
                     final TypeCode typeCode,
                     final ClassCode classCode) {
        this.name = Objects.requireNonNull(name);
        this.typeCode = Objects.requireNonNull(typeCode);
        this.classCode = Objects.requireNonNull(classCode);
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
}
