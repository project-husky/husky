package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import lombok.Data;
import lombok.NonNull;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedQuantityWithEmedUnits;

import java.util.Objects;

/**
 * Represents the ingredient of a medicine
 *
 * @author Ronaldo Loureiro
 */
@Data
public class NarrativeTreatmentIngredient {

    /**
     * The name of ingredient
     */
    private final String name;

    /**
     * the quantity of an ingredient in a medicine
     */
    private final String quantity;

    /**
     * The unit of quantity
     */
    private final String unit;

    /**
     * Constructor
     *
     * @param name     the ingredient's name
     * @param quantityWithEmedUnits the ingredient's quantity with the quantity's unit
     */
    public NarrativeTreatmentIngredient(final String name,
                                        final ChEmedQuantityWithEmedUnits quantityWithEmedUnits) {
        this.name = Objects.requireNonNull(name);
        this.quantity = Objects.requireNonNull(quantityWithEmedUnits.resolveQuantity().toPlainString());
        this.unit = Objects.requireNonNull(quantityWithEmedUnits.resolveUnitCode().getDisplayName());
    }
}
