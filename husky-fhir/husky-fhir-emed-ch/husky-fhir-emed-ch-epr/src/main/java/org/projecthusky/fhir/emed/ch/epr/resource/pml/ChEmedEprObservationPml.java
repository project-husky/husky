package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprObservation;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation (PML).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-observation-list")
public class ChEmedEprObservationPml extends ChEmedEprObservation {

    /**
     * Author of the original document if different from the author of the medical decision (Observation.performer), see
     * also 'Guidance - Different Authors'
     */
    @Nullable
    @Child(name = "authorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author")
    protected Reference authorDocument;

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
     * Resolves the author and her/his organization of the medical decision.
     *
     * @return the author and her/his organization of the medical decision.
     * @throws InvalidEmedContentException if the author and her/his organization of the medical decision are missing or
     *                                     aren't of the right type.
     */
    @ExpectsValidResource
    public ChEmedEprPractitionerRole resolvePerformer() throws InvalidEmedContentException {
        if (!this.hasPerformer()) throw new InvalidEmedContentException(
                "The the author and her/his organization of the medical decision is missing.");
        final var resource = this.getPerformerFirstRep().getResource();
        if (resource instanceof ChEmedEprPractitionerRole chEmedEprPractitionerRole) {
            return chEmedEprPractitionerRole;
        }
        throw new InvalidEmedContentException(
                "The author and her/his organization of the medical decision resource isn't of the right type.");
    }

    /**
     * Gets the author document element in the observation.
     *
     * @return the author document element.
     */
    public Reference getAuthorDocumentElement() {
        if (this.authorDocument == null) {
            this.authorDocument = new Reference();
        }
        return this.authorDocument;
    }

    /**
     * Gets the last author document resource in the observation if available.
     *
     * @return the author document resource or {@code null}.
     * @throws InvalidEmedContentException if the author document resource is invalid.
     */
    @Nullable
    @ExpectsValidResource
    public DomainResource getAuthorDocument() throws InvalidEmedContentException {
        final var resource = getAuthorDocumentElement().getResource();
        if (resource == null) return null;

        if (resource instanceof ChCorePatientEpr || resource instanceof ChEmedEprPractitionerRole) {
            return (DomainResource) resource;
        }
        throw new InvalidEmedContentException("The last author of the original document is invalid");
    }

    /**
     * Sets the author of the original document.
     *
     * @param author the author.
     * @return this.
     */
    public ChEmedEprObservationPml setAuthorDocument(final IBaseResource author) {
        this.authorDocument = References.createReference((Resource) author);
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
     * Returns whether author document exists.
     *
     * @return {@code true} if the author document exists, {@code false} otherwise.
     */
    public boolean hasAuthorDocument() {
        return this.authorDocument != null && this.authorDocument.getResource() != null;
    }

    @Override
    public ChEmedEprObservationPml copy() {
        final var copy = new ChEmedEprObservationPml();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final Observation dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedEprObservationPml als) {
            als.authorDocument = authorDocument == null ? null : authorDocument.copy();
        }
    }
}
