package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMediplanHealthcarePerson implements EMediplanObject {
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

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (firstName == null || firstName.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "fName"),
                "The healthcare professional's first name is missing but it is mandatory."
        ));

        if (lastName == null || lastName.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "lName"),
                "The healthcare professional's last name is missing but is mandataroy."
        ));

        return result;
    }

    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validate(basePath);

        if (Objects.requireNonNull(mediplanType) == EMediplanType.PRESCRIPTION) {
            if (gln == null || gln.isBlank()) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, "gln"),
                    "The healthcare professional's GLN is missing, but it is mandatory for eMediplan prescription documents."
            ));
        }

        if (mediplanType == EMediplanType.MEDICATION_PLAN) {
            if (zsr != null && !zsr.isBlank()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, "zsr"),
                    "Tĥe healthcare's professional ZSR number should not be included in a eMediplan medication plan document."
            ));
        }

        return result;
    }

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
