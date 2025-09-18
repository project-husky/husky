package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed16APatientId implements EMediplanObject {
    public static final int PATIENT_ID_TYPE_INSURANCE_CARD = 1;
    protected static final String TYPE_FIELD_NAME = "Type";

    /**
     * Type of the ID
     * Possible values
     * 1: Insurance card number
     */
    @JsonProperty(TYPE_FIELD_NAME)
    protected Integer type;
    /**
     * The ID value
     */
    @JsonProperty("Val")
    protected String value;

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (type == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath,TYPE_FIELD_NAME),
                "The patient's id type is missing but it is required."
        ));
        else if (type != PATIENT_ID_TYPE_INSURANCE_CARD) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.CODEINVALID,
                getFieldValidationPath(basePath, TYPE_FIELD_NAME),
        "The patient id's type must be 1 (insurance card)."
        ));

        if (value == null || value.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "value"),
                "The patient's id value is missing but it is required."
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }

    /**
     * Converts a FHIR identifier to a ChMed16APatientId.
     * @param identifier The FHIR identifier to be converted.
     * @return A ChMed16APatientId object with the Swiss insurance card number contained in the FHIR identifier. If the
     *         FHIR identifier does not contain a recognizable Swiss insurance card number, {@code null}.
     */
    public static @Nullable ChMed16APatientId fromFhirIdentifier(final Identifier identifier) {
        return CodeSystems.SWISS_VEKA_NR.getCodeSystemId().equalsIgnoreCase(Oids.normalize(identifier.getSystem()))?
                new ChMed16APatientId(PATIENT_ID_TYPE_INSURANCE_CARD, identifier.getValue())
                : null;
    }
}
