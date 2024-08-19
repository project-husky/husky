package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;

/**
 * This corresponds to the DosageObject definition in ChMed23A.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EMediplanDose {
    @JsonProperty("t")
    protected DoseType type;
}
