package org.projecthusky.fhir.emed.ch.epr.model.common;

import java.util.Objects;

/**
 * An amount quantity over a duration.
 *
 * @author Quentin Ligier
 */
public record AmountPerDuration(AmountQuantity amount,
                                Duration duration) {

    /**
     * Constructor.
     *
     * @param amount   The amount quantity.
     * @param duration The duration.
     */
    public AmountPerDuration(final AmountQuantity amount,
                             final Duration duration) {
        this.amount = Objects.requireNonNull(amount);
        this.duration = Objects.requireNonNull(duration);
    }
}
