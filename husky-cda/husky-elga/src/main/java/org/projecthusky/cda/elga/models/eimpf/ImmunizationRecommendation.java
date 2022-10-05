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
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunizationRecommendation;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunizationTarget;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrOtherVaccineProductNichtAngegeben;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabrrEntryComment;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.cda.elga.models.Comment;
import org.projecthusky.cda.elga.models.Drug;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.models.Translation;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Reference;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.time.DateTimes;

public class ImmunizationRecommendation {

	private Identificator id;
	private Code vaccinationIndication;
	private ZonedDateTime startRecommendation;
	private ZonedDateTime stopRecommendation;
	private Drug drug;
	private PractitionerCdaAt author;
	private ZonedDateTime timeAuthor;
	private List<Comment> comments;
	private Appendix externalDocument;
	private Appendix immunizationPlan;
	private List<Code> immunizationTargets;
	private ImmunizationSchedule schedule;
	private List<Translation> translations;

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public Code getVaccination() {
		return vaccinationIndication;
	}

	public void setVaccination(Code vaccination) {
		this.vaccinationIndication = vaccination;
	}

	public ZonedDateTime getStartRecommendation() {
		return startRecommendation;
	}

	public void setStartRecommendation(ZonedDateTime startRecommendation) {
		this.startRecommendation = startRecommendation;
	}

	public ZonedDateTime getStopRecommendation() {
		return stopRecommendation;
	}

	public void setStopRecommendation(ZonedDateTime stopRecommendation) {
		this.stopRecommendation = stopRecommendation;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public ZonedDateTime getTimeAuthor() {
		return timeAuthor;
	}

	public void setTimeAuthor(ZonedDateTime timeAuthor) {
		this.timeAuthor = timeAuthor;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Appendix getExternalDocument() {
		return externalDocument;
	}

	public void setExternalDocument(Appendix externalDocument) {
		this.externalDocument = externalDocument;
	}

	public Appendix getImmunizationPlan() {
		return immunizationPlan;
	}

	public void setImmunizationPlan(Appendix immunizationPlan) {
		this.immunizationPlan = immunizationPlan;
	}

	public List<Code> getImmunizationTargets() {
		return immunizationTargets;
	}

	public void setImmunizationTargets(List<Code> immunizationTargets) {
		this.immunizationTargets = immunizationTargets;
	}

	public ImmunizationSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(ImmunizationSchedule schedule) {
		this.schedule = schedule;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

	public POCDMT000040Entry getImmunizationRecommendationEntry(int index) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		entry.setContextConductionInd(true);
		AtcdabbrEntryImmunizationRecommendation immunization = new AtcdabbrEntryImmunizationRecommendation();

		if (this.id != null) {
			immunization.getId().add(this.id.getHl7CdaR2Ii());
		}

		immunization.setText(new ED(null, new TEL("#recommendation-" + index)));

		immunization.getEffectiveTime().add(createIntervalEffectiveTime(DateTimes.toDateTs(startRecommendation),
				DateTimes.toDateTs(stopRecommendation)));

		if (this.vaccinationIndication != null) {
			immunization.setCode(new CD(vaccinationIndication.getCode(), vaccinationIndication.getCodeSystem(),
					vaccinationIndication.getCodeSystemName(), vaccinationIndication.getDisplayName()));
		}

		if (this.drug != null) {
			immunization.setConsumable(this.drug.getVaccineProduct(true));
		} else {
			POCDMT000040Consumable consumable = new POCDMT000040Consumable();
			consumable.getTypeCode().add("CSM");
			consumable.setManufacturedProduct(new AtcdabbrOtherVaccineProductNichtAngegeben());
			immunization.setConsumable(consumable);
		}

		if (this.author != null) {
			if (timeAuthor == null) {
				timeAuthor = ZonedDateTime.now();
			}

			immunization.setHl7Author(this.author.getAtcdabbrOtherAuthorBodyEImpfpass(timeAuthor));
		}

		if (this.immunizationTargets != null && !this.immunizationTargets.isEmpty()) {
			setImmunizationTargets(immunization);
		}

		if (this.comments != null && !this.comments.isEmpty()) {
			setComments(immunization);
		}

		if (this.externalDocument != null) {
			POCDMT000040Reference ref = new POCDMT000040Reference();
			ref.setExternalDocument(this.externalDocument.getAtcdabbrEntryExternalDocument(0));
			immunization.getReference().add(ref);
		}

		if (this.immunizationPlan != null) {
			POCDMT000040Reference ref = new POCDMT000040Reference();
			ref.setExternalDocument(this.immunizationPlan.getAtcdabbrEntryImpfPlan(0));
			immunization.getReference().add(ref);
		}

		if (this.schedule != null) {
			immunization.setHl7Precondition(this.schedule.getImmunizationRecommendationEntry(index));
		}

		entry.setSubstanceAdministration(immunization);
		return entry;
	}

	protected SXCMTS createIntervalEffectiveTime(TS low, TS high) {
		IVLTS time = new IVLTS();
		time.getRest().add(
				new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, low));
		time.getRest().add(new JAXBElement<>(
				new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class, high));

		return time;
	}

	private void setComments(AtcdabbrEntryImmunizationRecommendation immunization) {
		int commmentIndex = 0;
		for (Comment comment : this.comments) {
			if (comment != null) {
				AtcdabrrEntryComment commentAct = comment.getAtcdabbrEntryComment(commmentIndex);
				commentAct.setText(new ED(null, new TEL("#impfempf-comment-" + commmentIndex++)));
				POCDMT000040EntryRelationship entryRel = AtcdabbrEntryImmunizationRecommendation
						.getPredefinedEntryRelationshipRsonTrue();
				entryRel.setAct(commentAct);
				immunization.addHl7EntryRelationship(entryRel);
			}
		}
	}

	private void setImmunizationTargets(AtcdabbrEntryImmunizationRecommendation immunization) {
		int targetIndex = 0;
		for (Code immunizationTarget : this.immunizationTargets) {
			AtcdabbrEntryImmunizationTarget target = new AtcdabbrEntryImmunizationTarget();
			target.setCode(new CE(immunizationTarget.getCode(), immunizationTarget.getCodeSystem(),
					immunizationTarget.getCodeSystemName(), immunizationTarget.getDisplayName()));
			target.setText(new ED(null, new TEL("#immunization-target-" + targetIndex++)));
			POCDMT000040EntryRelationship entryRel = AtcdabbrEntryImmunizationRecommendation
					.getPredefinedEntryRelationshipRsonTrue();
			entryRel.setObservation(target);
			immunization.addHl7EntryRelationship(entryRel);
		}
	}

}
