package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DayOfWeek;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.Set;

/**
 * Specifies on which days of the week a medication must be applied.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class WeekDaysDosage extends TimedDosage {
    protected static final String WEEK_DAYS_FIELD_NAME = "wds";
    protected static final String DOSAGE_FIELD_NAME = "tdo";

    /**
     * The days of the week for which the embedded timed dosage must be applied.
     */
    @JsonProperty(WEEK_DAYS_FIELD_NAME)
    protected Set<@NonNull DayOfWeek> weekdays;
    /**
     * The embedded timed dosage specifying the timing and dosage of the medication to be applied in the specified days
     * of the week.
     */
    @JsonProperty(DOSAGE_FIELD_NAME)
    protected EmbeddableTimedDosage dosage;

    public WeekDaysDosage() {
        super(TimedDosageType.WEEK_DAYS);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != TimedDosageType.WEEK_DAYS) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage type must be WeekDays for a week days timed dosage object."
        ));

        if (weekdays == null || weekdays.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, WEEK_DAYS_FIELD_NAME),
                "The week days are missing but are mandatory for a week days dosage object."
        ));

        if (dosage == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DOSAGE_FIELD_NAME),
                "The timed dosage object is missing but it is required."
        ));

        return result;
    }

    @Override
    public void trim() {
        if (dosage != null) dosage.trim();
    }
}
