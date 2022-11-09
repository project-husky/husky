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
package org.projecthusky.fhir.emed.ch.epr.resource.dis;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DomainResource;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.CommonLanguages;
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
 * The HAPI custom structure for the CH-EMED-EPR DIS Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionDis extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionDis() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     */
    public ChEmedEprCompositionDis(final UUID compositionId,
                                   final Instant date,
                                   final LanguageCode language) {
        super(compositionId, date, language);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "419891008", "Record artifact (record artifact)"));
        this.setTitle(CompositionTitle.DIS.getDisplayName(language));
    }

    /**
     * Returns the dispense section; if missing, it creates it.
     *
     * @return the dispense section.
     */
    public SectionComponent getDispenseSection() {
        var section = getSectionByLoincCode(DISPENSE_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   DISPENSE_SECTION_CODE_VALUE,
                                                   "Medication dispensed.brief"));
        }
        return section;
    }

    /**
     * Returns the medication dispense or throws.
     *
     * @return the medication dispense.
     * @throws InvalidEmedContentException if the medication dispense is missing.
     */
    @ExpectsValidResource
    public ChEmedEprMedicationDispenseDis resolveMedicationDispense() throws InvalidEmedContentException {
        final var section = this.getDispenseSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var resource = section.getEntry().get(0).getResource();
        if (resource instanceof final ChEmedEprMedicationDispenseDis medicationDispense) {
            return medicationDispense;
        }
        throw new InvalidEmedContentException("The section isn't referencing a ChEmedEprMedicationDispenseDis resource");
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
     * Returns whether the dispense section exists.
     *
     * @return {@code true} if the dispense section exists, {@code false} otherwise.
     */
    public boolean hasDispenseSection() {
        return getSectionByLoincCode(DISPENSE_SECTION_CODE_VALUE) != null;
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
    public ChEmedEprCompositionDis addAuthor(final ChEmedEprPractitionerRole author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Adds a {@link ChCorePatientEpr} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionDis addAuthor(final ChCorePatientEpr author) {
        this.addAuthor(References.createReference(author));
        return this;
    }

    /**
     * Sets a {@link ChEmedEprMedicationDispenseDis} reference.
     *
     * @param medicationDispense the medication dispense.
     * @return this.
     */
    public ChEmedEprCompositionDis setMedicationDispense(final ChEmedEprMedicationDispenseDis medicationDispense) {
        final var entry = this.getDispenseSection().getEntry();
        final var reference = References.createReference(medicationDispense);
        if (entry.isEmpty()) {
            entry.add(reference);
        } else {
            entry.set(0, reference);
        }
        return this;
    }
}
