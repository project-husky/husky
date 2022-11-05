package org.projecthusky.fhir.emed.ch.epr.resource;

import org.hl7.fhir.r4.model.MedicationDispense;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationDispense.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprMedicationDispense extends MedicationDispense implements ChEmedEprEntry {

    /**
     * Resolves the medication dispense UUID or throws.
     *
     * @return the medication dispense UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }
}
