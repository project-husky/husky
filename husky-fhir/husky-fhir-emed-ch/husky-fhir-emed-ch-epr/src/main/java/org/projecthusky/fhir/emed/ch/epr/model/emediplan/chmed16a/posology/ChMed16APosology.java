package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan.EMEDIPLAN_TIMEZONE;
import static org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16ADailyDosage.FIELD_NAME;

/**
 * Describes when and what amount of medication must be taken.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed16APosology extends EMediplanPosology {
    // The default cycle value is 86400s, that is, one day.
    public static final int DEFAULT_CYCLE = 86400;
    protected static final String TAKING_TIMES_FIELD_NAME = "TT";
    protected static final String CYCLE_DURATION_FIELD_NAME = "CyDu";
    protected static final String START_FIELD_NAME = "DtFrom";
    protected static final String AS_NEEDED_FIELD_NAME = "InRes";

    /**
     * From date (start date of medication treatment), Format: YYYY-MM-DD (ISO 8601 Date) (e.g. 2016-01-16)
     */
    @JsonProperty(START_FIELD_NAME)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = EMEDIPLAN_TIMEZONE)
    protected @Nullable Instant start;
    /**
     * To date (end date of medication treatment), Format: YYYY-MM-DD (ISO 8601 Date). The DtTo must be considered as
     * inclusive. For example DtTo: 2015-05-01, the patient must apply the medicament also on 2015-05-01.
     */
    @JsonProperty("DtTo")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = EMEDIPLAN_TIMEZONE)
    protected @Nullable Instant end;

    /**
     * The cycle duration (cycle length) for posology in seconds
     * <p>
     * Default: 86'400 seconds => one day
     * </p></p>
     * Will be ignored if TT is not specified
     * </p>
     */
    @JsonProperty(CYCLE_DURATION_FIELD_NAME)
    protected @Nullable Integer cycle;

    /**
     * Reserve medication. 1 if in reserve, 0 otherwise. Default: 0
     */
    @JsonProperty(AS_NEEDED_FIELD_NAME)
    protected @Nullable Integer asNeeded;

    /**
     * Simplified version of taking times. Describes the doses to be applied in the morning, at noon, in the evening and at night.
     * Will be ignored if TT is specified
     */
    @JsonProperty(FIELD_NAME)
    protected @Nullable ChMed16ADailyDosage dailyDoses;

    /**
     * The list of complex taking times (to be used when the simplified dosing schedule (morning, noon, evening, night)
     * cannot be applied).
     */
    @JsonProperty(TAKING_TIMES_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16ATakingTime> takingTimes;

    public List<@NonNull ChMed16ATakingTime> getTakingTimes() {
        if (takingTimes == null) takingTimes = new ArrayList<>();
        return takingTimes;
    }

    @Override
    protected boolean isInReserve() {
        if (asNeeded == null) return DEFAULT_AS_NEEDED_VALUE;
        return asNeeded != 0;
    }

    public void setAsNeeded(@Nullable Boolean inReserve) {
        if (inReserve == null) asNeeded = null;
        else asNeeded = inReserve? 1 : 0;
    }

    @Override
    public ValidationResult validate(@Nullable String basePath) {
        final var result = super.validate(basePath);

        if (dailyDoses != null) {
            result.add(dailyDoses.validate());

            if (takingTimes != null && !takingTimes.isEmpty())
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.INVALID,
                        getFieldValidationPath(basePath, FIELD_NAME),
                        "Explicit daily doses in posology object will be ignored in the presence of explicit taking times."
                ));
        }

        if (takingTimes != null && !takingTimes.isEmpty()) {
            final var takingTimesIterator = takingTimes.listIterator();
            while (takingTimesIterator.hasNext()) {
                final var index = takingTimesIterator.nextIndex();
                final var takingTime = takingTimesIterator.next();
                final var validationPath = getFieldValidationPath(basePath, TAKING_TIMES_FIELD_NAME, index);
                result.add(takingTime.validate(validationPath));
                if (asNeeded != null && asNeeded == 1) {
                    if (takingTime.getAmount() == null)
                        result.add(getValidationIssue(
                                OperationOutcome.IssueSeverity.ERROR,
                                OperationOutcome.IssueType.INVALID,
                                getFieldValidationPath(validationPath, ChMed16ATakingTime.AMOUNT_FIELD_NAME),
                                "The taking time amount is mandatory when the posology is as needed (in reserve)."
                        ));
                } else {
                    if (takingTime.getInitialDose() == null)
                        result.add(getValidationIssue(
                                OperationOutcome.IssueSeverity.ERROR,
                                OperationOutcome.IssueType.INVALID,
                                getFieldValidationPath(validationPath, ChMed16ATakingTime.INITIAL_DOSE_FIELD_NAME),
                                "The taking time initial dose (DoFrom) is mandatory when the posology is not as needed (i.e. not in reserve)."
                        ));
                }
            }
        }

        if (cycle != null) {
            if (cycle < 0) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    getFieldValidationPath(basePath, CYCLE_DURATION_FIELD_NAME),
                    "The cycle duration is specified in seconds and cannot be lower than 0."
            ));

            if (takingTimes == null || takingTimes.isEmpty())
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.INVALID,
                        getFieldValidationPath(basePath, CYCLE_DURATION_FIELD_NAME),
                        "Explicit cycle duration will be ignored in the absence of taking times in the posology."
                ));
        }

        return result;
    }

    /**
     * Performs validation of the eMediplan object taking into account whether it belongs to an eMediplan medication
     * plan document or to an eMediplan prescription document. This performs the base checks of {@link #validate(String)}
     * plus extra validation checks tied to the eMediplan document type.
     *
     * @param basePath     The base path of the object.
     * @param mediplanType The type of eMediplan document.
     * @return The validation result.
     */
    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validate(basePath);

        if (Objects.requireNonNull(mediplanType) != EMediplanType.MEDICATION_PLAN) {
            if (start == null && mediplanType == EMediplanType.POLYMEDICATION_CHECK) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, START_FIELD_NAME),
                    "The start date of the posology is mandatory for medication plan and polimedication check documents."
            ));

            if (cycle != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, CYCLE_DURATION_FIELD_NAME),
                    String.format("The posology object specifies a cycle duration, but this is not expected for the type of document %s.", mediplanType.name())
            ));

            if (asNeeded != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, AS_NEEDED_FIELD_NAME),
                    String.format("The posology object specifies whether the treatment is in reserve, but this is not expected for the type of document %s.", mediplanType.name())
            ));

            if (takingTimes != null) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, TAKING_TIMES_FIELD_NAME),
                    String.format("The posology object specifies taking times, but this is not expected for the type of document %s.", mediplanType.name())
            ));
        } else {
            if (start == null) result.add(getRequiredFieldValidationIssue(
                    getFieldValidationPath(basePath, START_FIELD_NAME),
                    "The start date of the posology is mandatory for medication plan and polimedication check documents."
                ));
        }

        return result;
    }

    @Override
    public void trim() {
        super.trim();
        if (takingTimes != null && !takingTimes.isEmpty()) takingTimes.forEach(ChMed16ATakingTime::trim);
        if (dailyDoses != null) {
            if (takingTimes != null && !takingTimes.isEmpty()) dailyDoses = null;
            else dailyDoses.trim();
        }
        if (cycle != null && (cycle == DEFAULT_CYCLE || takingTimes == null || takingTimes.isEmpty())) cycle = null;
        if (asNeeded != null && isInReserve() == DEFAULT_AS_NEEDED_VALUE) asNeeded = null;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth &&
                ((dailyDoses != null && dailyDoses.hasExtensions(true)) ||
                        (takingTimes != null && takingTimes.stream().anyMatch(t -> t.hasExtensions(true))));
    }
}
