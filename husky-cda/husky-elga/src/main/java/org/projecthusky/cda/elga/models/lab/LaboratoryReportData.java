/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.lab;

import java.util.List;

import org.projecthusky.cda.elga.generated.artdecor.base.Annotation;
import org.projecthusky.cda.elga.generated.artdecor.base.NotifiableCondition;
import org.projecthusky.cda.elga.generated.artdecor.base.NotificationOrganizer;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component4;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.POCDMT000040ObservationMedia;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organizer;
import org.projecthusky.common.hl7cdar2.POCDMT000040Procedure;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.XActClassDocumentEntryAct;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.hl7cdar2.XDocumentActMood;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;

public class LaboratoryReportData  {

	private Code structure;
	private List<SpecimenCollection> specimenCollections;
	private List<LaboratoryBatteryOrganizer> reportGroups;
	private List<LaboratoryObservation> results;
	private List<LaboratoryObservation> resultsActive;
	private List<CultureGermDetection> detections;
	private List<String> notes;
	private List<Code> notifications;
	private List<Appendix> appendices;

	public Code getStructure() {
		return structure;
	}

	public List<SpecimenCollection> getSpecimenCollections() {
		return specimenCollections;
	}

	public List<LaboratoryBatteryOrganizer> getReportGroups() {
		return reportGroups;
	}

	public List<LaboratoryObservation> getResults() {
		return results;
	}

	public List<LaboratoryObservation> getResultsActive() {
		return resultsActive;
	}

	public List<CultureGermDetection> getDetections() {
		return detections;
	}

	public List<String> getNotes() {
		return notes;
	}

	public List<Code> getNotifications() {
		return notifications;
	}

	public List<Appendix> getAppendices() {
		return appendices;
	}

	public void setStructure(Code structure) {
		this.structure = structure;
	}

	public void setSpecimenCollections(List<SpecimenCollection> specimenCollections) {
		this.specimenCollections = specimenCollections;
	}

	public void setReportGroups(List<LaboratoryBatteryOrganizer> reportGroups) {
		this.reportGroups = reportGroups;
	}

	public void setResults(List<LaboratoryObservation> results) {
		this.results = results;
	}

	public void setResultsActive(List<LaboratoryObservation> resultsActive) {
		this.resultsActive = resultsActive;
	}

	public void setDetections(List<CultureGermDetection> detections) {
		this.detections = detections;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public void setNotifications(List<Code> notifications) {
		this.notifications = notifications;
	}

	public void setAppendices(List<Appendix> appendices) {
		this.appendices = appendices;
	}

	public POCDMT000040Entry getPOCDMT000040Entry(String authorOid) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		entry.getTemplateId().add(new Identificator("1.3.6.1.4.1.19376.1.3.1").getHl7CdaR2Ii());
		entry.setAct(getPOCDMT000040Act(authorOid));
		return entry;
	}

	private POCDMT000040Act getPOCDMT000040Act(String authorOid) {
		POCDMT000040Act act = new POCDMT000040Act();
		act.setClassCode(XActClassDocumentEntryAct.ACT);
		act.setMoodCode(XDocumentActMood.EVN);
		act.setCode(structure.getHl7CdaR2Ce());
		act.setStatusCode(new CS("completed"));
		addEntryRelationships(act, authorOid);
		return act;
	}

	private void addEntryRelationships(POCDMT000040Act act, String authorOid) {
		if (specimenCollections != null && !specimenCollections.isEmpty()) {
			addSpecimenCollections(act, authorOid);
		} else if (reportGroups != null && !reportGroups.isEmpty()) {
			addReportGroups(act);
		} else if (results != null && !results.isEmpty()) {
			addResults(act);
		} else if (resultsActive != null && !resultsActive.isEmpty()) {
			addResultsActive(act);
		} else if (detections != null && !detections.isEmpty()) {
			addDetections(act);
		} else if (notes != null && !notes.isEmpty()) {
			addNotes(act);
		} else if (notifications != null && !notifications.isEmpty()) {
			addNotifications(act);
		} else if (appendices != null && !appendices.isEmpty()) {
			addAppendices(act);
		}

	}

	private void addSpecimenCollections(POCDMT000040Act act, String authorOid) {
		for (SpecimenCollection collection : specimenCollections) {
			act.getEntryRelationship().add(getEntryRelationship(null, null, null, null,
					collection.getLaboratorySpecimenCollection(authorOid)));
		}
	}

	private void addReportGroups(POCDMT000040Act act) {
		for (LaboratoryBatteryOrganizer reportGroup : reportGroups) {
			act.getEntryRelationship()
					.add(getEntryRelationship(null, null, null, reportGroup.getLaboratoryBatteryOrganizer(), null));
		}
	}

	private void addResults(POCDMT000040Act act) {
		int index = 0;
		for (LaboratoryObservation observation : results) {
			act.getEntryRelationship()
					.add(getEntryRelationship(null, observation.getLaboratoryObservation(index++), null, null, null));
		}
	}

	private void addResultsActive(POCDMT000040Act act) {
		for (LaboratoryObservation observation : resultsActive) {
			act.getEntryRelationship()
					.add(getEntryRelationship(null, observation.getLaboratoryObservationActive(), null, null, null));
		}
	}

	private void addDetections(POCDMT000040Act act) {
		for (CultureGermDetection detection : detections) {
			act.getEntryRelationship()
					.add(getEntryRelationship(null, null, null, detection.getKulturellerKeimnachweis(), null));
		}
	}

	private void addAppendices(POCDMT000040Act act) {
		int index = 0;
		for (Appendix appendix : appendices) {
			act.getEntryRelationship().add(getEntryRelationship(null, null,
					appendix.getEingebettetesObjektEntry("lab-speciality", index++), null, null));
		}
	}

	private void addNotes(POCDMT000040Act act) {
		for (int index = 0; index < notes.size(); index++) {
			Annotation annotation = new Annotation();
			annotation.setText(new ED(null, new TEL("#common-remark-" + index)));
			act.getEntryRelationship().add(getEntryRelationship(annotation, null, null, null, null));
		}
	}

	private void addNotifications(POCDMT000040Act act) {
		for (Code notification : notifications) {
			NotificationOrganizer notificationOrganizer = new NotificationOrganizer();
			POCDMT000040Component4 comp = new POCDMT000040Component4();
			comp.setTypeCode(ActRelationshipHasComponent.COMP);
			NotifiableCondition condition = new NotifiableCondition();
			condition.getValue().add(notification.getHl7CdaR2Ce());
			comp.setObservation(condition);
			notificationOrganizer.getComponent().add(comp);
			act.getEntryRelationship().add(getEntryRelationship(null, null, null, notificationOrganizer, null));
		}
	}

	private POCDMT000040EntryRelationship getEntryRelationship(POCDMT000040Act act, POCDMT000040Observation obersvation,
			POCDMT000040ObservationMedia obersvationMedia, POCDMT000040Organizer organizer,
			POCDMT000040Procedure procedure) {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		entryRel.setAct(act);
		entryRel.setOrganizer(organizer);
		entryRel.setObservationMedia(obersvationMedia);
		entryRel.setProcedure(procedure);
		entryRel.setObservation(obersvation);
		return entryRel;
	}

}
