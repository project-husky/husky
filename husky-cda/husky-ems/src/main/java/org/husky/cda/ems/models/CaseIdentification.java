/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.ems.models;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Map.Entry;

import org.husky.cda.ems.generated.artdecor.EpimsEntryCaseIdentificationArzt;
import org.husky.cda.ems.generated.artdecor.EpimsEntryEmsOrganizerObservation;
import org.husky.cda.ems.generated.artdecor.EpimsEntryEmsorganizerArzt;
import org.husky.cda.ems.generated.artdecor.EpimsEntryForeignCountry;
import org.husky.cda.ems.generated.artdecor.EpimsEntryInformant;
import org.husky.cda.ems.generated.artdecor.EpimsEntryNotificationOrganizerArzt;
import org.husky.cda.ems.utils.DateTimeUtils;
import org.husky.common.hl7cdar2.ActRelationshipHasComponent;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.CR;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.CV;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040Component4;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Organizer;
import org.husky.common.hl7cdar2.XActClassDocumentEntryAct;
import org.husky.common.hl7cdar2.XActRelationshipEntry;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.hl7cdar2.XDocumentActMood;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.time.DateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaseIdentification {
	private static final Logger LOGGER = LoggerFactory.getLogger(CaseIdentification.class.getName());
	private ZonedDateTime diagnosisDate;
	private Code disease;
	private Code diagnosisConfidence;
	private Map<Code, Code> fieldValues;
	private Code country;
	private ZonedDateTime startStayAbroad;
	private ZonedDateTime stopStayAbroad;
	private ZonedDateTime timeOfDisease;

	public ZonedDateTime getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(ZonedDateTime diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public Code getDisease() {
		return disease;
	}

	public void setDisease(Code disease) {
		this.disease = disease;
	}

	public Code getDiagnosisConfidence() {
		return diagnosisConfidence;
	}

	public void setDiagnosisConfidence(Code diagnosisConfidence) {
		this.diagnosisConfidence = diagnosisConfidence;
	}

	public Map<Code, Code> getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(Map<Code, Code> fieldValues) {
		this.fieldValues = fieldValues;
	}

	public Code getCountry() {
		return country;
	}

	public void setCountry(Code country) {
		this.country = country;
	}

	public ZonedDateTime getStartStayAbroad() {
		return startStayAbroad;
	}

	public void setStartStayAbroad(ZonedDateTime startStayAbroad) {
		this.startStayAbroad = startStayAbroad;
	}

	public ZonedDateTime getStopStayAbroad() {
		return stopStayAbroad;
	}

	public void setStopStayAbroad(ZonedDateTime stopStayAbroad) {
		this.stopStayAbroad = stopStayAbroad;
	}

	public ZonedDateTime getTimeOfDisease() {
		return timeOfDisease;
	}

	public void setTimeOfDisease(ZonedDateTime timeOfDisease) {
		this.timeOfDisease = timeOfDisease;
	}

	public POCDMT000040Entry getEpimsEntryCaseIdenticationArzt() {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		entry.getTemplateId().add(new Identificator("1.3.6.1.4.1.19376.1.3.1").getHl7CdaR2Ii());
		EpimsEntryCaseIdentificationArzt observationCaseIdentication = new EpimsEntryCaseIdentificationArzt();

		if (this.diagnosisDate != null) {
			observationCaseIdentication.setEffectiveTime(new IVLTS(DateTimes.toDateTs(diagnosisDate).getValue()));
		}

		CD diseaseCD = this.disease.getHl7CdaR2Cd();
		ObjectFactory factory = new ObjectFactory();
		CR cr = factory.createCR();
		CV cvName = factory.createCV();
		cvName.setCode("8");
		cvName.setCodeSystem("2.16.840.1.113883.3.7.1.0");
		cr.setName(cvName);
		cr.setValue(diagnosisConfidence.getHl7CdaR2Cd());
		diseaseCD.getQualifier().add(cr);
		observationCaseIdentication.getValue().add(diseaseCD);

		if (timeOfDisease != null) {
			observationCaseIdentication.getInformant().clear();
			observationCaseIdentication.getInformant().add(getEpimsEntryInformant());
		}

		entry.setAct(getAct(getOrganizer(observationCaseIdentication)));
		return entry;
	}

	private POCDMT000040Organizer getOrganizer(EpimsEntryCaseIdentificationArzt observationCaseIdentication) {
		EpimsEntryNotificationOrganizerArzt organizerArzt = new EpimsEntryNotificationOrganizerArzt();
		organizerArzt.getComponent().get(0).setObservation(observationCaseIdentication);
		return organizerArzt;
	}

	private EpimsEntryInformant getEpimsEntryInformant() {
		EpimsEntryInformant informant = new EpimsEntryInformant();
		informant.getRelatedEntity().setEffectiveTime(new IVLTS(DateTimes.toDateTs(timeOfDisease).getValue()));
		return informant;
	}

	private POCDMT000040Act getAct(POCDMT000040Organizer organizer) {
		POCDMT000040Act act = new POCDMT000040Act();
		act.setMoodCode(XDocumentActMood.EVN);
		act.setClassCode(XActClassDocumentEntryAct.ACT);

		ObjectFactory factory = new ObjectFactory();
		CD code = factory.createCD();
		code.setCode("34782-3");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		code.setDisplayName("Infectious disease Note");
		act.setCode(code);

		CS statusCode = factory.createCS();
		statusCode.setCode("completed");
		act.setStatusCode(statusCode);

		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		entryRel.setOrganizer(organizer);
		act.getEntryRelationship().add(entryRel);

		if (this.fieldValues != null && !this.fieldValues.isEmpty()) {
			act.getEntryRelationship().add(getEntryRelEMSOrganizerArzt());
		} else {
			LOGGER.info("No fields are given");
		}

		return act;
	}

	private POCDMT000040EntryRelationship getEntryRelEMSOrganizerArzt() {
		EpimsEntryEmsorganizerArzt organizer = new EpimsEntryEmsorganizerArzt();

		for (Entry<Code, Code> entry : fieldValues.entrySet()) {
			if (entry != null && entry.getKey() != null && entry.getValue() != null) {
				organizer.getComponent().add(getEntryCompEmsOrganizerObservation(entry.getKey(), entry.getValue()));
			} else {
				LOGGER.warn("value or field is null");
			}
		}

		if (country != null && startStayAbroad != null) {
			organizer.getComponent().add(getEntryCompEpimsEntryForeignCountry());
		} else {
			LOGGER.info("country or stay abroad is null");
		}

		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		entryRel.setOrganizer(organizer);

		return entryRel;
	}

	private POCDMT000040Component4 getEntryCompEmsOrganizerObservation(Code code, Code value) {
		POCDMT000040Component4 comp = new POCDMT000040Component4();
		comp.setTypeCode(ActRelationshipHasComponent.COMP);

		EpimsEntryEmsOrganizerObservation observation = new EpimsEntryEmsOrganizerObservation();
		observation.setCode(code.getHl7CdaR2Cd());
		observation.setHl7Value(value.getHl7CdaR2Cd());
		comp.setObservation(observation);

		return comp;
	}

	private POCDMT000040Component4 getEntryCompEpimsEntryForeignCountry() {
		POCDMT000040Component4 comp = new POCDMT000040Component4();
		comp.setTypeCode(ActRelationshipHasComponent.COMP);

		EpimsEntryForeignCountry observation = new EpimsEntryForeignCountry();

		observation.setEffectiveTime(DateTimeUtils.createIvlts(this.startStayAbroad, this.stopStayAbroad));

		CD value = new CD();
		value.setCode("AL");
		value.setCodeSystem("1.2.40.0.34.5.77");
		CR cr = new CR();
		CV cv = new CV();
		cv.setCode("TRVCNTRY");
		cv.setCodeSystem("1.2.40.0.34.5.101");
		cr.setName(cv);
		cr.setValue(country.getHl7CdaR2Cd());
		value.getQualifier().add(cr);
		observation.setHl7Value(value);

		comp.setObservation(observation);

		return comp;
	}

}
