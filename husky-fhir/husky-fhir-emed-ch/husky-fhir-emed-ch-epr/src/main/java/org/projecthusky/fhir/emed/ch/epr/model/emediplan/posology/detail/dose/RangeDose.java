package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A dose specifying a minimum and a maximum amount of medication.
 */
public class RangeDose extends EMediplanDose {
    /**
     * The minimum amount of medication that must be applied.
     */
    @JsonProperty("aMin")
    protected double minimumAmount;
    /**
     * Te maximum amount of medication that must be applied.
     */
    @JsonProperty("aMax")
    protected double maximumAmount;
}
