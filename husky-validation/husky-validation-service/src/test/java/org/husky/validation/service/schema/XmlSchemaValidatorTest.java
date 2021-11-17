package org.husky.validation.service.schema;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link XmlSchemaValidator} class.
 *
 * @author Quentin Ligier
 */
class XmlSchemaValidatorTest {

    @Test
    void testCdListByte() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleContent("cd-list.xsd"));
        final var result = validator.validate(this.getSampleContent("cd-list.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testCdListFile() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleFile("cd-list.xsd"));
        final var result = validator.validate(this.getSampleFile("cd-list.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testRecipeByte() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleContent("recipe.xsd"));
        final var result = validator.validate(this.getSampleContent("recipe.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testRecipeFile() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleFile("recipe.xsd"));
        final var result = validator.validate(this.getSampleFile("recipe.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testCdListInvalid() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleContent("cd-list.xsd"));
        final var result = validator.validate(this.getSampleContent("cd-list-invalid.xml"));
        assertFalse(result.isValid());
        assertEquals(0, result.getWarnings().size());
        assertEquals(4, result.getErrors().size());
        assertEquals(0, result.getFatalErrors().size());
    }

    @Test
    void testRecipeInvalid() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleFile("recipe.xsd"));
        final var result = validator.validate(this.getSampleFile("recipe-invalid.xml"));
        assertFalse(result.isValid());
        assertEquals(0, result.getWarnings().size());
        assertEquals(1, result.getErrors().size());
        assertEquals(1, result.getFatalErrors().size());
    }

    void validateEmptyReport(final XmlSchemaReport result) {
        assertNotNull(result);
        assertTrue(result.isValid());
        assertEquals(0, result.getWarnings().size());
        assertEquals(0, result.getErrors().size());
        assertEquals(0, result.getFatalErrors().size());
    }

    private byte[] getSampleContent(final String sampleName) throws IOException {
        return getClass().getClassLoader().getResourceAsStream("schema/" + sampleName).readAllBytes();
    }

    private File getSampleFile(final String sampleName) throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource("schema/" + sampleName).toURI());
    }
}