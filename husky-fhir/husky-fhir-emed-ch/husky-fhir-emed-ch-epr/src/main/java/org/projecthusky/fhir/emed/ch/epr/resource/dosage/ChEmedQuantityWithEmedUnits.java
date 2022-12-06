package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import org.hl7.fhir.r4.model.SimpleQuantity;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.UnitCode;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import java.math.BigDecimal;

/**
 * The HAPI custom structure for CH-EMED-QuantityWithEmedUnits.
 *
 * @author Ronaldo Loureiro
 **/
@DatatypeDef(name="ChEmedQuantityWithEmedUnits", isSpecialization = true, profileOf = SimpleQuantity.class)
public class ChEmedQuantityWithEmedUnits extends SimpleQuantity {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedQuantityWithEmedUnits() {
        super();
    }

    /**
     * Resolves the coded form of the unit.
     *
     * @return the coded form of the unit.
     * @throws InvalidEmedContentException if the coded form of the unit is missing or invalid.
     */
    @ExpectsValidResource
    public UnitCode resolveUnitCode() throws InvalidEmedContentException {
        if (!this.hasCode()) throw new InvalidEmedContentException("The coded form of the unit is missing.");

        final var unitCode = UnitCode.getEnum(this.getCode());
        if (unitCode != null) {
            return unitCode;
        }
        throw new InvalidEmedContentException("The coded form of the unit is invalid.");
    }

    /**
     * Resolves the quantity.
     *
     * @return the quantity.
     * @throws InvalidEmedContentException if the quantity is missing.
     */
    @ExpectsValidResource
    public BigDecimal resolveQuantity() throws InvalidEmedContentException {
        if (!this.hasValue()) throw new InvalidEmedContentException("The quantity is missing.");
        return this.getValue();
    }

    /**
     * Sets the coded form of the unit.
     *
     * @param unitCode the coded form of the unit.
     * @return this.
     */
    public ChEmedQuantityWithEmedUnits setUnitCode(final UnitCode unitCode) {
        this.setSystem(unitCode.getCodeSystemId())
                .setCode(unitCode.getCodeValue())
                .setUnit(unitCode.getDisplayName());
        return this;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the quantity.
     * @return this.
     */
    public ChEmedQuantityWithEmedUnits setQuantity(final BigDecimal quantity) {
        this.setValue(quantity);
        return this;
    }

    /**
     * Return whether the quantity.
     *
     * @return {@code true} if the quantity exists, {@code false} otherwise.
     */
    public boolean hasQuantity() {
        return this.hasValue();
    }
}
