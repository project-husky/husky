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
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * A CH-EMED-EPR validator. It does not use the Schema or Schematron validators but only the Instance one, which is
 * built upon the CH-EMED-EPR IG.
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprValidator {
    private static final Logger log = LoggerFactory.getLogger(ChEmedEprValidator.class);

    /**
     * The validation support chain.
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
     * @todo Update the packages.
     */
    public ChEmedEprValidator() throws IOException, URISyntaxException {
        this.matchboxEngine = new MatchboxEngine.MatchboxEngineBuilder()
                .getEngineR4();

        // Adding all necessary packages
        log.debug("Start loading IGs");
        this.loadIg("/iheformatcodefhir.tgz");
        this.loadIg("/chfhirigcheprterm.tgz");
        this.loadIg("/chfhirigchcore.tgz");
        this.loadIg("/chfhirigchemed.tgz");
        this.loadIg("/chcarafhirepremedr4.tgz");
        log.debug("Stop loading IGs");
    }

    /**
     * Validates a CH-EMED-EPR document Bundle. Use this method if you've generated a document that you want to
     * validate.
     *
     * @param document The document Bundle to validate.
     * @return the validation result.
     */
    public ValidationResult validateDocumentBundle(final ChEmedEprDocument document)
            throws EOperationOutcome, IOException {
        final OperationOutcome outcome = this.matchboxEngine.validate(
                document,
                this.getProfileUrl(document.getEmedType())
        );
        final var result = new ValidationResult(outcome.getIssue());
        if (!result.isSuccessful()) {
            return result;
        }
        final var newMessages = this.logicValidator.validate(document);
        result.getMessages().addAll(newMessages);
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

    /**
     * Loads a FHIR IG from its NPM package (TGZ file). The path shall start with a slash and points to an existing
     * resource.
     *
     * @param resourcePath The IG file path.
     */
    protected void loadIg(final String resourcePath) throws IOException {
        this.matchboxEngine.getIgLoader().loadIg(this.matchboxEngine.getIgs(),
                                                 this.matchboxEngine.getBinaries(),
                                                 resourcePath,
                                                 true);
    }
}
