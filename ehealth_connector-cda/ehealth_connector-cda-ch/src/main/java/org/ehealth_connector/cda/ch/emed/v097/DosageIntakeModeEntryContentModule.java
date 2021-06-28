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
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Material;

/**
 * DosageIntakeModeEntryContentModule
 *
 * Template description: Dosage intake mode reference to free text (non structured) in narrative part.
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.756.5.30.1.1.10.4.37
 * Effective date: 2016-09-13 16:06:07
 * Version: 2017
 * Status: pending
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class DosageIntakeModeEntryContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public DosageIntakeModeEntryContentModule() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.INT);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.37"));
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
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text This element SHALL be present. The URI given in the
	 * value attribute of the &lt;reference&gt; element points to an element in
	 * the narrative content that contains the complete text describing the
	 * dosage intake mode.
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
	 * value attribute of the &lt;reference&gt; element points to an element in
	 * the narrative content that contains the complete text describing the
	 * dosage intake mode.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
