package org.projecthusky.fhir.emed.ch.epr.resource.dis;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationDispense;

import java.time.Instant;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationDispense (DIS).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationdispense")
public class ChEmedEprMedicationDispenseDis extends ChEmedEprMedicationDispense {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationDispenseDis() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication dispense id.
     */
    public ChEmedEprMedicationDispenseDis(final UUID entryUuid,
                                          final Instant whenHandedOver) {
        super(entryUuid, whenHandedOver);
    }

    @Override
    public ChEmedEprMedicationDispenseDis copy() {
        final var copy = new ChEmedEprMedicationDispenseDis();
        this.copyValues(copy);
        return copy;
    }
}
