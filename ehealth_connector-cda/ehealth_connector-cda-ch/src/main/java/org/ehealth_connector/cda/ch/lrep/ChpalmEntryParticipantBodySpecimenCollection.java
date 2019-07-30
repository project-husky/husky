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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.24
 * Template description: Specimen Information.
 */
public class ChpalmEntryParticipantBodySpecimenCollection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ParticipantRole {

	/**
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity hl7PlayingEntity;

	/**
	 * Gets the hl7Id
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7PlayingEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity getHl7PlayingEntity() {
		return hl7PlayingEntity;
	}

	/**
	 * Sets the hl7Id
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7PlayingEntity
	 */
	public void setHl7PlayingEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity value) {
		hl7PlayingEntity = value;
	}
}
