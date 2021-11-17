package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * cdach_header_DocumentSetIdAndVersionNumber
 * <p>
 * Template description: Unity of document versions. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.<br>
 * Element description: The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.20<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachHeaderDocumentSetIdAndVersionNumber extends POCDMT000040ClinicalDocument {

    public CdachHeaderDocumentSetIdAndVersionNumber() {
    }

    /**
     * Gets the hl7SetId
     * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
     */
    public II getHl7SetId() {
        return setId;
    }

    /**
     * Gets the hl7VersionNumber
     * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
     */
    public INT getHl7VersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the hl7SetId
     * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
     */
    public void setHl7SetId(II value) {
        this.setId = value;
    }

    /**
     * Sets the hl7VersionNumber
     * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
     */
    public void setHl7VersionNumber(INT value) {
        this.versionNumber = value;
    }
}
