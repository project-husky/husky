package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

public interface NumberBoundRepeatable extends EMediplanObject {
    int getValue();

    @Override
    default ValidationResult validate(final @Nullable String basePath) {
        final ValidationResult result = new ValidationResult();
        if (getValue() < 0.0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                basePath == null ? "" : basePath,
                "A repetition's value cannot be lesser than 0."
        ));
        return result;
    }
}
