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
package org.husky.emed.ch.models.common;

import org.husky.common.hl7cdar2.PQ;

import java.util.Objects;

/**
 * A physical quantity (PQ, QTY).
 *
 * @author Quentin Ligier
 **/
public class Quantity {

    /**
     * The quantity value.
     */
    private String value;

    /**
     * The quantity unit.
     */
    private String unit;

    /**
     * Constructor.
     *
     * @param value The quantity value.
     * @param unit The quantity unit.
     */
    public Quantity(final String value,
                    final String unit) {
        this.value = Objects.requireNonNull(value);
        this.unit = Objects.requireNonNull(unit);
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    /**
     * Constructs a new instance from an HL7 PQ instance.
     *
     * @param qty The {@link PQ} to convert.
     */
    public static Quantity fromPq(final PQ qty) {
        Objects.requireNonNull(qty, "qty shall not be null in fromPq()");

        return new Quantity(
                Objects.requireNonNull(qty.getValue()),
                Objects.requireNonNull(qty.getUnit())
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final Quantity that)) return false;
        return Objects.equals(value, that.value)
                && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value='" + this.value + '\'' +
                ", unit='" + this.unit + '\'' +
                '}';
    }
}
