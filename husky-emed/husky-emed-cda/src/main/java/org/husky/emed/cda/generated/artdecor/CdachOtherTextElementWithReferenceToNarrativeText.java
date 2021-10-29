package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ED;

/**
 * cdach_other_TextElementWithReferenceToNarrativeText
 * <p>
 * Template description: Reusable template wherever a text reference to the corresponding text in the human readable part (narrative text) is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.14<br>
 * Effective date: 2021-06-09 08:55:14<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachOtherTextElementWithReferenceToNarrativeText extends ED {

    public CdachOtherTextElementWithReferenceToNarrativeText() {
    }

    /**
     * Gets the hl7Reference
     * The reference to the corresponding text in the human readable part must be specified by reference to content[@ID]: reference[@value='#xxx']
     */
    public org.husky.emed.cda.generated.hl7cdar2.TEL getHl7Reference() {
        return reference;
    }

    /**
     * Sets the hl7Reference
     * The reference to the corresponding text in the human readable part must be specified by reference to content[@ID]: reference[@value='#xxx']
     */
    public void setHl7Reference(org.husky.emed.cda.generated.hl7cdar2.TEL value) {
        this.reference = value;
    }
}
