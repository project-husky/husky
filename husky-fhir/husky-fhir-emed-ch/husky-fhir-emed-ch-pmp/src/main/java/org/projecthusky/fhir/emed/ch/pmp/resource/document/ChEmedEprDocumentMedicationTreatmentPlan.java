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
package org.projecthusky.fhir.emed.ch.pmp.resource.document;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.pmp.resource.composition.ChEmedEprCompositionMedicationTreatmentPlan;

import java.io.Serial;
import java.util.Date;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR MTP Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://example.com/StructureDefinition/mtpDoc")
public class ChEmedEprDocumentMedicationTreatmentPlan extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = 1095863629301164639L;

    /**
     * Empty constructor.
     */
    public ChEmedEprDocumentMedicationTreatmentPlan() {
        super();
    }

    /**
     * Constructor.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentMedicationTreatmentPlan(final UUID documentId,
                                                    final Date timestamp) {
        super(documentId, timestamp);
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionMedicationTreatmentPlan.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryByResourceType(ChEmedEprCompositionMedicationTreatmentPlan.class);
        if (entry == null) {
            entry = new BundleEntryComponent();
            this.getEntry().add(0, entry); // The composition shall go first
        }
        return entry;
    }

    /**
     * Returns the composition or throws.
     *
     * @return the composition.
     * @throws InvalidEmedContentException if the composition is missing.
     */
    @ExpectsValidResource
    public ChEmedEprCompositionMedicationTreatmentPlan resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionMedicationTreatmentPlan.class);
        if (entry != null && entry.getResource() instanceof final ChEmedEprCompositionMedicationTreatmentPlan composition) {
            return composition;
        }
        throw new InvalidEmedContentException(
                "The ChEmedEprCompositionMedicationTreatmentPlan is missing in the document Bundle");
    }
}
