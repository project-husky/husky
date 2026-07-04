package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.rest.server.interceptor.validation.ValidationMessagePostProcessingInterceptor;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationOptions;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator.LogicValidator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A HAPI based implementation of the {@link ChEmedEprValidator}.
 */
@Slf4j
public class ChEmedEprHapiValidator implements ChEmedEprValidator{
    final private FhirValidator validator;
    final private LogicValidator logicValidator = new LogicValidator();

    /**
     * Whether the validation outcome should be logged with logger when calling a validation method.
     */
    @Setter
    private boolean logValidationOutcome = true;

    /**
     * The logger to use in case validation result logger is enabled.
     */
    @Setter
    private @Nullable ValidationResultLogger validationResultLogger;

    /**
     * A list of validation message post-processing interceptors. These interceptors are handled right after performing
     * the base HAPI validation but before (optionally) logging and then returning the result.
     */
    @Setter
    private List<@NonNull ValidationMessagePostProcessingInterceptor> interceptors = new ArrayList<>();

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
        final var prepopulatedValidationSupport = new PrePopulatedValidationSupport(context);
        final var chain = new ValidationSupportChain(
                prepopulatedValidationSupport,
                packageSupport,
                new DefaultProfileValidationSupport(context),
                new SnapshotGeneratingValidationSupport(context),
                (txServer != null && !txServer.isBlank())? new RemoteTerminologyServiceValidationSupport(context, txServer)
                        : new InMemoryTerminologyServerValidationSupport(context),
                new CommonCodeSystemsTerminologyService(context)
        );
        var def = chain.fetchStructureDefinition("http://hl7.org/fhir/StructureDefinition/SimpleQuantity");
        prepopulatedValidationSupport.addStructureDefinition(((StructureDefinition) def).copy().setUrl("http://hl7.org/fhir/StructureDefinition/SimpleQuantity|4.0.1"));
        def = chain.fetchStructureDefinition("http://hl7.org/fhir/StructureDefinition/Organization");
        prepopulatedValidationSupport.addStructureDefinition(((StructureDefinition) def).copy().setUrl("http://hl7.org/fhir/StructureDefinition/Organization|4.0.1"));
        validator = context.newValidator();
        final var instanceValidator = new FhirInstanceValidator(chain);
        validator.registerValidatorModule(instanceValidator);
    }

    /**
     * Gets the list of validation message post-processing interceptors to be processed after validation.
     */
    public List<@NonNull ValidationMessagePostProcessingInterceptor>  getInterceptors() {
        if (interceptors == null) interceptors = new ArrayList<>();
        return interceptors;
    }

    /**
     * Adds an interceptor to the list of validation message post-processing interceptors.
     */
    public ChEmedEprHapiValidator addValidationMessagePostProcessingInterceptor(final ValidationMessagePostProcessingInterceptor interceptor) {
        getInterceptors().add(interceptor);
        return this;
    }

    @Override
    public ValidationResult validateDocumentBundle(final InputStream documentStream,
                                                   final ChEmedEprDocument document)
            throws IOException {
        final var validationOptions = new ValidationOptions();
        validationOptions.addProfile(document.getEmedType().getProfileEpr());
        final var result =
                validator.validateWithResult(new String(documentStream.readAllBytes(), StandardCharsets.UTF_8), validationOptions);
        handleValidationResult(result);
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
        handleValidationResult(result);
        final var huskyResult =
                ChEmedEprValidator.toHuskyValidationResult((OperationOutcome) result.toOperationOutcome());
        logValidationResult(huskyResult);
        return huskyResult;
    }

    /**
     * Handles the HAPI FHIR validation result by having all registered post-processors handle it. The result is
     * expected to be potentially modified by the handling. No new instance will be kept, results must be modified.
     */
    protected void handleValidationResult(final ca.uhn.fhir.validation.ValidationResult result) {
        for (final var interceptor : getInterceptors()) interceptor.handle(result);
    }

    /**
     * Logs the validation result if enabled in the validator config. If enabled and no explicit
     * {@link ValidationResultLogger} has been set, a default one will be automatically set and used.
     *
     * @param validationResult The validation result to be logged.
     */
    protected void logValidationResult(final ValidationResult validationResult) {
        if (logValidationOutcome) {
            if (validationResultLogger == null) validationResultLogger = getDefaultValidationResultLogger();
            if (validationResultLogger != null) validationResultLogger.logValidationResult(validationResult);
            else log.error("The CH EMED EPR validator is set to log results, but no logger is set. Cannot log results.");
        }
    }

    /**
     * Gets a default validation result logger.
     */
    public ValidationResultLogger getDefaultValidationResultLogger() {
        return new ValidationResultLogger(log);
    }
}
