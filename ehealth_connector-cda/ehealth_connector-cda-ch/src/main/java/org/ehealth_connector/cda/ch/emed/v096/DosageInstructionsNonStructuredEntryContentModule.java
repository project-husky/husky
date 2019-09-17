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
package org.ehealth_connector.cda.ch.emed.v096;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.52 Template
 * description: Dosage Instructions reference to free text (non structured) in
 * narrative part.
 */
public class DosageInstructionsNonStructuredEntryContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

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

	public DosageInstructionsNonStructuredEntryContentModule() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("INT"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.52"));
	}

	/**
	 * Gets the hl7Consumable
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return consumable;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text This element SHALL be present. The URI given in the
	 * value attribute of the<reference>element points to an element in the
	 * narrative content that contains the complete text describing the non
	 * strutured dosage instructions.</reference>
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Sets the hl7Consumable
	 */
	public void setHl7Consumable(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text This element SHALL be present. The URI given in the
	 * value attribute of the<reference>element points to an element in the
	 * narrative content that contains the complete text describing the non
	 * strutured dosage instructions.</reference>
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
