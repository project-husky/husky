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
package org.husky.emed.cda.models.common;

import java.io.Serial;
import java.util.ArrayList;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.emed.cda.generated.hl7cdar2.CD;
import org.husky.emed.cda.generated.hl7cdar2.CE;
import org.husky.emed.cda.generated.hl7cdar2.CS;
import org.husky.emed.cda.generated.hl7cdar2.ED;
import org.husky.emed.cda.models.common.basetypes.CodeBaseType;

/**
 * The class Code contains all necessary fields for a coded element. This class also provides mapping methods to other
 * data types.
 */
public class Code extends CodeBaseType {

    /**
     * The Constant serialVersionUID.
     */
    @Serial
    private static final long serialVersionUID = 5410972500384690838L;

    /**
     * Instantiates a new code. Default constructor.
     */
    public Code() {
    }

    /**
     * Instantiates a new instance from the given base type.
     *
     * @param baseType The base type
     */
    public Code(CodeBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value The HL7 CDA R2 data type
     */
    public Code(CD hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value The HL7 CDA R2 data type
     */
    public Code(CE hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value The HL7 CDA R2 data type
     */
    public Code(CS hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new code based on an enum value.
     *
     * @param enumValue The enum value
     */
    public Code(ValueSetEnumInterface enumValue) {
        CodeBaseType codeBt = CodeBaseType.builder().withCode(enumValue.getCodeValue())
                .withCodeSystem(enumValue.getCodeSystemId()).build();
        if (enumValue.getCodeSystemName() != null)
            if (!"".equals(enumValue.getCodeSystemName()))
                codeBt.setCodeSystemName(enumValue.getCodeSystemName());

        if (enumValue.getDisplayName() != null)
            if (!"".equals(enumValue.getDisplayName()))
                codeBt.setDisplayName(enumValue.getDisplayName());

        initFromBaseType(codeBt);

    }

    /**
     * Creates the base type from the given HL7 CDA R2 value. If it's {@code null}, a null flavor will be set.
     *
     * @param hl7CdaR2Value The HL7 CDA R2 value or {@code null}.
     * @return the base type
     */
    public static CodeBaseType createCodeBaseType(@Nullable final CD hl7CdaR2Value) {
        CodeBaseType retVal = new CodeBaseType();

        if (hl7CdaR2Value != null) {
            String nullFlavor = null;
            if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty()) {
				nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
			}
            if (nullFlavor != null) {
				retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));
			} else {

                retVal.setCode(hl7CdaR2Value.getCode());
                retVal.setCodeSystem(hl7CdaR2Value.getCodeSystem());
                retVal.setCodeSystemName(hl7CdaR2Value.getCodeSystemName());
                retVal.setCodeSystemVersion(hl7CdaR2Value.getCodeSystemVersion());
                retVal.setDisplayName(hl7CdaR2Value.getDisplayName());

                ED ed = hl7CdaR2Value.getOriginalText();
                if (ed != null)
                    retVal.setOriginalText(ed.getXmlMixed().get(0)); // TODO
            }

            for (CD item : hl7CdaR2Value.getTranslation()) {
                retVal.addCodeTranslation(createCodeBaseType(item));
            }

            // setDisplayNameTranslationList() is not implemented, because it is not supported by CD
        } else {
			retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);
		}
        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType The base type
     * @return the HL7 CDA R2 data typed value
     */
    public static CD createHl7CdaR2Cd(final CodeBaseType baseType) {
        final var retVal = new CD();
        String value;

        NullFlavor nf = baseType.getNullFlavor();
        if (nf != null) {
            if (retVal.nullFlavor == null)
                retVal.nullFlavor = new ArrayList<String>();
            retVal.nullFlavor.add(nf.getCodeValue());
        } else {

            retVal.setCode(baseType.getCode());
            retVal.setCodeSystem(baseType.getCodeSystem());
            retVal.setCodeSystemName(baseType.getCodeSystemName());
            retVal.setCodeSystemVersion(baseType.getCodeSystemVersion());
            retVal.setDisplayName(baseType.getDisplayName());

            value = baseType.getOriginalText();
            if (value != null) {
                ED ed = new ED();
                ed.getXmlMixed().add(value);
                retVal.setOriginalText(ed);
            }
        }

        for (CodeBaseType item : baseType.getCodeTranslationList()) {
            retVal.getTranslation().add(createHl7CdaR2Cd(item));
        }

        // listDisplayNameTranslations() is not implemented, because it is not supported by CD
        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType The base type
     * @return the HL7 CDA R2 data typed value
     */
    public static CE createHl7CdaR2Ce(CodeBaseType baseType) {
        CE retVal = null;
        if (baseType != null) {
            retVal = new CE();
            String value;

            NullFlavor nf = baseType.getNullFlavor();
            if (nf != null) {
                if (retVal.nullFlavor == null)
                    retVal.nullFlavor = new ArrayList<String>();
                retVal.nullFlavor.add(nf.getCodeValue());
            } else {

                value = baseType.getCode();
                if (value != null) {
                    retVal.setCode(value);
                }

                value = baseType.getCodeSystem();
                if (value != null) {
                    retVal.setCodeSystem(value);
                }

                value = baseType.getCodeSystemName();
                if (value != null) {
                    retVal.setCodeSystemName(value);
                }

                value = baseType.getCodeSystemVersion();
                if (value != null) {
                    retVal.setCodeSystemVersion(value);
                }

                value = baseType.getDisplayName();
                if (value != null) {
                    retVal.setDisplayName(value);
                }

                value = baseType.getOriginalText();
                if (value != null) {
                    ED ed = new ED();
                    ed.getXmlMixed().add(value);
                    retVal.setOriginalText(ed);
                }
            }

            for (CodeBaseType item : baseType.getCodeTranslationList()) {
                retVal.getTranslation().add(createHl7CdaR2Cd(item));
            }

            // listDisplayNameTranslations() is not implemented, because it is
            // not
            // supported by CD
        }

        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType The base type
     * @return the HL7 CDA R2 data typed value
     */
    public static CS createHl7CdaR2Cs(CodeBaseType baseType) {
        CS retVal = null;
        if (baseType != null) {
            retVal = new CS();
            String value;

            NullFlavor nf = baseType.getNullFlavor();
            if (nf != null) {
                if (retVal.nullFlavor == null)
                    retVal.nullFlavor = new ArrayList<String>();
                retVal.nullFlavor.add(nf.getCodeValue());
            } else {

                value = baseType.getCode();
                if (value != null) {
                    retVal.setCode(value);
                }

                value = baseType.getCodeSystem();
                if (value != null) {
                    retVal.setCodeSystem(value);
                }

                value = baseType.getCodeSystemName();
                if (value != null) {
                    retVal.setCodeSystemName(value);
                }

                value = baseType.getCodeSystemVersion();
                if (value != null) {
                    retVal.setCodeSystemVersion(value);
                }

                value = baseType.getDisplayName();
                if (value != null) {
                    retVal.setDisplayName(value);
                }

                value = baseType.getOriginalText();
                if (value != null) {
                    ED ed = new ED();
                    ed.getXmlMixed().add(value);
                    retVal.setOriginalText(ed);
                }
            }

            for (CodeBaseType item : baseType.getCodeTranslationList()) {
                retVal.getTranslation().add(createHl7CdaR2Cd(item));
            }

            // listDisplayNameTranslations() is not implemented, because it is
            // not
            // supported by CD
        }

        return retVal;

    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public CD getHl7CdaR2Cd() {
        return createHl7CdaR2Cd(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public CE getHl7CdaR2Ce() {
        return createHl7CdaR2Ce(this);
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public CS getHl7CdaR2Cs() {
        return createHl7CdaR2Cs(this);
    }

    /**
     * Inits from the base type.
     *
     * @param baseType The base type
     */
    private void initFromBaseType(@Nullable final CodeBaseType baseType) {
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
        } else {
            setNullFlavor(NullFlavor.NOT_AVAILABLE);
        }
    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value The HL7 CDA R2 data type value
     */
    private void initFromHl7CdaR2(@Nullable final CD hl7CdaR2Value) {
        initFromBaseType(createCodeBaseType(hl7CdaR2Value));
    }

    /**
     * Sets the fields of the current instance by the given base type.
     *
     * @param baseType The base type
     */
    public void set(@Nullable final CodeBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Sets the fields of the current instance by the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value The HL7 CDA R2 data typed value
     */
    public void set(CD hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

}
