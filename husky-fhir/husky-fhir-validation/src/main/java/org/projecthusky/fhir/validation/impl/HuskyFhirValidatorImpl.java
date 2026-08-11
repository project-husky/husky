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
package org.projecthusky.fhir.validation.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.common.hapi.validation.support.CommonCodeSystemsTerminologyService;
import org.hl7.fhir.common.hapi.validation.support.InMemoryTerminologyServerValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.NpmPackageValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.PrePopulatedValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.RemoteTerminologyServiceValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.SnapshotGeneratingValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.ValidationSupportChain;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.projecthusky.fhir.validation.HuskyFhirValidator;
import org.projecthusky.fhir.validation.logging.ValidationResultLogger;
import org.projecthusky.fhir.validation.model.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationOptions;

/**
 * 
 */
public class HuskyFhirValidatorImpl implements HuskyFhirValidator {

	private static final Logger log = LoggerFactory.getLogger(HuskyFhirValidatorImpl.class);

	private FhirValidator validator;

	/**
	 * Whether the validation outcome should be logged with logger when calling
	 * a validation method.
	 */
	private boolean logValidationOutcome = true;

	/**
	 * The logger to use in case validation result logger is enabled.
	 */
	private @Nullable ValidationResultLogger validationResultLogger;

	/**
	 * Creates an instance of a {@link HuskyFhirValidatorImpl}, that is, a
	 * validator that will not try to use external terminology services, and
	 * that uses HAPI's validation engine.
	 *
	 * @param context
	 *            The FHIR context to be used.
	 * @param resourcePackages
	 *            The list of resource packages to load for validation.
	 * @param txServer
	 *            The terminology server to use for validation. If null or
	 *            blank, an in-memory terminology server will be used.
	 * @throws IOException
	 *             if the NPM packages can't be found in the classpath.
	 */
	public HuskyFhirValidatorImpl(final FhirContext context, //
			List<String> resourcePackages, //
			final @Nullable String txServer) throws IOException {

		final var packageSupport = new NpmPackageValidationSupport(context);
		for (var packageResource : resourcePackages)
			packageSupport.loadPackageFromClasspath(packageResource);
		final var prepopulatedValidationSupport = new PrePopulatedValidationSupport(context);
		final var chain = new ValidationSupportChain(prepopulatedValidationSupport, packageSupport,
				new DefaultProfileValidationSupport(context),
				new SnapshotGeneratingValidationSupport(context),
				(txServer != null && !txServer.isBlank())
						? new RemoteTerminologyServiceValidationSupport(context, txServer)
						: new InMemoryTerminologyServerValidationSupport(context),
				new CommonCodeSystemsTerminologyService(context));
		final var def = chain
				.fetchStructureDefinition("http://hl7.org/fhir/StructureDefinition/SimpleQuantity");
		prepopulatedValidationSupport.addStructureDefinition(((StructureDefinition) def).copy()
				.setUrl("http://hl7.org/fhir/StructureDefinition/SimpleQuantity|4.0.1"));
		validator = context.newValidator();
		final var instanceValidator = new FhirInstanceValidator(chain);
		validator.registerValidatorModule(instanceValidator);
	}

	@Override
	public ValidationResult validateDocumentBundle(Bundle bundle, String profile)
			throws IOException {
		final var validationOptions = new ValidationOptions();
		validationOptions.addProfile(Objects.requireNonNull(profile));
		final var result = validator.validateWithResult(Objects.requireNonNull(bundle),
				validationOptions);
		// handleValidationResult(result);
		final var huskyResult = HuskyFhirValidator
				.toHuskyValidationResult((OperationOutcome) result.toOperationOutcome());
		logValidationResult(huskyResult);
		return huskyResult;
	}

	// /**
	// * Handles the HAPI FHIR validation result by having all registered
	// * post-processors handle it. The result is expected to be potentially
	// * modified by the handling. No new instance will be kept, results must be
	// * modified.
	// */
	// protected void handleValidationResult(final
	// ca.uhn.fhir.validation.ValidationResult result) {
	// for (final var interceptor : getInterceptors())
	// interceptor.handle(result);
	// }

	/**
	 * Logs the validation result if enabled in the validator config. If enabled
	 * and no explicit {@link ValidationResultLogger} has been set, a default
	 * one will be automatically set and used.
	 *
	 * @param validationResult
	 *            The validation result to be logged.
	 */
	protected void logValidationResult(final ValidationResult validationResult) {
		if (logValidationOutcome) {
			if (validationResultLogger == null)
				validationResultLogger = getDefaultValidationResultLogger();
			if (validationResultLogger != null)
				validationResultLogger.logValidationResult(validationResult);
			else
				log.error(
						"The CH EMED EPR validator is set to log results, but no logger is set. Cannot log results.");
		}
	}

	/**
	 * Gets a default validation result logger.
	 */
	public ValidationResultLogger getDefaultValidationResultLogger() {
		return new ValidationResultLogger(log);
	}

	public void setLogValidationOutcome(boolean logValidationOutcome) {
		this.logValidationOutcome = logValidationOutcome;
	}

	public void setValidationResultLogger(ValidationResultLogger validationResultLogger) {
		this.validationResultLogger = validationResultLogger;
	}

}
