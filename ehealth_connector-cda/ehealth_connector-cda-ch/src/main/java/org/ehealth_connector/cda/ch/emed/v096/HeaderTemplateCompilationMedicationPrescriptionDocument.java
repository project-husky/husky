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
package org.ehealth_connector.cda.ch.emed.v096;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.45 Template
 * description: Header Templates for Medication Prescription
 *
 * Element description: Validity of document
 */
public class HeaderTemplateCompilationMedicationPrescriptionDocument
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	/**
	 * Gets the hl7DocumentationOf Validity of document
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf> getHl7DocumentationOf() {
		return documentationOf;
	}

	/**
	 * Gets the hl7EffectiveTime The document's creation date and time. If this
	 * document replaces a previous version (linked via parentDocument), this is
	 * the date and time of the new version.
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getHl7EffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Sets the hl7DocumentationOf Validity of document
	 */
	public void setHl7DocumentationOf(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040DocumentationOf value) {
		getDocumentationOf().clear();
		getDocumentationOf().add(value);
	}

	/**
	 * Sets the hl7EffectiveTime The document's creation date and time. If this
	 * document replaces a previous version (linked via parentDocument), this is
	 * the date and time of the new version.
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		this.effectiveTime = value;
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		this.title = value;
	}
}
