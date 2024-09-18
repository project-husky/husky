package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DaySegment;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

/**
 * Specifies a day segment (morning, noon, evening or night) when a medication must be applied.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ApplicationInSegment extends Application {
    protected final static String SEGMENT_FIELD_NAME = "s";

    @JsonProperty(SEGMENT_FIELD_NAME)
    protected DaySegment segment;

    public ApplicationInSegment(final EMediplanDose dose, final DaySegment segment) {
        super( dose );
        this.segment = segment;
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (segment == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, SEGMENT_FIELD_NAME),
                "The day segment is missing but it is mandatory."
        ));

        return result;
    }
}
