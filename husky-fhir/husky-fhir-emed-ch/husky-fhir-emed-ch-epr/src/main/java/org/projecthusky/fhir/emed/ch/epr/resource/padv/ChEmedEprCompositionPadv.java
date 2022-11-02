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
 * The HAPI custom structure for the CH-EMED-EPR PADV Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionPadv extends ChEmedEprComposition {

    // TODO

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionPadv() {
        super();
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "419891008", "Record artifact (record artifact)"));
        this.setTitle("TODO");
    }

    /**
     * Constructor
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date The document's creation date and time
     */
    public ChEmedEprCompositionPadv(final UUID compositionId,
                                   final Date date) {
        super(compositionId, date);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "419891008", "Record artifact (record artifact)"));
        this.setTitle("TODO");
    }

    /**
     * Returns the pharmaceutical advice section; if missing, it creates it.
     *
     * @return the pharmaceutical advice section.
     */
    public SectionComponent getPharmaceuticalAdviceSection() {
        var section = getSectionByLoincCode(PHARMACEUTICAL_ADVICE_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                    PHARMACEUTICAL_ADVICE_SECTION_CODE_VALUE,
                    "Medication pharmaceutical advice.brief"));
        }
        return section;
    }

    /**
     * Returns the medication observation or throws.
     *
     * @return the medication observation.
     * @throws InvalidEmedContentException if the medication observation is missing.
     */
    @ExpectsValidResource
    public ChEmedEprObservationPadv getMedicationObservation() throws InvalidEmedContentException {
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
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                    ANNOTATION_SECTION_CODE_VALUE, "Annotation comment"));
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
}
