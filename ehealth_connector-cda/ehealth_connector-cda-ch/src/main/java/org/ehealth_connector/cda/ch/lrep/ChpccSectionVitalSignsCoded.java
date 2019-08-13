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
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.4
 * Template description: This section contains a list of measured / observed vital signs.
 *
 * Element description: This section contains a list of measured / observed vital signs.
 */
public class ChpccSectionVitalSignsCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	public ChpccSectionVitalSignsCoded() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.4"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.1.5.3.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.3.25"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.16"));
		codeFixedValue = createHl7CodeFixedValue("8716-3");
	}

	private org.ehealth_connector.common.hl7cdar2.CE codeFixedValue;

	/**
	 * Adds a hl7Entry
	 */
	public void addHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		getEntry().add(value);
	}

	/**
	 * Adds a hl7Entry
	 */
	public void clearHl7Entry() {
		getEntry().clear();
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param code the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE createHl7CodeFixedValue(String code) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CE retVal = factory.createCE();
		retVal.setCode(code);
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
	public org.ehealth_connector.common.hl7cdar2.CE getCodeFixedValue() {
		return codeFixedValue;
	}

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this section MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return super.id;
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
	 * Gets the hl7Text
	 * Human readable text of this section.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return super.text;
	}

	/**
	 * Gets the hl7Title
	 * Fixed human readable title of this section.
	 * - [ge]: 'Vitalzeichen'
	 * - [fr]: 'Signes vitaux'
	 * - [it]: 'Segni vitali'
	 * - [en]: 'Vital Signs'
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return super.title;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.code = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this section MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.id = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 * Human readable text of this section.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		super.text = value;
	}

	/**
	 * Sets the hl7Title
	 * Fixed human readable title of this section.
	 * - [ge]: 'Vitalzeichen'
	 * - [fr]: 'Signes vitaux'
	 * - [it]: 'Segni vitali'
	 * - [en]: 'Vital Signs'
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		super.title = value;
	}
}
