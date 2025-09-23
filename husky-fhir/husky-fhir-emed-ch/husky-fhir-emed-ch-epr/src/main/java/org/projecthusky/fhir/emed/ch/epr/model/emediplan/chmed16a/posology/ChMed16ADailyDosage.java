package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.List;

@Setter
public class ChMed16ADailyDosage implements EMediplanObject {
    public static final String FIELD_NAME = "D";

    protected @JsonIgnore @Nullable Double  morningDose, noonDose, eveningDose, nightDose;

    public double  getMorningDose() {
        if ( morningDose == null ) return 0f;
        return morningDose;
    }

    public double  getNoonDose() {
        if ( noonDose == null ) return 0f;
        return noonDose;
    }

    public double  getEveningDose() {
        if ( eveningDose == null ) return 0f;
        return eveningDose;
    }

    public double  getNightDose() {
        if ( nightDose == null ) return 0f;
        return nightDose;
    }

    @JsonValue
    public @Nullable List<@NonNull Double> getDoses() {
        if (nightDose != null) return List.of(getMorningDose(), getNoonDose(), getEveningDose(), getNightDose());
        if (eveningDose != null) return List.of(getMorningDose(), getNoonDose(), getEveningDose());
        if (noonDose != null) return List.of(getMorningDose(), getNoonDose());
        if (morningDose != null) return List.of(getMorningDose());
        return null;
    }

    @Override
    public ValidationResult validate(@Nullable String basePath) {
        final var result = new ValidationResult();

        if (getMorningDose() < 0 || getNoonDose() < 0 || getEveningDose() < 0 || getNightDose() < 0) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, FIELD_NAME),
                "All daily dosages must be equal or greater than 0."
        );

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }

    @Override
    public void trim() {
        if (nightDose != null && nightDose == 0f) nightDose = null;
        if (nightDose == null) {
            if (eveningDose != null && eveningDose == 0f) eveningDose = null;
            if (eveningDose == null) {
                if (noonDose != null && noonDose == 0f) noonDose = null;
                if (noonDose == null) {
                    if (morningDose != null) morningDose = null;
                }
            }
        }
    }
}
