package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.ChEmedEprTemplateResolver;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.NarrativeFormat;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.SoftwareProviderMetadataProvider;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.ChMed16AConverter;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.ChMed23AConverter;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.EMediplanConverter;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.EPrescriptionConverter;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A medication card PDF generator following eMediplan (CHMED16A or CHMED23A) paper layouts.
 */
@Slf4j
public class EMediplanPdfMedicationCardGenerator extends PdfMedicationCardGenerator {
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
    @Setter @Getter
    protected Consumer<@NonNull ValidationIssue> validationIssueConsumer = SLF4J_VALIDATION_RESULT_CONSUMER;

    protected final EMediplanQrCodeGenerator qrCodeGenerator;

    public EMediplanPdfMedicationCardGenerator(final String template,
                                               final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EMEDIPLAN, template, softwareProviderMetadataProvider);
        qrCodeGenerator = new EMediplanQrCodeGenerator(getEmediplanConverter(), validationIssueConsumer);
    }

    /**
     * This constructor will use the umbrella {@link NarrativeFormat#EMEDIPLAN} code for the narrative.
     * <p>This has no implications for the paper layout, since it is shared for CHMED16A and CHMED23A, but it has the
     * implication of deciding which eMediplan content will be created and hence conveyed within the QR code.</p>
     */
    public EMediplanPdfMedicationCardGenerator(final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EMEDIPLAN, softwareProviderMetadataProvider);
        /* When using the default emediplan template, we need the internal template resolver since there are fragments
           within the PDF template.
         */
        pdfConverter.getTemplateEngine().setTemplateResolver(ChEmedEprTemplateResolver.get());
        qrCodeGenerator = new EMediplanQrCodeGenerator(getEmediplanConverter(), validationIssueConsumer);
    }

    /**
     * This constructor allows the caller to specify exactly which kind of eMediplan narrative format can be used,
     * either the umbrella {@link NarrativeFormat#EMEDIPLAN} format, which will use whatever it is considered as default
     * by the library for generating the QR code content, or the more specific CHMED16A or CHMED23A codes.
     * <p>Note that other codes are NOT supported.</p>
     */
    public EMediplanPdfMedicationCardGenerator(final NarrativeFormat narrativeFormat, final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(Objects.requireNonNull(narrativeFormat), Objects.requireNonNull(softwareProviderMetadataProvider));
        /* When using the default emediplan template, we need the internal template resolver since there are fragments
           within the PDF template.
         */
        if (narrativeFormat != NarrativeFormat.EMEDIPLAN && narrativeFormat != NarrativeFormat.CHMED16A && narrativeFormat != NarrativeFormat.CHMED23A)
            throw new UnsupportedOperationException("The specified narrative format is not supported by this class.");
        pdfConverter.getTemplateEngine().setTemplateResolver(ChEmedEprTemplateResolver.get());
        qrCodeGenerator = new EMediplanQrCodeGenerator(getEmediplanConverter(), validationIssueConsumer);
    }

    @Override
    public byte[] generate(final ChEmedEprDocumentPmlc pmlcDocument, final NarrativeLanguage lang) {
        final var body = this.htmlNarrativeGenerator.generate(pmlcDocument, lang);

        final var bookmarks = new HashMap<String, String>(4, 0.75f);
        bookmarks.put("Carte de médication", "#header");
        bookmarks.put("Traitements actifs", "#active-treatments");
        bookmarks.put("Traitements en réserve", "#asneeded-treatments");

        final Map<String, Object> contextVariables = Map.of(
                "subject", formatHumanName(pmlcDocument.resolvePatient().resolveName()),
                "author", getPdfAuthor(),
                "description", "Une carte de médication pour le sujet, générée à la demande",
                "title", "Carte de médication",
                "bookmarks", bookmarks,
                "resource", pmlcDocument,
                "qrcode", generateQrCode(pmlcDocument),
                "softwareMetadata", softwareProviderMetadata,
                "content", body
        );

        final var pdf = this.pdfConverter.convert(
                lang,
                contextVariables,
                template);
        validatePDF(pmlcDocument, pdf);
        return pdf;
    }

    /**
     * Gets the eMediplan QR code for the PMLC document content.
     *
     * @param pmlcDocument The PMLC document for which to generate the eMediplan QR code.
     * @return The Base64-encoded PNG image render of the QR code, as a string.
     * @throws QrCodeGenerationException In case of error either transforming the PMLC to a eMediplan format or while
     *                                   generating the QR code itself.
     */
    protected String generateQrCode(final ChEmedEprDocumentPmlc pmlcDocument) throws QrCodeGenerationException {
        try {
            final var emediplan = new ChMed23AConverter().toEMediplan(pmlcDocument);
            emediplan.trim();
            final var validationResult = emediplan.validate();
            if (validationIssueConsumer != null)
                validationResult.getIssues().stream().filter(Objects::nonNull).forEach(validationIssueConsumer);
            if (validationResult.isSuccessful()) {
                final var qrCodeWriter = new QRCodeWriter();
                final var bitMatrix = qrCodeWriter.encode(
                        emediplan.toChTransmissionFormat(),
                        BarcodeFormat.QR_CODE,
                        152,
                        152
                );
                final var bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
                final var outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", outputStream);
                return Base64.getEncoder().encodeToString(outputStream.toByteArray());
            } else {
                throw new QrCodeGenerationException("Error when validating the generated eMediplan object.");
            }
        } catch (WriterException | IOException e) {
            throw new QrCodeGenerationException("Error while generating the eMediplan QR code.", e);
        }
    }

    protected EMediplanConverter getEmediplanConverter() {
        return switch (htmlNarrativeGenerator.getNarrativeFormat()) {
            case CH_EMED_EPR -> throw new UnsupportedOperationException("This PDF generator does not support CH EMED EPR narrative format.");
            case EMEDIPLAN, CHMED23A -> new ChMed23AConverter();
            case CHMED16A -> new ChMed16AConverter();
            case EPRESCRIPTION -> new EPrescriptionConverter();
        };
    }
}
