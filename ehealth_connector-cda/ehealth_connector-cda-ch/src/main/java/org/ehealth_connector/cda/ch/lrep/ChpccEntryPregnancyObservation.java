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
package org.ehealth_connector.cda.ch.lrep;

import javax.xml.bind.JAXBElement;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.92
 * Template description: This element contains structured information about a pregnancy.
 *
 * Element description: This element contains structured information about a pregnancy.
 */
public class ChpccEntryPregnancyObservation extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public ChpccEntryPregnancyObservation() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.92"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.13.5"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.13"));
		codeFixedValue = createHl7CodeFixedValue("2.16.840.1.113883.6.1", "LOINC");
	}

	private org.ehealth_connector.common.hl7cdar2.CD codeFixedValue;

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
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * Each observation SHALL have an identifier.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getId() != null)
			if (super.getId().size() > 0)
				retVal = super.getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7StatusCode
	 * The statusCode shall be set to 'completed' for all observations.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return super.statusCode;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getTemplateId() != null)
			if (super.getTemplateId().size() > 0)
				retVal = super.getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Value
	 * See [IHE PCC TF-2], Table 6.3.4.25.4-1 Pregnancy Observation Codes
	 */
	public org.ehealth_connector.common.hl7cdar2.ANY getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.ANY retVal = null;
		if (super.getValue() != null)
			if (super.getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.ANY) super.getValue().get(0);
		return retVal;
	}

	/**
	 * Sets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		super.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Date or timestamp of the finding (physiologically relevant time of this observation).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS ivlts = factory.createIVLTS();
		ivlts.setValue(value.getValue());
		super.effectiveTime = ivlts;
	}

	/**
	 * Sets the hl7Id
	 * Each observation SHALL have an identifier.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getId().clear();
		super.getId().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 * The statusCode shall be set to 'completed' for all observations.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.statusCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Value
	 * See [IHE PCC TF-2], Table 6.3.4.25.4-1 Pregnancy Observation Codes
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.ANY value) {
		super.getValue().clear();
		super.getValue().add(value);
	}
}
