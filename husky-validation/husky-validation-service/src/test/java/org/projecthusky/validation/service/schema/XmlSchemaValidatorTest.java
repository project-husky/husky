package org.projecthusky.validation.service.schema;

import org.projecthusky.common.utils.Sources;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
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
        final var result = validator.validate(this.getSampleSource("cd-list.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testCdListFile() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleFile("cd-list.xsd"));
        final var result = validator.validate(this.getSampleSource("cd-list.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testRecipeByte() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleContent("recipe.xsd"));
        final var result = validator.validate(this.getSampleSource("recipe.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testRecipeFile() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleFile("recipe.xsd"));
        final var result = validator.validate(this.getSampleSource("recipe.xml"));
        this.validateEmptyReport(result);
    }

    @Test
    void testCdListInvalid() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleContent("cd-list.xsd"));
        final var result = validator.validate(this.getSampleSource("cd-list-invalid.xml"));
        assertFalse(result.isValid());
        assertEquals(0, result.getWarnings().size());
        assertEquals(4, result.getErrors().size());
        assertNull(result.getFatalError());
    }

    @Test
    void testRecipeInvalid() throws Exception {
        final var validator = new XmlSchemaValidator(this.getSampleFile("recipe.xsd"));
        final var result = validator.validate(this.getSampleSource("recipe-invalid.xml"));
        assertFalse(result.isValid());
        assertEquals(0, result.getWarnings().size());
        assertEquals(1, result.getErrors().size());
        assertNotNull(result.getFatalError());
    }

    void validateEmptyReport(final XmlSchemaReport result) {
        assertNotNull(result);
        assertTrue(result.isValid());
        assertEquals(0, result.getWarnings().size());
        assertEquals(0, result.getErrors().size());
        assertNull(result.getFatalError());
    }

    private byte[] getSampleContent(final String sampleName) throws IOException {
        return getClass().getClassLoader().getResourceAsStream("schema/" + sampleName).readAllBytes();
    }

    private File getSampleFile(final String sampleName) throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource("schema/" + sampleName).toURI());
    }

    private Source getSampleSource(final String sampleName) {
        return Sources.fromInputStream(getClass().getClassLoader().getResourceAsStream("schema/" + sampleName));
    }
}