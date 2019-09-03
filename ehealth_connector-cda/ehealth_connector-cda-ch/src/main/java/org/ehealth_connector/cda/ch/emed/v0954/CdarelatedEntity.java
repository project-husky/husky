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
package org.ehealth_connector.cda.ch.emed.v0954;

import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.840.1.113883.10.12.316 Template
 * description: Template CDA RelatedEntity (prototype, directly derived from
 * POCD_RM000040 MIF)
 */
public class CdarelatedEntity
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedEntity {

	public CdarelatedEntity() {
		// This is fixed content for an optional element:
		// createHl7CodeFixedValue() --> Creating getPredefinedCode();
	}

	/**
	 * Adds a hl7Addr
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		getAddr().add(value);
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		getTelecom().add(value);
	}

	/**
	 * Adds a hl7Addr
	 */
	public void clearHl7Addr() {
		getAddr().clear();
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void clearHl7Telecom() {
		getTelecom().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 */
	private static org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7RelatedPerson
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Person getHl7RelatedPerson() {
		return relatedPerson;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.CE, filled by:
	 * 
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.CE getPredefinedCode() {
		return createHl7CodeFixedValue();
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7RelatedPerson
	 */
	public void setHl7RelatedPerson(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Person value) {
		this.relatedPerson = value;
	}
}
