/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.ems;

import java.time.ZonedDateTime;

import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsEntryProblem;
import org.projecthusky.cda.elga.utils.DateTimeUtils;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClinicalManifestationItem {
	/** The SLF4J logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicalManifestationItem.class);
	private ZonedDateTime startDate;
	private ZonedDateTime stopDate;
	private Code code;

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

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public EpimsEntryProblem getEpimsEntryProblem(Identificator id, int index) {
		EpimsEntryProblem problem = new EpimsEntryProblem();
		problem.setHl7Id(id.getHl7CdaR2Ii());
		problem.setText(new ED(null, new TEL(String.format("#epims-entry-problem-%d", index))));

		problem.setEffectiveTime(DateTimeUtils.createIvlts(this.startDate, this.stopDate));

		if (this.code != null) {
			problem.setHl7Value(this.code.getHl7CdaR2Cd());
		} else {
			LOGGER.warn("Code for clinical manifestation is null");
		}

		return problem;
	}

}
