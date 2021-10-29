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
package org.ehealth_connector.common.model;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * The Class Participant. E.g. employer and school informational contacts MAY be
 * recorded as participants.
 */
public class Participant {

	/** The MDHT participant object. */
	private POCDMT000040Participant2 mParticipant;

	/**
	 * Standard constructor.
	 */
	public Participant() {
		mParticipant = new POCDMT000040Participant2();
	}

	/**
	 * Standard mdht constructor.
	 *
	 * @param mdht
	 *            the mdht object
	 */
	public Participant(POCDMT000040Participant2 mdht) {
		this.mParticipant = mdht;
	}

	/**
	 * Returns the underlying mdht element.
	 *
	 * @return the mdht element
	 */
	public POCDMT000040Participant2 getMdht() {
		return this.mParticipant;
	}

	/**
	 * Gets the ParticipantRole.
	 *
	 * @return the partcipantRole
	 */
	public org.ehealth_connector.common.model.ParticipantRole getParticipantRole() {
		return new org.ehealth_connector.common.model.ParticipantRole(
				mParticipant.getParticipantRole());
	}

	/**
	 * Gets the time as Java Date Object.
	 *
	 * @return the time
	 */
	public Date getTime() {
		if (mParticipant.getTime() != null) {
			return DateUtil.parseHl7Timestamp(mParticipant.getTime());
		}
		return null;
	}

	/**
	 * Gets the ParticipationTypeCode.
	 *
	 * @return the participationTypeCode
	 */
	public List<String> getTypeCode() {
		return mParticipant.getTypeCode();
	}

	/**
	 * Sets the ParticipantRole.
	 *
	 * @param p
	 *            the participantRole
	 */
	public void setParticipantRole(org.ehealth_connector.common.model.ParticipantRole p) {
		mParticipant.setParticipantRole(p.getMdht());
	}

	/**
	 * Sets the time as Data object.
	 *
	 * @param date
	 *            the date
	 */
	public void setTime(Date date) {
		mParticipant.setTime(DateUtil.date2IvltsTzon(date));
	}

	/**
	 * Sets the type code for this participation.
	 *
	 * @param typeCode
	 *            the typeCode
	 */
	public void setTypeCode(String typeCode) {
		mParticipant.getTypeCode().clear();
		mParticipant.getTypeCode().add(typeCode);
	}
}
