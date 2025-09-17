package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Interface for an object that carries information about healthcare professionals in the context of an eMediplan
 * document. That is: that may convey an {@link EMediplanHealthcarePerson} object and/or an
 * {@link EMediplanHealthcareOrganization}.
 *
 * @param <P> The type of {@link EMediplanHealthcarePerson} objects of the implementing class may convey.
 * @param <O> The type of {@link EMediplanHealthcareOrganization} objects of the implementing class may convey.
 */
public interface EMediplanHealthcareProCarrier <P extends EMediplanHealthcarePerson, O extends EMediplanHealthcareOrganization>
extends EMediplanObject {
    @Nullable P getHealthcarePerson();
    @Nullable O getHealthcareOrganization();

    @JsonIgnore
    String getHealthcarePersonFieldName();
    @JsonIgnore
    String getHealthcareOrganizationFieldName();

    /**
     * Whether the author of the eMediplan is of a professional nature (pro/org) or a patient.
     * @return {@code true} if the author is a professional, {@code false} otherwise.
     */
    @JsonIgnore
    boolean isAuthorProfessional();

    /**
     * Validates the healthcare person and healthcare organization content.
     *
     * @param basePath The base path for the object containing the healthcare professional/organization information.
     * @return The validation result.
     */
    default ValidationResult validateHealtcareProInfo(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (getHealthcarePerson() == null) {
            if (isAuthorProfessional())
                result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath, getHealthcarePersonFieldName()),
                        "The hcPerson object is missing, but it is required when the author is a healthcare person."
                ));
        } else {
            result.add(getHealthcarePerson().validate(basePath));
            if (!isAuthorProfessional()) {
                result.add(getIgnoredFieldValidationIssue(
                        getFieldValidationPath(basePath, getHealthcarePersonFieldName()),
                        "The healthcare person object is present, but the author type is a patient."
                ));
            }
        }

        if (getHealthcareOrganization() == null) {
            if (isAuthorProfessional())
                result.add(getRequiredFieldValidationIssue(
                        getFieldValidationPath(basePath, getHealthcareOrganizationFieldName()),
                        "The hcOrg object is missing, but it is required when the author is a healthcare person."
                ));
        } else {
            result.add(getHealthcareOrganization().validate(basePath));
        }

        if (getHealthcarePerson() != null && getHealthcareOrganization() != null
                && getHealthcarePerson().getZsr() != null && !getHealthcarePerson().getZsr().isBlank()
                && getHealthcareOrganization().getZsr() != null && !getHealthcareOrganization().getZsr().isBlank())
            result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.BUSINESSRULE,
                    basePath == null? "" : basePath,
                    "The ZSR number may be present either in the healthcare person object or the healthcare organization object but not both."
            ));

        return result;
    }
}
