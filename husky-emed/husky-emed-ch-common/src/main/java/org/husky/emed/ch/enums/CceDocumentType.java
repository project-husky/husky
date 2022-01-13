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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.LanguageCode;
import org.husky.communication.ch.enums.ClassCode;
import org.husky.communication.ch.enums.FormatCode;
import org.husky.communication.ch.enums.TypeCode;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;

import java.util.Objects;

/**
 * Enum of the types of CDA-CH-EMED documents.
 *
 * @author Quentin Ligier
 */
public enum CceDocumentType {

    MTP(
            EmedDocumentType.MTP.getName(),
            "Medication Treatment Plan document",
            "77603-9",
            FormatCode.COMMUNITY_MEDICATION_TREATMENT_PLAN,
            EmedDocumentType.MTP.getTypeCode(),
            EmedDocumentType.MTP.getClassCode(),
            "2.16.756.5.30.1.1.10.1.7"
    ),
    PRE(
            EmedDocumentType.PRE.getName(),
            "Medication Prescription document",
            "57833-6",
            FormatCode.COMMUNITY_PRESCRIPTION,
            EmedDocumentType.PRE.getTypeCode(),
            EmedDocumentType.PRE.getClassCode(),
            "2.16.756.5.30.1.1.10.1.4"
    ),
    DIS(
            EmedDocumentType.DIS.getName(),
            "Medication Dispense document",
            "60593-1",
            FormatCode.COMMUNITY_DISPENSE,
            EmedDocumentType.DIS.getTypeCode(),
            EmedDocumentType.DIS.getClassCode(),
            "2.16.756.5.30.1.1.10.1.5"
    ),
    PADV(
            EmedDocumentType.PADV.getName(),
            "Pharmaceutical Advice document",
            "61356-2",
            FormatCode.COMMUNITY_PHARMACEUTICAL_ADVICE,
            EmedDocumentType.PADV.getTypeCode(),
            EmedDocumentType.PADV.getClassCode(),
            "2.16.756.5.30.1.1.10.1.6"
    ),
    PML(
            EmedDocumentType.PML.getName(),
            "Medication List document",
            "56445-0",
            FormatCode.COMMUNITY_MEDICATION_LIST,
            EmedDocumentType.PML.getTypeCode(),
            EmedDocumentType.PML.getClassCode(),
            "2.16.756.5.30.1.1.10.1.13"
    ),
    PMLC(
            EmedDocumentType.PMLC.getName(),
            "Medication Card document",
            "56445-0",
            FormatCode.MEDICATION_CARD,
            EmedDocumentType.PMLC.getTypeCode(),
            EmedDocumentType.PMLC.getClassCode(),
            "2.16.756.5.30.1.1.10.1.3"
    );

    /**
     * The name of the CDA-CH-EMED type.
     */
    private final String name;

    /**
     * The description of the CDA-CH-EMED type.
     */
    private final String description;

    /**
     * The code in the LOINC system (2.16.840.1.113883.6.1).
     */
    private final String loincCode;

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
     * The OID of the templateId.
     */
    private final String templateId;

    CceDocumentType(final String name,
                    final String description,
                    final String loincCode,
                    final FormatCode formatCode,
                    final TypeCode typeCode,
                    final ClassCode classCode,
                    final String templateId) {
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.loincCode = Objects.requireNonNull(loincCode);
        this.formatCode = Objects.requireNonNull(formatCode);
        this.typeCode = Objects.requireNonNull(typeCode);
        this.classCode = Objects.requireNonNull(classCode);
        this.templateId = Objects.requireNonNull(templateId);
    }

    /**
     * Returns the value of the type's format code.
     */
    public String getFormatCodeValue() {
        return this.formatCode.getCodeValue();
    }

    /**
     * Converts the type code to an instance of {@link Code}.
     */
    public Code toCode() {
        final FormatCode typeFormatCode = this.getFormatCode();
        return new Code(
                typeFormatCode.getCodeValue(),
                new LocalizedString(typeFormatCode.getDisplayName(), LanguageCode.ENGLISH_CODE, "UTF-8"),
                typeFormatCode.getCodeSystemName()
        );
    }

    /**
     * Returns the type corresponding to a LOINC code.
     *
     * @param loincCode The LOINC code.
     * @return the corresponding {@link CceDocumentType}.
     */
    public static CceDocumentType getByLoincCode(final String loincCode) {
        Objects.requireNonNull(loincCode);
        if (DIS.getLoincCode().equals(loincCode)) {
            return DIS;
        } else if (MTP.getLoincCode().equals(loincCode)) {
            return MTP;
        } else if (PADV.getLoincCode().equals(loincCode)) {
            return PADV;
        } else if (PML.getLoincCode().equals(loincCode)) {
            return PML;
        } else if (PMLC.getLoincCode().equals(loincCode)) {
            return PMLC;
        } else if (PRE.getLoincCode().equals(loincCode)) {
            return PRE;
        } else {
            throw new IllegalArgumentException("The code has not been found");
        }
    }

    /**
     * Returns the type corresponding to a template ID.
     *
     * @param templateId the template ID value.
     * @return the corresponding {@link CceDocumentType}.
     */
    @Nullable
    public static CceDocumentType getByTemplateId(final String templateId) {
        Objects.requireNonNull(templateId);
        if (DIS.getTemplateId().equals(templateId)) {
            return DIS;
        } else if (MTP.getTemplateId().equals(templateId)) {
            return MTP;
        } else if (PADV.getTemplateId().equals(templateId)) {
            return PADV;
        } else if (PML.getTemplateId().equals(templateId)) {
            return PML;
        } else if (PMLC.getTemplateId().equals(templateId)) {
            return PMLC;
        } else if (PRE.getTemplateId().equals(templateId)) {
            return PRE;
        } else {
            return null;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLoincCode() {
        return this.loincCode;
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

    public String getTemplateId() {
        return this.templateId;
    }
}
