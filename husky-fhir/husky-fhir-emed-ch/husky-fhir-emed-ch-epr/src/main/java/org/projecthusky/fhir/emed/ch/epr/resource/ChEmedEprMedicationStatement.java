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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprMedicationStatement extends MedicationStatement {
    // Here goes everything common to MedicationStatement (MTP), (PML) and (PMLC)

    /**
     * Empty constructor for the parser.
     */
    protected ChEmedEprMedicationStatement() {
        super();
    }

    protected ChEmedEprMedicationStatement(final UUID entryUuid) {
        super();
        this.setStatus(MedicationStatementStatus.COMPLETED);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
    }

    /**
     * Returns the medication or throws.
     *
     * @return the medication.
     * @throws InvalidEmedContentException if the medication is missing or invalid.
     */
    @ExpectsValidResource
    protected ChEmedEprMedication resolveMedication() throws InvalidEmedContentException {
        if (!this.hasMedication()) {
            throw new InvalidEmedContentException("The medication is missing in the medication statement");
        }

        final var reference = this.getMedication();
        if (reference instanceof final Reference ref) {
            final var resource = ref.getResource();
            if (resource instanceof ChEmedEprMedication chMedication) {
                return chMedication;
            }
        }
        throw new InvalidEmedContentException("The medication is invalid");
    }

    /**
     * Gets the treatment reason if available.
     *
     * @return the treatment reason or {@code null}.
     */
    @Nullable
    protected String getTreatmentReason() {
        if (this.reasonCode == null || !this.getReasonCodeFirstRep().hasText()) return null;
        return this.getReasonCodeFirstRep().getText();
    }

    /**
     * Sets the treatment reason. If the treatment reason already exists, it's replaced.
     *
     * @param treatmentReason the treatment reason
     * @return this.
     */
    protected ChEmedEprMedicationStatement setTreatmentReason(final String treatmentReason) {
        this.getReasonCodeFirstRep().setText(treatmentReason);
        return this;
    }
}
