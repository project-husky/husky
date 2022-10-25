/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.XActMoodDocumentObservation;

/**
 * epims_entry_EmsOrganizerObservation
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.69<br>
 * Effective date: 2020-03-24 10:45:19<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryEmsOrganizerObservation extends POCDMT000040Observation {
    public EpimsEntryEmsOrganizerObservation() {
		super.getClassCode().add("OBS");
		super.setMoodCode(XActMoodDocumentObservation.EVN);
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.projecthusky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7Value
     */
    public org.projecthusky.common.hl7cdar2.ANY getHl7Value() {
		if (this.value != null && !this.value.isEmpty()) {
			return this.value.get(0);
		}

		return null;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.projecthusky.common.hl7cdar2.ANY value) {
        // TODO: NYI
    }
}
