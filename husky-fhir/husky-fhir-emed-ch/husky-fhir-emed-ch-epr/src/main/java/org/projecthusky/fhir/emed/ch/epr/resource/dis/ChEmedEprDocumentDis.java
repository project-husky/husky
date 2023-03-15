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
package org.projecthusky.fhir.emed.ch.epr.resource.dis;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;

import java.io.Serial;
import java.time.Instant;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR DIS Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-medicationdispense")
public class ChEmedEprDocumentDis extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = 7824141700654582502L;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprDocumentDis() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentDis(final UUID documentId,
                                final Instant timestamp) {
        super(documentId, timestamp);
    }

    @Override
    public EmedDocumentType getEmedType() {
        return EmedDocumentType.DIS;
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionDis.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryByResourceType(ChEmedEprCompositionDis.class);
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
    public ChEmedEprCompositionDis resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionDis.class);
        if (entry != null && entry.getResource() instanceof final ChEmedEprCompositionDis composition) {
            return composition;
        }
        throw new InvalidEmedContentException(
                "The ChEmedEprCompositionDis is missing in the document Bundle");
    }

    /**
     * Adds a medication dispense.
     *
     * @param medicationDispense the medication dispense.
     * @return this.
     */
    public ChEmedEprDocumentDis addMedicationDispense(final ChEmedEprMedicationDispenseDis medicationDispense) {
        this.addEntry()
                .setFullUrl(medicationDispense.getIdentifierFirstRep().getValue())
                .setResource(medicationDispense);
        return this;
    }

    /**
     * Sets the composition.
     *
     * @param composition The CH EMED Medication Dispense Composition.
     * @return this.
     */
    public ChEmedEprDocumentDis setComposition(final ChEmedEprCompositionDis composition) {
        this.getCompositionEntry()
                .setFullUrl(composition.getIdentifier().getValue())
                .setResource(composition);
        return this;
    }

    @Override
    public ChEmedEprDocumentDis copy() {
        final var copy = new ChEmedEprDocumentDis();
        this.copyValues(copy);
        return copy;
    }
}
