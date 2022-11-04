package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED-DosageSplit.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedDosageSplit extends ChEmedDosage {

    /**
     * Empty constructor for the parser
     */
    public ChEmedDosageSplit() {
        super();
    }

    /**
     * Constructor
     *
     * @param sequence the order of the dosage instructions
     */
    public ChEmedDosageSplit(final int sequence) {
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
