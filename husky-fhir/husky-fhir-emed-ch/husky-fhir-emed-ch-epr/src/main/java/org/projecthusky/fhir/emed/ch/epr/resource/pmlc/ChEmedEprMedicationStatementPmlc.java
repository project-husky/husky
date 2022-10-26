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
package org.projecthusky.fhir.emed.ch.epr.resource.pmlc;

import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatement;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (PMLC).
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprMedicationStatementPmlc extends ChEmedEprMedicationStatement {

    // TODO: add support for extensions authorDocument, treatmentPlan

    public ChEmedEprMedicationStatementPmlc(final UUID entryUuid) {
        super(entryUuid);
    }
}
