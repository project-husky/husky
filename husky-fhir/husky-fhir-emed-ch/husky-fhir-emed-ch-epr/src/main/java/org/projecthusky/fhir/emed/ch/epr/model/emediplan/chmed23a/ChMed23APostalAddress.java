package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPostalAddress;

/**
 * A postal address. This class is made to be embedded within other classes like {@link ChMed23APatient} and
 * {@link ChMed23AHealthcareOrganization} that should use it as a {@link com.fasterxml.jackson.annotation.JsonUnwrapped}
 * property so that it is flattened on inclusion.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed23APostalAddress extends EMediplanPostalAddress {
    protected static final String STREET_FIELD_NAME = "street";
    protected static final String POSTAL_CODE_FIELD_NAME = "zip";
    protected static final String CITY_FIELD_NAME = "city";
    protected static final String COUNTRY_FIELD_NAME = "country";

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
    /**
     * Country. If the address is in Switzerland, this property does not need to be set, as it is assumed by default
     * that the address is in Switzerland.
     * Format: Alpha-2 code (ISO 3166 5Country Codes), e.g. {@code FR} for France.
     */
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
        return "country";
    }

    @Override
    public void trim() {
        if ("CH".equalsIgnoreCase(country)) country = null;
    }

    public static ChMed23APostalAddress fromFhirAddress(final Address fhirAddress) {
        return EMediplanPostalAddress.fromFhirAddress(ChMed23APostalAddress::new, fhirAddress);
    }
}
