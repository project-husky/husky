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
package org.husky.common.model;

import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.TEL;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Reference contains all necessary fields for an HL7 CDA R2 reference. This class also provides mapping
 * methods to other data types.
 */
public class Reference {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 6963042793314704003L;

    /**
     * The null flavor.
     */
    private NullFlavor nullFlavor;

    /**
     * The reference value.
     */
    private String value;

    /**
     * The narrative Text.
     */
    private List<String> narrativeText;

    /**
     * Instantiates a new identificator. Default constructor.
     */
    public Reference() {

    }

    /**
     * Instantiates a new instance from the given base type.
     *
     * @param value
     * @param narrativeText
     */
    public Reference(String value, List<String> narrativeText) {
        this.value = value;

        if (narrativeText != null) {
            this.narrativeText = narrativeText;
        }
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Reference(org.husky.common.hl7cdar2.ED hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Creates from the given HL7 CDA R2 value.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 value
     * @return the reference type
     */
    public static Reference createReferenceType(org.husky.common.hl7cdar2.ED hl7CdaR2Value) {
        var retVal = new Reference();

        if (hl7CdaR2Value != null) {
            String nullFlavor = null;
            if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
                nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
            if (nullFlavor != null)
                retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));

            if (hl7CdaR2Value.getReference() != null) {
                retVal.setValue(hl7CdaR2Value.getReference().getValue());
            }

            if (hl7CdaR2Value.getXmlMixed() != null) {
                retVal.setNarrativeText(hl7CdaR2Value.getXmlMixed());
            }
        } else
            retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

        return retVal;

    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.husky.common.hl7cdar2.ED createHl7CdaR2Ed(Reference baseType) {

        org.husky.common.hl7cdar2.ED retVal = null;

        if (baseType != null) {
            retVal = new org.husky.common.hl7cdar2.ED();
            String value;

            var nf = baseType.getNullFlavor();
            if (nf != null) {
                if (retVal.nullFlavor == null)
                    retVal.nullFlavor = new ArrayList<String>();
                retVal.nullFlavor.add(nf.getCodeValue());
            } else {

                value = baseType.getValue();
                if (value != null) {
                    TEL tel = new TEL();
                    tel.setValue(value);
                    retVal.setReference(tel);
                }

                if (baseType.getNarrativeText() != null) {
                    retVal.setXmlMixed(baseType.getNarrativeText());
                }
            }
        }

        return retVal;

    }

    /**
     * Creates an MDHT ED reference from a given String. Adds the hashtag '#' automatically, if not present as first
     * character.
     *
     * @param existingText the existing text
     * @param reference    the reference
     * @return the MDHT ED
     */
    public static ED createReference(ED existingText, String reference) {
        var ed = existingText;
        if (ed == null)
            ed = new ED();
        ed.setReference(createReferenceTel(reference));
        return ed;
    }

    /**
     * <div class="en">Creates the reference.</div>
     *
     * @param contentId <br>
     *                  <div class="en">content id</div>
     * @param prefix    <br>
     *                  <div class="en">prefix</div>
     * @return the ed
     */
    public static ED createReference(int contentId, String prefix) {
        final var text = new ED();
        final var tel = new TEL();

        // Dirty BugFix for missing addReference method.
        tel.setValue("#" + prefix + contentId);
        text.setReference(tel);
        return text;
    }

    /**
     * Creates an ED reference from a given String. Adds the hashtag '#' automatically, if not present as first
     * character.
     *
     * @param reference the reference value
     * @return the ED
     */
    public static ED createReference(String reference) {
        var ed = new ED();
        ed.setReference(createReferenceTel(reference));
        return ed;
    }

    /**
     * Creates an ED reference from a given String.
     *
     * @param url           the reference url
     * @param narrativeText the reference narrative text
     * @return the ED
     */
    public static ED createReference(String url, String narrativeText) {
        final var tel = new TEL();
        final var ed = new ED();
        tel.setValue(url);
        ed.setXmlMixed(narrativeText);
        ed.setReference(tel);
        return ed;
    }

    /**
     * Creates the reference tel.
     *
     * @param value the value
     * @return the tel
     */
    public static TEL createReferenceTel(String value) {
        final var tel = new TEL();
        if (!value.startsWith("#")) {
            value = "#" + value;
        }
        tel.setValue(value);
        return tel;
    }

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.husky.common.hl7cdar2.ED getHl7CdaR2Ed() {
        return createHl7CdaR2Ed(this);
    }

    /**
     * Inits from the base type.
     *
     * @param baseType the base type
     */
    private void init(Reference baseType) {
        if (baseType != null) {
            setValue(baseType.getValue());
            setNarrativeText(baseType.getNarrativeText());
            setNullFlavor(baseType.getNullFlavor());
        } else
            setNullFlavor(NullFlavor.NOT_AVAILABLE);
    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type value
     */
    private void initFromHl7CdaR2(org.husky.common.hl7cdar2.ED hl7CdaR2Value) {
        init(createReferenceType(hl7CdaR2Value));
    }

    /**
     * Sets the fields of the current instance by the given base type.
     *
     * @param baseType the base type
     */
    public void set(Reference baseType) {
        init(baseType);
    }

    /**
     * Sets the fields of the current instance by the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data typed value
     */
    public void set(org.husky.common.hl7cdar2.ED hl7CdaR2Value) {
        init(createReferenceType(hl7CdaR2Value));
    }

    public NullFlavor getNullFlavor() {
        return nullFlavor;
    }

    public void setNullFlavor(NullFlavor nullFlavor) {
        this.nullFlavor = nullFlavor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getNarrativeText() {
        return narrativeText;
    }

    public void setNarrativeText(List<String> narrativeText) {
        this.narrativeText = narrativeText;
    }
}
