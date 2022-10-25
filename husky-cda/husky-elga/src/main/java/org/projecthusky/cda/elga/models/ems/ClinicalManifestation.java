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
import java.util.List;

import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsEntryProblemConcern;
import org.projecthusky.cda.elga.utils.DateTimeUtils;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.model.Identificator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClinicalManifestation {

	/** The SLF4J logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicalManifestation.class);
	private String rootId;
	private ZonedDateTime startDate;
	private ZonedDateTime stopDate;
	private List<ClinicalManifestationItem> clinicalManifestationItems;

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
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

	public List<ClinicalManifestationItem> getClinicalManifestationItems() {
		return clinicalManifestationItems;
	}

	public void setClinicalManifestationItems(List<ClinicalManifestationItem> clinicalManifestationItems) {
		this.clinicalManifestationItems = clinicalManifestationItems;
	}

	public POCDMT000040Entry getEpimsEntryProblemConcernEntry() {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setAct(getEpimsEntryProblemConcern());
		return entry;
	}

	public EpimsEntryProblemConcern getEpimsEntryProblemConcern() {
		EpimsEntryProblemConcern problemConcern = new EpimsEntryProblemConcern();

		Identificator idProblemConcern = new Identificator();
		idProblemConcern.setRoot(rootId);
		idProblemConcern.setExtension("EMS-problem-concern");
		problemConcern.setHl7Id(idProblemConcern.getHl7CdaR2Ii());
		problemConcern.setEffectiveTime(DateTimeUtils.createIvlts(this.startDate, this.stopDate));

		if (this.clinicalManifestationItems != null && !this.clinicalManifestationItems.isEmpty()) {
			problemConcern.getEntryRelationship().clear();
			int index = 1;
			for (ClinicalManifestationItem item : clinicalManifestationItems) {
				if (item != null) {
					POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
					entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
					entryRel.setContextConductionInd(true);
					entryRel.setInversionInd(false);
					entryRel.setObservation(item.getEpimsEntryProblem(
							new Identificator(rootId, String.format("EMS-problem-%d", index)), index++));
					problemConcern.addHl7EntryRelationship(entryRel);
				}
			}
		} else {
			LOGGER.warn("clinical manifestations are null or empty");
		}

		return problemConcern;
	}

}
