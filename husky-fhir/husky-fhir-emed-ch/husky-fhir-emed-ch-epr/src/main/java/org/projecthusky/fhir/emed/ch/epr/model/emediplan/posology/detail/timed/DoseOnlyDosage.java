package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Specifies a dosage without specifying a precise moment for the intake.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DoseOnlyDosage extends EmbeddableTimedDosage {
    protected static final String DOSE_FIELD_NAME = "do";

    /**
     * Specifies the dose to be applied.
     */
    @JsonProperty(DOSE_FIELD_NAME)
    protected EMediplanDose dose;

    public DoseOnlyDosage () {
        super(TimedDosageType.DOSAGE_ONLY);
    }

    public DoseOnlyDosage(final EMediplanDose dose) {
        super(TimedDosageType.DOSAGE_ONLY);
        this.dose = dose;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != TimedDosageType.DOSAGE_ONLY) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage type must be DosageOnly for a dosage only object."
        ));

        if (dose == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, DOSE_FIELD_NAME),
                "The dosage object is missing but it is required."
        ));
        else result.add(dose.validate(getFieldValidationPath(basePath, DOSE_FIELD_NAME)));

        return result;
    }

    @Override
    public void trim() {
        if (dose != null) dose.trim();
    }
}
