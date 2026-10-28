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
package org.projecthusky.fhir.validation;

import java.io.IOException;
import java.util.stream.Collectors;

import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.validation.model.ValidationIssue;
import org.projecthusky.fhir.validation.model.ValidationResult;
import org.slf4j.Logger;

public interface HuskyFhirValidator {

	/**
	 * Validates a document Bundle. No logic validation is performed on the
	 * content.
	 *
	 * @param bundle
	 *            The document Bundle to be validated.
	 * @param profile
	 *            The profile to match the bundle against.
	 * @return the validation result.
	 */
	ValidationResult validateDocumentBundle(final Bundle bundle, final String profile)
			throws IOException;
	
	ValidationResult validateResource(final IBaseResource resource, final String profile) throws IOException;

	/**
	 * Gets the class logger.
	 */
	Logger getLog();

	/**
	 * Maps an {@link OperationOutcome} issue to Husky's own model of a
	 * validation issue.
	 * 
	 * @param component
	 *            The FHIR operation outcome issue.
	 * @return The translated Husky validation issue.
	 */
	static ValidationIssue mapIssue(
			final OperationOutcome.OperationOutcomeIssueComponent component) {
		Integer line = null, column = null;
		String source = null, messageId = null;
		for (final Extension extension : component.getExtension()) {
			switch (extension.getUrl()) {
			case ValidationIssue.OO_ISSUE_COL -> column = extension
					.castToInteger(extension.getValue()).getValue();
			case ValidationIssue.OO_ISSUE_LINE -> line = extension
					.castToInteger(extension.getValue()).getValue();
			case ValidationIssue.OO_ISSUE_SOURCE -> source = extension
					.castToString(extension.getValue()).getValue();
			case ValidationIssue.OO_ISSUE_MESSAGE_ID -> messageId = extension
					.castToString(extension.getValue()).getValue();
			}
		}
		String msg = null;
		if (component.hasDetails() && component.getDetails().hasText())
			msg = component.getDetails().getText();
		else if (component.hasDiagnostics())
			msg = component.getDiagnostics();
		return new ValidationIssue(component.getSeverity(), component.getCode(),
				(component.hasExpression()) ? component.getExpression().getFirst().getValueNotNull()
						: null,
				msg, line, column, source, messageId);
	}

	/**
	 * Translates a FHIR operation outcome to a Husky validation result.
	 */
	static ValidationResult toHuskyValidationResult(final OperationOutcome operationOutcome) {
		return new ValidationResult(operationOutcome.getIssue().stream()
				.map(HuskyFhirValidator::mapIssue).collect(Collectors.toList()));
	}

}
