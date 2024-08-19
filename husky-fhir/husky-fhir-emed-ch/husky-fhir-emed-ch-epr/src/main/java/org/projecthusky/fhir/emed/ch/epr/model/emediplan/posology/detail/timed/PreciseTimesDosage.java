package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application.ApplicationAtTime;

import java.util.List;

/**
 * Specifies precise times when a medication must be applied. This is named simply Times in ChMed23A.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PreciseTimesDosage extends EmbeddableTimedDosage {
    /**
     * Specifies the dosage to be applied at a certain time.
     */
    @JsonProperty("ts")
    protected List<@NonNull ApplicationAtTime> applications;

    public PreciseTimesDosage() {
        super(TimedDosageType.TIMES);
    }
}
