package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Ratio;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED-RatioWithEmedUnits.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedRatioWithEmedUnits extends Ratio {


    /**
     * Empty constructor for the parser.
     */
    public ChEmedRatioWithEmedUnits() {
        super();
    }

    /**
     * Resolves the numerator quantity or {@code null}.
     *
     * @return the numerator quantity or {@code null}.
     * @throws InvalidEmedContentException if the numerator quantity isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveNumerator() throws InvalidEmedContentException {
        if (!this.hasNumerator()) return null;
        final var numerator = this.getNumerator();
        if (numerator instanceof ChEmedQuantityWithEmedUnits chNumerator) {
            return chNumerator;
        }
        throw new InvalidEmedContentException("The numerator quantity isn't of the right type.");
    }

    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveDenominator() throws InvalidEmedContentException {
        if (!this.hasDenominator()) return null;
        final var denominator = this.getDenominator();
        if (denominator instanceof ChEmedQuantityWithEmedUnits chDenominator) {
            return chDenominator;
        }
        throw new InvalidEmedContentException("The denominator quantity isn't of the right type");
    }

    /**
     * Sets the numerator quantity.
     *
     * @param numerator the numerator quantity.
     * @return this.
     */
    public ChEmedRatioWithEmedUnits setNumerator(final ChEmedQuantityWithEmedUnits numerator) {
        super.setNumerator(numerator);
        return this;
    }

    /**
     * Sets the denominator quantity.
     *
     * @param denominator the denominator quantity.
     * @return this.
     */
    public ChEmedRatioWithEmedUnits setDenominator(final ChEmedQuantityWithEmedUnits denominator) {
        super.setDenominator(denominator);
        return this;
    }
}
