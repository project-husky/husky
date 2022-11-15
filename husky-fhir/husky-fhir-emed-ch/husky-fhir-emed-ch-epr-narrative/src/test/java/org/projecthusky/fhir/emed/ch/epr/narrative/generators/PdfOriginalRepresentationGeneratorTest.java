package org.projecthusky.fhir.emed.ch.epr.narrative.generators;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.Binary;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.services.IndexDbAugmentationService;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentDocument;
import org.projecthusky.fhir.emed.ch.epr.narrative.utils.NarrativeUtils;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link PdfOriginalRepresentationGenerator} class.
 *
 * @author Ronaldo Loureiro
 */
class PdfOriginalRepresentationGeneratorTest {

    @Test
    void testGeneratePdf() throws Exception {
        final var xml = new String(getClass().getResourceAsStream("/2-7-MedicationCard.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var documents = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, documents);
        final var pmlcDocument = (ChEmedEprDocumentPmlc) documents;
        assertNotNull(pmlcDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlcDocument.resolveComposition());

        final var doc = NarrativeTreatmentDocument.builder(NarrativeLanguage.FRENCH)
                .emedDocumentDigest(pmlcDocument, EmedDocumentType.PMLC)
                .build();

//        final var indexDbAugmentationService = new IndexDbAugmentationService("jdbc:postgresql://localhost:5432/pharmINDEX", "postgres", "root");
//        for (var i : doc.getActiveTreatments()) {
//            indexDbAugmentationService.augment(i, doc.getNarrativeLanguage());
//        }

        final var templateHeader = new String(Objects.requireNonNull(PdfOriginalRepresentationGenerator.class.getResourceAsStream("/narrative/default/template.header.html")).readAllBytes(), StandardCharsets.UTF_8);

        final var pdfGenerator = new PdfOriginalRepresentationGenerator();
        final var pdf = pdfGenerator.generate(doc, templateHeader, "</body></html>");

        NarrativeUtils.setPdfOriginalRepresentation(pmlcDocument, pdf);
        assertArrayEquals(pdf, pmlcDocument.resolveComposition().getOriginalRepresentationPdf());

        final var pdfOut = new FileOutputStream("pdtOut.pdf");
        pdfOut.write(pdf);
        pdfOut.close();
    }
}