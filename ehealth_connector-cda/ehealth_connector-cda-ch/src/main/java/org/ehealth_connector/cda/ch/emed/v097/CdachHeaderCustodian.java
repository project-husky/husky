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

import javax.annotation.Generated;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.3 Template
 * description: The organization in whose name this CDA document has been
 * created (corresponds to the sender of a letter). All CDA-CH V2 derivatives,
 * i.e. Swiss exchange formats MUST use this template by either reference or
 * specialisation.
 *
 * Element description: The organization in whose name this CDA document has
 * been created (corresponds to the sender of a letter).
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-02-23")
public class CdachHeaderCustodian
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Custodian {

	public CdachHeaderCustodian() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.3"));
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
	 * Gets the hl7AssignedCustodian
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian getHl7AssignedCustodian() {
		return assignedCustodian;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7AssignedCustodian
	 */
	public void setHl7AssignedCustodian(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedCustodian value) {
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
