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
package org.ehealth_connector.cda.ch.lrep.v133;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.11
 * Template description: Laboratory reports MAY contain information on the specimen. If there are more than one specimen associated to the order, then this item occurs multiple times.
 */
public class ChpalmEntrySpecimenCollection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Procedure {

	public ChpalmEntrySpecimenCollection() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.11"));
		codeFixedValue = createHl7CodeFixedValue("33882-2", "2.16.840.1.113883.6.1", "LOINC", "Collection date of Unspecified specimen");
	// chpalm_entry_SpecimenCollection/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.1.2";
	// chpalm_entry_SpecimenCollection/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.11";
	// chpalm_entry_SpecimenCollection/hl7:code:cs code = "33882-2";
	// chpalm_entry_SpecimenCollection/hl7:code:oid codeSystem = "2.16.840.1.113883.6.1";
	// chpalm_entry_SpecimenCollection/hl7:code:st codeSystemName = "LOINC";
	// chpalm_entry_SpecimenCollection/hl7:code:st displayName = "Collection date of Unspecified specimen";
	// chpalm_entry_SpecimenCollection/hl7:effectiveTime:cs nullFlavor = "UNK";
	// chpalm_entry_SpecimenCollection/hl7:targetSiteCode:oid codeSystem = "2.16.840.1.113883.5.1052";
	// chpalm_entry_SpecimenCollection/hl7:targetSiteCode:st codeSystemName = "ActSite";
	// chpalm_entry_SpecimenCollection/hl7:entryRelationship:cs typeCode = "COMP";
	// chpalm_entry_SpecimenCollection/hl7:entryRelationship:cs typeCode = "COMP";
	}

	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CD codeFixedValue;

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param code the desired fixed value for this argument.
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 * @param displayName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7EffectiveTime
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7EntryRelationship
	 *
	 * @param typeCode the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
		retVal.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TargetSiteCode
	 *
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7TargetSiteCodeFixedValue(String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		return retVal;
	}

	/**
	 * Creates fixed contents for hl7TemplateId
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
	 * Gets the member codeFixedValue
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getCodeFixedValue() {
		return codeFixedValue;
	}

	/**
	 * Gets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7EntryRelationship
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
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
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getId() != null)
			if (getId().size() > 0)
				retVal = getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Participant
	 * The information on the specimen MUST be declared.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 getHl7Participant() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 retVal = null;
		if (getParticipant() != null)
			if (getParticipant().size() > 0)
				retVal = getParticipant().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Performer
	 * This can be used to specify who performed the specimen collection.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 getHl7Performer() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 retVal = null;
		if (getPerformer() != null)
			if (getPerformer().size() > 0)
				retVal = getPerformer().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7TargetSiteCode
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7TargetSiteCode() {
		org.ehealth_connector.common.hl7cdar2.CD retVal = null;
		if (getTargetSiteCode() != null)
			if (getTargetSiteCode().size() > 0)
				retVal = getTargetSiteCode().get(0);
		return retVal;
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
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Sets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp (e.g., for simple blood sampling) or period (e.g., 24 hour urine test) of the specimen collection or specimen creation.
	 * - Timestamp: Is declared using @value. Minimum accuracy of the value: Date (the time of the day is OPTIONAL).
	 * - Period: Is declared using low/@value and high/@value. Accuracy of the value: Date and time with hour and minute.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7EntryRelationship
	 * This MAY be used to indicate when the sample has arrived at the laboratory.
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().clear();
		getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7Participant
	 * The information on the specimen MUST be declared.
	 */
	public void setHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		getParticipant().clear();
		getParticipant().add(value);
	}

	/**
	 * Sets the hl7Performer
	 * This can be used to specify who performed the specimen collection.
	 */
	public void setHl7Performer(org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		getPerformer().clear();
		getPerformer().add(value);
	}

	/**
	 * Sets the hl7TargetSiteCode
	 * This CAN be used to indicate the anatomical position of the specimen collection. This is particularly relevant in microbiology (e.g., when the sample was removed with a swab from the left foot). The HL7 vocabulary ActSite contains anatomical locations of organisms that may be at the center of the action.
	 */
	public void setHl7TargetSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		getTargetSiteCode().clear();
		getTargetSiteCode().add(value);
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
