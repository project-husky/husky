package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DoseType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * A dose specifying a minimum and a maximum amount of medication.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RangeDose extends EMediplanDose {
    protected static final String MIN_AMOUNT_FIELD_NAME = "aMin";
    protected static final String MAX_AMOUNT_FIELD_NAME = "aMax";

    /**
     * The minimum amount of medication that must be applied.
     */
    @JsonProperty(MIN_AMOUNT_FIELD_NAME)
    protected double minimumAmount;
    /**
     * Te maximum amount of medication that must be applied.
     */
    @JsonProperty(MAX_AMOUNT_FIELD_NAME)
    protected double maximumAmount;

    public RangeDose() {
        super(DoseType.RANGE);
    }

    public RangeDose(double minimumAmount, double maximumAmount) {
        this();
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != DoseType.RANGE) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, DOSE_TYPE_FIELD_NAME),
                "The dosage type must be Range for an interval dose."
        ));

        if (minimumAmount <= 0.0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, MIN_AMOUNT_FIELD_NAME),
                "The minimum amount must be greater than or equal to 0."
        ));

        if (maximumAmount <= minimumAmount) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, MAX_AMOUNT_FIELD_NAME),
                "The maximum amount must be greater than the minimum amount."
        ));

        return result;
    }
}
