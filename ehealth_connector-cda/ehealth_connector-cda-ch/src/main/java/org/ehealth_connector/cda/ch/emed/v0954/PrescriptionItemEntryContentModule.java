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
package org.ehealth_connector.cda.ch.emed.v0954;

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.43 Template
 * description: A Prescription Item belongs to one prescription and represents
 * one prescribed medication. It may be associated with one or more
 * observations. Prescription Item is the atomic entity for logistics,
 * distribution and billing. It contains the prescribed medicine and dosage
 * information as well as other information to the prescribed item such as
 * patient- and fulfillment instructions and substitution handling.
 *
 * Element description: Prescription Item Entry Additional Template ID
 */
public class PrescriptionItemEntryContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public PrescriptionItemEntryContentModule() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("INT"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.43"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7"));
		super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
		// This is fixed content for an optional element:
		// createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1") -->
		// Creating getPredefinedTemplateId136141193761531471();
		// This is fixed content for an optional element:
		// createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.8") -->
		// Creating getPredefinedTemplateId13614119376153148();
		// This is fixed content for an optional element:
		// createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9") -->
		// Creating getPredefinedTemplateId13614119376153149();
		// This is fixed content for an optional element:
		// createHl7EntryRelationshipFixedValue("RSON", null) --> Creating
		// getPredefinedEntryRelationshipRsonNull();
		// This is fixed content for an optional element:
		// createHl7EntryRelationshipFixedValue("REFR", null) --> Creating
		// getPredefinedEntryRelationshipRefrNull();
		// This is fixed content for an optional element:
		// createHl7EntryRelationshipFixedValue("COMP", null) --> Creating
		// getPredefinedEntryRelationshipCompNull();
		// This is fixed content for an optional element:
		// createHl7EntryRelationshipFixedValue("SUBJ", "true") --> Creating
		// getPredefinedEntryRelationshipSubjTrue();
		// This is fixed content for an optional element:
		// createHl7ReferenceFixedValue("XCRPT") --> Creating
		// getPredefinedReferenceXcrpt();
		// This is fixed content for an optional element:
		// createHl7EffectiveTimeFixedValue("A") --> Creating
		// getPredefinedEffectiveTimeA();
		// This is fixed content for an optional element:
		// createHl7RouteCodeFixedValue() --> Creating getPredefinedRouteCode();
	}

	/**
	 * Adds a hl7ApproachSiteCode
	 */
	public void addHl7ApproachSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		getApproachSiteCode().add(value);
	}

	/**
	 * Adds a hl7Reference
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().add(value);
	}

	/**
	 * Adds a hl7ApproachSiteCode
	 */
	public void clearHl7ApproachSiteCode() {
		getApproachSiteCode().clear();
	}

	/**
	 * Adds a hl7Reference
	 */
	public void clearHl7Reference() {
		getReference().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7EffectiveTime
	 *
	 * @param operator
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(
			String operator) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();
		retVal.setOperator(org.ehealth_connector.common.hl7cdar2.SetOperator.fromValue(operator));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7EntryRelationship
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 * @param inversionInd
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(
			String typeCode, String inversionInd) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory
				.createPOCDMT000040EntryRelationship();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship
				.fromValue(typeCode));
		retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Reference
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference createHl7ReferenceFixedValue(
			String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference retVal = factory
				.createPOCDMT000040Reference();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipExternalReference
				.fromValue(typeCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7RouteCode
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7RouteCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7StatusCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CS createHl7StatusCodeFixedValue(
			String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
		retVal.setCode(code);
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

	/**
	 * Gets the hl7Author Prescriber
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author> getHl7Author() {
		return author;
	}

	/**
	 * Gets the hl7Consumable
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return consumable;
	}

	/**
	 * Gets the hl7DoseQuantity
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
		return doseQuantity;
	}

	/**
	 * Gets the hl7EffectiveTime Dosage Instructions PCC 6.3.4.16.10 - Start and
	 * Stop
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.SXCMTS> getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7EntryRelationship Treatment Reason as text
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
		return entryRelationship;
	}

	/**
	 * Gets the hl7Id This ID represents the Prescription Item ID and SHALL be
	 * present.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7Precondition Precondition Criterion
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040Precondition> getHl7Precondition() {
		return precondition;
	}

	/**
	 * Gets the hl7RateQuantity
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLPQ getHl7RateQuantity() {
		return rateQuantity;
	}

	/**
	 * Gets the hl7RepeatNumber Number of repeats/refills
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLINT getHl7RepeatNumber() {
		return repeatNumber;
	}

	/**
	 * Gets the hl7RouteCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7RouteCode() {
		return routeCode;
	}

	/**
	 * Gets the hl7StatusCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7TemplateId CH-PHARM Prescription Item Entry Content Module
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text Narrative Text
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.IVLTS, filled by:
	 * "A"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.IVLTS getPredefinedEffectiveTimeA() {
		return createHl7EffectiveTimeFixedValue("A");
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship,
	 * filled by: "COMP", null
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipCompNull() {
		return createHl7EntryRelationshipFixedValue("COMP", null);
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship,
	 * filled by: "REFR", null
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
		return createHl7EntryRelationshipFixedValue("REFR", null);
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship,
	 * filled by: "RSON", null
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRsonNull() {
		return createHl7EntryRelationshipFixedValue("RSON", null);
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship,
	 * filled by: "SUBJ", "true"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjTrue() {
		return createHl7EntryRelationshipFixedValue("SUBJ", "true");
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference, filled by:
	 * "XCRPT"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference getPredefinedReferenceXcrpt() {
		return createHl7ReferenceFixedValue("XCRPT");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CE, filled by:
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CE getPredefinedRouteCode() {
		return createHl7RouteCodeFixedValue();
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "1.3.6.1.4.1.19376.1.5.3.1.4.7.1"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId136141193761531471() {
		return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "1.3.6.1.4.1.19376.1.5.3.1.4.8"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId13614119376153148() {
		return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.8");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.II, filled by:
	 * "1.3.6.1.4.1.19376.1.5.3.1.4.9"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.II getPredefinedTemplateId13614119376153149() {
		return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9");
	}

	/**
	 * Sets the hl7Author Prescriber
	 */
	public void setHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().clear();
		getAuthor().add(value);
	}

	/**
	 * Sets the hl7Consumable
	 */
	public void setHl7Consumable(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
	}

	/**
	 * Sets the hl7DoseQuantity
	 */
	public void setHl7DoseQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
	}

	/**
	 * Sets the hl7EffectiveTime Dosage Instructions PCC 6.3.4.16.10 - Start and
	 * Stop
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		getEffectiveTime().clear();
		getEffectiveTime().add(value);
	}

	/**
	 * Sets the hl7EntryRelationship Treatment Reason as text
	 */
	public void setHl7EntryRelationship(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().clear();
		getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7Id This ID represents the Prescription Item ID and SHALL be
	 * present.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7Precondition Precondition Criterion
	 */
	public void setHl7Precondition(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Precondition value) {
		getPrecondition().clear();
		getPrecondition().add(value);
	}

	/**
	 * Sets the hl7RateQuantity
	 */
	public void setHl7RateQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.rateQuantity = value;
	}

	/**
	 * Sets the hl7RepeatNumber Number of repeats/refills
	 */
	public void setHl7RepeatNumber(org.ehealth_connector.common.hl7cdar2.IVLINT value) {
		this.repeatNumber = value;
	}

	/**
	 * Sets the hl7RouteCode
	 */
	public void setHl7RouteCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.routeCode = value;
	}

	/**
	 * Sets the hl7StatusCode
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.statusCode = value;
	}

	/**
	 * Sets the hl7TemplateId CH-PHARM Prescription Item Entry Content Module
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text Narrative Text
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
