package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanIdentifier;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.PatientIdType;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed23APatientId implements EMediplanIdentifier {
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

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }

    public static ChMed23APatientId fromFhirIdentifier(final Identifier identifier) {
        return new ChMed23APatientId(
            CodeSystems.SWISS_VEKA_NR.getCodeSystemId().equalsIgnoreCase(Oids.normalize(identifier.getSystem()))?
                PatientIdType.INSURANCE_CARD_NUMBER : PatientIdType.LOCAL_PID,
            identifier.getSystem(),
            identifier.getValue()
        );
    }

    @Override @ExpectsValidResource
    public Identifier toFhir() {
        if (type == null) throw new InvalidEmedContentException("The patient id type must be specified.");
        if (value == null || value.isBlank()) throw new InvalidEmedContentException("The patient id cannot be null or empty.");
        return switch(type) {
            case INSURANCE_CARD_NUMBER ->
                    (new Identifier()).setSystem(Oids.PREFIX_OID + CodeSystems.SWISS_VEKA_NR.getCodeSystemId()).setValue(value);
            case LOCAL_PID -> {
                if (system == null || system.isBlank()) throw new InvalidEmedContentException("The patient id system cannot be null or empty for local PIDs.");
                final var fhirSystem = Oids.match(system)? Oids.PREFIX_OID + Oids.normalize(system) : system;
                yield (new Identifier()).setSystem(fhirSystem).setValue(value);
            }
        };
    }
}
