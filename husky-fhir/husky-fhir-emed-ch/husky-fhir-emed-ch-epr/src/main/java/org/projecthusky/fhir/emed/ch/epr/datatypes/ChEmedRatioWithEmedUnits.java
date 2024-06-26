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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Ratio;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED-RatioWithEmedUnits.
 *
 * @author Ronaldo Loureiro
 **/
@DatatypeDef(name = "ChEmedRatioWithEmedUnits", isSpecialization = true, profileOf = Ratio.class)
public class ChEmedRatioWithEmedUnits extends Ratio {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedRatioWithEmedUnits() {
        super();
    }

    /**
     * Empty constructor for the parser.
     */
    public ChEmedRatioWithEmedUnits(final ChEmedQuantityWithEmedUnits numerator,
                                    final ChEmedQuantityWithEmedUnits denominator) {
        super();
        this.setNumerator(numerator);
        this.setDenominator(denominator);
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

    @Override
    public ChEmedRatioWithEmedUnits copy() {
        final var copy = new ChEmedRatioWithEmedUnits();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final Ratio dst) {
        super.copyValues(dst);
        if (!(this.numerator instanceof ChEmedQuantityWithEmedUnits)) {
            final var chNumerator = new ChEmedQuantityWithEmedUnits();
            this.numerator.copyValues(chNumerator);
            dst.setNumerator(chNumerator);
        }
        if (!(this.denominator instanceof ChEmedQuantityWithEmedUnits)) {
            final var chDenominator = new ChEmedQuantityWithEmedUnits();
            this.denominator.copyValues(chDenominator);
            dst.setDenominator(chDenominator);
        }
    }
}
