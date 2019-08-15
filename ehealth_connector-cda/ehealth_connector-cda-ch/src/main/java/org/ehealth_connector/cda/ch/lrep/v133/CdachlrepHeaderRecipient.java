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

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.57
 * Template description: The laboratory report MUST contain at least one receiver. This can be a person or an institution. If the document is created for internal use, the recipient can include the same information as author or custodian. In case of health care professionals the declaration is as for custodian. For patients or other persons, the declaration is as for recordTarget or author.
 *
 * Element description: The laboratory report MUST contain at least one receiver.
 */
public class CdachlrepHeaderRecipient extends org.ehealth_connector.common.hl7cdar2.POCDMT000040InformationRecipient {

	public CdachlrepHeaderRecipient() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.57"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.3.1.4"));
	// cdachlrep_header_Recipient/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.4";
	// cdachlrep_header_Recipient/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.57";
	// cdachlrep_header_Recipient/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.3.1.4";
	}

	/**
	 * Creates fixed contents for hl7TemplateId
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
	 * Gets the hl7IntendedRecipient
	 * The laboratory report MUST contain at least one receiver.
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
	 * Sets the hl7IntendedRecipient
	 * The laboratory report MUST contain at least one receiver.
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
