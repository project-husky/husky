package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.RiskCategory;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Data
public class EMediplanPatientMedicalData implements EMediplanExtendable, EMediplanObject {
    public final static Pattern TIME_OF_GESTATION_PATTERN = Pattern.compile("[0-3]?[0-9]-[1-6]?");

    protected static final String PREMATURE_BABY_FIELD_NAME = "prem";

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
    @JsonProperty("toG")
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
    protected @Nullable List<@NonNull EMediplanExtension> extensions;

    public List<@NonNull EMediplanRiskList> getRisks() {
        if (risks == null) risks = new ArrayList<>();
        return risks;
    }

    @Override
    public List<@NonNull EMediplanExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (!getRisks().isEmpty()) {
            final var risksIterator = getRisks().listIterator();
            while(risksIterator.hasNext()) {
                final var index = risksIterator.nextIndex();
                result.add(risksIterator.next().validate(getFieldValidationPath(basePath, "rcs", index)));
            }

            if (risks.stream().anyMatch(riskList -> riskList.getCategory() == RiskCategory.REPRODUCTION && riskList.getRisks().stream().anyMatch(risk -> risk.getCode() == 78)) && lastMenstruation == null)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.REQUIRED,
                        getFieldValidationPath(basePath, "dLstMen"),
                        "The date of the last menstruation is missing but should be included due to having risk 78."
                ));
        }

        if (timeOfGestation != null && !timeOfGestation.isBlank()) {
            if (prematureBaby == null || !prematureBaby) result.add( getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath, "toG"),
                    "The time of gestation is present but should normally be included only for a premature baby."
            ));

            if (!TIME_OF_GESTATION_PATTERN.matcher(timeOfGestation).matches()) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath, "toG"),
                    "The time of gestation is not in the good format.Format: {week}-{day}, week is a natural number including 0, day excluding 0."
            ));
        }

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

        if (!getExtensions().isEmpty()) {
            final var extsIterator = getExtensions().listIterator();
            while (extsIterator.hasNext()) {
                final var index = extsIterator.nextIndex();
                result.add(extsIterator.next().validate(getFieldValidationPath(basePath, "exts",index)));
            }
        }

        return result;
    }

    /**
     * Performs context-aware validation of the object, including the base context-unaware validation.
     *
     * @param basePath The object's JSON path.
     * @param age      The age of the patient at the time of the document creation.
     * @return         The validation result.
     */
    public ValidationResult validate(final @Nullable String basePath, final @Nullable Period age) {
        final var result = validate(basePath);

        if (age != null && prematureBaby != null && age.getMonths() > 18) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, PREMATURE_BABY_FIELD_NAME),
                "The premature baby flag is present but the age of the patient at the time of the document creation is greater than 18 months. The flag should not be present."
        ));

        return result;
    }

    @Override
    public void trim() {
        getRisks().forEach(EMediplanRiskList::trim);
        getExtensions().forEach(EMediplanExtension::trim);
    }

    /**
     * Convenience method to add a risk to a medical data object. It will search for the appropriate list per category
     * to which to append the new risk and, if the category does not exist in the list, it creates it.
     * @param risk The risk to be added to the lists of risks.
     */
    @ExpectsValidResource
    public void addRisk(final EMediplanRisk risk) {
        if (risks == null) {
            risks = new ArrayList<>();
            risks.add(new EMediplanRiskList(risk.getCategory(), risk));
        } else {
            risks.stream().filter(riskList -> riskList.getCategory().equals(risk.getCategory())).findAny()
                    .ifPresentOrElse(
                            riskList -> riskList.getRisks().add(risk),
                            () -> risks.add(new EMediplanRiskList(risk.getCategory(), risk))
                    );
        }
    }
}
