/*
 *
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
package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtProcedureFacade;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.Participant;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class SpecimenCollectionEntry. Specimen Collection, when present, SHALL
 * be recorded under the Specimen Act in an entryRelationship under the
 * Laboratory Data Processing Entry.
 */
public class SpecimenCollectionEntry
		extends MdhtProcedureFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection> {

	/**
	 * Instantiates a new specimen collection entry.
	 */
	public SpecimenCollectionEntry() {
		super(LABFactory.eINSTANCE.createSpecimenCollection().init());
	}

	/**
	 * Instantiates a new specimen collection entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

	/**
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
	}

	/**
	 * Gets the participants.
	 *
	 * @return the participants
	 */
	public List<Participant> getParticipants() {
		final List<Participant> list = new ArrayList<Participant>();
		if ((getMdht() != null) && (getMdht().getParticipants() != null)) {
			for (final Participant2 p : this.getMdht().getParticipants()) {
				list.add(new Participant(p));
			}
		}
		return list;
	}

	/**
	 * Gets the specimen received entry.
	 *
	 * @return the specimen received entry
	 */
	public SpecimenReceivedEntry getSpecimenReceivedEntry() {
		return new SpecimenReceivedEntry(getMdht().getSpecimenReceived());
	}

	/**
	 * Sets the effective time.
	 *
	 * @param date
	 *            the new effective time
	 */
	public void setEffectiveTime(Date date) {
		getMdht().setEffectiveTime(DateUtil.convertDateToIvlTsyyyyMMddHHmmssZZZZ(date));
	}

	/**
	 * Sets the effective time interval.
	 *
	 * @param low
	 *            the low value
	 * @param high
	 *            the high value
	 */
	public void setEffectiveTime(Date low, Date high) {
		getMdht().setEffectiveTime(DateUtil.convertDateToIvlTsyyyyMMddHHmmssZZZZ(low, high));
	}

	/**
	 * Sets the participant.
	 *
	 * @param participant
	 *            the participant
	 */
	public void setParticipant(Participant participant) {
		// set ParticipantionType and ParticipantClassRole
		participant.setTypeCode(ParticipationType.PRD);
		participant.getParticipantRole().setClassCode(RoleClassRoot.SPEC);

		getMdht().getParticipants().clear();
		getMdht().getParticipants().add(participant.copy());
	}

	/**
	 * Sets the specimen received entry.
	 *
	 * @param entry
	 *            the new specimen received entry
	 */
	public void setSpecimenReceivedEntry(SpecimenReceivedEntry entry) {
		if (entry != null) {
			// Check if the element already exist, if so, replace it, if not add
			// it
			boolean added = false;
			for (Act o : getMdht().getActs()) {
				if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived) {
					o = entry.getMdht();
					added = true;
				}
			}
			if (added == false) {
				getMdht().addAct(entry.copy());
			}
			CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
					x_ActRelationshipEntryRelationship.COMP);
		}
	}
}
