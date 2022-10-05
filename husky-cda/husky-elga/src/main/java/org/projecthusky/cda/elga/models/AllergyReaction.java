/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import java.time.ZonedDateTime;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.ps.ProblemEntryAllergyReaction;
import org.projecthusky.cda.elga.generated.artdecor.ps.SeverityObservation;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.time.DateTimes;

public class AllergyReaction  {
	private Code reaction;
	private Code severity;
	private ZonedDateTime start;
	private ZonedDateTime stop;

	public Code getReaction() {
		return reaction;
	}

	public Code getSeverity() {
		return severity;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public ZonedDateTime getStop() {
		return stop;
	}

	public void setReaction(Code reaction) {
		this.reaction = reaction;
	}

	public void setSeverity(Code severity) {
		this.severity = severity;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public void setStop(ZonedDateTime stop) {
		this.stop = stop;
	}

	public POCDMT000040EntryRelationship getAllergyReactionObservationEntryRel(int indexReaction, int indexAllergy) {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.MFST);
		entryRel.setInversionInd(true);
		ProblemEntryAllergyReaction allergyReactionObservation = new ProblemEntryAllergyReaction();

		allergyReactionObservation.setText(new ED(null, new TEL("#react" + indexAllergy + "" + indexReaction)));

		IVLTS time = new IVLTS();
		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(this.start)));

		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(this.stop)));

		allergyReactionObservation.setEffectiveTime(time);

		CD code = this.reaction.getHl7CdaR2Cd();
		code.setOriginalText(new ED(null, new TEL("#react" + indexAllergy + "" + indexReaction)));
		allergyReactionObservation.getValue()
				.add(code);

		allergyReactionObservation.getEntryRelationship().add(getSeverityObservationEntryRel(indexReaction,
				indexAllergy,
				allergyReactionObservation.getEntryRelationship().get(0)));

		entryRel.setObservation(allergyReactionObservation);
		return entryRel;
	}

	private POCDMT000040EntryRelationship getSeverityObservationEntryRel(int indexReaction, int indexAllergy,
			POCDMT000040EntryRelationship entryRel) {
		SeverityObservation severityObservation = new SeverityObservation();

		severityObservation.setText(new ED(null, new TEL("#sev" + indexAllergy + "" + indexReaction)));

		CD code = this.severity.getHl7CdaR2Cd();
		code.setOriginalText(new ED(null, new TEL("#sev" + indexAllergy + "" + indexReaction)));
		severityObservation.getValue()
				.add(code);

		entryRel.setObservation(severityObservation);
		return entryRel;
	}

}
