package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.dose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.DoseType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * This is what ChMed23A calls DosageFromTo. It specifies how a dose changes during time, e.g. for infusions, starting
 * at one value and ending at a different value during the specified amount of time.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class IntervalDose extends EMediplanDose {
    protected static final String INITIAL_AMOUNT_FIELD_NAME = "aFrom";
    protected static final String FINAL_AMOUNT_FIELD_NAME = "aTo";
    protected static final String DURATION_UNIT_FIELD_NAME = "duU";
    protected static final String DURATION_FIELD_NAME = "du";

    /**
     * The dose start amount.
     */
    @JsonProperty(INITIAL_AMOUNT_FIELD_NAME)
    protected double initialAmount;
    /**
     * The end start amount.
     */
    @JsonProperty(FINAL_AMOUNT_FIELD_NAME)
    protected double finalAmount;
    /**
     * The unit of the dose duration.
     */
    @JsonProperty(DURATION_UNIT_FIELD_NAME)
    protected TimeUnit durationUnit;
    /**
     * The duration (amount).
     */
    @JsonProperty(DURATION_FIELD_NAME)
    protected int duration;

    public IntervalDose() {
        super(DoseType.FROM_TO);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != DoseType.FROM_TO) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, DOSE_TYPE_FIELD_NAME),
                "The dosage type must be FromTo for an interval dose."
        ));

        if (initialAmount < 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, INITIAL_AMOUNT_FIELD_NAME),
                "The dose initial amount must be greater or equal than zero."
        ));

        if (finalAmount < initialAmount) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, FINAL_AMOUNT_FIELD_NAME),
                "The dose final amount must be greater than the initial amount."
        ));

        if (durationUnit == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DURATION_UNIT_FIELD_NAME),
                "The duration unit is missing, but it is required."
        ));

        if (duration <= 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, DURATION_FIELD_NAME),
                "The duration cannot be lesser or equal than 0."
        ));

        return result;
    }
}
