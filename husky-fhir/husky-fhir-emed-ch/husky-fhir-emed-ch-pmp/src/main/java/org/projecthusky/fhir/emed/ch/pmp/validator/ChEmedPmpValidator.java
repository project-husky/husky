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
package org.projecthusky.fhir.emed.ch.pmp.validator;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.context.support.IValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.instance.model.api.IBaseBundle;

import java.io.IOException;
import java.util.Objects;

/**
 * A CH-EMED-PMP validator. It does not use the Schema or Schematron validators but only the Instance one, which is
 * built upon the CH-EMED-PMP IG.
 *
 * @author Quentin Ligier
 **/
public class ChEmedPmpValidator {

    private final FhirContext context;

    private final IValidationSupport validationSupport;

    /**
     * Constructor.
     *
     * @throws IOException if the NPM packages can't be found in the classpath.
     */
    public ChEmedPmpValidator(final FhirContext context) throws IOException {
        this.context = Objects.requireNonNull(context);

        // Adding all necessary packages
        final var npmPackageSupport = new NpmPackageValidationSupport(this.context);
        npmPackageSupport.loadPackageFromClasspath("classpath:package/UK.Core.r4-1.1.0.tgz");

        final var validationSupportChain = new ValidationSupportChain(
                npmPackageSupport,
                new DefaultProfileValidationSupport(this.context),
                new CommonCodeSystemsTerminologyService(this.context),
                new InMemoryTerminologyServerValidationSupport(this.context),
                new SnapshotGeneratingValidationSupport(this.context)
        );
        this.validationSupport = new CachingValidationSupport(validationSupportChain);
    }

    /**
     *
     *
     * @param documentBundle
     * @return
     */
    public boolean validateDocumentBundle(final IBaseBundle documentBundle) {
        final var validator = this.context.newValidator();
        final var instanceValidator = new FhirInstanceValidator(this.validationSupport);
        validator.registerValidatorModule(instanceValidator);

        final var result = validator.validateWithResult(documentBundle);
        return result.isSuccessful();
    }
}
