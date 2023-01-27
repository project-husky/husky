package org.projecthusky.fhir.emed.ch.epr.resource.pre;

import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationRequest;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest (PRE).
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedEprMedicationRequestPre extends ChEmedEprMedicationRequest {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationRequestPre() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication request ID.
     */
    public ChEmedEprMedicationRequestPre(final UUID entryUuid) {
        super(entryUuid);
    }
}
