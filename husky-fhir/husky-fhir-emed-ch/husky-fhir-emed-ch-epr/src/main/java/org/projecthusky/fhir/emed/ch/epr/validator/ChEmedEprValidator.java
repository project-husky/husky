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
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger log = LoggerFactory.getLogger(ChEmedEprValidator.class);

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
        this.matchboxEngine = new MatchboxEngine.MatchboxEngineBuilder().getEngineR4();

        // Adding all necessary packages
        log.debug("Start loading IGs");
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ihe.formatcode.fhir#1.1.0.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-epr-term#20230523.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-core#20230523.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.fhir.ig.ch-emed#20230523.tgz"));
        this.matchboxEngine.loadPackage(getClass().getResourceAsStream("/package/ch.cara.fhir.epr.emed#20230523.tgz"));
        log.debug("Stop loading IGs");
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

    /**
     * Returns the profile URL from the eMed type.
     *
     * @param type The eMed type.
     * @return the profile URL.
     */
    protected String getProfileUrl(final EmedDocumentType type) {
        return switch (type) {
            case MTP -> "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-medicationtreatmentplan";
            case PRE -> "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-medicationprescription";
            case DIS -> "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-medicationdispense";
            case PADV -> "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-pharmaceuticaladvice";
            case PML -> "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-medicationlist";
            case PMLC -> "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-document-medicationcard";
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
