package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.EmbeddableTimedDosage;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Describes a single application of a medicament.
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Getter
@Setter
public class SingleDosage extends PosologyDetail {
    protected final static String TIMED_DOSAGE_FIELD_NAME = "tdo";
    /**
     * Specifies the timing and dose of a medication to be applied.
     */
    @JsonProperty(TIMED_DOSAGE_FIELD_NAME)
    protected EmbeddableTimedDosage timedDosage;

    public SingleDosage() {
        super(PosologyType.SINGLE);
    }

    public SingleDosage(final EmbeddableTimedDosage dosage) {
        this();
        timedDosage = dosage;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != PosologyType.SINGLE) getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, POSOLOGY_TYPE_FIELD_NAME),
                "The posology type is single but the object is not single."
        );

        if (timedDosage == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME),
                "The timed dosage object is missing but it is required for a timed dosage posology object."
        ));
        else result.add(timedDosage.validate(getFieldValidationPath(basePath, TIMED_DOSAGE_FIELD_NAME)));

        return result;
    }

    @Override
    public void trim() {
        if (timedDosage != null) timedDosage.trim();
    }
}
