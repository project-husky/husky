package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PatientIdType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMediplanPatientId implements EMediplanObject {
    protected PatientIdType type;
    @JsonProperty("sId")
    protected @Nullable String system;
    @JsonProperty("val")
    protected String value;

    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (type == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath,"type"),
                "The patient's id type is missing but it is required."
            ));
        else {
            switch (type) {
                case INSURANCE_CARD_NUMBER -> {
                    if (system != null && !system.isBlank()) result.add(getIgnoredFieldValidationIssue(
                            getFieldValidationPath(basePath, "system"),
                            "The patient's id system should not be included if the id type is an insurance card number."
                    ));
                }
                case LOCAL_PID -> {
                    if (system == null || system.isBlank()) result.add(getRequiredFieldValidationIssue(
                            getFieldValidationPath(basePath,"sId"),
                            "The patient's id has no system but it is required for a local PID."
                    ));
                }
            }
        }

        if (value == null || value.isBlank()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, "value"),
                "The patient's id value is missing but it is required."
        ));

        return result;
    }

    public static EMediplanPatientId fromFhirIdentifier(final Identifier identifier) {
        return new EMediplanPatientId(
            CodeSystems.SWISS_VEKA_NR.getCodeSystemId().equalsIgnoreCase(Oids.normalize(identifier.getSystem()))?
                PatientIdType.INSURANCE_CARD_NUMBER : PatientIdType.LOCAL_PID,
            identifier.getSystem(),
            identifier.getValue()
        );
    }
}
