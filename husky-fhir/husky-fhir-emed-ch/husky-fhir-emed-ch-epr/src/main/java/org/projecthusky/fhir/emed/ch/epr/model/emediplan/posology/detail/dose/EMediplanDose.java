package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * This corresponds to the DosageObject definition in ChMed23A.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EMediplanDose implements EMediplanObject {
    protected static final String DOSE_TYPE_FIELD_NAME = "t";

    @JsonProperty(DOSE_TYPE_FIELD_NAME)
    protected DoseType type;

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();
        if (type == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DOSE_TYPE_FIELD_NAME),
                "The dosage object type is missing, but it is required."
        ));
        return result;
    }
}
