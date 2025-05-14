package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.util.ElementUtil;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.core.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-Extension. Extension to represent the reference to the document
 *
 * @author Ronaldo Loureiro
 */
@Block
public abstract class ChEmedExtensionReference extends BackboneElement {
    public static final String ID_URL = "id";
    public static final String EXTERNAL_DOCUMENT_ID_URL = "externalDocumentId";

    /**
     * ID of the document.
     */
    @Nullable
    @Child(name = "extension:" + ID_URL, min = 1)
    @Extension(url = ID_URL, definedLocally = false)
    protected Identifier extensionId;

    /**
     * ID of the external document.
     */
    @Nullable
    @Child(name = "extension:" + EXTERNAL_DOCUMENT_ID_URL, min = 1)
    @Extension(url = EXTERNAL_DOCUMENT_ID_URL, definedLocally = false)
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
        this.setExtensionId(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    /**
     * Resolves the ID of the document.
     *
     * @return the ID of the document.
     * @throws InvalidEmedContentException if the ID of the document is missing or invalid.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasExtensionId())
            throw new InvalidEmedContentException("The ID of the document is missing.");

        return Uuids.parseUrnEncoded(this.extensionId.getValue());
    }

    /**
     * Resolves the ID of the external document.
     *
     * @return the ID of the external document.
     * @throws InvalidEmedContentException if the ID of the external document is missing or invalid.
     */
    @ExpectsValidResource
    public UUID resolveExternalDocumentId() throws InvalidEmedContentException {
        if (!this.hasExternalDocumentId())
            throw new InvalidEmedContentException("The ID of the external document is missing.");

        return Uuids.parseUrnEncoded(this.externalDocumentId.getValue());
    }

    /**
     * Resolves the eMed reference.
     *
     * @return the eMed reference.
     * @throws InvalidEmedContentException if the IDs are missing.
     */
    @ExpectsValidResource
    public EmedReference resolveReference() throws InvalidEmedContentException {
        return new EmedReference(resolveExternalDocumentId(), resolveIdentifier(), null, this.getEntryType());
    }

    /**
     * Gets the extension id element. If it doesn't exist, it is created.
     *
     * @return the extension id element.
     */
    public Identifier getExtensionIdElement() {
        if (this.extensionId == null) {
            this.extensionId = new Identifier();
        }
        return this.extensionId;
    }

    /**
     * Gets the external document id element. If it doesn't exist, it is created.
     *
     * @return the external document id element.
     */
    public Identifier getExternalDocumentIdElement() {
        if (this.externalDocumentId == null) {
            this.externalDocumentId = new Identifier();
        }
        return this.externalDocumentId;
    }

    /**
     * Sets the ID of the document, if it already exists, it is replaced.
     *
     * @param extensionId the ID of the document.
     * @return this.
     */
    public ChEmedExtensionReference setExtensionId(final UUID extensionId) {
        if (this.extensionId == null) {
            this.extensionId = new Identifier();
        }
        this.extensionId.setSystem(FhirSystem.URI)
                .setValue(Uuids.URN_PREFIX + extensionId);
        return this;
    }

    /**
     * Sets the ID of the external document, if it already exists, it is replaced.
     *
     * @param externalDocumentId the ID of the external document.
     * @return this.
     */
    public ChEmedExtensionReference setExternalDocumentId(final UUID externalDocumentId) {
        if (this.externalDocumentId == null) {
            this.externalDocumentId = new Identifier();
        }
        this.externalDocumentId.setSystem(FhirSystem.URI)
                .setValue(Uuids.URN_PREFIX + externalDocumentId);
        return this;
    }

    /**
     * Returns whether ID of the document exists.
     *
     * @return {@code true} if the ID of the document exists, {@code false} otherwise.
     */
    public boolean hasExtensionId() {
        return this.extensionId != null && !this.extensionId.isEmpty();
    }

    /**
     * Returns whether ID of the external document exists.
     *
     * @return {@code true} if the ID of the external document exists, {@code false} otherwise.
     */
    public boolean hasExternalDocumentId() {
        return this.externalDocumentId != null && !this.externalDocumentId.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() && ElementUtil.isEmpty(extensionId, externalDocumentId);
    }

    public abstract EmedEntryType getEntryType();

    @Override
    public void copyValues(final BackboneElement dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedExtensionReference als) {
            als.extensionId = extensionId == null ? null : extensionId.copy();
            als.externalDocumentId = externalDocumentId == null ? null : externalDocumentId.copy();
        }
    }
}
