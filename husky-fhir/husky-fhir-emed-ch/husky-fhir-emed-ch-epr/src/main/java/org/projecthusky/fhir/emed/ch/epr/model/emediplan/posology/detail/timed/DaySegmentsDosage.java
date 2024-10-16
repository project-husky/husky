package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimedDosageType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application.ApplicationInSegment;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Specifies the day segment (morning, noon, evening, night) when a medication should be applied. This is called
 * DaySegments by ChMed23A.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DaySegmentsDosage extends EmbeddableTimedDosage {
    protected final static String APPLICATIONS_FIELD_NAME = "ss";

    /**
     * Specifies the dosage to be applied per day segment.
     */
    @JsonProperty(APPLICATIONS_FIELD_NAME)
    protected List<@NonNull ApplicationInSegment> applications;

    public DaySegmentsDosage() {
        super(TimedDosageType.DAY_SEGMENTS);
        getApplications();
    }

    public List<@NonNull ApplicationInSegment> getApplications() {
        if (applications == null) applications = new ArrayList<>();
        return applications;
    }

    public void addApplication(final ApplicationInSegment application) {
        getApplications().add(application);
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (type != null && type != TimedDosageType.DAY_SEGMENTS) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                getFieldValidationPath(basePath, TIMED_DOSAGE_TYPE_FIELD_NAME),
                "The timed dosage type must be DaySegments for a day segments timed dosage object."
        ));

        if (applications == null || applications.isEmpty()) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, APPLICATIONS_FIELD_NAME),
                "The application in segments list is missing or empty, but it is required."
        ));
        else {
            final var applicationsIterator = applications.listIterator();
            while (applicationsIterator.hasNext()) {
                final var index = applicationsIterator.nextIndex();
                result.add(applicationsIterator.next().validate(getFieldValidationPath(basePath, APPLICATIONS_FIELD_NAME, index)));
            }
        }

        return result;
    }

    @Override
    public void trim() {
        if (applications != null && !applications.isEmpty()) applications.forEach(ApplicationInSegment::trim);
    }
}
