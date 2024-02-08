package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocumentAuthorable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationRequest;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest (PML).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationrequest-list")
public class ChEmedEprMedicationRequestPml
        extends ChEmedEprMedicationRequest implements ChEmedEprDocumentAuthorable<ChEmedEprMedicationRequestPml> {

    /**
     * Author of the original document if different from the author of the medical decision.
     */
    @Nullable
    @Child(name = "authorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author", definedLocally = false)
    protected Reference authorDocument;

    /**
     * Reference to the original document.
     */
    @Nullable
    @Child(name = "parentDocument")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-prescription")
    protected ChEmedExtPrescription parentDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationRequestPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the medication request ID.
     */
    public ChEmedEprMedicationRequestPml(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Gets the author reference of the original document if different from the author of the medical decision. If it
     * doesn't exist, it's created.
     *
     * @return the author reference of the original document
     */
    @Override
    public Reference getAuthorDocument() {
        if (this.authorDocument == null) {
            this.authorDocument = new Reference();
        }
        return this.authorDocument;
    }

    /**
     * Sets the reference to the original author of the document.
     * @param reference The reference to be set as authorDocument.
     * @return this.
     */
    @Override
    public ChEmedEprMedicationRequestPml setAuthorDocument(final Reference reference) {
        this.authorDocument = reference;
        return this;
    }

    /**
     * Gets the parent document element. If it doesn't exist, it is created.
     *
     * @return the parent document element.
     */
    public ChEmedExtPrescription getParentDocumentElement() {
        if (this.parentDocument == null) {
            this.parentDocument = new ChEmedExtPrescription();
        }
        return this.parentDocument;
    }

    /**
     * Sets the parent document reference.
     *
     * @param parentDocument the parent document reference.
     * @return this.
     */
    public ChEmedEprMedicationRequestPml setParentDocumentElement(final ChEmedExtPrescription parentDocument) {
        this.parentDocument = parentDocument;
        return this;
    }

    /**
     * Returns whether the parent document reference exists.
     *
     * @return {@code true} if the parent document reference exists, {@code false} otherwise.
     */
    public boolean hasParentDocument() {
        return this.parentDocument != null && !this.parentDocument.isEmpty();
    }

    @Override
    public ChEmedEprMedicationRequestPml copy() {
        final var copy = new ChEmedEprMedicationRequestPml();
        this.copyValues(copy);
        return copy;
    }

    /**
     * Copies the content of the medication request to a destination medication request.
     * @param dst The destination medication request.
     */
    @Override
    public void copyValues(final MedicationRequest dst) {
        super.copyValues(dst);
        copyAuthorDocumentValues(dst);
        if (dst instanceof final ChEmedEprMedicationRequestPml als) {
            als.parentDocument = parentDocument == null ? null : parentDocument.copy();
        }
    }
}
