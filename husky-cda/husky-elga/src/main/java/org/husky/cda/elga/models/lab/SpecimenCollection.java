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

import org.husky.cda.elga.generated.artdecor.base.Annotation;
import org.husky.cda.elga.generated.artdecor.base.LaboratorySpecimenEntry;
import org.husky.cda.elga.generated.artdecor.base.SpecimenReceived;
import org.husky.cda.elga.models.PerformerAt;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Participant2;
import org.husky.common.hl7cdar2.POCDMT000040ParticipantRole;
import org.husky.common.hl7cdar2.POCDMT000040PlayingEntity;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.time.DateTimes;

public class SpecimenCollection  {

	private ZonedDateTime collectedTime;
	private Code targetSite;
	private PerformerAt collector;
	private Code type;
	private ZonedDateTime receivedTime;
	private List<String> notes;
	private String materialId;
	private String material;

	public ZonedDateTime getCollectedTime() {
		return collectedTime;
	}

	public Code getTargetSite() {
		return targetSite;
	}

	public PerformerAt getCollector() {
		return collector;
	}

	public Code getType() {
		return type;
	}

	public ZonedDateTime getReceivedTime() {
		return receivedTime;
	}

	public List<String> getNotes() {
		return notes;
	}

	public String getMaterialId() {
		return materialId;
	}

	public String getMaterial() {
		return material;
	}

	public void setCollectedTime(ZonedDateTime collectedTime) {
		this.collectedTime = collectedTime;
	}

	public void setTargetSite(Code targetSite) {
		this.targetSite = targetSite;
	}

	public void setCollector(PerformerAt collector) {
		this.collector = collector;
	}

	public void setType(Code type) {
		this.type = type;
	}

	public void setReceivedTime(ZonedDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}

	public void setNote(List<String> notes) {
		this.notes = notes;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public org.husky.cda.elga.generated.artdecor.base.SpecimenCollection getLaboratorySpecimenCollection(
			String authorOid) {
		org.husky.cda.elga.generated.artdecor.base.SpecimenCollection collection = new org.husky.cda.elga.generated.artdecor.base.SpecimenCollection();

		if (collectedTime != null) {
			collection.setHl7EffectiveTime(new IVLTS(DateTimes.toDatetimeTs(collectedTime).getValue()));
		}

		if (targetSite != null) {
			collection.getHl7TargetSiteCode().clear();
			collection.getHl7TargetSiteCode().add(targetSite.getHl7CdaR2Ce());
		}

		if (collector != null) {
			collection.getHl7Performer().clear();
			collection.getHl7Performer().add(collector.getHl7Cdar2Perfomer());
		}

		if (type != null) {
			POCDMT000040Participant2 participant = new POCDMT000040Participant2();
			participant.getTypeCode().add("PRD");

			POCDMT000040ParticipantRole participantRole = new POCDMT000040ParticipantRole();
			participantRole.getClassCode().add("SPEC");

			participantRole.getId().add(new Identificator(authorOid, materialId).getHl7CdaR2Ii());

			POCDMT000040PlayingEntity playingEntity = new POCDMT000040PlayingEntity();
			playingEntity.setCode(type.getHl7CdaR2Ce());

			participantRole.setPlayingEntity(playingEntity);
			participant.setParticipantRole(participantRole);
			collection.getHl7Participant().add(participant);
		}

		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		entryRel.setAct(getSpecimenReceived());
		collection.getHl7EntryRelationship().add(entryRel);

		return collection;
	}

	public SpecimenReceived getSpecimenReceived() {
		SpecimenReceived specimenReceived = new SpecimenReceived();

		if (receivedTime != null) {
			specimenReceived.setHl7EffectiveTime(new IVLTS(DateTimes.toDatetimeTs(receivedTime).getValue()));
		}

		if (notes != null && !notes.isEmpty()) {
			for (int index = 0; index < notes.size(); index++) {
				POCDMT000040EntryRelationship entryRel = LaboratorySpecimenEntry
						.createHl7EntryRelationshipFixedValue("COMP", null);
				Annotation annotation = new Annotation();
				annotation.setHl7Text(new ED(null, new TEL("#commonRemark-" + index)));
				entryRel.setAct(annotation);
				specimenReceived.addHl7EntryRelationship(entryRel);
			}
		}

		return specimenReceived;
	}

}
