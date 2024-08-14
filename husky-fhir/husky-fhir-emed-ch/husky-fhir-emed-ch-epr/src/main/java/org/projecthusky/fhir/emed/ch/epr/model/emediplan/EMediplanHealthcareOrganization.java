package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.checkerframework.checker.nullness.qual.Nullable;

public class EMediplanHealthcareOrganization {
    /**
     * The GLN. Required if not set in the HealthcarePerson object, otherwise optional.
     */
    protected @Nullable String gln;
    protected String name;
    protected String street;
    /**
     * Postcode.
     */
    protected String zip;
    protected String city;
    /**
     * Country. If the address is in Switzerland, this property does not need to be set, as it is assumed by default
     * that the address is in Switzerland.
     * Format: Alpha-2 code (ISO 3166 5Country Codes), e.g. {@code FR} for France.
     */
    protected @Nullable String country;
    /**
     * ZSR number. The ZSR number may only be set once, either in the HealthcarePerson object or in the
     * HealthcareOrganization object.
     */
    protected @Nullable String zsr;
}
