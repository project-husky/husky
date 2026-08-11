package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.validation.ValidationOptions;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator.LogicValidator;
import org.projecthusky.fhir.validation.HuskyFhirValidator;
import org.projecthusky.fhir.validation.impl.HuskyFhirValidatorImpl;
import org.projecthusky.fhir.validation.model.ValidationResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * A HAPI based implementation of the {@link ChEmedEprValidator}.
 */
@Slf4j
public class ChEmedEprHapiValidator extends HuskyFhirValidatorImpl implements ChEmedEprValidator {
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
        super(context, packageResourceList, txServer);

        final var def = chain.fetchStructureDefinition("http://hl7.org/fhir/StructureDefinition/SimpleQuantity");
        prepopulatedValidationSupport
                .addStructureDefinition(((StructureDefinition) def).copy().setUrl("http://hl7.org/fhir/StructureDefinition/SimpleQuantity|4.0.1"));
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
        final var huskyResult = HuskyFhirValidator.toHuskyValidationResult((OperationOutcome) result.toOperationOutcome());
        if (huskyResult.isSuccessful())
            huskyResult.add(logicValidator.validate(document));
        logValidationResult(huskyResult);
        return huskyResult;
    }
}
