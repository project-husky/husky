package org.projecthusky.validation.service.schema;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.w3c.dom.ls.LSResourceResolver;
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
     * @param schema           The source of the XML Schema to use.
     * @param allowDtd         Whether external DTDs and entities can be accessed or not.
     * @param allowInclude     Whether includes are resolved or not.
     * @param resourceResolver The custom resource resolver or {@code null}.
     * @throws SAXException if an error arises while parsing the XML Schema.
     */
    public XmlSchemaValidator(final Source schema,
                              final boolean allowDtd,
                              final boolean allowInclude,
                              @Nullable final LSResourceResolver resourceResolver) throws SAXException {
        final var schemaFactory = SchemaFactory.newDefaultInstance();
        if (!allowDtd) {
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        }
        if (!allowInclude) {
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        }
        if (resourceResolver != null) {
            schemaFactory.setResourceResolver(resourceResolver);
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
        this(Objects.requireNonNull(schema), false, false, null);
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
     * Validates the XML content with the XML Schema. You can use {@link org.projecthusky.common.utils.Sources} to convert
     * different objects to {@link Source}s.
     *
     * @param xml The source of the XML content to validate.
     * @return the validation report.
     * @throws IOException  if the validator is processing a {@link javax.xml.transform.sax.SAXSource} and the
     *                      underlying {@link org.xml.sax.XMLReader} throws an {@link IOException}.
     * @throws SAXException if the {@link ErrorHandler} throws a {@link SAXException} or if a fatal error is found and
     *                      the {@link ErrorHandler} returns normally.
     */
    public XmlSchemaReport validate(final Source xml) throws IOException, SAXException {
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
}
