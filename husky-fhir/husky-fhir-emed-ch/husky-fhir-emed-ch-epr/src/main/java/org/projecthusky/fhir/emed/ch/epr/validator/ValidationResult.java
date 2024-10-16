/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.emed.ch.epr.validator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.r4.model.OperationOutcome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The model that contains the result of a FHIR resource validation. It contains a list of issues of different
 * severity.
 *
 * @author Quentin Ligier
 **/
public class ValidationResult {

    private final List<@NonNull ValidationIssue> issues;

    public ValidationResult() {
        this.issues = new ArrayList<>();
    }

    public ValidationResult(final List<@NonNull ValidationIssue> issues) {
        this.issues = Objects.requireNonNull(issues);
    }

    public boolean isSuccessful() {
        return this.getErrors().isEmpty() && this.getFatals().isEmpty();
    }

    public List<@NonNull ValidationIssue> getIssues() {
        return this.issues;
    }

    public List<@NonNull ValidationIssue> getFatals() {
        return this.issues.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.FATAL)
                .toList();
    }

    public List<@NonNull ValidationIssue> getErrors() {
        return this.issues.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
                .toList();
    }

    public List<@NonNull ValidationIssue> getWarnings() {
        return this.issues.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.WARNING)
                .toList();
    }

    public List<@NonNull ValidationIssue> getInformations() {
        return this.issues.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.INFORMATION)
                .toList();
    }

    public static ValidationResult concat(final ValidationResult... results) {
        return new ValidationResult(Arrays.stream(results).flatMap(result -> result.getIssues().stream()).toList());
    }

    public ValidationResult add(final ValidationResult... results) {
        for (final var result : results) issues.addAll(result.getIssues());
        return this;
    }

    public ValidationResult add(final ValidationIssue... issues) {
        this.issues.addAll(Arrays.asList(issues));
        return this;
    }

    public ValidationResult add(final List<@NonNull ValidationIssue> issues) {
        this.issues.addAll(issues);
        return this;
    }
}
