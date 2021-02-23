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
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Material;

/**
 * Original ART-DECOR template id: 1.3.6.1.4.1.19376.1.9.1.3.16 Template
 * description: Reference to a Medication Treatment Plan Entry
 *
 * Element description: Reference to Medication Treatment Plan Item General
 * Specification
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-02-23")
public class IhevalidationStepEntryContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public IhevalidationStepEntryContentModule() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.PRP);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.16"));
		super.setConsumable(createHl7ConsumableNa());
	}

	/**
	 * Creates fixed contents for CDA Element hl7Consumable, containing an
	 * hl7ManufacturedMaterial with a null flavor NA.
	 */
	private static POCDMT000040Consumable createHl7ConsumableNa() {
		final POCDMT000040Material material = new POCDMT000040Material();
		material.getNullFlavor().add("NA");
		final POCDMT000040ManufacturedProduct product = new POCDMT000040ManufacturedProduct();
		product.setManufacturedMaterial(material);
		final POCDMT000040Consumable consumable = new POCDMT000040Consumable();
		consumable.setManufacturedProduct(product);
		return consumable;
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
	 * Gets the hl7Consumable
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return consumable;
	}

	/**
	 * Gets the hl7TemplateId Reference to Medication Treatment Plan Item
	 * General Specification Template ID
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7Consumable
	 */
	public void setHl7Consumable(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
	}

	/**
	 * Sets the hl7TemplateId Reference to Medication Treatment Plan Item
	 * General Specification Template ID
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
