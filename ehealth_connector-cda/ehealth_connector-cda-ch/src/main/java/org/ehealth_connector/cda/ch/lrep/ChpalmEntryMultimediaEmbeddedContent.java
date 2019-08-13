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
import org.ehealth_connector.common.hl7cdar2.BinaryDataEncoding;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.18
 * Template description: Multimedia objects (e.g., PDF representations of the CDA document, pictures, Reiber diagrams, electrophoresis, etc.) MAY be integrated into a CDA document, either by reference to external multimedia objects or by means of XML embedding.This template defines only the embedding of multimedia objects in the CDA document. References to external documents can be created with the ExternalDocument template.For embedding in XML, the multimedia objects Base-64 must be encoded.Due to the amount of data, only light objects should be embedded.Heavy objects should be integrated using links to external documents.
 */
public class ChpalmEntryMultimediaEmbeddedContent extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ObservationMedia {

	public ChpalmEntryMultimediaEmbeddedContent() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.18"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.83"));
	}

	/**
	 * Adds a hl7Id
	 * IDs for this item CAN be filled for traceability.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id
	 * IDs for this item CAN be filled for traceability.
	 */
	public void clearHl7Id() {
		getId().clear();
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
	 * Creates fixed contents for hl7Value
	 *
	 * @param representation the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.ED createHl7ValueFixedValue(String representation) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.ED retVal = factory.createED();
		retVal.setRepresentation(BinaryDataEncoding.fromValue(representation));
		return retVal;
	}

	/**
	 * Gets the hl7EntryRelationship
	 * This template defines only the embedding of multimedia objects in the CDA document.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship getHl7EntryRelationship() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship retVal = null;
		if (super.getEntryRelationship() != null)
			if (super.getEntryRelationship().size() > 0)
				retVal = super.getEntryRelationship().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7LanguageCode
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the multimedia object is written. If it isn't known or not available (e.g. for pictures), use nullFlavor instead.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7LanguageCode() {
		return super.languageCode;
	}

	/**
	 * Gets the hl7Reference
	 * This template defines only the embedding of multimedia objects in the CDA document.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference getHl7Reference() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference retVal = null;
		if (super.getReference() != null)
			if (super.getReference().size() > 0)
				retVal = super.getReference().get(0);
		return retVal;
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
	 * The Base-64 encoded multimedia object.
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Value() {
		return super.value;
	}

	/**
	 * Sets the hl7EntryRelationship
	 * This template defines only the embedding of multimedia objects in the CDA document.
	 */
	public void setHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		super.getEntryRelationship().clear();
		super.getEntryRelationship().add(value);
	}

	/**
	 * Sets the hl7LanguageCode
	 * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the multimedia object is written. If it isn't known or not available (e.g. for pictures), use nullFlavor instead.
	 */
	public void setHl7LanguageCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.languageCode = value;
	}

	/**
	 * Sets the hl7Reference
	 * This template defines only the embedding of multimedia objects in the CDA document.
	 */
	public void setHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		super.getReference().clear();
		super.getReference().add(value);
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
	 * The Base-64 encoded multimedia object.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.ED value) {
		super.value = value;
	}
}
