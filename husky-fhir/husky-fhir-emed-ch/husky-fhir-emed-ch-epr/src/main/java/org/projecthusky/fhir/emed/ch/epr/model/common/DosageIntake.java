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
package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;

import java.util.Objects;

/**
 * A dosage instruction for an intake.
 *
 * @author Quentin Ligier
 */
public record DosageIntake(TimingEventAmbu eventTiming,
                           Dose dose,
                           @Nullable AmountPerDuration rate) {

    /**
     * Constructor.
     *
     * @param eventTiming The event timing (when).
     * @param dose        The dose (how much) or {@code null}.
     * @param rate        The rate (how much) or {@code null}.
     */
    public DosageIntake(final TimingEventAmbu eventTiming,
                        @Nullable final Dose dose,
                        @Nullable final AmountPerDuration rate) {
        if (dose == null && rate == null) {
            throw new IllegalArgumentException("DosageIntake: The dose and/or rate shall be specified");
        }
        this.eventTiming = Objects.requireNonNull(eventTiming);
        this.dose = Objects.requireNonNullElseGet(dose, () -> new Dose(rate.amount(), null, null));
        this.rate = rate;
    }

    public boolean hasRate() {
        return this.rate != null;
    }

    /**
     * Returns the total dose for the intake. If the rate is also specified, the rate amount may not be equal to the
     * total dose. The dose is always non-null: it's either explicitly specified, or it's equal to the rate amount.
     * <p>
     * For example: 1 liter @ 500mL per hour. The dose is 1 liter, the rate is 500 mL/hour.
     */
    @Override
    @NonNull
    public Dose dose() {
        return this.dose;
    }
}
