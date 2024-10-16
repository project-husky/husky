package org.projecthusky.fhir.emed.ch.epr.model.emediplan.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepetitionDuration extends Repetition implements DurationBoundRepeatable {
    protected static final String DURATION_FIELD_NAME = "d";

    /**
     * The duration of the prescription defining in which time frame the prescription can be redeemed, e.g. the
     * prescription can be redeemed an undefined number of times within for instance 6 months duration.
     */
    @JsonProperty(DURATION_FIELD_NAME)
    private int duration;
    /**
     * The unit of the duration.
     */
    @JsonProperty("u")
    private TimeUnit durationUnit;

    public ValidationResult validate(final @Nullable String basePath) {
        return DurationBoundRepeatable.super.validate(getFieldValidationPath(basePath, DURATION_FIELD_NAME));
    }
}
