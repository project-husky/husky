package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPostalAddress;

/**
 * A postal address. This class is made to be embedded within other classes like {@link ChMed23APatient} and
 * {@link EMediplanHealthcareOrganization} that should use it as a {@link com.fasterxml.jackson.annotation.JsonUnwrapped}
 * property so that it is flattened on inclusion.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed23APostalAddress extends EMediplanPostalAddress {
    /**
     * All information at lower leven than the postal code, can be several lines.
     */
    protected @Nullable String street;
    /**
     * Postcode.
     */
    @JsonProperty("zip")
    protected @Nullable String postalCode;
    protected @Nullable String city;
    /**
     * Country. If the address is in Switzerland, this property does not need to be set, as it is assumed by default
     * that the address is in Switzerland.
     * Format: Alpha-2 code (ISO 3166 5Country Codes), e.g. {@code FR} for France.
     */
    protected @Nullable String country;

    protected String getCountryFieldName() {
        return "country";
    }

    @Override
    public void trim() {
        if ("CH".equalsIgnoreCase(country)) country = null;
    }

    public static ChMed23APostalAddress fromFhirAddress(final Address fhirAddress) {
        final var res = new ChMed23APostalAddress();
        EMediplanPostalAddress.fromFhirAddress(res, fhirAddress);
        String country = null;
        if (fhirAddress.hasCountryElement()) {
            final var countryElement = fhirAddress.getCountryElement();
            final var countryCode = countryElement.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/iso21090-SC-coding");
            if (countryCode != null && countryCode.hasValue() && countryCode.getValue() instanceof Coding countryCoding) {
                country = countryCoding.getCode();
            }
        }
        res.setCountry(country);
        return res;
    }
}
