package org.projecthusky.fhir.emed.ch.epr.resource.padv;


import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatement;

import java.util.UUID;

/**
 * The HAPI custom structure for CH EMED MedicationStatement Changed (PADV).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-medicationstatement-changed")
public class ChEmedEprMedicationStatementChanged extends ChEmedEprMedicationStatement {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationStatementChanged() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the uuid of the medication statement.
     */
    public ChEmedEprMedicationStatementChanged(final UUID entryUuid) {
        super(entryUuid);
    }

    @Override
    public ChEmedEprMedicationStatementChanged copy() {
        final var copy = new ChEmedEprMedicationStatementChanged();
        this.copyValues(copy);
        return copy;
    }
}
