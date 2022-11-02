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
package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BaseReference;
import org.hl7.fhir.r4.model.Binary;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DomainResource;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PML Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionPml extends ChEmedEprComposition {

    // TODO

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionPml() {
        super();
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "721912009", "Medication summary document (record artifact)"));
        this.setTitle("TODO");
    }

    /**
     * Constructor
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date The document's creation date and time
     */
    public ChEmedEprCompositionPml(final UUID compositionId,
                                   final Date date) {
        super(compositionId, date);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT, "721912009", "Medication summary document (record artifact)"));
        this.setTitle("TODO");
    }

    /**
     * Returns the list section; if missing, it creates it.
     *
     * @return the list section.
     */
    public SectionComponent getListSection() {
        var section = getSectionByLoincCode(LIST_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                    LIST_SECTION_CODE_VALUE,
                    "Medication summary"));
        }
        return section;
    }

    /**
     * Returns the list with medication statement, medication request, medication dispense and observation or throws.
     *
     * @return the list with medication statement, medication request, medication dispense and observation
     */
    @ExpectsValidResource
    public List<DomainResource> getResources() {
        final var section = this.getListSection();

        return section.getEntry().stream()
                .map(BaseReference::getResource)
                .filter(DomainResource.class::isInstance)
                .map(DomainResource.class::cast)
                .toList();
    }

    /**
     * Returns whether the list section exists.
     *
     * @return {@code true} if the list section exists, {@code false} otherwise.
     */
    public boolean hasListSection() {
        return getSectionByLoincCode(LIST_SECTION_CODE_VALUE) != null;
    }
}
