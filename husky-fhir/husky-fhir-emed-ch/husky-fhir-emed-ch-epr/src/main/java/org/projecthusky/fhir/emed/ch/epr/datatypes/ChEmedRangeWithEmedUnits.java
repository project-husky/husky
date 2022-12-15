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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Range;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED-RangeWithEmedUnits.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedRangeWithEmedUnits extends Range {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedRangeWithEmedUnits() {
        super();
    }

    /**
     * Resolves the low quantity or {@code null}.
     *
     * @return the low quantity or {@code null}.
     * @throws InvalidEmedContentException if the low quantity isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveLow() throws InvalidEmedContentException {
        if (!this.hasLow()) return null;
        final var low = this.getLow();
        if (low instanceof ChEmedQuantityWithEmedUnits chLow) {
            return chLow;
        }
        throw new InvalidEmedContentException("The low quantity isn't of the right type.");
    }

    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveHigh() throws InvalidEmedContentException {
        if (!this.hasHigh()) return null;
        final var high = this.getHigh();
        if (high instanceof ChEmedQuantityWithEmedUnits chHigh) {
            return chHigh;
        }
        throw new InvalidEmedContentException("The high quantity isn't of the right type");
    }

    /**
     * Sets the low quantity.
     *
     * @param low the low quantity.
     * @return this.
     */
    public ChEmedRangeWithEmedUnits setLow(final ChEmedQuantityWithEmedUnits low) {
        super.setLow(low);
        return this;
    }

    /**
     * Sets the high quantity.
     *
     * @param high the high quantity.
     * @return this.
     */
    public ChEmedRangeWithEmedUnits setHigh(final ChEmedQuantityWithEmedUnits high) {
        super.setHigh(high);
        return this;
    }
}
