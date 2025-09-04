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
package org.projecthusky.fhir.emed.ch.epr.resource.pre;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;

import java.io.Serial;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PRE Document Bundle.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationprescription")
public class ChEmedEprDocumentPre extends ChEmedEprDocument {
    @Serial
    private static final long serialVersionUID = 2718367416326416761L;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprDocumentPre() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    public ChEmedEprDocumentPre(final UUID documentId,
                                final Instant timestamp) {
        super(documentId, timestamp);
    }

    @Override
    public EmedDocumentType getEmedType() {
        return EmedDocumentType.PRE;
    }

    /**
     * Returns whether the composition entry exists.
     *
     * @return {@code true} if the composition entry exists, {@code false} otherwise.
     */
    public boolean hasCompositionEntry() {
        return this.getEntryByResourceType(ChEmedEprCompositionPre.class) != null;
    }

    /**
     * Returns the composition entry; if missing, it creates it.
     *
     * @return the composition entry.
     */
    public BundleEntryComponent getCompositionEntry() {
        var entry = this.getEntryComponentByResourceType(ChEmedEprCompositionPre.class);
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
     * @throws InvalidEmedContentException if the composition is missing or if the medication requests are missing or
     *                                     any is invalid.
     */
    @ExpectsValidResource
    public ChEmedEprCompositionPre resolveComposition() {
        final var entry = this.getEntryByResourceType(ChEmedEprCompositionPre.class);
        if (entry instanceof final ChEmedEprCompositionPre composition) {
            return composition;
        }
        throw new InvalidEmedContentException(
                "The ChEmedEprCompositionPre is missing in the document Bundle");
    }

    /**
     * Convenience method to resolve all the medication requests listed in the composition of this prescription document.
     *
     * @return The medication requests.
     * @throws InvalidEmedContentException if the composition is missing.
     */
    @ExpectsValidResource
    public List<@NonNull ChEmedEprMedicationRequestPre> resolveMedicationRequests() {
        return resolveComposition().resolveMedicationRequests();
    }

    /**
     * Adds a medication request in the document.
     *
     * @param medicationRequest the medication request.
     * @return this.
     */
    public ChEmedEprDocumentPre addMedicationRequest(final ChEmedEprMedicationRequestPre medicationRequest) {
        this.addEntry()
                .setFullUrl(medicationRequest.getIdentifierFirstRep().getValue())
                .setResource(medicationRequest);

        return this;
    }

    /**
     * Sets the composition.
     *
     * @param composition The CH EMED Medication Prescription Composition.
     * @return this.
     */
    public ChEmedEprDocumentPre setComposition(final ChEmedEprCompositionPre composition) {
        this.getCompositionEntry()
                .setFullUrl(composition.getIdentifier().getValue())
                .setResource(composition);
        return this;
    }

    /**
     * It resolves the last medication request from the PRE. The last request is the request with the most recent
     * medical authorship timestamp. Should several request share the same last timestamp instant, one among them
     * will be returned, arbitrarily, depending on the order of execution.
     *
     * @return The medication request with the last medication authorship timestamp.
     * @throws InvalidEmedContentException if the PRE document does not have any request listed in the prescription
     *                                     section or if any other errors related to CH EMED EPR invalid content are found.
     */
    @ExpectsValidResource
    public ChEmedEprMedicationRequestPre resolveLastRequest() {
        final var res =  resolveComposition().resolveMedicationRequests().stream()
                .reduce(null,(lastRequest, request) -> {
                    if (lastRequest == null) return request;
                    if (lastRequest.resolveMedicalAuthorshipTimestamp().isBefore(request.resolveMedicalAuthorshipTimestamp()))
                        return request;
                    return lastRequest;
                });
        if (res == null) throw new InvalidEmedContentException("No medication request found");
        else return res;
    }

    @Override
    public ChEmedEprDocumentPre copy() {
        final var copy = new ChEmedEprDocumentPre();
        this.copyValues(copy);
        return copy;
    }
}
