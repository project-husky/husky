package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Period;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.TimeUnit;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        return DurationBoundRepeatable.super.validate(getFieldValidationPath(basePath, DURATION_FIELD_NAME));
    }

    /**
     * Gets a repetition duration object from a FHIR period, if such a thing would make sense. Note that:
     * <ul>
     *     <li>Periods shorter than a day will result on a null object.</li>
     *     <li>If the period can be rounded to years, without a remainder in months, or to months without a remainder
     *         in days, any lesser remainder will be ignored. E.g. if a period is 1 year, 1 month and 2 seconds, it
     *         will be rounded to 13 months. If a period is 1 year 0 month and 2 days, it will be rounded to 1 year.</li>
     * </ul>
     *
     * @param period The FHIR period to be converted to a RepetitionDuration.
     * @return The repetition duration object.
     */
    public static @Nullable RepetitionDuration fromFhirPeriod(final Period period) {
        if (period.hasStart() && period.hasEnd()) {
            final var start = period.getStartElement().getValueAsCalendar().toInstant();
            final var end = period.getEndElement().getValueAsCalendar().toInstant();

            final var javaPeriod = java.time.Period.between(
                    LocalDate.ofInstant(end, ZoneId.systemDefault()),
                    LocalDate.ofInstant(start, ZoneId.systemDefault())
            );
            if (!javaPeriod.isNegative()) {
                if (javaPeriod.getYears() > 0 && javaPeriod.getMonths() == 0)
                    return new RepetitionDuration(javaPeriod.getYears(), TimeUnit.YEAR);
                if (javaPeriod.getMonths() > 0 && javaPeriod.getDays() == 0)
                    return new RepetitionDuration(javaPeriod.getYears() * 12 + javaPeriod.getMonths(), TimeUnit.MONTH);
                final var duration = Duration.between(end, start);
                final var days = (int) duration.toDays();
                if (days > 0) {
                    if (days % 7 == 0) return new RepetitionDuration(days / 7, TimeUnit.WEEK);
                    return new RepetitionDuration(days, TimeUnit.DAY);
                }
            }
        }
        return null;
    }
}
