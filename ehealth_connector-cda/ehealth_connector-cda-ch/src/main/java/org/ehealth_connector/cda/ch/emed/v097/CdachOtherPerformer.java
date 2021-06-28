/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.emed.v097;

import javax.annotation.processing.Generated;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * cdach_other_Performer
 *
 * Template description: Reusable template wherever a healthcare provider who was the primary performer of an act is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: Information about a healthcare provider who was the primary performer of the act.
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.756.5.30.1.1.10.9.31
 * Effective date: 2018-12-24 19:51:04
 * Version: 2020
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class CdachOtherPerformer
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer1 {

	public CdachOtherPerformer() {
		super.setTypeCode(org.ehealth_connector.common.hl7cdar2.XServiceEventPerformer.PRF);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.9.31"));
		super.getTemplateId()
				.add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.24.3.5"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.12.323"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7AssignedEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return assignedEntity;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Time Duration of the performance.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7Time() {
		return time;
	}

	/**
	 * Sets the hl7AssignedEntity
	 */
	public void setHl7AssignedEntity(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		this.assignedEntity = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Time Duration of the performance.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.time = value;
	}
}
