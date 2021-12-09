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
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachHeaderDocumentSetIdAndVersionNumber extends POCDMT000040ClinicalDocument {

    public CdachHeaderDocumentSetIdAndVersionNumber() {
    }

    /**
     * Gets the hl7SetId/The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
     */
    public org.husky.common.hl7cdar2.II getHl7SetId() {
        return setId;
    }

    /**
     * Gets the hl7VersionNumber/The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
     */
    public org.husky.common.hl7cdar2.INT getHl7VersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the hl7SetId<br/>
     * The setId element MUST match the document id of the very first version of that document. It MUST remain the same for all document versions.
     */
    public void setHl7SetId(org.husky.common.hl7cdar2.II value) {
        this.setId = value;
    }

    /**
     * Sets the hl7VersionNumber<br/>
     * The versionNumber element MUST contain the value 1 for the very first version of that document. For later versions, the version number MUST be increased by 1 each.
     */
    public void setHl7VersionNumber(org.husky.common.hl7cdar2.INT value) {
        this.versionNumber = value;
    }
}
