/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ED;

/**
 * atcdabbr_other_OriginalTextReference
 * <p>
 * Template description: Reusable template wherever a original text reference to the corresponding text in the human readable part (narrative text) is used in a CDA document.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.2<br>
 * Effective date: 2021-02-19 13:31:48<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherOriginalTextReference extends ED {

    public AtcdabbrOtherOriginalTextReference() {
    }

    /**
     * Gets the hl7Reference
     */
    public org.projecthusky.common.hl7cdar2.TEL getHl7Reference() {
        return reference;
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.projecthusky.common.hl7cdar2.TEL value) {
        this.reference = value;
    }
}
