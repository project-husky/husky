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
package org.projecthusky.fhir.emed.ch.epr.resource.mtp;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Resource;
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
 * The HAPI custom structure for the CH-EMED-EPR MTP Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-composition-medicationtreatmentplan")
public class ChEmedEprCompositionMtp extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionMtp() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     * @param language      Language of the document
     */
    public ChEmedEprCompositionMtp(final UUID compositionId,
                                   final Instant date,
                                   final LanguageCode language) {
        super(compositionId, date, language);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT,
                                            "761931002",
                                            "Medication treatment plan report (record artifact)"));
        this.getType().addCoding(new Coding(FhirSystem.LOINC,
                                            "77603-9",
                                            "Medication treatment plan.extended Document"));
        this.setTitle(CompositionTitle.MTP.getDisplayName(language));
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
     * Returns whether the treatment plan section exists.
     *
     * @return {@code true} if the treatment plan section exists, {@code false} otherwise.
     */
    public boolean hasTreatmentPlanSection() {
        return getSectionByLoincCode(TREATMENT_PLAN_SECTION_CODE_VALUE) != null;
    }

    /**
     * Returns the treatment plan section; if missing, it creates it.
     *
     * @return the treatment plan section.
     */
    public SectionComponent getTreatmentPlanSection() {
        var section = getSectionByLoincCode(TREATMENT_PLAN_SECTION_CODE_VALUE);
        if (section == null) {
            section = this.addSection();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   TREATMENT_PLAN_SECTION_CODE_VALUE,
                                                   "Medication treatment plan.brief Document"));
        }
        return section;
    }

    /**
     * Returns the medication statement or throws.
     *
     * @return the medication statement.
     * @throws InvalidEmedContentException if the medication statement is missing.
     */
    @ExpectsValidResource
    public ChEmedEprMedicationStatementMtp resolveMedicationStatement() throws InvalidEmedContentException {
        final var section = this.getTreatmentPlanSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var resource = section.getEntry().get(0).getResource();
        if (resource instanceof final ChEmedEprMedicationStatementMtp medicationStatement) {
            return medicationStatement;
        }
        throw new InvalidEmedContentException("The section isn't referencing a ChEmedEprMedicationStatementMtp resource");
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
     * Adds a {@link ChEmedEprPractitionerRole} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionMtp addAuthor(final ChEmedEprPractitionerRole author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Adds a {@link ChCorePatientEpr} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionMtp addAuthor(final ChCorePatientEpr author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Adds a {@link Device} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionMtp addAuthor(final Device author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Sets the medication statement reference.
     *
     * @param medicationStatement the medication statement.
     * @return this.
     */
    public ChEmedEprCompositionMtp setMedicationStatement(final ChEmedEprMedicationStatementMtp medicationStatement) {
        final var entry = this.getTreatmentPlanSection().getEntry();
        final var reference = References.createReference(medicationStatement);
        if (entry.isEmpty()) {
            entry.add(reference);
        } else {
            entry.set(0, reference);
        }
        return this;
    }

    @Override
    public ChEmedEprCompositionMtp copy() {
        final var copy = new ChEmedEprCompositionMtp();
        this.copyValues(copy);
        return copy;
    }
}
