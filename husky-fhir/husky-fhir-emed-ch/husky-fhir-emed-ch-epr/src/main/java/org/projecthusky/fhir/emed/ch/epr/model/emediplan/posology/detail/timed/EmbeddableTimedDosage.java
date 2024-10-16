package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;

/**
 * A {@link TimedDosage} that can be embedded within a {@link WeekDaysDosage}, a {@link DaysOfMonthDosage} or a
 * {@link org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.SingleDosage}
 * Inheritors:
 * <ul>
 *     <li>{@link DaySegmentsDosage}</li>
 *     <li>{@link DoseOnlyDosage}</li>
 *     <li>{@link PreciseTimesDosage}</li>
 * </ul>
 */
public abstract class EmbeddableTimedDosage extends TimedDosage {
    protected EmbeddableTimedDosage() {
        super();
    }
    protected EmbeddableTimedDosage(TimedDosageType type) {
        super(type);
    }
}
