package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprOrganization;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMediplanHealthcareOrganization {
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
    protected EMediplanPostalAddress address;
    /**
     * ZSR number. The ZSR number may only be set once, either in the HealthcarePerson object or in the
     * HealthcareOrganization object.
     */
    protected @Nullable String zsr;

    /**
     * Gets an eMediplan organization object from a CH EMED EPR organization object.
     * @param organization The CH EMED EPR organization object to be converted.
     * @return The resulting eMediplan object.
     */
    public static EMediplanHealthcareOrganization fromChEmedEprOrganization(final ChEmedEprOrganization organization) {
        return new EMediplanHealthcareOrganization(
                organization.resolveGln(),
                organization.getName(),
                EMediplanPostalAddress.fromFhirAddress(organization.resolveAddress()),
                organization.resolveZsr()
        );
    }
}
