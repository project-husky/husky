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

import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component4;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organizer;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.utils.time.DateTimes;

public class Organizer  {

	private List<LaboratoryObservation> laboratoryResults;
	private List<LaboratoryObservation> laboratoryResultsActive;
	private ZonedDateTime startDate;
	private ZonedDateTime stopDate;

	public List<LaboratoryObservation> getLaboratoryResults() {
		return laboratoryResults;
	}

	public List<LaboratoryObservation> getLaboratoryResultsActive() {
		return laboratoryResultsActive;
	}

	public ZonedDateTime getStartDate() {
		return startDate;
	}

	public ZonedDateTime getStopDate() {
		return stopDate;
	}

	public void setLaboratoryResults(List<LaboratoryObservation> laboratoryResults) {
		this.laboratoryResults = laboratoryResults;
	}

	public void setLaboratoryResultsActive(List<LaboratoryObservation> laboratoryResultsActive) {
		this.laboratoryResultsActive = laboratoryResultsActive;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public void setStopDate(ZonedDateTime stopDate) {
		this.stopDate = stopDate;
	}

	protected void fillPOCDMT000040Organizer(POCDMT000040Organizer organizer) {
		if (startDate != null && stopDate != null) {
			IVLTS time = new IVLTS();
			time.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(stopDate)));
			time.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(startDate)));
			organizer.setEffectiveTime(time);
		} else {
			IVLTS time = new IVLTS();
			time.getNullFlavor().add("UNK");
			organizer.setEffectiveTime(time);
		}

		addLaboratoryResults(organizer);
		addLaboratoryResultsActive(organizer);
	}

	private void addLaboratoryResultsActive(POCDMT000040Organizer organizer) {
		if (laboratoryResultsActive != null && !laboratoryResultsActive.isEmpty()) {
			for (LaboratoryObservation observation : laboratoryResultsActive) {
				if (observation != null) {
					organizer.getComponent()
							.add(getComponentWithObservation(observation.getLaboratoryObservationActive()));
				}
			}
		}
	}

	private void addLaboratoryResults(POCDMT000040Organizer organizer) {
		if (laboratoryResults != null && !laboratoryResults.isEmpty()) {
			int index = 0;
			for (LaboratoryObservation observation : laboratoryResults) {
				if (observation != null) {
					organizer.getComponent()
							.add(getComponentWithObservation(observation.getLaboratoryObservation(index)));
					index++;
				}
			}
		}
	}

	private POCDMT000040Component4 getComponentWithObservation(POCDMT000040Observation observation) {
		POCDMT000040Component4 component = new POCDMT000040Component4();
		component.setTypeCode(ActRelationshipHasComponent.COMP);
		component.setObservation(observation);
		return component;
	}

}
