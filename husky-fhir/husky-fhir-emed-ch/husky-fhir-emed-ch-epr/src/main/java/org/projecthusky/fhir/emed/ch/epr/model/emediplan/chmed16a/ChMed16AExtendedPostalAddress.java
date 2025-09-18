package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPostalAddress;

/**
 * This is the postal address object used for the ePrescription backport of HealthcareOrganization, which includes
 * the country code, while the vanilla CHMED16A does not.
 */
public class ChMed16AExtendedPostalAddress extends ChMed16APostalAddress {
    @Override
    public void setCountry(final @Nullable String country) {
        this.country = country;
    }

    public static ChMed16AExtendedPostalAddress fromFhirAddress(final Address fhirAddress) {
        return EMediplanPostalAddress.fromFhirAddress(ChMed16AExtendedPostalAddress::new, fhirAddress);
    }
}
