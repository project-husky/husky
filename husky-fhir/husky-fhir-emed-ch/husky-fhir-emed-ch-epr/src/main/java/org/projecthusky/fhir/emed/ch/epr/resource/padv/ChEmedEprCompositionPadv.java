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
package org.projecthusky.fhir.emed.ch.epr.resource.padv;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.enums.CompositionTitle;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PADV Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-composition-pharmaceuticaladvice")
public class ChEmedEprCompositionPadv extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionPadv() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     */
    public ChEmedEprCompositionPadv(final UUID compositionId,
                                    final Instant date,
                                    final LanguageCode language) {
        super(compositionId, date, language);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "419891008", "Record artifact (record artifact)"));
        this.getType().addCoding(new Coding(FhirSystem.LOINC,
                                            "61356-2",
                                            "Medication pharmaceutical advice.extended Document"));
        this.setTitle(CompositionTitle.PADV.getDisplayName(language));
    }

    /**
     * Resolves the authors of the document ({@link ChEmedEprPractitionerRole}, {@link ChCorePatientEpr} or
     * {@link Device}).
     *
     * @return the list with the authors of the document.
     * @throws InvalidEmedContentException if no author is specified or if an author is not of type
     *                                     {@link ChEmedEprPractitionerRole}, {@link ChCorePatientEpr} or
     *                                     {@link Device}.
     */
    @ExpectsValidResource
    public List<DomainResource> resolveAuthors() throws InvalidEmedContentException {
        if (!this.hasAuthor()) {
            throw new InvalidEmedContentException("The composition requires at least one author.");
        }

        final var authors = new ArrayList<DomainResource>();

        for (final var reference : this.getAuthor()) {
            final var resource = reference.getResource();
            if (resource instanceof ChEmedEprPractitionerRole
                    || resource instanceof ChCorePatientEpr
                    || resource instanceof Device) {
                authors.add((DomainResource) resource);
            } else {
                throw new InvalidEmedContentException("An author is invalid.");
            }
        }
        return authors;
    }

    /**
     * Resolves the main human author of the document.
     *
     * @return the main human author.
     * @throws InvalidEmedContentException if no author is specified or if an author is not of type
     *                                     {@link ChEmedEprPractitionerRole} or {@link ChCorePatientEpr}.
     */
    @ExpectsValidResource
    public Resource resolveMainHumanAuthor() {
        return this.resolveAuthors().stream()
                .filter(author -> author instanceof ChEmedEprPractitionerRole || author instanceof ChCorePatientEpr)
                .findFirst()
                .orElseThrow(() -> new InvalidEmedContentException(""));
    }

    /**
     * Returns the pharmaceutical advice section; if missing, it creates it.
     *
     * @return the pharmaceutical advice section.
     */
    public SectionComponent getPharmaceuticalAdviceSection() {
        var section = getSectionByLoincCode(PHARMACEUTICAL_ADVICE_SECTION_CODE_VALUE);
        if (section == null) {
            section = this.addSection();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   PHARMACEUTICAL_ADVICE_SECTION_CODE_VALUE,
                                                   "Medication pharmaceutical advice.brief Document"));
        }
        return section;
    }

    /**
     * Returns the observation or throws.
     *
     * @return the observation.
     * @throws InvalidEmedContentException if the observation is missing.
     */
    @ExpectsValidResource
    public ChEmedEprObservationPadv resolveObservation() throws InvalidEmedContentException {
        final var section = this.getPharmaceuticalAdviceSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var resource = section.getEntry().get(0).getResource();
        if (resource instanceof final ChEmedEprObservationPadv medicationPharmaceuticalAdvice) {
            return medicationPharmaceuticalAdvice;
        }
        throw new InvalidEmedContentException("The section isn't referencing a ChEmedEprObservationPadv resource");
    }

    /**
     * Returns the annotation section; if missing, it creates it.
     *
     * @return the annotation section.
     */
    public SectionComponent getAnnotationSection() {
        var section = getSectionByLoincCode(ANNOTATION_SECTION_CODE_VALUE);
        if (section == null) {
            section = this.addSection();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   ANNOTATION_SECTION_CODE_VALUE, "Annotation comment [Interpretation] Narrative"));
        }
        return section;
    }

    /**
     * Returns whether the pharmaceutical advice section exists.
     *
     * @return {@code true} if the pharmaceutical advice section exists, {@code false} otherwise.
     */
    public boolean hasPharmaceuticalAdviceSection() {
        return getSectionByLoincCode(PHARMACEUTICAL_ADVICE_SECTION_CODE_VALUE) != null;
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
    public ChEmedEprCompositionPadv addAuthor(final ChEmedEprPractitionerRole author) {
        this.addAuthor(new Reference(author));
        return this;
    }

    /**
     * Adds a {@link ChCorePatientEpr} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionPadv addAuthor(final ChCorePatientEpr author) {
        this.addAuthor(new Reference(author));
        return this;
    }

    @Override
    public ChEmedEprCompositionPadv copy() {
        final var copy = new ChEmedEprCompositionPadv();
        this.copyValues(copy);
        return copy;
    }
}
