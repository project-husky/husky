package org.projecthusky.fhir.emed.ch.epr.narrative.html;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.pdf.EMediplanPdfMedicationCardGenerator;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprCompositionPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;
import org.projecthusky.validation.service.pdf.PdfA12Validator;
import org.verapdf.core.ValidationException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class EMediplanPdfGeneratorTest {
    private static final SoftwareProviderMetadata softwareProviderMetadata = new SoftwareProviderMetadata(
            "Husky",
            "test",
            "Husky"
    );

    @Test
    void testGeneratePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/2-7-MedicationCard.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var documents = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, documents);
        final var pmlcDocument = (ChEmedEprDocumentPmlc) documents;
        assertNotNull(pmlcDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlcDocument.resolveComposition());

        final var pdfGenerator = new EMediplanPdfMedicationCardGenerator(() -> softwareProviderMetadata);
        final var generatedPdf = pdfGenerator.generate(pmlcDocument, NarrativeLanguage.FRENCH);
        assertNotNull(generatedPdf);

        final var pdfValidator = new PdfA12Validator();
        final var validationResult = pdfValidator.validate(generatedPdf);
        assertTrue(validationResult.isCompliant());
    }

    @Test @Disabled
    void testGenerateAndWritePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/2-7-MedicationCard.xml").readAllBytes());
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var documents = parser.parse(xml, EmedDocumentType.PMLC);
        assertInstanceOf(ChEmedEprDocumentPmlc.class, documents);
        final var pmlcDocument = (ChEmedEprDocumentPmlc) documents;
        assertNotNull(pmlcDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPmlc.class, pmlcDocument.resolveComposition());

        final var pdfGenerator = new EMediplanPdfMedicationCardGenerator(() -> softwareProviderMetadata);
        final var generatedPdf = pdfGenerator.generate(pmlcDocument, NarrativeLanguage.FRENCH);
        assertNotNull(generatedPdf);

        final var pdfValidator = new PdfA12Validator();
        final var validationResult = pdfValidator.validate(generatedPdf);
        assertTrue(validationResult.isCompliant());

        final var pdfOut = new FileOutputStream("pdfOut.pdf");
        pdfOut.write(generatedPdf);
        pdfOut.close();
    }
}
