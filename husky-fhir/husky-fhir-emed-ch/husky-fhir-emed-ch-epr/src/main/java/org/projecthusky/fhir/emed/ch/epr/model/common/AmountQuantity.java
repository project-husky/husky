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
}
