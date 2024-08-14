package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleDose extends EMediplanDose {
    /**
     * The amount to be applied.
     */
    @JsonProperty("a")
    protected Double amount;
}
