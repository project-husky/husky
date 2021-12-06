/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.models.common;

import org.husky.emed.cda.generated.artdecor.enums.UnitCode;
import org.husky.common.hl7cdar2.PQ;

import java.util.Objects;

/**
 * A physical quantity (PQ, QTY) with a unit of presentation.
 *
 * @author Quentin Ligier
 */
public class QuantityWithUnit {

    /**
     * The quantity value.
     */
    private String value;

    /**
     * The quantity unit.
     */
    private UnitCode unit;

    /**
     * Constructor.
     *
     * @param value The quantity value.
     * @param unit The quantity unit.
     */
    public QuantityWithUnit(final String value,
                            final UnitCode unit) {
        this.value = Objects.requireNonNull(value);
        this.unit = Objects.requireNonNull(unit);
    }

    /**
     * Constructs a new instance from an HL7 PQ instance.
     *
     * @param qty The {@link PQ} to convert.
     */
    public static QuantityWithUnit fromPq(final PQ qty) {
        final var newValue = Objects.requireNonNull(qty).getValue();
        UnitCode newUnit = null;
        if (qty.getUnit() != null) {
            if (!UnitCode.isInValueSet(qty.getUnit())) {
                throw new IllegalArgumentException("The quantity unit is invalid");
            }
            newUnit = UnitCode.getEnum(qty.getUnit());
        }
        return new QuantityWithUnit(Objects.requireNonNull(newValue), Objects.requireNonNull(newUnit));
    }

    public String getValue() {
        return this.value;
    }

    public UnitCode getUnit() {
        return this.unit;
    }

    public void setValue(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public void setUnit(final UnitCode unit) {
        this.unit = Objects.requireNonNull(unit);
    }

    public String toString() {
        return "QuantityWithUnit(value=" + this.getValue() + ", unit=" + this.getUnit() + ")";
    }
}
