package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r4.model.HumanName;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.*;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.validation.service.pdf.PdfA12Validator;
import org.verapdf.core.ValidationException;
import org.verapdf.pdfa.results.TestAssertion;
import org.verapdf.pdfa.results.ValidationResult;
import com.openhtmltopdf.svgsupport.BatikSVGDrawer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

@Slf4j
public abstract class PdfMedicationCardGenerator {
    protected static final String FONT_FAMILY = "arimo";

    /**
     * The generator HTML narrative.
     */
    protected final HtmlNarrativeGenerator htmlNarrativeGenerator;

    /**
     * The converter of HTML to PDF/A.
     */
    protected final OpenHtmlToPdfAConverter pdfConverter;

    /**
     * The custom template content.
     */
    protected final String template;

    /**
     * The validator of PDF documents to conformance level A-1 and A-2.
     */
    protected final PdfA12Validator pdfValidator = new PdfA12Validator();

    protected final SoftwareProviderMetadata softwareProviderMetadata;

    public PdfMedicationCardGenerator(final NarrativeFormat narrativeFormat,
                                      final String template,
                                      final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        Objects.requireNonNull(narrativeFormat);
        Objects.requireNonNull(template);
        Objects.requireNonNull(softwareProviderMetadataProvider);

        this.pdfConverter = new OpenHtmlToPdfAConverter();

        this.softwareProviderMetadata = softwareProviderMetadataProvider.getSoftwareProviderMetadata();

        this.pdfConverter.setProducerName(
                softwareProviderMetadata.hasSoftwareName()?
                softwareProviderMetadata.softwareName() : HuskySoftwareMetadataProvider.HUSKY_DEFAULT_SOFTWARE_NAME
        );

        // The library will close the supplied InputStreams
        this.pdfConverter.addFont(
                FONT_FAMILY,
                400,
                BaseRendererBuilder.FontStyle.NORMAL,
                () -> getResourceAsStream("Arimo-Regular.ttf")
        );
        this.pdfConverter.addFont(
                FONT_FAMILY,
                700,
                BaseRendererBuilder.FontStyle.NORMAL,
                () -> getResourceAsStream("Arimo-Bold.ttf")
        );
        this.pdfConverter.addFont(
                FONT_FAMILY,
                400,
                BaseRendererBuilder.FontStyle.ITALIC,
                () -> getResourceAsStream("Arimo-Italic.ttf")
        );
        this.pdfConverter.setPdfRendererBuilderConsumer(builder -> builder.useSVGDrawer(new BatikSVGDrawer()));
        this.htmlNarrativeGenerator = new HtmlNarrativeGenerator(narrativeFormat);
        this.template = Objects.requireNonNull(template);
    }

    public PdfMedicationCardGenerator(final NarrativeFormat narrativeFormat,
                                      final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        this(narrativeFormat,
             narrativeFormat == NarrativeFormat.CH_EMED_EPR ?
             getDefaultChEmedEprPdfTemplate() : getDefaultEmediplanPdfTemplate(), softwareProviderMetadataProvider
        );
    }

    public abstract byte[] generate(final ChEmedEprDocumentPmlc pmlcDocument,
                                    final NarrativeLanguage lang) throws Exception ;

    /**
     * Validates the generated document using a different PDF/A-1 PDF/A-2 validator (not from husky).
     * If the document does not pass validation, an exception is thrown.
     *
     * @param pmlcDocument The document for which the PDF has been generated.
     * @param pdf          The byte array of the generated PDF.
     * @throws PdfValidationException If the generated PDF failed to pass PDF/A-1 or A-2 validation.
     */
    protected void validatePDF(final ChEmedEprDocumentPmlc pmlcDocument, final byte[] pdf) throws PdfValidationException {
        final ValidationResult result;
        try {
            result = this.pdfValidator.validate(pdf);
        } catch (final IOException exception) {
            throw new PdfValidationException("Unable to parse the generated PDF for validation.", exception);
        } catch (final ValidationException exception) {
            throw new PdfValidationException("The generated PDF validation failed unexpectedly.", exception);
        }

        if (!result.isCompliant()) {
            boolean hasFailedAssertion = false;
            for (final TestAssertion assertion : result.getTestAssertions()) {
                if (assertion.getStatus() != TestAssertion.Status.FAILED) {
                    continue;
                }
                hasFailedAssertion = true;
                log.error("Error when validating generated PDF: {} {}", assertion.getErrorMessage(), assertion.getMessage());
            }

            if (!hasFailedAssertion) {
                log.error("The PDF generated for document {} is not conformant to the PDF/A-1 or PDF/A-2 levels.", pmlcDocument.resolveIdentifier());
            }

            throw new PdfValidationException("The generated PDF is not conformant to the PDF/A-1 or PDF/A-2 levels.");
        }
    }


    static InputStream getResourceAsStream(String resource) throws FileNotFoundException {
        InputStream is = PdfMedicationCardGenerator.class.getResourceAsStream("/emed/pdf/fonts/" + resource);
        if (is == null) {
            throw new FileNotFoundException("The resource '" + resource + "' is not found");
        } else {
            return is;
        }
    }

    public static String getDefaultChEmedEprPdfTemplate() throws IOException {
        return getTemplate("/narrative/templates/pdfa_pmlc.html");
    }

    public static String getDefaultEmediplanPdfTemplate() throws IOException {
        return getTemplate("/narrative/templates/emediplan/emediplan_pdf.html");
    }

    static String getTemplate(final String resource) throws IOException {
        try (final var is = PdfMedicationCardGenerator.class.getResourceAsStream(resource)) {
            return new String(Objects.requireNonNull(is).readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    /**
     * Formats a human name.
     */
    protected static String formatHumanName(final HumanName name) {
        final var parts = new ArrayList<String>(2);
        name.getGiven().forEach(given -> parts.add(given.getValue()));
        parts.add(name.getFamily());
        return String.join(" ", parts);
    }
}
