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
package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprMedicationStatementChanged;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;

import java.io.Serial;
import java.time.Instant;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PML Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationlist")
public class ChEmedEprDocumentPml extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = -1802412421572043644L;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprDocumentPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentPml(final UUID documentId,
                                final Instant timestamp) {
        super(documentId, timestamp);
    }

    @Override
    public EmedDocumentType getEmedType() {
        return EmedDocumentType.PML;
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionPml.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryByResourceType(ChEmedEprCompositionPml.class);
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
    public ChEmedEprCompositionPml resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionPml.class);
        if (entry != null && entry.getResource() instanceof final ChEmedEprCompositionPml composition) {
            return composition;
        }
        throw new InvalidEmedContentException(
                "The ChEmedEprCompositionPml is missing in the document Bundle");
    }

    /**
     * Sets the composition.
     *
     * @param composition The CH EMED Medication List Composition.
     * @return the bundle entry.
     */
    public BundleEntryComponent setComposition(final ChEmedEprCompositionPml composition) {
        return this.getCompositionEntry()
                .setFullUrl(composition.getIdentifier().getValue())
                .setResource(composition);
    }

    /**
     * Adds a medication statement.
     *
     * @param medicationStatement a medication statement.
     * @return the bundle entry.
     */
    public BundleEntryComponent addMedicationStatement(final ChEmedEprMedicationStatementPml medicationStatement) {
        return this.addEntry()
                .setFullUrl(medicationStatement.getIdentifierFirstRep().getValue())
                .setResource(medicationStatement);
    }

    /**
     * Adds a medication statement.
     *
     * @param medicationStatement a medication statement.
     * @return the bundle entry.
     */
    public BundleEntryComponent addMedicationStatement(final ChEmedEprMedicationStatementMtp medicationStatement) {
        return this.addEntry()
                .setFullUrl(medicationStatement.getIdentifierFirstRep().getValue())
                .setResource(medicationStatement);
    }

    /**
     * Adds a medication statement.
     *
     * @param medicationStatement a medication statement.
     * @return the bundle entry.
     */
    public BundleEntryComponent addMedicationStatement(final ChEmedEprMedicationStatementChanged medicationStatement) {
        return this.addEntry()
                .setFullUrl(medicationStatement.getIdentifierFirstRep().getValue())
                .setResource(medicationStatement);
    }

    /**
     * Adds a medication request.
     *
     * @param medicationRequest a medication request.
     * @return the bundle entry.
     */
    public BundleEntryComponent addMedicationRequest(final ChEmedEprMedicationRequestPml medicationRequest) {
        return this.addEntry()
                .setFullUrl(medicationRequest.getIdentifierFirstRep().getValue())
                .setResource(medicationRequest);
    }

    /**
     * Adds a medication request.
     *
     * @param medicationRequest a medication request.
     * @return the bundle entry.
     */
    public BundleEntryComponent addMedicationRequest(final ChEmedEprMedicationRequestPre medicationRequest) {
        return this.addEntry()
                .setFullUrl(medicationRequest.getIdentifierFirstRep().getValue())
                .setResource(medicationRequest);
    }

    /**
     * Adds a medication dispense.
     *
     * @param medicationDispense a medication dispense.
     * @return the bundle entry.
     */
    public BundleEntryComponent addMedicationDispense(final ChEmedEprMedicationDispensePml medicationDispense) {
        return this.addEntry()
                .setFullUrl(medicationDispense.getIdentifierFirstRep().getValue())
                .setResource(medicationDispense);
    }

    /**
     * Adds an observation.
     *
     * @param observation an observation.
     * @return the bundle entry.
     */
    public BundleEntryComponent addObservation(final ChEmedEprObservationPml observation) {
        return this.addEntry()
                .setFullUrl(observation.getIdentifierFirstRep().getValue())
                .setResource(observation);
    }

    @Override
    public ChEmedEprDocumentPml copy() {
        final var copy = new ChEmedEprDocumentPml();
        this.copyValues(copy);
        return copy;
    }
}
