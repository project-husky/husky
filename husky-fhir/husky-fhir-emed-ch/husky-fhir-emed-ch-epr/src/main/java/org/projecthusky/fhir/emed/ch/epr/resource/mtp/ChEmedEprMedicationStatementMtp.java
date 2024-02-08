/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.emed.ch.epr.resource.mtp;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatement;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (MTP).
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationstatement-treatmentplan")
public class ChEmedEprMedicationStatementMtp extends ChEmedEprMedicationStatement {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationStatementMtp() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the uuid of the medication statement.
     */
    public ChEmedEprMedicationStatementMtp(final UUID entryUuid) {
        super(entryUuid);
    }


    @Override
    public ChEmedEprMedicationStatementMtp copy() {
        final var copy = new ChEmedEprMedicationStatementMtp();
        this.copyValues(copy);
        return copy;
    }
}
