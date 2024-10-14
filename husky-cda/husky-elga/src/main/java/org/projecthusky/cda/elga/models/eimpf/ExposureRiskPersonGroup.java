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
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryExpositionsrisikoProblemConcern;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.models.Translation;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Reference;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.hl7cdar2.XActRelationshipExternalReference;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.time.DateTimes;

public class ExposureRiskPersonGroup {

	private Identificator id;
	private boolean active;
	private ZonedDateTime startProblem;
	private ZonedDateTime finishProblem;
	private PractitionerCdaAt author;
	private ZonedDateTime authTime;
	private ExposureRiskProblem risk;
	private Appendix originalReport;
	private List<Translation> translations;

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ZonedDateTime getStartProblem() {
		return startProblem;
	}

	public void setStartProblem(ZonedDateTime startProblem) {
		this.startProblem = startProblem;
	}

	public ZonedDateTime getFinishProblem() {
		return finishProblem;
	}

	public void setFinishProblem(ZonedDateTime finishProblem) {
		this.finishProblem = finishProblem;
	}

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public ZonedDateTime getAuthTime() {
		return authTime;
	}

	public void setAuthTime(ZonedDateTime authTime) {
		this.authTime = authTime;
	}

	public ExposureRiskProblem getRisk() {
		return risk;
	}

	public void setRisk(ExposureRiskProblem risk) {
		this.risk = risk;
	}

	public Appendix getOriginalReport() {
		return originalReport;
	}

	public void setOriginalReport(Appendix originalReport) {
		this.originalReport = originalReport;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}


	public POCDMT000040Entry getExposureRiskPersonGroupEntry(int index) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		entry.setContextConductionInd(true);
		AtcdabbrEntryExpositionsrisikoProblemConcern immunization = new AtcdabbrEntryExpositionsrisikoProblemConcern();

		if (this.id != null) {
			immunization.getId().add(this.id.getHl7CdaR2Ii());
		}

		if (active) {
			immunization.setHl7StatusCode(new CS("active"));
			if (startProblem != null) {
				IVLTS time = new IVLTS();
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(startProblem)));
				immunization.setEffectiveTime(time);
			}
		} else {
			immunization.setHl7StatusCode(new CS("completed"));
			if (startProblem != null && finishProblem != null) {
				IVLTS time = new IVLTS();
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(startProblem)));
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(finishProblem)));
				immunization.setEffectiveTime(time);
			}
		}

		if (this.author != null) {
			immunization.getAuthor().add(this.author.getAtcdabbrOtherAuthorBodyEImpfpass(authTime));
		}

		if (this.risk != null) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(false);
			entryRel.setContextConductionInd(true);
			entryRel.setObservation(risk.getExposureRiskProblem(index));
			immunization.getEntryRelationship().add(entryRel);
		}

		if (this.originalReport != null) {
			POCDMT000040Reference reference = new POCDMT000040Reference();
			reference.setTypeCode(XActRelationshipExternalReference.REFR);
			reference.setExternalDocument(this.originalReport.getAtcdabbrEntryExternalDocument(index));
			immunization.getReference().add(reference);
		}

		entry.setAct(immunization);
		return entry;
	}


}
