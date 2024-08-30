package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

public interface EMediplanObject {
    /**
     * Trims the eMediplan object, that is, removes any redundant info and sets to null values that match the default
     * assumed value by the specs, to shorten the serialized result.
     */
    default void trim() {}

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
}
