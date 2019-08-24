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

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.34
 * Template description: A medication treatment plan item is an entity describing a medication included in the medication treatment plan of the patient. See also<a href="http://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_MTP.pdf">IHE Pharmacy MTP Suppl</a>
 *
 * Element description: 6.3.4.E1.3.1 Medication Treatment Plan Item Entry General Specification
 */
public class MedicationTreatmentPlanEntryContentModule extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public MedicationTreatmentPlanEntryContentModule() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("INT"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.34"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.7"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.8"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9"));
		super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("RSON", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("RSON", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("SUBJ", "true"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("SUBJ", "true"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getReference().add(createHl7ReferenceFixedValue("XCRPT"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getEffectiveTime().add(createHl7EffectiveTimeFixedValue("A"));
		super.getEffectiveTime().add(createHl7EffectiveTimeFixedValue("A"));
		super.setRouteCode(createHl7RouteCodeFixedValue());
	// MedicationTreatmentPlanEntryContentModule/hl7:substanceAdministration:cs classCode = "SBADM";
	// MedicationTreatmentPlanEntryContentModule/hl7:substanceAdministration:cs moodCode = "INT";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.34";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.9.1.3.7";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "2.16.840.1.113883.10.20.1.24";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.7";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.7.1";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.8";
	// MedicationTreatmentPlanEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.9";
	// MedicationTreatmentPlanEntryContentModule/hl7:statusCode:null code = "completed";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "RSON";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "RSON";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "SUBJ";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:bl inversionInd = "true";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "SUBJ";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:bl inversionInd = "true";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// MedicationTreatmentPlanEntryContentModule/hl7:reference:cs typeCode = "XCRPT";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// MedicationTreatmentPlanEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	}

	@XmlTransient()
	private String myClassCode;

	@XmlTransient()
	private String myMoodCode;

	@XmlTransient()
	private String myTypeCode;

	/**
	 * Adds a hl7ApproachSiteCode
	 */
	public void addHl7ApproachSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		getApproachSiteCode().add(value);
	}

	/**
	 * Adds a hl7ApproachSiteCode
	 */
	public void clearHl7ApproachSiteCode() {
		getApproachSiteCode().clear();
	}

	/**
	 * Creates fixed contents for CDA Attribute classCode
	 */
	private void createClassCodeFixedValue(String value) {
		this.myClassCode = value;
	}

	/**
	 * Creates fixed contents for CDA Element hl7EffectiveTime
	 *
	 * @param operator the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(String operator) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();
		retVal.setOperator(org.ehealth_connector.common.hl7cdar2.SetOperator.fromValue(operator));
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
	 * Creates fixed contents for CDA Element hl7RouteCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7RouteCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7StatusCode
	 *
	 * @param code the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
		retVal.setCode(code);
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
	 * Creates fixed contents for CDA Attribute moodCode
	 */
	private void createMoodCodeFixedValue(String value) {
		this.myMoodCode = value;
	}

	/**
	 * Creates fixed contents for CDA Attribute typeCode
	 */
	private void createTypeCodeFixedValue(String value) {
		this.myTypeCode = value;
	}

	/**
	 * Gets the hl7Author
	 * Medication Treatment Plan Author
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
	 * Gets the hl7EffectiveTime
	 * Dosage Instructions PCC 6.3.4.16.10 - Start and Stop
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.SXCMTS> getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7EntryRelationship
	 * IHE MTP Reason. Referencing to the Treatment Reason Entry Content Module below (required by IHE PHARM)
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
		return entryRelationship;
	}

	/**
	 * Gets the hl7Id
	 * Medication Treatment Plan Item ID
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7Precondition
	 * Precondition Criterion
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
	 * Gets the hl7Reference
	 * ID of parent container (Community Medication Treatment Plan document)
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
		return reference;
	}

	/**
	 * Gets the hl7RouteCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7RouteCode() {
		return routeCode;
	}

	/**
	 * Gets the hl7StatusCode
	 * Status Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7TemplateId
	 * CH-PHARM Medication Treatment Plan Item Entry Content Module
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Gets the member myClassCode
	 */
	public String getPredefinedClassCode() {
		return myClassCode;
	}

	/**
	 * Gets the member myMoodCode
	 */
	public String getPredefinedMoodCode() {
		return myMoodCode;
	}

	/**
	 * Gets the member myTypeCode
	 */
	public String getPredefinedTypeCode() {
		return myTypeCode;
	}

	/**
	 * Sets the hl7Author
	 * Medication Treatment Plan Author
	 */
	public void setHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().clear();
		getAuthor().add(value);
	}

	/**
	 * Sets the hl7Consumable
	 */
	public void setHl7Consumable(org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
	}

	/**
	 * Sets the hl7DoseQuantity
	 */
	public void setHl7DoseQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Dosage Instructions PCC 6.3.4.16.10 - Start and Stop
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		getEffectiveTime().clear();
		getEffectiveTime().add(value);
	}

	/**
	 * Sets the hl7EntryRelationship
	 * IHE MTP Reason. Referencing to the Treatment Reason Entry Content Module below (required by IHE PHARM)
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().clear();
		getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7Id
	 * Medication Treatment Plan Item ID
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7Precondition
	 * Precondition Criterion
	 */
	public void setHl7Precondition(org.ehealth_connector.common.hl7cdar2.POCDMT000040Precondition value) {
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
	 * Sets the hl7Reference
	 * ID of parent container (Community Medication Treatment Plan document)
	 */
	public void setHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().clear();
		getReference().add(value);
	}

	/**
	 * Sets the hl7RouteCode
	 */
	public void setHl7RouteCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.routeCode = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * Status Code
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.statusCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 * CH-PHARM Medication Treatment Plan Item Entry Content Module
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
