package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Specifies a dose that must be applied at certain times, either at a precise moment or in a day's segment (i.e.
 * morning, noon, evening or night).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Application implements EMediplanObject {
    protected static final String DOSE_FIELD_NAME = "do";

    @JsonProperty(DOSE_FIELD_NAME)
    protected EMediplanDose dose;

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (dose == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DOSE_FIELD_NAME),
                "The application object is missing the dose, but it is mandatory."
        ));
        else result.add(dose.validate(getFieldValidationPath(basePath, DOSE_FIELD_NAME)));

        return result;
    }
}
