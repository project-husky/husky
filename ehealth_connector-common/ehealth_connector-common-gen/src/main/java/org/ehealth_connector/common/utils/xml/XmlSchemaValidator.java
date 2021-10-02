package org.ehealth_connector.common.utils.xml;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.bind.ValidationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.*;
import java.net.URL;
import java.util.Objects;

/**
 * A validator of XML documents against an XML Schema Definition (XSD) file.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class XmlSchemaValidator {

    private static final Logger log = LoggerFactory.getLogger(XmlSchemaValidator.class);

    /**
     * The XML Schema that instantiates Schema {@link Validator}s.
     */
    private final Schema schema;

    /**
     * Constructor.
     * <p>
     * Instantiates the XSD Schema and configures the future validator against XXE injections and for external resources
     * resolving (the XSD Schema includes external definitions).
     *
     * @param schemaUrl The XSD Schema URL.
     * @throws SAXException if the XML Schema file is not valid.
     * @see <a href="https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html#schemafactory">XML
     * External Entity Prevention Cheat Sheet</a>
     */
    public XmlSchemaValidator(final URL schemaUrl) throws SAXException {
        Objects.requireNonNull(schemaUrl);
        this.schema = XmlFactories.newSafeSchema(schemaUrl);
    }

    /**
     * Validates an XML document against its XML Schema.
     *
     * @param documentContent The document content.
     * @throws ValidationException if the document is invalid.
     */
    public void validate(final String documentContent) throws ValidationException {
        Objects.requireNonNull(documentContent);
        this.validate(new StreamSource(new StringReader(documentContent)));
    }

    /**
     * Validates an XML document against its XML Schema.
     *
     * @param documentFile The document file.
     * @throws ValidationException   if the document is invalid.
     * @throws FileNotFoundException if the file does not exist or is not readable.
     * @throws IOException           if an I/O error occurs.
     */
    public void validate(final File documentFile) throws ValidationException, IOException {
        Objects.requireNonNull(documentFile);
        try (final var is = new FileInputStream(documentFile)) {
            this.validate(new StreamSource(is));
        }
    }

    /**
     * Validates an XML document against its XML Schema.
     *
     * @param source The document source.
     * @throws ValidationException if the document is invalid.
     */
    public void validate(final Source source) throws ValidationException {
        Objects.requireNonNull(source);
        final Validator schemaValidator = this.schema.newValidator();
        try {
            schemaValidator.validate(source);
        } catch (final SAXException | IOException exception) {
            log.debug("XmlSchemaValidator.validate(): ", exception);
            throw new ValidationException("XML Schema error", exception);
        }
    }
}
