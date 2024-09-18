package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DosageSequenceType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SequenceElement implements EMediplanObject {
    protected static final String SEQUENCE_TYPE_FIELD_NAME = "t";
    protected static final String DURATION_FIELD_NAME = "du";
    protected static final String DURATION_UNIT_FIELD_NAME = "duU";

    @JsonProperty(SEQUENCE_TYPE_FIELD_NAME)
    protected DosageSequenceType type;
    @JsonProperty(DURATION_FIELD_NAME)
    protected int duration;
    @JsonProperty(DURATION_UNIT_FIELD_NAME)
    protected TimeUnit durationUnit;

    public SequenceElement(final DosageSequenceType type) {
        this.type = type;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (type == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, SEQUENCE_TYPE_FIELD_NAME),
                "The sequence object type is missing, but it is required."
        ));

        if (duration <= 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, DURATION_FIELD_NAME),
                "The sequence element duration cannot be lesser or equal than 0."
        ));

        if (durationUnit == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DURATION_UNIT_FIELD_NAME),
                "The duration unit is missing, but it is required."
        ));

        return result;
    }
}
