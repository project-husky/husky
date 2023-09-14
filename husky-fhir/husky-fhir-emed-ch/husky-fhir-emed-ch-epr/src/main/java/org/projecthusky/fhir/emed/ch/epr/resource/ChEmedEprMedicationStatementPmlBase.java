package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;

import java.util.UUID;

/**
 * Base class for PML and PMLC medication statements with common behaviour.
 */
public abstract class ChEmedEprMedicationStatementPmlBase
        extends ChEmedEprMedicationStatement
        implements ChEmedEprDocumentAuthorable<ChEmedEprMedicationStatementPmlBase> {
    /**
     * "Last" author of the original document if different from the author of the medical decision
     * (MedicationStatement.informationSource)
     */
    @Nullable
    @Child(name = "authorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author")
    protected Reference authorDocument;

    public ChEmedEprMedicationStatementPmlBase() {
        super();
    }
    public ChEmedEprMedicationStatementPmlBase(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Gets the author document element in the medication statement.
     *
     * @return the author document element.
     */
    @Override
    public Reference getAuthorDocument() {
        if (this.authorDocument == null) {
            this.authorDocument = new Reference();
        }
        return this.authorDocument;
    }

    /**
     * Sets the authorDocument reference.
     * @param reference The reference to be set as authorDocument.
     * @return this.
     */
    @Override
    public ChEmedEprMedicationStatementPmlBase setAuthorDocument(final Reference reference) {
        this.authorDocument = reference;
        return this;
    }

    /**
     * Resolves the information source.
     *
     * @return the information source as an {@link Author}.
     */
    @Override
    @ExpectsValidResource
    public Author resolveInformationSource() {
        if (!this.hasInformationSource()) {
            throw new InvalidEmedContentException(
                    "The information source is missing.");
        }
        final var author = new Author(this.getInformationSource().getResource());
        org.hl7.fhir.r4.model.Extension extension =
                getInformationSource().getExtensionByUrl("http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time");
        if (extension == null) throw new InvalidEmedContentException("The information source time extension is missing.");
        author.setTime(((DateTimeType) extension.getValue()).getValueAsCalendar().toInstant());
        return author;
    }

    /**
     * Copies the content from this statement to a destination statement.
     * @param dst The destination statement.
     */
    @Override
    public void copyValues(final MedicationStatement dst) {
        super.copyValues(dst);
        copyAuthorDocumentValues(dst);
    }
}
