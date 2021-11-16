package org.husky.validation.service.schema;

import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.Objects;

/**
 * An implementation of {@link ErrorHandler} that puts the exceptions into a {@link XmlSchemaReport}.
 *
 * @author Quentin Ligier
 */
public class ErrorHandlerToReport implements ErrorHandler {

    /**
     * The report in which to put the handled exceptions.
     */
    private final XmlSchemaReport report;

    /**
     * Constructor.
     *
     * @param report The report in which to put the handled exceptions.
     */
    public ErrorHandlerToReport(final XmlSchemaReport report) {
        this.report = Objects.requireNonNull(report);
    }

    /**
     * Receive notification of a warning.
     *
     * <p>SAX parsers will use this method to report conditions that
     * are not errors or fatal errors as defined by the XML
     * recommendation.  The default behaviour is to take no
     * action.</p>
     *
     * <p>The SAX parser must continue to provide normal parsing events
     * after invoking this method: it should still be possible for the
     * application to process the document through to the end.</p>
     *
     * <p>Filters may use this method to report other, non-XML warnings
     * as well.</p>
     *
     * @param exception The warning information encapsulated in a SAX parse exception.
     * @see SAXParseException
     */
    @Override
    public void warning(final SAXParseException exception) {
        this.report.getWarnings().add(exception);
    }

    /**
     * Receive notification of a recoverable error.
     *
     * <p>This corresponds to the definition of "error" in section 1.2
     * of the W3C XML 1.0 Recommendation.  For example, a validating
     * parser would use this callback to report the violation of a
     * validity constraint.  The default behaviour is to take no
     * action.</p>
     *
     * <p>The SAX parser must continue to provide normal parsing
     * events after invoking this method: it should still be possible
     * for the application to process the document through to the end.
     * If the application cannot do so, then the parser should report
     * a fatal error even if the XML recommendation does not require
     * it to do so.</p>
     *
     * <p>Filters may use this method to report other, non-XML errors
     * as well.</p>
     *
     * @param exception The error information encapsulated in a SAX parse exception.
     * @see SAXParseException
     */
    @Override
    public void error(final SAXParseException exception) {
        this.report.getErrors().add(exception);
    }

    /**
     * Receive notification of a non-recoverable, fatal error.
     *
     * <p>
     * As defined in section 1.2 of the W3C XML 1.0 Recommendation, fatal errors
     * are those that would make it impossible for a parser to continue normal
     * processing. These include violation of a well-formedness constraint,
     * invalid encoding, and forbidden structural errors as described in the
     * W3C XML 1.0 Recommendation.
     *
     * @apiNote An application must assume that the parser can no longer perform
     * normal processing after reporting a fatal error and may stop by throwing
     * a {@link SAXException} without calling {@link ContentHandler#endDocument()}.
     * In addition, the parser cannot be expected to be able to return accurate
     * information about the logical structure on the rest of the document even
     * if it may be able to resume parsing.
     *
     * @param exception The error information encapsulated in a {@link SAXParseException}.
     */
    @Override
    public void fatalError(final SAXParseException exception) throws SAXException {
        this.report.getFatalErrors().add(exception);
        throw exception;
    }
}
