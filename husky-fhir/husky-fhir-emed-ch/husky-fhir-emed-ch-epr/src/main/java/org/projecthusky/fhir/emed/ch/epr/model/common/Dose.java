package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Range;

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
            throw new IllegalArgumentException("Dose: Either the quantity or the low/high shall be specified");
        } else if (quantity != null && (low != null || high != null)) {
            throw new IllegalArgumentException("Dose: Either the quantity or the low/high shall be specified");
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

    public static Dose fromDosageDoseAndRateComponent(final Dosage.DosageDoseAndRateComponent doseAndRate) {
        if (doseAndRate.hasDoseQuantity()) {
            if (doseAndRate.hasDoseRange())
                throw new IllegalArgumentException("Dose: Either the quantity or range shall be specified");
            else return new Dose(AmountQuantity.fromQuantity(doseAndRate.getDoseQuantity()), null, null);
        }
        if (doseAndRate.hasDoseRange())
            return new Dose(
                null,
                AmountQuantity.fromQuantity(doseAndRate.getDoseRange().getLow()),
                AmountQuantity.fromQuantity(doseAndRate.getDoseRange().getHigh())
            );
        else throw new IllegalArgumentException("Dose: Either the quantity or range shall be specified");
    }
}
