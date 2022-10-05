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

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Participant2;

/**
 * atcdabbr_other_ParticipantBodyDataEnterer
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.47<br>
 * Effective date: 2022-01-25 13:42:02<br>
 * Version: 1.0.0+20220127<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherParticipantBodyDataEnterer extends POCDMT000040Participant2 {

    public AtcdabbrOtherParticipantBodyDataEnterer() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.9.47"));
        super.setParticipantRole(createHl7ParticipantRoleFixedValue("ROL"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ParticipantRole
     *
     * @param classCode the desired fixed value for this argument.
     */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040ParticipantRole createHl7ParticipantRoleFixedValue(
			String classCode) {
		org.projecthusky.common.hl7cdar2.POCDMT000040ParticipantRole retVal = new org.projecthusky.common.hl7cdar2.POCDMT000040ParticipantRole();
		retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7ParticipantRole
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040ParticipantRole getHl7ParticipantRole() {
		return this.participantRole;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Time
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7Time() {
		return this.time;
    }

    /**
     * Sets the hl7ParticipantRole
     */
	public void setHl7ParticipantRole(org.projecthusky.common.hl7cdar2.POCDMT000040ParticipantRole value) {
		this.participantRole = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Time
     */
	public void setHl7Time(org.projecthusky.common.hl7cdar2.IVLTS value) {
		this.time = value;
    }
}
