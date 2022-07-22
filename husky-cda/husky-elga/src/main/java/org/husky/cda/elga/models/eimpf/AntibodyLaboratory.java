/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.eimpf;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map.Entry;

import org.husky.cda.elga.generated.artdecor.EimpfEntryAntikoerperBestimmungLaboratoryObservation;
import org.husky.cda.elga.generated.artdecor.base.enums.ElgaObservationInterpretation;
import org.husky.cda.elga.generated.artdecor.enums.EImpfAntikoerperbestimmungVs;
import org.husky.cda.elga.models.Comment;
import org.husky.cda.elga.models.Laboratory;
import org.husky.cda.elga.models.PerformerAt;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Observation;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;

public class AntibodyLaboratory extends Laboratory {

	private EImpfAntikoerperbestimmungVs antibodyDetermination;
	private ElgaObservationInterpretation interpretationCode;
	private List<Comment> comments;

	public EimpfEntryAntikoerperBestimmungLaboratoryObservation getEimpfEntryAntikoerperBestimmungLaboratoryObservation(
			int index) {
		EimpfEntryAntikoerperBestimmungLaboratoryObservation observation = new EimpfEntryAntikoerperBestimmungLaboratoryObservation();

		fillPOCDMT000040Observation(observation, index);

		if (this.antibodyDetermination != null) {
			observation.setCode(new CE(this.antibodyDetermination.getCode().getCode(),
					this.antibodyDetermination.getCode().getCodeSystem(),
					this.antibodyDetermination.getCode().getCodeSystemName(),
					this.antibodyDetermination.getCode().getDisplayName()));
		}

		if (isAborted()) {
			observation.setStatusCode(new CS("aborted"));
		} else {
			observation.setStatusCode(new CS("completed"));
		}

		if (this.interpretationCode != null) {
			observation.getInterpretationCode()
					.add(new CE(this.interpretationCode.getCode().getCode(),
							this.interpretationCode.getCode().getCodeSystem(),
							this.interpretationCode.getCode().getCodeSystemName(),
							this.interpretationCode.getCode().getDisplayName()));
		}

		if (this.comments != null && !this.comments.isEmpty()) {
			setComments(observation);
		}

		setLaboratories(observation);

		return observation;
	}

	private void setComments(EimpfEntryAntikoerperBestimmungLaboratoryObservation observation) {
		int commentIndex = 0;
		for (Comment comment : this.comments) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
			entryRel.setContextConductionInd(true);
			if (comment != null) {
				entryRel.setAct(comment.getAtcdabbrEntryComment(commentIndex));
			}

			observation.getEntryRelationship().add(entryRel);
		}
	}

	private void setLaboratories(POCDMT000040Observation observation) {
		if (getLaboratories() != null) {
			for (Entry<ZonedDateTime, PerformerAt> entry : getLaboratories().entrySet()) {
				if (entry != null) {
					observation.getPerformer()
							.add(entry.getValue().getAtcdabbrOtherPerformerBodyLaboratory(entry.getKey()));
				}
			}
		}
	}

	public EImpfAntikoerperbestimmungVs getAntibodyDetermination() {
		return antibodyDetermination;
	}

	public void setAntibodyDetermination(EImpfAntikoerperbestimmungVs antibodyDetermination) {
		this.antibodyDetermination = antibodyDetermination;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public ElgaObservationInterpretation getInterpretationCode() {
		return interpretationCode;
	}

	public void setInterpretationCode(ElgaObservationInterpretation interpretationCode) {
		this.interpretationCode = interpretationCode;
	}

}
