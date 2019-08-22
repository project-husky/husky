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
package org.ehealth_connector.cda.ch.emed.v0953;

import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.4
 * Template description: A recipient of this CDA document (corresponds to the addressee of a letter - person or organization). All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST use this template by either reference or specialisation.
 *
 * Element description: A recipient of this CDA document (corresponds to the addressee of a letter - person or organization).Recipient types:
 * - The main recipient of the document is indicated by typeCode 'PRCP' (primary recipient).Note: Since it makes no sense to create a CDA document without doing it for someone, in Switzerland at least one recipient MUST be declared. If the document is created for the user's own needs, the user itself or its organization will be the primary recipient.
 * - Other recipients (copy to; Cc) are indicated with typeCode, TRC '(secondary recipient).
 */
public class CdachHeaderInformationRecipient extends org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient {

	public CdachHeaderInformationRecipient() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.4"));
	// cdach_header_InformationRecipient/hl7:informationRecipient:cs typeCode = valueSet("2.16.840.1.113883.1.11.19366");
	// cdach_header_InformationRecipient/hl7:informationRecipient:cs typeCode = valueSet("2.16.840.1.113883.1.11.19366");
	// cdach_header_InformationRecipient/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.4";
	}

	@XmlTransient()
	private org.ehealth_connector.cda.ch.emed.v0953.enums.XInformationRecipient myTypeCode;

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
	private void createTypeCodeFixedValue(org.ehealth_connector.cda.ch.emed.v0953.enums.XInformationRecipient value) {
		this.myTypeCode = value;
	}

	/**
	 * Gets the hl7IntendedRecipient
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040IntendedRecipient getHl7IntendedRecipient() {
		return intendedRecipient;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getTemplateId() != null)
			if (getTemplateId().size() > 0)
				retVal = getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the member myTypeCode
	 */
	public org.ehealth_connector.cda.ch.emed.v0953.enums.XInformationRecipient getPredefinedTypeCode() {
		return myTypeCode;
	}

	/**
	 * Sets the hl7IntendedRecipient
	 */
	public void setHl7IntendedRecipient(org.ehealth_connector.common.hl7cdar2.POCDMT000040IntendedRecipient value) {
		this.intendedRecipient = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
