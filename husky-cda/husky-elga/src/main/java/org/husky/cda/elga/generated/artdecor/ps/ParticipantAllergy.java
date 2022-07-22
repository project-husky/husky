/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040ParticipantRole;

/**
 * ParticipantAllergy
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.3<br>
 * Effective date: 2016-11-06 17:53:23<br>
 * Version: 0.1<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class ParticipantAllergy extends POCDMT000040ParticipantRole {

    public ParticipantAllergy() {
		super.getClassCode().add("MANU");
    }

    /**
     * Adds a hl7PlayingEntity
     */
	public void addHl7PlayingEntity(org.husky.common.hl7cdar2.POCDMT000040PlayingEntity value) {
        playingEntity = value;
    }

    /**
     * Creates fixed contents for CDA Element hl7PlayingEntity
     *
     * @param classCode the desired fixed value for this argument.
     */
	private static org.husky.common.hl7cdar2.POCDMT000040PlayingEntity createHl7PlayingEntityFixedValue(
			String classCode) {
		org.husky.common.hl7cdar2.POCDMT000040PlayingEntity retVal = new org.husky.common.hl7cdar2.POCDMT000040PlayingEntity();
		retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.ANY, filled by: "MMAT"
     * @return the predefined element.
     */
	public static org.husky.common.hl7cdar2.POCDMT000040PlayingEntity getPredefinedPlayingEntityMmat() {
        return createHl7PlayingEntityFixedValue("MMAT");
    }
}
