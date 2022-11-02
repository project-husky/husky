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
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Document Bundles.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprDocument extends Bundle {

    /**
     * Empty constructor.
     */
    protected ChEmedEprDocument() {
        super();
        this.setType(BundleType.DOCUMENT);
    }

    /**
     * Constructor.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    protected ChEmedEprDocument(final UUID documentId,
                                final Date timestamp) {
        super();
        Objects.requireNonNull(documentId, "documentId shall not be null in ChEmedEprDocument()");
        Objects.requireNonNull(timestamp, "timestamp shall not be null in ChEmedEprDocument()");
        this.setType(BundleType.DOCUMENT);
        this.setIdentifier(new Identifier());
        this.getIdentifier().setSystem(FhirSystem.URI);
        this.getIdentifier().setValue(Uuids.URN_PREFIX + documentId);
        this.setTimestamp(timestamp);
    }

    /**
     * Finds a bundle entry by the type of its resource or {@code null}, without creating it.
     *
     * @param resourceType The type of the resource.
     * @return the bundle entry or {@code null}.
     */
    @Nullable
    protected BundleEntryComponent getEntryByResourceType(final Class<?> resourceType) {
        return this.getEntry().stream()
                .filter(entry -> resourceType.isInstance(entry.getResource()))
                .findAny()
                .orElse(null);
    }

    public abstract ChEmedEprComposition resolveComposition();

    /**
     * Resolves the document UUID or throws.
     *
     * @return the document UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentfier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return UUID.fromString(this.getIdentifier().getValue());
    }

    /**
     * Sets the document UUID.
     *
     * @param documentUUID The document UUID
     * @return this.
     */
    public ChEmedEprDocument setIdentifier(final UUID documentUUID) {
        var identifier = this.getIdentifier();
        if (identifier == null) {
            identifier = new Identifier();
        }

        identifier.setSystem(FhirSystem.URI);
        identifier.setValue(documentUUID.toString());

        return this;
    }
}
