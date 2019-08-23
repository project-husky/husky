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

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.42
 * Template description: A Dispense Item belongs to one Dispensation and represents one dispensed medication. It contains the dispensed medicinal product including information such as product code, brand name and packaging information.
 */
public class DispenseItemEntryContentModule extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Supply {

	public DispenseItemEntryContentModule() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.42"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.3"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.34"));
		super.setCode(createHl7CodeFixedValue());
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("SUBJ", "true"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("SUBJ", "true"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getReference().add(createHl7ReferenceFixedValue("XCRPT"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
	// DispenseItemEntryContentModule/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.42";
	// DispenseItemEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.9.1.3.4";
	// DispenseItemEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.7.3";
	// DispenseItemEntryContentModule/hl7:templateId:uid root = "2.16.840.1.113883.10.20.1.34";
	// DispenseItemEntryContentModule/hl7:code:cs valueSet = valueSet("2.16.756.5.30.1.127.77.4.11.7"); --> org.ehealth_connector.cda.ch.emed.v0953.enums.DispenseSupplyType
	// DispenseItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// DispenseItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// DispenseItemEntryContentModule/hl7:entryRelationship:null typeCode = "REFR";
	// DispenseItemEntryContentModule/hl7:entryRelationship:cs typeCode = "SUBJ";
	// DispenseItemEntryContentModule/hl7:entryRelationship:bl inversionInd = "true";
	// DispenseItemEntryContentModule/hl7:entryRelationship:null typeCode = "SUBJ";
	// DispenseItemEntryContentModule/hl7:entryRelationship:null inversionInd = "true";
	// DispenseItemEntryContentModule/hl7:entryRelationship:null typeCode = "COMP";
	// DispenseItemEntryContentModule/hl7:reference:null typeCode = "XCRPT";
	// DispenseItemEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// DispenseItemEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// DispenseItemEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	}

	/**
	 * Adds a hl7Reference
	 * ID of parent container (Community Dispense document)
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().add(value);
	}

	/**
	 * Adds a hl7Reference
	 * ID of parent container (Community Dispense document)
	 */
	public void clearHl7Reference() {
		getReference().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7EntryRelationship
	 *
	 * @param typeCode the desired fixed value for this argument.
	 * @param inversionInd the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
		retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Reference
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference createHl7ReferenceFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference retVal = factory.createPOCDMT000040Reference();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipExternalReference.fromValue(typeCode));
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
	 * Gets the hl7Author
	 * Dispenser
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Author getHl7Author() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Author retVal = null;
		if (getAuthor() != null)
			if (getAuthor().size() > 0)
				retVal = getAuthor().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 * Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EntryRelationship
	 * If the dispense is related to a Medication Treatment Plan Item, the reference to it SHALL be present.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getHl7EntryRelationship() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = null;
		if (getEntryRelationship() != null)
			if (getEntryRelationship().size() > 0)
				retVal = getEntryRelationship().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Id
	 * Dispense Item ID
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getId() != null)
			if (getId().size() > 0)
				retVal = getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Product
	 * Product
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Product getHl7Product() {
		return product;
	}

	/**
	 * Gets the hl7Quantity
	 * Quantity Value
	 */
	public org.ehealth_connector.common.hl7cdar2.PQ getHl7Quantity() {
		return quantity;
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
	 * Gets the hl7Text
	 * Narrative Text
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Sets the hl7Author
	 * Dispenser
	 */
	public void setHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().clear();
		getAuthor().add(value);
	}

	/**
	 * Sets the hl7Code
	 * Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EntryRelationship
	 * If the dispense is related to a Medication Treatment Plan Item, the reference to it SHALL be present.
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().clear();
		getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7Id
	 * Dispense Item ID
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7Product
	 * Product
	 */
	public void setHl7Product(org.ehealth_connector.common.hl7cdar2.POCDMT000040Product value) {
		this.product = value;
	}

	/**
	 * Sets the hl7Quantity
	 * Quantity Value
	 */
	public void setHl7Quantity(org.ehealth_connector.common.hl7cdar2.PQ value) {
		this.quantity = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 * Narrative Text
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
