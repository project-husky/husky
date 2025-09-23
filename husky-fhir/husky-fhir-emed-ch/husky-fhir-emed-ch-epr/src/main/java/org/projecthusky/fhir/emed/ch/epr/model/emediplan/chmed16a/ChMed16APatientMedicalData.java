package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPatientMedicalData;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanRisk;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanRiskList;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed16APatientMedicalData extends EMediplanPatientMedicalData<ChMed16AExtension> implements ChMed16AExtendable {
    protected static final String PREMATURE_BABY_FIELD_NAME = "Prem";
    protected static final String TIME_OF_GESTATION_FIELD_NAME = "ToG";
    protected static final String LAST_MENSTRUATION_FIELD_NAME = "DLstMen";
    protected static final String MEASUREMENTS_FIELD_NAME = "Meas";

    /**
     * First day of last menstruation, format: yyyy-mm-dd (ISO 86017 Date).
     * Only required in case of risk code 78, category code 3 (see {@link EMediplanRisk}).
     */
    @JsonProperty("dLstMen")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected @Nullable LocalDate lastMenstruation;
    /**
     * 1 if it is a premature baby, 0 otherwise (only if age <= 18 months)
     */
    @JsonProperty(PREMATURE_BABY_FIELD_NAME)
    protected @Nullable Integer prematureBaby;

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
    @JsonProperty("Rc")
    protected @Nullable List<@NonNull EMediplanRiskList> risks;

    @JsonProperty(MEASUREMENTS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16APatientMedicalDataMeasurement> measurements;

    @JsonProperty(ChMed16AExtension.EXTENSIONS_FIELD_NAME)
    protected @Nullable List<@NonNull ChMed16AExtension> extensions;

    /**
     * Whether the patient is a premature baby or not. Take into account that calling this method makes sense only when
     * the age of the patient is lesser or equal than 18 months, but this method does not perform any such checks and
     * will return the result solely based on the content of the underlying property.
     *
     * @return <ul>
     *          <li>{@code true} if the eMediplan document explicitly declares the baby to be premature</li>
     *          <li>{@code false} if the eMediplan document explicitly declares the baby not to be premature</li>
     *          <li>{@code null} if there is no explicit declaration or if there is but its content is not valid (i.e.
     *              neither {@code 0} nor {@code 1})</li>
     *         </ul
     */
    @JsonIgnore @Override
    public @Nullable Boolean isPrematureBaby() {
        if (prematureBaby == null) return null;
        else {
            return switch (prematureBaby) {
                case 1 -> true;
                case 0 -> false;
                default -> null;
            };
        }
    }

    public String getPrematureBabyFieldName() {
        return PREMATURE_BABY_FIELD_NAME;
    }

    public String getTimeOfGestationFieldName() {
        return TIME_OF_GESTATION_FIELD_NAME;
    }

    public String getLastMenstruationFieldName() {
        return LAST_MENSTRUATION_FIELD_NAME;
    }

    public @Nullable Boolean getPrematureBaby() {
        return prematureBaby == null ? null : prematureBaby != 0;
    }

    public List<@NonNull EMediplanRiskList> getRisks() {
        if (risks == null) risks = new ArrayList<>();
        return risks;
    }

    public List<@NonNull ChMed16APatientMedicalDataMeasurement> getMeasurements() {
        if (measurements == null) measurements = new ArrayList<>();
        return measurements;
    }

    @Override
    public List<@NonNull ChMed16AExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    public ChMed16APatientMedicalData addMeasurement(final ChMed16APatientMedicalDataMeasurement measurement) {
        getMeasurements().add(Objects.requireNonNull(measurement));
        return this;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (prematureBaby != null && (prematureBaby < 0 || prematureBaby > 1))
            result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.CODEINVALID,
                    getFieldValidationPath(basePath, getPrematureBabyFieldName()),
                    "The premature baby field is numeric and its value must be either 0 (false) or 1 (true)."
                    ));

        if (!getMeasurements().isEmpty()) {
            final var measIterator = getMeasurements().listIterator();
            while (measIterator.hasNext()) {
                final var index = measIterator.nextIndex();
                result.add(measIterator.next().validate(getFieldValidationPath(basePath, MEASUREMENTS_FIELD_NAME,index)));
            }
        }

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return (extensions != null && !extensions.isEmpty()) || (inDepth && (
                (risks != null && risks.stream().anyMatch(risk -> risk.hasExtensions(true))) ||
                (measurements != null && measurements.stream().anyMatch(meas -> meas.hasExtensions(true)))
                ));
    }

    @Override
    public void trim() {
        super.trim();
        if (measurements != null) measurements.forEach(ChMed16APatientMedicalDataMeasurement::trim);
    }
}
