package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.DoseType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleDose extends EMediplanDose {
    protected static final String AMOUNT_FIELD_NAME = "a";

    /**
     * The amount to be applied.
     */
    @JsonProperty(AMOUNT_FIELD_NAME)
    protected double amount;

    public SimpleDose() {
        super(DoseType.SIMPLE);
    }

    public SimpleDose(Double amount) {
        this();
        this.amount = amount;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != DoseType.SIMPLE) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, DOSE_TYPE_FIELD_NAME),
                "The dosage type must be Simple for a simple dose."
        ));

        if (amount <= 0.0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, AMOUNT_FIELD_NAME),
                "The dosage amount must be greater than 0."
        ));

        return result;
    }
}
