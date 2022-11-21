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
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.enums.CompositionTitle;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprEntry;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PML Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef
public class ChEmedEprCompositionPml extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     */
    public ChEmedEprCompositionPml(final UUID compositionId,
                                   final Instant date,
                                   final LanguageCode language) {
        super(compositionId, date, language);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT,
                                            "721912009",
                                            "Medication summary document (record artifact)"));
        this.setTitle(CompositionTitle.PML.getDisplayName(language));
    }

    /**
     * Resolves the authors of the document ({@link Device}).
     *
     * @return the list with the authors of the document.
     * @throws InvalidEmedContentException if no author is specified or if an author is not of type {@link Device}.
     */
    @ExpectsValidResource
    public List<Device> resolveAuthors() throws InvalidEmedContentException {
        if (!this.hasAuthor()) throw new InvalidEmedContentException("The composition requires at least one author.");

        final var authors = new ArrayList<Device>();

        for (final var reference : this.getAuthor()) {
            final var resource = reference.getResource();
            if (resource instanceof Device device) {
                authors.add(device);
            } else {
                throw new InvalidEmedContentException("An author is invalid.");
            }
        }
        return authors;
    }

    /**
     * Returns the list section; if missing, it creates it.
     *
     * @return the list section.
     */
    public SectionComponent getListSection() {
        var section = getSectionByLoincCode(LIST_SECTION_CODE_VALUE);
        if (section == null) {
            section = this.addSection();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   LIST_SECTION_CODE_VALUE,
                                                   "Medication summary"));
        }
        return section;
    }

    /**
     * Returns the list with medication statement, medication request, medication dispense and observation.
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
     * Resolves the medication statements, medication requests, medication dispenses and observations.
     *
     * @return the medication statements, medication requests, medication dispenses and observations.
     */
    @ExpectsValidResource
    public List<ChEmedEprEntry> resolveEntries() {
        return this.getListSection()
                .getEntry()
                .stream()
                .map(Reference::getResource)
                .filter(ChEmedEprEntry.class::isInstance)
                .map(ChEmedEprEntry.class::cast)
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

    /**
     * Adds a {@link Device} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionPml addAuthor(final Device author) {
        this.addAuthor(References.createReference(author));
        return this;
    }
}
