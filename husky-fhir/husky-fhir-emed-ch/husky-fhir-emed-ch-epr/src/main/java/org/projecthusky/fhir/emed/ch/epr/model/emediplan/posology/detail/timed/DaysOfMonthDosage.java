package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.Set;

/**
 * Specifies on which days of the month a medication must be applied.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class DaysOfMonthDosage extends TimedDosage {
    protected static final String DAYS_OF_MONTH_FIELD_NAME = "doms";
    protected static final String DOSAGE_FIELD_NAME = "tdo";

    /**
     * The days of the month in which the medication must be applied. Each number must be greater than 0 and lesser or
     * equal than 28.
     */
    @JsonProperty(DAYS_OF_MONTH_FIELD_NAME)
    protected Set<@NonNull Integer> daysOfMonth;
    /**
     * The timed dosage object specifying the timing and dosage of the medication to be applied.
     */
    @JsonProperty(DOSAGE_FIELD_NAME)
    protected EmbeddableTimedDosage dosage;

    public DaysOfMonthDosage() {
        super(TimedDosageType.DAYS_OF_MONTH);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != TimedDosageType.DAYS_OF_MONTH) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage type must be DaysOfMonth for a days of month timed dosage object."
        ));

        if (daysOfMonth == null || daysOfMonth.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DAYS_OF_MONTH_FIELD_NAME),
                "The days of month list is missing or is empty, but it is required."
        ));
        else {
            if (daysOfMonth.stream().anyMatch(val -> val <= 0 || val > 28)) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath, DAYS_OF_MONTH_FIELD_NAME),
                    "The days of the month must be between (and including) 0 and 28."
            ));
        }

        if (dosage == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DOSAGE_FIELD_NAME),
                "The timed dosage object is missing, but it is required."
        ));

        return result;
    }

    @Override
    public void trim() {
        if (dosage != null) dosage.trim();
    }
}
