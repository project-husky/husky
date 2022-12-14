package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A medication dose, either as an amount or as a range. The range may only contain a low or high value.
 *
 * @author Quentin Ligier
 */
public record Dose(@Nullable AmountQuantity quantity,
                   @Nullable AmountQuantity low,
                   @Nullable AmountQuantity high) {

    /**
     * Constructor.
     *
     * @param quantity The amount quantity or {@code null} if using a range.
     * @param low      The low amount quantity or {@code null}.
     * @param high     The high amount quantity or {@code null}.
     */
    public Dose(@Nullable final AmountQuantity quantity,
                @Nullable final AmountQuantity low,
                @Nullable final AmountQuantity high) {
        if (quantity == null && low == null && high == null) {
            throw new IllegalArgumentException("");
        } else if (quantity != null && (low != null || high != null)) {
            throw new IllegalArgumentException("");
        }
        this.quantity = quantity;
        this.low = low;
        this.high = high;
    }

    public boolean isRange() {
        return !this.isQuantity();
    }

    public boolean isQuantity() {
        return this.quantity != null;
    }
}
