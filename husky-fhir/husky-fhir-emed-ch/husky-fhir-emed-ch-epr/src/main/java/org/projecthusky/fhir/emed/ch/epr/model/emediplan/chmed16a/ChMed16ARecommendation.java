package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.ChMed16ARecommendationId;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Model of a polymedication check recommendation.
 */
@Data
public class ChMed16ARecommendation implements EMediplanObject {
    protected static final String ID_FIELD = "Id";
    protected static final String AGREED_FIELD = "PatAgr";
    protected static final String REMARK_FIELD = "Rmk";

    /**
     * The ID or description of the recommendation.
     */
    @JsonProperty(ID_FIELD)
    protected ChMed16ARecommendationId id;
    /**
     * 1 if patient agrees, 0 otherwise.
     */
    @JsonProperty(AGREED_FIELD)
    protected @Nullable Integer patientAgrees;
    /**
     * Remarks on the PolymedicationCheck.
     */
    @JsonProperty(REMARK_FIELD)
    protected @Nullable String remarks;

    @Override
    public ValidationResult validate(@Nullable String basePath) {
        final var result = new ValidationResult();

        if (id == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, ID_FIELD),
                "The recommendation id is required, but it is missing."
        ));

        if (patientAgrees != null && (patientAgrees < 0 || patientAgrees > 1)) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, AGREED_FIELD),
                String.format("The %s field must be either 0 or 1, but %d was found.", AGREED_FIELD, patientAgrees)
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }
}
