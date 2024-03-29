/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;

/**
 * Dosierung4er
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30044<br>
 * Effective date: 2020-07-21 13:37:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Dosierung4er extends POCDMT000040EntryRelationship {

    public Dosierung4er() {
		super.setTypeCode(XActRelationshipEntryRelationship.COMP);
    }

    /**
     * Gets the hl7SequenceNumber
     */
    public org.projecthusky.common.hl7cdar2.INT getHl7SequenceNumber() {
		return this.sequenceNumber;
    }

    /**
     * Gets the hl7SubstanceAdministration
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration getHl7SubstanceAdministration() {
		return this.substanceAdministration;
    }

    /**
     * Sets the hl7SequenceNumber
     */
    public void setHl7SequenceNumber(org.projecthusky.common.hl7cdar2.INT value) {
		this.sequenceNumber = value;
    }

    /**
     * Sets the hl7SubstanceAdministration
     */
	public void setHl7SubstanceAdministration(org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration value) {
		this.substanceAdministration = value;
    }
}
