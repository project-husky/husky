package org.projecthusky.fhir.emed.ch.epr.resource.padv;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationRequest;

import java.util.UUID;

@ResourceDef(profile = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-medicationrequest-changed")
public class ChEmedEprMedicationRequestChanged extends ChEmedEprMedicationRequest {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationRequestChanged() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the uuid of the medication statement.
     */
    public ChEmedEprMedicationRequestChanged(final UUID entryUuid) {
        super(entryUuid);
    }

    @Override
    public ChEmedEprMedicationRequestChanged copy() {
        final var copy = new ChEmedEprMedicationRequestChanged();
        this.copyValues(copy);
        return copy;
    }
}
