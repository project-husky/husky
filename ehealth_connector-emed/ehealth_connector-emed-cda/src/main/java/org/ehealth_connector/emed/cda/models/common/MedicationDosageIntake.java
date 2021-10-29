package org.ehealth_connector.emed.cda.models.common;

import org.ehealth_connector.emed.cda.generated.artdecor.enums.ChEmedTimingEvent;

import java.util.Objects;

/**
 * A dosage instruction for an intake.
 *
 * @author Quentin Ligier
 */
public class MedicationDosageIntake {

    /**
     * The event timing.
     */
    private ChEmedTimingEvent eventTiming;

    /**
     * The dose quantity.
     */
    private QuantityWithUnit doseQuantity;

    /**
     * Constructor.
     *
     * @param timingEvent  The event timing.
     * @param doseQuantity The dose quantity.
     */
    public MedicationDosageIntake(final ChEmedTimingEvent timingEvent,
                                  final QuantityWithUnit doseQuantity) {
        this.eventTiming = Objects.requireNonNull(timingEvent);
        this.doseQuantity = Objects.requireNonNull(doseQuantity);
    }

    /**
     * Returns the event timing.
     */
    public ChEmedTimingEvent getEventTiming() {
        return eventTiming;
    }

    /**
     * Sets the event timing.
     *
     * @param eventTiming The event timing.
     */
    public void setEventTiming(final ChEmedTimingEvent eventTiming) {
        this.eventTiming = Objects.requireNonNull(eventTiming);
    }

    /**
     * Returns the dose quantity.
     */
    public QuantityWithUnit getDoseQuantity() {
        return doseQuantity;
    }

    /**
     * Sets the dose quantity.
     *
     * @param doseQuantity The dose quantity.
     */
    public void setDoseQuantity(final QuantityWithUnit doseQuantity) {
        this.doseQuantity = Objects.requireNonNull(doseQuantity);
    }

    @Override
    public String toString() {
        return "MedicationDosageIntake{" +
                "eventTiming=" + eventTiming +
                ", doseQuantity=" + doseQuantity +
                '}';
    }
}
