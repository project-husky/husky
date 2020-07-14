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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.90 Template
 * description: This element describes a problem concern of the patient and
 * indicates the period of time where this concern is active. It contains a set
 * of references to problems related to this concern. In the context of
 * immunization a Problem Concern Entry SHALL be indicated for medical-risks and
 * exposure-risks separately.
 *
 * Element description: This element describes a problem concern of the patient
 * and indicates the period of time where this concern is active. It contains a
 * set of references to problems related to this concern. In the context of
 * immunization a Problem Concern Entry SHALL be indicated for medical-risks and
 * exposure-risks separately.
 */
public class ChpccEntryProblemConcern
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Act {

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param nullFlavor
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue(
			String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
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

	private ArrayList<org.ehealth_connector.common.Code> vocabStatusCodeCode = new ArrayList<org.ehealth_connector.common.Code>();

	public ChpccEntryProblemConcern() {
		super.setClassCode(
				org.ehealth_connector.common.hl7cdar2.XActClassDocumentEntryAct.fromValue("ACT"));
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XDocumentActMood.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.90"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5.1"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.27"));
		super.setCode(createHl7CodeFixedValue("NA"));
		vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("active").build()));
		vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("suspended").build()));
		vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("aborted").build()));
		vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
		super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("SUBJ", "false"));
	}

	/**
	 * Adds a hl7Author The author of the statement SHALL be specified either
	 * here or in one of the ancestors.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7EntryRelationship
	 */
	public void addHl7EntryRelationship(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().add(value);
	}

	/**
	 * Adds a hl7Author The author of the statement SHALL be specified either
	 * here or in one of the ancestors.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7EntryRelationship
	 */
	public void clearHl7EntryRelationship() {
		getEntryRelationship().clear();
	}

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return (org.ehealth_connector.common.hl7cdar2.CE) code;
	}

	/**
	 * Gets the hl7EffectiveTime Indicates the period while the concern was
	 * active.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Id An ID for this item MAY be filled for traceability.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7StatusCode
	 *
	 * - active: A concern that is still being tracked. - suspended: A concern
	 * that is active, but which may be set aside. - aborted: A concern that is
	 * no longer actively being tracked, but for reasons other than because the
	 * problem was resolved. - completed: The problem, allergy or medical state
	 * has been resolved and the concern no longer needs to be tracked except
	 * for historical purposes.
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
	 * Gets the hl7Text Description of the concern (free text). Examples:
	 * 'Hypertension', 'Medical-Risks', 'Exposure-Risks'
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Returns a list of vocab codes as definied in the ART-DECOR model
	 */
	public ArrayList<org.ehealth_connector.common.Code> getVocabStatusCodeCode() {
		return vocabStatusCodeCode;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime Indicates the period while the concern was
	 * active.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7Id An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 *
	 * - active: A concern that is still being tracked. - suspended: A concern
	 * that is active, but which may be set aside. - aborted: A concern that is
	 * no longer actively being tracked, but for reasons other than because the
	 * problem was resolved. - completed: The problem, allergy or medical state
	 * has been resolved and the concern no longer needs to be tracked except
	 * for historical purposes.
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
	 * Sets the hl7Text Description of the concern (free text). Examples:
	 * 'Hypertension', 'Medical-Risks', 'Exposure-Risks'
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
