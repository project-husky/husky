package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED-DosageStructuredSplitMedicationRequest.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedDosageSplitMedicationRequest extends ChEmedDosage {

    // TODO update

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
}
