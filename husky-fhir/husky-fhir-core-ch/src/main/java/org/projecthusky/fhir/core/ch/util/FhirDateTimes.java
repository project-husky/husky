package org.projecthusky.fhir.core.ch.util;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BaseDateTimeType;
import org.hl7.fhir.r4.model.DateTimeType;

import java.time.Instant;
import java.util.Objects;

import static java.util.Calendar.*;

/**
 * Helper utilities related to FHIR DateTime resources, based on {@link org.projecthusky.common.utils.time.DateTimes}.
 *
 * @see DateTimeType
 */
public class FhirDateTimes {
    private FhirDateTimes() {}

    /**
     * Takes a FHIR {@link BaseDateTimeType} element, sets the resolution to the fraction of seconds by
     * filling missing values to the end of the year, month, day, hour, minute and second if needed (i.e. sets it to the
     * latest instant covered by the partial date).
     * <p>
     * For instance, if the value "2019-03" is given, the day is fixed to the end of the month (the last of march) and
     * the time is set to the end of the day (usually 23:59:59), which results in: "2019-03-31T235959".
     * <p>
     * If the FHIR date time is already precise to the milliseconds, it will be returned as the equivalent Instant with
     * no further transformation.
     *
     * @param dateTime The FHIR date time element.
     * @return the full precision instant.
     */
    @Nullable
    @SuppressWarnings("fallthrough")
    public static Instant completeToLatestInstant(final BaseDateTimeType dateTime) {
        final var calendar = Objects.requireNonNull(dateTime).getValueAsCalendar();
        if (calendar == null) return null;
        switch (dateTime.getPrecision()) {
            case YEAR:
                calendar.set(MONTH, calendar.getActualMaximum(MONTH));
            case MONTH:
                calendar.set(DAY_OF_MONTH, calendar.getActualMaximum(DAY_OF_MONTH));
            case DAY:
                calendar.set(HOUR_OF_DAY, calendar.getActualMaximum(HOUR_OF_DAY));
                calendar.set(MINUTE, calendar.getActualMaximum(MINUTE));
            case MINUTE:
                calendar.set(SECOND, calendar.getActualMaximum(SECOND));
            case SECOND:
                calendar.set(MILLISECOND, calendar.getActualMaximum(MILLISECOND));
            case MILLI:
            default:
                break;
        }
        return calendar.toInstant();
    }
}
