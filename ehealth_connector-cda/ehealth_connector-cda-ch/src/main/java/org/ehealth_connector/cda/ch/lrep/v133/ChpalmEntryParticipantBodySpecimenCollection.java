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

import java.util.ArrayList;
import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.24
 * Template description: Specimen Information.
 */
public class ChpalmEntryParticipantBodySpecimenCollection extends org.ehealth_connector.common.hl7cdar2.POCDMT000040ParticipantRole {

	public ChpalmEntryParticipantBodySpecimenCollection() {
		super.getClassCode().add("SPEC");
		super.getId().add(createHl7IdFixedValue("NA"));
	// chpalm_entry_ParticipantBodySpecimenCollection/hl7:participantRole:cs classCode = "SPEC";
	// chpalm_entry_ParticipantBodySpecimenCollection/hl7:id:cs nullFlavor = "NA";
	}

	/**
	 * Creates fixed contents for CDA Element hl7Id
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7IdFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Gets the hl7Id
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7PlayingEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity getHl7PlayingEntity() {
		return playingEntity;
	}

	/**
	 * Sets the hl7Id
	 * The specimen identification MUST be declared. If no specimen identification is available, nullFlavor='NA' MUST be used. In this case @root and @extension are NOT ALLOWED.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		getId().clear();
		getId().add(value);
	}

	/**
	 * Sets the hl7PlayingEntity
	 */
	public void setHl7PlayingEntity(org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity value) {
		this.playingEntity = value;
	}
}
