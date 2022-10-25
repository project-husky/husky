/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient;

/**
 * epims_header_informationRecipient
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.35<br>
 * Effective date: 2020-02-20 09:37:56<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsHeaderInformationRecipient extends POCDMT000040InformationRecipient {

    public EpimsHeaderInformationRecipient() {
        super.setTypeCode(org.projecthusky.common.hl7cdar2.XInformationRecipient.PRCP);
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
