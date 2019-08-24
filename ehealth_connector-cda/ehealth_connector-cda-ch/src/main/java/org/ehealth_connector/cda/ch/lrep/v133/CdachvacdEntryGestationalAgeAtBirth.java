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

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.84
 * Template description: The coded gestational age in days of gestation at birth of a patient. This item is intended to be applied for the child but not for the mother.
 *
 * Element description: The coded gestational age in days of gestation at birth of a patient. This item is intended to be applied for the child but not for the mother.
 */
public class CdachvacdEntryGestationalAgeAtBirth extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public CdachvacdEntryGestationalAgeAtBirth() {
		super.getClassCode().add("OBS");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.84"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.13"));
		super.setCode(createHl7CodeFixedValue("49052-4", "2.16.840.1.113883.6.1", "LOINC", "Gestational age in days"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:observation:cs classCode = "OBS";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:observation:cs moodCode = "EVN";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.84";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.13";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:code:cs code = "49052-4";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:code:oid codeSystem = "2.16.840.1.113883.6.1";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:code:st codeSystemName = "LOINC";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:code:st displayName = "Gestational age in days";
	// cdachvacd_entry_GestationalAgeAtBirth/hl7:statusCode:cs valueSet = valueSet("2.16.840.1.113883.1.11.20025"); --> org.ehealth_connector.cda.ch.lrep.v133.enums.ActStatusCompleted
	}

	@XmlTransient()
	private String myClassCode;

	@XmlTransient()
	private String myMoodCode;

	/**
	 * Adds a hl7Author
	 * This MAY be used to indicate who has documented the observation. This information supersedes any information recorded at higher level.
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7Author
	 * This MAY be used to indicate who has documented the observation. This information supersedes any information recorded at higher level.
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
	 */
	public org.ehealth_connector.common.hl7cdar2.CS createHl7StatusCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CS retVal = factory.createCS();
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
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * Each observation SHALL have an identifier.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7StatusCode
	 * The statusCode SHALL be set to 'completed' for all observations.
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
	 * Gets the hl7Value
	 * The gestational age, recorded in days. Therefore weeks have to be converted to days and back to weeks by the applications.Examples:
	 * - Application --&gt; CDA:37th week and 4th day = 37 * 7 + 4 days = 263 days
	 * - CDA --&gt; application:178 d = 25 weeks and 3 days
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.ANY> getHl7Value() {
		return value;
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
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS ivlts = factory.createIVLTS();
		ivlts.setValue(value.getValue());
		this.effectiveTime = ivlts;
	}

	/**
	 * Sets the hl7Id
	 * Each observation SHALL have an identifier.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 * The statusCode SHALL be set to 'completed' for all observations.
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

	/**
	 * Sets the hl7Value
	 * The gestational age, recorded in days. Therefore weeks have to be converted to days and back to weeks by the applications.Examples:
	 * - Application --&gt; CDA:37th week and 4th day = 37 * 7 + 4 days = 263 days
	 * - CDA --&gt; application:178 d = 25 weeks and 3 days
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.PQ value) {
		getValue().clear();
		getValue().add(value);
	}
}
