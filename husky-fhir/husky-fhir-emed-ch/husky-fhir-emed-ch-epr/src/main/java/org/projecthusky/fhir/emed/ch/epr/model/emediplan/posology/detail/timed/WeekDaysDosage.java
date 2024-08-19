package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DayOfWeek;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;

import java.util.List;

/**
 * Specifies on which days of the week a medication must be applied.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
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

    public WeekDaysDosage() {
        super(TimedDosageType.WEEK_DAYS);
    }
}
