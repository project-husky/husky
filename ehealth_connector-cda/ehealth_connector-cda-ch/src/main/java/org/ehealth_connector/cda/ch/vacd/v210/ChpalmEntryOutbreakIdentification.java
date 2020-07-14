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

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.16 Template
 * description: If an examination falls under the category "accumulation of
 * observations" or "specific epidemiologically relevant event", this CAN be
 * declared in the CDA body using this element.Precise specification on the
 * usage of this element is documented in the specification "Laboratory reports
 * for public health (CDA-CH-LRPH)"
 */
public class ChpalmEntryOutbreakIdentification
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

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
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7ValueFixedValue(
			String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	public ChpalmEntryOutbreakIdentification() {
		super.getClassCode().add("OUTB");
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XActMoodDocumentObservation.fromValue("EVN"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.16"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.1.3"));
		super.setStatusCode(createHl7StatusCodeFixedValue());
		super.getValue().add(createHl7ValueFixedValue("NA"));
	}

	/**
	 * Adds a hl7Id An ID for this item CAN be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id An ID for this item CAN be filled for traceability.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Gets the hl7Code A code that defines the 'outbreak' MUST be
	 * specified.Note:The SNOMED-CT code 416534008 (Outbreak) has been defined
	 * for reportable laboratory findings in Switzerland.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime Timestamp or period of the outbreak.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7StatusCode The status 'completed' means the patient has been
	 * associated with the given outbreak.
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
	 * Gets the hl7Value A code that defines the 'outbreak' condition MUST be
	 * specified. If no code is known, nullFlavor='NA' MUST be used.Note:For
	 * reportable laboratory findings in Switzerland, nullFlavor = 'NA' MUST
	 * MUST be used.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.ANY> getHl7Value() {
		return value;
	}

	/**
	 * Sets the hl7Code A code that defines the 'outbreak' MUST be
	 * specified.Note:The SNOMED-CT code 416534008 (Outbreak) has been defined
	 * for reportable laboratory findings in Switzerland.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime Timestamp or period of the outbreak.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7StatusCode The status 'completed' means the patient has been
	 * associated with the given outbreak.
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
	 * Sets the hl7Value A code that defines the 'outbreak' condition MUST be
	 * specified. If no code is known, nullFlavor='NA' MUST be used.Note:For
	 * reportable laboratory findings in Switzerland, nullFlavor = 'NA' MUST
	 * MUST be used.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.CE value) {
		getValue().clear();
		getValue().add(value);
	}
}
