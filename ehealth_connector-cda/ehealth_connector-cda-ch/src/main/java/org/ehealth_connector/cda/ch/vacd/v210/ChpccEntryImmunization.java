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
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.89 Template
 * description: An immunizations entry is used to record the patient's
 * immunization history. An immunization is a substance administration event. An
 * immunization entry may also be used to report a specific immunization that
 * was not performed (e.g. undesired immunization). In this case, negationInd
 * shall be set to "true", otherwise, it shall be "false".
 *
 * Element description: An immunizations entry is used to record the patient's
 * immunization history. An immunization is a substance administration event. An
 * immunization entry may also be used to report a specific immunization that
 * was not performed (e.g. undesired immunization). In this case, negationInd
 * shall be set to "true", otherwise, it shall be "false".
 */
public class ChpccEntryImmunization
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public ChpccEntryImmunization() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.89"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.12"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
		super.setPriorityCode(createHl7PriorityCodeFixedValue());
		super.setRouteCode(createHl7RouteCodeFixedValue());
		vocabApproachSiteCodeCode.add(new Code(
				CodeBaseType.builder().withCode("null").withCodeSystem("2.16.840.1.113883.5.1052")
						.withCodeSystemName("null").withDisplayName("null").build()));
		super.setConsumable(createHl7ConsumableFixedValue("CSM"));
		// vocab code list entry for attribute code / element
		// hl7:approachSiteCode: no code !! / 2.16.840.1.113883.5.1052
		// ---
	}

	private ArrayList<org.ehealth_connector.common.Code> vocabApproachSiteCodeCode = new ArrayList<org.ehealth_connector.common.Code>();

	/**
	 * Adds a hl7ApproachSiteCode If laterility of the administration is known,
	 * it MAY be recorded according to the HL7 value set.Recommendation for
	 * eVACDOC: omit
	 */
	public void addHl7ApproachSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		getApproachSiteCode().add(value);
	}

	/**
	 * Adds a hl7Author The author of the statement SHALL be specified either
	 * here or in one of the ancestors.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7EntryRelationship Immunization series number, if applicable.
	 */
	public void addHl7EntryRelationship(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().add(value);
	}

	/**
	 * Adds a hl7Performer This MAY be used to indicate who has administered the
	 * immunization.
	 */
	public void addHl7Performer(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		getPerformer().add(value);
	}

	/**
	 * Adds a hl7Precondition Recommendation-Category according to the swiss
	 * vaccination plan.
	 */
	public void addHl7Precondition(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Precondition value) {
		getPrecondition().add(value);
	}

	/**
	 * Adds a hl7ApproachSiteCode If laterility of the administration is known,
	 * it MAY be recorded according to the HL7 value set.Recommendation for
	 * eVACDOC: omit
	 */
	public void clearHl7ApproachSiteCode() {
		getApproachSiteCode().clear();
	}

	/**
	 * Adds a hl7Author The author of the statement SHALL be specified either
	 * here or in one of the ancestors.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7EntryRelationship Immunization series number, if applicable.
	 */
	public void clearHl7EntryRelationship() {
		getEntryRelationship().clear();
	}

	/**
	 * Adds a hl7Performer This MAY be used to indicate who has administered the
	 * immunization.
	 */
	public void clearHl7Performer() {
		getPerformer().clear();
	}

	/**
	 * Adds a hl7Precondition Recommendation-Category according to the swiss
	 * vaccination plan.
	 */
	public void clearHl7Precondition() {
		getPrecondition().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 * @param codeSystem
	 *            the desired fixed value for this argument.
	 * @param codeSystemName
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String code,
			String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Consumable
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable createHl7ConsumableFixedValue(
			String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable retVal = factory
				.createPOCDMT000040Consumable();
		retVal.getTypeCode().add(typeCode);
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
	 * Creates fixed contents for CDA Element hl7PriorityCode
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7PriorityCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
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
	 */
	private static org.ehealth_connector.common.hl7cdar2.CS createHl7StatusCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
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
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Consumable Vaccine
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return consumable;
	}

	/**
	 * Gets the hl7DoseQuantity If dose quantity of the administration is known,
	 * it MAY be recorded according to the recommendations in the addendum
	 * "Darstellung Medikation" to the German "Arztbrief".Recommendation for
	 * eVACDOC: @nullFlavor='UNK'
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
		return doseQuantity;
	}

	/**
	 * Gets the hl7EffectiveTime Date of the immunization.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.SXCMTS> getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Id Immunization event ID, assigned by the software
	 * application.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7PriorityCode If the priority for the immunization is known,
	 * the code MAY be drawn from the HL7 value set.Recommendation for
	 * eVACDOC: @nullFlavor='UNK'
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7PriorityCode() {
		return priorityCode;
	}

	/**
	 * Gets the hl7RouteCode If the route of administration is known, the code
	 * MAY be drawn from the HL7 value set.Recommendation for
	 * eVACDOC: @nullFlavor='NA'
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7RouteCode() {
		return routeCode;
	}

	/**
	 * Gets the hl7StatusCode The statusCode shall be set to 'completed' for all
	 * immunizations.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7TemplateId
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
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CD, filled by:
	 * "2.16.840.1.113883.6.96", "SNOMED CT", null
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CD getPredefinedCode2168401113883696SnomedCtNull() {
		return createHl7CodeFixedValue("2.16.840.1.113883.6.96", "SNOMED CT", null);
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CD, filled by:
	 * "IMMUNIZ", "2.16.840.1.113883.5.4", "ActCode"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CD getPredefinedCodeImmuniz216840111388354ActCode() {
		return createHl7CodeFixedValue("IMMUNIZ", "2.16.840.1.113883.5.4", "ActCode");
	}

	/**
	 * Adds a predefined
	 * org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship,
	 * filled by: "CAUS", null
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipCausNull() {
		return createHl7EntryRelationshipFixedValue("CAUS", null);
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
	 * filled by: "SUBJ", null
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjNull() {
		return createHl7EntryRelationshipFixedValue("SUBJ", null);
	}

	/**
	 * Returns a list of vocab codes as definied in the ART-DECOR model
	 */
	public ArrayList<org.ehealth_connector.common.Code> getVocabApproachSiteCodeCode() {
		return vocabApproachSiteCodeCode;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Consumable Vaccine
	 */
	public void setHl7Consumable(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
	}

	/**
	 * Sets the hl7DoseQuantity If dose quantity of the administration is known,
	 * it MAY be recorded according to the recommendations in the addendum
	 * "Darstellung Medikation" to the German "Arztbrief".Recommendation for
	 * eVACDOC: @nullFlavor='UNK'
	 */
	public void setHl7DoseQuantity(org.ehealth_connector.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
	}

	/**
	 * Sets the hl7EffectiveTime Date of the immunization.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.SXCMTS value) {
		getEffectiveTime().clear();
		getEffectiveTime().add(value);
	}

	/**
	 * Sets the hl7Id Immunization event ID, assigned by the software
	 * application.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7PriorityCode If the priority for the immunization is known,
	 * the code MAY be drawn from the HL7 value set.Recommendation for
	 * eVACDOC: @nullFlavor='UNK'
	 */
	public void setHl7PriorityCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.priorityCode = value;
	}

	/**
	 * Sets the hl7RouteCode If the route of administration is known, the code
	 * MAY be drawn from the HL7 value set.Recommendation for
	 * eVACDOC: @nullFlavor='NA'
	 */
	public void setHl7RouteCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.routeCode = value;
	}

	/**
	 * Sets the hl7StatusCode The statusCode shall be set to 'completed' for all
	 * immunizations.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.statusCode = value;
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
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
