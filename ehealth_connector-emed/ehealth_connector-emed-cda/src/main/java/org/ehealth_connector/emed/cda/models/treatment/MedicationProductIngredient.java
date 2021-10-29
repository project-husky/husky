package org.ehealth_connector.emed.cda.models.treatment;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.ActivePharmaceuticalIngredient;
import org.ehealth_connector.emed.cda.models.common.QuantityWithUnit;

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
    @Nullable private QuantityWithUnit quantityNumerator;

    /**
     * The quantity denominator or {@code null}.
     */
    @Nullable private QuantityWithUnit quantityDenominator;

    /**
     * The component code in SNOMED CT system or {@code null}.
     */
    @Nullable private ActivePharmaceuticalIngredient code;

    /**
     * Returns whether the product ingredient has a quantity (numerator and denominator) or not.
     */
    public boolean hasQuantity() {
        return this.quantityNumerator != null && this.quantityDenominator != null;
    }
}
