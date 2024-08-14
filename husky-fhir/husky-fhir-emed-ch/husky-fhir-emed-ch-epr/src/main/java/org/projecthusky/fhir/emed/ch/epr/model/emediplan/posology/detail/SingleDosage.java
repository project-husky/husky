package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.EmbeddableTimedDosage;

/**
 * Describes a single application of a medicament.
 */
public class SingleDosage extends PosologyDetail {
    /**
     * Specifies the timing and dose of a medication to be applied.
     */
    @JsonProperty("tdo")
    protected EmbeddableTimedDosage timedDosage;
}
