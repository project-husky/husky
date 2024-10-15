package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.LocalTime;

/**
 * Specifies a precise moment in time for a medication to be applied.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApplicationAtTime extends Application {
    protected static final String APPLICATION_TIME_FIELD_NAME = "dt";

    /**
     * Time of day when the medicament must be applied (hh:mm:ss). The time applies to the time zone of Switzerland:
     * GMT+2 (summer time) or GMT+1 (winter time).
     * The time format hh:mm is also supported (e.g. 08:00).
     */
    @JsonProperty(APPLICATION_TIME_FIELD_NAME)
    @JsonFormat(pattern = "HH:mm:ss")
    protected LocalTime applicationTime;

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = super.validate(basePath);

        if (applicationTime == null) result.add(getRequiredFieldValidationIssue(
                getFieldValidationPath(basePath, APPLICATION_TIME_FIELD_NAME),
                "The application time is missing, but it is mandatory."
        ));

        return result;
    }
}
