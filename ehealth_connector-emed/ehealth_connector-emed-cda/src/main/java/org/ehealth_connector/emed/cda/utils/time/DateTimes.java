package org.ehealth_connector.emed.cda.utils.time;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.TS;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

/**
 * Helper utilities related to HL7 DateTime (DTM) resources.
 *
 * @see Hl7Dtm
 * @author Quentin Ligier
 */
public final class DateTimes {

    /**
     * The HL7 V2.5 Date Time (DTM) format.
     */
    private static final DateTimeFormatter HL7_DATETIME_FORMATTER =
        DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC);

    /**
     * The TS.CH.TZ (TS) date time format.
     */
    private static final DateTimeFormatter TS_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ")
        .withZone(ZoneOffset.UTC);

    /**
     * The TS.CH.TZ (TS) date format.
     */
    private static final DateTimeFormatter TS_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd")
        .withZone(ZoneOffset.UTC);

    /**
     * Takes an HL7 DTM-formatted value given as a {@link Hl7Dtm}, sets the resolution to the fraction of seconds by
     * filling missing values to the start of the year, month, day, hour and minute if needed (i.e. sets it to the
     * earliest instant covered by the partial date). The DTM value must be given in UTC.
     * <p>
     * By example, if the value "201903" is given, the day is fixed to the start of the month (the first of march) and
     * the time is set to 00:00:00, which results in: "20190301000000".
     * <p>
     * If the HL7 DTM is already precise to the fraction of seconds, it will be returned as-is.
     *
     * @param hl7Dtm The HL7 DTM-formatted dateTime to process.
     * @return the full precision dateTime.
     */
    @NonNull
    @SuppressWarnings("fallthrough")
    public static Hl7Dtm completeToEarliestInstant(@NonNull final Hl7Dtm hl7Dtm) {
        if (hl7Dtm.getPrecision() == Hl7Dtm.Precision.FRAC_SECOND) {
            return hl7Dtm;
        }
        final var calendar = GregorianCalendar.from(ZonedDateTime.from(hl7Dtm.getDateTime()));
        // Voluntarily not using breaks in the switch. We have to recreate the
        switch (hl7Dtm.getPrecision()) {
            case YEAR:
                calendar.set(MONTH, calendar.getActualMinimum(MONTH));
            case MONTH:
                calendar.set(DAY_OF_MONTH, calendar.getActualMinimum(DAY_OF_MONTH));
            case DAY:
                calendar.set(HOUR_OF_DAY, calendar.getActualMinimum(HOUR_OF_DAY));
            case HOUR:
                calendar.set(MINUTE, calendar.getActualMinimum(MINUTE));
            case MINUTE:
                calendar.set(SECOND, calendar.getActualMinimum(SECOND));
            case SECOND:
                calendar.set(MILLISECOND, calendar.getActualMinimum(MILLISECOND));
            default:
                break;
        }

        return new Hl7Dtm(OffsetDateTime.ofInstant(calendar.toInstant(), hl7Dtm.getDateTime().getOffset()),
                Hl7Dtm.Precision.FRAC_SECOND);
    }

    /**
     * Takes an HL7 DTM-formatted value given as a {@link Hl7Dtm}, sets the resolution to the fraction of seconds by
     * filling missing values to the end of the year, month, day, hour and minute if needed (i.e. sets it to the
     * latest instant covered by the partial date). The DTM value must be given in UTC.
     * <p>
     * By example, if the value "201903" is given, the day is fixed to the end of the month (the last of march) and the
     * time is set to the end of the day (usually 23:59:59), which results in: "20190331235959".
     * <p>
     * If the HL7 DTM is already precise to the fraction of seconds, it will be returned as-is.
     *
     * TODO: Can we get more precision while setting the nanoseconds? As of now, the max resolution is to the
     * millisecond, so we might get 23:59:59.999_000_000 instead of 23:59:59.999_999_999.
     *
     * @param hl7Dtm The HL7 DTM-formatted dateTime to process.
     * @return the full precision dateTime.
     */
    @NonNull
    @SuppressWarnings("fallthrough")
    public static Hl7Dtm completeToLatestInstant(@NonNull final Hl7Dtm hl7Dtm) {
        if (hl7Dtm.getPrecision() == Hl7Dtm.Precision.FRAC_SECOND) {
            return hl7Dtm;
        }

        final var calendar = GregorianCalendar.from(ZonedDateTime.from(hl7Dtm.getDateTime()));
        // Voluntarily not using breaks in the switch
        switch (hl7Dtm.getPrecision()) {
            case YEAR:
                calendar.set(MONTH, calendar.getActualMaximum(MONTH));
            case MONTH:
                calendar.set(DAY_OF_MONTH, calendar.getActualMaximum(DAY_OF_MONTH));
            case DAY:
                calendar.set(HOUR_OF_DAY, calendar.getActualMaximum(HOUR_OF_DAY));
            case HOUR:
                calendar.set(MINUTE, calendar.getActualMaximum(MINUTE));
            case MINUTE:
                calendar.set(SECOND, calendar.getActualMaximum(SECOND));
            case SECOND:
                calendar.set(MILLISECOND, calendar.getActualMaximum(MILLISECOND));
            default:
                break;
        }

        return new Hl7Dtm(OffsetDateTime.ofInstant(calendar.toInstant(), hl7Dtm.getDateTime().getOffset()),
                Hl7Dtm.Precision.FRAC_SECOND);
    }

    /**
     * Converts a {@link Hl7Dtm} to an {@link Instant}.
     *
     * @param timestamp The timestamp to convert.
     * @return the equivalent instant.
     */
    @NonNull
    public static Instant toInstant(@NonNull final Hl7Dtm timestamp) {
        return timestamp.getDateTime().toInstant();
    }

    /**
     * Converts an {@link Instant} to a local {@link ZonedDateTime}.
     *
     * @param instant The instant to convert.
     * @return the equivalent zoned date time.
     */
    @NonNull
    public static ZonedDateTime getZonedDateTime(@NonNull final Instant instant) {
        return ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Zurich"));
    }

    /**
     * Formats an {@link Instant} to an HL7 DTM. UTC is assumed.
     *
     * @param instant The instant to convert.
     * @return the resulting HL7 DTM.
     */
    @NonNull
    public static String toHl7Dtm(@NonNull final Instant instant) {
        return HL7_DATETIME_FORMATTER.format(instant);
    }

    /**
     * Converts an {@link Instant} to a {@link TS} (TS.CH.TZ, Time Stamp) with a precision to the second. UTC is
     * assumed.
     *
     * @param temporal The temporal object to convert.
     * @return the resulting timestamp.
     */
    @NonNull
    public static TS toDatetimeTs(@NonNull final TemporalAccessor temporal) {
        final TS ts = new TS();
        ts.setValue(TS_DATETIME_FORMATTER.format(temporal));
        return ts;
    }

    /**
     * Converts an {@link Instant} to a {@link TS} (TS.CH.TZ, Time Stamp) with a precision to the day. UTC is assumed.
     *
     * @param temporal The temporal object to convert.
     * @return the resulting timestamp.
     */
    @NonNull
    public static TS toDateTs(@NonNull final TemporalAccessor temporal) {
        final TS ts = new TS();
        ts.setValue(TS_DATE_FORMATTER.format(temporal));
        return ts;
    }

    /**
     * Converts a {@link TS} (TS.CH.TZ, Time Stamp) to a local date. Only two formats are allowed in the TS.CH.TZ.
     *
     * @param ts The timestamp to convert.
     * @return the equivalent local date or {@code null} if a null flavor was used in the {@code ts}.
     */
    @Nullable
    public static LocalDate toLocalDate(@NonNull final TS ts) {
        if (ts.getValue() == null || ts.getValue().isBlank()) {
            return null;
        }
        try {
            return LocalDate.parse(ts.getValue(), TS_DATETIME_FORMATTER);
        } catch (final DateTimeParseException ignored) {
        }
        try {
            return LocalDate.parse(ts.getValue(), TS_DATE_FORMATTER);
        } catch (final DateTimeParseException ignored) {
        }
        return null;
    }
}
