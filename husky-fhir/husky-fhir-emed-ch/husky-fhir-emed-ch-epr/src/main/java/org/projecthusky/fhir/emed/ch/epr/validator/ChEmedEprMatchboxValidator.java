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
import ch.ahdis.matchbox.engine.MatchboxEngine.FilesystemPackageCacheMode;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator.LogicValidator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * <a href="https://github.com/ahdis/matchbox">matchbox-engine</a> Implementation of {@link ChEmedEprValidator}.
 */
public class ChEmedEprMatchboxValidator implements ChEmedEprValidator {

    /**
     * The instance validator.
     */
    private final MatchboxEngine matchboxEngine;

    /**
     * The logic validator.
     */
    private final LogicValidator logicValidator = new LogicValidator();

    /**
     * Creates an instance of an offline validator with matchbox as validation engine.
     *
     * @throws IOException if the NPM packages can't be found in the classpath.
     */
    public ChEmedEprMatchboxValidator() throws IOException, URISyntaxException {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param txServer The URL of the terminology server to be used for validation. If null, no external terminology
     *                 services will be used for the validation.
     * @throws IOException if the NPM packages can't be found in the classpath.
     */
    public ChEmedEprMatchboxValidator(final @Nullable String txServer)  throws IOException, URISyntaxException {
        final var builder = new MatchboxEngine.MatchboxEngineBuilder();
        builder.setTxServer(txServer);
        builder.setPackageCacheMode(FilesystemPackageCacheMode.TESTING);
        this.matchboxEngine = builder.getEngineR4();

        // Adding all necessary packages
        for (final var packageResource : packageResourceList)
            this.matchboxEngine.loadPackage(getClass().getResourceAsStream(packageResource));
    }

    @Override
    public ValidationResult validateDocumentBundle(final InputStream documentStream,
                                                   final ChEmedEprDocument document,
                                                   final Manager.FhirFormat streamFormat)
            throws EOperationOutcome, IOException {
        // First validation pass with the instance validator (matchbox-engine)
        final OperationOutcome outcome = this.matchboxEngine.validate(
                documentStream,
                streamFormat,
                document.getEmedType().getProfile()
        );
        final var result = ChEmedEprValidator.toHuskyValidationResult(outcome);
        if (!result.isSuccessful()) {
            return result;
        }

        // Second validation pass with the logic validator
        result.getIssues().addAll(this.logicValidator.validate(document));
        return result;
    }

    @Override
    public ValidationResult validateDocumentBundle(final Bundle bundle,
                                                   final String profile
    ) throws EOperationOutcome, IOException {
        // First validation pass with the instance validator (matchbox-engine)
        final OperationOutcome outcome = this.matchboxEngine.validate(bundle, profile);

        return ChEmedEprValidator.toHuskyValidationResult(outcome);
    }
}
