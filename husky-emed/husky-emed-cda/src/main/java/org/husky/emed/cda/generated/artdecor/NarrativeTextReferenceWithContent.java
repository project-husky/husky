/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ED;

/**
 * NarrativeTextReferenceWithContent
 * <p>
 * Template description: Reusable template wherever a text content is included and a text reference is used in a CDA-CH V2 document (only CDA-CH-EMED at first). CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br/><br>
 * Element description: It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.1<br>
 * Effective date: 2021-06-08 15:50:58<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class NarrativeTextReferenceWithContent extends ED {

    public NarrativeTextReferenceWithContent() {
    }

    /**
     * Gets the hl7Reference<br/>
     * The reference to the corresponding text in the human readable part must be specified by reference to content[{@literal @}ID]: reference[{@literal @}value='#xxx']<br/>
     */
    public org.husky.common.hl7cdar2.TEL getHl7Reference() {
        return reference;
    }

    /**
     * Sets the hl7Reference<br/>
     * The reference to the corresponding text in the human readable part must be specified by reference to content[{@literal @}ID]: reference[{@literal @}value='#xxx']<br/>
     */
    public void setHl7Reference(org.husky.common.hl7cdar2.TEL value) {
        this.reference = value;
    }
}
