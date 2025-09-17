package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcarePerson;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed23AHealthcarePerson extends EMediplanHealthcarePerson {
    protected static final String GLN_FIELD_NAME = "gln";
    protected static final String FIRST_NAME_FIELD_NAME = "fName";
    protected static final String LAST_NAME_FIELD_NAME = "lName";
    protected static final String ZSR_FIELD_NAME = "zsr";

    /**
     * The HCP GLN.
     */
    @JsonProperty(GLN_FIELD_NAME)
    protected @Nullable String gln;
    /**
     * First name.
     */
    @JsonProperty(FIRST_NAME_FIELD_NAME)
    protected String firstName;
    /**
     * Last name.
     */
    @JsonProperty(LAST_NAME_FIELD_NAME)
    protected String lastName;
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

    /**
     * Gets an eMediplan practitioner object from a CH EMED EPR Practitioner object.
     * @param practitioner The CH EMED EPR Practitioner to be converted.
     * @return The resulting eMediplan practitioner.
     */
    public static ChMed23AHealthcarePerson fromChEmedEprPractitioner(final ChEmedEprPractitioner practitioner) {
        return fromChEmedEprPractitioner(practitioner, ChMed23AHealthcarePerson::new);
    }
}
