package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PosologyDetail implements EMediplanObject {
    protected static final String POSOLOGY_TYPE_FIELD_NAME = "t";

    @JsonProperty(POSOLOGY_TYPE_FIELD_NAME)
    protected PosologyType type;

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();
        if (type == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, POSOLOGY_TYPE_FIELD_NAME),
                "The posology type is missing, but it is required."
        ));
        return result;
    }
}
