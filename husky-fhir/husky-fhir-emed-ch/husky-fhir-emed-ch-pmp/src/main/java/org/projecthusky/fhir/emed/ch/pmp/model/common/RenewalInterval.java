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

import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Duration;
import java.time.Instant;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.TemporalAmount;
import java.util.Objects;

/**
 * A time interval with either a duration or a higher bound (it might have both).
 *
 * @author Quentin Ligier
 */
public class RenewalInterval {

    /**
     * The inclusive lower bound or {@code null}.
     */
    @Nullable
    private final Instant low;

    /**
     * The inclusive higher bound or {@code null}.
     */
    @Nullable
    private final Instant high;

    /**
     * The interval duration.
     */
    @Nullable
    private final TemporalAmount duration;

    /**
     * Constructs a new instance from a lower and higher bounds.
     *
     * @param low The time interval lower bound or {@code null}.
     * @param high The time interval higher bound.
     * @throws IllegalArgumentException if the lower bound is after the higher bound.
     */
    public RenewalInterval(@Nullable final Instant low,
                           final Instant high) {
        this.low = low;
        this.high = Objects.requireNonNull(high);
        if (low != null && low.isAfter(high)) {
            throw new IllegalArgumentException("The time interval lower bound is after the higher bound");
        }
        this.duration = (low != null) ? Duration.between(low, high) : null;
    }

    /**
     * Constructs a new instance from a duration and an optional lower bound.
     *
     * @param low The time interval lower bound or {@code null}.
     * @param duration The time interval duration. It shall not be negative.
     */
    public RenewalInterval(@Nullable final Instant low,
                           final TemporalAmount duration) {
        this.low = low;
        this.duration = Objects.requireNonNull(duration);
        this.high = (low != null) ? low.plus(duration) : null;
        if (duration instanceof final Duration d && d.isNegative()) {
            throw new IllegalArgumentException("The time interval duration is negative");
        }
        if (duration instanceof final ChronoPeriod p && p.isNegative()) {
            throw new IllegalArgumentException("The time interval duration is negative");
        }
    }

    /**
     * Returns the time interval lower bound or {@code null}.
     */
    @Nullable
    public Instant getLow() {
        return this.low;
    }

    /**
     * Returns the time interval higher bound or {@code null}. Either the higher bound or the duration is non-null.
     */
    @Nullable
    public Instant getHigh() {
        return this.high;
    }

    /**
     * Returns the time interval duration or {@code null}. Either the higher bound or the duration is non-null.
     */
    @Nullable
    public TemporalAmount getDuration() {
        return this.duration;
    }

    /**
     * Returns whether the interval is absolute (bounded by higher bound) or relative (only made of a duration).
     */
    public boolean isAbsolute() {
        return this.getHigh() != null;
    }

    @Override
    public String toString() {
        return "TimeInterval{" +
                "low=" + this.low +
                ", high=" + this.high +
                ", duration=" + this.duration +
                '}';
    }
}
