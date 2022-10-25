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

import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component4;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.time.DateTimes;

public class Antibiogram  {

	private ZonedDateTime resultTime;
	private Specimen specimen;
	private LaboratoryBatteryOrganizer laboratoryBattery;

	public ZonedDateTime getResultTime() {
		return resultTime;
	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public LaboratoryBatteryOrganizer getLaboratoryBattery() {
		return laboratoryBattery;
	}

	public void setResultTime(ZonedDateTime resultTime) {
		this.resultTime = resultTime;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}

	public void setLaboratoryBattery(LaboratoryBatteryOrganizer laboratoryBattery) {
		this.laboratoryBattery = laboratoryBattery;
	}

	public org.projecthusky.cda.elga.generated.artdecor.base.Antibiogram getAntibiogram() {
		org.projecthusky.cda.elga.generated.artdecor.base.Antibiogram antibiogram = new org.projecthusky.cda.elga.generated.artdecor.base.Antibiogram();

		if (resultTime != null) {
			antibiogram.setHl7EffectiveTime(new IVLTS(DateTimes.toDatetimeTs(this.resultTime).getValue()));
		}

		antibiogram.setHl7Specimen(specimen.getPOCDMT000040Specimen());

		POCDMT000040Component4 comp = new POCDMT000040Component4();
		comp.setTypeCode(ActRelationshipHasComponent.COMP);

		Code defaultCodeAntibiogram = new Code();
		defaultCodeAntibiogram.setCode("29576-6");
		defaultCodeAntibiogram.setCodeSystem("2.16.840.1.113883.6.1");
		defaultCodeAntibiogram.setCodeSystemName("LOINC");
		defaultCodeAntibiogram.setDisplayName("Antibiogramm");
		laboratoryBattery.setStructure(defaultCodeAntibiogram);

		comp.setOrganizer(laboratoryBattery.getLaboratoryBatteryOrganizer());

		antibiogram.setHl7Component(comp);
		
		return antibiogram;

	}

}
