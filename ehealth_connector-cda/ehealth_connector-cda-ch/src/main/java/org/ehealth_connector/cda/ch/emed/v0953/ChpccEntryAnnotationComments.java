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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.2
 * Template description: This entry allows for a comment to be supplied with each entry.
 *
 * Element description: A comment to the parent entry.
 */
public class ChpccEntryAnnotationComments extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Act {

	public ChpccEntryAnnotationComments() {
		super.setClassCode(org.ehealth_connector.common.hl7cdar2.XActClassDocumentEntryAct.fromValue("ACT"));
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XDocumentActMood.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.40"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.2"));
		super.setCode(createHl7CodeFixedValue("48767-8", "2.16.840.1.113883.6.1", "LOINC", "Annotation comment"));
		super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
	// chpcc_entry_AnnotationComments/hl7:act:cs classCode = "ACT";
	// chpcc_entry_AnnotationComments/hl7:act:cs moodCode = "EVN";
	// chpcc_entry_AnnotationComments/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.2";
	// chpcc_entry_AnnotationComments/hl7:templateId:uid root = "2.16.840.1.113883.10.20.1.40";
	// chpcc_entry_AnnotationComments/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.2";
	// chpcc_entry_AnnotationComments/hl7:code:cs code = "48767-8";
	// chpcc_entry_AnnotationComments/hl7:code:oid codeSystem = "2.16.840.1.113883.6.1";
	// chpcc_entry_AnnotationComments/hl7:code:st codeSystemName = "LOINC";
	// chpcc_entry_AnnotationComments/hl7:code:st displayName = "Annotation comment";
	// chpcc_entry_AnnotationComments/hl7:statusCode:cs valueSet = valueSet("2.16.840.1.113883.1.11.20025"); --> org.ehealth_connector.cda.ch.emed.v0953.enums.ActStatusCompleted
	// chpcc_entry_AnnotationComments/hl7:statusCode:cs code = "completed";
	}

	@XmlTransient()
	private String myClassCode;

	@XmlTransient()
	private String myMoodCode;

	/**
	 * Adds a hl7Author
	 * The author of the comment MAY be specified.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7Author
	 * The author of the comment MAY be specified.
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

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
	 * Gets the hl7Code
	 * The reference to the text in the narrative section of the section MUST be specified.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
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
	 * Gets the hl7StatusCode
	 * The status 'completed' indicates that the comment is final.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return statusCode;
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
	 * Sets the hl7Code
	 * The reference to the text in the narrative section of the section MUST be specified.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
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
	 * Sets the hl7StatusCode
	 * The status 'completed' indicates that the comment is final.
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
