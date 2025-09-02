package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Pattern;

public abstract class EMediplanPatientMedicalData<E extends EMediplanObject> implements EMediplanExtendable<E> {
    public final static Pattern TIME_OF_GESTATION_PATTERN = Pattern.compile("[0-3]?[0-9]-[1-6]?");

    public abstract @Nullable LocalDate getLastMenstruation();
    public abstract @Nullable String getTimeOfGestation();
    public abstract List<@NonNull EMediplanRiskList> getRisks();

    /**
     * Whether the patient is a premature baby or not. Take into account that calling this method makes sense only when
     * the age of the patient is lesser or equal than 18 months, but this method does not perform any such checks and
     * will return the result solely based on the content of the underlying property.
     *
     * @return <ul>
     *          <li>{@code true} if the eMediplan document explicitly declares the baby to be premature</li>
     *          <li>{@code false} if the eMediplan document explicitly declares the baby not to be premature</li>
     *          <li>{@code null} otherwise</li>
     *         </ul
     */
    public abstract @Nullable Boolean isPrematureBaby();

    @JsonIgnore
    protected abstract String getPrematureBabyFieldName();
    @JsonIgnore
    protected abstract String getTimeOfGestationFieldName();
    @JsonIgnore
    protected abstract String getLastMenstruationFieldName();

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = validateExtensions(basePath);

        if (!getRisks().isEmpty()) {
            final var risksIterator = getRisks().listIterator();
            while(risksIterator.hasNext()) {
                final var index = risksIterator.nextIndex();
                result.add(risksIterator.next().validate(getFieldValidationPath(basePath, "rcs", index)));
            }

            if (getRisks().stream().anyMatch(riskList -> riskList.getCategory() == RiskCategory.REPRODUCTION && riskList.getRisks().stream().anyMatch(risk -> risk.getCode() == 78)) && getLastMenstruation() == null)
                result.add(getValidationIssue(
                        OperationOutcome.IssueSeverity.WARNING,
                        OperationOutcome.IssueType.REQUIRED,
                        getFieldValidationPath(basePath, getLastMenstruationFieldName()),
                        "The date of the last menstruation is missing but should be included due to having risk 78."
                ));
        }

        if (getTimeOfGestation() != null && !getTimeOfGestation().isBlank()) {
            final var isPrematureBaby = isPrematureBaby();
            if (isPrematureBaby == null || !isPrematureBaby) result.add( getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath,  getTimeOfGestationFieldName()),
                    "The time of gestation is present but should normally be included only for a premature baby."
            ));

            if (!TIME_OF_GESTATION_PATTERN.matcher(getTimeOfGestation()).matches()) result.add(getValidationIssue(
                    OperationOutcome.IssueSeverity.WARNING,
                    OperationOutcome.IssueType.VALUE,
                    getFieldValidationPath(basePath, getTimeOfGestationFieldName()),
                    "The time of gestation is not in the good format.Format: {week}-{day}, week is a natural number including 0, day excluding 0."
            ));
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

        if (age != null && isPrematureBaby() != null && age.getMonths() > 18) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.WARNING,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, getPrematureBabyFieldName()),
                "The premature baby flag is present but the age of the patient at the time of the document creation is greater than 18 months. The flag should not be present."
        ));

        return result;
    }

    @Override
    public void trim() {
        EMediplanExtendable.super.trim();
        getRisks().forEach(EMediplanRiskList::trim);
    }

    /**
     * Convenience method to add a risk to a medical data object. It will search for the appropriate list per category
     * to which to append the new risk and, if the category does not exist in the list, it creates it.
     * @param risk The risk to be added to the lists of risks.
     */
    @ExpectsValidResource
    public void addRisk(final EMediplanRisk risk) {
        getRisks().stream().filter(riskList -> riskList.getCategory().equals(risk.getCategory())).findAny()
                .ifPresentOrElse(
                        riskList -> riskList.getRisks().add(risk),
                        () -> getRisks().add(new EMediplanRiskList(risk.getCategory(), risk))
                );
    }
}
