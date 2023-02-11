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
package org.projecthusky.fhir.emed.ch.epr.resource.pmlc;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Device;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.enums.CompositionTitle;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprComposition;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for the CH-EMED-EPR PMLC Composition.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-composition-medicationcard")
public class ChEmedEprCompositionPmlc extends ChEmedEprComposition {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprCompositionPmlc() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     */
    public ChEmedEprCompositionPmlc(final UUID compositionId,
                                    final Instant date,
                                    final LanguageCode language) {
        super(compositionId, date, language);
        this.getType().addCoding(new Coding(FhirSystem.SNOMEDCT,
                                            "721912009",
                                            "Medication summary document (record artifact)"));
        this.setTitle(CompositionTitle.PMLC.getDisplayName(language));
    }

    /**
     * Resolves the author of the document ({@link Device}).
     *
     * @return the author of the document.
     * @throws InvalidEmedContentException if no author is specified or if an author is not of type {@link Device}.
     */
    @ExpectsValidResource
    public Device resolveAuthor() throws InvalidEmedContentException {
        if (!this.hasAuthor()) throw new InvalidEmedContentException("The composition requires an author.");
        if (this.getAuthorFirstRep().getResource() instanceof final Device device) {
            return device;
        }
        throw new InvalidEmedContentException("The author is not a device.");
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
                                                   ANNOTATION_SECTION_CODE_VALUE, "Annotation comment"));
            section.setTitle("Comment");
        }
        return section;
    }

    /**
     * Returns the card section; if missing, it creates it.
     *
     * @return the card section.
     */
    public SectionComponent getCardSection() {
        var section = getSectionByLoincCode(CARD_SECTION_CODE_VALUE);
        if (section == null) {
            section = this.addSection();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   CARD_SECTION_CODE_VALUE,
                                                   "History of medication use"));
            section.setTitle("Medication List");
        }
        return section;
    }

    /**
     * Returns the original representation section; if missing, it creates it.
     *
     * @return the original representation section.
     */
    public SectionComponent getOriginalRepresentationSection() {
        var section = getSectionByLoincCode(ORIGINAL_REPR_SECTION_CODE_VALUE);
        if (section == null) {
            section = this.addSection();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   ORIGINAL_REPR_SECTION_CODE_VALUE,
                                                   "Clinical presentation"));
            section.setTitle("Original representation");
        }
        return section;
    }

    /**
     * Returns the list with medication statement or throws.
     *
     * @return the list with medication statement.
     * @throws InvalidEmedContentException if the section references an invalid resource
     */
    @ExpectsValidResource
    public List<ChEmedEprMedicationStatementPmlc> resolveMedicationStatements() throws InvalidEmedContentException {
        final var section = this.getCardSection();
        final var medicationStatementList = new ArrayList<ChEmedEprMedicationStatementPmlc>();

        for (final var entry : section.getEntry()) {
            final var resource = entry.getResource();
            if (resource instanceof final ChEmedEprMedicationStatementPmlc medicationStatementPmlc) {
                medicationStatementList.add(medicationStatementPmlc);
            } else {
                throw new InvalidEmedContentException("The section references an invalid resource");
            }
        }

        return medicationStatementList;
    }

    /**
     * Returns whether the card section exists.
     *
     * @return {@code true} if the card section exists, {@code false} otherwise.
     */
    public boolean hasCardSection() {
        return getSectionByLoincCode(CARD_SECTION_CODE_VALUE) != null;
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
     * Adds a {@link Device} to the list of document authors.
     *
     * @param author the author od the document.
     * @return this.
     */
    public ChEmedEprCompositionPmlc addAuthor(final Device author) {
        this.addAuthor(References.createReference(author));
        return this;
    }
}
