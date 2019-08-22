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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.47
 * Template description: Reference to Prescription Item
 *
 * Element description: Reference to Prescription Item General Specification
 */
public class PrereferenceEntryContentModule extends org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public PrereferenceEntryContentModule() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("INT"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.11"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.47"));
		super.setCode(createHl7CodeFixedValue("PREItem"));
		super.getReference().add(createHl7ReferenceFixedValue("XCRPT"));
	// PREReferenceEntryContentModule/hl7:substanceAdministration:cs classCode = "SBADM";
	// PREReferenceEntryContentModule/hl7:substanceAdministration:cs moodCode = "INT";
	// PREReferenceEntryContentModule/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.9.1.3.11";
	// PREReferenceEntryContentModule/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.47";
	// Vocab not supported, yet. Should add a code:PREItem / 1.3.6.1.4.1.19376.1.9.2.2
	// PREReferenceEntryContentModule/hl7:code:cs code = "PREItem"; (isVocab)
	// PREReferenceEntryContentModule/hl7:reference:cs typeCode = "XCRPT";
	}

	@XmlTransient()
	private String myClassCode;

	@XmlTransient()
	private String myMoodCode;

	/**
	 * Creates fixed contents for CDA Attribute classCode
	 */
	private void createClassCodeFixedValue(String value) {
		this.myClassCode = value;
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
	 * Creates fixed contents for CDA Attribute moodCode
	 */
	private void createMoodCodeFixedValue(String value) {
		this.myMoodCode = value;
	}

	/**
	 * Gets the hl7Author
	 * Author of the referenced item
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
	 * Reference to Prescription code
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Consumable
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return consumable;
	}

	/**
	 * Gets the hl7Id
	 * Reference to Prescription Item ID
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getId() != null)
			if (getId().size() > 0)
				retVal = getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Reference
	 * ID of parent container of referenced item
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference getHl7Reference() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference retVal = null;
		if (getReference() != null)
			if (getReference().size() > 0)
				retVal = getReference().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7TemplateId
	 * Reference to Prescription Item Template ID
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getTemplateId() != null)
			if (getTemplateId().size() > 0)
				retVal = getTemplateId().get(0);
		return retVal;
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
	 * Sets the hl7Author
	 * Author of the referenced item
	 */
	public void setHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().clear();
		getAuthor().add(value);
	}

	/**
	 * Sets the hl7Code
	 * Reference to Prescription code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Consumable
	 */
	public void setHl7Consumable(org.ehealth_connector.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
	}

	/**
	 * Sets the hl7Id
	 * Reference to Prescription Item ID
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7Reference
	 * ID of parent container of referenced item
	 */
	public void setHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().clear();
		getReference().add(value);
	}

	/**
	 * Sets the hl7TemplateId
	 * Reference to Prescription Item Template ID
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
