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

import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.22
 * Template description: A laboratory result can be supplemented with any number of previous results, if this information is important. Previous laboratory results MUST be associated to the same patient, the same test, the same procedure, and the same test kit, otherwise they are NOT ALLOWED, here.
 */
public class ChpalmEntryPreviousObservation extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public ChpalmEntryPreviousObservation() {
		super.getClassCode().add("OBS");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.22"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
	// chpalm_entry_PreviousObservation/hl7:observation:cs classCode = "OBS";
	// chpalm_entry_PreviousObservation/hl7:observation:cs moodCode = "EVN";
	// chpalm_entry_PreviousObservation/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.22";
	// chpalm_entry_PreviousObservation/hl7:statusCode:cs valueSet = valueSet("2.16.840.1.113883.1.11.20025"); --> org.ehealth_connector.cda.ch.lrep.v133.enums.ActStatusCompleted
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
	 * MUST contain the same code as the current laboratory result.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp of the findings (physiologically relevant time) of this previous result. Accuracy of the value: Date and time with hour and minute.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7StatusCode
	 * MUST be set to 'completed'.
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
	 * Gets the hl7Value
	 * The previous result obtained for this test.
	 */
	public org.ehealth_connector.common.hl7cdar2.ANY getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.ANY retVal = null;
		if (getValue() != null)
			if (getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.ANY) getValue().get(0);
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
	 * Sets the hl7Code
	 * MUST contain the same code as the current laboratory result.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp of the findings (physiologically relevant time) of this previous result. Accuracy of the value: Date and time with hour and minute.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * MUST be set to 'completed'.
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
	 * Sets the hl7Value
	 * The previous result obtained for this test.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.ANY value) {
		getValue().clear();
		getValue().add(value);
	}
}
