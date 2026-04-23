package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanObject;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Duration;
import java.time.Instant;

public interface DurationBoundRepeatable extends EMediplanObject {
    int getDuration();
    TimeUnit getDurationUnit();

    @Override
    default ValidationResult validate(final @Nullable String basePath) {
        final ValidationResult result = new ValidationResult();
        if (getDuration() <= 0.0) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.VALUE,
                basePath == null ? "" : basePath,
                "A repetition's duration cannot be equal or lesser than 0."
        ));
        return result;
    }

    /**
     * Gets the value of the duration binding as a Java {@link java.time.temporal.TemporalAmount}; more specifically as
     * a {@link Duration}.
     * <p>
     *     Note that in the case of a duration specified in months, this method will consider all months to be 30 days
     *     for computing the temporal amount. In the case of a duration specified in years, it will consider all years
     *     to consist of 365 days for computing the temporal amount.
     * </p>
     *
     * @return The {@link Duration} representation.
     */
    default Duration getTemporalAmount() {
        return switch(getDurationUnit()) {
            case SECOND -> Duration.ofSeconds(getDuration());
            case MINUTE -> Duration.ofMinutes(getDuration());
            case HOUR -> Duration.ofHours(getDuration());
            case DAY -> Duration.ofDays(getDuration());
            case WEEK -> Duration.ofDays(getDuration() * 7L);
            case MONTH -> Duration.ofDays(getDuration() * 30L);
            case YEAR -> Duration.ofDays(getDuration() * 365L);
        };
    }

    /**
     * Gets the end of the duration binding from a received start timestamp.
     */
    default Instant getEnd(final Instant start) {
        return start.plus(getTemporalAmount());
    }
}
