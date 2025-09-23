package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
public class ChMed16ATakingTime implements EMediplanObject {
    public static final String AMOUNT_FIELD_NAME = "A";
    public static final String INITIAL_DOSE_FIELD_NAME = "DoFrom";
    protected static final String MAXIMUM_AMOUNT_FIELD_NAME = "MA";
    protected static final String OFFSET_FIELD_NAME = "Off";
    protected static final String DURATION_FIELD_NAME = "Du";

    /**
     * The offset (in seconds) for the Taking Time after cycle start.
     * <p>
     * First cycle starts at DtFrom = dd.MM.yyyy 00:00:00 (midnight)</p>
     */
    @JsonProperty(OFFSET_FIELD_NAME)
    protected int offset;
    /**
     * Duration of the medication application in seconds (e.g. 0 for a pill, 1'800 for an intravenous medication
     * infusion of 30 minutes). Default: 0.
     */
    @JsonProperty(DURATION_FIELD_NAME)
    protected @Nullable Integer duration;
    /**
     * Dose from (starting dose) Required if InRes = 0
     */
    @JsonProperty(INITIAL_DOSE_FIELD_NAME)
    protected @Nullable Double initialDose;
    /**
     * Dose to (ending dose).
     * Default: DoFrom
     */
    @JsonProperty("DoTo")
    protected @Nullable Double finalDose;
    /**
     * Amount. Required if InRes = 1
     */
    @JsonProperty(AMOUNT_FIELD_NAME)
    protected @Nullable Double amount;
    /**
     * Maximum amount per cycle.
     */
    @JsonProperty(MAXIMUM_AMOUNT_FIELD_NAME)
    protected @Nullable Double maximumDose;

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (offset < 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, OFFSET_FIELD_NAME),
                "The offset cannot be lesser than 0."
        ));

        if (duration != null && duration < 0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, DURATION_FIELD_NAME),
                "The application duration cannot be lesser than 0."
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }

    @Override
    public void trim() {
        if (duration != null && duration == 0) duration = null;
        if (finalDose != null && finalDose.equals(initialDose)) finalDose = null;
    }
}
