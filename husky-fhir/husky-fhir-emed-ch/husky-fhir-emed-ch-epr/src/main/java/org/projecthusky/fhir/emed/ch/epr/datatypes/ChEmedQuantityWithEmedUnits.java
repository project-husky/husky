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
package org.projecthusky.fhir.emed.ch.epr.datatypes;

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
@DatatypeDef(name = "ChEmedQuantityWithEmedUnits", isSpecialization = true, profileOf = SimpleQuantity.class)
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

    @Override
    public ChEmedQuantityWithEmedUnits copy() {
        final var copy = new ChEmedQuantityWithEmedUnits();
        this.copyValues(copy);
        return copy;
    }
}
