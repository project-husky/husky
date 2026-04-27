package org.projecthusky.fhir.emed.ch.epr.validator;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A CH-EMED-EPR validator. It doesn't use the Schema or Schematron validators but only the Instance one, which is built
 * upon the CH-EMED-EPR IG.
 * <p>
 *     This interface should be independent of the actual validation engine being used. Engine-specific implementations
 *     of this interface should cover their specifics.
 * </p>
 *
 * @author Quentin Ligier
 **/
public interface ChEmedEprValidator {
    List<String> packageResourceList = List.of(
            "/package/ihe.formatcode.fhir#1.4.0.tgz",
            "/package/ch.fhir.ig.ch-term#3.3.0.tgz",
            "/package/ch.fhir.ig.ch-core#6.0.0.tgz",
            "/package/ch.fhir.ig.ch-emed#6.0.0.tgz",
            "/package/ch.fhir.ig.ch-emed-epr#3.0.0.tgz",
            "/package/ch.fhir.ig.ch-epr-fhir#5.0.0.tgz",
            "/package/ihe.iti.mhd#4.2.3.tgz"
            );

    /**
     * Validates a CH-EMED-EPR document Bundle AND performs a logic validation of the content as well.
     *
     * @param documentStream The document Bundle to validate as a stream.
     * @param document       The parsed CH EMED EPR document, for the logic validator.
     * @return the validation result.
     * @implNote We need the parsed document for the logical validator and the serialized document for the instance
     * validator, because HAPI's parser messes with resource IDs.
     */
    ValidationResult validateDocumentBundle(final InputStream documentStream,
                                            final ChEmedEprDocument document) throws IOException;

    /**
     * Validates a CH-EMED-EPR document Bundle. No logic validation is performed on the content.
     *
     * @param bundle  The document Bundle to be validated.
     * @param profile The profile to match the bundle against.
     * @return the validation result.
     */
    ValidationResult validateDocumentBundle(final Bundle bundle,
                                                   final String profile
    ) throws IOException;

    /**
     * Maps an {@link OperationOutcome} issue to Husky's own model of a validation issue.
     * @param component The FHIR operation outcome issue.
     * @return The translated Husky validation issue.
     */
    static ValidationIssue mapIssue(final OperationOutcome.OperationOutcomeIssueComponent component) {
        Integer line = null, column = null;
        String source = null, messageId = null;
        for (final Extension extension : component.getExtension()) {
            switch (extension.getUrl()) {
                case ValidationIssue.OO_ISSUE_COL -> column = extension.castToInteger(extension.getValue()).getValue();
                case ValidationIssue.OO_ISSUE_LINE -> line = extension.castToInteger(extension.getValue()).getValue();
                case ValidationIssue.OO_ISSUE_SOURCE ->
                        source = extension.castToString(extension.getValue()).getValue();
                case ValidationIssue.OO_ISSUE_MESSAGE_ID ->
                        messageId = extension.castToString(extension.getValue()).getValue();
            }
        }
        String msg = null;
        if (component.hasDetails() && component.getDetails().hasText()) msg = component.getDetails().getText();
        else if (component.hasDiagnostics()) msg = component.getDiagnostics();
        return new ValidationIssue(
                component.getSeverity(),
                component.getCode(),
                (component.hasExpression()) ? component.getExpression().getFirst().getValueNotNull() : null,
                msg,
                line,
                column,
                source,
                messageId
        );
    }

    /**
     * Translates a FHIR operation outcome to a Husky validation result.
     */
    static ValidationResult toHuskyValidationResult(final OperationOutcome operationOutcome) {
        return new ValidationResult(operationOutcome.getIssue().stream().map(ChEmedEprValidator::mapIssue).collect(Collectors.toList()));
    }

    /**
     * Returns the profile URL from the eMed type.
     *
     * @deprecated Deprecated and marked for removal since Husky 3.2.2.
     *             Use {@link EmedDocumentType#getProfileEpr()} instead.
     *
     * @param type The eMed type.
     * @return the profile URL.
     */
    @Deprecated(since = "3.2.2", forRemoval = true)
    static String getProfileUrl(final EmedDocumentType type) {
        return type.getProfileEpr();
    }
}
