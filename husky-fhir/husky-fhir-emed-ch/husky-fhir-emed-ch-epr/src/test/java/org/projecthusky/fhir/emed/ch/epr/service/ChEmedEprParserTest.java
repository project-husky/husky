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
import ca.uhn.fhir.rest.api.EncodingEnum;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprCompositionDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprCompositionMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprCompositionPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.ChEmedEprCompositionPml;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.ChEmedEprDocumentPml;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

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
    void testParseMtp() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/1-1-MedicationTreatmentPlan.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.MTP);
        assertInstanceOf(ChEmedEprDocumentMtp.class, document);
        final var mtpDocument = (ChEmedEprDocumentMtp) document;
        assertNotNull(mtpDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionMtp.class, mtpDocument.resolveComposition());
        assertNotNull(mtpDocument.resolveComposition().resolveMedicationStatement().resolveMedication());
        assertInstanceOf(ChEmedEprMedication.class,
                         mtpDocument.resolveComposition().resolveMedicationStatement().resolveMedication());
    }

    @Test
    void testParsePre() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/2-6-MedicationPrescription.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPre.class, preDocument.resolveComposition());
    }

    @Test
    void testParseDis() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/1-2-MedicationDispense.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.DIS);
        assertInstanceOf(ChEmedEprDocumentDis.class, document);
        final var disDocument = (ChEmedEprDocumentDis) document;
        assertNotNull(disDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionDis.class, disDocument.resolveComposition());
        assertNotNull(disDocument.resolveComposition().resolveMedicationDispense().resolveMedication());
        assertInstanceOf(ChEmedEprMedicationDis.class,
                         disDocument.resolveComposition().resolveMedicationDispense().resolveMedication());
    }

    @Test
    void testParseAndSerializePadv() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/2-2-PharmaceuticalAdvice.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PADV);
        assertInstanceOf(ChEmedEprDocumentPadv.class, document);
        final var padvDocument = (ChEmedEprDocumentPadv) document;
        assertNotNull(padvDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPadv.class, padvDocument.resolveComposition());

        final var serializedDoc = parser.serializePrettyPrint(padvDocument, EncodingEnum.XML);
        final var document2 = parser.parse(serializedDoc, EmedDocumentType.PADV);
        assertInstanceOf(ChEmedEprDocumentPadv.class, document2);
        final var padvDocument2 = (ChEmedEprDocumentPadv) document2;
        assertNotNull(padvDocument2.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPadv.class, padvDocument2.resolveComposition());
    }

    @Test
    void testParsePml() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-BundleUtc6bPml.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PML);
        assertInstanceOf(ChEmedEprDocumentPml.class, document);
        final var pml = (ChEmedEprDocumentPml) document;
        assertNotNull(pml.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPml.class, pml.resolveComposition());
    }
}
