/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.emed.ch.pmp.model.common;

import org.projecthusky.fhir.emed.ch.pmp.enums.TimingEventAmbu;

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
    private TimingEventAmbu eventTiming;

    /**
     * The dose quantity.
     */
    private QuantityWithRegularUnit doseQuantity;

    /**
     * Constructor.
     *
     * @param eventTiming  The event timing.
     * @param doseQuantity The dose quantity.
     */
    public MedicationDosageIntake(final TimingEventAmbu eventTiming,
                                  final QuantityWithRegularUnit doseQuantity) {
        this.eventTiming = Objects.requireNonNull(eventTiming);
        this.doseQuantity = Objects.requireNonNull(doseQuantity);
    }

    /**
     * Returns the event timing.
     */
    public TimingEventAmbu getEventTiming() {
        return eventTiming;
    }

    /**
     * Sets the event timing.
     *
     * @param eventTiming The event timing.
     */
    public void setEventTiming(final TimingEventAmbu eventTiming) {
        this.eventTiming = Objects.requireNonNull(eventTiming);
    }

    /**
     * Returns the dose quantity.
     */
    public QuantityWithRegularUnit getDoseQuantity() {
        return doseQuantity;
    }

    /**
     * Sets the dose quantity.
     *
     * @param doseQuantity The dose quantity.
     */
    public void setDoseQuantity(final QuantityWithRegularUnit doseQuantity) {
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
