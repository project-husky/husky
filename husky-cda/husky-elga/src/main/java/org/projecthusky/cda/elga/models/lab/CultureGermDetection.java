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

import org.projecthusky.cda.elga.generated.artdecor.base.KulturellerKeimnachweis;
import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component4;
import org.projecthusky.common.utils.time.DateTimes;

public class CultureGermDetection extends Organizer {

	private Specimen specimen;
	private Antibiogram antibiogram;
	private ZonedDateTime samplingTime;

	public Specimen getSpecimen() {
		return specimen;
	}

	public Antibiogram getAntibiogram() {
		return antibiogram;
	}

	public ZonedDateTime getSamplingTime() {
		return samplingTime;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}

	public void setAntibiogram(Antibiogram antibiogram) {
		this.antibiogram = antibiogram;
	}

	public void setSamplingTime(ZonedDateTime samplingTime) {
		this.samplingTime = samplingTime;
	}

	public KulturellerKeimnachweis getKulturellerKeimnachweis() {
		KulturellerKeimnachweis detection = new KulturellerKeimnachweis();

		fillPOCDMT000040Organizer(detection);

		if (samplingTime != null) {
			detection.setHl7EffectiveTime(new IVLTS(DateTimes.toDateTs(samplingTime).getValue()));
		}

		detection.setHl7Specimen(specimen.getPOCDMT000040Specimen());

		if (antibiogram != null) {
			POCDMT000040Component4 comp = new POCDMT000040Component4();
			comp.setTypeCode(ActRelationshipHasComponent.COMP);
			comp.setOrganizer(antibiogram.getAntibiogram());
			detection.setHl7Component(comp);
		}

		return detection;
	}

}
