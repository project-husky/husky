package org.projecthusky.fhir.emed.ch.epr.narrative.html;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.pdf.EPrescriptionPdfGenerator;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;
import org.projecthusky.validation.service.pdf.PdfA12Validator;
import org.verapdf.core.ValidationException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EPrescriptionPdfGeneratorTest {
    private static final SoftwareProviderMetadata softwareProviderMetadata = new SoftwareProviderMetadata(
            "Husky",
            "test",
            "Husky"
    );

    /**
     * Generates the ePrescription PDF for the received PRE content as a String and validates it.
     * @param content The content of the CH EMED EPR file.
     * @return The generated PDF as a byte array.
     */
    private byte[] generateAndTestPdf(final String content) throws IOException, ParserConfigurationException, ValidationException {
        final var parser = new ChEmedEprParser(FhirContext.forR4Cached());
        final var documents = parser.parse(content, EmedDocumentType.PRE);
        assertInstanceOf(ChEmedEprDocumentPre.class, documents);
        final var preDocument = (ChEmedEprDocumentPre) documents;
        assertNotNull(preDocument.resolveComposition());
        assertInstanceOf(ChEmedEprCompositionPre.class, preDocument.resolveComposition());

        final var pdfGenerator = new EPrescriptionPdfGenerator(() -> softwareProviderMetadata);
        final var generatedPdf = pdfGenerator.generate(preDocument, NarrativeLanguage.FRENCH);
        assertNotNull(generatedPdf);

        final var pdfValidator = new PdfA12Validator();
        final var validationResult = pdfValidator.validate(generatedPdf);
        assertTrue(validationResult.isCompliant());

        return generatedPdf;
    }

    @Test
    void testGeneratePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreParacetamolAxapharmCARAPMP004.xml").readAllBytes());
        generateAndTestPdf(xml);
    }

    @Test @Disabled
    void testGenerateAndWritePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreParacetamolAxapharmCaraPMP004.xml").readAllBytes());
        final var generatedPdf = generateAndTestPdf(xml);

        final var pdfOut = new FileOutputStream("pdfOut.pdf");
        pdfOut.write(generatedPdf);
        pdfOut.close();
    }

    @Test
    void testMultiplePrescriptionGeneratePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentUCSF7CARAPMP004PREDafalgan.json").readAllBytes());
        generateAndTestPdf(xml);
    }

    @Test @Disabled
    void testMultiplePrescriptionGenerateAndWritePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentUCSF7CARAPMP004PREDafalgan.json").readAllBytes());
        final var generatedPdf = generateAndTestPdf(xml);

        final var pdfOut = new FileOutputStream("pdfOut.pdf");
        pdfOut.write(generatedPdf);
        pdfOut.close();
    }

    @Test
    void testFreeTextDosageGeneratePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreCARAPMP004MarcoumarFreeTextDosage.json").readAllBytes());
        generateAndTestPdf(xml);
    }

    @Test @Disabled
    void testFreeTestDosageGenerateAndWritePdf() throws IOException, ParserConfigurationException, ValidationException {
        final var xml = new String(getClass().getResourceAsStream("/Bundle-DocumentPreCARAPMP004MarcoumarFreeTextDosage.json").readAllBytes());
        final var generatedPdf = generateAndTestPdf(xml);

        final var pdfOut = new FileOutputStream("pdfOut.pdf");
        pdfOut.write(generatedPdf);
        pdfOut.close();
    }

}
