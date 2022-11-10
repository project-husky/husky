package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-Extension.
 * Extension to represent the reference to the document
 *
 * @author Ronaldo Loureiro
 */
@Block
public abstract class ChEmedExtensionReference extends BackboneElement {

    /**
     * ID of the document.
     */
    @Child(name = "id", min = 1)
    @Extension(url = "id", definedLocally = false)
    protected Identifier identifier;

    /**
     * ID of the external document.
     */
    @Child(name = "externalDocumentId", min = 1)
    @Extension(url = "externalDocumentId", definedLocally = false)
    protected Identifier externalDocumentId;

    /**
     * Empty constructor
     */
    public ChEmedExtensionReference() {
        super();
    }

    /**
     * Constructor
     *
     * @param id                 the ID of the document.
     * @param externalDocumentId the ID of the external document.
     */
    public ChEmedExtensionReference(final UUID id,
                                    final UUID externalDocumentId) {
        super();
        this.setIdentifier(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    /**
     * Resolves the ID of the document.
     *
     * @return the ID of the document.
     * @throws InvalidEmedContentException if the ID of the document is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasId())
            throw new InvalidEmedContentException("The ID of the document is missing.");
        return Uuids.parseUrnEncoded(this.identifier.getValue());
    }

    /**
     * Resolves the ID of the external document is missing.
     *
     * @return the ID of the external document is missing.
     * @throws InvalidEmedContentException if the ID of the external document is missing.
     */
    @ExpectsValidResource
    public UUID resolveExternalDocumentId() throws InvalidEmedContentException {
        if (!this.hasExternalDocumentId())
            throw new InvalidEmedContentException("The ID of the external document is missing.");
        return Uuids.parseUrnEncoded(this.externalDocumentId.getValue());
    }

    /**
     * Sets the ID of the document, if it's already exists, it's replaced.
     *
     * @param identifier the ID of the document.
     * @return this.
     */
    public ChEmedExtensionReference setIdentifier(final UUID identifier) {
        if (this.identifier == null) {
            this.identifier = new Identifier();
            this.identifier.setSystem(FhirSystem.URI);
        }
        this.identifier.setValue(Uuids.URN_PREFIX + identifier);
        return this;
    }

    /**
     * Sets the ID of the external document, if it's already exists, it's replaced.
     *
     * @param externalDocumentId the ID of the external document.
     * @return this.
     */
    public ChEmedExtensionReference setExternalDocumentId(final UUID externalDocumentId) {
        if (this.externalDocumentId == null) {
            this.externalDocumentId = new Identifier();
            this.externalDocumentId.setSystem(FhirSystem.URI);
        }
        this.externalDocumentId.setValue(Uuids.URN_PREFIX + externalDocumentId);
        return this;
    }

    /**
     * Returns whether ID of the Medication Treatment Plan document exists.
     *
     * @return {@code true} if the ID of the Medication Treatment Plan document exists, {@code false} otherwise.
     */
    public boolean hasId() {
        return this.identifier != null && !this.identifier.isEmpty();
    }

    /**
     * Returns whether ID of the external document exists.
     *
     * @return {@code true} if the ID of the external document exists, {@code false} otherwise.
     */
    public boolean hasExternalDocumentId() {
        return this.externalDocumentId != null && !this.externalDocumentId.isEmpty();
    }
}
