package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.TimedDosage;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Describes the application of a medication at constant intervals.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CyclicDosage extends PosologyDetail {
    protected static final String CYCLE_DURATION_UNIT_FIELD_NAME = "cyDuU";
    protected static final String CYCLE_DURATION_FIELD_NAME = "cyDu";
    protected static final String TIMED_DOSAGE_FIELD_NAME = "tdo";
    protected static final String NUMBER_OF_DOSES_PER_CYCLE_FIELD_NAME = "tdpc";

    protected static final int DEFAULT_NUMBER_OF_DOSES_PER_CYCLE = 1;

    /**
     * The cycle duration unit.
     */
    @JsonProperty(CYCLE_DURATION_UNIT_FIELD_NAME)
    protected TimeUnit cycleDurationUnit;
    /**
     * The duration of a cycle.
     */
    @JsonProperty(CYCLE_DURATION_FIELD_NAME)
    protected int cycleDuration;
    /**
     * Timing and dose of a medication to be applied.
     * Supported types: DosageOnly, Times, DaySegments, Interval, WeekDaysDosage and DaysOfMonthDosage.
     * WeekDaysDosage is supported only if the cycle curation unit is a week.
     * DaysOfMonthDosage is supported only if the cycle duration unit is a month.
     */
    @JsonProperty(TIMED_DOSAGE_FIELD_NAME)
    protected TimedDosage timedDosage;
    /**
     * Number of doses (as specified by tdo) to be applied per cycle. By default, 1 is assumed.
     */
    @JsonProperty(NUMBER_OF_DOSES_PER_CYCLE_FIELD_NAME)
    protected @Nullable Integer numberOfDosesPerCycle;

    public CyclicDosage() {
        super(PosologyType.CYCLIC);
    }

    public int getNumberOfDosesPerCycle() {
        if (numberOfDosesPerCycle == null) return DEFAULT_NUMBER_OF_DOSES_PER_CYCLE;
        else return numberOfDosesPerCycle;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != PosologyType.CYCLIC) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, POSOLOGY_TYPE_FIELD_NAME),
                "The posology type is cyclic but the object is not."
        );

        if (cycleDurationUnit == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, CYCLE_DURATION_UNIT_FIELD_NAME),
                "The cycle duration unit is missing but it is required."
        ));

        if (timedDosage == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME),
                "The timed dosage object is missing but it is required for cyclic dosages."
        ));
        else {
            result.add(timedDosage.validate(getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME)));
            switch(timedDosage.getType()) {
                case DOSAGE_ONLY, TIMES, DAY_SEGMENTS, INTERVAL -> {}
                case WEEK_DAYS -> {
                    if (cycleDurationUnit == null || cycleDurationUnit != TimeUnit.WEEK) result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.INVALID,
                            getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME),
                            "The timed dosage cannot be of WeekDays type if the cyclic dosage duration unit is not week."
                    ));
                }
                case DAYS_OF_MONTH -> {
                    if (cycleDurationUnit == null || cycleDurationUnit != TimeUnit.MONTH) result.add(getValidationIssue(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.INVALID,
                            getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME),
                            "The timed dosage cannot be of DaysOfMonth type if the cyclic dosage duration unit is not month."
                    ));
                }
                default -> result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.INVALID,
                        getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME),
                        "Unsupported type of timed dosage."
                ));
            }
        }

        if (cycleDuration <= 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, CYCLE_DURATION_FIELD_NAME),
                "The cycle duration has to be greater than 0."
        ));

        if (numberOfDosesPerCycle != null && numberOfDosesPerCycle <= 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, NUMBER_OF_DOSES_PER_CYCLE_FIELD_NAME),
                "The number of timed dosages per cycle has to be greater than 0."
        ));

        return result;
    }

    @Override
    public void trim() {
        if (timedDosage != null) timedDosage.trim();

        if (numberOfDosesPerCycle != null && numberOfDosesPerCycle == DEFAULT_NUMBER_OF_DOSES_PER_CYCLE)
            numberOfDosesPerCycle = null;
    }
}
