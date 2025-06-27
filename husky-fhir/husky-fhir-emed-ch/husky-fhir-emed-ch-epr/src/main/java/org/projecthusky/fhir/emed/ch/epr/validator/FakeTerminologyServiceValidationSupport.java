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
import ca.uhn.fhir.context.support.ConceptValidationOptions;
import ca.uhn.fhir.context.support.IValidationSupport;
import ca.uhn.fhir.context.support.ValidationSupportContext;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.common.hapi.validation.support.BaseValidationSupport;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.projecthusky.fhir.core.ch.util.FhirSystem;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of {@link IValidationSupport} that fakes validation of codes. It only do so for
 * 'external' code systems like SNOMED CT and LOINC, which HAPI always tries to validate.
 * <p>
 * It's useful when value sets are checked at IG compilation time.
 *
 * @author Quentin Ligier
 **/
@ThreadSafe
public class FakeTerminologyServiceValidationSupport extends BaseValidationSupport implements IValidationSupport {

    /**
     * The list of supported systems.
     */
    private final List<String> supportedCodeSystems = new ArrayList<>(2);

    /**
     * Constructor
     *
     * @param theFhirContext The FHIR context.
     */
    public FakeTerminologyServiceValidationSupport(final FhirContext theFhirContext) {
        super(theFhirContext);
        this.supportedCodeSystems.add(FhirSystem.SNOMEDCT);
        this.supportedCodeSystems.add(FhirSystem.LOINC);
    }

    /**
     * Gets the list of supported code systems.
     *
     * @return a live list.
     */
    public List<String> getSupportedCodeSystems() {
        return this.supportedCodeSystems;
    }

    /**
     * Validates that the given code exists and if possible returns a display name. This method is called to check codes
     * which are found in "example" binding fields (e.g. <code>Observation.code</code> in the default profile.
     *
     * @param theValidationSupportContext The validation support module will be passed in to this method. This is
     *                                    convenient in cases where the operation needs to make calls to other method in
     *                                    the support chain, so that they can be passed through the entire chain.
     *                                    Implementations of this interface may always safely ignore this parameter.
     * @param theOptions                  Provides options controlling the validation
     * @param theCodeSystem               The code system, e.g. "<code>http://loinc.org</code>"
     * @param theCode                     The code, e.g. "<code>1234-5</code>"
     * @param theDisplay                  The display name, if it should also be validated
     * @return Returns a validation result object
     */
    @Nullable
    @Override
    public CodeValidationResult validateCode(final ValidationSupportContext theValidationSupportContext,
                                             final ConceptValidationOptions theOptions,
                                             final String theCodeSystem,
                                             final String theCode,
                                             final String theDisplay,
                                             final String theValueSetUrl) {
        return this.createSuccessfulCodeValidationResult(theCode, theDisplay);
    }

    /**
     * Validates that the given code exists and if possible returns a display name. This method is called to check codes
     * which are found in "example" binding fields (e.g. <code>Observation.code</code> in the default profile.
     *
     * @param theValidationSupportContext The validation support module will be passed in to this method. This is
     *                                    convenient in cases where the operation needs to make calls to other method in
     *                                    the support chain, so that they can be passed through the entire chain.
     *                                    Implementations of this interface may always safely ignore this parameter.
     * @param theCodeSystem               The code system, e.g. "<code>http://loinc.org</code>"
     * @param theCode                     The code, e.g. "<code>1234-5</code>"
     * @param theDisplay                  The display name, if it should also be validated
     * @param theValueSet                 The ValueSet to validate against. Must not be null, and must be a ValueSet
     *                                    resource.
     * @return Returns a validation result object, or <code>null</code> if this validation support module can not handle
     * this kind of request
     */
    @Nullable
    @Override
    public CodeValidationResult validateCodeInValueSet(final ValidationSupportContext theValidationSupportContext,
                                                       final ConceptValidationOptions theOptions,
                                                       final String theCodeSystem,
                                                       final String theCode,
                                                       final String theDisplay,
                                                       @NonNull final IBaseResource theValueSet) {
        return this.createSuccessfulCodeValidationResult(theCode, theDisplay);
    }

    /**
     * Returns <code>true</code> if codes in the given code system can be expanded or validated.
     *
     * @param theValidationSupportContext The validation support module will be passed in to this method. This is
     *                                    convenient in cases where the operation needs to make calls to other method in
     *                                    the support chain, so that they can be passed through the entire chain.
     *                                    Implementations of this interface may always safely ignore this parameter.
     * @param theSystem                   The URI for the code system, e.g. <code>"http://loinc.org"</code>
     * @return Returns <code>true</code> if codes in the given code system can be validated
     */
    @Override
    public boolean isCodeSystemSupported(final ValidationSupportContext theValidationSupportContext,
                                         final String theSystem) {
        return this.supportedCodeSystems.contains(theSystem);
    }

    /**
     * @param theCode    The code, e.g. "<code>1234-5</code>".
     * @param theDisplay The display name.
     * @return a validation result object.
     */
    protected CodeValidationResult createSuccessfulCodeValidationResult(final String theCode,
                                                                        final String theDisplay) {
        final var result = new CodeValidationResult();
        result.setCode(theCode);
        result.setDisplay(theDisplay);
        return result;
    }
}
