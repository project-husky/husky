package org.projecthusky.fhir.emed.ch.epr.resource.pre;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationRequest;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest (PRE).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationrequest")
public class ChEmedEprMedicationRequestPre extends ChEmedEprMedicationRequest {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationRequestPre() {
        super();
        this.setStatus(MedicationRequestStatus.ACTIVE);
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication request ID.
     */
    public ChEmedEprMedicationRequestPre(final UUID entryUuid) {
        super(entryUuid);
        this.setStatus(MedicationRequestStatus.ACTIVE);
    }

    @Override
    public ChEmedEprMedicationRequestPre copy() {
        final var copy = new ChEmedEprMedicationRequestPre();
        this.copyValues(copy);
        return copy;
    }
}
