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

import java.util.ArrayList;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.4
 * Template description: This section contains a list of measured / observed vital signs.
 *
 * Element description: This section contains a list of measured / observed vital signs.
 */
public class ChpccSectionVitalSignsCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	private org.ehealth_connector.common.hl7cdar2.CE hl7Code;

	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry> hl7Entry;

	/**
	 * An ID for this section MAY be filled for traceability.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId2;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId3;

	/**
	 * Human readable text of this section.
	 */
	private org.ehealth_connector.common.hl7cdar2.StrucDocText hl7Text;

	/**
	 * Fixed human readable title of this section.
	 * - [ge]: 'Vitalzeichen'
	 * - [fr]: 'Signes vitaux'
	 * - [it]: 'Segni vitali'
	 * - [en]: 'Vital Signs'
	 */
	private org.ehealth_connector.common.hl7cdar2.ST hl7Title;

	/**
	 * Adds a hl7Entry
	 */
	public void addHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		hl7Entry.add(value);
	}

	/**
	 * Adds a hl7Entry
	 */
	public void clearHl7Entry() {
		hl7Entry.clear();
	}

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this section MAY be filled for traceability.
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
	 * Gets the hl7TemplateId2
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId2() {
		return hl7TemplateId2;
	}

	/**
	 * Gets the hl7TemplateId3
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId3() {
		return hl7TemplateId3;
	}

	/**
	 * Gets the hl7Text
	 * Human readable text of this section.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return hl7Text;
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
		return hl7Title;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this section MAY be filled for traceability.
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

	/**
	 * Sets the hl7TemplateId2
	 */
	public void setHl7TemplateId2(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId2 = value;
	}

	/**
	 * Sets the hl7TemplateId3
	 */
	public void setHl7TemplateId3(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId3 = value;
	}

	/**
	 * Sets the hl7Text
	 * Human readable text of this section.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		hl7Text = value;
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
		hl7Title = value;
	}
}
