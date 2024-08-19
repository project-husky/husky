package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.TimedDosage;

/**
 * Describes the application of a medication at constant intervals.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CyclicDosage extends PosologyDetail {
    /**
     * The cycle duration unit.
     */
    @JsonProperty("cyDuU")
    protected TimeUnit cycleDurationUnit;
    /**
     * The duration of a cycle.
     */
    @JsonProperty("cyDu")
    protected int cycleDuration;
    /**
     * Timing and dose of a medication to be applied. WeekDaysDosage is supported only if the cycle curation unit is
     * a week. DaysOfMonthDosage is supported only if the cycle duration unit is a month.
     */
    @JsonProperty("tdo")
    protected TimedDosage tdo;
    /**
     * Number of doses (as specified by tdo) to be applied per cycle. By default, 1 is assumed.
     */
    @JsonProperty("tdpc")
    protected @Nullable Integer numberOfDosesPerCycle;

    public CyclicDosage() {
        super(PosologyType.CYCLIC);
    }
}
