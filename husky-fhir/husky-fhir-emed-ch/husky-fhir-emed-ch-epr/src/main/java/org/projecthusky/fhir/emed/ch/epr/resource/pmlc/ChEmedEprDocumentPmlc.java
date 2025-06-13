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

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Resource;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;

import java.io.Serial;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PMLC Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationcard")
public class ChEmedEprDocumentPmlc extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = 9089732845195396799L;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprDocumentPmlc() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentPmlc(final UUID documentId,
                                 final Instant timestamp) {
        super(documentId, timestamp);
    }

    @Override
    public EmedDocumentType getEmedType() {
        return EmedDocumentType.PMLC;
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionPmlc.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryComponentByResourceType(ChEmedEprCompositionPmlc.class);
        if (entry == null) {
            entry = new BundleEntryComponent();
            this.getEntry().addFirst(entry); // The composition shall go first
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
    public ChEmedEprCompositionPmlc resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionPmlc.class);
        if (entry instanceof final ChEmedEprCompositionPmlc composition) {
            return composition;
        }
        throw new InvalidEmedContentException(
                "The ChEmedEprCompositionPmlc is missing in the document Bundle");
    }

    /**
     * Creates a new entry and adds the given resource to it.
     *
     * @return the created entry.
     */
    public BundleEntryComponent addEntryResource(final Resource resource) {
        return this.addEntry().setResource(resource);
    }

    /**
     * Adds a medication statement.
     *
     * @param medicationStatement the medication statement.
     * @return this.
     */
    public ChEmedEprDocumentPmlc addMedicationStatement(final ChEmedEprMedicationStatementPmlc medicationStatement) {
        this.addEntry()
                .setFullUrl(medicationStatement.getIdentifierFirstRep().getValue())
                .setResource(medicationStatement);
        return this;
    }

    /**
     * Sets the composition.
     *
     * @param composition The CH EMED Medication Card Composition.
     * @return this.
     */
    public ChEmedEprDocumentPmlc setComposition(final ChEmedEprCompositionPmlc composition) {
        this.getCompositionEntry()
                .setFullUrl(composition.getIdentifier().getValue())
                .setResource(composition);
        return this;
    }

    /**
     * It resolves the last medication statement from the PMLC. The last statement is the statement with the most recent
     * medical authorship timestamp. Should several statements share the same last timestamp instant, one among them
     * will be returned, arbitrarily, depending on the order of execution.
     *
     * @return The medication statement with the last medication authorship timestamp. {@code null} if the PMLC contains
     *         no medication statements.
     */
    @ExpectsValidResource
    public @Nullable ChEmedEprMedicationStatementPmlc resolveLastStatement() {
        return resolveComposition().resolveMedicationStatements().stream()
                .reduce(null,(lastStatement, statement) -> {
                    if (lastStatement == null) return statement;
                    if (lastStatement.resolveMedicalAuthorshipTimestamp().isBefore(statement.resolveMedicalAuthorshipTimestamp()))
                        return statement;
                    return lastStatement;
                });
    }

    @ExpectsValidResource
    public List<ChEmedEprMedicationStatementPmlc> resolveStatements() {
        return resolveComposition().resolveMedicationStatements();
    }

    @Override
    public ChEmedEprDocumentPmlc copy() {
        final var copy = new ChEmedEprDocumentPmlc();
        this.copyValues(copy);
        return copy;
    }
}
