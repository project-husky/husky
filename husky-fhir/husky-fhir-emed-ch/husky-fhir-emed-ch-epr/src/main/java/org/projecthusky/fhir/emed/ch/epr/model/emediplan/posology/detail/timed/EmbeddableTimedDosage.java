package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

/**
 * A {@link TimedDosage} that can be embedded within a {@link WeekDaysDosage} or a {@link DaysOfMonthDosage}.
 * Inheritors:
 * <ul>
 *     <li>{@link DaySegmentsDosage}</li>
 *     <li>{@link DoseOnlyDosage}</li>
 *     <li>{@link PreciseTimesDosage}</li>
 * </ul>
 */
public abstract class EmbeddableTimedDosage extends TimedDosage {
}
