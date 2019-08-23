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

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.840.1.113883.10.12.316
 * Template description: Template CDA RelatedEntity (prototype, directly derived from POCD_RM000040 MIF)
 */
public class CdarelatedEntity {

	public CdarelatedEntity() {
		this.code = createHl7CodeFixedValue();
	// CDARelatedEntity/hl7:code:cs classCode = valueSet("2.16.840.1.113883.1.11.19563"); --> org.ehealth_connector.cda.ch.emed.v0953.enums.PersonalRelationshipRoleType
	}

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.AD> addr = new ArrayList<org.ehealth_connector.common.hl7cdar2.AD>();

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.CE code;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.IVLTS effectiveTime;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Person relatedPerson;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.TEL> telecom = new ArrayList<org.ehealth_connector.common.hl7cdar2.TEL>();

	/**
	 * Adds a hl7Addr
	 */
	public void addHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		addr.add(value);
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void addHl7Telecom(org.ehealth_connector.common.hl7cdar2.TEL value) {
		telecom.add(value);
	}

	/**
	 * Adds a hl7Addr
	 */
	public void clearHl7Addr() {
		addr.clear();
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void clearHl7Telecom() {
		telecom.clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue() {
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
	public void setHl7RelatedPerson(org.ehealth_connector.common.hl7cdar2.POCDMT000040Person value) {
		this.relatedPerson = value;
	}
}
