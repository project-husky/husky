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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Binary;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;

import java.util.Date;
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
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "761938008", "Medical prescription record (record artifact)"));
        this.setTitle("TODO");
    }

    /**
     * Constructor
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date The document's creation date and time
     */
    public ChEmedEprCompositionPre(final UUID compositionId,
                                   final Date date) {
        super(compositionId, date);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "761938008", "Medical prescription record (record artifact)"));
        this.setTitle("TODO");
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
     * Returns the medication request or throws.
     *
     * @return the medication request.
     * @throws InvalidEmedContentException if the medication request is missing.
     */
    @ExpectsValidResource
    public ChEmedMedicationRequestPre getMedicationRequest() throws InvalidEmedContentException {
        final var section = this.getPrescriptionSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var resource = section.getEntry().get(0).getResource();
        if (resource instanceof final ChEmedMedicationRequestPre medicationRequest) {
            return medicationRequest;
        }
        throw new InvalidEmedContentException("The section isn't referencing a ChEmedMedicationRequestPre resource");
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
}
