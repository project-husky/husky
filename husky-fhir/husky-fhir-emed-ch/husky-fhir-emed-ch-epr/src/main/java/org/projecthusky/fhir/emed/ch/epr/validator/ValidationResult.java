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

import org.hl7.fhir.r4.model.OperationOutcome;

import java.util.List;
import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public class ValidationResult {

    private final List<OperationOutcome.OperationOutcomeIssueComponent> messages;

    public ValidationResult(final List<OperationOutcome.OperationOutcomeIssueComponent> messages) {
        this.messages = Objects.requireNonNull(messages);
    }

    public boolean isSuccessful() {
        return this.getErrors().isEmpty() && this.getFatals().isEmpty();
    }
    public List<OperationOutcome.OperationOutcomeIssueComponent> getMessages() {
        return this.messages;
    }

    public List<OperationOutcome.OperationOutcomeIssueComponent> getFatals() {
        return this.messages.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.FATAL)
                .toList();
    }

    public List<OperationOutcome.OperationOutcomeIssueComponent> getErrors() {
        return this.messages.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
                .toList();
    }

    public List<OperationOutcome.OperationOutcomeIssueComponent> getWarnings() {
        return this.messages.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.WARNING)
                .toList();
    }

    public List<OperationOutcome.OperationOutcomeIssueComponent> getInformations() {
        return this.messages.stream()
                .filter(message -> message.getSeverity() == OperationOutcome.IssueSeverity.INFORMATION)
                .toList();
    }
}
