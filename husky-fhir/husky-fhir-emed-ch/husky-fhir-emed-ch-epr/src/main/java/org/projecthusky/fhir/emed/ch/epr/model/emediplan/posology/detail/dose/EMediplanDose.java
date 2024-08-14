package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;

/**
 * This corresponds to the DosageObject definition in ChMed23A.
 */
public abstract class EMediplanDose {
    @JsonProperty("t")
    protected DoseType type;
}
