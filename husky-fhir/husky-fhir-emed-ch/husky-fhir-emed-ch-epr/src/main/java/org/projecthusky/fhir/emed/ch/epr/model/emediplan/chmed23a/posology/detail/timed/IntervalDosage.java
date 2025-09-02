package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.dose.EMediplanDose;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Specifies the application of a medication with a minimal interval between two applications.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class IntervalDosage extends TimedDosage {
    protected static final String DOSE_FIELD_NAME = "do";
    protected static final String MINIMUM_DURATION_FIELD_NAME = "miDu";
    protected static final String MINIMUM_DURATION_UNIT_FIELD_NAME = "miDuU";

    /**
     * The dose to be applied.
     */
    @JsonProperty(DOSE_FIELD_NAME)
    protected EMediplanDose dose;
    /**
     * The amount of time of the interval that must elapse between two intakes of the medication.
     */
    @JsonProperty(MINIMUM_DURATION_FIELD_NAME)
    protected int minimumDuration;
    /**
     * The time unit for the interval.
     */
    @JsonProperty(MINIMUM_DURATION_UNIT_FIELD_NAME)
    protected TimeUnit durationUnit;

    public IntervalDosage() {
        super(TimedDosageType.INTERVAL);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != TimedDosageType.INTERVAL) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage type must be Interval for an interval timed dosage object."
        ));

        if (dose == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DOSE_FIELD_NAME),
                "The dose object for the interval is missing, but it is required."
        ));
        else result.add(dose.validate(getFieldValidationPath(basePath, DOSE_FIELD_NAME)));

        if (minimumDuration <= 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, MINIMUM_DURATION_FIELD_NAME),
                "The minimum duration value of the interval must be greater than zero."
        ));

        if (durationUnit == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, MINIMUM_DURATION_UNIT_FIELD_NAME),
                "The minimum duration unit for the interval is missing, but it is required."
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth && dose != null && dose.hasExtensions(true);
    }

    @Override
    public void trim() {
        if (dose != null) dose.trim();
    }
}
