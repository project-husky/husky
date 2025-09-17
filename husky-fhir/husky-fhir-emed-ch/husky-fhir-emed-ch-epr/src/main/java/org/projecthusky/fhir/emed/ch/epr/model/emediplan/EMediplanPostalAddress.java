package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class EMediplanPostalAddress implements EMediplanObject {
    protected static final Pattern COUNTRY_CODE_PATTERN = Pattern.compile( "^[a-zA-Z]{2}$" );

    public abstract String getStreet();
    public abstract String getPostalCode();
    public abstract String getCity();
    public abstract @Nullable String getCountry();
    public abstract void setStreet(final @Nullable String street);
    public abstract void setPostalCode(final @Nullable String postalCode);
    public abstract void setCity(final @Nullable String city);
    public abstract void setCountry(final @Nullable String country);

    @JsonIgnore
    public abstract String getStreetFieldName();
    @JsonIgnore
    public abstract String getPostalCodeFieldName();
    @JsonIgnore
    public abstract String getCityFieldName();
    @JsonIgnore
    public abstract String getCountryFieldName();

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (getCountry() != null && !COUNTRY_CODE_PATTERN.matcher(getCountry()).matches()) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.CODEINVALID,
                getFieldValidationPath(basePath,  getCountryFieldName()),
                "The address' country code should be a 2 letter Alpha-2 code (ISO 3166 5Country Codes)."
        ));

        return result;
    }

    /**
     * Fills the received (normally, new) eMediplan postal address object with the content of the received FHIR address.
     * @param addressSupplier     A supplier for the eMediplan address to be filled.
     * @param fhirAddress The FHIR address with the postal address data.
     * @return            The mutated eMediplan address object.
     * @param <T>         The type of eMediplanPostalAddress object.
     */
    public static <T extends EMediplanPostalAddress> T fromFhirAddress(final Supplier<T> addressSupplier, final Address fhirAddress) {
        Objects.requireNonNull(addressSupplier, "address must not be null");
        Objects.requireNonNull(fhirAddress, "fhirAddress must not be null");

        final var address = addressSupplier.get();

        String street = null, postalCode = null, city = null, country = null;
        if (fhirAddress.hasLine())
            street = fhirAddress.getLine().stream().map(PrimitiveType::getValue).collect(Collectors.joining("\n"));
        if (fhirAddress.hasPostalCode()) postalCode = fhirAddress.getPostalCode();
        if (fhirAddress.hasCity()) city = fhirAddress.getCity();
        if (fhirAddress.hasCountryElement()) {
            final var countryElement = fhirAddress.getCountryElement();
            final var countryCode = countryElement.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/iso21090-SC-coding");
            if (countryCode != null && countryCode.hasValue() && countryCode.getValue() instanceof Coding countryCoding) {
                country = countryCoding.getCode();
            }
        }

        address.setStreet( street );
        address.setPostalCode( postalCode );
        address.setCity( city );
        address.setCountry(country);
        return address;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }
}
