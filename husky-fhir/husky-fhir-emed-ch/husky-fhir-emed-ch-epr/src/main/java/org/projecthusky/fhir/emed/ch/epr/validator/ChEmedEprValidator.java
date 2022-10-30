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

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.context.support.IValidationSupport;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationOptions;
import ca.uhn.fhir.validation.ValidationResult;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.projecthusky.fhir.emed.ch.common.enums.EmedDocumentType;

import java.io.IOException;

/**
 * A CH-EMED-EPR validator. It does not use the Schema or Schematron validators but only the Instance one, which is
 * built upon the CH-EMED-EPR IG.
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprValidator {

    /**
     * The FHIR context (R4).
     */
    private final FhirContext context;

    /**
     * The validation support chain.
     */
    private final IValidationSupport validationSupport;

    /**
     * Constructor.
     *
     * @param fhirR4Context The non-null FHIR context (R4).
     * @throws IOException if the NPM packages can't be found in the classpath.
     * @todo Update the packages.
     */
    public ChEmedEprValidator(@Nullable final FhirContext fhirR4Context) throws IOException {
        if (fhirR4Context == null || fhirR4Context.getVersion().getVersion() != FhirVersionEnum.R4) {
            throw new IllegalArgumentException("ChEmedEprValidator requires a FHIR R4 context");
        }
        this.context = fhirR4Context;

        // Adding all necessary packages
        final var npmPackageSupport = new NpmPackageValidationSupport(this.context);
        npmPackageSupport.loadPackageFromClasspath("classpath:package/hl7.terminology.r4#4.0.0.tgz");
        npmPackageSupport.loadPackageFromClasspath("classpath:package/ihe.formatcode.fhir#1.0.0.tgz");
        npmPackageSupport.loadPackageFromClasspath("classpath:package/ch.fhir.ig.ch-epr-term#2.0.7.tgz");
        npmPackageSupport.loadPackageFromClasspath("classpath:package/ch.fhir.ig.ch-core#3.0.0.tgz");
        npmPackageSupport.loadPackageFromClasspath("classpath:package/ch.fhir.ig.ch-emed#3.0.0.tgz");

        // To validate SNOMED CT codes.
        // final var remoteTermSvc = new RemoteTerminologyServiceValidationSupport(context);
        // remoteTermSvc.setBaseUrl("http://tx.fhir.org/r4");

        // Thread-safety of all components?

        final var validationSupportChain = new ValidationSupportChain(
                npmPackageSupport,
                new DefaultProfileValidationSupport(this.context),
                new CommonCodeSystemsTerminologyService(this.context),
                new InMemoryTerminologyServerValidationSupport(this.context),
                new SnapshotGeneratingValidationSupport(this.context) // TODO: may not be needed, we generate the
                // snapshot view in the IG
        );
        this.validationSupport = new CachingValidationSupport(validationSupportChain); //TODO: do we need it?
    }

    /**
     * Validates a CH-EMED-EPR document Bundle from its JSON or XML representation. Use this method if you've received a
     * document that you want to validate.
     *
     * @param documentRepresentation The JSON or XML representation of the document Bundle to validate.
     * @param type                   The eMed type.
     * @return the validation result.
     */
    public ValidationResult validateDocumentBundle(final String documentRepresentation,
                                                   final EmedDocumentType type) {
        return this.createValidator().validateWithResult(documentRepresentation, this.createOptions(type));
    }

    /**
     * Validates a CH-EMED-EPR document Bundle. Use this method if you've generated a document that you want to
     * validate.
     *
     * @param documentBundle The document Bundle to validate.
     * @param type           The eMed type.
     * @return the validation result.
     */
    public ValidationResult validateDocumentBundle(final Bundle documentBundle,
                                                   final EmedDocumentType type) {
        return this.createValidator().validateWithResult(documentBundle, this.createOptions(type));
    }

    /**
     * Creates an instance of the FHIR validator to be used in a single validation, and configures it.
     *
     * @return a configured FHIR validator instance.
     * @todo Re-enable the terminology checks.
     */
    protected FhirValidator createValidator() {
        final var instanceValidator = new FhirInstanceValidator(this.validationSupport);
        instanceValidator.setCustomExtensionDomains("http://fhir.ch");
        instanceValidator.setBestPracticeWarningLevel(BestPracticeWarningLevel.Ignore);
        instanceValidator.setAnyExtensionsAllowed(false);
        instanceValidator.setErrorForUnknownProfiles(true);
        instanceValidator.setNoTerminologyChecks(true);

        final var validator = this.context.newValidator();
        validator.registerValidatorModule(instanceValidator);
        return validator;
    }

    /**
     * Creates the validator options from the eMed type.
     *
     * @param type The eMed type.
     * @return the validator options.
     * @todo Update the URLs.
     */
    protected ValidationOptions createOptions(final EmedDocumentType type) {
        final var options = new ValidationOptions();
        options.addProfile(switch (type) {
            case MTP -> "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationtreatmentplan";
            case PRE -> "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationprescription";
            case DIS -> "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationdispense";
            case PADV -> "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-pharmaceuticaladvice";
            case PML -> "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationlist";
            case PMLC -> "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-document-medicationcard";
        });
        return options;
    }
}
