package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;

/**
 * Specifies the application of a medication with a minimal interval between two applications.
 */
public class IntervalDosage extends TimedDosage {
    /**
     * The dose to be applied.
     */
    @JsonProperty("do")
    protected EMediplanDose dose;
    /**
     * The amount of time of the interval that must elapse between two intakes of the medication.
     */
    @JsonProperty("miDu")
    protected int minimumDuration;
    /**
     * The time unit for the interval.
     */
    @JsonProperty("miDuU")
    protected TimeUnit durationUnit;
}
