/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.lab;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map.Entry;

import org.husky.cda.elga.generated.artdecor.base.Annotation;
import org.husky.cda.elga.generated.artdecor.base.LaboratoryObservationActive;
import org.husky.cda.elga.models.Laboratory;
import org.husky.cda.elga.models.PerformerAt;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Observation;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.model.Code;
import org.husky.common.utils.time.DateTimes;

public class LaboratoryObservation extends Laboratory {

	private List<String> notes;
	private List<Code> interpretationCodes;
	private boolean completed;

	public boolean isCompleted() {
		return completed;
	}

	public List<String> getNotes() {
		return notes;
	}

	public List<Code> getInterpretationCodes() {
		return interpretationCodes;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public void setInterpretationCodes(List<Code> interpretationCodes) {
		this.interpretationCodes = interpretationCodes;
	}

	public org.husky.cda.elga.generated.artdecor.base.LaboratoryObservation getLaboratoryObservation(int index) {
		org.husky.cda.elga.generated.artdecor.base.LaboratoryObservation observation = new org.husky.cda.elga.generated.artdecor.base.LaboratoryObservation();

		fillPOCDMT000040Observation(observation, index);

		setLaboratories(observation);
		setStatusCode(observation);

		if (this.interpretationCodes != null) {
			for (Code interpretation : interpretationCodes) {
				if (interpretation != null) {
					observation.addHl7InterpretationCode(interpretation.getHl7CdaR2Ce());
				}
			}
		}

		setNotes(observation);

		return observation;
	}

	private void setLaboratories(POCDMT000040Observation observation) {
		if (getLaboratories() != null) {
			for (Entry<ZonedDateTime, PerformerAt> entry : getLaboratories().entrySet()) {
				if (entry != null) {
					observation.getPerformer().add(entry.getValue().getLaboratoryPerformer2(entry.getKey()));
				}
			}
		}
	}

	public LaboratoryObservationActive getLaboratoryObservationActive() {
		LaboratoryObservationActive observation = new LaboratoryObservationActive();

		if (getLabTestId() != null) {
			observation.setHl7Id(getLabTestId().getHl7CdaR2Ii());
			observation.setHl7Text(new ED(null, new TEL("#" + getLabTestId().getExtension())));
		}

		if (getAnalysisCode() != null) {
			observation.setHl7Code(getAnalysisCode().getHl7CdaR2Ce());
		}

		observation.setHl7EffectiveTime(new IVLTS(DateTimes.toDatetimeTs(getSamplingTime()).getValue()));

		return observation;
	}

	private void setStatusCode(POCDMT000040Observation observation) {
		if (isAborted()) {
			observation.setStatusCode(new CS("aborted"));
		} else if (this.completed) {
			observation.setStatusCode(new CS("completed"));
		} else {
			observation.setStatusCode(new CS("active"));
		}
	}

	private void setNotes(POCDMT000040Observation observation) {
		if (this.notes != null && !this.notes.isEmpty() && observation != null) {
			for (int count = 0; count < this.notes.size(); count++) {
				POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
				entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
				Annotation annotation = new Annotation();
				annotation.setHl7Text(new ED(null, new TEL("#analyse-comment-" + count)));
				entryRel.setAct(annotation);
				observation.getEntryRelationship().add(entryRel);
			}
		}
	}

}
