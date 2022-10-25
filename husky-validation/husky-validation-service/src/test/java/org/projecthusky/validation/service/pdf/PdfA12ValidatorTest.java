package org.projecthusky.validation.service.pdf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.TestAssertion;
import org.verapdf.pdfa.results.ValidationResult;

import java.io.InputStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link PdfA12Validator} class.
 *
 * @author Quentin Ligier
 */
class PdfA12ValidatorTest {

    private final PdfA12Validator validator = new PdfA12Validator();

    @Test
    @DisplayName("Test PDF/A-1a")
    void testPdfA1a() throws Exception {
        this.testValidPdf("pdfa1a.pdf", PDFAFlavour.PDFA_1_A);
    }

    @Test
    @DisplayName("Test PDF/A-1b")
    void testPdfA1b() throws Exception {
        this.testValidPdf("pdfa1b.pdf", PDFAFlavour.PDFA_1_B);
    }

    @Test
    @DisplayName("Test PDF/A-2a")
    void testPdfA2a() throws Exception {
        this.testValidPdf("pdfa2a.pdf", PDFAFlavour.PDFA_2_A);
    }

    @Test
    @DisplayName("Test invalid PDF/A-2a")
    void testInvalidPdfA2a() throws Exception {
        final var result = this.testInvalidPdf("pdfa2a_invalid.pdf", PDFAFlavour.PDFA_2_A);
        assertEquals(1, result.getTestAssertions().size());
        assertEquals(TestAssertion.Status.FAILED, result.getTestAssertions().get(0).getStatus());
    }

    @Test
    @DisplayName("Test PDF/A-2b")
    void testPdfA2b() throws Exception {
        this.testValidPdf("pdfa2b.pdf", PDFAFlavour.PDFA_2_B);
    }

    @Test
    @DisplayName("Test PDF/A-2u")
    void testPdfA2u() throws Exception {
        this.testValidPdf("pdfa2u.pdf", PDFAFlavour.PDFA_2_U);
    }

    @Test
    @DisplayName("Test PDF/A-3a")
    void testPdfA3a() throws Exception {
        final var result = this.testInvalidPdf("pdfa3a.pdf", PDFAFlavour.PDFA_3_A);
        assertEquals(1, result.getTotalAssertions());
        assertEquals(1, result.getTestAssertions().size());
        assertTrue(result.getTestAssertions().get(0).getMessage().contains("conform"));
        assertEquals(TestAssertion.Status.FAILED, result.getTestAssertions().get(0).getStatus());
    }

    @Test
    @DisplayName("Test PDF/A-3b")
    void testPdfA3b() throws Exception {
        final var result = this.testInvalidPdf("pdfa3b.pdf", PDFAFlavour.PDFA_3_B);
        assertEquals(1, result.getTotalAssertions());
        assertEquals(1, result.getTestAssertions().size());
        assertTrue(result.getTestAssertions().get(0).getMessage().contains("conform"));
        assertEquals(TestAssertion.Status.FAILED, result.getTestAssertions().get(0).getStatus());
    }

    @Test
    @DisplayName("Test PDF/A-3u")
    void testPdfA3u() throws Exception {
        final var result = this.testInvalidPdf("pdfa3u.pdf", PDFAFlavour.PDFA_3_U);
        assertEquals(1, result.getTotalAssertions());
        assertEquals(1, result.getTestAssertions().size());
        assertTrue(result.getTestAssertions().get(0).getMessage().contains("conform"));
        assertEquals(TestAssertion.Status.FAILED, result.getTestAssertions().get(0).getStatus());
    }

    @Test
    @DisplayName("Test password protected PDF")
    void testPasswordProtectedPdf() throws Exception {
        final var result = this.testInvalidPdf("password.pdf", PDFAFlavour.NO_FLAVOUR);
        assertEquals(1, result.getTotalAssertions());
        assertEquals(1, result.getTestAssertions().size());
        assertTrue(result.getTestAssertions().get(0).getMessage().contains("password"));
        assertEquals(TestAssertion.Status.FAILED, result.getTestAssertions().get(0).getStatus());
    }

    @Test
    @DisplayName("Test corrupted PDF")
    void testCorruptedPdf() throws Exception {
        final var result = this.testInvalidPdf("corrupted.pdf", PDFAFlavour.NO_FLAVOUR);
        assertEquals(1, result.getTotalAssertions());
        assertEquals(1, result.getTestAssertions().size());
        assertTrue(result.getTestAssertions().get(0).getMessage().contains("unparsable"));
        assertEquals(TestAssertion.Status.FAILED, result.getTestAssertions().get(0).getStatus());
    }

    private void testValidPdf(final String sampleName, final PDFAFlavour flavour) throws Exception {
        final var result = this.validator.validate(this.getSample(sampleName));
        assertNotNull(result);
        assertEquals(flavour, result.getPDFAFlavour());
        assertTrue(result.isCompliant());
    }

    private ValidationResult testInvalidPdf(final String sampleName, final PDFAFlavour flavour) throws Exception {
        final var result = this.validator.validate(this.getSample(sampleName));
        assertNotNull(result);
        assertEquals(flavour, result.getPDFAFlavour());
        assertFalse(result.isCompliant());
        return result;
    }

    private InputStream getSample(final String sampleName) {
        return Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pdf/" + sampleName));
    }
}