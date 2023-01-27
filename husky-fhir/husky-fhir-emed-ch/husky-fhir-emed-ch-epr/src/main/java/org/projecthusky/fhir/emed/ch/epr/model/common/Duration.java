package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.hl7.fhir.r4.model.Quantity;
import org.projecthusky.fhir.emed.ch.epr.enums.ChEmedEprTimeUnit;

import java.util.Objects;

/**
 * A time quantity (duration).
 *
 * @author Quentin Ligier
 */
public record Duration(int value,
                       ChEmedEprTimeUnit unit) {

    /**
     * Constructor.
     *
     * @param value The value.
     * @param unit  The time unit.
     */
    public Duration(final int value,
                    final ChEmedEprTimeUnit unit) {
        if (value < 1) {
            throw new IllegalArgumentException("Duration: The value must be at least 1");
        }
        this.value = value;
        this.unit = Objects.requireNonNull(unit);
    }

    /**
     * Creates an instance from an HAPI Quantity.
     */
    public static Duration fromQuantity(final Quantity quantity) {
        if (!quantity.hasCode()) {
            throw new IllegalArgumentException("Duration: Missing code in quantity");
        }
        if (!quantity.hasValue()) {
            throw new IllegalArgumentException("Duration: Missing value in quantity");
        }
        if (!quantity.hasSystem()) {
            throw new IllegalArgumentException("Duration: Missing system in quantity");
        }
        final var unit = ChEmedEprTimeUnit.getEnum(quantity.getCode());
        if (unit == null || !quantity.getSystem().equals(unit.getCodeSystemId())) {
            throw new IllegalArgumentException("Duration: Invalid code in quantity");
        }
        return new Duration(quantity.getValueElement().getValueAsInteger(),
                            unit);
    }
}
