package org.projecthusky.fhir.emed.ch.epr.resource.pre;

import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationRequest;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest (PRE).
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedEprMedicationRequestPre extends ChEmedEprMedicationRequest {
    // TODO

    public Identifier resolveIdentifier() throws InvalidEmedContentException {
        return new Identifier(); // TODO
    }
}
