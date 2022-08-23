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

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Participant2;
import org.husky.common.hl7cdar2.POCDMT000040ParticipantRole;

/**
 * atcdabbr_other_ParticipantBodyTranscriber
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.14<br>
 * Effective date: 2021-08-04 15:41:13<br>
 * Version: 1.1.0+20220103<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherParticipantBodyTranscriber extends POCDMT000040Participant2 {

    public AtcdabbrOtherParticipantBodyTranscriber() {
		super.getTypeCode().add("ENT");
		super.setContextControlCode("OP");
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.9.14"));
		super.setParticipantRole(createHl7ParticipantRoleFixedValue("ROL"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ParticipantRole
     *
     * @param classCode the desired fixed value for this argument.
     */
	private static org.husky.common.hl7cdar2.POCDMT000040ParticipantRole createHl7ParticipantRoleFixedValue(
			String classCode) {
		ObjectFactory factory = new ObjectFactory();
		POCDMT000040ParticipantRole retVal = factory.createPOCDMT000040ParticipantRole();
		retVal.getClassCode().add("ROL");
		return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7ParticipantRole
     */
	public org.husky.common.hl7cdar2.POCDMT000040ParticipantRole getHl7ParticipantRole() {
		return this.participantRole;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Time
     */
	public org.husky.common.hl7cdar2.IVLTS getHl7Time() {
		return this.time;
    }

    /**
     * Sets the hl7ParticipantRole
     */
	public void setHl7ParticipantRole(org.husky.common.hl7cdar2.POCDMT000040ParticipantRole value) {
		this.participantRole = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Time
     */
	public void setHl7Time(org.husky.common.hl7cdar2.IVLTS value) {
		this.time = value;
    }
}
