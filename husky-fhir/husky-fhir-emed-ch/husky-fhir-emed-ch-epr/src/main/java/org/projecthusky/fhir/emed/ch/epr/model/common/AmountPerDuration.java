package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.hl7.fhir.r4.model.Ratio;

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


    /**
     * Creates an instance from an HAPI Ratio.
     */
    public static AmountPerDuration fromRatio(final Ratio ratio) {
        final var amount = AmountQuantity.fromQuantity(ratio.getNumerator());
        final var duration = Duration.fromQuantity(ratio.getDenominator());
        return new AmountPerDuration(amount, duration);
    }
}
