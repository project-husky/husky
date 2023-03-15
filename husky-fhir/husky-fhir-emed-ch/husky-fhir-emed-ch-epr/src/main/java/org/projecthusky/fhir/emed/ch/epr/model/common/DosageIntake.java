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

import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;

import java.util.Objects;

/**
 * A dosage instruction for an intake.
 *
 * @author Quentin Ligier
 */
public record DosageIntake(TimingEventAmbu eventTiming,
                           Dose dose) {

    /**
     * Constructor. Either the dose, rate or both shall be specified.
     *
     * @param eventTiming The event timing (when).
     * @param dose        The dose (how much).
     */
    public DosageIntake(final TimingEventAmbu eventTiming,
                        final Dose dose) {
        this.eventTiming = Objects.requireNonNull(eventTiming);
        this.dose = Objects.requireNonNull(dose);
    }
}
