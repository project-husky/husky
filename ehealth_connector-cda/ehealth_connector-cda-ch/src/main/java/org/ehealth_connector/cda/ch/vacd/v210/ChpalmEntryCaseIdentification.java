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

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.15 Template
 * description: If an examination belongs to a specific case, this CAN be
 * documented with this element (in the Notification Organizer).
 */
public class ChpalmEntryCaseIdentification
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	public ChpalmEntryCaseIdentification() {
		super.getClassCode().add("CASE");
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.15"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.1.2"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
	}

	/**
	 * Adds a hl7Id The number of the case to which the examinations belong in
	 * this section MUST be declared. Multiple case numbers CAN be specified.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id The number of the case to which the examinations belong in
	 * this section MUST be declared. Multiple case numbers CAN be specified.
	 */
	public void clearHl7Id() {
		getId().clear();
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
	 * Gets the hl7Code The type of the case MUST be declared with a code. LOINC
	 * (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or
	 * values from the HL7 vocabulary ObservationType
	 * (2.16.840.1.113883.1.11.16226) SHOULD be used.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return (org.ehealth_connector.common.hl7cdar2.CE) code;
	}

	/**
	 * Gets the hl7EffectiveTime MAY contain the period of validity of the case.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7StatusCode The status 'completed' means the patient has been
	 * associated with the given case number.The status 'aborted' means the
	 * patient was associated with the case number in error.
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
	 * Gets the hl7Value A not further specified precision of the case MUST be
	 * declared according to XD-LAB with data type 'CE'. If no further precision
	 * is known, nullFavor='UNK' MUST be used.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.ANY> getHl7Value() {
		return value;
	}

	/**
	 * Sets the hl7Code The type of the case MUST be declared with a code. LOINC
	 * (2.16.840.1.113883.6.1) or SNOMED CT (2.16.840.1.113883.6.96) codes or
	 * values from the HL7 vocabulary ObservationType
	 * (2.16.840.1.113883.1.11.16226) SHOULD be used.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime MAY contain the period of validity of the case.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode The status 'completed' means the patient has been
	 * associated with the given case number.The status 'aborted' means the
	 * patient was associated with the case number in error.
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
	 * Sets the hl7Value A not further specified precision of the case MUST be
	 * declared according to XD-LAB with data type 'CE'. If no further precision
	 * is known, nullFavor='UNK' MUST be used.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.CE value) {
		getValue().clear();
		getValue().add(value);
	}
}
