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
import org.projecthusky.common.utils.datatypes.Uuids;
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
     * @param document   The clinical document.
     * @param pdfContent The PDF content.
     */
    public static void setPdfOriginalRepresentation(final ChEmedEprDocument document,
                                                    final byte[] pdfContent) {
        // Create the new Original Representation Section
        final var binary = new Binary()
                .setData(pdfContent);
        binary.setId(Uuids.URN_PREFIX + Uuids.generate());

        document.addEntry()
                .setFullUrl(binary.getId())
                .setResource(binary);

        document.resolveComposition()
                .setOriginalRepresentationPdf("Representation of the original view:", binary);
    }
}
