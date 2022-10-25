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
package org.projecthusky.common.model;

import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.ED;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Code contains all necessary fields for a coded element. This class also provides mapping methods to other
 * data types.
 */
public class Code extends CodeBaseType {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5410972500384690838L;

    /**
     * Instantiates a new code. Default constructor.
     */
    public Code() {
    }

    /**
     * Instantiates a new instance from the given base type.
     *
     * @param baseType the base type
     */
    public Code(CodeBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Instantiates a new instance from the given information.
     *
     * @param code       the code
     * @param codeSystem the code System
     * @param display    the display name
     */
    public Code(String code, String codeSystem, String display) {
        setCode(code);
        setCodeSystem(codeSystem);
        setDisplayName(display);
    }

    /**
     * Instantiates a new instance from the given information.
     *
     * @param code       the code
     * @param codeSystem the code System
     * @param display    the display name
     */
    public Code(String code, String codeSystem, String codeSystemName, String display) {
        setCode(code);
        setCodeSystem(codeSystem);
        setCodeSystemName(codeSystemName);
        setDisplayName(display);
    }

    /**
     * Instantiates a new instance from the given null flavor.
     *
     * @param nf the null flavor
     */
    public Code(NullFlavor nf) {
        setNullFlavor(nf);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Code(org.projecthusky.common.hl7cdar2.CD hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Code(org.projecthusky.common.hl7cdar2.CE hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Code(org.projecthusky.common.hl7cdar2.CS hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new code based on an enum value.
     *
     * @param enumValue the enum value
     */
    public Code(ValueSetEnumInterface enumValue) {
        CodeBaseType codeBt = CodeBaseType.builder().withCode(enumValue.getCodeValue())
                .withCodeSystem(enumValue.getCodeSystemId()).build();
		if (!enumValue.getCodeSystemName().isEmpty())
            codeBt.setCodeSystemName(enumValue.getCodeSystemName());

		if (!enumValue.getDisplayName().isEmpty())
            codeBt.setDisplayName(enumValue.getDisplayName());

        initFromBaseType(codeBt);

    }

    /**
     * Creates the base type from the given HL7 CDA R2 value.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 value
     * @return the base type
     */
    public static CodeBaseType createCodeBaseType(
            org.projecthusky.common.hl7cdar2.CD hl7CdaR2Value) {
        var retVal = new CodeBaseType();

        if (hl7CdaR2Value != null) {
            String nullFlavor = null;
            if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
                nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
            if (nullFlavor != null)
                retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));
            else {

                retVal.setCode(hl7CdaR2Value.getCode());
                retVal.setCodeSystem(hl7CdaR2Value.getCodeSystem());
                retVal.setCodeSystemName(hl7CdaR2Value.getCodeSystemName());
                retVal.setCodeSystemVersion(hl7CdaR2Value.getCodeSystemVersion());
                retVal.setDisplayName(hl7CdaR2Value.getDisplayName());

                var ed = hl7CdaR2Value.getOriginalText();
                if (ed != null)
                    retVal.setOriginalText(ed.getTextContent());
            }

            for (CD item : hl7CdaR2Value.getTranslation()) {
                retVal.addCodeTranslation(createCodeBaseType(item));
            }

            // setDisplayNameTranslationList() is not implemented, because
            // it is
            // not supported by CD
        } else
            retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.projecthusky.common.hl7cdar2.CD createHl7CdaR2Cd(CodeBaseType baseType) {
        org.projecthusky.common.hl7cdar2.CD retVal = null;
        if (baseType != null) {
            retVal = new org.projecthusky.common.hl7cdar2.CD();
			createCode(retVal, baseType);
        }
        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.projecthusky.common.hl7cdar2.CE createHl7CdaR2Ce(CodeBaseType baseType) {
        org.projecthusky.common.hl7cdar2.CE retVal = null;
        if (baseType != null) {
            retVal = new org.projecthusky.common.hl7cdar2.CE();
			createCode(retVal, baseType);
        }

        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.projecthusky.common.hl7cdar2.CS createHl7CdaR2Cs(CodeBaseType baseType) {
        org.projecthusky.common.hl7cdar2.CS retVal = null;
        if (baseType != null) {
            retVal = new org.projecthusky.common.hl7cdar2.CS();
			createCode(retVal, baseType);
        }

        return retVal;

    }

	private static void createCode(CD retVal, CodeBaseType baseType) {

		var nf = baseType.getNullFlavor();
		if (nf != null) {
			if (retVal.nullFlavor == null)
				retVal.nullFlavor = new ArrayList<String>();
			retVal.nullFlavor.add(nf.getCodeValue());
		} else {
			setCodeValues(retVal, baseType);
		}

		for (CodeBaseType item : baseType.getCodeTranslationList()) {
			retVal.getTranslation().add(createHl7CdaR2Cd(item));
		}
	}

	private static void setCodeValues(CD retVal, CodeBaseType baseType) {
		if (baseType.getCode() != null) {
			retVal.setCode(baseType.getCode());
		}

		if (baseType.getCodeSystem() != null) {
			retVal.setCodeSystem(baseType.getCodeSystem());
		}

		if (baseType.getCodeSystemName() != null) {
			retVal.setCodeSystemName(baseType.getCodeSystemName());
		}

		if (baseType.getCodeSystemVersion() != null) {
			retVal.setCodeSystemVersion(baseType.getCodeSystemVersion());
		}

		if (baseType.getDisplayName() != null) {
			retVal.setDisplayName(baseType.getDisplayName());
		}

		if (baseType.getOriginalText() != null) {
			ED ed = new ED();
			ed.setXmlMixed(List.of(baseType.getOriginalText()));
			retVal.setOriginalText(ed);
		}
	}

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.projecthusky.common.hl7cdar2.CD getHl7CdaR2Cd() {
        return createHl7CdaR2Cd(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7CdaR2Ce() {
        return createHl7CdaR2Ce(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7CdaR2Cs() {
        return createHl7CdaR2Cs(this);
    }

    /**
     * Inits from the base type.
     *
     * @param baseType the base type
     */
    private void initFromBaseType(CodeBaseType baseType) {
        if (baseType != null) {
            setCode(baseType.getCode());
            setCodeSystem(baseType.getCodeSystem());
            setCodeSystemName(baseType.getCodeSystemName());
            setCodeSystemVersion(baseType.getCodeSystemVersion());
            setCodeTranslationList(baseType.getCodeTranslationList());
            setDisplayName(baseType.getDisplayName());
            setDisplayNameTranslationList(baseType.getDisplayNameTranslationList());
            setOriginalText(baseType.getOriginalText());
            setNullFlavor(baseType.getNullFlavor());
        } else
            setNullFlavor(NullFlavor.NOT_AVAILABLE_L2);

    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type value
     */
    private void initFromHl7CdaR2(org.projecthusky.common.hl7cdar2.CD hl7CdaR2Value) {
        initFromBaseType(createCodeBaseType(hl7CdaR2Value));
    }

    /**
     * Sets the fields of the current instance by the given base type.
     *
     * @param baseType the base type
     */
    public void set(CodeBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Sets the fields of the current instance by the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data typed value
     */
    public void set(org.projecthusky.common.hl7cdar2.CD hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

}
