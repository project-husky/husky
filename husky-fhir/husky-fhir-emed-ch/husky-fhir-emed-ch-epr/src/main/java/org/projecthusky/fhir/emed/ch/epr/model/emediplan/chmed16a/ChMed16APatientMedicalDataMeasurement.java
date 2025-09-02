package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AMeasurementType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16AMeasurementUnit;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChMed16APatientMedicalDataMeasurement implements EMediplanObject {
    protected static final String MEAS_TYPE_FIELD_NAME = "Type";
    protected static final String MEAS_VALUE_FIELD_NAME = "Val";
    protected static final String MEAS_UNIT_FIELD_NAME = "Unit";

    @JsonProperty(MEAS_TYPE_FIELD_NAME)
    protected ChMed16AMeasurementType type;
    @JsonProperty(MEAS_VALUE_FIELD_NAME)
    protected String value;
    @JsonProperty(MEAS_UNIT_FIELD_NAME)
    protected ChMed16AMeasurementUnit unit;

    @Override
    public ValidationResult validate(@Nullable String basePath) {
        ValidationResult validationResult = new ValidationResult();
        if (type == null) getRequiredFieldValidationIssue(MEAS_TYPE_FIELD_NAME, "The measurement type field is required but it is missing.");
        else {
            if (type == ChMed16AMeasurementType.HEIGHT && unit != ChMed16AMeasurementUnit.CENTIMETRE)
                validationResult.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.INVALID,
                        getFieldValidationPath(basePath, MEAS_UNIT_FIELD_NAME),
                        "If the measurement type is height, then the unit must be centimetre."
                ));
            if (type == ChMed16AMeasurementType.WEIGHT && unit != ChMed16AMeasurementUnit.KILOGRAM)
                validationResult.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.INVALID,
                        getFieldValidationPath(basePath, MEAS_UNIT_FIELD_NAME),
                        "If the measurement type is weight, then the unit must be kilogram."
                ));
        }
        if (unit == null) getRequiredFieldValidationIssue(MEAS_UNIT_FIELD_NAME, "The measurement unit field is required but it is missing.");
        if (value == null) getRequiredFieldValidationIssue(MEAS_VALUE_FIELD_NAME, "The value field is required but it is missing.");
        return validationResult;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }
}
