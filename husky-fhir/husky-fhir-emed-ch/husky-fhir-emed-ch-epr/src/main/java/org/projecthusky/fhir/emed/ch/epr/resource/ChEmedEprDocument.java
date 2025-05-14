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
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Document Bundles.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprDocument extends Bundle {

    /**
     * Empty constructor for the parser.
     */
    protected ChEmedEprDocument() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param documentId The document ID.
     * @param timestamp  The document creation date.
     */
    protected ChEmedEprDocument(final UUID documentId,
                                final Instant timestamp) {
        super();
        Objects.requireNonNull(documentId, "documentId shall not be null in ChEmedEprDocument()");
        Objects.requireNonNull(timestamp, "timestamp shall not be null in ChEmedEprDocument()");
        this.setType(BundleType.DOCUMENT);
        this.setIdentifier(new Identifier());
        this.getIdentifier().setSystem(FhirSystem.URI);
        this.getIdentifier().setValue(Uuids.URN_PREFIX + documentId);
        this.setTimestamp(Date.from(timestamp));
    }

    public abstract ChEmedEprComposition resolveComposition();

    public abstract EmedDocumentType getEmedType();

    public abstract BundleEntryComponent getCompositionEntry();

    /**
     * Resolves the document UUID or throws.
     *
     * @return the document UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifier().getValue());
    }

    /**
     * Resolves the patient targeted by this medication treatment plan.
     *
     * @return The patient targeted by this medication treatment plan.
     * @throws InvalidEmedContentException if the patient is missing.
     */
    @ExpectsValidResource
    public ChCorePatientEpr resolvePatient() throws InvalidEmedContentException {
        final var entry = this.getEntryByResourceType(ChCorePatientEpr.class);
        if (entry != null && entry.getResource() instanceof final ChCorePatientEpr patient) {
            return patient;
        }
        throw new InvalidEmedContentException("The ChCorePatientEpr is missing in the document Bundle");
    }

    /**
     * Resolves the document timestamp.
     *
     * @return the document timestamp.
     * @throws InvalidEmedContentException if the timestamp is missing.
     */
    @ExpectsValidResource
    public Instant resolveTimestamp() throws InvalidEmedContentException {
        if (!this.hasTimestamp()) {
            throw new InvalidEmedContentException("The document timestamp is missing");
        }
        return this.getTimestampElement().getValueAsCalendar().toInstant();
    }

    /**
     * Sets the document's creation date and time.
     *
     * @param creationTime the document's creation date and time.
     * @return this.
     */
    public ChEmedEprDocument setCreationTime(final Instant creationTime) {
        this.setTimestamp(Date.from(creationTime));
        return this;
    }

    /**
     * Sets the document UUID.
     *
     * @param documentUUID The document UUID.
     * @return this.
     */
    public ChEmedEprDocument setIdentifier(final UUID documentUUID) {
        var identifier = this.getIdentifier();
        if (identifier == null) {
            identifier = new Identifier();
        }

        identifier.setSystem(FhirSystem.URI);
        identifier.setValue(Uuids.URN_PREFIX + documentUUID);

        return this;
    }

    /**
     * Sets the patient targeted by this document.
     *
     * @param patient the patient targeted by this document.
     * @return the bundle entry.
     */
    public BundleEntryComponent setPatient(final ChCorePatientEpr patient) {
        var entry = this.getEntryByResourceType(ChCorePatientEpr.class);
        if (entry == null) {
            entry = this.addEntry();
        }
        entry.setResource(patient);

        return entry;
    }

    /**
     * Finds a bundle entry by the type of its resource or {@code null}, without creating it.
     *
     * @param resourceType The type of the resource.
     * @return the bundle entry or {@code null}.
     */
    @Nullable
    public BundleEntryComponent getEntryByResourceType(final Class<?> resourceType) {
        return this.getEntry().stream()
                .filter(entry -> resourceType.isInstance(entry.getResource()))
                .findAny()
                .orElse(null);
    }

    /**
     * Gets the resources in the package entries by the specified resource type.
     *
     * @param resourceType The type of the resource.
     * @return the list with the resource.
     */
    protected <T> List<T> getEntryResourceByResourceType(final Class<T> resourceType) {
        return this.getEntry().stream()
                .map(BundleEntryComponent::getResource)
                .filter(resourceType::isInstance)
                .map(resourceType::cast)
                .toList();
    }
}
