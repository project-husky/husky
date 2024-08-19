package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;

/**
 * Specifies a dose that must be applied at certain times, either at a precise moment or in a day's segment (i.e.
 * morning, noon, evening or night).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Application {
    @JsonProperty("do")
    protected EMediplanDose dose;
}
