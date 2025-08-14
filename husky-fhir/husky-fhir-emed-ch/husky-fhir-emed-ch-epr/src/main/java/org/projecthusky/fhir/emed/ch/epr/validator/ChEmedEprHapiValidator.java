package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationOptions;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator.LogicValidator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * A HAPI based implementation of the {@link ChEmedEprValidator}.
 */
@Slf4j
public class ChEmedEprHapiValidator implements ChEmedEprValidator{
    final private FhirValidator validator;
    final private LogicValidator logicValidator = new LogicValidator();

    /**
     * Creates an instance of an <i>offline</i> {@link ChEmedEprValidator}, that is, a validator that will not try to
     * use external terminology services, and that uses HAPI's validation engine.
     *
     * @param context The FHIR context to be used.
     * @throws IOException if the NPM packages can't be found in the classpath.
     */
    public ChEmedEprHapiValidator(final FhirContext context) throws IOException {
        this(context, null);
    }

    /**
     * Creates an instance of a HAPI based {@link ChEmedEprValidator}.
     * @param context  The FHIR context to be used.
     * @param txServer The URL of the terminology server to be used. If {@code null} or blank, no external terminology
     *                 services will be used for validation.
     * @throws IOException if the NPM packages can't be found in the classpath.
     */
    public ChEmedEprHapiValidator(final FhirContext context, final @Nullable String txServer)  throws IOException {
        final var packageSupport = new NpmPackageValidationSupport(context);
        for (var packageResource : packageResourceList) packageSupport.loadPackageFromClasspath(packageResource);
        final var chain = new ValidationSupportChain(
                packageSupport,
                new DefaultProfileValidationSupport(context),
                (txServer != null && !txServer.isBlank())? new RemoteTerminologyServiceValidationSupport(context, txServer)
                        : new InMemoryTerminologyServerValidationSupport(context),
                new CommonCodeSystemsTerminologyService(context)
        );
        validator = context.newValidator();
        final var instanceValidator = new FhirInstanceValidator(chain);
        validator.registerValidatorModule(instanceValidator);
    }

    @Override
    public ValidationResult validateDocumentBundle(final InputStream documentStream,
                                                   final ChEmedEprDocument document,
                                                   final Manager.FhirFormat streamFormat)
            throws IOException {
        final var validationOptions = new ValidationOptions();
        validationOptions.addProfile(ChEmedEprValidator.getProfileUrl(document.getEmedType()));
        final var result =
                validator.validateWithResult(new String(documentStream.readAllBytes(), StandardCharsets.UTF_8), validationOptions);
        final var huskyResult = ChEmedEprValidator.toHuskyValidationResult((OperationOutcome) result.toOperationOutcome());
        if (huskyResult.isSuccessful())
            huskyResult.add(logicValidator.validate(document));
        logValidationResult(huskyResult);
        return huskyResult;
    }

    @Override
    public ValidationResult validateDocumentBundle(final Bundle bundle, final String profile) {
        final var validationOptions = new ValidationOptions();
        validationOptions.addProfile(Objects.requireNonNull(profile));
        final var result = validator.validateWithResult(Objects.requireNonNull(bundle), validationOptions);
        final var huskyResult =
                ChEmedEprValidator.toHuskyValidationResult((OperationOutcome) result.toOperationOutcome());
        logValidationResult(huskyResult);
        return huskyResult;
    }

    /**
     * Logs a validation result as info messages, to loosely imitate matchbox-engine behaviour.
     * @param validationResult The validation result to be logged.
     */
    private void logValidationResult(final ValidationResult validationResult) {
        log.info("Validation result: {}", validationResult.isSuccessful()? "successful" : "failed");
        for (final var issue : validationResult.getIssues())
            log.info(issue.toString());
    }
}
