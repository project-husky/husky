package org.ehealth_connector.emed.cda.models.common;

import org.ehealth_connector.emed.cda.generated.artdecor.enums.UnitCode;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.PQ;

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
