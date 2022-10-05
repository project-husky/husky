/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient;

/**
 * HeaderInformationRecipient
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20005<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class HeaderInformationRecipient extends POCDMT000040InformationRecipient {

    public HeaderInformationRecipient() {
    }

    /**
     * Gets the hl7IntendedRecipient
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040IntendedRecipient getHl7IntendedRecipient() {
        return intendedRecipient;
    }

    /**
     * Sets the hl7IntendedRecipient
     */
    public void setHl7IntendedRecipient(org.projecthusky.common.hl7cdar2.POCDMT000040IntendedRecipient value) {
        this.intendedRecipient = value;
    }
}
