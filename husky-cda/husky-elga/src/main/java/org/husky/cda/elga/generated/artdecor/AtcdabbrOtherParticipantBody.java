/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Participant2;

/**
 * atcdabbr_other_ParticipantBody
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.13<br>
 * Effective date: 2021-06-28 14:00:23<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherParticipantBody extends POCDMT000040Participant2 {

    public AtcdabbrOtherParticipantBody() {
        super.setParticipantRole(createHl7ParticipantRoleFixedValue("ROL"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AwarenessCode
     */
    private static org.husky.common.hl7cdar2.CE createHl7AwarenessCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7ParticipantRole
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040ParticipantRole createHl7ParticipantRoleFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040ParticipantRole retVal = factory.createPOCDMT000040ParticipantRole();
        retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7AwarenessCode
     */
    public org.husky.common.hl7cdar2.CE getHl7AwarenessCode() {
        return awarenessCode;
    }

    /**
     * Gets the hl7ParticipantRole
     */
    public org.husky.common.hl7cdar2.POCDMT000040ParticipantRole getHl7ParticipantRole() {
        return participantRole;
    }

    /**
     * Gets the hl7Time
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7Time() {
        return time;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedAwarenessCode() {
        return createHl7AwarenessCodeFixedValue();
    }

    /**
     * Sets the hl7AwarenessCode
     */
    public void setHl7AwarenessCode(org.husky.common.hl7cdar2.CE value) {
        this.awarenessCode = value;
    }

    /**
     * Sets the hl7ParticipantRole
     */
    public void setHl7ParticipantRole(org.husky.common.hl7cdar2.POCDMT000040ParticipantRole value) {
        this.participantRole = value;
    }

    /**
     * Sets the hl7Time
     */
    public void setHl7Time(org.husky.common.hl7cdar2.IVLTS value) {
        this.time = value;
    }
}
