package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationRequest;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest (PML).
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedEprMedicationRequestPml extends ChEmedEprMedicationRequest {
    /**
     * Author of the original document if different from the author of the medical decision.
     */
    @Nullable
    @Child(name = "authorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author", definedLocally = false)
    protected Reference authorDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationRequestPml() {
        super();
    }

    /**
     * Constructor      * Constructor that pre-populates fields.
     *
     * @param entryUuid the medication request ID.
     */
    public ChEmedEprMedicationRequestPml(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Resolves the author and her/his organization of the medical decision.
     *
     * @return the author and her/his organization of the medical decision.
     * @throws InvalidEmedContentException if author and her/his organization of the medical decision are missing or
     *                                     isn't of the right type.
     */
    @ExpectsValidResource
    public ChEmedEprPractitionerRole resolvePerformer() throws InvalidEmedContentException {
        if (!this.hasPerformer()) throw new InvalidEmedContentException(
                "The author and her/his organization of the medical decision are missing.");
        final var resource = this.getPerformer().getResource();
        if (resource instanceof ChEmedEprPractitionerRole chEmedEprPractitionerRole) {
            return chEmedEprPractitionerRole;
        }
        throw new InvalidEmedContentException(
                "The reference to the author and her/his organization of the medical decision isn't of the right type.");
    }

    /**
     * Gets the author reference of the original document if different from the author of the medical decision. If it
     * doesn't exist, it's created.
     *
     * @return the author reference of the original document
     */
    public Reference getAuthorDocumentElement() {
        if (this.authorDocument == null) {
            this.authorDocument = new Reference();
        }
        return this.authorDocument;
    }

    /**
     * Sets the author of the original document.
     *
     * @param author the author.
     * @return this.
     */
    public ChEmedEprMedicationRequestPml setAuthorDocument(final IBaseResource author) {
        this.authorDocument = References.createReference((Resource) author);
        return this;
    }

    /**
     * Sets the author and her/his organization of the medical decision.
     *
     * @param practitionerRole the author and her/his organization of the medical decision.
     * @return this.
     */
    public ChEmedEprMedicationRequestPml setPerformer(final ChEmedEprPractitionerRole practitionerRole) {
        this.setPerformer(References.createReference(practitionerRole));
        return this;
    }

    /**
     * Return whether author of the original document.
     *
     * @return {@code true} if the author of the original document exists, {@code false} otherwise.
     */
    public boolean hasAuthorDocument() {
        return this.authorDocument != null && !this.authorDocument.isEmpty();
    }
}
