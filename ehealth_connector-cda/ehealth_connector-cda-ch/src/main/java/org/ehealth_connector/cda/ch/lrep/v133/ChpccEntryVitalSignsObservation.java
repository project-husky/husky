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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.21
 * Template description: Structured notation of a measured value resp. an observation of a single vital sign (such as body height, weight, blood pressure).
 */
public class ChpccEntryVitalSignsObservation extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public ChpccEntryVitalSignsObservation() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.13"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.13.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.31"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.21"));
		codeFixedValue = createHl7CodeFixedValue("2.16.840.1.113883.6.1", "LOINC");
	// chpcc_entry_VitalSignsObservation/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.13";
	// chpcc_entry_VitalSignsObservation/hl7:templateId:uid root = "1.3.6.1.4.1.19376.1.5.3.1.4.13.2";
	// chpcc_entry_VitalSignsObservation/hl7:templateId:uid root = "2.16.840.1.113883.10.20.1.31";
	// chpcc_entry_VitalSignsObservation/hl7:templateId:uid root = "2.16.756.5.30.1.1.10.4.21";
	// chpcc_entry_VitalSignsObservation/hl7:code:cs valueSet = valueSet("2.16.756.5.30.1.1.11.5");
	// chpcc_entry_VitalSignsObservation/hl7:code:oid codeSystem = "2.16.840.1.113883.6.1";
	// chpcc_entry_VitalSignsObservation/hl7:code:st codeSystemName = "LOINC";
	// chpcc_entry_VitalSignsObservation/hl7:statusCode:cs valueSet = valueSet("2.16.840.1.113883.1.11.20025");
	}

	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CD codeFixedValue;

	/**
	 * Adds a hl7InterpretationCode
	 */
	public void addHl7InterpretationCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		getInterpretationCode().add(value);
	}

	/**
	 * Adds a hl7MethodCode
	 */
	public void addHl7MethodCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		getMethodCode().add(value);
	}

	/**
	 * Adds a hl7TargetSiteCode
	 */
	public void addHl7TargetSiteCode(org.ehealth_connector.common.hl7cdar2.CD value) {
		getTargetSiteCode().add(value);
	}

	/**
	 * Adds a hl7InterpretationCode
	 */
	public void clearHl7InterpretationCode() {
		getInterpretationCode().clear();
	}

	/**
	 * Adds a hl7MethodCode
	 */
	public void clearHl7MethodCode() {
		getMethodCode().clear();
	}

	/**
	 * Adds a hl7TargetSiteCode
	 */
	public void clearHl7TargetSiteCode() {
		getTargetSiteCode().clear();
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param codeSystem the desired fixed value for this argument.
	 * @param codeSystemName the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD createHl7CodeFixedValue(String codeSystem, String codeSystemName) {
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
	 * The reference to the text in the narrative section of the section MUST be specified.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
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
	 * The status 'completed' indicates that the observation is final.
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
	 * Gets the hl7Value
	 * According to table in [IHE PCC TF-2], 6.3.4.22.3
	 */
	public org.ehealth_connector.common.hl7cdar2.ANY getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.ANY retVal = null;
		if (getValue() != null)
			if (getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.ANY) getValue().get(0);
		return retVal;
	}

	/**
	 * Sets the hl7Code
	 * The reference to the text in the narrative section of the section MUST be specified.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
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
	 * The status 'completed' indicates that the observation is final.
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
	 * According to table in [IHE PCC TF-2], 6.3.4.22.3
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.ANY value) {
		getValue().clear();
		getValue().add(value);
	}
}
