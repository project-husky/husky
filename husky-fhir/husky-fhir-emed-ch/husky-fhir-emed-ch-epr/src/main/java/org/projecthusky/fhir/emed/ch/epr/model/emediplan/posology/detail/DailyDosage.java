package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanMedicament;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Describes when (morning, moon, evening, night) and how much of a medication must be applied daily, in a structured
 * form.
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Getter
@Setter
public class DailyDosage extends PosologyDetail {
    protected static final String DOSES_FIELD_NAME = "ds";

    /**
     * The doses specify the amount of the medication to be applied in a day segment.
     * <p>
     * Doses must contain exactly 4 decimal values, and they must all be equal or greater than 0.
     * </p>
     * Note that the unit of dosage is specified at the {@link EMediplanMedicament} level.
     */
    protected @JsonIgnore double  morningDose, noonDose, eveningDose, nightDose;

    public DailyDosage() {
        super(PosologyType.DAILY);
    }

    @JsonGetter(DOSES_FIELD_NAME)
    public double[] getDoses() {
        return new double[] {morningDose, noonDose, eveningDose, nightDose};
    }

    @JsonSetter(DOSES_FIELD_NAME)
    public void setDoses(double[] doses) {
        if (doses.length != 4) throw new RuntimeException("DailyDosage expects exactly an array of 4 doses to be set, received " + doses.length + ".");
        morningDose = doses[0];
        noonDose = doses[1];
        eveningDose = doses[2];
        nightDose = doses[3];
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != PosologyType.DAILY) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, POSOLOGY_TYPE_FIELD_NAME),
                "The posology type is daily but the object is not daily."
        );

        if (morningDose < 0 || noonDose < 0 || eveningDose < 0 || nightDose < 0) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, DOSES_FIELD_NAME),
                "All daily dosages must be equal or greater than 0."
        );

        return result;
    }
}
