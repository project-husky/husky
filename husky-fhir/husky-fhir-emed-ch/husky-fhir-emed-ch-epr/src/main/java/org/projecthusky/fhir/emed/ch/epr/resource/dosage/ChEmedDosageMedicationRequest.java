package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EventTiming;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-DosageMedicationRequest.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedDosageMedicationRequest extends ChEmedDosage {

    /**
     * Empty constructor for the parser
     */
    public ChEmedDosageMedicationRequest() {
        super();
    }

    /**
     * Resolves the list of with event timings.
     *
     * @return the list of with event timings.
     * @throws InvalidEmedContentException if ChEmedDosageMedicationRequest has no code for time period of occurrence.
     */
    @Override
    @ExpectsValidResource
    public List<EventTiming> resolveWhen() throws InvalidEmedContentException {
        final var eventTimingList = super.resolveWhen();
        if (eventTimingList == null) {
            throw new InvalidEmedContentException("ChEmedDosageMedicationRequest requires a minimum one code for time period of occurrence.");
        }
        return eventTimingList;
    }

    /**
     * Resolve the dose quantity.
     *
     * @return the dose quantity or {@code null}.
     * @throws InvalidEmedContentException if the dose quantity isn't of the right type or the dose and rate are missing.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveDoseQuantity() throws InvalidEmedContentException {
        if (!this.hasDoseAndRate()) throw new InvalidEmedContentException("The dose and rate are missing.");
        return super.resolveDoseQuantity();
    }

    /**
     * Resolve the dose range.
     *
     * @return the dose range or {@code null}.
     * @throws InvalidEmedContentException if the dose range isn't of the right type or the dose and rate are missing.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedRangeWithEmedUnits resolveDoseRange() throws InvalidEmedContentException {
        if (!this.hasDoseAndRate()) throw new InvalidEmedContentException("The dose and rate are missing.");
        return super.resolveDoseRange();
    }
}
