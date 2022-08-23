/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.generated.artdecor.ps.AllergienUnvertraeglichkeitenEntry;
import org.husky.cda.elga.generated.artdecor.ps.AllergyProblemEntry;
import org.husky.cda.elga.generated.artdecor.ps.AllergyStatusObservation;
import org.husky.cda.elga.generated.artdecor.ps.CertaintyObservation;
import org.husky.cda.elga.generated.artdecor.ps.CriticalityObservation;
import org.husky.cda.elga.generated.artdecor.ps.ParticipantAllergy;
import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Participant2;
import org.husky.common.hl7cdar2.POCDMT000040PlayingEntity;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.model.Code;
import org.husky.common.utils.time.DateTimes;

public class Allergy  {
	private boolean active;
	private ZonedDateTime start;
	private ZonedDateTime stop;
	private PractitionerCdaAt author;
	private Informant informant;
	private Code kindOfAllergy;
	private Code absentAllergy;
	private List<AllergyReaction> reactions;
	private Code allergyAgent;
	private Code clinicalState;
	private Code verificationState;
	private Code criticality;
	private String text;

	public Allergy(String text) {
		this.text = text;
	}

	public Allergy(POCDMT000040Entry entry) {
		// TODO: implement entry for coded allergies
	}

	public Code getAbsentAllergy() {
		return absentAllergy;
	}

	public Code getAllergyAgent() {
		return allergyAgent;
	}

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public Code getClinicalState() {
		return clinicalState;
	}

	public Code getCriticality() {
		return criticality;
	}

	public Informant getInformant() {
		return informant;
	}

	public Code getKindOfAllergy() {
		return kindOfAllergy;
	}

	public List<AllergyReaction> getReactions() {
		return reactions;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public ZonedDateTime getStop() {
		return stop;
	}

	public String getText() {
		return text;
	}

	public Code getVerificationState() {
		return verificationState;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setAbsentAllergy(Code absentAllergy) {
		this.absentAllergy = absentAllergy;
	}

	public void setActive(boolean state) {
		this.active = state;
	}

	public void setAllergyAgent(Code allergyAgent) {
		this.allergyAgent = allergyAgent;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public void setClinicalState(Code clinicalState) {
		this.clinicalState = clinicalState;
	}

	public void setCriticality(Code criticality) {
		this.criticality = criticality;
	}

	public void setInformant(Informant informant) {
		this.informant = informant;
	}

	public void setKindOfAllergy(Code kindOfAllergy) {
		this.kindOfAllergy = kindOfAllergy;
	}

	public void setReactions(List<AllergyReaction> reactions) {
		this.reactions = reactions;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public void setStop(ZonedDateTime stop) {
		this.stop = stop;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setVerificationState(Code verificationState) {
		this.verificationState = verificationState;
	}

	/**
	 * <div class="en">Creates the HL7 CDA R2 data type from the given type.<div>
	 *
	 * <div class="de">Erstellt den HL7 CDA R2 Datentyp aus dem angegebenen
	 * Typ.<div>
	 *
	 * @param index id for attr
	 * @return the HL7 CDA R2 data typed value
	 */
	public POCDMT000040Entry getHl7CdaR2AllergyEntry(int index) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setAct(getAllergiesIntoleranceEntry(index));
		return entry;
	}

	protected AllergienUnvertraeglichkeitenEntry getAllergiesIntoleranceEntry(int index) {
		AllergienUnvertraeglichkeitenEntry allergyAct = new AllergienUnvertraeglichkeitenEntry();

		if (this.author != null) {
			allergyAct.addHl7Author(this.author.getAuthorBodyPs(this.start));
		}

		if (this.informant != null) {
			allergyAct.addHl7Informant(this.informant.getInformantBodyPs());
		}

		if (!this.active) {
			allergyAct.setStatusCode(new CS("completed"));
		}

		IVLTS time = new IVLTS();

		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(this.start)));

		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(this.stop)));

		allergyAct.setEffectiveTime(time);

		allergyAct.addHl7EntryRelationship(getAllergyProblemEntryObservation(index));

		return allergyAct;
	}

	protected POCDMT000040EntryRelationship getAllergyProblemEntryObservation(int index) {
		POCDMT000040EntryRelationship entry = new POCDMT000040EntryRelationship();

		AllergyProblemEntry allergyObservation = new AllergyProblemEntry();

		if (this.kindOfAllergy != null) {
			allergyObservation.setCode(this.kindOfAllergy.getHl7CdaR2Cd());
			allergyObservation.setText(new ED(null, new TEL("#typ" + index)));
		}

		allergyObservation.setStatusCode(new CS("completed"));

		allergyObservation.setEffectiveTime(getIVLTSTime());

		if (this.absentAllergy != null) {
			allergyObservation.setHl7Value(this.absentAllergy.getHl7CdaR2Cd());
		} else {
			if (this.reactions != null && !this.reactions.isEmpty()) {
				allergyObservation.getEntryRelationship().addAll(getAllergyReactions(this.reactions, index));
			}

			if (this.allergyAgent != null) {
				allergyObservation.getParticipant().add(getParticipantAllergy(index));
			}

			if (this.criticality != null) {
				allergyObservation.getEntryRelationship().add(getCriticalityObservationEntryRel(index));
			}

			if (this.verificationState != null) {
				allergyObservation.getEntryRelationship().add(getCertaintyObservationEntryRel(index));
			}

			if (this.clinicalState != null) {
				allergyObservation.getEntryRelationship().add(getAllergyStatusObservationEntryRel(index));
			}
		}

		entry.setObservation(allergyObservation);
		return entry;
	}

	private List<POCDMT000040EntryRelationship> getAllergyReactions(List<AllergyReaction> reactions, int index) {
		List<POCDMT000040EntryRelationship> entryRels = new LinkedList<>();

		int indexReaction = 0;
		for (AllergyReaction reaction : reactions) {
			if (reaction != null) {
				entryRels.add(reaction.getAllergyReactionObservationEntryRel(indexReaction++, index));
			}
		}

		return entryRels;
	}

	private IVLTS getIVLTSTime() {
		IVLTS time = new IVLTS();

		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(this.start)));

		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(this.stop)));

		return time;
	}

	protected POCDMT000040EntryRelationship getAllergyStatusObservationEntryRel(int index) {
		POCDMT000040EntryRelationship entryRel = null;
		if (this.clinicalState != null) {
			entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.REFR);
			entryRel.setInversionInd(false);
			AllergyStatusObservation observation = new AllergyStatusObservation();
			observation.setText(new ED(null, new TEL("#status" + index)));

			CD code = this.clinicalState.getHl7CdaR2Cd();
			code.setOriginalText(new ED(null, new TEL("#state" + index)));
			observation.setHl7Value(code);
			entryRel.setObservation(observation);
		}
		return entryRel;
	}

	protected POCDMT000040EntryRelationship getCertaintyObservationEntryRel(int index) {
		POCDMT000040EntryRelationship entryRel = null;
		if (this.verificationState != null) {
			entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(true);
			CertaintyObservation observation = new CertaintyObservation();
			observation.setCode(new Code("NEW-LOINC-CERTAINTY", "2.16.840.1.113883.6.1", null, null).getHl7CdaR2Cd());
			
			CD code = this.verificationState.getHl7CdaR2Cd();
			code.setOriginalText(new ED(null, new TEL("#cert" + index)));
			observation.setHl7Value(code);
			entryRel.setObservation(observation);
		}
		return entryRel;
	}

	protected POCDMT000040EntryRelationship getCriticalityObservationEntryRel(int index) {
		POCDMT000040EntryRelationship entryRel = null;
		if (this.criticality != null) {
			entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(true);
			CriticalityObservation observation = new CriticalityObservation();
			CD code = this.criticality.getHl7CdaR2Cd();
			code.setOriginalText(new ED(null, new TEL("#crit" + index)));
			observation.setHl7Value(code);
			entryRel.setObservation(observation);
		}
		return entryRel;
	}

	protected POCDMT000040Participant2 getParticipantAllergy(int index) {
		POCDMT000040Participant2 participant2 = null;
		if (this.allergyAgent != null) {
			participant2 = new POCDMT000040Participant2();
			participant2.getTypeCode().add("CSM");
			ParticipantAllergy participant = new ParticipantAllergy();
			participant
					.addHl7PlayingEntity(getHl7CdaR2Pocdmt000040PlayingEntity(participant.getPlayingEntity(), index));
			participant2.setParticipantRole(participant);
		}
		return participant2;
	}

	protected POCDMT000040PlayingEntity getHl7CdaR2Pocdmt000040PlayingEntity(POCDMT000040PlayingEntity entity,
			int index) {
		if (this.allergyAgent != null && this.allergyAgent.getCode() != null) {
			CE retVal = this.allergyAgent.getHl7CdaR2Ce();
			retVal.setOriginalText(new ED(null, new TEL("#alg" + index)));
			entity.setCode(retVal);
		}

		return entity;
	}

}
