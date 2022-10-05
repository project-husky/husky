/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ED;

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
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdachOtherTextElementWithReferenceToNarrativeText extends ED {

    public CdachOtherTextElementWithReferenceToNarrativeText() {
    }

    /**
     * Gets the hl7Reference<br/>
     * The reference to the corresponding text in the human readable part must be specified by reference to content[{@literal @}ID]: reference[{@literal @}value='#xxx']
     */
    public org.projecthusky.common.hl7cdar2.TEL getHl7Reference() {
        return reference;
    }

    /**
     * Sets the hl7Reference<br/>
     * The reference to the corresponding text in the human readable part must be specified by reference to content[{@literal @}ID]: reference[{@literal @}value='#xxx']
     */
    public void setHl7Reference(org.projecthusky.common.hl7cdar2.TEL value) {
        this.reference = value;
    }
}
