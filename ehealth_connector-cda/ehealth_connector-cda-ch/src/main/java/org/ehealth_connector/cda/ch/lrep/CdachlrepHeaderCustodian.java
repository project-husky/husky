/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lrep;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.60
 * Template description: The laboratory that creates the document MUST be declared as Custodian. The GLN is the primary key and thus the unique identification of the laboratory. If the lab services are to be refunded by the insurance, the SASIS number (ge:ZSR / fr:RCC) MUST be declared in the same element as the GLN as follows.
 */
public class CdachlrepHeaderCustodian extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian {

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian hl7AssignedCustodian;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * Gets the hl7AssignedCustodian
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian getHl7AssignedCustodian() {
		return hl7AssignedCustodian;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7TemplateId1
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId1() {
		return hl7TemplateId1;
	}

	/**
	 * Sets the hl7AssignedCustodian
	 */
	public void setHl7AssignedCustodian(org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian value) {
		hl7AssignedCustodian = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7TemplateId1
	 */
	public void setHl7TemplateId1(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId1 = value;
	}
}
