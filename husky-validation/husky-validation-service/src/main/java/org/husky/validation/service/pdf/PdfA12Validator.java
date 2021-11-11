package org.husky.validation.service.pdf;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.verapdf.core.EncryptedPdfException;
import org.verapdf.core.ModelParsingException;
import org.verapdf.core.ValidationException;
import org.verapdf.pdfa.Foundries;
import org.verapdf.pdfa.VeraGreenfieldFoundryProvider;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.ValidationResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Validator of PDF to conformance level A-1 and A-2.
 *
 * <p>In the CH-EPR project, CDA-CH-EMED and CH-EMED, PDFs must conform to the level A-1 or A-2.
 *
 * <p>The following PDF levels are passing:
 * <ul>
 *     <li>PDF/A-1b – PDF 1.4 – Level B (basic) conformance
 *     <li>PDF/A-1a – PDF 1.4 – Level A (accessible) conformance
 *     <li>PDF/A-2b – PDF 1.7 – Level B (basic) conformance
 *     <li>PDF/A-2a – PDF 1.7 – Level A (accessible) conformance
 *     <li>PDF/A-2u – PDF 1.7 – Level U (unicode) conformance
 * </ul>
 *
 * @author Quentin Ligier
 */
public class PdfA12Validator {

    /**
     * Constructor.
     */
    public PdfA12Validator() {
        VeraGreenfieldFoundryProvider.initialise();
    }

    /**
     * Validates that a PDF conforms to the PDF/A-1 or PDF/A-2 levels.
     *
     * @param pdf The PDF content as a {@link String}.
     * @return the validation result.
     * @throws IOException if the parser or validator cannot be closed.
     * @throws ValidationException if the validator encounters an issue.
     */
    public ValidationResult validate(@NonNull final String pdf) throws IOException, ValidationException {
        return this.validate(Objects.requireNonNull(pdf).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Validates that a PDF conforms to the PDF/A-1 or PDF/A-2 levels.
     *
     * @param pdf The PDF content as a byte array.
     * @return the validation result.
     * @throws IOException if the parser or validator cannot be closed.
     * @throws ValidationException if the validator encounters an issue.
     */
    public ValidationResult validate(final byte[] pdf) throws IOException, ValidationException {
        // No need to close a ByteArrayInputStream
        return this.validate(new ByteArrayInputStream(Objects.requireNonNull(pdf)));
    }

    /**
     * Validates that a PDF conforms to the PDF/A-1 or PDF/A-2 levels.
     *
     * @param pdf The PDF content as an {@link InputStream}.
     * @return the validation result.
     * @throws IOException if the parser or validator cannot be closed.
     * @throws ValidationException if the validator encounters an issue.
     */
    public ValidationResult validate(@NonNull final InputStream pdf) throws IOException, ValidationException {
        Objects.requireNonNull(pdf);
        final var foundry = Foundries.defaultInstance();
        try (final var parser = foundry.createParser(pdf)) {
            if (!this.validateFlavour(parser.getFlavour())) {
                return new FailedValidationResult(parser.getFlavour(), "The PDF does not conform to PDF/A-1 or " +
                        "PDF/A-2 levels");
            }
            try (final var validator = foundry.createFailFastValidator(parser.getFlavour(), 1)) {
                return validator.validate(parser);
            }
        } catch (final EncryptedPdfException e) {
            return new FailedValidationResult(PDFAFlavour.NO_FLAVOUR, "The PDF is encrypted");
        } catch (final ModelParsingException e) {
            return new FailedValidationResult(PDFAFlavour.NO_FLAVOUR, "The PDF is unparsable: " + e.getMessage());
        }
    }

    /**
     * Checks that the PDF/A flavour is supported.
     *
     * @param flavour The flavour to check.
     * @return {@code true} if the flavour is supported, {@code false} otherwise.
     */
    private boolean validateFlavour(final PDFAFlavour flavour) {
        return flavour == PDFAFlavour.PDFA_1_A
                || flavour == PDFAFlavour.PDFA_1_B
                || flavour == PDFAFlavour.PDFA_2_A
                || flavour == PDFAFlavour.PDFA_2_B
                || flavour == PDFAFlavour.PDFA_2_U;
    }
}
