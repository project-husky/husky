package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPostalAddress;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.EMediplanHealthcareOrganization;

/**
 * A postal address. This class is made to be embedded within other classes like {@link ChMed16APatient} and
 * {@link EMediplanHealthcareOrganization} that should use it as a {@link com.fasterxml.jackson.annotation.JsonUnwrapped}
 * property so that it is flattened on inclusion.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed16APostalAddress extends EMediplanPostalAddress {
    /**
     * All information at lower leven than the postal code, can be several lines.
     */
    @JsonProperty("Street")
    protected @Nullable String street;
    /**
     * Postcode.
     */
    @JsonProperty("Zip")
    protected @Nullable String postalCode;
    @JsonProperty("City")
    protected @Nullable String city;

    @Override @JsonIgnore
    public @Nullable String getCountry() {
        return null;
    }

    @Override
    public String getCountryFieldName() {
        return "";
    }

    public void setCountry(final @Nullable String country) {}

    public static ChMed16APostalAddress fromFhirAddress(final Address fhirAddress) {
        return EMediplanPostalAddress.fromFhirAddress(new ChMed16APostalAddress(), fhirAddress);
    }
}
