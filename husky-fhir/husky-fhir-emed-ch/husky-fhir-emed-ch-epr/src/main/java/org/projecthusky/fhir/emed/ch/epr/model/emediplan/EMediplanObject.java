package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.Objects;

/**
 * Abstraction of an eMediplan (JSON) object. Declares common methods to all eMediplan objects and provides a default
 * implementation for some of them.
 */
public interface EMediplanObject {
    /**
     * Trims the eMediplan object, that is, removes any redundant info and sets to null values that match the default
     * assumed value by the specs, to shorten the serialized result.
     */
    default void trim() {}

    /**
     * Validates the eMediplan object, without any further context than its own content, against the eMediplan specs.
     * @return The validation result containing all the encountered validation issues, if any.
     */
    default ValidationResult validate() {
        return validate(null);
    }

    /**
     * Validates the eMediplan object, without any further context than its JSON path and its own content, against the
     * eMediplan specs.
     *
     * @param basePath The JSON path of this object. If {@code null}, the object is considered to be root. Any
     *                 validation issues produced by the validation will use this path as a base for each issue's path.
     * @return The validation result containing all the encountered validation issues, if any.
     */
    ValidationResult validate(final @Nullable String basePath);

    /**
     * Convenience method to get a validation issue of severity {@link OperationOutcome.IssueSeverity#ERROR} and type
     * {@link OperationOutcome.IssueType#REQUIRED} with the specified issue path and message. This issue is to be used
     * for eMediplan mandatory fields/objects that are however missing within the object being validated.
     *
     * @param path    The path of the issue. Where the issue was encountered.
     * @param message The message describing the issue.
     * @return The produced validation issue.
     */
    default ValidationIssue getRequiredFieldValidationIssue(final String path, final String message) {
        return getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.REQUIRED,
                path,
                message
                );
    }

    /**
     * Convenience method to produce a validation issue by providing only severity, type, path and message.
     * @param severity The severity of the issue.
     * @param type     The type of issue.
     * @param path     The path of the issue. Where the issue was encountered.
     * @param message  The message describing the issue.
     * @return The produced validation issue.
     */
    default ValidationIssue getValidationIssue(final OperationOutcome.IssueSeverity severity,
                                               final OperationOutcome.IssueType type,
                                               final String path,
                                               final String message) {
        return new ValidationIssue(
                severity,
                type,
                path,
                message,
                null,
                null,
                getClass().getCanonicalName(),
                null
        );
    }

    /**
     * Convenience method to get a validation issue of severity {@link OperationOutcome.IssueSeverity#WARNING} and type
     * {@link OperationOutcome.IssueType#INVALID} with the specified issue path and message. This issue is to be
     * produced when a field is specified by the eMediplan specification not to be provided and to be ignored if
     * encountered (on the specified conditions).
     *
     * @param path    The path of the issue. Where the issue was encountered.
     * @param message The message describing the issue.
     * @return The produced validation issue.
     */
    default ValidationIssue getIgnoredFieldValidationIssue(final String path, final String message) {
        return getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.INVALID,
                path,
                message
        );
    }

    /**
     * Convenience method to get a specific field's validation path, that is, the path to be used to produce a
     * {@link ValidationIssue}.
     *
     * @param basePath The base path of the object being validated and containing the field triggering the validation
     *                 issue.
     * @param field    The name of the field triggering the validation issue.
     * @return         The path for the specified field within the specified object as to be used for a validation issue.
     */
    default String getFieldValidationPath(final @Nullable String basePath, final String field) {
        return (basePath == null || basePath.isBlank()) ? field : basePath + "." + field;
    }

    /**
     * Convenience method to get a specific field's validation path when the field is actually an element of a
     * list/array. For instance, if the element failing to pass validation is the value <i>1</i> within the JSON
     * {@code {"mylist": [1, 2]}} ; then this method can be called as {@code getFieldValidationPath(null, "mylist", 0)}
     * to get a path for this element to be used to produce a validation issue.
     *
     * @param basePath The base path of the object being validated and containing the field triggering the validation
     *                 issue.
     * @param field    The name of the field triggering the validation issue.
     * @param index    The index of the list/array element that failed to pass validation.
     * @return The resulting field validation path.
     */
    default String getFieldValidationPath(final @Nullable String basePath, final String field, final int index) {
        return getFieldValidationPath(basePath, Objects.requireNonNull(field)) + "[" + index + "]";
    }

    /**
     * Whether the eMediplan object has any extension or not.
     * @param inDepth If {@code true}, the called object, and all its children objects, are subject to the check. If
     *                {@code false}, only the called object is checked for extensions.
     * @return {@code true} if the object contains any extensions; {@code false} otherwise.
     */
    boolean hasExtensions(boolean inDepth);
}
