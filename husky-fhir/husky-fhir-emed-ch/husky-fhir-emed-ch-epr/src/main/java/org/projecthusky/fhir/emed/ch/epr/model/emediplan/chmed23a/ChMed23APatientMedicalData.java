package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.*;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed23APatientMedicalData extends EMediplanPatientMedicalData<ChMed23AExtension> implements ChMed23AExtendable {
    protected static final String PREMATURE_BABY_FIELD_NAME = "prem";
    protected static final String TIME_OF_GESTATION_FIELD_NAME = "toG";
    protected static final String LAST_MENSTRUATION_FIELD_NAME = "dLstMen";

    /**
     * First day of last menstruation, format: yyyy-mm-dd (ISO 86017 Date).
     * Only required in case of risk code 78, category code 3 (see {@link EMediplanRisk}).
     */
    @JsonProperty("dLstMen")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected @Nullable LocalDate lastMenstruation;
    /**
     * True if it is a premature baby (and only if age <= 18 months), false otherwise.
     */
    @JsonProperty(PREMATURE_BABY_FIELD_NAME)
    protected @Nullable Boolean prematureBaby;
    /**
     * The time of gestation, should usually only be filled if prematureBaby is true.
     * Format: {week}-{day}, week is a natural number including 0, day excluding 0.
     */
    @JsonProperty(TIME_OF_GESTATION_FIELD_NAME)
    protected @Nullable String timeOfGestation;
    /**
     * Risks per category. See {@link EMediplanRisk} and {@link EMediplanRiskList}.
     * <p>
     * If a risk category is specified but empty, is considered as explicitly excluded for the current patient.
     * If the category does not exist, the risks are considered to be unknown for the patient.
     * </p>
     */
    @JsonProperty("rcs")
    protected @Nullable List<@NonNull EMediplanRiskList> risks;
    /**
     * Weight in kg.
     */
    @JsonProperty("w")
    protected @Nullable Double weight;
    /**
     * Height in cm.
     */
    @JsonProperty("h")
    protected @Nullable Double height;
    /**
     * Extensions.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull ChMed23AExtension> extensions;

    @JsonIgnore
    @Override
    public String getPrematureBabyFieldName() {
        return PREMATURE_BABY_FIELD_NAME;
    }

    @JsonIgnore
    @Override
    public String getTimeOfGestationFieldName() {
        return TIME_OF_GESTATION_FIELD_NAME;
    }

    @JsonIgnore
    @Override
    public String getLastMenstruationFieldName() {
        return LAST_MENSTRUATION_FIELD_NAME;
    }

    public List<@NonNull EMediplanRiskList> getRisks() {
        if (risks == null) risks = new ArrayList<>();
        return risks;
    }

    @Override
    public List<@NonNull ChMed23AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    @Override @JsonIgnore
    public @Nullable Boolean isPrematureBaby() {
        return getPrematureBaby();
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (weight != null && (weight.isNaN() || weight.isInfinite() || weight <= 0.0)) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, "w"),
                "The patient's weight is not a valid positive decimal value."
        ));

        if (height != null && (height.isNaN() || height.isInfinite() || height <= 0.0)) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.VALUE,
                getFieldValidationPath(basePath, "h"),
                "The patient's height is not a valid positive decimal value."
        ));

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                risks != null && risks.stream().anyMatch(risk -> risk.hasExtensions(true))
        ));
    }
}
