/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lrep;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.12
 * Template description: A laboratory report MAY contain information on the reception of the specimen at the laboratory.
 */
public class ChpalmEntrySpecimenReceived extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Act {

	/**
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7Code;

	/**
	 * Timestamp of the specimen reception at the laboratory. Minimum accuracy of the value: Date and time with hour and minute.
	 */
	private org.ehealth_connector.common.hl7cdar2.IVLTS hl7EffectiveTime;

	/**
	 * The delivered identification of specimen at the customer MUST be declared. If specimen identification is not available, nullFlavor='ASKU' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * Gets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * Timestamp of the specimen reception at the laboratory. Minimum accuracy of the value: Date and time with hour and minute.
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * The delivered identification of specimen at the customer MUST be declared. If specimen identification is not available, nullFlavor='ASKU' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7TemplateId1
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId1() {
		return hl7TemplateId1;
	}

	/**
	 * Sets the hl7Code
	 * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * Timestamp of the specimen reception at the laboratory. Minimum accuracy of the value: Date and time with hour and minute.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * The delivered identification of specimen at the customer MUST be declared. If specimen identification is not available, nullFlavor='ASKU' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7TemplateId1
	 */
	public void setHl7TemplateId1(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId1 = value;
	}
}
