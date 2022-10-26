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
package org.projecthusky.fhir.emed.ch.epr.resource;

import org.hl7.fhir.r4.model.MedicationStatement;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprMedicationStatement extends MedicationStatement {
    // Here goes everything common to MedicationStatement (MTP), (PML) and (PMLC)

    protected ChEmedEprMedicationStatement(final UUID entryUuid) {
        super();
        this.setStatus(MedicationStatementStatus.COMPLETED);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
    }

    // TODO: create method resolveMedication
    // TODO: create methods getTreatmentReason (string, nullable) and setTreatmentReason -> reasonCode.text

}
