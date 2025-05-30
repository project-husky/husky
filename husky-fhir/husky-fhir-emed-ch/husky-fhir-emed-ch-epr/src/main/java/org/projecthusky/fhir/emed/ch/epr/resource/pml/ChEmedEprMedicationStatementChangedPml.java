package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocumentAuthorable;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPharmaceuticalAdvice;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprMedicationStatementChanged;

import java.util.UUID;

@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationstatement-changed-list")
public class ChEmedEprMedicationStatementChangedPml extends ChEmedEprMedicationStatementChanged
    implements ChEmedEprDocumentAuthorable<ChEmedEprMedicationStatementChangedPml> {

    protected static final String PARENT_DOCUMENT_URL =
            "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-pharmaceuticaladvice";

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
    @Extension(url = PARENT_DOCUMENT_URL, definedLocally = false)
    protected ChEmedExtPharmaceuticalAdvice parentDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationStatementChangedPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the medication request ID.
     */
    public ChEmedEprMedicationStatementChangedPml(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Constructor that copies the content of the PML med statement to a PML changed statement. This is used as a workaround
     * due to the limitations of HAPI's parser that will only parse all the medication statements to a single type. This
     * method allows a custom parser (or other) to create a {@link ChEmedEprMedicationStatementChangedPml} by copying the
     * values from a parsed {@link ChEmedEprMedicationStatementPml} statement.
     * <p>
     *     If the passed medication statement has the parentDocument extension (as it should if it passed validation), it
     *     will be part of the extensions (and not recognized as parentDocument by the
     *     {@link ChEmedEprMedicationStatementChangedPml} class, since the URLs differ). This constructor will move it
     *     from the extensions to the {@link #parentDocument} custom property of this class.
     * </p>
     * @param request The PML simple request.
     */
    public ChEmedEprMedicationStatementChangedPml(final ChEmedEprMedicationStatementPml request) {
        request.copyValues(this);
        if (hasExtension(ChEmedExtPharmaceuticalAdvice.URL)) {
            final var extension = getExtensionByUrl(ChEmedExtPharmaceuticalAdvice.URL);
            final var parentDocumentExtension = new ChEmedExtPharmaceuticalAdvice(
                    Uuids.parseUrnEncoded(((Identifier) extension.getExtensionByUrl(ChEmedExtPharmaceuticalAdvice.ID_URL).getValue()).getValue()),
                    Uuids.parseUrnEncoded(((Identifier) extension.getExtensionByUrl(ChEmedExtPharmaceuticalAdvice.EXTERNAL_DOCUMENT_ID_URL).getValue()).getValue())
            );
            setParentDocumentElement(parentDocumentExtension);
            getExtension().remove(extension);
        }
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
    public ChEmedEprMedicationStatementChangedPml setAuthorDocument(final @Nullable Reference reference) {
        this.authorDocument = reference;
        return this;
    }

    /**
     * Gets the parent document element. If it doesn't exist, it is created.
     *
     * @return the parent document element.
     */
    public ChEmedExtPharmaceuticalAdvice getParentDocumentElement() {
        if (this.parentDocument == null) {
            this.parentDocument = new ChEmedExtPharmaceuticalAdvice();
        }
        return this.parentDocument;
    }

    /**
     * Sets the parent document reference.
     *
     * @param parentDocument the parent document reference.
     * @return this.
     */
    public ChEmedEprMedicationStatementChangedPml setParentDocumentElement(final ChEmedExtPharmaceuticalAdvice parentDocument) {
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
    public ChEmedEprMedicationStatementChangedPml copy() {
        final var copy = new ChEmedEprMedicationStatementChangedPml();
        this.copyValues(copy);
        return copy;
    }

    /**
     * Copies the content of the medication request to a destination medication request.
     * @param dst The destination medication request.
     */
    @Override
    public void copyValues(final MedicationStatement dst) {
        super.copyValues(dst);
        copyAuthorDocumentValues(dst);
        if (dst instanceof final ChEmedEprMedicationStatementChangedPml als) {
            als.parentDocument = parentDocument == null ? null : parentDocument.copy();
        }
    }
}
