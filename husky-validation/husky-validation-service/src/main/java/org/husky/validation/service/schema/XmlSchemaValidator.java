package org.husky.validation.service.schema;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * An XML Schema validator.
 *
 * <p>It's thread safe.
 *
 * @author Quentin Ligier
 */
@ThreadSafe
public class XmlSchemaValidator {

    /**
     * The parsed Schema.
     */
    private final Schema schema;

    /**
     * Constructor.
     *
     * @param schema       The source of the XML Schema to use.
     * @param allowDtd     Whether external DTDs and entities can be accessed or not.
     * @param allowInclude Whether includes are resolved or not.
     * @throws SAXException if an error arises while parsing the XML Schema.
     */
    public XmlSchemaValidator(final Source schema,
                              final boolean allowDtd,
                              final boolean allowInclude) throws SAXException {
        final var schemaFactory = SchemaFactory.newDefaultInstance();
        if (!allowDtd) {
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        }
        if (!allowInclude) {
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        }
        this.schema = schemaFactory.newSchema(Objects.requireNonNull(schema));
    }

    /**
     * Constructor.
     *
     * @param schema The source of the XML Schema to use.
     * @throws SAXException if an error arises while parsing the XML Schema.
     */
    public XmlSchemaValidator(final Source schema) throws SAXException {
        this(Objects.requireNonNull(schema), false, false);
    }

    /**
     * Constructor.
     *
     * @param schema The content of the XML Schema to use.
     * @throws SAXException if an error arises while parsing the XML Schema.
     */
    public XmlSchemaValidator(final byte[] schema) throws SAXException {
        this(new StreamSource(new ByteArrayInputStream(Objects.requireNonNull(schema))));
    }

    /**
     * Constructor.
     *
     * @param schema The XML Schema file to use.
     * @throws SAXException if an error arises while parsing the XML Schema.
     */
    public XmlSchemaValidator(final File schema) throws SAXException {
        this(new StreamSource(Objects.requireNonNull(schema)));
    }

    /**
     * Validates the XML content with the XML Schema.
     *
     * @param xml The source of the XML content to validate.
     * @return the validation report.
     * @throws IOException  if the validator is processing a {@link javax.xml.transform.sax.SAXSource} and the
     *                      underlying {@link org.xml.sax.XMLReader} throws an {@link IOException}.
     * @throws SAXException if the {@link ErrorHandler} throws a {@link SAXException} or if a fatal error is found and
     *                      the {@link ErrorHandler} returns normally.
     */
    public XmlSchemaReport validate(final StreamSource xml) throws IOException, SAXException {
        final var report = new XmlSchemaReport();
        final var validator = this.schema.newValidator();
        validator.setErrorHandler(new ErrorHandlerToReport(report));
        try {
            validator.validate(Objects.requireNonNull(xml));
        } catch (final SAXParseException exception) {
            // Ignore any SAXParseException, as they have been caught by the ErrorHandler
        }
        return report;
    }

    /**
     * Validates the XML content with the XML Schema.
     *
     * @param xml The XML file to validate.
     * @return the validation report.
     * @throws IOException  if the validator is processing a {@link javax.xml.transform.sax.SAXSource} and the
     *                      underlying {@link org.xml.sax.XMLReader} throws an {@link IOException}.
     * @throws SAXException if the {@link ErrorHandler} throws a {@link SAXException} or if a fatal error is found and
     *                      the {@link ErrorHandler} returns normally.
     */
    public XmlSchemaReport validate(final File xml) throws IOException, SAXException {
        return this.validate(new StreamSource(Objects.requireNonNull(xml)));
    }

    /**
     * Validates the XML content with the XML Schema.
     *
     * @param xml The XML content to validate.
     * @return the validation report.
     * @throws IOException  if the validator is processing a {@link javax.xml.transform.sax.SAXSource} and the
     *                      underlying {@link org.xml.sax.XMLReader} throws an {@link IOException}.
     * @throws SAXException if the {@link ErrorHandler} throws a {@link SAXException} or if a fatal error is found and
     *                      the {@link ErrorHandler} returns normally.
     */
    public XmlSchemaReport validate(final byte[] xml) throws IOException, SAXException {
        return this.validate(new StreamSource(new ByteArrayInputStream(Objects.requireNonNull(xml))));
    }
}
