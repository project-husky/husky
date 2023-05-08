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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;

import java.util.Objects;

/**
 * The model of a validation issue. It is a simpler
 * {@link org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent}.
 *
 * @author Quentin Ligier
 * @see <a href="http://hl7.org/fhir/R4/operationoutcome.html">OperationOutcome</a>
 **/
public class ValidationIssue {

    public static final String OO_ISSUE_COL = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col";
    public static final String OO_ISSUE_LINE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line";
    public static final String OO_ISSUE_SOURCE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source";
    public static final String OO_ISSUE_MESSAGE_ID = "http://hl7.org/fhir/StructureDefinition/operationoutcome" +
            "-message-id";

    /**
     * The issue severity.
     *
     * @see <a href="http://hl7.org/fhir/R4/valueset-issue-severity.html">ValueSet/issue-severity</a>
     */
    private OperationOutcome.@Nullable IssueSeverity severity;

    /**
     * The issue type.
     *
     * @see <a href="http://hl7.org/fhir/R4/valueset-issue-type.html">ValueSet/issue-type</a>
     */
    private OperationOutcome.@Nullable IssueType type;

    /**
     * FHIRPath of the element related to the issue.
     */
    private @Nullable String path;

    /**
     * Additional details about the issue.
     */
    private @Nullable String message;

    /**
     * The line of the issue.
     *
     * @see <a href="https://hl7.org/fhir/extensions/StructureDefinition-operationoutcome-issue-line.html">Extension:
     * OperationOutcome Line of Issue</a>
     */
    private @Nullable Integer line;

    /**
     * The column of the issue.
     *
     * @see <a href="https://hl7.org/fhir/extensions/StructureDefinition-operationoutcome-issue-col.html">Extension:
     * OperationOutcome Column of Issue</a>
     */
    private @Nullable Integer column;

    /**
     * The source of the issue.
     *
     * @see <a href="https://hl7.org/fhir/extensions/StructureDefinition-operationoutcome-issue-source.html">Extension:
     * OperationOutcome Source of Issue</a>
     */
    private @Nullable String source;

    /**
     * The identifier of the message template.
     *
     * @see <a href="https://hl7.org/fhir/extensions/StructureDefinition-operationoutcome-message-id.html">Extension:
     * OperationOutcome Message ID</a>
     */
    private @Nullable String messageId;

    public ValidationIssue() {
    }

    public ValidationIssue(final OperationOutcome.@Nullable IssueSeverity severity,
                           final OperationOutcome.@Nullable IssueType type,
                           @Nullable final String path,
                           @Nullable final String message,
                           @Nullable final Integer line,
                           @Nullable final Integer column,
                           @Nullable final String source,
                           @Nullable final String messageId) {
        this.severity = severity;
        this.type = type;
        this.path = path;
        this.message = message;
        this.line = line;
        this.column = column;
        this.source = source;
        this.messageId = messageId;
    }

    public OperationOutcome.@Nullable IssueSeverity getSeverity() {
        return this.severity;
    }

    public void setSeverity(final OperationOutcome.@Nullable IssueSeverity severity) {
        this.severity = severity;
    }

    public OperationOutcome.@Nullable IssueType getType() {
        return this.type;
    }

    public void setType(final OperationOutcome.@Nullable IssueType type) {
        this.type = type;
    }

    public @Nullable String getPath() {
        return this.path;
    }

    public void setPath(final @Nullable String path) {
        this.path = path;
    }

    public @Nullable String getMessage() {
        return this.message;
    }

    public void setMessage(final @Nullable String message) {
        this.message = message;
    }

    public @Nullable Integer getLine() {
        return this.line;
    }

    public void setLine(final @Nullable Integer line) {
        this.line = line;
    }

    public @Nullable Integer getColumn() {
        return this.column;
    }

    public void setColumn(final @Nullable Integer column) {
        this.column = column;
    }

    public @Nullable String getSource() {
        return this.source;
    }

    public void setSource(final @Nullable String source) {
        this.source = source;
    }

    public @Nullable String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(final @Nullable String messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) return true;
        if (!(o instanceof final ValidationIssue that)) return false;
        return severity == that.severity
                && type == that.type
                && Objects.equals(path, that.path)
                && Objects.equals(message, that.message)
                && Objects.equals(line, that.line)
                && Objects.equals(column, that.column)
                && Objects.equals(source, that.source)
                && Objects.equals(messageId, that.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(severity, type, path, message, line, column, source, messageId);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        if (this.severity != null) {
            builder.append("[").append(this.severity.name()).append("] ");
        }
        if (this.type != null) {
            builder.append("[").append(this.type.name()).append("] ");
        }
        if (this.message != null) {
            builder.append(this.message).append(" ");
        }
        if (this.path != null) {
            builder.append(" in ").append(this.path).append(" ");
        }
        if (this.line != null || this.column != null) {
            builder.append(String.format("[%d:%d]", this.line, this.column)).append(" ");
        }
        if (this.source != null) {
            builder.append("from source ").append(this.source).append(" ");
        }
        if (this.messageId != null) {
            builder.append("from messageId ").append(this.messageId);
        }
        return builder.toString();
    }
}
