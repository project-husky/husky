/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.narrative.utils;

import org.husky.common.hl7cdar2.*;
import org.husky.emed.ch.cda.generated.artdecor.CdachEntryObservationMedia;
import org.husky.emed.ch.cda.generated.artdecor.CdachSectionOriginalRepresentationCoded;
import org.husky.emed.ch.cda.narrative.enums.NarrativeLanguage;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Utilities for CDA-CH-EMED narrative texts.
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
     * Creates and inserts in a CDA-CH-EMED document a PDF representation.
     *
     * @param clinicalDocument The clinical document.
     * @param pdfContent The PDF content.
     * @param pdfLanguage The PDF language.
     * @return the Original Representation Section created and inserted in the clinical document.
     */
    public static CdachSectionOriginalRepresentationCoded setPdfOriginalRepresentation(final POCDMT000040ClinicalDocument clinicalDocument,
                                                                                       final byte[] pdfContent,
                                                                                       final NarrativeLanguage pdfLanguage) {
        // Create the new Original Representation Section
        final var id = "pdfNarrative";
        final var factory = new ObjectFactory();

        final var renderMultimedia = new StrucDocRenderMultiMedia();
        renderMultimedia.setID(id);

        final var text = new StrucDocText();
        text.getContent().add("Representation of the original view:");
        text.getContent().add(factory.createStrucDocTextRenderMultiMedia(renderMultimedia));

        final var observationMedia = new CdachEntryObservationMedia();
        observationMedia.setIDAttr(id);
        requireNonNull(observationMedia.getLanguageCode()).setCode(pdfLanguage.getIsoCode());
        requireNonNull(observationMedia.getValue()).setXmlMixed(new String(pdfContent, StandardCharsets.UTF_8));

        final var section = new CdachSectionOriginalRepresentationCoded();
        section.getEntry().get(0).setObservationMedia(observationMedia);
        section.setText(text);

        // Add or replace it in the CDA document
        final var structuredBody = Optional.ofNullable(clinicalDocument.getComponent())
                .map(POCDMT000040Component2::getStructuredBody)
                .orElseThrow();

        structuredBody.getComponent().stream()
                .filter(component -> component.getSection() != null)
                .filter(component -> component.getSection().getId() != null)
                .filter(component -> "2.16.756.5.30.1.1.10.3.45".equals(component.getSection().getId().getRoot()))
                .findAny()
                .orElseGet(() -> {
                    final var component = new POCDMT000040Component3();
                    structuredBody.getComponent().add(component);
                    return component;
                })
                .setSection(section);
        return section;
    }

    public static void setStrucDocTextSectionNarrative() {
        // Simply replace it.
        // Warn about lost references.
    }
}
