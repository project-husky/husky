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
package org.projecthusky.fhir.emed.ch.pmp.models.treatment;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.emed.ch.enums.ActivePharmaceuticalIngredient;
import org.projecthusky.fhir.emed.ch.pmp.models.common.QuantityWithRegularUnit;

/**
 * An ingredient of a medication product.
 *
 * @author Quentin Ligier
 * @see MedicationProduct
 */
@Data
@AllArgsConstructor
public class MedicationProductIngredient {

     /**
     * The component name.
     */
    private String name;

    /**
     * The quantity numerator or {@code null}.
     */
    @Nullable
    private QuantityWithRegularUnit quantityNumerator;

    /**
     * The quantity denominator or {@code null}.
     */
    @Nullable
    private QuantityWithRegularUnit quantityDenominator;

    /**
     * The component code in SNOMED CT system or {@code null}.
     */
    @Nullable
    private ActivePharmaceuticalIngredient code;

    /**
     * Returns whether the product ingredient has a quantity (numerator and denominator) or not.
     */
    public boolean hasQuantity() {
        return this.quantityNumerator != null && this.quantityDenominator != null;
    }
}
