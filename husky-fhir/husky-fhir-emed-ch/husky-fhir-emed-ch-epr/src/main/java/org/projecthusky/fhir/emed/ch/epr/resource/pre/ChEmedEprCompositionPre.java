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
package org.projecthusky.fhir.emed.ch.epr.resource.pre;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DomainResource;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.CommonLanguages;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PRE Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionPre extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionPre() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     */
    public ChEmedEprCompositionPre(final UUID compositionId,
                                   final Instant date,
                                   final CommonLanguages language) {
        super(compositionId, date, language);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT,
                                            "761938008",
                                            "Medical prescription record (record artifact)"));
        this.setTitle("TODO");
    }

    /**
     * Resolves the authors of the document ({@link ChEmedEprPractitionerRole} | {@link ChCorePatientEpr}).
     *
     * @return the list with the authors of the document.
     * @throws InvalidEmedContentException if no author is specified or if an author is not of type
     *                                     {@link ChEmedEprPractitionerRole} or {@link ChCorePatientEpr}.
     */
    @ExpectsValidResource
    public List<DomainResource> resolveAuthors() throws InvalidEmedContentException {
        if (!this.hasAuthor()) throw new InvalidEmedContentException("The composition requires at least one author.");

        final var authors = new ArrayList<DomainResource>();

        for (final var reference : this.getAuthor()) {
            final var resource = reference.getResource();
            if (resource instanceof ChEmedEprPractitionerRole || resource instanceof ChCorePatientEpr) {
                authors.add((DomainResource) resource);
            } else {
                throw new InvalidEmedContentException("An author is invalid.");
            }
        }
        return authors;
    }

    /**
     * Returns the prescription section; if missing, it creates it.
     *
     * @return the prescription section.
     */
    public SectionComponent getPrescriptionSection() {
        var section = getSectionByLoincCode(PRESCRIPTION_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   PRESCRIPTION_SECTION_CODE_VALUE,
                                                   "PRESCRIPTIONS"));
        }
        return section;
    }

    /**
     * Returns the list medication requests or throws.
     *
     * @return the list with medication requests.
     * @throws InvalidEmedContentException if the medication requests is missing or invalid.
     */
    @ExpectsValidResource
    public List<ChEmedEprMedicationRequestPre> resolveMedicationRequests() throws InvalidEmedContentException {
        final var section = this.getPrescriptionSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var medicationRequests = new ArrayList<ChEmedEprMedicationRequestPre>(0);
        for (final var entry : section.getEntry()) {
            final var resource = entry.getResource();
            if (resource instanceof final ChEmedEprMedicationRequestPre medicationRequest) {
                medicationRequests.add(medicationRequest);
            } else {
                throw new InvalidEmedContentException("The prescription section has a non ChEmedEprMedicationRequestPre resource");
            }
        }
        return medicationRequests;
    }

    /**
     * Returns the annotation section; if missing, it creates it.
     *
     * @return the annotation section.
     */
    public SectionComponent getAnnotationSection() {
        var section = getSectionByLoincCode(ANNOTATION_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   ANNOTATION_SECTION_CODE_VALUE, "Annotation comment"));
        }
        return section;
    }

    /**
     * Returns whether the prescription section exists.
     *
     * @return {@code true} if the prescription section exists, {@code false} otherwise.
     */
    public boolean hasPrescriptionSection() {
        return getSectionByLoincCode(PRESCRIPTION_SECTION_CODE_VALUE) != null;
    }

    /**
     * Returns whether the annotation section exists.
     *
     * @return {@code true} if the annotation section exists, {@code false} otherwise.
     */
    public boolean hasAnnotationSection() {
        return getSectionByLoincCode(ANNOTATION_SECTION_CODE_VALUE) != null;
    }

    /**
     * Adds a {@link ChEmedEprPractitionerRole} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionPre addAuthor(final ChEmedEprPractitionerRole author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Adds a {@link ChCorePatientEpr} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionPre addAuthor(final ChCorePatientEpr author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Adds a {@link ChEmedEprMedicationRequestPre}.
     *
     * @param medicationRequest the medication request.
     */
    public ChEmedEprCompositionPre addMedicationRequest(final ChEmedEprMedicationRequestPre medicationRequest) {
        final var entry = this.getPrescriptionSection().getEntry();
        final var reference = References.createReference(medicationRequest);
        if (entry.isEmpty()) {
            entry.add(reference);
        } else {
            entry.set(0, reference);
        }
        return this;
    }
}
