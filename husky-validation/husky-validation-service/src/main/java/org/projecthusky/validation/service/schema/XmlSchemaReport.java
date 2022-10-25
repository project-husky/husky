package org.projecthusky.validation.service.schema;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
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
     * The fatal error or {@code null}.
     */
    @Nullable
    private SAXParseException fatalError = null;

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
     * Returns the fatal error or {@code null}.
     */
    @Nullable
    public SAXParseException getFatalError() {
        return fatalError;
    }

    /**
     * Sets the fatal error.
     *
     * @param fatalError The fatal error or {@code null}.
     */
    public void setFatalError(@Nullable final SAXParseException fatalError) {
        this.fatalError = fatalError;
    }

    /**
     * Return whether the validation was successful or not.
     */
    public boolean isValid() {
        return this.errors.isEmpty() && this.fatalError == null;
    }
}
