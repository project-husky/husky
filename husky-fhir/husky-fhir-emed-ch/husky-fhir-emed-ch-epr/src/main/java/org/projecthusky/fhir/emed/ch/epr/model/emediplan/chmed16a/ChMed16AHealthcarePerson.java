package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcarePerson;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed16AHealthcarePerson extends EMediplanHealthcarePerson {
    protected static final String GLN_FIELD_NAME = "Gln";
    protected static final String FIRST_NAME_FIELD_NAME = "FName";
    protected static final String LAST_NAME_FIELD_NAME = "LName";
    protected static final String ZSR_FIELD_NAME = "Zsr";

    /**
     * The HCP GLN.
     */
    @JsonProperty(GLN_FIELD_NAME)
    protected @Nullable String gln;
    /**
     * First name.
     */
    @JsonProperty(FIRST_NAME_FIELD_NAME)
    protected @Nullable String firstName;
    /**
     * Last name.
     */
    @JsonProperty(LAST_NAME_FIELD_NAME)
    protected @Nullable String lastName;
    /**
     * ZSR number. ZSR (Zahlstellenregister), RCC (Registre des codes-créanciers), RCC (Registro dei codici creditori).
     * The ZSR number may only be set once, either in the HealthcarePerson object or in the HealthcareOrganization
     * object.
     */
    @JsonProperty(ZSR_FIELD_NAME)
    protected @Nullable String zsr;

    @Override
    public String getGlnFieldName() {
        return GLN_FIELD_NAME;
    }

    @Override
    public String getFirstNameFieldName() {
        return FIRST_NAME_FIELD_NAME;
    }

    @Override
    public String getLastNameFieldName() {
        return LAST_NAME_FIELD_NAME;
    }

    public @Nullable String getZsrFieldName() {
        return ZSR_FIELD_NAME;
    }

    /**
     * Gets an ePrescription practitioner object from a CH EMED EPR Practitioner object.
     * @param practitioner The CH EMED EPR Practitioner to be converted.
     * @return The resulting ePrescription practitioner.
     */
    public static ChMed16AHealthcarePerson fromChEmedEprPractitioner(final ChEmedEprPractitioner practitioner) {
        return fromChEmedEprPractitioner(practitioner, ChMed16AHealthcarePerson::new);
    }
}
