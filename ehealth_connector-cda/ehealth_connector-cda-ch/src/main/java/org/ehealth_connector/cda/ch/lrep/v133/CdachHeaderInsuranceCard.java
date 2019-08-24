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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.14
 * Template description: Information on a patient's insurance card. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.
 *
 * Element description: Information on a patient's insurance card.
 */
public class CdachHeaderInsuranceCard extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant1 {

	public CdachHeaderInsuranceCard() {
		super.getTypeCode().add("HLD");
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.14"));
		super.setAssociatedEntity(createHl7AssociatedEntityFixedValue("POLHOLD"));
	// cdach_header_InsuranceCard/hl7:participant:cs typeCode = "HLD";
	// cdach_header_InsuranceCard/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.14";
	// cdach_header_InsuranceCard/hl7:associatedEntity:cs classCode = "POLHOLD";
	}

	@XmlTransient()
	private String myTypeCode;

	/**
	 * Creates fixed contents for CDA Element hl7AssociatedEntity
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity createHl7AssociatedEntityFixedValue(String classCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity retVal = factory.createPOCDMT000040AssociatedEntity();
		retVal.getClassCode().add(classCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Attribute typeCode
	 */
	private void createTypeCodeFixedValue(String value) {
		this.myTypeCode = value;
	}

	/**
	 * Gets the hl7AssociatedEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity getHl7AssociatedEntity() {
		return associatedEntity;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Time
	 * Validity period of the insurance card.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7Time() {
		return time;
	}

	/**
	 * Gets the member myTypeCode
	 */
	public String getPredefinedTypeCode() {
		return myTypeCode;
	}

	/**
	 * Sets the hl7AssociatedEntity
	 */
	public void setHl7AssociatedEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssociatedEntity value) {
		this.associatedEntity = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Time
	 * Validity period of the insurance card.
	 */
	public void setHl7Time(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.time = value;
	}
}
