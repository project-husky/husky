package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprOrganization;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class EMediplanHealthcareOrganization<A extends EMediplanPostalAddress> implements EMediplanObject {
    public abstract String getName();
    public abstract A getAddress();
    public abstract @Nullable String getZsr();

    public abstract void setName(String name);
    public abstract void setAddress(A address);
    public abstract void setZsr(@Nullable String zsr);

    @JsonIgnore
    protected abstract String getNameFieldName();

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (getName() == null || getName().isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, getNameFieldName()),
                "The healthcare organization's name is missing but it is mandatory."
        ));

        if (getAddress() == null) result.add(getRequiredFieldValidationIssue(
                basePath,
                "The healthcare organization's address is missing but it is mandatory."
        ));
        else {
            result.add(getAddress().validate(basePath));
            if (getAddress().getStreet() == null || getAddress().getStreet().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, getAddress().getStreetFieldName()),
                    "The healthcare organization's address is missing the street, but it is mandatory."
            ));
            if (getAddress().getPostalCode() == null || getAddress().getPostalCode().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, getAddress().getPostalCodeFieldName()),
                    "The healthcare organization's address is missing the postal code, but it is mandatory."
            ));
            if (getAddress().getCity() == null || getAddress().getCity().isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, getAddress().getCityFieldName()),
                    "The healthcare organization's city is missing but it is mandatory."
            ));
        }

        return result;
    }

    @Override
    public void trim() {
        if (getAddress() != null) getAddress().trim();
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth && getAddress() != null && getAddress().hasExtensions(true);
    }

    /**
     * Gets an eMediplan organization object from a CH EMED EPR organization object.
     * @param organization The CH EMED EPR organization object to be converted.
     * @param supplier     The new healthcare organization object supplier, normally an empty constructor.
     * @param addressConverter The converter from FHIR address to the eMediplan address to be used.
     * @return The resulting eMediplan object.
     */
    protected static <T extends EMediplanHealthcareOrganization<Ad>, Ad extends EMediplanPostalAddress> @NotNull T fromChEmedEprOrganization(
            final ChEmedEprOrganization organization,
            final Supplier<? extends T> supplier,
            final Function<Address, ? extends Ad> addressConverter) {

        final var hcOrg = supplier.get();
        hcOrg.setName(organization.getName());
        hcOrg.setAddress(addressConverter.apply(organization.resolveAddress()));
        hcOrg.setZsr(organization.resolveZsr());
        return hcOrg;
    }
}
