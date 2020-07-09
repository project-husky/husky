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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.97 Template
 * description: Problem as structured entry (e.g. syptom, complaint, diagnosis
 * etc.)
 *
 * Element description: Problem as structured entry (e.g. syptom, complaint,
 * diagnosis etc.)
 */
public class ChpccEntryProblem
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public ChpccEntryProblem() {
		super.getClassCode().add("OBS");
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.97"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.28"));
		super.setCode(createHl7CodeFixedValue("2.16.840.1.113883.6.96", "SNOMED CT"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
		vocabValueValueSet.add(
				new Code(CodeBaseType.builder().withCodeSystem("2.16.756.5.30.1.126.3.1").build()));
		vocabValueValueSet.add(
				new Code(CodeBaseType.builder().withCodeSystem("2.16.756.5.30.1.126.3.2").build()));
		vocabValueValueSet.add(
				new Code(CodeBaseType.builder().withCodeSystem("2.16.840.1.113883.6.139").build()));
		vocabValueValueSet.add(new Code(CodeBaseType.builder()
				.withCodeSystem("2.16.756.5.30.1.127.3.1.20080401.1").build()));
		vocabValueValueSet.add(
				new Code(CodeBaseType.builder().withCodeSystem("2.16.840.1.113883.6.96").build()));
	}

	private ArrayList<org.ehealth_connector.common.Code> vocabValueValueSet = new ArrayList<org.ehealth_connector.common.Code>();

	/**
	 * Adds a hl7Author The author of the statement SHALL be specified either
	 * here or in one of the ancestors.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7Id Each observation SHALL have an identifier.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Value The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public void addHl7Value(org.ehealth_connector.common.hl7cdar2.CD value) {
		getValue().add(value);
	}

	/**
	 * Adds a hl7Author The author of the statement SHALL be specified either
	 * here or in one of the ancestors.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7Id Each observation SHALL have an identifier.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Adds a hl7Value The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public void clearHl7Value() {
		getValue().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param codeSystem
	 *            the desired fixed value for this argument.
	 * @param codeSystemName
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(
			String codeSystem, String codeSystemName) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
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
	 * Creates fixed contents for CDA Element hl7Value
	 *
	 * @param nullFlavor
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.CD createHl7ValueFixedValue(
			String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD retVal = factory.createCD();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Gets the hl7Code The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime Indicates the time interval over which the
	 * problem is known to be true.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7StatusCode The statusCode shall be set to 'completed' for all
	 * problems.
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
	 * "NAV"
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CD getPredefinedValueNav() {
		return createHl7ValueFixedValue("NAV");
	}

	/**
	 * Returns a list of vocab codes as definied in the ART-DECOR model
	 */
	public ArrayList<org.ehealth_connector.common.Code> getVocabValueValueSet() {
		return vocabValueValueSet;
	}

	/**
	 * Sets the hl7Code The human-readable text MUST be generated automatically
	 * from the structured information of this element. The text element MUST
	 * contain the reference to the corresponding text in the human readable
	 * part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime Indicates the time interval over which the
	 * problem is known to be true.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode The statusCode shall be set to 'completed' for all
	 * problems.
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
