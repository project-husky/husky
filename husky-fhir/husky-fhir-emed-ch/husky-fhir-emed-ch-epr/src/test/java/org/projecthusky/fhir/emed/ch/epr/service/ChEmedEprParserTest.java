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
import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprCompositionDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprCompositionMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.*;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.ChEmedEprCompositionPml;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.ChEmedEprDocumentPml;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link ChEmedEprParser}.
 *
 * @author Quentin Ligier
 **/
class ChEmedEprParserTest {

    @Test
    void testParseMtp() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-1-1-MedicationTreatmentPlan.xml").readAllBytes());
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
    void testParseDis() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-1-2-MedicationDispense.xml").readAllBytes());
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
    void testParsePml() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-1-MedicationList.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PML);
        assertInstanceOf(ChEmedEprDocumentPml.class, document);
        final var pml = (ChEmedEprDocumentPml) document;
        assertNotNull(pml.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPml.class, pml.resolveComposition());
    }

    @Test
    void testParseAndSerializePadv() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-2-PharmaceuticalAdvice.xml").readAllBytes());
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
    void testParseMtpSplitdose() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-3-MedicationTreatmentPlan.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.MTP);
        assertInstanceOf(ChEmedEprDocumentMtp.class, document);
        final var mtpDocument = (ChEmedEprDocumentMtp) document;
        assertNotNull(mtpDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionMtp.class, mtpDocument.resolveComposition());
        assertNotNull(mtpDocument.resolveComposition().resolveMedicationStatement().resolveMedication());
        assertInstanceOf(ChEmedEprMedication.class,
                mtpDocument.resolveComposition().resolveMedicationStatement().resolveMedication());
        assertInstanceOf(ChEmedEprDosage.class, mtpDocument.resolveComposition().resolveMedicationStatement().resolveBaseDosage());
        assertEquals(1, mtpDocument.resolveComposition().resolveMedicationStatement().resolveAdditionalDosage().size());
        assertInstanceOf(ChEmedEprDosage.class, mtpDocument.resolveComposition().resolveMedicationStatement().resolveAdditionalDosage().get(0));
    }

    @Test
    void testParseDis2() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-4-MedicationDispense.xml").readAllBytes());
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
    void testParseMtpNorvasc() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-5-MedicationTreatmentPlan.xml").readAllBytes());
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
    void testParsePreNorvasc() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-6-MedicationPrescription.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPre.class, preDocument.resolveComposition());
    }

    @Test
    void testParsePmlc() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-2-7-MedicationCard-UUIDfullUrl.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, document);
        final var pmlc = (ChEmedEprDocumentPmlc) document;
        assertNotNull(pmlc.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlc.resolveComposition());
    }

    @Test
    void testParsePadvChange() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-PharmaceuticalAdvice-ChangeDosage.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PADV);
        assertInstanceOf(ChEmedEprDocumentPadv.class, document);
        final var padvDocument = (ChEmedEprDocumentPadv) document;
        final var composition = padvDocument.resolveComposition();
        assertNotNull(composition);
        assertInstanceOf(ChEmedEprCompositionPadv.class, composition);
        final var observation = composition.resolveObservation();
        assertNotNull(observation);
        assertInstanceOf(ChEmedEprObservationPadv.class, observation);
        final var statement = observation.resolveMedicationStatementChanged();
        assertNotNull(statement);
        assertInstanceOf(ChEmedEprMedicationStatementChanged.class, statement);
    }

    @Test
    void testParseChEmedEprCaseEmptyPml() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-BundleUtc1Pml.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PML);
        assertInstanceOf(ChEmedEprDocumentPml.class, document);
        final var pml = (ChEmedEprDocumentPml) document;
        final var composition = pml.resolveComposition();
        assertNotNull(composition);
        assertInstanceOf(ChEmedEprCompositionPml.class, composition);
        assertTrue (composition.resolveEntries().isEmpty());
    }

    @Test
    void testParseChEmedEprCaseMtp() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentMtpParacetamolCARAPMP004.xml").readAllBytes());
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
    void testParseChEmedEprCasePre() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreParacetamolAxapharmCARAPMP004.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPre.class, preDocument.resolveComposition());
    }

    @Test
    void testParseChEmedEprCasePadvCancel() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPadvCancelParacetamolCARAPMP004.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PADV);
        assertInstanceOf(ChEmedEprDocumentPadv.class, document);
        final var padvDocument = (ChEmedEprDocumentPadv) document;
        final var composition = padvDocument.resolveComposition();
        assertNotNull(composition);
        assertInstanceOf(ChEmedEprCompositionPadv.class, composition);
        final var observation = composition.resolveObservation();
        assertNotNull(observation);
        assertInstanceOf(ChEmedEprObservationPadv.class, observation);
        final var statement = observation.resolveMedicationStatementChanged();
        assertNull(statement);
        final var padvEntryType = observation.resolvePadvEntryType();
        assertNotNull(padvEntryType);
        assertEquals(EmedPadvEntryType.CANCEL, padvEntryType);
    }

    @Test
    void testParseChEmedEprCaseMtp2() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentMtpParacetamolDafalganCARAPMP004.xml").readAllBytes());
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
    void testParseChEmedEprCasePre2() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreParacetamolDafalganCARAPMP004.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, document);
        final var preDocument = (ChEmedEprDocumentPre) document;
        assertNotNull(preDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPre.class, preDocument.resolveComposition());
    }

    @Test
    void testParseChEmedEprCasePmlc() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPmlcCARAPMP004DafalganEffParacetamol.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, document);
        final var pmlc = (ChEmedEprDocumentPmlc) document;
        assertNotNull(pmlc.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlc.resolveComposition());
        assertEquals(1, pmlc.resolveComposition().resolveMedicationStatements().size());
    }

    @Test
    void testParseChEmedEprCaseAlternativeFlowPadvChange() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPadvChangeParacetamolCARAPMP004.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PADV);
        assertInstanceOf(ChEmedEprDocumentPadv.class, document);
        final var padvDocument = (ChEmedEprDocumentPadv) document;
        final var composition = padvDocument.resolveComposition();
        assertNotNull(composition);
        assertInstanceOf(ChEmedEprCompositionPadv.class, composition);
        final var observation = composition.resolveObservation();
        assertNotNull(observation);
        assertInstanceOf(ChEmedEprObservationPadv.class, observation);
        final var statement = observation.resolveMedicationStatementChanged();
        assertNull(statement);
        final var request = observation.resolveMedicationRequestChanged();
        assertNotNull(request);
        assertInstanceOf(ChEmedEprMedicationRequestChanged.class, request);
    }

    @Test
    void testParseChEmedEprCaseAlternativeFlowPmlWithChangedResource() throws IOException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-BundleUtc6bPml.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var document = parser.parse(xml, EmedDocumentType.PML);
        assertInstanceOf(ChEmedEprDocumentPml.class, document);
        final var pml = (ChEmedEprDocumentPml) document;
        assertNotNull(pml.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPml.class, pml.resolveComposition());
    }
}
