package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.ChEmedEprTemplateResolver;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.NarrativeFormat;
import org.projecthusky.fhir.emed.ch.epr.narrative.html.SoftwareProviderMetadataProvider;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.service.EMediplanConverter;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class EMediplanPdfMedicationCardGenerator extends PdfMedicationCardGenerator {

    public EMediplanPdfMedicationCardGenerator(final String template,
                                               final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EMEDIPLAN, template, softwareProviderMetadataProvider);
    }

    public EMediplanPdfMedicationCardGenerator(final SoftwareProviderMetadataProvider softwareProviderMetadataProvider)
            throws IOException, ParserConfigurationException {
        super(NarrativeFormat.EMEDIPLAN, softwareProviderMetadataProvider);
        /* When using the default emediplan template, we need the internal template resolver since there are fragments
           within the PDF template.
         */
        pdfConverter.getTemplateEngine().setTemplateResolver(ChEmedEprTemplateResolver.get());
    }

    public byte[] generate(final ChEmedEprDocumentPmlc pmlcDocument, final NarrativeLanguage lang) {
        final var body = this.htmlNarrativeGenerator.generate(pmlcDocument, lang);

        final var bookmarks = new HashMap<String, String>(4, 0.75f);
        bookmarks.put("Carte de médication", "#header");
        bookmarks.put("Traitements actifs", "#active-treatments");
        bookmarks.put("Traitements en réserve", "#asneeded-treatments");

        final Map<String, Object> contextVariables = Map.of(
                "subject", formatHumanName(pmlcDocument.resolvePatient().resolveName()),
                "author", "Author", // TODO implement
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
            final var qrCodeWriter = new QRCodeWriter();
            final var bitMatrix = qrCodeWriter.encode(
                    EMediplanConverter.toEMediplan(pmlcDocument).toChTransmissionFormat(),
                    BarcodeFormat.QR_CODE,
                    152,
                    152
            );

            final var bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            final var outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (WriterException | IOException e) {
            throw new QrCodeGenerationException("Error while generating the eMediplan QR code.", e);
        }
    }

    public static final class QrCodeGenerationException extends RuntimeException {
        public QrCodeGenerationException() {
        }

        public QrCodeGenerationException(String message) {
            super(message);
        }

        public QrCodeGenerationException(String message, Throwable cause) {
            super(message, cause);
        }

        public QrCodeGenerationException(Throwable cause) {
            super(cause);
        }

        public QrCodeGenerationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
