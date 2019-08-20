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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.86
 * Template description: Coding of a significant pathogen.
 */
public class CdachlrepEntryNotifiableConditionSignificantPathogen extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public CdachlrepEntryNotifiableConditionSignificantPathogen() {
		super.getClassCode().add("COND");
		super.setMoodCode(org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.86"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.14"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.1.1"));
		super.setCode(createHl7CodeFixedValue("170516003", "2.16.840.1.113883.6.96", "SNOMED CT", "Notification of disease"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
		super.getValue().add(createHl7ValueFixedValue("NA"));
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:observation:cs classCode = "COND";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:observation:cs moodCode = "EVN";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.86";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.14";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.3.1.1.1";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:code:cs code = "170516003";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:code:oid codeSystem = "2.16.840.1.113883.6.96";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:code:st codeSystemName = "SNOMED CT";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:code:st displayName = "Notification of disease";
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:statusCode:cs valueSet = valueSet("1.3.6.1.4.1.19376.1.3.11.2");
	// cdachlrep_entry_NotifiableConditionSignificantPathogen/hl7:value:cs nullFlavor = "NA";
	}

	@XmlTransient()
	private String myClassCode;

	@XmlTransient()
	private String myMoodCode;

	/**
	 * Adds a hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void clearHl7Id() {
		getId().clear();
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
	 * Creates fixed contents for CDA Element hl7Value
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7ValueFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
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
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp of the sampling.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means the patient has been associated with the given notifiable condition.The status 'aborted' means the patient was associated with the notifiable condition in error.
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
	 * A code that defines the reportable state MUST be specified. If no code is known, nullFlavor='NA' MUST be used.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.CE retVal = null;
		if (getValue() != null)
			if (getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.CE) getValue().get(0);
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
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp of the sampling.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means the patient has been associated with the given notifiable condition.The status 'aborted' means the patient was associated with the notifiable condition in error.
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
	 * A code that defines the reportable state MUST be specified. If no code is known, nullFlavor='NA' MUST be used.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.CE value) {
		getValue().clear();
		getValue().add(value);
	}
}
