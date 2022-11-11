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
package org.projecthusky.fhir.emed.ch.epr.narrative.utils;

import org.hl7.fhir.r4.model.Binary;
import org.hl7.fhir.r4.model.Composition;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;


/**
 * Utilities for FHIR CH-EMED-EPR narrative texts.
 *
 * @author Quentin Ligier
 */
public class NarrativeUtils {
    /**
     * This class is not instantiable.
     */
    private NarrativeUtils() {
    }

    /**
     * Creates and inserts in a FHIR CH-EMED document a PDF representation.
     *
     * @param document The clinical document.
     * @param pdfContent The PDF content.
     * @param pdfLanguage The PDF language.
     * @return the Original Representation Section created and inserted in the clinical document.
     */
    public static Composition.SectionComponent setPdfOriginalRepresentation(final ChEmedEprDocument document,
                                                           final byte[] pdfContent,
                                                           final NarrativeLanguage pdfLanguage) {
        // Create the new Original Representation Section
        final var id = "pdfNarrative";

        final var binary = new Binary();
        binary.setId(id);
        binary.setData(pdfContent);

        final var section = new Composition.SectionComponent();
        section.addEntry().setReference(binary.getId());
        section.setTitle("Representation of the original view:");

        // Add or replace it in the CDA document
//        final var structuredBody = Optional.ofNullable(document.getComponent())
//                .map(POCDMT000040Component2::getStructuredBody)
//                .orElseThrow();
        // TODO set original representation
//        structuredBody.getComponent().stream()
//                .filter(component -> component.getSection() != null)
//                .filter(component -> component.getSection().getId() != null)
//                .filter(component -> "2.16.756.5.30.1.1.10.3.45".equals(component.getSection().getId().getRoot()))
//                .findAny()
//                .orElseGet(() -> {
//                    final var component = new POCDMT000040Component3();
//                    structuredBody.getComponent().add(component);
//                    return component;
//                })
//                .setSection(section);
        return section;
    }
}
