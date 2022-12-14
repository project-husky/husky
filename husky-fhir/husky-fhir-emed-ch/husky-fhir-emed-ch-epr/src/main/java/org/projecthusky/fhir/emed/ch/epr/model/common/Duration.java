package org.projecthusky.fhir.emed.ch.epr.model.common;

import java.util.Objects;

/**
 * A time quantity (duration).
 *
 * @author Quentin Ligier
 */
public record Duration(int value,
                       String unit) {

    /**
     * Constructor.
     *
     * @param value The value.
     * @param unit  The time unit.
     */
    public Duration(final int value,
                    final String unit) {
        if (value < 1) {
            throw new IllegalArgumentException("Duration: The value must be at least 1");
        }
        this.value = value;
        this.unit = Objects.requireNonNull(unit);
    }
}
