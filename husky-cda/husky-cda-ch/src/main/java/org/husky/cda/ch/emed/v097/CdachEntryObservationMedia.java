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
package org.husky.cda.ch.emed.v097;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;

/**
 * cdach_entry_ObservationMedia
 *
 * Template description: Multimedia objects (e.g., PDF representations of the CDA document, pictures, Reiber diagrams, electrophoresis, etc.) MAY be integrated into a CDA document, either by reference to external multimedia objects or by means of XML embedding.This template defines only the embedding of multimedia objects in the CDA document. References to external documents can be created with the ExternalDocument template.For embedding in XML, the multimedia objects Base-64 must be encoded.Due to the amount of data, only light objects should be embedded.Heavy objects should be integrated using links to external documents.
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.756.5.30.1.1.10.4.83
 * Effective date: 2018-04-18 00:00:00
 * Version: 2017
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class CdachEntryObservationMedia
		extends org.husky.common.hl7cdar2.POCDMT000040ObservationMedia {

	public CdachEntryObservationMedia() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.83"));
		super.setLanguageCode(createHl7LanguageCodeFixedValue());
		super.setValue(createHl7ValueFixedValue("B64"));
	}

	/**
	 * Adds a hl7Id IDs for this item MAY be filled for traceability.
	 */
	public void addHl7Id(org.husky.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id IDs for this item MAY be filled for traceability.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7LanguageCode
	 */
	private static org.husky.common.hl7cdar2.CS createHl7LanguageCodeFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.CS retVal = factory.createCS();
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Value
	 *
	 * @param representation
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.ED createHl7ValueFixedValue(
			String representation) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.ED retVal = factory.createED();
		return retVal;
		// TODO: Contents shall be taken from enum:
		// org.ehealth_connector.common.hl7cdar2.VideoMediaType
	}

	/**
	 * Gets the hl7LanguageCode The RFC 1766 (ISO-639-1 and ISO 3166) based
	 * language in which the multimedia object is written. If it isn't known or
	 * not available (e.g. for pictures), use nullFlavor instead.
	 */
	public org.husky.common.hl7cdar2.CS getHl7LanguageCode() {
		return languageCode;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Value This template defines only the embedding of multimedia
	 * objects in the CDA document.
	 */
	public org.husky.common.hl7cdar2.ED getHl7Value() {
		return value;
	}

	/**
	 * Sets the hl7LanguageCode The RFC 1766 (ISO-639-1 and ISO 3166) based
	 * language in which the multimedia object is written. If it isn't known or
	 * not available (e.g. for pictures), use nullFlavor instead.
	 */
	public void setHl7LanguageCode(org.husky.common.hl7cdar2.CS value) {
		this.languageCode = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Value This template defines only the embedding of multimedia
	 * objects in the CDA document.
	 */
	public void setHl7Value(org.husky.common.hl7cdar2.ED value) {
		this.value = value;
	}
}
