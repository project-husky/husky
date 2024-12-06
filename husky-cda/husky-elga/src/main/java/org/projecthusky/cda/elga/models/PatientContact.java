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
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderComponentOfEncompassingEncounter;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderEncounterLocation;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.at.PractitionerAt;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040EncompassingEncounter;
import org.projecthusky.common.hl7cdar2.POCDMT000040HealthCareFacility;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.time.DateTimes;

public class PatientContact {

	private Identificator id;
	private Code encounterCode;
	private ZonedDateTime startTime;
	private ZonedDateTime stopTime;
	private PractitionerAt responsibleParty;

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public Code getEncounterCode() {
		return encounterCode;
	}

	public void setEncounterCode(Code encounterCode) {
		this.encounterCode = encounterCode;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(ZonedDateTime stopTime) {
		this.stopTime = stopTime;
	}

	public PractitionerAt getResponsibleParty() {
		return responsibleParty;
	}

	public void setResponsibleParty(PractitionerAt responsibleParty) {
		this.responsibleParty = responsibleParty;
	}

	public AtcdabbrHeaderComponentOfEncompassingEncounter getAtcdabbrHeaderComponentOfEncompassingEncounter() {
		AtcdabbrHeaderComponentOfEncompassingEncounter encounter = new AtcdabbrHeaderComponentOfEncompassingEncounter();
		POCDMT000040EncompassingEncounter encompassingEncounter = encounter.getEncompassingEncounter();

		if (id != null) {
			encompassingEncounter.getId().add(id.getHl7CdaR2Ii());
		}

		if (encounterCode != null) {
			encompassingEncounter.setCode(new CE(encounterCode.getCode(), encounterCode.getCodeSystem(),
					encounterCode.getCodeSystemName(), encounterCode.getDisplayName()));
		}

		encompassingEncounter.setEffectiveTime(new IVLTS());

		if (startTime != null) {
			encompassingEncounter.getEffectiveTime().getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(startTime)));
		}

		if (stopTime != null) {
			encompassingEncounter.getEffectiveTime().getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(stopTime)));
		}

		if (responsibleParty != null) {
			encompassingEncounter.setResponsibleParty(responsibleParty.getPOCDMT000040ResponsibleParty());
			encompassingEncounter.setLocation(getAtcdabbrHeaderEncounterLocation());
		}

		return encounter;
	}

	private AtcdabbrHeaderEncounterLocation getAtcdabbrHeaderEncounterLocation() {
		AtcdabbrHeaderEncounterLocation headerEncounterLocation = new AtcdabbrHeaderEncounterLocation();

		if (this.responsibleParty != null && this.responsibleParty.getOrganization() != null) {
			POCDMT000040HealthCareFacility healthcareFacility = headerEncounterLocation.getHealthCareFacility();
			healthcareFacility.setServiceProviderOrganization(
					responsibleParty.getOrganization().getHl7CdaR2Pocdmt000040Organization());
			headerEncounterLocation.setHl7HealthCareFacility(healthcareFacility);
		}

		return headerEncounterLocation;
	}


}
