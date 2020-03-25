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
package org.ehealth_connector.cda.ch.emed.v096;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.36 Template
 * description: Dosage Instructions are a set of data elements which together
 * represent the dosage instructions to a medication such as duration of
 * treatment, medication frequency, dose quantity, route of administration, etc.
 * Dosage Instructions may be provided structured and/or narrative. This entry
 * describes structured dosage instructions.
 *
 * Element description: Dosage Instructions PCC 6.3.4.16.12 - Dosage change
 */
public class DosageInstructionsEntryDosageChange
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship {

	public DosageInstructionsEntryDosageChange() {
		super.setTypeCode(org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship
				.fromValue("COMP"));
	}

	/**
	 * Gets the hl7SequenceNumber
	 */
	public org.ehealth_connector.common.hl7cdar2.INT getHl7SequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Gets the hl7SubstanceAdministration
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration getHl7SubstanceAdministration() {
		return substanceAdministration;
	}

	/**
	 * Sets the hl7SequenceNumber
	 */
	public void setHl7SequenceNumber(org.ehealth_connector.common.hl7cdar2.INT value) {
		this.sequenceNumber = value;
	}

	/**
	 * Sets the hl7SubstanceAdministration
	 */
	public void setHl7SubstanceAdministration(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration value) {
		this.substanceAdministration = value;
	}
}
