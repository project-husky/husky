package org.husky.emed.cda.models.common;

import org.checkerframework.checker.nullness.qual.NonNull;
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
                           @NonNull final Instant high) {
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
                           @NonNull final TemporalAmount duration) {
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

    @Override
    @NonNull
    public String toString() {
        return "TimeInterval{" +
                "low=" + this.low +
                ", high=" + this.high +
                ", duration=" + this.duration +
                '}';
    }
}
