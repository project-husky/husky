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

import ch.ahdis.matchbox.engine.MatchboxEngine;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator.LogicValidator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

/**
 * A CH-EMED-EPR validator. It doesn't use the Schema or Schematron validators but only the Instance one, which is built
 * upon the CH-EMED-EPR IG.
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprValidator {

    /**
     * The instance validator.
     */
    private final MatchboxEngine matchboxEngine;

    /**
     * The logic validator.
     */
    private final LogicValidator logicValidator = new LogicValidator();

    /**
     * Constructor.
     *
     * @throws IOException if the NPM packages can't be found in the classpath.
     */
    public ChEmedEprValidator() throws IOException, URISyntaxException {
        final var builder = new MatchboxEngine.MatchboxEngineBuilder();
        builder.setTxServer(null);
        builder.setPackageCacheMode(FilesystemPackageCacheManager.FilesystemPackageCacheMode.TESTING);
        this.matchboxEngine = builder.getEngineR4();

        // Adding all necessary packages
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ihe.formatcode.fhir#1.1.0.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-epr-term#2.0.10.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-core#4.0.1.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-emed#4.0.1.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-emed-epr#1.0.0.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-epr-fhir#4.0.1-ballot.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ihe.iti.mhd#4.2.2.tgz"));
    }

    /**
     * Validates a CH-EMED-EPR document Bundle.
     *
     * @param documentStream The document Bundle to validate as a stream.
     * @return the validation result.
     * @implNote We need the parsed document for the logical validator and the serialized document for the instance
     * validator, because HAPI's parser messes with resource IDs.
     */
    public ValidationResult validateDocumentBundle(final InputStream documentStream,
                                                   final ChEmedEprDocument document,
                                                   final Manager.FhirFormat streamFormat)
            throws EOperationOutcome, IOException {
        // First validation pass with the instance validator (matchbox-engine)
        final OperationOutcome outcome = this.matchboxEngine.validate(
                documentStream,
                streamFormat,
                this.getProfileUrl(document.getEmedType())
        );
        final var result = new ValidationResult(outcome.getIssue().stream().map(this::mapIssue).collect(Collectors.toList()));
        if (!result.isSuccessful()) {
            return result;
        }

        // Second validation pass with the logic validator
        result.getIssues().addAll(this.logicValidator.validate(document));
        return result;
    }

    public ValidationResult validateDocumentBundle(final Bundle bundle,
                                                   final String profile
                                                   ) throws EOperationOutcome, IOException {
        // First validation pass with the instance validator (matchbox-engine)
        final OperationOutcome outcome = this.matchboxEngine.validate(bundle, profile);

        final var result = new ValidationResult(outcome.getIssue().stream().map(this::mapIssue).collect(Collectors.toList()));
        if (!result.isSuccessful()) {
            return result;
        }

        return result;
    }

    /**
     * Returns the profile URL from the eMed type.
     *
     * @param type The eMed type.
     * @return the profile URL.
     */
    protected String getProfileUrl(final EmedDocumentType type) {
        return switch (type) {
            case MTP -> "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationtreatmentplan";
            case PRE -> "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationprescription";
            case DIS -> "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationdispense";
            case PADV -> "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-pharmaceuticaladvice";
            case PML -> "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationlist";
            case PMLC -> "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-document-medicationcard";
        };
    }

    protected ValidationIssue mapIssue(final OperationOutcome.OperationOutcomeIssueComponent component) {
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
        return new ValidationIssue(
                component.getSeverity(),
                component.getCode(),
                (component.hasExpression()) ? component.getExpression().get(0).getValueNotNull() : null,
                (component.hasDetails() && component.getDetails().hasText()) ? component.getDetails().getText() : null,
                line,
                column,
                source,
                messageId
        );
    }
}
