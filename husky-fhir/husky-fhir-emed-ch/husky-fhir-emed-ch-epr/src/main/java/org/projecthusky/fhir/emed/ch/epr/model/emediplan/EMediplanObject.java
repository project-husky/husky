package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.Objects;

public interface EMediplanObject {
    /**
     * Trims the eMediplan object, that is, removes any redundant info and sets to null values that match the default
     * assumed value by the specs, to shorten the serialized result.
     */
    default void trim() {}

    default ValidationResult validate() {
        return validate(null);
    }

    ValidationResult validate(final @Nullable String basePath);

    default ValidationIssue getRequiredFieldValidationIssue(final String path, final String message) {
        return getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.REQUIRED,
                path,
                message
                );
    }

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

    default ValidationIssue getIgnoredFieldValidationIssue(final String path, final String message) {
        return getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.INVALID,
                path,
                message
        );
    }

    default String getFieldValidationPath(final @Nullable String basePath, final String field) {
        return (basePath == null || basePath.isBlank()) ? field : basePath + "." + field;
    }

    default String getFieldValidationPath(final @Nullable String basePath, final String field, final int index) {
        return getFieldValidationPath(basePath, Objects.requireNonNull(field)) + "[" + index + "]";
    }
}
