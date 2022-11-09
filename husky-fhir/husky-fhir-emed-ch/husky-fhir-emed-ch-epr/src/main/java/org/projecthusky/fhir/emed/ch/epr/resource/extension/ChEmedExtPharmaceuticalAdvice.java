package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Child;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-Ext PharmaceuticalAdvice.
 * Extension to represent the reference to the Pharmaceutical Advice document.
 * URL : <a href="http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-pharmaceuticaladvice">...</a>
 *
 * @author Ronaldo Loureiro
 */
public class ChEmedExtPharmaceuticalAdvice extends Extension implements ChEmedExtReference {
    /**
     * ID of the Pharmaceutical Advice document.
     */
    @Child(name = "id")
    @ca.uhn.fhir.model.api.annotation.Extension(url = "id", definedLocally = false)
    protected Identifier identifier;

    /**
     * ID of the external document.
     */
    @Child(name = "externalDocumentId")
    @ca.uhn.fhir.model.api.annotation.Extension(url = "externalDocumentId", definedLocally = false)
    protected Identifier externalDocumentId;

    /**
     * Empty constructor
     */
    public ChEmedExtPharmaceuticalAdvice() {
        super();
    }

    /**
     * Constructor
     *
     * @param id                 the ID of the Pharmaceutical Advice document.
     * @param externalDocumentId the ID of the external document.
     */
    public ChEmedExtPharmaceuticalAdvice(final UUID id,
                                         final UUID externalDocumentId) {
        super();
        this.setIdentifier(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    /**
     * Resolves the ID of the Pharmaceutical Advice document is missing.
     *
     * @return the ID of the Pharmaceutical Advice document is missing.
     * @throws InvalidEmedContentException if the ID of the Pharmaceutical Advice document is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasId())
            throw new InvalidEmedContentException("The ID of the Pharmaceutical Advice document is missing.");
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
     * Sets the ID of the Pharmaceutical Advice document, if it's already exists, it's replaced.
     *
     * @param identifier the ID of the Pharmaceutical Advice document.
     * @return this.
     */
    public ChEmedExtPharmaceuticalAdvice setIdentifier(final UUID identifier) {
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
    public ChEmedExtPharmaceuticalAdvice setExternalDocumentId(final UUID externalDocumentId) {
        if (this.externalDocumentId == null) {
            this.externalDocumentId = new Identifier();
            this.externalDocumentId.setSystem(FhirSystem.URI);
        }
        this.externalDocumentId.setValue(Uuids.URN_PREFIX + externalDocumentId);
        return this;
    }

    /**
     * Returns whether the ID of the Pharmaceutical Advice document exists.
     *
     * @return {@code true} if the ID of the Pharmaceutical Advice document exists, {@code false} otherwise.
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
