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

import org.hl7.fhir.r4.model.Quantity;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;

import java.util.Objects;

/**
 * A physical quantity (PQ, QTY) with a unit of presentation.
 *
 * @author Quentin Ligier
 */
public record AmountQuantity(String value,
                             RegularUnitCodeAmbu unit) {

    /**
     * Constructor.
     *
     * @param value The amount quantity.
     * @param unit  The amount unit.
     */
    public AmountQuantity(final String value,
                          final RegularUnitCodeAmbu unit) {
        this.value = Objects.requireNonNull(value);
        this.unit = Objects.requireNonNull(unit);
    }

    /**
     * Creates an instance from an HAPI Quantity.
     */
    public static AmountQuantity fromQuantity(final Quantity quantity) {
        if (!quantity.hasCode()) {
            throw new IllegalArgumentException("AmountQuantity: Missing code in quantity");
        }
        if (!quantity.hasValue()) {
            throw new IllegalArgumentException("AmountQuantity: Missing value in quantity");
        }
        if (!quantity.hasSystem()) {
            throw new IllegalArgumentException("AmountQuantity: Missing system in quantity");
        }
        final var unit = RegularUnitCodeAmbu.getEnum(quantity.getCode());
        if (unit == null || !quantity.getSystem().equals(unit.getCodeSystemId())) {
            throw new IllegalArgumentException("AmountQuantity: Invalid code in quantity");
        }
        return new AmountQuantity(quantity.getValueElement().asStringValue(),
                                  unit);
    }
}
