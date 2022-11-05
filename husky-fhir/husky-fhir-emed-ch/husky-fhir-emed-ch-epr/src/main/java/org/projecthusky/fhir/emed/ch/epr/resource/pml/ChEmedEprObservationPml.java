package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprObservation;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation (PML).
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedEprObservationPml extends ChEmedEprObservation {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprObservationPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication statement id.
     * @param padvType  The pharmaceutical advice type.
     */
    public ChEmedEprObservationPml(final UUID entryUuid,
                                   final EmedPadvEntryType padvType) {
        super(entryUuid, padvType);
    }

    // TODO
}
