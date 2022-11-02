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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Binary;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;

import java.util.Date;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR MTP Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionMtp extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionMtp() {
        super();
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "419891008", "Record artifact (record artifact)"));
        this.setTitle("TODO");
    }

    public ChEmedEprCompositionMtp(final UUID compositionId,
                                   final Date date) {
        super(compositionId, date);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "419891008", "Record artifact (record artifact)"));
        this.setTitle("TODO");
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
}
