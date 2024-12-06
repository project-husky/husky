package org.projecthusky.fhir.emed.ch.epr.resource;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Medication;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.ActivePharmaceuticalIngredient;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedRatioWithEmedUnits;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationIngredient.
 *
 * @author Ronaldo Loureiro
 */
public class ChEmedEprMedicationIngredient extends Medication.MedicationIngredientComponent {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationIngredient() {
        super();
    }

    /**
     * Constructor from {@link Medication.MedicationIngredientComponent} object.
     * @param ingredientComponent the ingredient
     */
    public ChEmedEprMedicationIngredient(final Medication.MedicationIngredientComponent ingredientComponent) {
        ingredientComponent.copyValues(this);
    }

    /**
     * Resolves the dose per unit.
     *
     * @return the dose per unit.
     * @throws InvalidEmedContentException if the dose per unit isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedRatioWithEmedUnits resolveStrength() throws InvalidEmedContentException {
        if (!this.hasStrength()) return null;
        if (this.getStrength() instanceof final ChEmedRatioWithEmedUnits chRatio) {
            return chRatio;
        }
        throw new InvalidEmedContentException("The dose per unit isn't of the right type.");
    }

    /**
     * Resolves the active ingredient name.
     *
     * @return the active ingredient name.
     * @throws InvalidEmedContentException if the active ingredient is missing or unknown.
     */
    @ExpectsValidResource
    public ActivePharmaceuticalIngredient resolveActiveIngredient() throws InvalidEmedContentException {
        if (!this.hasItemCodeableConcept()) throw new InvalidEmedContentException("The active ingredient is missing.");
        final var ingredient = ActivePharmaceuticalIngredient.getEnum(this.getItemCodeableConcept().getCodingFirstRep().getCode());
        if (ingredient != null) {
            return ingredient;
        }
        throw new InvalidEmedContentException("The active ingredient name is unknown.");
    }

    /**
     * Sets the dose per unit.
     *
     * @param ratio the dose per unit.
     * @return this.
     */
    public ChEmedEprMedicationIngredient setStrength(final ChEmedRatioWithEmedUnits ratio) {
        super.setStrength(ratio);
        return this;
    }

    /**
     * Sets the active ingredient.
     *
     * @param ingredient the active ingredient.
     * @return this.
     */
    public ChEmedEprMedicationIngredient setActiveIngredient(final ActivePharmaceuticalIngredient ingredient) {
        this.getItemCodeableConcept()
                .setText(ingredient.getDisplayName())
                .getCodingFirstRep()
                .setSystem(Oids.PREFIX_OID + Oids.normalize(ingredient.getCodeSystemId()))
                .setCode(ingredient.getCodeValue())
                .setDisplay(ingredient.getDisplayName());

        this.setIsActive(true);

        return this;
    }

    @Override
    public ChEmedEprMedicationIngredient copy() {
      final var copy = new ChEmedEprMedicationIngredient();
      this.copyValues(copy);
      return copy;
    }
}
