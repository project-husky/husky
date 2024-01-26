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
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;

import java.io.Serial;
import java.time.Instant;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR MTP Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationtreatmentplan")
public class ChEmedEprDocumentMtp extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = 1095863629301164639L;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprDocumentMtp() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentMtp(final UUID documentId,
                                final Instant timestamp) {
        super(documentId, timestamp);
    }

    @Override
    public EmedDocumentType getEmedType() {
        return EmedDocumentType.MTP;
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionMtp.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryByResourceType(ChEmedEprCompositionMtp.class);
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
    public ChEmedEprCompositionMtp resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionMtp.class);
        if (entry != null && entry.getResource() instanceof final ChEmedEprCompositionMtp composition) {
            return composition;
        }
        throw new InvalidEmedContentException("The ChEmedEprCompositionMtp is missing in the document Bundle");
    }

    /**
     * Sets the composition.
     *
     * @param composition The CH EMED Medication Treatment Plan Composition.
     * @return this.
     */
    public ChEmedEprDocumentMtp setComposition(final ChEmedEprCompositionMtp composition) {
        this.getCompositionEntry()
                .setFullUrl(composition.getIdentifier().getValue())
                .setResource(composition);
        return this;
    }

    /**
     * Sets the medication statement. If it already exists, it will be replaced.
     *
     * @param medicationStatement the medication statement.
     * @return this.
     */
    public ChEmedEprDocumentMtp setMedicationStatement(final ChEmedEprMedicationStatementMtp medicationStatement) {
        var entry = this.getEntryByResourceType(ChEmedEprMedicationStatementMtp.class);
        if (entry == null) {
            entry = this.addEntry();
        }
        entry.setFullUrl(medicationStatement.getIdentifierFirstRep().getValue());
        entry.setResource(medicationStatement);

        return this;
    }

    @Override
    public ChEmedEprDocumentMtp copy() {
        final var copy = new ChEmedEprDocumentMtp();
        this.copyValues(copy);
        return copy;
    }
}
