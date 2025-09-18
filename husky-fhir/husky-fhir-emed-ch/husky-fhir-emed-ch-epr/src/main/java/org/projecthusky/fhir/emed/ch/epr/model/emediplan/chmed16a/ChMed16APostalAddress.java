package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPostalAddress;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.ChMed23AHealthcareOrganization;

/**
 * A postal address. This class is made to be embedded within other classes like {@link ChMed16APatient} and
 * {@link ChMed23AHealthcareOrganization} that should use it as a {@link com.fasterxml.jackson.annotation.JsonUnwrapped}
 * property so that it is flattened on inclusion.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ChMed16APostalAddress extends EMediplanPostalAddress {
    protected static final String STREET_FIELD_NAME = "Street";
    protected static final String POSTAL_CODE_FIELD_NAME = "Zip";
    protected static final String CITY_FIELD_NAME = "City";
    protected static final String COUNTRY_FIELD_NAME = "Country";

    /**
     * All information at lower leven than the postal code, can be several lines.
     */
    @JsonProperty(STREET_FIELD_NAME)
    protected @Nullable String street;
    /**
     * Postcode.
     */
    @JsonProperty(POSTAL_CODE_FIELD_NAME)
    protected @Nullable String postalCode;
    @JsonProperty(CITY_FIELD_NAME)
    protected @Nullable String city;
    @JsonProperty(COUNTRY_FIELD_NAME)
    protected @Nullable String country;

    @Override
    public String getStreetFieldName() {
        return STREET_FIELD_NAME;
    }

    @Override
    public String getPostalCodeFieldName() {
        return POSTAL_CODE_FIELD_NAME;
    }

    @Override
    public String getCityFieldName() {
        return CITY_FIELD_NAME;
    }

    @Override
    public String getCountryFieldName() {
        return "";
    }

    // An empty setter fulfills the constraint of not allowing a country code in the vanilla CHMED16A structure.
    @Override
    public void setCountry(final @Nullable String country) {}

    public static ChMed16APostalAddress fromFhirAddress(final Address fhirAddress) {
        return EMediplanPostalAddress.fromFhirAddress(ChMed16APostalAddress::new, fhirAddress);
    }
}
