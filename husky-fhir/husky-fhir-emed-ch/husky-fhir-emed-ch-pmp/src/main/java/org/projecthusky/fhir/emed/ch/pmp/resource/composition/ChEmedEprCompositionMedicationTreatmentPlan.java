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
package org.projecthusky.fhir.emed.ch.pmp.resource.composition;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Binary;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.pmp.resource.ChEmedEprMedicationStatementMtp;

/**
 * A HAPI custom structure for the CH-EMED-EPR MTP Composition.
 * <p>
 * It assumes {@code Configuration.status = 0}, i.e. 'auto-create' mode when accessing attributes that have not been
 * set.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionMedicationTreatmentPlan extends ChEmedEprComposition {

    /**
     * Returns whether the original representation section exists.
     *
     * @return {@code true} if the original representation section exists, {@code false} otherwise.
     */
    public boolean hasOriginalRepresentationSection() {
        return getSectionByLoincCode(ORIGINAL_REPR_SECTION_CODE_VALUE) != null;
    }

    /**
     * Returns the original representation section; if missing, it creates it.
     *
     * @return the original representation section.
     */
    public SectionComponent getOriginalRepresentationSection() {
        var section = getSectionByLoincCode(ORIGINAL_REPR_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   ORIGINAL_REPR_SECTION_CODE_VALUE, "Clinical presentation"));
        }
        return section;
    }

    /**
     * Returns the PDF content of the original representation or throws.
     *
     * @return the PDF content of the original representation.
     * @throws InvalidEmedContentException if the original representation is missing.
     */
    @ExpectsValidResource
    public byte[] getOriginalRepresentationPdf() throws InvalidEmedContentException {
        final var section = this.getOriginalRepresentationSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var resource = section.getEntry().get(0).getResource();
        if (resource instanceof final Binary binary && binary.hasData()) {
            return binary.getData();
        }
        throw new InvalidEmedContentException("The section isn't referencing a filled Binary resource");
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
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   TREATMENT_PLAN_SECTION_CODE_VALUE,
                                                   "Medication treatment plan.brief"));
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
    public ChEmedEprMedicationStatementMtp getMedicationStatement() throws InvalidEmedContentException {
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
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   ANNOTATION_SECTION_CODE_VALUE, "Annotation comment"));
        }
        return section;
    }

    /**
     * Finds a section by its LOINC code or {@code null}, without creating it.
     *
     * @return the section or {@code null}.
     */
    @Nullable
    private SectionComponent getSectionByLoincCode(final String code) {
        return this.getSection().stream()
                .filter(section -> section.getCode().hasCoding(FhirSystem.LOINC, code))
                .findAny()
                .orElse(null);
    }
}
