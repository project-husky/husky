package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.EmbeddableTimedDosage;

/**
 * Describes a single application of a medicament.
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Getter
@Setter
public class SingleDosage extends PosologyDetail {
    /**
     * Specifies the timing and dose of a medication to be applied.
     */
    @JsonProperty("tdo")
    protected EmbeddableTimedDosage timedDosage;

    public SingleDosage() {
        super(PosologyType.SINGLE);
    }

    public SingleDosage(final EmbeddableTimedDosage dosage) {
        this();
        timedDosage = dosage;
    }
}
