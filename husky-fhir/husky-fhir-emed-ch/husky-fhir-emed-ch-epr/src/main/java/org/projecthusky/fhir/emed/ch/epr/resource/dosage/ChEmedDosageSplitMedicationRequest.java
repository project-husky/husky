package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;

import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-DosageSplitMedicationRequest.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedDosageSplitMedicationRequest extends ChEmedDosageSplit {

    /**
     * Empty constructor for the parser
     */
    public ChEmedDosageSplitMedicationRequest() {
        super();
    }

    /**
     * Constructor
     *
     * @param sequence the order of the dosage instructions
     */
    public ChEmedDosageSplitMedicationRequest(final int sequence) {
        super();
        this.setSequence(sequence);
    }

    /**
     * Gets the order of the dosage instructions.
     *
     * @return the order of the dosage instructions.
     * @throws InvalidEmedContentException if the order of the dosage instructions is less than 1.
     */
    @Override
    @ExpectsValidResource
    public int getSequence() throws InvalidEmedContentException {
        if (super.getSequence() < 1) throw new InvalidEmedContentException("The order of the dosage instructions is is less than 1.");
        return super.getSequence();
    }

    /**
     * Resolves the list of with event timings.
     *
     * @return the list of with event timings.
     * @throws InvalidEmedContentException if ChEmedDosageMedicationRequest has no code for time period of occurrence.
     */
    @Override
    @ExpectsValidResource
    public List<TimingEventAmbu> resolveWhen() throws InvalidEmedContentException {
        final var eventTimingList = super.resolveWhen();
        if (eventTimingList == null) {
            throw new InvalidEmedContentException("ChEmedDosageSplitMedicationRequest requires a minimum one code for time period of occurrence.");
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
