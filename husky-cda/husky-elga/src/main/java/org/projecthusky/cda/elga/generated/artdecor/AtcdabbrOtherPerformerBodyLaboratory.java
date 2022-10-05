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

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.projecthusky.common.hl7cdar2.ParticipationPhysicalPerformer;

/**
 * Original ART-DECOR template id: 1.2.40.0.34.6.0.11.9.28 
 */
public class AtcdabbrOtherPerformerBodyLaboratory
		extends org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 {

	public AtcdabbrOtherPerformerBodyLaboratory() {
		super.setTypeCode(ParticipationPhysicalPerformer.PRF);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.9.28"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.7"));
		super.setAssignedEntity(createHl7AssignedEntityFixedValue("ASSIGNED"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7AssignedEntity
	 *
	 * @param classCode
	 *            the desired fixed value for this argument.
	 */
	private static POCDMT000040AssignedEntity createHl7AssignedEntityFixedValue(String classCode) {
		ObjectFactory factory = new ObjectFactory();
		POCDMT000040AssignedEntity retVal = factory.createPOCDMT000040AssignedEntity();
		retVal.setClassCode(classCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7AssignedEntity
	 */
	public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return this.getAssignedEntity();
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Time
	 */
	public org.projecthusky.common.hl7cdar2.IVLTS getHl7Time() {
		return this.getTime();
	}

	/**
	 * Sets the hl7AssignedEntity
	 */
	public void setHl7AssignedEntity(
			org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		this.assignedEntity = value;
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
