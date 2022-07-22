/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ED;

/**
 * atcdabrr_other_NarrativeTextReference
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.1<br>
 * Effective date: 2021-05-06 09:38:20<br>
 * Version: 1.0.1+20210512<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabrrOtherNarrativeTextReference extends ED {

    public AtcdabrrOtherNarrativeTextReference() {
    }

    /**
     * Gets the hl7Reference
     */
    public org.husky.common.hl7cdar2.TEL getHl7Reference() {
        return reference;
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.husky.common.hl7cdar2.TEL value) {
        this.reference = value;
    }
}
