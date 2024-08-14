package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;

/**
 * Specifies a dosage without specifying a precise moment for the intake.
 */
public class DoseOnlyDosage extends EmbeddableTimedDosage {
    /**
     * Specifies the dose to be applied.
     */
    @JsonProperty("do")
    protected EMediplanDose dose;
}
