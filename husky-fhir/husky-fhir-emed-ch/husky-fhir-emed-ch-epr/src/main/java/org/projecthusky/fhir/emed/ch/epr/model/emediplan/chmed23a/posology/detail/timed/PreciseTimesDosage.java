package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.application.ApplicationAtTime;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.List;

/**
 * Specifies precise times when a medication must be applied. This is named simply Times in ChMed23A.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PreciseTimesDosage extends EmbeddableTimedDosage {
    protected static final String APPLICATIONS_FIELD_NAME = "ts";

    /**
     * Specifies the dosage to be applied at a certain time.
     */
    @JsonProperty(APPLICATIONS_FIELD_NAME)
    protected List<@NonNull ApplicationAtTime> applications;

    public PreciseTimesDosage() {
        super(TimedDosageType.TIMES);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != TimedDosageType.TIMES) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage type must be Times for a times timed dosage object."
        ));

        if (applications == null || applications.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, APPLICATIONS_FIELD_NAME),
                "The precise application times list is missing or it is empty, but it is mandatory and should have at last one element."
        ));
        else {
            final var applicationsIterator = applications.listIterator();
            while (applicationsIterator.hasNext()) {
                final var index = applicationsIterator.nextIndex();
                result.add(applicationsIterator.next().validate(getFieldValidationPath(basePath, APPLICATIONS_FIELD_NAME)));
            }
        }

        return result;
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return inDepth && applications != null && applications.stream().anyMatch(application -> application.hasExtensions(true));
    }

    @Override
    public void trim() {
        if (applications != null && !applications.isEmpty()) applications.forEach(ApplicationAtTime::trim);
    }
}
