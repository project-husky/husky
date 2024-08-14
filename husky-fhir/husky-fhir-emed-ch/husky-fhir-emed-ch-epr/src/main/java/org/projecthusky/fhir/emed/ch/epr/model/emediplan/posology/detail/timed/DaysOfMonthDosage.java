package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

/**
 * Specifies on which days of the month a medication must be applied.
 */
public class DaysOfMonthDosage extends TimedDosage {
    /**
     * The days of the month in which the medication must be applied. Each number must be greater than 0 and lesser or
     * equal than 28.
     */
    @JsonProperty("doms")
    protected List<@NonNull Integer> daysOfMonth;
    /**
     * The timed dosage object specifying the timing and dosage of the medication to be applied.
     */
    @JsonProperty("tdo")
    protected EmbeddableTimedDosage dosage;
}
