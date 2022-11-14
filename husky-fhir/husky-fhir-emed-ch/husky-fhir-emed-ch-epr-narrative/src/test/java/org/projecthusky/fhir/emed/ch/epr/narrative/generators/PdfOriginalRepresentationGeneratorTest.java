package org.projecthusky.fhir.emed.ch.epr.narrative.generators;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.treatment.NarrativeTreatmentDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

//        IndexDbAugmentationService indexDbAugmentationService = new IndexDbAugmentationService("jdbc:postgresql://localhost:5432/swissmeds_o", "postgres", "root");
//        for (var i : doc.getActiveTreatments()) {
//            indexDbAugmentationService.augment(i, doc.getNarrativeLanguage());
//        }

        final var templateHeader = new String(Objects.requireNonNull(PdfOriginalRepresentationGenerator.class.getResourceAsStream("/narrative/default/template.header.html")).readAllBytes(), StandardCharsets.UTF_8);

        final PdfOriginalRepresentationGenerator pdfGenerator = new PdfOriginalRepresentationGenerator();
        final var pdf = pdfGenerator.generate(doc, templateHeader, "</body></html>");

        final OutputStream pdfOut = new FileOutputStream("pdtOut.pdf");
        pdfOut.write(pdf);
        pdfOut.close();
    }
}