package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprOrganization;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMediplanHealthcareOrganization implements EMediplanObject {
    /**
     * The GLN. Required if not set in the HealthcarePerson object, otherwise optional.
     */
    protected @Nullable String gln;
    /**
     * Name of the organization.
     */
    protected String name;
    /**
     * Postal address of the patient.
     */
    @JsonUnwrapped
    protected ChMed23APostalAddress address;
    /**
     * ZSR number. The ZSR number may only be set once, either in the HealthcarePerson object or in the
     * HealthcareOrganization object.
     */
    protected @Nullable String zsr;

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (name == null || !name.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "name"),
                "The healthcare organization's name is missing but it is mandatory."
        ));

        if (address == null) result.add(getRequiredFieldValidationIssue(
                basePath,
                "The healthcare organization's address is missing but it is mandatory."
        ));
        else {
            result.add(address.validate(basePath));
            if (address.getStreet() == null || address.getStreet().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "street"),
                    "The healthcare organization's address is missing the street, but it is mandatory."
            ));
            if (address.getPostalCode() == null || address.getPostalCode().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "zip"),
                    "The healthcare organization's address is missing the postal code, but it is mandatory."
            ));
            if (address.getCity() == null || address.getCity().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "city"),
                    "The healthcare organization's city is missing but it is mandatory."
            ));
        }

        return result;
    }

    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validate(basePath);

        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (gln != null && !gln.isEmpty()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, "gln"),
                    "The healthcare organization's GLN is present but should not be included in eMediplan prescription documents. the healthcare professional GLN should be filled instead."
            ));
        }

        return result;
    }

    public void trim() {
        if (address != null) address.trim();
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth && address != null && address.hasExtensions(true);
    }

    /**
     * Gets an eMediplan organization object from a CH EMED EPR organization object.
     * @param organization The CH EMED EPR organization object to be converted.
     * @return The resulting eMediplan object.
     */
    public static EMediplanHealthcareOrganization fromChEmedEprOrganization(final ChEmedEprOrganization organization) {
        return new EMediplanHealthcareOrganization(
                organization.resolveGln(),
                organization.getName(),
                ChMed23APostalAddress.fromFhirAddress(organization.resolveAddress()),
                organization.resolveZsr()
        );
    }
}
