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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.20 Template
 * description: Unity of document versions. All CDA-CH V2 derivatives, i.e.
 * Swiss exchange formats MUST reference this template.
 *
 * Element description: The versionNumber element MUST contain the value 1 for
 * the very first version of that document. For later versions, the version
 * number MUST be increased by 1 each.
 */
public class CdachHeaderDocumentSetIdAndVersionNumber
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument {

	public CdachHeaderDocumentSetIdAndVersionNumber() {
	}

	/**
	 * Gets the hl7SetId The setId element MUST match the document id of the
	 * very first version of that document. It MUST remain the same for all
	 * document versions.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7SetId() {
		return setId;
	}

	/**
	 * Gets the hl7VersionNumber The versionNumber element MUST contain the
	 * value 1 for the very first version of that document. For later versions,
	 * the version number MUST be increased by 1 each.
	 */
	public org.ehealth_connector.common.hl7cdar2.INT getHl7VersionNumber() {
		return versionNumber;
	}

	/**
	 * Sets the hl7SetId The setId element MUST match the document id of the
	 * very first version of that document. It MUST remain the same for all
	 * document versions.
	 */
	public void setHl7SetId(org.ehealth_connector.common.hl7cdar2.II value) {
		this.setId = value;
	}

	/**
	 * Sets the hl7VersionNumber The versionNumber element MUST contain the
	 * value 1 for the very first version of that document. For later versions,
	 * the version number MUST be increased by 1 each.
	 */
	public void setHl7VersionNumber(org.ehealth_connector.common.hl7cdar2.INT value) {
		this.versionNumber = value;
	}
}
