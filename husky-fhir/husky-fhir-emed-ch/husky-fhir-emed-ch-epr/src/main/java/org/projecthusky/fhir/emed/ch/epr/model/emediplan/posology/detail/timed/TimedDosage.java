package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Specifies the moment and amount of a medication application. All TimedDosage objects must specify an amount to be
 * applied. It is not mandatory to specify the moment of application, but it is possibly to set them either precisely
 * or vaguely.
 */
@Data
@NoArgsConstructor
public abstract class TimedDosage implements EMediplanObject {
    protected static final String TIMED_DOSAGE_TYPE_FIELD_NAME = "t";

    @JsonProperty(TIMED_DOSAGE_TYPE_FIELD_NAME)
    protected TimedDosageType type;

    protected TimedDosage(final TimedDosageType type) {
        this.type = type;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();
        if (type == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage object type is missing, but it is required."
        ));
        return result;
    }
}
