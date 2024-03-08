package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocumentAuthorable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprObservation;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPharmaceuticalAdvice;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation (PML).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-observation-list")
public class ChEmedEprObservationPml
        extends ChEmedEprObservation<ChEmedEprMedicationStatementPml>
        implements ChEmedEprDocumentAuthorable<ChEmedEprObservationPml> {

    /**
     * Author of the original document if different from the author of the medical decision (Observation.performer), see
     * also 'Guidance - Different Authors'
     */
    @Nullable
    @Child(name = "authorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author")
    protected Reference authorDocument;

    /**
     * Reference to the original document.
     */
    @Nullable
    @Child(name = "parentDocument")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-pharmaceuticaladvice")
    protected ChEmedExtPharmaceuticalAdvice parentDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprObservationPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication statement id.
     * @param padvType  The pharmaceutical advice type.
     */
    public ChEmedEprObservationPml(final UUID entryUuid,
                                   final EmedPadvEntryType padvType) {
        super(entryUuid, padvType);
    }

    /**
     *
     * @return The {@link ChEmedEprMedicationStatementPml} class, since it is the resulting class of parsing the
     * medication statement changed resources in a PML document (parser limitation).
     */
    @Override
    protected Class<ChEmedEprMedicationStatementPml> getMedicationStatementChangedType() {
        return ChEmedEprMedicationStatementPml.class;
    }

    /**
     * Gets the author document element in the observation.
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
     * Sets the reference to the original author of the document.
     * @param reference The reference to be set as authorDocument.
     * @return this.
     */
    @Override
    public ChEmedEprObservationPml setAuthorDocument(final @Nullable Reference reference) {
        this.authorDocument = reference;
        return this;
    }

    /**
     * Sets the author and her/his organization of the medical decision.
     *
     * @param performer the author and her/his organization of the medical decision.
     * @return this.
     */
    public ChEmedEprObservationPml setPerformer(final ChEmedEprPractitionerRole performer) {
        final var reference = References.createReference(performer);
        if (this.getPerformer().isEmpty()) {
            this.addPerformer(reference);
        } else {
            this.getPerformer().set(0, reference);
        }
        return this;
    }

    /**
     * Sets the author and her/his organization of the medical decision.
     *
     * @param performer the author and her/his organization of the medical decision.
     * @return this.
     */
    public ChEmedEprObservationPml setPerformer(final ChCorePatientEpr performer) {
        final var reference = References.createReference(performer);
        if (this.getPerformer().isEmpty()) {
            this.addPerformer(reference);
        } else {
            this.getPerformer().set(0, reference);
        }
        return this;
    }

    /**
     * Sets the author and her/his organization of the medical decision.
     *
     * @param performer the author and her/his organization of the medical decision.
     * @return this.
     */
    public ChEmedEprObservationPml setPerformer(final RelatedPerson performer) {
        final var reference = References.createReference(performer);
        if (this.getPerformer().isEmpty()) {
            this.addPerformer(reference);
        } else {
            this.getPerformer().set(0, reference);
        }
        return this;
    }

    /**
     * Sets a reference to the received auhor as performer (medical author)
     * @param performer The author to be referenced as performer (medical author).
     * @return this.
     */
    public ChEmedEprObservationPml setPerformer(final Author performer) {
        final var reference = References.createAuthorReference(performer);
        if (getPerformer().isEmpty()) {
            addPerformer(reference);
        } else {
            getPerformer().set(0, reference);
        }
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
    public ChEmedEprObservationPml setParentDocumentElement(final ChEmedExtPharmaceuticalAdvice parentDocument) {
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
    public ChEmedEprObservationPml copy() {
        final var copy = new ChEmedEprObservationPml();
        this.copyValues(copy);
        return copy;
    }

    /**
     * Copies the content of the observation to another observation.
     * @param dst The destination observation.
     */
    @Override
    public void copyValues(final Observation dst) {
        super.copyValues(dst);
        copyAuthorDocumentValues(dst);
        if (dst instanceof final ChEmedEprObservationPml als) {
            als.parentDocument = parentDocument == null ? null : parentDocument.copy();
        }
    }


}
