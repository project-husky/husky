package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is what ChMed23A calls DosageFromTo. It specifies how a dose changes during time, e.g. for infusions, starting
 * at one value and ending at a different value during the specified amount of time.
 */
public class IntervalDose extends EMediplanDose {
    /**
     * The dose start amount.
     */
    @JsonProperty("aFrom")
    protected double initialAmount;
    /**
     * The end start amount.
     */
    @JsonProperty("aTo")
    protected double finalAmount;
    /**
     * The unit of the dose duration.
     */
    @JsonProperty("duU")
    protected int durationUnit;
    /**
     * The duration (amount).
     */
    @JsonProperty("du")
    protected int duration;
}
