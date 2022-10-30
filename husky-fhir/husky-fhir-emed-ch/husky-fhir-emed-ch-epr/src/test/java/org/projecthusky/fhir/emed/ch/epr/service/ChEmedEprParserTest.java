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
package org.projecthusky.fhir.emed.ch.epr.service;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprCompositionMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for {@link ChEmedEprParser}.
 *
 * @author Quentin Ligier
 **/
class ChEmedEprParserTest {

    @Test
    void testParse() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/1-1-MedicationTreatmentPlan.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.MTP);
        assertInstanceOf(ChEmedEprDocumentMtp.class, document);
        final var mtpDocument = (ChEmedEprDocumentMtp) document;
        assertNotNull(mtpDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionMtp.class, mtpDocument.resolveComposition());
    }
}
