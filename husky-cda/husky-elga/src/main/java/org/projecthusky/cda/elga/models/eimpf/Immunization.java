/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.eimpf;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunization;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunizationBillability;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunizationImpfungNichtAngegeben;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunizationTarget;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrOtherVaccineProductNichtAngegeben;
import org.projecthusky.cda.elga.generated.artdecor.enums.EImpfImpfgrundVs;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.cda.elga.models.Dose;
import org.projecthusky.cda.elga.models.Drug;
import org.projecthusky.cda.elga.models.ParticipantAt;
import org.projecthusky.cda.elga.models.PerformerAt;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.models.Translation;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CR;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.IVLPQ;
import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Reference;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.hl7cdar2.XActRelationshipExternalReference;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.time.DateTimes;

public class Immunization {

	private Identificator id;
	private ZonedDateTime immunizationDate;
	private Drug drug;
	private Dose dose;
	private ImmunizationSchedule immunizationSchedule;
	private List<Code> immunizationTargets;
	private PerformerAt performer;
	private PractitionerCdaAt author;
	private ZonedDateTime approvalDate;
	private ParticipantAt participant;
	private ZonedDateTime recordDate;
	private Identificator immunizationVoucher;
	private EImpfImpfgrundVs immunizationReason;
	private ZonedDateTime expirationDate;
	private Appendix originalImmunizationDocument;
	private List<Translation> translations;

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public ZonedDateTime getImmunizationDate() {
		return immunizationDate;
	}

	public void setImmunizationDate(ZonedDateTime immunizationDate) {
		this.immunizationDate = immunizationDate;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Dose getDose() {
		return dose;
	}

	public void setDose(Dose dose) {
		this.dose = dose;
	}

	public ImmunizationSchedule getImmunizationSchedule() {
		return immunizationSchedule;
	}

	public void setImmunizationSchedule(ImmunizationSchedule immunizationSchedule) {
		this.immunizationSchedule = immunizationSchedule;
	}

	public List<Code> getImmunizationTargets() {
		return immunizationTargets;
	}

	public void setImmunizationTargets(List<Code> immunizationTargets) {
		this.immunizationTargets = immunizationTargets;
	}

	public PerformerAt getPerformer() {
		return performer;
	}

	public void setPerformer(PerformerAt performer) {
		this.performer = performer;
	}

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public ZonedDateTime getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(ZonedDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}

	public ParticipantAt getParticipant() {
		return participant;
	}

	public void setParticipant(ParticipantAt participant) {
		this.participant = participant;
	}

	public ZonedDateTime getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(ZonedDateTime recordDate) {
		this.recordDate = recordDate;
	}

	public Identificator getImmunizationVoucher() {
		return immunizationVoucher;
	}

	public void setImmunizationVoucher(Identificator immunizationVoucher) {
		this.immunizationVoucher = immunizationVoucher;
	}

	public EImpfImpfgrundVs getImmunizationReason() {
		return immunizationReason;
	}

	public void setImmunizationReason(EImpfImpfgrundVs immunizationReason) {
		this.immunizationReason = immunizationReason;
	}

	public ZonedDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(ZonedDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

	public Appendix getOriginalImmunizationDocument() {
		return originalImmunizationDocument;
	}

	public void setOriginalImmunizationDocument(Appendix originalImmunizationDocument) {
		this.originalImmunizationDocument = originalImmunizationDocument;
	}

	public POCDMT000040Entry getImmunizationEntry(int index) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		entry.setContextConductionInd(true);

		if (this.drug != null) {
			AtcdabbrEntryImmunization immunization = new AtcdabbrEntryImmunization();
			setProperties(immunization, index, false);
			immunization.setConsumable(this.drug.getVaccineProduct(false));
			entry.setSubstanceAdministration(immunization);
		} else {
			AtcdabbrEntryImmunizationImpfungNichtAngegeben immunizationNotDeclared = new AtcdabbrEntryImmunizationImpfungNichtAngegeben();
			setProperties(immunizationNotDeclared, index, true);
			POCDMT000040Consumable consumable = new POCDMT000040Consumable();
			consumable.getTypeCode().add("CSM");
			AtcdabbrOtherVaccineProductNichtAngegeben otherVaccineProduct = new AtcdabbrOtherVaccineProductNichtAngegeben();
			consumable.setManufacturedProduct(otherVaccineProduct);
			immunizationNotDeclared.setConsumable(consumable);
			entry.setSubstanceAdministration(immunizationNotDeclared);
		}

		return entry;
	}

	private void setImmunizationProperties(POCDMT000040SubstanceAdministration substanceAdministration, int index) {
		if (this.immunizationDate != null) {
			SXCMTS time = new SXCMTS();
			time.setValue(DateTimes.toDateTs(immunizationDate).getValue());
			substanceAdministration.getEffectiveTime().add(time);
		}

		if (this.dose != null) {
			substanceAdministration
					.setDoseQuantity(Dose.getIVLPQ(String.valueOf(this.dose.getQuantity()), this.dose.getUnit()));
		} else {
			IVLPQ ivlpq = new IVLPQ();
			ivlpq.nullFlavor = new ArrayList<String>();
			ivlpq.getNullFlavor().add("UNK");
			substanceAdministration.setDoseQuantity(ivlpq);
		}

		if (this.immunizationSchedule != null) {
			substanceAdministration.getPrecondition().clear();
			substanceAdministration.getPrecondition().add(immunizationSchedule.getImmunizationScheduleEntry(index));
		}

		if (this.performer != null) {
			substanceAdministration.getPerformer().clear();
			substanceAdministration.getPerformer()
					.add(this.performer.getAtcdabbrOtherPerformerBodyImpfendePerson(immunizationDate));
		}

		if (this.author != null) {
			substanceAdministration.getAuthor().clear();
			substanceAdministration.getAuthor().add(this.author.getAtcdabbrOtherAuthorBodyEImpfpass(approvalDate));
		}

		if (this.participant != null) {
			substanceAdministration.getParticipant().clear();
			substanceAdministration.getParticipant()
					.add(this.participant.getAtcdabbrOtherParticipantBodyTranscriber(recordDate));
		}

		if (this.immunizationTargets != null) {
			int indexTarget = 0;
			for (Code immunizationTarget : this.immunizationTargets) {
				POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
				entryRel.setTypeCode(XActRelationshipEntryRelationship.RSON);
				entryRel.setObservation(getAtcdabbrEntryImmunizationTarget(indexTarget++, index, immunizationTarget));
				substanceAdministration.getEntryRelationship().add(entryRel);
			}
		}

		if (this.immunizationVoucher != null) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setAct(getAtcdabbrEntryImmunizationBillability());
			substanceAdministration.getEntryRelationship().add(entryRel);
		}

		if (this.originalImmunizationDocument != null) {
			POCDMT000040Reference referenceDoc = new POCDMT000040Reference();
			referenceDoc.setTypeCode(XActRelationshipExternalReference.REFR);
			referenceDoc.setExternalDocument(this.originalImmunizationDocument.getAtcdabbrEntryExternalDocument(0));
			substanceAdministration.getReference().add(referenceDoc);
		}
	}

	private void setProperties(POCDMT000040SubstanceAdministration substanceAdministration, int index,
			boolean noImmunization) {
		if (this.id != null) {
			substanceAdministration.getId().add(this.id.getHl7CdaR2Ii());
		}

		substanceAdministration.setText(new ED(null, new TEL("#immunization-entry-" + index)));

		if (!noImmunization) {
			setImmunizationProperties(substanceAdministration, index);
		}
	}

	private AtcdabbrEntryImmunizationTarget getAtcdabbrEntryImmunizationTarget(int indexTarget, int indexImmunization,
			Code immunizationTarget) {
		AtcdabbrEntryImmunizationTarget immunizationTargetObservation = new AtcdabbrEntryImmunizationTarget();

		if (immunizationTarget != null) {
			immunizationTargetObservation.setHl7Code(immunizationTarget.getHl7CdaR2Cd());
		}

		immunizationTargetObservation.setText(new ED(null, new TEL("#target-" + indexImmunization + "-" + indexTarget)));

		return immunizationTargetObservation;
	}

	private AtcdabbrEntryImmunizationBillability getAtcdabbrEntryImmunizationBillability() {
		AtcdabbrEntryImmunizationBillability immunizationBillabilityAct = new AtcdabbrEntryImmunizationBillability();

		if (immunizationReason != null) {
			CD cd = immunizationBillabilityAct.getCode();
			cd.getQualifier().clear();

			CR qualifier = new CR();
			qualifier.setValue(new CD(immunizationReason.getCode().getCode(),
					immunizationReason.getCode().getCodeSystem(), immunizationReason.getCode().getCodeSystemName(),
					immunizationReason.getCode().getDisplayName()));
			cd.getQualifier().add(qualifier);
			immunizationBillabilityAct.setCode(cd);
		}

		if (immunizationVoucher != null) {
			immunizationBillabilityAct.setHl7Id(immunizationVoucher.getHl7CdaR2Ii());
		}

		if (expirationDate != null) {
			immunizationBillabilityAct.setHl7EffectiveTime(DateTimes.toDateTs(expirationDate));
		} else {
			TS effectiveTimeUnk = new TS();
			effectiveTimeUnk.nullFlavor = new ArrayList<>();
			effectiveTimeUnk.nullFlavor.add("UNK");
			immunizationBillabilityAct.setHl7EffectiveTime(effectiveTimeUnk);
		}

		return immunizationBillabilityAct;
	}

}
