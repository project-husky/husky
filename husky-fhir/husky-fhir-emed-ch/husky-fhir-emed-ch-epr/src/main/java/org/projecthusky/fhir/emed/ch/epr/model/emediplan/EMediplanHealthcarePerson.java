package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
     * ZSR number. ZSR (Zahlstellenregister), RCC (Registre des codes-créanciers), RCC (Registro dei codici creditori).
     * The ZSR number may only be set once, either in the HealthcarePerson object or in the HealthcareOrganization
     * object.
     */
    protected @Nullable String zsr;

    /**
     * Gets an eMediplan practitioner object from a CH EMED EPR Practitioner object.
     * @param practitioner The CH EMED EPR Practitioner to be converted.
     * @return The resulting eMediplan practitioner.
     */
    public static EMediplanHealthcarePerson fromChEmedEprPractitioner(final ChEmedEprPractitioner practitioner) {
        final var zsr = practitioner.resolveZsr();
        final var zsrNumber = zsr.isEmpty()? null : zsr.get(0);
        return new EMediplanHealthcarePerson(
                practitioner.resolveGln(),
                practitioner.resolveName().getGivenAsSingleString(),
                practitioner.resolveName().getFamily(),
                zsrNumber
                );
    }
}
