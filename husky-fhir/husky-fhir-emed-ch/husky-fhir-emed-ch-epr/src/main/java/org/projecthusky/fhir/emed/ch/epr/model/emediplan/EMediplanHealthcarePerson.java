package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EMediplanHealthcarePerson {
    /**
     * The HCP GLN.
     */
    protected @Nullable String gln;
    /**
     * First name.
     */
    @JsonProperty("fName")
    protected String firstName;
    /**
     * Last name.
     */
    @JsonProperty("lName")
    protected String lastName;
    /**
     * ZSR number. The ZSR number may only be set once, either in the HealthcarePerson object or in the
     * HealthcareOrganization object.
     */
    protected @Nullable String zsr;
}
