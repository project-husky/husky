package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan.EMediplanConverter;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * This class generates a QR Code conveying an eMediplan object, as defined in the relevant CH Transmission Format
 * specification, depending on the received {@link EMediplanConverter}.
 */
public class EMediplanQrCodeGenerator {
    private final static int DEFAULT_SIZE = 152;

    private final EMediplanConverter eMediplanConverter;
    private final Consumer<@NonNull ValidationIssue> validationIssueConsumer;

    /**
     *
     * @param eMediplanConverter The converter between CH EMED EPR documents and eMediplan objects, depending on the
     *                           relevant specification.
     * @param validationIssueConsumer A consumer for encountered eMediplan validation issues.
     */
    public EMediplanQrCodeGenerator(final EMediplanConverter eMediplanConverter,
                                    final Consumer<@NonNull ValidationIssue> validationIssueConsumer) {
        this.eMediplanConverter = Objects.requireNonNull(eMediplanConverter);
        this.validationIssueConsumer = Objects.requireNonNull(validationIssueConsumer);
    }

    /**
     * Gets the eMediplan QR code for the PRE document content.
     *
     * @param document The CH EMED EPR PMLC document for which to generate the eMediplan QR code.
     * @return The Base64-encoded PNG image render of the QR code, as a string.
     * @throws QrCodeGenerationException In case of error either transforming the PRE to an eMediplan format or while
     *                                   generating the QR code itself.
     */
    public String generateQrCode(final ChEmedEprDocumentPmlc document) throws QrCodeGenerationException {
        final var emediplan = eMediplanConverter.toEMediplan(document);
        return generateQrCode(emediplan);
    }

    /**
     * Gets the eMediplan QR code for the PRE document content.
     *
     * @param document The CH EMED EPR PRE document for which to generate the eMediplan QR code.
     * @return The Base64-encoded PNG image render of the QR code, as a string.
     * @throws QrCodeGenerationException In case of error either transforming the PRE to an eMediplan format or while
     *                                   generating the QR code itself.
     */
    public String generateQrCode(final ChEmedEprDocumentPre document) throws QrCodeGenerationException {
        return generateQrCode(document, DEFAULT_SIZE);
    }

    /**
     * Gets the eMediplan QR code for the PRE document content.
     *
     * @param document The CH EMED EPR PRE document for which to generate the eMediplan QR code.
     * @param size     The desired size (one side of the square) in pixels. This includes the mandatory white spacing.
     * @return The Base64-encoded PNG image render of the QR code, as a string.
     * @throws QrCodeGenerationException In case of error either transforming the PRE to an eMediplan format or while
     *                                   generating the QR code itself.
     */
    public String generateQrCode(final ChEmedEprDocumentPre document, int size) {
        final var emediplan = eMediplanConverter.toEMediplan(document);
        return generateQrCode(emediplan, size);
    }

    /**
     * Gets the eMediplan QR code for the PRE document content.
     *
     * @param emediplan The eMediplan model object for which to generate the eMediplan QR code.
     * @return The Base64-encoded PNG image render of the QR code, as a string, with the default size including margin.
     * @throws QrCodeGenerationException In case of error either transforming the PRE to an eMediplan format or while
     *                                   generating the QR code itself.
     */
    public String generateQrCode(final EMediplan<?,?,?,?> emediplan) throws QrCodeGenerationException {
        return generateQrCode(emediplan, DEFAULT_SIZE);
    }

    /**
     * Gets the eMediplan QR code for the PRE document content.
     *
     * @param emediplan The eMediplan model object for which to generate the eMediplan QR code.
     * @param size      The desired size (one side of the square) in pixels. This includes the mandatory white spacing.
     * @return The Base64-encoded PNG image render of the QR code, as a string.
     * @throws QrCodeGenerationException In case of error either transforming the PRE to an eMediplan format or while
     *                                   generating the QR code itself.
     */
    public String generateQrCode(final EMediplan<?,?,?,?> emediplan, final int size) throws QrCodeGenerationException {
        try {
            emediplan.trim();
            final var validationResult = emediplan.validate();
            validationResult.getIssues().stream().filter(Objects::nonNull).forEach(validationIssueConsumer);
            if (validationResult.isSuccessful()) {
                final var qrCodeWriter = new QRCodeWriter();
                final var bitMatrix = qrCodeWriter.encode(
                        emediplan.toChTransmissionFormat(),
                        BarcodeFormat.QR_CODE,
                        size,
                        size
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
}
