package org.projecthusky.communication.xdsmhdconversion.model;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Instant;

/**
 * Specifies a time range where the lower bound is inclusive and the upper bound is exclusive.
 *
 * @author Quentin Ligier
 */
@Data
public class XdsTimeRange {

    /**
     * The inclusive lower bound of the time range or {@code null} if it's not defined.
     */
    @Nullable
    private Instant lower;

    /**
     * The exclusive upper bound of the time range or {@code null} if it's not defined.
     */
    @Nullable
    private Instant upper;

    /**
     * Sets the lower bound of the time range. It shall not be later than the upper bound, but can be the same instant.
     *
     * @param lower The lower bound.
     * @throws IllegalArgumentException if the lower bound is after the upper one.
     */
    public void setLower(final @Nullable Instant lower) {
        if (this.upper != null && lower != null && lower.isAfter(upper)) {
            throw new IllegalArgumentException("The low bound is after the upper bound in XdsTimeRange");
        }
        this.lower = lower;
    }

    /**
     * Sets the upper bound of the time range. It shall not be sooner than the lower bound, but can be the same
     * instant.
     *
     * @param upper The upper bound.
     * @throws IllegalArgumentException if the upper bound is before the lower one.
     */
    public void setUpper(final @Nullable Instant upper) {
        if (this.lower != null && upper != null && upper.isBefore(lower)) {
            throw new IllegalArgumentException("The upper bound is before the low bound in XdsTimeRange");
        }
        this.upper = upper;
    }

    /**
     * Returns whether the time range has a duration (i.e. a lower and a upper bounds) or not.
     */
    public boolean hasDuration() {
        return this.lower != null && this.upper != null;
    }
}
