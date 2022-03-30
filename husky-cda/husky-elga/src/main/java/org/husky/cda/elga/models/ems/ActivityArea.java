/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.ems;

import java.time.ZonedDateTime;

import org.husky.cda.elga.generated.artdecor.ems.EpimsEntryActTaetigkeitsbereich;
import org.husky.cda.elga.generated.artdecor.ems.EpimsEntryOrganizerTaetigkeitsbereich;
import org.husky.cda.elga.utils.DateTimeUtils;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040Organizer;
import org.husky.common.model.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityArea {

	/** The SLF4J logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityArea.class);
	private Code area;
	private ZonedDateTime startDate;
	private ZonedDateTime stopDate;

	public Code getArea() {
		return area;
	}

	public void setArea(Code area) {
		this.area = area;
	}

	public ZonedDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public ZonedDateTime getStopDate() {
		return stopDate;
	}

	public void setStopDate(ZonedDateTime stopDate) {
		this.stopDate = stopDate;
	}

	public POCDMT000040Entry getEpimsEntryOrganizerBetreuungEntry() {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setOrganizer(getEpimsEntryOrganizerTaetigkeitsbereich());
		return entry;
	}

	public POCDMT000040Organizer getEpimsEntryOrganizerTaetigkeitsbereich() {
		EpimsEntryOrganizerTaetigkeitsbereich organizerCare = new EpimsEntryOrganizerTaetigkeitsbereich();
		organizerCare.getComponent().get(0).setAct(getEpimsEntryActTaetigkeitsbereich());
		return organizerCare;
	}

	public EpimsEntryActTaetigkeitsbereich getEpimsEntryActTaetigkeitsbereich() {
		EpimsEntryActTaetigkeitsbereich activityArea = new EpimsEntryActTaetigkeitsbereich();

		if (area != null) {
			activityArea.setCode(this.area.getHl7CdaR2Cd());
		} else {
			LOGGER.error("facility of care is null");
		}

		if (this.stopDate == null && this.startDate == null) {
			return activityArea;
		}

		activityArea.setEffectiveTime(DateTimeUtils.createIvlts(this.startDate, this.stopDate));

		return activityArea;
	}


}
