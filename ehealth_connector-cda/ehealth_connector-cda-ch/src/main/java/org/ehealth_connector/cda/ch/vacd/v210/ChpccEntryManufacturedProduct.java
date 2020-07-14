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
package org.ehealth_connector.cda.ch.vacd.v210;

import java.util.ArrayList;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.94 Template
 * description: Structured information on a product (e.g. Vaccine or
 * Medication). - Trade name of the product SHALL be present in the element
 * 'name' of manufacturedMaterial, - Package barcode (GTIN) SHALL be present in
 * the element 'ID' of manufacturedProduct IF KNOWN - WHO-ATC code MAY be
 * present in the element 'code' of manufacturedMaterial - LOT (lot number) of
 * the product MAY be present in the element 'lotNumberText' of
 * manufacturedMaterial - Name of the manufacturer MAY be present in the element
 * 'name' of manufacturerOrganization
 *
 * Element description: Structured information on a product (e.g. Vaccine or
 * Medication). - Trade name of the product SHALL be present in the element
 * 'name' of manufacturedMaterial, - Package barcode (GTIN) SHALL be present in
 * the element 'ID' of manufacturedProduct IF KNOWN - WHO-ATC code MAY be
 * present in the element 'code' of manufacturedMaterial - LOT (lot number) of
 * the product MAY be present in the element 'lotNumberText' of
 * manufacturedMaterial - Name of the manufacturer MAY be present in the element
 * 'name' of manufacturerOrganization
 */
public class ChpccEntryManufacturedProduct
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ManufacturedProduct {

	/**
	 * Creates fixed contents for CDA Element hl7Id
	 *
	 * @param nullFlavor
	 *            the desired fixed value for this argument.
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7IdFixedValue(String nullFlavor,
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		retVal.setRoot(root);
		return retVal;
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

	public ChpccEntryManufacturedProduct() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.94"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.53"));
		super.getId().add(createHl7IdFixedValue("NAV", "2.51.1.1"));
	}

	/**
	 * Gets the hl7Id The barcode on the package (GTIN).
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7ManufacturedMaterial
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Material getHl7ManufacturedMaterial() {
		return manufacturedMaterial;
	}

	/**
	 * Gets the hl7ManufacturerOrganization Manufacturer of the product.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization getHl7ManufacturerOrganization() {
		return manufacturerOrganization;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7Id The barcode on the package (GTIN).
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7ManufacturedMaterial
	 */
	public void setHl7ManufacturedMaterial(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Material value) {
		this.manufacturedMaterial = value;
	}

	/**
	 * Sets the hl7ManufacturerOrganization Manufacturer of the product.
	 */
	public void setHl7ManufacturerOrganization(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization value) {
		this.manufacturerOrganization = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
