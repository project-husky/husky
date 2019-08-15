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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.60
 * Template description: The laboratory that creates the document MUST be declared as Custodian. The GLN is the primary key and thus the unique identification of the laboratory. If the lab services are to be refunded by the insurance, the SASIS number (ge:ZSR / fr:RCC) MUST be declared in the same element as the GLN as follows.
 */
public class CdachlrepHeaderCustodian extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian {

	public CdachlrepHeaderCustodian() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.3"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.60"));
	// cdachlrep_header_Custodian/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.3";
	// cdachlrep_header_Custodian/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.2.60";
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
	 * Gets the hl7AssignedCustodian
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian getHl7AssignedCustodian() {
		return assignedCustodian;
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
	 * Sets the hl7AssignedCustodian
	 */
	public void setHl7AssignedCustodian(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian value) {
		this.assignedCustodian = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
