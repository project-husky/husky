package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DayOfWeek;

import java.util.List;

/**
 * Specifies on which days of the week a medication must be applied.
 */
public class WeekDaysDosage extends TimedDosage {
    /**
     * The days of the week for which the embedded timed dosage must be applied.
     */
    @JsonProperty("wds")
    protected List<@NonNull DayOfWeek> weekdays;
    /**
     * The embedded timed dosage specifying the timing and dosage of the medication to be applied in the specified days
     * of the week.
     */
    @JsonProperty("tdo")
    protected EmbeddableTimedDosage dosage;
}
