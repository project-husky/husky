/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.common.model;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Participant2;
import org.projecthusky.common.utils.time.DateTimes;
import org.projecthusky.common.utils.time.Hl7Dtm;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The Class Participant. E.g. employer and school informational contacts MAY be recorded as participants.
 */
public class Participant {

    /**
     * The participant object.
     */
    private POCDMT000040Participant2 mParticipant;

    /**
     * Standard constructor.
     */
    public Participant() {
        mParticipant = new POCDMT000040Participant2();
    }

    /**
     * Standard constructor.
     *
     * @param mdht the mdht object
     */
    public Participant(POCDMT000040Participant2 mdht) {
        this.mParticipant = mdht;
    }

    /**
     * Returns the underlying element.
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
    public org.projecthusky.common.model.ParticipantRole getParticipantRole() {
        return new org.projecthusky.common.model.ParticipantRole(
                mParticipant.getParticipantRole());
    }

    /**
     * Sets the ParticipantRole.
     *
     * @param p the participantRole
     */
    public void setParticipantRole(org.projecthusky.common.model.ParticipantRole p) {
        mParticipant.setParticipantRole(p.getMdht());
    }

    /**
     * Returns the time as an {@link Hl7Dtm} or {@code null}.
     */
    @Nullable
    public Hl7Dtm getTimeAsHl7Dtm() {
        if (mParticipant.getTime() != null && mParticipant.getTime().getValue() != null) {
            return Hl7Dtm.fromHl7(mParticipant.getTime().getValue());
        }
        return null;
    }

    /**
     * Returns the time as an {@link Hl7Dtm} or {@code null}.
     */
    @Nullable
    public Instant getTimeAsInstant() {
		return Optional.ofNullable(this.getTimeAsHl7Dtm()).map(Hl7Dtm::toInstant).orElse(Hl7Dtm.now().toInstant());
    }

    /**
     * Gets the time as Java Date Object.
     *
     * @return the time
     */
    public Date getTime() {
        return Optional.ofNullable(this.getTimeAsInstant()).map(Date::from).orElse(null);
    }

    /**
     * Sets the time as Data object.
     *
     * @param date the date
     */
    public void setTime(Date date) {
		if (date == null) {
			mParticipant.setTime(new IVLTS(NullFlavor.UNKNOWN_L1));
		} else {
			mParticipant.setTime(new IVLTS(DateTimes.toHl7Dtm(date.toInstant(), ZoneId.systemDefault())));
		}
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
     * Sets the type code for this participation.
     *
     * @param typeCode the typeCode
     */
    public void setTypeCode(String typeCode) {
        mParticipant.getTypeCode().clear();
        mParticipant.getTypeCode().add(typeCode);
    }
}
