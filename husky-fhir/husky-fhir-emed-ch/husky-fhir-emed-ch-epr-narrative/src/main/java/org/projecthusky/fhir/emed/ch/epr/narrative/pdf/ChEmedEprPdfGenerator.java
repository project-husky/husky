package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.svgsupport.BatikSVGDrawer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.HumanName;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.*;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.validation.service.pdf.PdfA12Validator;
import org.verapdf.core.ValidationException;
import org.verapdf.pdfa.results.TestAssertion;
import org.verapdf.pdfa.results.ValidationResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

@Slf4j
public abstract class ChEmedEprPdfGenerator {
    @Getter
    public enum FontFamily {
        /**
         * Use <a href="https://fonts.google.com/specimen/Arimo">Arimo</a>, metrically equivalent to Arial. (default)
         */
        ARIMO("arimo", "Arimo-Regular.ttf", "Arimo-Bold.ttf", "Arimo-Italic.ttf", null),
        /**
         * Use <a href="https://fonts.google.com/specimen/Carlito">, metrically equivalent to Calibri.</a>
         */
        CARLITO("carlito", "Carlito-Regular.ttf", "Carlito-Bold.ttf", "Carlito-Italic.ttf", "Carlito-BoldItalic.ttf");

        private final String familyName, regularTtf, boldTtf, italicTtf;
        private final @Nullable String italicBoldTtf;

        FontFamily(final String familyName, final String regularTtf, final String boldTtf, final String italicTtf, final @Nullable String italicBoldTtf) {
            this.familyName = familyName;
            this.regularTtf = regularTtf;
            this.boldTtf = boldTtf;
            this.italicTtf = italicTtf;
            this.italicBoldTtf = italicBoldTtf;
        }

        public boolean hasRegularTtf() {
            return true;
        }

        public boolean hasBoldTtf() {
            return true;
        }

        public boolean hasItalicTtf() {
            return true;
        }

        public boolean hasItalicBoldTtf() {
            return italicBoldTtf != null;
        }
    }

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

    public ChEmedEprPdfGenerator(final NarrativeFormat narrativeFormat,
                                      final String template,
                                      final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException {
        this(narrativeFormat, template, softwareProviderMetadataProvider, FontFamily.ARIMO);
    }

    public ChEmedEprPdfGenerator(final NarrativeFormat narrativeFormat,
                                 final String template,
                                 final SoftwareProviderMetadataProvider softwareProviderMetadataProvider,
                                 final FontFamily fontFamily
                                 )
            throws IOException {
        Objects.requireNonNull(narrativeFormat);
        Objects.requireNonNull(template);
        Objects.requireNonNull(softwareProviderMetadataProvider);
        Objects.requireNonNull(fontFamily);

        this.pdfConverter = new OpenHtmlToPdfAConverter();

        this.softwareProviderMetadata = softwareProviderMetadataProvider.getSoftwareProviderMetadata();

        this.pdfConverter.setProducerName(
                softwareProviderMetadata.hasSoftwareName()?
                        softwareProviderMetadata.softwareName() : HuskySoftwareMetadataProvider.HUSKY_DEFAULT_SOFTWARE_NAME
        );

        // The library will close the supplied InputStreams
        this.addFontFamily(fontFamily);
        this.pdfConverter.setPdfRendererBuilderConsumer(builder -> builder.useSVGDrawer(new BatikSVGDrawer()));
        this.htmlNarrativeGenerator = new HtmlNarrativeGenerator(narrativeFormat);
        this.template = Objects.requireNonNull(template);
    }

    protected void addFontFamily(final FontFamily fontFamily) {
        if(fontFamily.hasRegularTtf()) {
            this.pdfConverter.addFont(
                    fontFamily.getFamilyName(),
                    400,
                    BaseRendererBuilder.FontStyle.NORMAL,
                    () -> getResourceAsStream(fontFamily.getRegularTtf())
            );
        }

        if(fontFamily.hasBoldTtf()) {
            this.pdfConverter.addFont(
                    fontFamily.getFamilyName(),
                    700,
                    BaseRendererBuilder.FontStyle.NORMAL,
                    () -> getResourceAsStream(fontFamily.getBoldTtf())
            );
        }

        if (fontFamily.hasItalicTtf()) {
            this.pdfConverter.addFont(
                    fontFamily.getFamilyName(),
                    400,
                    BaseRendererBuilder.FontStyle.ITALIC,
                    () -> getResourceAsStream(fontFamily.getItalicTtf())
            );
        }

        if (fontFamily.hasItalicBoldTtf()) {
            this.pdfConverter.addFont(
                    fontFamily.getFamilyName(),
                    700,
                    BaseRendererBuilder.FontStyle.ITALIC,
                    () -> getResourceAsStream(fontFamily.getItalicBoldTtf())
            );
        }
    }

    /**
     * Validates the generated document using a different PDF/A-1 PDF/A-2 validator (not from husky).
     * If the document does not pass validation, an exception is thrown.
     *
     * @param document The document for which the PDF has been generated.
     * @param pdf          The byte array of the generated PDF.
     * @throws PdfValidationException If the generated PDF failed to pass PDF/A-1 or A-2 validation.
     */
    protected void validatePDF(final ChEmedEprDocument document, final byte[] pdf) throws PdfValidationException {
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
                log.error("The PDF generated for document {} is not conformant to the PDF/A-1 or PDF/A-2 levels.", document.resolveIdentifier());
            }

            throw new PdfValidationException("The generated PDF is not conformant to the PDF/A-1 or PDF/A-2 levels.");
        }
    }

    protected String getPdfAuthor() {
        if (softwareProviderMetadata != null) {
            final var author = new StringBuilder();

            if (softwareProviderMetadata.hasSoftwareName())
                author.append(softwareProviderMetadata.softwareName()).append(" ");
            if (softwareProviderMetadata.hasSoftwareProvider())
                author.append("by ").append(softwareProviderMetadata.softwareProvider()).append(" ");
            if (softwareProviderMetadata.hasSoftwareVersion())
                author.append("(").append(softwareProviderMetadata.softwareVersion()).append(")");

            return author.toString();
        }
        return "";
    }

    static InputStream getResourceAsStream(String resource) throws FileNotFoundException {
        InputStream is = PdfMedicationCardGenerator.class.getClassLoader().getResourceAsStream("narrative/default/font/" + resource);
        if (is == null) {
            throw new FileNotFoundException("The resource '" + resource + "' is not found");
        } else {
            return is;
        }
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
