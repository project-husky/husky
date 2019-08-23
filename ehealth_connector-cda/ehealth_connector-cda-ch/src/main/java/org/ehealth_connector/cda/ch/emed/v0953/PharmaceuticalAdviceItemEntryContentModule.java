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

import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.44
 * Template description: A Pharmaceutical Advice Item belongs to one Pharmaceutical Advice and represents the validation outcome or management command regarding the referenced Medication Treatment Plan-, Prescription- or Dispense Item (e.g., change, cancel, etc.).
 */
public class PharmaceuticalAdviceItemEntryContentModule extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public PharmaceuticalAdviceItemEntryContentModule() {
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.44"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.3"));
		super.setCode(createHl7CodeFixedValue("COMMENT"));
		super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", null));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", "false"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", "false"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", "false"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("REFR", "false"));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP", null));
		super.getReference().add(createHl7ReferenceFixedValue("XCRPT"));
	// PharmaceuticalAdviceItemEntryContentModule/hl7:observation:cs moodCode = "EVN";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.44";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.9.1.3.3";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:code:cs code = "COMMENT"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:code:cs code = "COMMENT"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:code:cs code = "COMMENT"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:code:cs code = "COMMENT"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:code:cs code = "COMMENT"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:code:cs code = "COMMENT"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:statusCode:cs code = "completed"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:statusCode:cs code = "completed"; (isVocab)
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:bl inversionInd = "false";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:null typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:null inversionInd = "false";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:null typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:null inversionInd = "false";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:cs typeCode = "REFR";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:bl inversionInd = "false";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:entryRelationship:cs typeCode = "COMP";
	// PharmaceuticalAdviceItemEntryContentModule/hl7:reference:null typeCode = "XCRPT";
	}

	@XmlTransient()
	private String myMoodCode;

	/**
	 * Adds a hl7Id
	 * Pharmaceutical Advice Item ID
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Reference
	 * ID of parent container (Community Pharmaceutical Advice document)
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().add(value);
	}

	/**
	 * Adds a hl7Id
	 * Pharmaceutical Advice Item ID
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Adds a hl7Reference
	 * ID of parent container (Community Pharmaceutical Advice document)
	 */
	public void clearHl7Reference() {
		getReference().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCode(code);
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
	 * Gets the hl7Author
	 * Pharmaceutical Adviser
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
	 * Observation Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Effective Time (Date of becoming effective)
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7EntryRelationship
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getHl7EntryRelationship() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = null;
		if (getEntryRelationship() != null)
			if (getEntryRelationship().size() > 0)
				retVal = getEntryRelationship().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7StatusCode
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
	}

	/**
	 * Gets the hl7TemplateId
	 * CH-PHARM-PharmaceuticalAdviceItemEntryContentModule
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
	 * Gets the member myMoodCode
	 */
	public String getPredefinedMoodCode() {
		return myMoodCode;
	}

	/**
	 * Sets the hl7Author
	 * Pharmaceutical Adviser
	 */
	public void setHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().clear();
		getAuthor().add(value);
	}

	/**
	 * Sets the hl7Code
	 * Observation Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Effective Time (Date of becoming effective)
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7EntryRelationship
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().clear();
		getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		this.statusCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 * CH-PHARM-PharmaceuticalAdviceItemEntryContentModule
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
