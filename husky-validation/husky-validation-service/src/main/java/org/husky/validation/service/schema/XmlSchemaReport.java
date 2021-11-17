package org.husky.validation.service.schema;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * The report of an XML Schema validation.
 *
 * @author Quentin Ligier
 */
public class XmlSchemaReport {

    /**
     * The list of validation warnings.
     */
    private final List<@NonNull SAXParseException> warnings = new ArrayList<>();

    /**
     * The list of validation errors.
     */
    private final List<@NonNull SAXParseException> errors = new ArrayList<>();

    /**
     * The list of fatal errors.
     */
    private final List<@NonNull SAXParseException> fatalErrors = new ArrayList<>();

    /**
     * Returns the list of validation warnings.
     */
    public List<@NonNull SAXParseException> getWarnings() {
        return this.warnings;
    }

    /**
     * Returns the list of validation errors.
     */
    public List<@NonNull SAXParseException> getErrors() {
        return errors;
    }

    /**
     * Returns the list of fatal errors.
     */
    public List<@NonNull SAXParseException> getFatalErrors() {
        return fatalErrors;
    }

    /**
     * Return whether the validation was successful or not.
     */
    public boolean isValid() {
        return this.errors.isEmpty() && this.fatalErrors.isEmpty();
    }
}
