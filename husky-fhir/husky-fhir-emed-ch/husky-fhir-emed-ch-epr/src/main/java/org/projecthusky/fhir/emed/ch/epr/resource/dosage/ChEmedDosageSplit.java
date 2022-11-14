package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Timing;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;

import java.util.ArrayList;
import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-DosageSplit.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedDosageSplit extends Dosage {

    /**
     * Empty constructor for the parser
     */
    public ChEmedDosageSplit() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param sequence the order of the dosage instructions
     */
    public ChEmedDosageSplit(final int sequence) {
        super();
        this.setSequence(sequence);
    }

    /**
     * Gets the order of the dosage instructions.
     *
     * @return the order of the dosage instructions.
     * @throws InvalidEmedContentException if the order of the dosage instructions is less than 1.
     */
    @Override
    @ExpectsValidResource
    public int getSequence() throws InvalidEmedContentException {
        if (super.getSequence() < 1) throw new InvalidEmedContentException("The order of the dosage instructions is is less than 1.");
        return super.getSequence();
    }

    /**
     * Resolves the list of with event timings.
     *
     * @return the list of with event timings.
     * @throws InvalidEmedContentException if dosage for time period of occurrence is invalid.
     */
    @Nullable
    @ExpectsValidResource
    public List<TimingEventAmbu> resolveWhen() throws InvalidEmedContentException {
        final var repeat = this.getTiming().getRepeat();
        if (!repeat.hasWhen()) return null;

        final var eventTimings = new ArrayList<TimingEventAmbu>();
        for (final var event : repeat.getWhen()) {
            final var eventTiming = TimingEventAmbu.getEnum(event.getCode());
            if (eventTiming == null) {
                throw new InvalidEmedContentException("The event timing is invalid.");
            }
            eventTimings.add(eventTiming);
        }
        return eventTimings;
    }

    /**
     * Resolve the dose quantity.
     *
     * @return the dose quantity or {@code null}.
     * @throws InvalidEmedContentException if the dose quantity isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveDoseQuantity() throws InvalidEmedContentException {
        if (!this.hasDoseAndRate() || !this.getDoseAndRateFirstRep().hasDoseQuantity()) return null;
        final var doseQuantity = this.getDoseAndRateFirstRep().getDoseQuantity();
        if (doseQuantity instanceof ChEmedQuantityWithEmedUnits chDoseQuantity) {
            return chDoseQuantity;
        }
        throw new InvalidEmedContentException("The dose quantity isn't of the right type.");
    }

    /**
     * Resolve the dose range.
     *
     * @return the dose range or {@code null}.
     * @throws InvalidEmedContentException if the dose range isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedRangeWithEmedUnits resolveDoseRange() throws InvalidEmedContentException {
        if (!this.hasDoseAndRate() || !this.getDoseAndRateFirstRep().hasDoseRange()) return null;
        final var doseRange = this.getDoseAndRateFirstRep().getDoseRange();
        if (doseRange instanceof ChEmedRangeWithEmedUnits chDoseRange) {
            return chDoseRange;
        }
        throw new InvalidEmedContentException("The dose range isn't of the right type.");
    }

    /**
     * Gets the start and/or end of treatment. If it doesn't exist, it's created.
     *
     * @return the start and/or end of treatment.
     */
    public Period getBoundsPeriod() {
        return this.getTiming()
                .getRepeat()
                .getBoundsPeriod();
    }

    /**
     * Sets start and/or end of treatment.
     *
     * @param boundsPeriod start and/or end of treatment.
     * @return this.
     */
    public ChEmedDosageSplit setBoundsPeriod(final Period boundsPeriod) {
        this.getTiming()
                .getRepeat()
                .setBounds(boundsPeriod);
        return this;
    }

    /**
     * Sets the dose quantity.
     *
     * @param doseQuantity the dose quantity.
     * @return this.
     */
    public ChEmedDosageSplit setDoseQuantity(final ChEmedQuantityWithEmedUnits doseQuantity) {
        this.getDoseAndRateFirstRep().setDose(doseQuantity);
        return this;
    }

    /**
     * Sets the dose range.
     *
     * @param doseRange the dose range.
     * @return this.
     */
    public ChEmedDosageSplit setDoseRange(final ChEmedQuantityWithEmedUnits doseRange) {
        this.getDoseAndRateFirstRep().setDose(doseRange);
        return this;
    }

    /**
     * Adds an event timing for time period occurrence.
     *
     * @param timing the event timing.
     * @return this.
     */
    public ChEmedDosageSplit addWhen(final TimingEventAmbu timing) {
        this.getTiming()
                .getRepeat()
                .addWhen(Timing.EventTiming.fromCode(timing.getCodeValue()));

        return this;
    }

    /**
     * Return whether a code for time period of occurrence.
     *
     * @return {@code true} if a code for time period of occurrence exists, {@code false} otherwise.
     */
    public boolean hasWhen() {
        return this.getTiming()
                .getRepeat()
                .hasWhen();
    }

    /**
     * Return whether the start and/or end of treatment.
     *
     * @return {@code true} if the start and/or end of treatment exists, {@code false} otherwise.
     */
    public boolean hasBoundsPeriod() {
        return this.getTiming()
                .getRepeat()
                .hasBoundsPeriod();
    }
}
