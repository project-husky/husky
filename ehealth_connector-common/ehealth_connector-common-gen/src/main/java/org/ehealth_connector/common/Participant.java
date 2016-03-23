/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.common;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

/**
 * The Class Participant. E.g. employer and school informational contacts MAY be
 * recorded as participants.
 */
public class Participant {

	/** The m participant. */
	Participant2 mParticipant;

	/**
	 * Standard constructor.
	 */
	public Participant() {
		mParticipant = CDAFactory.eINSTANCE.createParticipant2();
	}

	/**
	 * Standard mdht constructor.
	 *
	 * @param mdht
	 *          the mdht object
	 */
	public Participant(Participant2 mdht) {
		this.mParticipant = mdht;
	}

	/**
	 * Returns a copy of the underlying mdht element.
	 *
	 * @return the copy of the mdht element
	 */
	public Participant2 copy() {
		return EcoreUtil.copy(mParticipant);
	}

	/**
	 * Returns the underlying mdht element.
	 *
	 * @return the mdht element
	 */
	public Participant2 getMdht() {
		return this.mParticipant;
	}

	/**
	 * Gets the ParticipantRole.
	 *
	 * @return the partcipantRole
	 */
	public org.ehealth_connector.common.ParticipantRole getParticipantRole() {
		return new org.ehealth_connector.common.ParticipantRole(mParticipant.getParticipantRole());
	}

	/**
	 * Gets the time as Java Date Object.
	 *
	 * @return the time
	 */
	public Date getTime() {
		if (mParticipant.getTime() != null) {
			return DateUtil.parseIVL_TSVDateTimeValue(mParticipant.getTime());
		}
		return null;
	}

	/**
	 * Gets the ParticipationTypeCode.
	 *
	 * @return the participationTypeCode
	 */
	public ParticipationType getTypeCode() {
		return mParticipant.getTypeCode();
	}

	/**
	 * Sets the ParticipantRole.
	 *
	 * @param p
	 *          the participantRole
	 */
	public void setParticipantRole(org.ehealth_connector.common.ParticipantRole p) {
		mParticipant.setParticipantRole(p.copy());
	}

	/**
	 * Sets the time as Data object.
	 *
	 * @param date
	 *          the date
	 */
	public void setTime(Date date) {
		try {
			mParticipant.setTime(DateUtil.createIVL_TSFromEuroDate(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the type code for this participation.
	 *
	 * @param typeCode
	 *          the typeCode
	 */
	public void setTypeCode(ParticipationType typeCode) {
		mParticipant.setTypeCode(typeCode);
	}
}
