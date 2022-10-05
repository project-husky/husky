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
 * atcdabbr_other_ParticipantBodyAuthorizedEditor
 * 
 * Identifier: 1.2.40.0.34.6.0.11.9.46<br>
 * Effective date: 2021-12-03 12:35:40<br>
 * Version: 1.0.0+20220103<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherParticipantBodyAuthorizedEditor extends POCDMT000040Participant2 {

    public AtcdabbrOtherParticipantBodyAuthorizedEditor() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.9.46"));
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
}
