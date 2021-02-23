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
package org.ehealth_connector.cda.ch.emed.v097;

import javax.annotation.Generated;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.46 Template
 * description: Header Templates for Medication List document.
 *
 * Element description: The document's creation date and time. If this document
 * replaces a previous version (linked via parentDocument), this is the date and
 * time of the new version.
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-02-23")
public class HeaderTemplateCompilationMedicationListDocument
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	public HeaderTemplateCompilationMedicationListDocument() {
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
