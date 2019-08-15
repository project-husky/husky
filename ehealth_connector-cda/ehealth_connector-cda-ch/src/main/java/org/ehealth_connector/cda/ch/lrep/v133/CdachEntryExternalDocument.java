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
package org.ehealth_connector.cda.ch.lrep.v133;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.29
 * Template description: External documents can be included in a CDA document, either by means of references or by means of XML embedding.This template defines a reference to an external document, only.Embedded documents can be created with the template Observation Media (or derived templates).
 *
 * Element description: Reference to an external document.
 */
public class CdachEntryExternalDocument extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ExternalDocument {

	/**
	 * Adds a hl7Id
	 * MUST contain the id of the external document.
	 */
	public void addHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Adds a hl7Id
	 * MUST contain the id of the external document.
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getTemplateId() != null)
			if (getTemplateId().size() > 0)
				retVal = getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Text
	 * The external document MUST be declared as a link.The link MUST be declared as an URL, which points to the referenced document.The same link MUST be used in the human readable part (narrative text) using the &lt;linkHTML&gt; element.
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Text() {
		return text;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 * The external document MUST be declared as a link.The link MUST be declared as an URL, which points to the referenced document.The same link MUST be used in the human readable part (narrative text) using the &lt;linkHTML&gt; element.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.ED value) {
		this.text = value;
	}
}
