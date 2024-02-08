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
package org.projecthusky.fhir.emed.ch.epr.resource.padv;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;

import java.io.Serial;
import java.time.Instant;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PADV Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-pharmaceuticaladvice")
public class ChEmedEprDocumentPadv extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = -4904031873679621597L;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprDocumentPadv() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentPadv(final UUID documentId,
                                 final Instant timestamp) {
        super(documentId, timestamp);
    }

    @Override
    public EmedDocumentType getEmedType() {
        return EmedDocumentType.PADV;
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionPadv.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryByResourceType(ChEmedEprCompositionPadv.class);
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
    public ChEmedEprCompositionPadv resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionPadv.class);
        if (entry != null && entry.getResource() instanceof final ChEmedEprCompositionPadv composition) {
            return composition;
        }
        throw new InvalidEmedContentException(
                "The ChEmedEprCompositionPadv is missing in the document Bundle");
    }

    /**
     * Sets the composition.
     *
     * @param composition The CH EMED Pharmaceutical Advice Composition.
     * @return this.
     */
    public ChEmedEprDocumentPadv setComposition(final ChEmedEprCompositionPadv composition) {
        this.getCompositionEntry()
                .setFullUrl(Uuids.URN_PREFIX + composition.resolveIdentifier())
                .setResource(composition);
        return this;
    }

    /**
     * Sets the observation.
     *
     * @param observation the observation.
     * @return this.
     */
    public ChEmedEprDocumentPadv addObservation(final ChEmedEprObservationPadv observation) {
        this.addEntry()
                .setFullUrl(Uuids.URN_PREFIX + observation.resolveIdentifier())
                .setResource(observation);
        return this;
    }

    /**
     * Sets the medication statement.
     *
     * @param observation the medication statement.
     * @return this.
     */
    public ChEmedEprDocumentPadv addMedicationStatement(final ChEmedEprMedicationStatementMtp observation) {
        this.addEntry()
                .setFullUrl(Uuids.URN_PREFIX + observation.resolveIdentifier())
                .setResource(observation);
        return this;
    }

    @Override
    public ChEmedEprDocumentPadv copy() {
        final var copy = new ChEmedEprDocumentPadv();
        this.copyValues(copy);
        return copy;
    }
}
