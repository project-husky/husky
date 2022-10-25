package org.projecthusky.validation.service.schematron;

import org.projecthusky.common.utils.Sources;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link SchematronValidator} class.
 *
 * @author Quentin Ligier
 */
@TestMethodOrder(MethodOrderer.Random.class)
class SchematronValidatorTest {

    /*
     * Xsl / File
     */
    @Test
    void testBooksXslFile() throws Exception {
        final var validator = new SchematronValidator(this.getSampleFile("books.xsl"));
        final var result = validator.validate(this.getSampleSource("books.xml"));
        this.validateBooksResult(result);
    }

    @Test
    void testBooksNsXslFile() throws Exception {
        final var validator = new SchematronValidator(this.getSampleFile("booksNs.xsl"));
        final var result = validator.validate(this.getSampleSource("booksNs.xml"));
        this.validateBooksNsResult(result);
    }

    @Test
    void testFlowersXslFile() throws Exception {
        final var validator = new SchematronValidator(this.getSampleFile("flowers.xsl"));
        final var result = validator.validate(this.getSampleSource("flowers.xml"));
        this.validateFlowersResult(result);
    }

    @Test
    void testTournamentXslFile() throws Exception {
        final var validator = new SchematronValidator(this.getSampleFile("tournament.xsl"));
        final var result = validator.validate(this.getSampleSource("tournament.xml"));
        this.validateTournamentResult(result);
    }

    /*
     * Xsl / Byte
     */
    @Test
    void testBooksXslByte() throws Exception {
        final var validator = new SchematronValidator(this.getSampleContent("books.xsl"));
        final var result = validator.validate(this.getSampleSource("books.xml"));
        this.validateBooksResult(result);
    }

    @Test
    void testBooksNsXslByte() throws Exception {
        final var validator = new SchematronValidator(this.getSampleContent("booksNs.xsl"));
        final var result = validator.validate(this.getSampleSource("booksNs.xml"));
        this.validateBooksNsResult(result);
    }

    @Test
    void testFlowersXslByte() throws Exception {
        final var validator = new SchematronValidator(this.getSampleContent("flowers.xsl"));
        final var result = validator.validate(this.getSampleSource("flowers.xml"));
        this.validateFlowersResult(result);
    }

    @Test
    void testTournamentXslByte() throws Exception {
        final var validator = new SchematronValidator(this.getSampleContent("tournament.xsl"));
        final var result = validator.validate(this.getSampleSource("tournament.xml"));
        this.validateTournamentResult(result);
    }

    /*
     * Sch / File
     */
    @Test
    void testBooksSchFile() throws Exception {
        final var validator = SchematronValidator.fromSchematronFile(this.getSampleFile("books.sch"));
        final var result = validator.validate(this.getSampleSource("books.xml"));
        this.validateBooksResult(result);
    }

    @Test
    void testBooksNsSchFile() throws Exception {
        final var validator = SchematronValidator.fromSchematronFile(this.getSampleFile("booksNs.sch"));
        final var result = validator.validate(this.getSampleSource("booksNs.xml"));
        this.validateBooksNsResult(result);
    }

    @Test
    void testFlowersSchFile() throws Exception {
        final var validator = SchematronValidator.fromSchematronFile(this.getSampleFile("flowers.sch"));
        final var result = validator.validate(this.getSampleSource("flowers.xml"));
        this.validateFlowersResult(result);
    }

    @Test
    void testTournamentSchFile() throws Exception {
        final var validator = SchematronValidator.fromSchematronFile(this.getSampleFile("tournament.sch"));
        final var result = validator.validate(this.getSampleSource("tournament.xml"));
        this.validateTournamentResult(result);
    }

    /*
     * Sch / Byte
     */
    @Test
    void testBooksSchByte() throws Exception {
        final var validator = SchematronValidator.fromSchematronContent(this.getSampleContent("books.sch"));
        final var result = validator.validate(this.getSampleSource("books.xml"));
        this.validateBooksResult(result);
    }

    @Test
    void testBooksNsSchByte() throws Exception {
        final var validator = SchematronValidator.fromSchematronContent(this.getSampleContent("booksNs.sch"));
        final var result = validator.validate(this.getSampleSource("booksNs.xml"));
        this.validateBooksNsResult(result);
    }

    @Test
    void testFlowersSchByte() throws Exception {
        final var validator = SchematronValidator.fromSchematronContent(this.getSampleContent("flowers.sch"));
        final var result = validator.validate(this.getSampleSource("flowers.xml"));
        this.validateFlowersResult(result);
    }

    @Test
    void testTournamentSchByte() throws Exception {
        final var validator = SchematronValidator.fromSchematronContent(this.getSampleContent("tournament.sch"));
        final var result = validator.validate(this.getSampleSource("tournament.xml"));
        this.validateTournamentResult(result);
    }

    private void validateBooksResult(final SchematronReport result) {
        assertNotNull(result);
        assertFalse(result.isValid());
        assertEquals(1, result.getFailedAsserts().size());
        assertEquals(4, result.getFiredRules().size());
        assertEquals(1, result.getActivePatterns().size());
        assertEquals(1, result.getSuccessfulReports().size());
        assertEquals("Books", result.getTitle());
        assertTrue(result.getText().isEmpty());
        assertNull(result.getPhase());
    }

    private void validateBooksNsResult(final SchematronReport result) {
        assertNotNull(result);
        assertFalse(result.isValid());
        assertEquals(1, result.getFailedAsserts().size());
        assertEquals(4, result.getFiredRules().size());
        assertEquals(1, result.getActivePatterns().size());
        assertEquals(1, result.getSuccessfulReports().size());
        assertEquals("BooksNs", result.getTitle());
        assertTrue(result.getText().isEmpty());
        assertNull(result.getPhase());
    }

    private void validateFlowersResult(final SchematronReport result) {
        assertNotNull(result);
        assertFalse(result.isValid());
        assertEquals(4, result.getFailedAsserts().size());
        assertEquals(36, result.getFiredRules().size());
        assertEquals(1, result.getActivePatterns().size());
        assertEquals(3, result.getSuccessfulReports().size());
        assertEquals("Flowers", result.getTitle());
        assertTrue(result.getText().isEmpty());
        assertNull(result.getPhase());
    }

    private void validateTournamentResult(final SchematronReport result) {
        assertNotNull(result);
        assertFalse(result.isValid());
        assertEquals(2, result.getFailedAsserts().size());
        assertEquals(6, result.getFiredRules().size());
        assertEquals(2, result.getActivePatterns().size());
        assertEquals(0, result.getSuccessfulReports().size());
        assertEquals("Schematron validation schema for the Tournament", result.getTitle());
        assertTrue(result.getText().isEmpty());
        assertNull(result.getPhase());
        assertEquals(1, result.getNsPrefixInAttributeValuesCount());
        assertEquals("t", result.getNsPrefixInAttributeValuesAtIndex(0).getPrefix());
        assertEquals("www.allette.com.au/Tournament", result.getNsPrefixInAttributeValuesAtIndex(0).getUri());
    }

    private byte[] getSampleContent(final String sampleName) throws IOException {
        return getClass().getClassLoader().getResourceAsStream("schematron/" + sampleName).readAllBytes();
    }

    private File getSampleFile(final String sampleName) throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource("schematron/" + sampleName).toURI());
    }

    private Source getSampleSource(final String sampleName) throws URISyntaxException {
        return Sources.fromInputStream(getClass().getClassLoader().getResourceAsStream("schematron/" + sampleName));
    }
}