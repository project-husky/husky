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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.45
 * Template description: This section MAY be used to provide the original representation of the current CDA document as it has been seen by the legal authenticator while signing.Notes:
 * - This template doesn't require PDF/A but keep in mind that only PDF/A contains all necessary information that allows to identically display the PDF on different machines.
 * - To ensure that digital data remains legible in the long term, PDF/A (but not PDF) is mentioned in the allowed list of archival formats for the Swiss Federal Archives.
 * - The certification requirements according to the Swiss EPR (EPRA) require PDF/A-1 oder PDF/A-2.
 * - Following the recommendations of CDA-CH V2 (2017), embedding the original representation in PDF/A-1a format is therefore strongly recommended.
 *
 * Element description: Contains the original representation of the current CDA document as it has been seen by the legal authenticator while signing.
 */
public class CdachSectionOriginalRepresentationCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {

	private org.ehealth_connector.common.hl7cdar2.CE hl7Code;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry hl7Entry;

	/**
	 * An ID for this section MAY be filled for traceability.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	/**
	 * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
	 */
	private org.ehealth_connector.common.hl7cdar2.StrucDocText hl7Text;

	/**
	 * Fixed human readable title of this section.
	 * - [ge]: 'Original Darstellung'
	 * - [fr]: 'Représentation originale'
	 * - [it]: 'Rappresentazione originale'
	 * - [en]: 'Original representation'
	 */
	private org.ehealth_connector.common.hl7cdar2.ST hl7Title;

	/**
	 * Gets the hl7Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7Entry
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry getHl7Entry() {
		return hl7Entry;
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
	 * Gets the hl7Text
	 * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return hl7Text;
	}

	/**
	 * Gets the hl7Title
	 * Fixed human readable title of this section.
	 * - [ge]: 'Original Darstellung'
	 * - [fr]: 'Représentation originale'
	 * - [it]: 'Rappresentazione originale'
	 * - [en]: 'Original representation'
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
	 * Sets the hl7Entry
	 */
	public void setHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		hl7Entry = value;
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
	 * Sets the hl7Text
	 * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		hl7Text = value;
	}

	/**
	 * Sets the hl7Title
	 * Fixed human readable title of this section.
	 * - [ge]: 'Original Darstellung'
	 * - [fr]: 'Représentation originale'
	 * - [it]: 'Rappresentazione originale'
	 * - [en]: 'Original representation'
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		hl7Title = value;
	}
}
