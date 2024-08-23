package org.projecthusky.common.utils.time;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.hl7cdar2.TS;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	/** The SLF4J logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DateTimes.class);

    /**
     * The HL7 V2.5 Date Time (DTM) format.
     */
    private static final DateTimeFormatter HL7_DATETIME_FORMATTER =
        DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault());

    /**
     * The TS.CH.TZ (TS) date time format.
     */
    private static final DateTimeFormatter TS_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ")
        .withZone(ZoneId.systemDefault());
    private static final String TS_DATETIME_FORMAT = "yyyyMMddHHmmssZ";

    /**
     * The TS.CH.TZ (TS) date format.
     */
    private static final DateTimeFormatter TS_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd")
        .withZone(ZoneId.systemDefault());
    private static final String TS_DATE_FORMAT = "yyyyMMdd";

    /**
     * This class is not instantiable.
     */
    private DateTimes() {}

    /**
     * Takes an HL7 DTM-formatted value given as a {@link Hl7Dtm}, sets the resolution to the fraction of seconds by
     * filling missing values to the start of the year, month, day, hour and minute if needed (i.e. sets it to the
     * earliest instant covered by the partial date). The DTM value must be given in UTC.
     * <p>
     * For example, if the value "201903" is given, the day is fixed to the start of the month (the first of march) and
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
     * Takes an HL7 DTM-formatted value given as a {@link Hl7Dtm}, sets the resolution to the fraction of seconds by
     * filling missing values to the start of the year, month, day, hour and minute if needed (i.e. sets it to the
     * earliest instant covered by the partial date). The DTM value must be given in UTC.
     * <p>
     * For example, if the value "201903" is given, the day is fixed to the start of the month (the first of march) and
     * the time is set to 00:00:00, which results in: "20190301000000".
     * <p>
     * If the HL7 DTM is already precise to the fraction of seconds, it will be returned as-is.
     *
     * @param timestamp The HL7 DTM-formatted dateTime to process.
     * @return the full precision dateTime.
     */
    @NonNull
    @SuppressWarnings("fallthrough")
    public static Hl7Dtm completeToEarliestInstant(@NonNull final Timestamp timestamp) {
        final var calendar = GregorianCalendar.from(ZonedDateTime.from(timestamp.getDateTime()));
        // Voluntarily not using breaks in the switch. We have to recreate the
        switch (timestamp.getPrecision()) {
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

        return new Hl7Dtm(OffsetDateTime.ofInstant(calendar.toInstant(), timestamp.getDateTime().getOffset()),
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
     * @param timestamp The HL7 DTM-formatted dateTime to process.
     * @return the full precision dateTime.
     */
    @NonNull
    @SuppressWarnings("fallthrough")
    public static Hl7Dtm completeToLatestInstant(@NonNull final Timestamp timestamp) {
        final var calendar = GregorianCalendar.from(ZonedDateTime.from(timestamp.getDateTime()));
        // Voluntarily not using breaks in the switch
        switch (timestamp.getPrecision()) {
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

        return new Hl7Dtm(OffsetDateTime.ofInstant(calendar.toInstant(), timestamp.getDateTime().getOffset()),
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
     * @deprecated use {@link DateTimes#getZonedDateTime(Instant, ZoneId)} instead, to control the time zone.
     */
    @NonNull
    @Deprecated(since = "2024-08-23", forRemoval = true)
    public static ZonedDateTime getZonedDateTime(@NonNull final Instant instant) {
        return ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Zurich"));
    }

    /**
     * Converts an {@link Instant} to a {@link ZonedDateTime}.
     *
     * @param instant The instant to convert.
     * @param zone    The time zone to use.
     * @return the equivalent zoned date time.
     */
    @NonNull
    public static ZonedDateTime getZonedDateTime(@NonNull final Instant instant, @NonNull final ZoneId zone) {
        return ZonedDateTime.ofInstant(instant, zone);
    }

    /**
     * Formats an {@link Instant} to an HL7 DTM. Local time zone is assumed.
     *
     * @param instant The instant to convert.
     * @return the resulting HL7 DTM.
     * @deprecated use {@link DateTimes#toHl7Dtm(Instant, ZoneId)} instead, to control the time zone.
     */
    @NonNull
    @Deprecated(since = "2024-08-23", forRemoval = true)
    public static String toHl7Dtm(@NonNull final Instant instant) {
        return HL7_DATETIME_FORMATTER.format(instant);
    }

    /**
     * Formats an {@link Instant} to an HL7 DTM.
     *
     * @param instant The instant to convert.
     * @param zone    The time zone to use.
     * @return the resulting HL7 DTM.
     */
    @NonNull
    public static String toHl7Dtm(@NonNull final Instant instant, @NonNull final ZoneId zone) {
        return DateTimeFormatter.ofPattern(TS_DATETIME_FORMAT).withZone(zone).format(instant);
    }

    /**
     * Converts an {@link Instant} to a {@link TS} (TS.CH.TZ, Time Stamp) with a precision to the second. UTC is
     * assumed.
     *
     * @param temporal The temporal object to convert.
     * @return the resulting timestamp.
     * @deprecated use {@link DateTimes#toDatetimeTs(TemporalAccessor, ZoneId)} instead, to control the time zone.
     */
    @NonNull
    @Deprecated(since = "2024-08-23", forRemoval = true)
    public static TS toDatetimeTs(@NonNull final TemporalAccessor temporal) {
        final TS ts = new TS();
        ts.setValue(TS_DATETIME_FORMATTER.format(temporal));
        return ts;
    }

    /**
     * Converts an {@link Instant} to a {@link TS} (TS.CH.TZ, Time Stamp) with a precision to the second.
     *
     * @param temporal The temporal object to convert.
     * @param zone     The time zone to use.
     * @return the resulting timestamp.
     */
    @NonNull
    public static TS toDatetimeTs(@NonNull final TemporalAccessor temporal, @NonNull final ZoneId zone) {
        final TS ts = new TS();
        ts.setValue(DateTimeFormatter.ofPattern(TS_DATETIME_FORMAT).withZone(zone).format(temporal));
        return ts;
    }

    /**
     * Converts an {@link Instant} to a {@link TS} (TS.CH.TZ, Time Stamp) with a precision to the day. UTC is assumed.
     *
     * @param temporal The temporal object to convert.
     * @return the resulting timestamp.
     * @deprecated use {@link DateTimes#toDateTs(TemporalAccessor, ZoneId)} instead, to control the time zone.
     */
    @NonNull
    @Deprecated(since = "2024-08-23", forRemoval = true)
    public static TS toDateTs(@NonNull final TemporalAccessor temporal) {
        final TS ts = new TS();
        ts.setValue(TS_DATE_FORMATTER.format(temporal));
        return ts;
    }

	/**
	 * Converts an {@link Instant} to a {@link TS} (TS.CH.TZ, Time Stamp) with a
	 * precision to the day with passed time zone.
	 *
	 * @param temporal The temporal object to convert.
	 * @param zone     time zone
	 * @return the resulting timestamp.
	 */
	@NonNull
	public static TS toDateTs(@NonNull final TemporalAccessor temporal, ZoneId zone) {
		final TS ts = new TS();
		ts.setValue(DateTimeFormatter.ofPattern(TS_DATE_FORMAT).withZone(zone).format(temporal));
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
			LOGGER.debug("Date {} could not be parsed", ts);
        }
        try {
            return LocalDate.parse(ts.getValue(), TS_DATE_FORMATTER);
        } catch (final DateTimeParseException ignored) {
			LOGGER.debug("Date {} could not be parsed", ts);
        }
        return null;
    }
}
