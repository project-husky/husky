package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.ChEmedEprTemplateResolver;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.NarrativeFormat;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.SoftwareProviderMetadataProvider;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.EPrescriptionConverter;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class EPrescriptionPdfGenerator extends PdfPrescriptionGenerator {
    public static final Consumer<@NonNull ValidationIssue> SLF4J_VALIDATION_RESULT_CONSUMER = issue -> {
        if (issue.getSeverity() == null) log.error(issue.toString());
        else {
            switch (issue.getSeverity()) {
                case NULL, ERROR, FATAL -> log.error(issue.toString());
                case WARNING -> log.warn(issue.toString());
                case INFORMATION -> log.info(issue.toString());
            }
        }
    };

    /**
     * The consumer for any encountered validation issues. By default, an Slf4 logger will log all encountered issues.
     */
    @Setter
    @Getter
    protected Consumer<@NonNull ValidationIssue> validationIssueConsumer = SLF4J_VALIDATION_RESULT_CONSUMER;

    /**
     * The ePrescription QR code generator.
     */
    protected final EMediplanQrCodeGenerator qrCodeGenerator =
            new EMediplanQrCodeGenerator(new EPrescriptionConverter(), validationIssueConsumer);

    public EPrescriptionPdfGenerator(final String template,
                                     final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EPRESCRIPTION, template, softwareProviderMetadataProvider/*, FontFamily.CARLITO*/);
    }

    public EPrescriptionPdfGenerator(final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(
                NarrativeFormat.EPRESCRIPTION,
                "eprescription/eprescription_pdf.html",
                softwareProviderMetadataProvider/*,
                FontFamily.CARLITO*/
        );
        /* When using the default emediplan template, we need the internal template resolver since there are fragments
           within the PDF template.
         */
        pdfConverter.getTemplateEngine().setTemplateResolver(ChEmedEprTemplateResolver.get());
    }

    @Override
    public byte[] generate(final ChEmedEprDocumentPre preDocument, final NarrativeLanguage lang) {
        return generate(preDocument, lang, qrCodeGenerator.generateQrCode(preDocument, 265));
    }

    /**
     * Generates an ePrescription PDF document, following the ePrescription service guidelines.
     * <p><b>
     *     Note that the CH EMED EPR document is assumed to have the same identifier as the submitted ePrescription.
     * </b></p>
     * @param preDocument The CH EMED EPR document from which to generate the ePrescription PDF.
     * @param lang        In which language the document must be generated.
     * @param qrCode      The QR code to be used, as returned by HIN's ePrescription service.
     * @return The generated PDF as a byte array.
     */
    public byte[] generate(final ChEmedEprDocumentPre preDocument,
                           final NarrativeLanguage lang,
                           final String qrCode) {
        final var body = this.htmlNarrativeGenerator.generate(preDocument, lang, new AbstractMap.SimpleImmutableEntry<>("qrcode", qrCode));

        final var bookmarks = new HashMap<String, String>(4, 0.75f);
        // no bookmarks, for now

        final Map<String, Object> contextVariables = Map.of(
                "subject", formatHumanName(preDocument.resolvePatient().resolveName()),
                "author", getPdfAuthor(),
                "description", "Ordonnance électronique imprimée",
                "title", "E-ORDONNANCE",
                "bookmarks", bookmarks,
                "resource", preDocument,
                "qrcode", qrCode,
                "softwareMetadata", softwareProviderMetadata,
                "content", body
        );

        final var pdf = this.pdfConverter.convert(
                lang,
                contextVariables,
                template);
        validatePDF(preDocument, pdf);
        return pdf;
    }
}
