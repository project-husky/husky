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
@ResourceDef(profile = "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-medicationdispense")
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
}
